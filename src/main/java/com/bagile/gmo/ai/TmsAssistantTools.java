package com.bagile.gmo.ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Read-only tools the LLM can call to answer questions about the TMS data.
 * <p>
 * Design choices:
 * <ul>
 *   <li>The model never writes SQL. It can only call these methods; every query is fixed and parameterized,
 *       so there is no SQL-injection surface and no way to modify data.</li>
 *   <li>Each tool enforces the same habilitations as the matching REST resource ({@link AccessGuard}).</li>
 *   <li>Text filters are accent- and case-insensitive ("valide" matches "VALIDÉ", "casa" matches "CASABLANCA").</li>
 *   <li>Results are capped and always report the total, so the model can say "showing 20 of 147".</li>
 * </ul>
 */
@Component
@Transactional(readOnly = true)
public class TmsAssistantTools {

    private static final Logger log = LoggerFactory.getLogger(TmsAssistantTools.class);

    static final int DEFAULT_LIMIT = 20;
    static final int MAX_LIMIT = 50;

    /** Statuses after which a trip or order is considered finished. */
    static final List<String> CLOSED_STATUSES = List.of("ferme", "annule", "facture", "regle");

    private static final Pattern DIACRITICS = Pattern.compile("\\p{M}+");
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final JdbcClient jdbc;
    private final String s;

    public TmsAssistantTools(JdbcClient jdbc,
                             @Value("${spring.jpa.properties.hibernate.default_schema:schema_tmsvoieexpress}") String schema) {
        this.jdbc = jdbc;
        if (!schema.matches("[A-Za-z_][A-Za-z0-9_]*")) {
            throw new IllegalArgumentException("Invalid schema name: " + schema);
        }
        this.s = schema;
    }

    // ------------------------------------------------------------------------------------------------
    // Transport orders
    // ------------------------------------------------------------------------------------------------

    @Tool(description = """
            Search customer transport orders (ordres de transport, OT). All filters are optional and combined with AND.
            Returns code, date, client, route, status, km and prices (HT/TTC in MAD), newest first.""")
    public QueryResult searchTransportOrders(
            @ToolParam(required = false, description = "Status text, e.g. 'VALIDÉ', 'En Cours', 'ANNULÉ'") String status,
            @ToolParam(required = false, description = "Part of the client (account) name") String client,
            @ToolParam(required = false, description = "Departure city, e.g. 'Casablanca'") String fromCity,
            @ToolParam(required = false, description = "Destination city, e.g. 'Nador'") String toCity,
            @ToolParam(required = false, description = "Orders dated on or after this day, yyyy-MM-dd") String dateFrom,
            @ToolParam(required = false, description = "Orders dated on or before this day, yyyy-MM-dd") String dateTo,
            @ToolParam(required = false, description = "Max rows to return (default 20, max 50)") Integer limit) {
        AccessGuard.requireAny("transport orders", AccessGuard.ORDERS);
        Where w = new Where()
                .like(norm("st.tms_turnstatuscode"), "status", status)
                .like(norm("a.cmd_accountname"), "client", client)
                .like(norm("vs.prm_villecode"), "fromCity", fromCity)
                .like(norm("vd.prm_villecode"), "toCity", toCity)
                .dateFrom("o.tms_ordertransportdate", dateFrom)
                .dateTo("o.tms_ordertransportdate", dateTo);
        String sql = """
                SELECT o.tms_ordertransportcode AS code, o.tms_ordertransportdate AS date, a.cmd_accountname AS client,
                       vs.prm_villecode AS from_city, vd.prm_villecode AS to_city, st.tms_turnstatuscode AS status,
                       o.tms_ordertransportnumberkm AS km,
                       COALESCE(o.tms_ordertransporttotalpriceht, o.tms_ordertransportpriceht) AS total_ht,
                       COALESCE(o.tms_ordertransporttotalpricettc, o.tms_ordertransportpricettc) AS total_ttc,
                       count(*) OVER () AS total_count
                """ + ordersFrom() + w.sql() + " ORDER BY o.tms_ordertransportdate DESC NULLS LAST LIMIT :limit";
        return run(sql, w, limit);
    }

