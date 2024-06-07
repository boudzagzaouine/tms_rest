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

        return TransportPlanMapper.toDto(transportPlanRepository.saveAndFlush(TransportPlanMapper.toEntity(transportPlan, false)), false);
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

}

