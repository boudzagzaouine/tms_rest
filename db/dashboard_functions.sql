-- TMS dashboard KPI stored functions (schema_tmsvoieexpress).
-- Recreated from the live schema; the backend (TmsDashboardRepository) calls
-- these by name with all-varchar params ('*' = all, dates 'yyyy/MM/dd').
-- Apply with: psql -d <db> -f dashboard_functions.sql

-- =====================================================================
--  TMS dashboard KPI stored functions  (schema_tmsvoieexpress)
--  Recreated from the live schema — the backend (TmsDashboardRepository)
--  calls these by name with all-varchar params; '*' means "all", dates
--  are 'yyyy/MM/dd' strings (may be null).
-- =====================================================================
SET search_path TO schema_tmsvoieexpress;

-- Parse a 'yyyy/MM/dd' string to date (null-safe, accepts '*').
CREATE OR REPLACE FUNCTION _dash_d(p varchar) RETURNS date SET search_path TO schema_tmsvoieexpress AS $$
BEGIN
  IF p IS NULL OR p = '' OR p = '*' THEN RETURN NULL; END IF;
  RETURN to_date(p, 'YYYY/MM/DD');
END; $$ LANGUAGE plpgsql IMMUTABLE;

-- =====================  Transport-plan outcomes  =====================
-- Validé / effectué = completed plans (turnStatus 3 = FERMÉ).
CREATE OR REPLACE FUNCTION "transportplan_validé"(p_transport varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(*)::numeric FROM tms_transportplan tp
  WHERE tp.tms_turnstatusid = 3
    AND (p_transport = '*' OR tp.tms_trptransportid = NULLIF(p_transport,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- Annulé = cancelled plans (turnStatus 4 = ANNULÉ).
CREATE OR REPLACE FUNCTION transportplan_canceled(p_transport varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(*)::numeric FROM tms_transportplan tp
  WHERE tp.tms_turnstatusid = 4
    AND (p_transport = '*' OR tp.tms_trptransportid = NULLIF(p_transport,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- Refusé = plans a carrier (TRANSPORTEUR) refused — recorded in the plan history.
CREATE OR REPLACE FUNCTION transportplan_refused(p_transport varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(DISTINCT tp.tms_transportplanid)::numeric
  FROM tms_transportplan tp
  JOIN tms_transportplanhistory h ON h.tms_transportplanhistorytransportplanid = tp.tms_transportplanid
  JOIN tms_ordertransportrejecttype rt ON rt.tms_ordertransportrejecttypeid = h.tms_ordertransportrejecttypeid
  WHERE rt.tms_ordertransportrejecttypecode = 'TRANSPORTEUR'
    AND (p_transport = '*' OR tp.tms_trptransportid = NULLIF(p_transport,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- Rejeté = plans rejected on the CLIENT side — recorded in the plan history.
CREATE OR REPLACE FUNCTION transportplan_rejected(p_transport varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(DISTINCT tp.tms_transportplanid)::numeric
  FROM tms_transportplan tp
  JOIN tms_transportplanhistory h ON h.tms_transportplanhistorytransportplanid = tp.tms_transportplanid
  JOIN tms_ordertransportrejecttype rt ON rt.tms_ordertransportrejecttypeid = h.tms_ordertransportrejecttypeid
  WHERE rt.tms_ordertransportrejecttypecode = 'CLIENT'
    AND (p_transport = '*' OR tp.tms_trptransportid = NULLIF(p_transport,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- =====================  Trajet counts  =====================
CREATE OR REPLACE FUNCTION number_trajetvehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(*)::numeric FROM tms_transportplan tp
  WHERE (p_vehicle = '*' OR tp.tms_gmovehicleid = NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet  = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (p_cat     = '*' OR tp.tms_vehiclecategryid = NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION number_trajetdriver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(*)::numeric FROM tms_transportplan tp
  WHERE (p_driver = '*' OR tp.tms_gmodriverid = NULLIF(p_driver,'*')::numeric)
    AND (p_trajet = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- =====================  Durations (minutes)  =====================
-- Trip duration = departure -> arrival at destination.
CREATE OR REPLACE FUNCTION avg_duree_trajet_vehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatearriverdestination - tp.tms_transportplandatedepart))/60))::numeric, 0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatearriverdestination IS NOT NULL AND tp.tms_transportplandatedepart IS NOT NULL
    AND (p_vehicle = '*' OR tp.tms_gmovehicleid = NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet  = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (p_cat     = '*' OR tp.tms_vehiclecategryid = NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duree_trajet_driver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatearriverdestination - tp.tms_transportplandatedepart))/60))::numeric, 0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatearriverdestination IS NOT NULL AND tp.tms_transportplandatedepart IS NOT NULL
    AND (p_driver = '*' OR tp.tms_gmodriverid = NULLIF(p_driver,'*')::numeric)
    AND (p_trajet = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- Waiting duration = arrival at pickup -> loading start.
CREATE OR REPLACE FUNCTION avg_duree_trajet_attentvehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatecommancerchargement - tp.tms_transportplandatearriver))/60))::numeric, 0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatecommancerchargement IS NOT NULL AND tp.tms_transportplandatearriver IS NOT NULL
    AND (p_vehicle = '*' OR tp.tms_gmovehicleid = NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet  = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (p_cat     = '*' OR tp.tms_vehiclecategryid = NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duree_trajet_attentdriver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatecommancerchargement - tp.tms_transportplandatearriver))/60))::numeric, 0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatecommancerchargement IS NOT NULL AND tp.tms_transportplandatearriver IS NOT NULL
    AND (p_driver = '*' OR tp.tms_gmodriverid = NULLIF(p_driver,'*')::numeric)
    AND (p_trajet = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- Operation duration = loading (start->end) + unloading (start->end).
CREATE OR REPLACE FUNCTION avg_duration_operation_trajetvehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(
     COALESCE(EXTRACT(EPOCH FROM (tp.tms_transportplandatefinchargement - tp.tms_transportplandatecommancerchargement))/60, 0)
   + COALESCE(EXTRACT(EPOCH FROM (tp.tms_transportplandatefindechargement - tp.tms_transportplandatecommancerdechargement))/60, 0)
  ))::numeric, 0)
  FROM tms_transportplan tp
  WHERE (tp.tms_transportplandatefinchargement IS NOT NULL OR tp.tms_transportplandatefindechargement IS NOT NULL)
    AND (p_vehicle = '*' OR tp.tms_gmovehicleid = NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet  = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (p_cat     = '*' OR tp.tms_vehiclecategryid = NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duration_operation_trajetdriver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(
     COALESCE(EXTRACT(EPOCH FROM (tp.tms_transportplandatefinchargement - tp.tms_transportplandatecommancerchargement))/60, 0)
   + COALESCE(EXTRACT(EPOCH FROM (tp.tms_transportplandatefindechargement - tp.tms_transportplandatecommancerdechargement))/60, 0)
  ))::numeric, 0)
  FROM tms_transportplan tp
  WHERE (tp.tms_transportplandatefinchargement IS NOT NULL OR tp.tms_transportplandatefindechargement IS NOT NULL)
    AND (p_driver = '*' OR tp.tms_gmodriverid = NULLIF(p_driver,'*')::numeric)
    AND (p_trajet = '*' OR tp.tms_transportplantrajetid = NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart >= _dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart <= _dash_d(p_d2));
$$ LANGUAGE sql;

-- =====================  Mileage (odometer, from diesel declarations)  ===
-- Sum of (max-min odometer) per vehicle in the window.
CREATE OR REPLACE FUNCTION total_mileage_vehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(sum(delta), 0)::numeric FROM (
    SELECT max(d.gmo_dieseldeclarationmileage) - min(d.gmo_dieseldeclarationmileage) AS delta
    FROM gmo_dieseldeclaration d
    WHERE (p_vehicle = '*' OR d.gmo_vehicleid = NULLIF(p_vehicle,'*')::numeric)
      AND (p_cat = '*' OR d.gmo_vehicleid IN (SELECT v.gmo_patrimonyid FROM gmo_vehicule v WHERE v.gmo_vehiculecategorieid = NULLIF(p_cat,'*')::numeric))
      AND (_dash_d(p_d1) IS NULL OR d.gmo_dieseldeclarationdate >= _dash_d(p_d1))
      AND (_dash_d(p_d2) IS NULL OR d.gmo_dieseldeclarationdate <= _dash_d(p_d2))
    GROUP BY d.gmo_vehicleid
  ) x;
$$ LANGUAGE sql;

-- Driver mileage: sum odometer deltas of the vehicles the driver ran in the window.
CREATE OR REPLACE FUNCTION total_mileage_driver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(sum(delta), 0)::numeric FROM (
    SELECT max(d.gmo_dieseldeclarationmileage) - min(d.gmo_dieseldeclarationmileage) AS delta
    FROM gmo_dieseldeclaration d
    WHERE (p_driver = '*' OR d.gmo_vehicleid IN (
             SELECT DISTINCT tp.tms_gmovehicleid FROM tms_transportplan tp
             WHERE tp.tms_gmodriverid = NULLIF(p_driver,'*')::numeric))
      AND (_dash_d(p_d1) IS NULL OR d.gmo_dieseldeclarationdate >= _dash_d(p_d1))
      AND (_dash_d(p_d2) IS NULL OR d.gmo_dieseldeclarationdate <= _dash_d(p_d2))
    GROUP BY d.gmo_vehicleid
  ) x;
$$ LANGUAGE sql;

-- ---- duration functions: sanity-bounded versions (override the above) ----
SET search_path TO schema_tmsvoieexpress;
-- Sanity bounds: only count operation pairs where both stamps are real (>2020),
-- the gap is positive and within a plausible cap; placeholder/garbage dates and
-- outliers are excluded.

CREATE OR REPLACE FUNCTION avg_duree_trajet_vehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatearriverdestination - tp.tms_transportplandatedepart))/60))::numeric,0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatearriverdestination > DATE '2020-01-01' AND tp.tms_transportplandatedepart > DATE '2020-01-01'
    AND tp.tms_transportplandatearriverdestination >= tp.tms_transportplandatedepart
    AND EXTRACT(EPOCH FROM (tp.tms_transportplandatearriverdestination - tp.tms_transportplandatedepart))/60 <= 2880
    AND (p_vehicle='*' OR tp.tms_gmovehicleid=NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet ='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (p_cat    ='*' OR tp.tms_vehiclecategryid=NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duree_trajet_driver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatearriverdestination - tp.tms_transportplandatedepart))/60))::numeric,0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatearriverdestination > DATE '2020-01-01' AND tp.tms_transportplandatedepart > DATE '2020-01-01'
    AND tp.tms_transportplandatearriverdestination >= tp.tms_transportplandatedepart
    AND EXTRACT(EPOCH FROM (tp.tms_transportplandatearriverdestination - tp.tms_transportplandatedepart))/60 <= 2880
    AND (p_driver='*' OR tp.tms_gmodriverid=NULLIF(p_driver,'*')::numeric)
    AND (p_trajet='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duree_trajet_attentvehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatecommancerchargement - tp.tms_transportplandatearriver))/60))::numeric,0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatecommancerchargement > DATE '2020-01-01' AND tp.tms_transportplandatearriver > DATE '2020-01-01'
    AND tp.tms_transportplandatecommancerchargement >= tp.tms_transportplandatearriver
    AND EXTRACT(EPOCH FROM (tp.tms_transportplandatecommancerchargement - tp.tms_transportplandatearriver))/60 <= 600
    AND (p_vehicle='*' OR tp.tms_gmovehicleid=NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet ='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (p_cat    ='*' OR tp.tms_vehiclecategryid=NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duree_trajet_attentdriver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(EXTRACT(EPOCH FROM (tp.tms_transportplandatecommancerchargement - tp.tms_transportplandatearriver))/60))::numeric,0)
  FROM tms_transportplan tp
  WHERE tp.tms_transportplandatecommancerchargement > DATE '2020-01-01' AND tp.tms_transportplandatearriver > DATE '2020-01-01'
    AND tp.tms_transportplandatecommancerchargement >= tp.tms_transportplandatearriver
    AND EXTRACT(EPOCH FROM (tp.tms_transportplandatecommancerchargement - tp.tms_transportplandatearriver))/60 <= 600
    AND (p_driver='*' OR tp.tms_gmodriverid=NULLIF(p_driver,'*')::numeric)
    AND (p_trajet='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duration_operation_trajetvehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(mins))::numeric,0) FROM (
    SELECT (
      CASE WHEN tp.tms_transportplandatefinchargement > DATE '2020-01-01' AND tp.tms_transportplandatecommancerchargement > DATE '2020-01-01'
                AND tp.tms_transportplandatefinchargement >= tp.tms_transportplandatecommancerchargement
                AND EXTRACT(EPOCH FROM (tp.tms_transportplandatefinchargement - tp.tms_transportplandatecommancerchargement))/60 <= 480
           THEN EXTRACT(EPOCH FROM (tp.tms_transportplandatefinchargement - tp.tms_transportplandatecommancerchargement))/60 ELSE 0 END
    + CASE WHEN tp.tms_transportplandatefindechargement > DATE '2020-01-01' AND tp.tms_transportplandatecommancerdechargement > DATE '2020-01-01'
                AND tp.tms_transportplandatefindechargement >= tp.tms_transportplandatecommancerdechargement
                AND EXTRACT(EPOCH FROM (tp.tms_transportplandatefindechargement - tp.tms_transportplandatecommancerdechargement))/60 <= 480
           THEN EXTRACT(EPOCH FROM (tp.tms_transportplandatefindechargement - tp.tms_transportplandatecommancerdechargement))/60 ELSE 0 END
    ) AS mins
    FROM tms_transportplan tp
    WHERE (p_vehicle='*' OR tp.tms_gmovehicleid=NULLIF(p_vehicle,'*')::numeric)
      AND (p_trajet ='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
      AND (p_cat    ='*' OR tp.tms_vehiclecategryid=NULLIF(p_cat,'*')::numeric)
      AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
      AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2))
  ) x WHERE mins > 0;
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION avg_duration_operation_trajetdriver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(avg(mins))::numeric,0) FROM (
    SELECT (
      CASE WHEN tp.tms_transportplandatefinchargement > DATE '2020-01-01' AND tp.tms_transportplandatecommancerchargement > DATE '2020-01-01'
                AND tp.tms_transportplandatefinchargement >= tp.tms_transportplandatecommancerchargement
                AND EXTRACT(EPOCH FROM (tp.tms_transportplandatefinchargement - tp.tms_transportplandatecommancerchargement))/60 <= 480
           THEN EXTRACT(EPOCH FROM (tp.tms_transportplandatefinchargement - tp.tms_transportplandatecommancerchargement))/60 ELSE 0 END
    + CASE WHEN tp.tms_transportplandatefindechargement > DATE '2020-01-01' AND tp.tms_transportplandatecommancerdechargement > DATE '2020-01-01'
                AND tp.tms_transportplandatefindechargement >= tp.tms_transportplandatecommancerdechargement
                AND EXTRACT(EPOCH FROM (tp.tms_transportplandatefindechargement - tp.tms_transportplandatecommancerdechargement))/60 <= 480
           THEN EXTRACT(EPOCH FROM (tp.tms_transportplandatefindechargement - tp.tms_transportplandatecommancerdechargement))/60 ELSE 0 END
    ) AS mins
    FROM tms_transportplan tp
    WHERE (p_driver='*' OR tp.tms_gmodriverid=NULLIF(p_driver,'*')::numeric)
      AND (p_trajet='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
      AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
      AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2))
  ) x WHERE mins > 0;