    @Tool(description = """
            Full details of one transport order by its code (e.g. OT5797): client, route, status, prices,
            and every trip (plan de transport) executing it with driver, vehicle, status and timestamps.""")
    public Map<String, Object> getTransportOrder(
            @ToolParam(description = "Order code, e.g. OT5797 (the 'OT' prefix is optional)") String code) {
        AccessGuard.requireAny("transport orders", AccessGuard.ORDERS);
        String normalized = code == null ? "" : code.trim().toUpperCase(Locale.ROOT);
        if (!normalized.startsWith("OT")) {
            normalized = "OT" + normalized;
        }
        List<Map<String, Object>> order = jdbc.sql("""
                        SELECT o.tms_ordertransportid AS id, o.tms_ordertransportcode AS code, o.tms_ordertransportdate AS date,
                               a.cmd_accountname AS client, t.tms_trajetcode AS route, st.tms_turnstatuscode AS status,
                               o.tms_ordertransportdescription AS description, o.tms_ordertransportnumberkm AS km,
                               o.tms_ordertransportpriceht AS price_ht, o.tms_ordertransportpricettc AS price_ttc,
                               o.tms_ordertransporttotalserviceht AS services_ht,
                               o.tms_ordertransporttotalpriceht AS total_ht, o.tms_ordertransporttotalpricettc AS total_ttc,
                               o.tms_ordertransportmarginrate AS margin_rate
                        """ + ordersFrom() + " WHERE upper(o.tms_ordertransportcode) = :code")
                .param("code", normalized)
                .query().listOfRows();
        if (order.isEmpty()) {
            return Map.of("found", false, "message", "No transport order with code " + normalized);
        }
        Map<String, Object> result = clean(order.getFirst());
        Object orderId = result.remove("id");
        List<Map<String, Object>> trips = jdbc.sql("""
                        SELECT p.tms_transportplanid AS trip_id, st.tms_turnstatuscode AS status,
                        """ + DRIVER_NAME + " AS driver, " + VEHICLE_NAME + """
                         AS vehicle,
                               p.tms_transportplandatedepart AS departed_at, p.tms_transportplandatearriver AS arrived_at_loading,
                               p.tms_transportplandatefinchargement AS loading_done_at,
                               p.tms_transportplandatearriverdestination AS arrived_at_destination,
                               p.tms_transportplandatefindechargement AS unloading_done_at, p.tms_transportplanclosedate AS closed_at,
                               p.tms_transportplantotalpriceht AS sale_ht, p.tms_transportplanpurchasepriceht AS purchase_ht,
                               p.tms_transportplanremark AS remark
                        """ + tripsFrom() + " WHERE p.tms_ordertransportid = :id ORDER BY p.tms_transportplanid")
                .param("id", orderId)
                .query().listOfRows();
        result.put("found", true);
        result.put("trips", trips.stream().map(TmsAssistantTools::clean).toList());
        return result;
    }

    // ------------------------------------------------------------------------------------------------
    // Trips (plans de transport)
    // ------------------------------------------------------------------------------------------------

