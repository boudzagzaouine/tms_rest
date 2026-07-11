package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.TmsTransportPlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportPlanMapper;
import com.bagile.gmo.repositories.TransportPlanRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class TransportPlanServiceImpl implements TransportPlanService {

    private final TransportPlanRepository transportPlanRepository;
    private final DataSource dataSource;

    @Autowired
    private com.bagile.gmo.services.PushService pushService;


    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaintenanceService.class);

    @Autowired
    private OrderTransportInfoService orderTransportInfoService;

    @Autowired
    private OrderTransportInfoLineService orderTransportInfoLineService;


    @Autowired
    private TransportPlanLocationService transportPlanLocationService;
    @Autowired
    private VehicleService vehicleService;

    public TransportPlanServiceImpl(TransportPlanRepository transportPlanRepository, DataSource dataSource) {
        this.transportPlanRepository = transportPlanRepository;
        this.dataSource = dataSource;
    }

    @Override
    public TransportPlan save(TransportPlan transportPlan) throws IdNotFound, ErrorType, IOException, AttributesNotFound {

if(transportPlan.getTransport().getInterneOrExterne()) {
    Vehicle vehicle = vehicleService.findById(transportPlan.getVehicle().getId());
    if(vehicle.getId()>0){
    if (transportPlan.getTurnStatus().getId() == 3) //3fermer
    {
        vehicle.setDisponible(4L); // 4 disponible
    }
    if (transportPlan.getTurnStatus().getId() >=5) // 5 enCour
    {
        vehicle.setDisponible(1L); // 1 Trajet
    }
    vehicle.setLastPointCity(transportPlan.getTrajet().getVilleSource().getCode());
    vehicle.setLastPointDate(new Date());
    vehicleService.save(vehicle);
    }
}

        boolean isNew = transportPlan.getId() == 0;
        TransportPlan saved = TransportPlanMapper.toDto(
                transportPlanRepository.saveAndFlush(TransportPlanMapper.toEntity(transportPlan, false)), false);

        // Notify the driver when a delivery is newly affected to them (a new plan
        // with a driver). Updates (id>0, incl. the app's own status writes) don't
        // fire, so there's no self-notification loop. Best-effort — never blocks save.
        if (isNew && saved.getDriver() != null && saved.getDriver().getId() > 0) {
            try {
                java.util.Map<String, Object> data = new java.util.HashMap<>();
                data.put("orderId", saved.getId());
                String code = saved.getOrderTransport() != null && saved.getOrderTransport().getCode() != null
                        ? saved.getOrderTransport().getCode()
                        : "TP-" + saved.getId();
                String route = saved.getTrajet() != null ? saved.getTrajet().getCode() : "";
                pushService.notifyDriver(saved.getDriver().getId(),
                        "Nouvelle livraison affectée", code + (route.isEmpty() ? "" : " · " + route), data);
            } catch (Exception ignored) {
                // push must never break the assignment
            }
        }

        // The driver app records operation timestamps on the plan, but the
        // Track & Trace screen reads them from the order's info-line. Mirror the
        // plan's operation dates onto the order's info-line(s) so the driver's
        // progress (arrival, loading/unloading start/end, close) shows there.
        try {
            if (saved.getOrderTransport() != null && saved.getOrderTransport().getId() > 0) {
                propagateOpsToInfoLines(saved.getOrderTransport().getId(), saved);
            }
        } catch (Exception ignored) {
            // never block the save on this mirroring
        }
        return saved;
    }

    /**
     * Copies the plan's operation timestamps onto the order's info-line(s).
     *
     * An order has separate info-lines for the pickup leg (enlevement,
     * tms_ordertrasnportserviceid = 1) and the delivery leg (livraison,
     * serviceid = 2). Each leg must only receive its own operations, otherwise
     * recording e.g. "arrival at pickup" would wrongly stamp the delivery line
     * too. So we split the mirroring per line type:
     *   - enlevement: arrival, loading start/end, close
     *   - livraison:  unloading start/end, close
     * (the delivery leg's own arrival is a distinct event, not the pickup
     * arrival, so we never copy the plan's dateArriver onto it here.)
     */
    private void propagateOpsToInfoLines(long orderId, TransportPlan plan) {
        // Pickup leg (enlevement) — arrival + loading + close.
        String enlevementSql = "UPDATE schema_tmsvoieexpress.tms_ordertransportinfolineinfoline l SET "
                + "tms_ordertransportinfolinedatearriver = COALESCE(?, l.tms_ordertransportinfolinedatearriver), "
                + "tms_ordertransportinfolinedatecommancerchargement = COALESCE(?, l.tms_ordertransportinfolinedatecommancerchargement), "
                + "tms_ordertransportinfolinedatefinchargement = COALESCE(?, l.tms_ordertransportinfolinedatefinchargement), "
                + "tms_ordertransportinfolineclosedate = COALESCE(?, l.tms_ordertransportinfolineclosedate) "
                + "FROM schema_tmsvoieexpress.tms_ordertransportinfo i "
                + "WHERE i.tms_ordertransportinfoid = l.tms_ordertransportinfoid "
                + "AND i.tms_ordertransport = ? AND l.tms_ordertrasnportserviceid = 1";

        // Delivery leg (livraison) — arrival at destination + unloading + close.
        String livraisonSql = "UPDATE schema_tmsvoieexpress.tms_ordertransportinfolineinfoline l SET "
                + "tms_ordertransportinfolinedatearriver = COALESCE(?, l.tms_ordertransportinfolinedatearriver), "
                + "tms_ordertransportinfolinedatecommancerdechargement = COALESCE(?, l.tms_ordertransportinfolinedatecommancerdechargement), "
                + "tms_ordertransportinfolinedatefindechargement = COALESCE(?, l.tms_ordertransportinfolinedatefindechargement), "
                + "tms_ordertransportinfolineclosedate = COALESCE(?, l.tms_ordertransportinfolineclosedate) "
                + "FROM schema_tmsvoieexpress.tms_ordertransportinfo i "
                + "WHERE i.tms_ordertransportinfoid = l.tms_ordertransportinfoid "
                + "AND i.tms_ordertransport = ? AND l.tms_ordertrasnportserviceid = 2";

        try (java.sql.Connection c = dataSource.getConnection()) {
            try (java.sql.PreparedStatement ps = c.prepareStatement(enlevementSql)) {
                setTs(ps, 1, plan.getDateArriver());
                setTs(ps, 2, plan.getDateCommancerChargement());
                setTs(ps, 3, plan.getDateFinChargement());
                setTs(ps, 4, plan.getCloseDate());
                ps.setLong(5, orderId);
                ps.executeUpdate();
            }
            try (java.sql.PreparedStatement ps = c.prepareStatement(livraisonSql)) {
                setTs(ps, 1, plan.getDateArriverDestination());
                setTs(ps, 2, plan.getDateCommancerDechargement());
                setTs(ps, 3, plan.getDateFinDechargement());
                setTs(ps, 4, plan.getCloseDate());
                ps.setLong(5, orderId);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            LOGGER.warn("could not propagate operation dates to info-lines for order {}", orderId, e);
        }
    }

    private static void setTs(java.sql.PreparedStatement ps, int idx, java.util.Date d) throws java.sql.SQLException {
        if (d == null) ps.setNull(idx, java.sql.Types.TIMESTAMP);
        else ps.setTimestamp(idx, new java.sql.Timestamp(d.getTime()));
    }

    @Override
    public Long size() {
        return transportPlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportPlanRepository.existsById(id);
    }

    @Override
    public TransportPlan findById(Long id) throws IdNotFound {
        return TransportPlanMapper.toDto(transportPlanRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportPlan> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(Search.expression(search, TmsTransportPlan.class)), false);
    }

    @Override
    public List<TransportPlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(Search.expression(search, TmsTransportPlan.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportPlanRepository.count(Search.expression(search, TmsTransportPlan.class));
    }

    @Override
    public void delete(Long id) {
        transportPlanRepository.deleteById(id);
    }

    @Override
    public void deleteByOt(Long otId) throws ErrorType, AttributesNotFound {
        List<Long> transportPlans = new ArrayList<>();


                transportPlans.addAll( find("orderTransport.id:"+otId).stream().map(m-> m.getId()).collect(Collectors.toList()));

               deleteAll(transportPlans);
    }

    @Override
    public void delete(TransportPlan transportPlan) {
        transportPlanRepository.delete(TransportPlanMapper.toEntity(transportPlan, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportPlanRepository.deleteById(id);        }
    }


    @Override
    public List<TransportPlan> findAll() {
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(), false);
    }

    @Override
    public List<TransportPlan> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(pageable), false);
    }

    @Override
    public TransportPlan findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public String getNextVal() {
        return null;


    }

    @Override
    public TransportPlan getLastPriceTransport( String search) throws ErrorType, AttributesNotFound {
        TransportPlan transportPlan = new TransportPlan();
        List<TransportPlan> transportPlans = new ArrayList<>();
        transportPlans= TransportPlanMapper.toDtos(transportPlanRepository.findAll(Search.expression(search,TmsTransportPlan.class),(Sort.by(Sort.Direction.DESC, "tmsTransportPlanDate"))), false);
        if(!transportPlans.isEmpty()){
            transportPlan=transportPlans.stream().findFirst().get();
        }


        return transportPlan;
    }

    @Override
    public List<TransportPlan> getLastPriceTransports( String search) throws ErrorType, AttributesNotFound {

        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(Search.expression(search,TmsTransportPlan.class),(Sort.by(Sort.Direction.DESC, "tmsTransportPlanDate"))), false);


    }

    @Override
    public  byte[] exportInvoiceState(String search) throws ErrorType, AttributesNotFound {

        try {
            //dynamic parameters required for report
            Map<String, Object> empParams = new HashMap<>();
            empParams.put("id", search);
            String invoiceStateTemplatePath = "/reports/InvoiceStateReport.jrxml";
            final InputStream reportInputStream= getClass().getResourceAsStream(invoiceStateTemplatePath);


            JasperPrint empReport =
                    JasperFillManager.fillReport
                            (
                                    JasperCompileManager.compileReport(
                                            reportInputStream )
                                    , empParams // dynamic parameters
                                    , dataSource.getConnection()
                            );

            HttpHeaders headers = new HttpHeaders();
            //set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "invocieState.pdf");
            //create the report in PDF format
            return JasperExportManager.exportReportToPdf(empReport);

        } catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }

    }

    @Override
    public List<TransportPlan> getItineraries(String search,int page, int size) throws ErrorType, AttributesNotFound {

       List<TransportPlan> transportPlans = find(search,page,size);

       transportPlans.forEach(transportPlan -> {

           try {
               transportPlan.getOrderTransport().setOrderTransportInfos(orderTransportInfoService.find("orderTransport.id:"+transportPlan.getOrderTransport().getId()));

               transportPlan.getOrderTransport().getOrderTransportInfos().forEach(info -> {
                   try {
                       info.setOrderTransportInfoLines(orderTransportInfoLineService.find("orderTransportInfo.id:"+info.getId()));

                   } catch (AttributesNotFound e) {
                       throw new RuntimeException(e);
                   } catch (ErrorType e) {
                       throw new RuntimeException(e);
                   }
               });

      /*         TransportPlanLocation transportPlanLocation=   transportPlanLocationService.find("orderTransport.id:"+transportPlan.getOrderTransport().getId()).get(0);
               if(transportPlanLocation.getId()>0){
                   OrderTransportInfoLine orderTransportInfoLine = new OrderTransportInfoLine();
                   Address address = new Address();
//                   address.setLatitude(transportPlanLocation.getLatitude());
//                   address.setLongitude(transportPlanLocation.getLongitude());

                   address.setLatitude(33.80026065115837);
                   address.setLongitude(-6.060294108419388);

                   orderTransportInfoLine.setAddress(address);
orderTransportInfoLine.setDate(transportPlanLocation.getDate());
                   transportPlan.getOrderTransport().getOrderTransportInfos().get(0).getOrderTransportInfoLines().add(orderTransportInfoLine);

               }
*/



           } catch (AttributesNotFound e) {
               throw new RuntimeException(e);
           } catch (ErrorType e) {
               throw new RuntimeException(e);
           }


       });





       return transportPlans;

    }

    @Override
    public int updateLivePosition(long id, Double latitude, Double longitude) {
        return transportPlanRepository.updateLivePosition(id, latitude, longitude);
    }

}