$$ LANGUAGE sql;

-- ---- mileage: use order distance (tms_ordertransportnumberkm), not the
--      empty odometer table — overrides the diesel-based versions above ----
SET search_path TO schema_tmsvoieexpress;
-- Kilométrage parcouru = sum of the order distance (tms_ordertransportnumberkm)
-- over the driver's/vehicle's trips. (gmo_dieseldeclaration odometer is empty
-- in this environment, so the order distance is the real, populated source.)

CREATE OR REPLACE FUNCTION total_mileage_vehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(sum(ot.tms_ordertransportnumberkm)::numeric, 2), 0)
  FROM tms_transportplan tp
  JOIN tms_ordertransport ot ON ot.tms_ordertransportid = tp.tms_ordertransportid
  WHERE (p_vehicle='*' OR tp.tms_gmovehicleid=NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet ='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (p_cat    ='*' OR tp.tms_vehiclecategryid=NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION total_mileage_driver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(sum(ot.tms_ordertransportnumberkm)::numeric, 2), 0)
  FROM tms_transportplan tp
  JOIN tms_ordertransport ot ON ot.tms_ordertransportid = tp.tms_ordertransportid
  WHERE (p_driver='*' OR tp.tms_gmodriverid=NULLIF(p_driver,'*')::numeric)
    AND (p_trajet='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

-- ==== data-audit fixes (override the versions above) ====
SET search_path TO schema_tmsvoieexpress;
-- Fixes from the data audit:
--  (1) "Trajets parcouru / plans effectués" must count trips actually run,
--      not planned (CRÉE=1) or cancelled (ANNULÉ=4).
--  (2) Kilométrage: use the order distance; when it's missing, fall back to the
--      great-circle distance between the trajet's source and destination villes
--      (all villes have GPS), so the km isn't lost for un-priced orders.

-- great-circle km between a trajet's source and destination ville
CREATE OR REPLACE FUNCTION _dash_trajetkm(p_trajet numeric) RETURNS numeric
SET search_path TO schema_tmsvoieexpress AS $$
  SELECT 6371 * acos(GREATEST(-1, LEAST(1,
           cos(radians(vs.prm_villelatitude)) * cos(radians(vd.prm_villelatitude))
             * cos(radians(vd.prm_villelongtitude) - radians(vs.prm_villelongtitude))
         + sin(radians(vs.prm_villelatitude)) * sin(radians(vd.prm_villelatitude)))))
  FROM tms_trajet tr
  JOIN prm_ville vs ON vs.prm_villeid = tr.tms_villesournceid
  JOIN prm_ville vd ON vd.prm_villeid = tr.tms_villedistinationid
  WHERE tr.tms_trajetid = p_trajet;
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION number_trajetvehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(*)::numeric FROM tms_transportplan tp
  WHERE tp.tms_turnstatusid NOT IN (1,4)
    AND (p_vehicle='*' OR tp.tms_gmovehicleid=NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet ='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (p_cat    ='*' OR tp.tms_vehiclecategryid=NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION number_trajetdriver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT count(*)::numeric FROM tms_transportplan tp
  WHERE tp.tms_turnstatusid NOT IN (1,4)
    AND (p_driver='*' OR tp.tms_gmodriverid=NULLIF(p_driver,'*')::numeric)
    AND (p_trajet='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION total_mileage_vehicle(p_vehicle varchar, p_trajet varchar, p_cat varchar,
       p_marque varchar, p_seniority varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(sum(COALESCE(ot.tms_ordertransportnumberkm, _dash_trajetkm(tp.tms_transportplantrajetid)))::numeric, 2), 0)
  FROM tms_transportplan tp
  JOIN tms_ordertransport ot ON ot.tms_ordertransportid = tp.tms_ordertransportid
  WHERE tp.tms_turnstatusid NOT IN (1,4)
    AND (p_vehicle='*' OR tp.tms_gmovehicleid=NULLIF(p_vehicle,'*')::numeric)
    AND (p_trajet ='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (p_cat    ='*' OR tp.tms_vehiclecategryid=NULLIF(p_cat,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION total_mileage_driver(p_driver varchar, p_trajet varchar, p_d1 varchar, p_d2 varchar)
RETURNS numeric SET search_path TO schema_tmsvoieexpress AS $$
  SELECT COALESCE(round(sum(COALESCE(ot.tms_ordertransportnumberkm, _dash_trajetkm(tp.tms_transportplantrajetid)))::numeric, 2), 0)
  FROM tms_transportplan tp
  JOIN tms_ordertransport ot ON ot.tms_ordertransportid = tp.tms_ordertransportid
  WHERE tp.tms_turnstatusid NOT IN (1,4)
    AND (p_driver='*' OR tp.tms_gmodriverid=NULLIF(p_driver,'*')::numeric)
    AND (p_trajet='*' OR tp.tms_transportplantrajetid=NULLIF(p_trajet,'*')::numeric)
    AND (_dash_d(p_d1) IS NULL OR tp.tms_transportplandatedepart>=_dash_d(p_d1))
    AND (_dash_d(p_d2) IS NULL OR tp.tms_transportplandatedepart<=_dash_d(p_d2));
$$ LANGUAGE sql;