    @Tool(description = """
            Search trips (plans de transport / voyages). All filters optional and combined with AND.
            Returns trip id, order code, date, client, route, driver, vehicle registration, status and sale price HT.""")
    public QueryResult searchTrips(
            @ToolParam(required = false, description = "Part of the driver's name") String driver,
            @ToolParam(required = false, description = "Part of the vehicle registration (matricule), e.g. '95225'") String vehicle,
            @ToolParam(required = false, description = "Status text, e.g. 'CRÉE', 'FERMÉ', 'Fin Dechargement'") String status,
            @ToolParam(required = false, description = "Departure city") String fromCity,
            @ToolParam(required = false, description = "Destination city") String toCity,
            @ToolParam(required = false, description = "Trips departing on or after this day, yyyy-MM-dd") String dateFrom,
            @ToolParam(required = false, description = "Trips departing on or before this day, yyyy-MM-dd") String dateTo,
            @ToolParam(required = false, description = "true = only trips not yet closed/cancelled/invoiced") Boolean openOnly,
            @ToolParam(required = false, description = "Max rows to return (default 20, max 50)") Integer limit) {
        AccessGuard.requireAny("trips", AccessGuard.TRIPS);
        Where w = new Where()
                .like(norm(DRIVER_NAME), "driver", driver)
                .like(norm(VEHICLE_NAME), "vehicle", vehicle)
                .like(norm("st.tms_turnstatuscode"), "status", status)
                .like(norm("vs.prm_villecode"), "fromCity", fromCity)
                .like(norm("vd.prm_villecode"), "toCity", toCity)
                .dateFrom(TRIP_DATE, dateFrom)
                .dateTo(TRIP_DATE, dateTo);
        if (Boolean.TRUE.equals(openOnly)) {
            w.raw(notClosed("st.tms_turnstatuscode"));
        }
        String sql = """
                SELECT p.tms_transportplanid AS trip_id, o.tms_ordertransportcode AS order_code,
                """ + TRIP_DATE + " AS date, a.cmd_accountname AS client, vs.prm_villecode AS from_city, vd.prm_villecode AS to_city, "
                + DRIVER_NAME + " AS driver, " + VEHICLE_NAME + """
                 AS vehicle, st.tms_turnstatuscode AS status,
                       p.tms_transportplantotalpriceht AS sale_ht, count(*) OVER () AS total_count
                """ + tripsFrom() + w.sql() + " ORDER BY " + TRIP_DATE + " DESC NULLS LAST LIMIT :limit";
        return run(sql, w, limit);
    }

    @Tool(description = """
            Find trips that need attention: (1) started but not arrived at destination after more than `minHours` hours,
            (2) created/validated with a planned date older than `minHours` hours but never started.
            Use for questions like 'which trips are late?', 'chkoun m3attal?', 'voyages en retard'.""")
    public QueryResult findDelayedTrips(
            @ToolParam(required = false, description = "Delay threshold in hours (default 24)") Integer minHours,
            @ToolParam(required = false, description = "Only look at trips planned in the last N days (default 30) so very old unclosed records are ignored") Integer lookbackDays,
            @ToolParam(required = false, description = "Max rows to return (default 20, max 50)") Integer limit) {
        AccessGuard.requireAny("trips", AccessGuard.TRIPS);
        int hours = minHours == null || minHours <= 0 ? 24 : minHours;
        Where w = new Where().raw(notClosed("st.tms_turnstatuscode"));
        w.params.put("hours", hours);
        w.params.put("lookback", lookbackDays == null || lookbackDays <= 0 ? 30 : lookbackDays);
        String inner = """
                SELECT p.tms_transportplanid AS trip_id, o.tms_ordertransportcode AS order_code,
                       vs.prm_villecode AS from_city, vd.prm_villecode AS to_city,
                """ + DRIVER_NAME + " AS driver, " + VEHICLE_NAME + """
                 AS vehicle, st.tms_turnstatuscode AS status,
                       p.tms_transportplandatedepart AS departed_at,
                       CASE WHEN p.tms_transportplandatedepart IS NOT NULL THEN 'in transit too long'
                            ELSE 'not started' END AS problem,
                       round(EXTRACT(EPOCH FROM (now() - COALESCE(p.tms_transportplandatedepart, p.tms_transportplandate,
                             o.tms_ordertransportdate))) / 3600) AS hours_since
                """ + tripsFrom() + w.sql() + """
                  AND p.tms_transportplandatearriverdestination IS NULL
                  AND COALESCE(p.tms_transportplandatedepart, p.tms_transportplandate, o.tms_ordertransportdate)
                      < now() - make_interval(hours => :hours)
                  AND COALESCE(p.tms_transportplandatedepart, p.tms_transportplandate, o.tms_ordertransportdate)
                      >= now() - make_interval(days => :lookback)
                """;
        String counted = "SELECT x.*, count(*) OVER () AS total_count FROM (" + inner + ") x "
                + "ORDER BY x.hours_since DESC LIMIT :limit";
        return run(counted, w, limit);
    }

