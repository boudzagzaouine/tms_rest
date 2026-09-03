package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.TransportPlan;
import com.bagile.gmo.dto.TransportPlanServiceCatalog;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TransportPlanService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/transportPlans")
public class TransportPlanController {

    private final TransportPlanService transportPlanService;

    public TransportPlanController(TransportPlanService transportPlanService) {
        this.transportPlanService = transportPlanService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TransportPlan> getAll() {
        return transportPlanService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TransportPlan> getAll(@RequestParam int page, @RequestParam int size) {
        return transportPlanService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TransportPlan getOne(@PathVariable("id") Long id) throws IdNotFound {
        return transportPlanService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportPlanService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportPlanService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TransportPlan> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TransportPlan> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportPlanService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlan add(@RequestBody TransportPlan transportPlan) throws IdNotFound, ErrorType, IOException, AttributesNotFound {
        return transportPlanService.save(transportPlan);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportPlan set(@RequestBody TransportPlan transportPlan) throws IdNotFound, ErrorType, IOException, AttributesNotFound {
        return transportPlanService.save(transportPlan);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TransportPlan transportPlan) {
        transportPlanService.delete(transportPlan);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportPlanService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        transportPlanService.deleteAll (Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  transportPlanService.getNextVal();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLastPriceTransport")
    @ResponseBody
    public TransportPlan getLastPriceTransport(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.getLastPriceTransport(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLastPriceTransports")
    @ResponseBody
    public List<TransportPlan> getLastPriceTransports(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportPlanService.getLastPriceTransports(search);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/exportInvoiceState")
//    @ResponseBody
//    public ResponseEntity<byte[]> exportInvoiceState(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
//        return transportPlanService.exportInvoiceState(search);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/exportInvoiceState")
    @ResponseBody
    public ResponseEntity<Resource> exportInvoiceState(@RequestParam(value = "search")String search) throws ErrorType, AttributesNotFound {
        byte[] responseEntity = transportPlanService.exportInvoiceState(search);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new ByteArrayResource(responseEntity));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getItineraries")
    @ResponseBody
    public List<TransportPlan> getItineraries(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportPlanService.getItineraries(search, page,  size);
    }

    /**
     * Slim plan list for the driver mobile app: only the fields the app reads,
     * filtered server-side to one driver. The full DTO graph serializes to
     * hundreds of KB per plan (vehicle maintenance data, order graph, vehicle
     * category), which runs the phone out of memory once the table grows — this
     * keeps each plan to a few KB.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/driver/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<java.util.Map<String, Object>> listForDriver(@PathVariable Long driverId) throws AttributesNotFound, ErrorType {
        List<TransportPlan> plans = transportPlanService.find("driver.id:" + driverId);
        List<java.util.Map<String, Object>> out = new java.util.ArrayList<java.util.Map<String, Object>>(plans.size());
        for (TransportPlan p : plans) {
            java.util.Map<String, Object> m = new java.util.HashMap<String, Object>();
            m.put("id", p.getId());
            if (p.getDriver() != null) {
                java.util.Map<String, Object> d = new java.util.HashMap<String, Object>();
                d.put("id", p.getDriver().getId());
                m.put("driver", d);
            }
            if (p.getTurnStatus() != null) {
                java.util.Map<String, Object> ts = new java.util.HashMap<String, Object>();
                ts.put("id", p.getTurnStatus().getId());
                ts.put("code", p.getTurnStatus().getCode());
                m.put("turnStatus", ts);
            }
            if (p.getVehicle() != null) {
                java.util.Map<String, Object> v = new java.util.HashMap<String, Object>();
                v.put("id", p.getVehicle().getId());
                v.put("code", p.getVehicle().getCode());
                v.put("matricule", p.getVehicle().getRegistrationNumber());
                m.put("vehicle", v);
            }
            if (p.getOrderTransport() != null) {
                java.util.Map<String, Object> ot = new java.util.HashMap<String, Object>();
                ot.put("id", p.getOrderTransport().getId());
                ot.put("code", p.getOrderTransport().getCode());
                ot.put("description", p.getOrderTransport().getDescription());
                if (p.getOrderTransport().getTurnType() != null) {
                    java.util.Map<String, Object> tt = new java.util.HashMap<String, Object>();
                    tt.put("code", p.getOrderTransport().getTurnType().getCode());
                    ot.put("turnType", tt);
                }
                if (p.getOrderTransport().getOrderTransportServiceCatalogs() != null) {
                    List<java.util.Map<String, Object>> scs = new java.util.ArrayList<java.util.Map<String, Object>>();
                    for (TransportPlanServiceCatalog sc : p.getOrderTransport().getOrderTransportServiceCatalogs()) {
                        if (sc == null) continue;
                        java.util.Map<String, Object> scm = new java.util.HashMap<String, Object>();
                        if (sc.getProduct() != null) {
                            java.util.Map<String, Object> prod = new java.util.HashMap<String, Object>();
                            prod.put("code", sc.getProduct().getCode());
                            scm.put("product", prod);
                        }
                        scm.put("quantity", sc.getQuantity());
                        scs.add(scm);
                    }
                    ot.put("orderTransportServiceCatalogs", scs);
                }
                m.put("orderTransport", ot);
            }
            m.put("villeSource", slimVille(p.getVilleSource()));
            m.put("villeDistination", slimVille(p.getVilleDistination()));
            if (p.getTrajet() != null) {
                java.util.Map<String, Object> tr = new java.util.HashMap<String, Object>();
                tr.put("code", p.getTrajet().getCode());
                tr.put("villeSource", slimVille(p.getTrajet().getVilleSource()));
                tr.put("villeDestination", slimVille(p.getTrajet().getVilleDestination()));
                m.put("trajet", tr);
            }
            m.put("dateDepart", p.getDateDepart());
            m.put("dateDepartDriver", p.getDateDepartDriver());
            m.put("closeDate", p.getCloseDate());
            m.put("dateArriver", p.getDateArriver());
            m.put("dateCommancerChargement", p.getDateCommancerChargement());
            m.put("dateFinChargement", p.getDateFinChargement());
            m.put("dateCommancerDechargement", p.getDateCommancerDechargement());
            m.put("dateFinDechargement", p.getDateFinDechargement());
            m.put("dateArriverDestination", p.getDateArriverDestination());
            m.put("latitude", p.getLatitude());
            m.put("longitude", p.getLongitude());
            m.put("remark", p.getRemark());
            m.put("paymentAmountEnlevement", p.getPaymentAmountEnlevement());
            m.put("paymentTypeEnlevement", p.getPaymentTypeEnlevement());
            m.put("paymentAmountLivraison", p.getPaymentAmountLivraison());
            m.put("paymentTypeLivraison", p.getPaymentTypeLivraison());
            out.add(m);
        }
        return out;
    }

    private static java.util.Map<String, Object> slimVille(com.bagile.gmo.dto.Ville v) {
        if (v == null) return null;
        java.util.Map<String, Object> m = new java.util.HashMap<String, Object>();
        m.put("code", v.getCode());
        m.put("description", v.getDescription());
        m.put("latitude", v.getLatitude());
        m.put("longitude", v.getLongitude());
        return m;
    }

    /**
     * Lightweight live-position update used by the driver app during a mission.
     * Updates only the plan's current latitude/longitude (a targeted UPDATE), so
     * the tracking map reflects the driver's position without a full plan save.
     */
    @RequestMapping(value = "/{id}/position", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public java.util.Map<String, Object> updatePosition(@PathVariable Long id,
                                                        @RequestBody java.util.Map<String, Object> body) {
        Double lat = body.get("latitude") == null ? null : Double.valueOf(body.get("latitude").toString());
        Double lng = body.get("longitude") == null ? null : Double.valueOf(body.get("longitude").toString());
        int updated = transportPlanService.updateLivePosition(id, lat, lng);
        java.util.Map<String, Object> res = new java.util.HashMap<>();
        res.put("updated", updated);
        return res;
    }

    /**
     * Records cash the driver actually collected at a stop ("retour de fonds"). Append-only: each
     * confirmation is a new row, so a correction never erases the original declaration.
     *
     * <p>Body: {@code {leg: 1|2, collectedAmount: number, expectedAmount?: number,
     * paymentTypeCode?: string, driverId?: number, note?: string}}.</p>
     */
    @RequestMapping(value = "/{id}/cash-collection", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<java.util.Map<String, Object>> recordCashCollection(
            @PathVariable Long id, @RequestBody java.util.Map<String, Object> body) {
        Integer leg = num(body.get("leg")) == null ? null : num(body.get("leg")).intValue();
        java.math.BigDecimal collected = dec(body.get("collectedAmount"));
        if (leg == null || (leg != 1 && leg != 2) || collected == null) {
            java.util.Map<String, Object> err = new java.util.HashMap<>();
            err.put("error", "leg must be 1 or 2 and collectedAmount is required");
            return ResponseEntity.badRequest().body(err);
        }
        Long recordId = transportPlanService.recordCashCollection(
                id, leg, collected, dec(body.get("expectedAmount")),
                body.get("paymentTypeCode") == null ? null : body.get("paymentTypeCode").toString(),
                num(body.get("driverId")) == null ? null : num(body.get("driverId")).longValue(),
                body.get("note") == null ? null : body.get("note").toString());
        java.util.Map<String, Object> res = new java.util.HashMap<>();
        res.put("id", recordId);
        return ResponseEntity.ok(res);
    }

    /** Cash collections already recorded for a plan (so the app can show what is confirmed). */
    @RequestMapping(value = "/{id}/cash-collection", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<java.util.Map<String, Object>> listCashCollections(@PathVariable Long id) {
        return transportPlanService.findCashCollections(id);
    }

    /** Lenient numeric parsing: the body is a raw map, values may arrive as String or Number. */
    private static Double num(Object v) {
        if (v == null) return null;
        try {
            return Double.valueOf(v.toString().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static java.math.BigDecimal dec(Object v) {
        if (v == null) return null;
        try {
            return new java.math.BigDecimal(v.toString().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