    @Tool(description = """
            Last known GPS position of a vehicle, a driver or a trip (from the driver mobile app tracking),
            with the nearest known city and a Google Maps link. Provide at least one filter.""")
    public Map<String, Object> getLastKnownPosition(
            @ToolParam(required = false, description = "Part of the vehicle registration (matricule)") String vehicle,
            @ToolParam(required = false, description = "Part of the driver's name") String driver,
            @ToolParam(required = false, description = "Trip id (plan de transport id)") Long tripId) {
        AccessGuard.requireAny("trips", AccessGuard.TRIPS);
        if (isBlank(vehicle) && isBlank(driver) && tripId == null) {
            return Map.of("found", false, "message", "Give a vehicle, a driver or a trip id.");
        }
        Where w = new Where()
                .like(norm("COALESCE(v.gmo_vehiculeregistrationnumber, '')"), "vehicle", vehicle)
                .like(norm("COALESCE(d.gmo_drivername, '')"), "driver", driver);
        if (tripId != null) {
            w.raw("l.tms_transportplanlocationtransportplanid = :tripId");
            w.params.put("tripId", tripId);
        }
        String sql = """
                SELECT l.tms_transportplanlocationdate AS recorded_at, l.tms_transportplanlocationlatitude AS latitude,
                       l.tms_transportplanlocationlongtitude AS longitude, l.tms_transportplanlocationtype AS event,
                       l.tms_transportplanlocationtransportplanid AS trip_id, d.gmo_drivername AS driver,
                       v.gmo_vehiculeregistrationnumber AS vehicle,
                       (SELECT c.prm_villecode FROM %1$s.prm_ville c
                         WHERE c.prm_villelatitude IS NOT NULL AND c.prm_villelongtitude IS NOT NULL
                         ORDER BY power(c.prm_villelatitude - l.tms_transportplanlocationlatitude, 2)
                                + power((c.prm_villelongtitude - l.tms_transportplanlocationlongtitude)
                                        * cos(radians(l.tms_transportplanlocationlatitude)), 2)
                         LIMIT 1) AS nearest_city
                FROM %1$s.tms_transportplanlocation l
                LEFT JOIN %1$s.gmo_driver d ON d.gmo_driverid = COALESCE(l.tms_transportplanlocationdriverid, l.tms_transportplanlocationdriver)
                LEFT JOIN %1$s.gmo_vehicule v ON v.gmo_patrimonyid = COALESCE(l.tms_transportplanlocationvehicleid, l.tms_transportplanlocationvehicle)
                """.formatted(s) + w.sql() + """
                 AND l.tms_transportplanlocationlatitude IS NOT NULL
                 ORDER BY l.tms_transportplanlocationdate DESC NULLS LAST LIMIT 1""";
        List<Map<String, Object>> rows = jdbc.sql(sql).params(w.params).query().listOfRows();
        if (rows.isEmpty()) {
            return Map.of("found", false, "message", "No GPS position recorded for that vehicle/driver/trip.");
        }
        Map<String, Object> row = clean(rows.getFirst());
        row.put("found", true);
        row.put("map_link", "https://www.google.com/maps?q=" + row.get("latitude") + "," + row.get("longitude"));
        return row;
    }

    // ------------------------------------------------------------------------------------------------
    // Statistics
    // ------------------------------------------------------------------------------------------------

    @Tool(description = "Count transport orders or trips per status over an optional date range.")
    public QueryResult countByStatus(
            @ToolParam(description = "ORDERS or TRIPS") String target,
            @ToolParam(required = false, description = "From day, yyyy-MM-dd") String dateFrom,
            @ToolParam(required = false, description = "To day, yyyy-MM-dd") String dateTo) {
        boolean trips = target != null && target.trim().toUpperCase(Locale.ROOT).startsWith("TRIP");
        if (trips) {
            AccessGuard.requireAny("trips", AccessGuard.TRIPS);
        } else {
            AccessGuard.requireAny("transport orders", AccessGuard.ORDERS);
        }
        String dateColumn = trips ? TRIP_DATE : "o.tms_ordertransportdate";
        Where w = new Where().dateFrom(dateColumn, dateFrom).dateTo(dateColumn, dateTo);
        String sql = "SELECT COALESCE(st.tms_turnstatuscode, '(no status)') AS status, count(*) AS count, "
                + "count(*) OVER () AS total_count " + (trips ? tripsFrom() : ordersFrom()) + w.sql()
                + " GROUP BY 1 ORDER BY 2 DESC LIMIT :limit";
        return run(sql, w, MAX_LIMIT);
    }

    @Tool(description = """
            Revenue of transport orders (cancelled orders excluded) over a date range, optionally grouped by
            CLIENT, ROUTE or MONTH (use NONE for a single total). Returns order count, km, total HT and TTC in MAD.""")
    public QueryResult revenueSummary(
            @ToolParam(required = false, description = "CLIENT, ROUTE, MONTH or NONE (default NONE)") String groupBy,
            @ToolParam(required = false, description = "From day, yyyy-MM-dd") String dateFrom,
            @ToolParam(required = false, description = "To day, yyyy-MM-dd") String dateTo,
            @ToolParam(required = false, description = "Max groups to return, best first (default 20)") Integer limit) {
        AccessGuard.requireAny("transport orders", AccessGuard.ORDERS);
        String key = switch (groupBy == null ? "NONE" : groupBy.trim().toUpperCase(Locale.ROOT)) {
            case "CLIENT" -> "COALESCE(a.cmd_accountname, '(no client)')";
            case "ROUTE" -> "COALESCE(t.tms_trajetcode, '(no route)')";
            case "MONTH" -> "to_char(o.tms_ordertransportdate, 'YYYY-MM')";
            default -> "'all'";
        };
        Where w = new Where()
                .dateFrom("o.tms_ordertransportdate", dateFrom)
                .dateTo("o.tms_ordertransportdate", dateTo)
                .raw("(st.tms_turnstatuscode IS NULL OR " + norm("st.tms_turnstatuscode") + " NOT LIKE 'annul%')");
        String order = key.startsWith("to_char") ? "1 DESC" : "total_ht DESC NULLS LAST";
        String sql = "SELECT " + key + " AS grp, count(*) AS orders, sum(o.tms_ordertransportnumberkm) AS km, "
                + "sum(COALESCE(o.tms_ordertransporttotalpriceht, o.tms_ordertransportpriceht)) AS total_ht, "
                + "sum(COALESCE(o.tms_ordertransporttotalpricettc, o.tms_ordertransportpricettc)) AS total_ttc, "
                + "count(*) OVER () AS total_count " + ordersFrom() + w.sql()
                + " GROUP BY 1 ORDER BY " + order + " LIMIT :limit";
        return run(sql, w, limit);
    }

    @Tool(description = """
            Activity ranking of drivers or vehicles over a date range: number of trips, closed trips, km driven
            and sale revenue HT. Optionally filter on one driver/vehicle name. Best performers first.""")
    public QueryResult activityRanking(
            @ToolParam(description = "DRIVER or VEHICLE") String by,
            @ToolParam(required = false, description = "Part of the driver name or vehicle registration") String name,
            @ToolParam(required = false, description = "From day, yyyy-MM-dd") String dateFrom,
            @ToolParam(required = false, description = "To day, yyyy-MM-dd") String dateTo,
            @ToolParam(required = false, description = "Max rows (default 20)") Integer limit) {
        AccessGuard.requireAny("trips", AccessGuard.TRIPS);
        boolean vehicles = by != null && by.trim().toUpperCase(Locale.ROOT).startsWith("VEHIC");
        String key = vehicles ? VEHICLE_NAME : DRIVER_NAME;
        Where w = new Where()
                .like(norm(key), "name", name)
                .dateFrom(TRIP_DATE, dateFrom)
                .dateTo(TRIP_DATE, dateTo)
                .raw("(st.tms_turnstatuscode IS NULL OR " + norm("st.tms_turnstatuscode") + " NOT LIKE 'annul%')")
                .raw(key + " IS NOT NULL");
        String sql = "SELECT " + key + " AS " + (vehicles ? "vehicle" : "driver") + ", count(*) AS trips, "
                + "count(*) FILTER (WHERE " + norm("st.tms_turnstatuscode") + " IN ('ferme', 'facture', 'regle')) AS closed_trips, "
                + "sum(o.tms_ordertransportnumberkm) AS km, sum(p.tms_transportplantotalpriceht) AS revenue_ht, "
                + "count(*) OVER () AS total_count " + tripsFrom() + w.sql()
                + " GROUP BY 1 ORDER BY trips DESC, revenue_ht DESC NULLS LAST LIMIT :limit";
        return run(sql, w, limit);
    }

    // ------------------------------------------------------------------------------------------------
    // Fleet
    // ------------------------------------------------------------------------------------------------

    @Tool(description = """
            List fleet vehicles with registration, category, availability, current mileage, last known city,
            and the technical-inspection (visite technique) and vignette dates with days remaining (negative = overdue).""")
    public QueryResult listVehicles(
            @ToolParam(required = false, description = "Part of the registration (matricule) or internal code") String search,
            @ToolParam(required = false, description = "true = only vehicles marked available") Boolean availableOnly,
            @ToolParam(required = false, description = "Only vehicles whose inspection or vignette date falls within this many days (includes overdue)") Integer dueWithinDays,
            @ToolParam(required = false, description = "Max rows (default 20, max 50)") Integer limit) {
        AccessGuard.requireAny("vehicles", "USER", "ADMIN");
        Where w = new Where()
                .like(norm("COALESCE(v.gmo_vehiculeregistrationnumber, '') || ' ' || COALESCE(v.gmo_patrimonycode, '')"), "search", search);
        if (Boolean.TRUE.equals(availableOnly)) {
            w.raw("COALESCE(v.gmo_vehiculedisponible, 0) <> 0");
        }
        if (dueWithinDays != null) {
            w.raw("(v.gmo_vehiculetechnicalvisit < current_date + make_interval(days => :due) "
                    + "OR v.gmo_vehiculevignette < current_date + make_interval(days => :due))");
            w.params.put("due", Math.max(dueWithinDays, 0));
        }
        String sql = """
                SELECT v.gmo_vehiculeregistrationnumber AS registration, v.gmo_patrimonycode AS code,
                       c.gmo_vehiclecategorycode AS category, v.gmo_vehiculedisponible AS available,
                       v.gmo_gmovehiclecurrentmileage AS mileage_km, v.gmo_vehiculelastpointcity AS last_city,
                       v.gmo_vehiculelastpointdate AS last_seen,
                       v.gmo_vehiculetechnicalvisit::date AS technical_visit, (v.gmo_vehiculetechnicalvisit::date - current_date) AS technical_visit_days_left,
                       v.gmo_vehiculevignette::date AS vignette, (v.gmo_vehiculevignette::date - current_date) AS vignette_days_left,
                       count(*) OVER () AS total_count
                FROM %1$s.gmo_vehicule v
                LEFT JOIN %1$s.gmo_vehiclecategory c ON c.gmo_vehiclecategoryid = v.gmo_vehiculecategorieid
                """.formatted(s) + w.sql()
                + " ORDER BY LEAST(v.gmo_vehiculetechnicalvisit, v.gmo_vehiculevignette) NULLS LAST, v.gmo_vehiculeregistrationnumber LIMIT :limit";
        return run(sql, w, limit);
    }

    // ------------------------------------------------------------------------------------------------
    // SQL building blocks
    // ------------------------------------------------------------------------------------------------

    static final String DRIVER_NAME =
            "COALESCE(NULLIF(trim(COALESCE(d.gmo_drivername, '') || ' ' || COALESCE(d.gmo_driversurname, '')), ''), p.tms_transportplandriverexterne)";
    static final String VEHICLE_NAME =
            "COALESCE(v.gmo_vehiculeregistrationnumber, p.tms_transportplanvehicleexterne)";
    static final String TRIP_DATE =
            "COALESCE(p.tms_transportplandatedepart, p.tms_transportplandate, o.tms_ordertransportdate)";

    private String ordersFrom() {
        return """
                FROM %1$s.tms_ordertransport o
                LEFT JOIN %1$s.cmd_account a ON a.cmd_accountid = COALESCE(o.cmd_accountid, o.cmd_ordertransportaccountid)
                LEFT JOIN %1$s.tms_trajet t ON t.tms_trajetid = o.tms_ordertransporttrajetid
                LEFT JOIN %1$s.prm_ville vs ON vs.prm_villeid = t.tms_villesournceid
                LEFT JOIN %1$s.prm_ville vd ON vd.prm_villeid = t.tms_villedistinationid
                LEFT JOIN %1$s.tms_turnstatus st ON st.tms_turnstatusid = o.tms_turnstatusid
                """.formatted(s);
    }

    private String tripsFrom() {
        return """
                FROM %1$s.tms_transportplan p
                LEFT JOIN %1$s.tms_ordertransport o ON o.tms_ordertransportid = p.tms_ordertransportid
                LEFT JOIN %1$s.cmd_account a ON a.cmd_accountid = COALESCE(p.tms_cmdaccount, o.cmd_accountid, o.cmd_ordertransportaccountid)
                LEFT JOIN %1$s.tms_trajet t ON t.tms_trajetid = COALESCE(p.tms_transportplantrajetid, o.tms_ordertransporttrajetid)
                LEFT JOIN %1$s.prm_ville vs ON vs.prm_villeid = t.tms_villesournceid
                LEFT JOIN %1$s.prm_ville vd ON vd.prm_villeid = t.tms_villedistinationid
                LEFT JOIN %1$s.gmo_driver d ON d.gmo_driverid = p.tms_gmodriverid
                LEFT JOIN %1$s.gmo_vehicule v ON v.gmo_patrimonyid = p.tms_gmovehicleid
                LEFT JOIN %1$s.tms_turnstatus st ON st.tms_turnstatusid = p.tms_turnstatusid
                """.formatted(s);
    }

    /** Lower-cases and strips French accents in SQL so filters match "VALIDÉ" with "valide". */
    static String norm(String expression) {
        return "lower(translate(" + expression + ", 'ÉÈÊËéèêëÀÂÄàâäÎÏîïÔÖôöÙÛÜùûüÇç', 'EEEEeeeeAAAaaaIIiiOOooUUUuuuCc'))";
    }

    /** Same normalization in Java for the user-supplied value. */
    static String normalize(String value) {
        String decomposed = Normalizer.normalize(value.trim(), Normalizer.Form.NFD);
        return DIACRITICS.matcher(decomposed).replaceAll("").toLowerCase(Locale.ROOT);
    }

    private static String notClosed(String statusColumn) {
        StringBuilder sb = new StringBuilder("(" + statusColumn + " IS NULL OR " + norm(statusColumn) + " NOT IN (");
        for (int i = 0; i < CLOSED_STATUSES.size(); i++) {
            sb.append(i == 0 ? "" : ", ").append('\'').append(CLOSED_STATUSES.get(i)).append('\'');
        }
        return sb.append("))").toString();
    }

    private QueryResult run(String sql, Where where, Integer limit) {
        int effectiveLimit = limit == null || limit <= 0 ? DEFAULT_LIMIT : Math.min(limit, MAX_LIMIT);
        Map<String, Object> params = new LinkedHashMap<>(where.params);
        params.put("limit", effectiveLimit);
        long started = System.currentTimeMillis();
        List<Map<String, Object>> rows = jdbc.sql(sql).params(params).query().listOfRows();
        log.debug("Assistant tool query returned {} rows in {} ms", rows.size(), System.currentTimeMillis() - started);
        long total = rows.isEmpty() ? 0 : ((Number) rows.getFirst().get("total_count")).longValue();
        List<Map<String, Object>> cleaned = rows.stream().map(r -> {
            Map<String, Object> c = clean(r);
            c.remove("total_count");
            return c;
        }).toList();
        String note = total > cleaned.size()
                ? "Showing " + cleaned.size() + " of " + total + " results; refine filters or raise the limit to see more."
                : null;
        return new QueryResult(total, cleaned.size(), cleaned, note);
    }

    /** Makes JDBC values readable for the model: timestamps as text, money rounded, nulls dropped. */
    static Map<String, Object> clean(Map<String, Object> row) {
        Map<String, Object> out = new LinkedHashMap<>();
        row.forEach((k, v) -> {
            if (v == null) {
                return;
            }
            if (v instanceof Timestamp ts) {
                out.put(k, ts.toLocalDateTime().format(DATE_TIME));
            } else if (v instanceof java.sql.Date d) {
                out.put(k, d.toLocalDate().toString());
            } else if (v instanceof BigDecimal bd) {
                out.put(k, bd.setScale(2, RoundingMode.HALF_UP));
            } else if (v instanceof Double dbl && (k.contains("latitude") || k.contains("longitude"))) {
                out.put(k, Math.round(dbl * 1_000_000d) / 1_000_000d);
            } else {
                out.put(k, v);
            }
        });
        return out;
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    static LocalDate parseDate(String value) {
        try {
            return LocalDate.parse(value.trim());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date '" + value + "'. Use yyyy-MM-dd.");
        }
    }

    /** Collects optional WHERE clauses and their named parameters. */
    static final class Where {
        final List<String> clauses = new ArrayList<>();
        final Map<String, Object> params = new LinkedHashMap<>();

        Where like(String normalizedExpression, String param, String value) {
            if (!isBlank(value)) {
                clauses.add(normalizedExpression + " LIKE :" + param);
                params.put(param, "%" + normalize(value) + "%");
            }
            return this;
        }

        Where dateFrom(String column, String value) {
            if (!isBlank(value)) {
                clauses.add(column + " >= :dateFrom");
                params.put("dateFrom", Timestamp.valueOf(parseDate(value).atStartOfDay()));
            }
            return this;
        }

        Where dateTo(String column, String value) {
            if (!isBlank(value)) {
                clauses.add(column + " < :dateTo");
                params.put("dateTo", Timestamp.valueOf(parseDate(value).plusDays(1).atStartOfDay()));
            }
            return this;
        }

        Where raw(String clause) {
            clauses.add(clause);
            return this;
        }

        String sql() {
            return clauses.isEmpty() ? " WHERE 1=1 " : " WHERE " + String.join(" AND ", clauses) + " ";
        }
    }

    /** What every list tool returns: the total count, how many rows are included, the rows, and an optional note. */
    public record QueryResult(long total, int returned, List<Map<String, Object>> rows, String note) {
    }
}
