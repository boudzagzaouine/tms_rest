package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportPlanLocation;
import com.bagile.gmo.entities.TmsTransportPlanLocation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportPlanLocationMapper;
import com.bagile.gmo.repositories.TransportPlanLocationRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransportPlanLocationServiceImpl implements TransportPlanLocationService {
    
    private final TransportPlanLocationRepository transportPlanLocationRepository;


    @Autowired
    private TransportPlanService transportPlanService;
    @Autowired
    private OrderTransportService orderTransportService;

    @Autowired
    private OrderTransportInfoService orderTransportInfoService;
    @Autowired
    private OrderTransportInfoLineService orderTransportInfoLineService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DriverService driverService;



    public TransportPlanLocationServiceImpl(TransportPlanLocationRepository transportPlanLocationRepository) {
        this.transportPlanLocationRepository = transportPlanLocationRepository;
    }

    @Override
    public TransportPlanLocation save(TransportPlanLocation transportPlanLocation) throws IdNotFound {

        transportPlanLocation.setTransportPlan(transportPlanService.findById(transportPlanLocation.getTransportPlan().getId()));
        transportPlanLocation.setOrderTransport(orderTransportService.findById(transportPlanLocation.getOrderTransport().getId()));
        transportPlanLocation.setOrderTransportInfo(orderTransportInfoService.findById(transportPlanLocation.getOrderTransportInfo().getId()));
        transportPlanLocation.setOrderTransportInfoLine(orderTransportInfoLineService.findById(transportPlanLocation.getOrderTransportInfoLine().getId()));
        transportPlanLocation.setVehicle(vehicleService.findById(transportPlanLocation.getVehicle().getId()));
        transportPlanLocation.setDriver(driverService.findById(transportPlanLocation.getDriver().getId()));


        return TransportPlanLocationMapper.toDto(transportPlanLocationRepository.saveAndFlush(TransportPlanLocationMapper.toEntity(transportPlanLocation, false)), false);
    }

    @Override
    public Long size() {
        return transportPlanLocationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportPlanLocationRepository.existsById(id);
    }

    @Override
    public TransportPlanLocation findById(Long id) throws IdNotFound {
        return TransportPlanLocationMapper.toDto(transportPlanLocationRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportPlanLocation> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportPlanLocationMapper.toDtos(transportPlanLocationRepository.findAll(Search.expression(search, TmsTransportPlanLocation.class)), false);
    }

    @Override
    public List<TransportPlanLocation> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanLocationMapper.toDtos(transportPlanLocationRepository.findAll(Search.expression(search, TmsTransportPlanLocation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportPlanLocationRepository.count(Search.expression(search, TmsTransportPlanLocation.class));
    }

    @Override
    public void delete(Long id) {
        transportPlanLocationRepository.deleteById(id);
    }

    @Override
    public void delete(TransportPlanLocation transportPlanLocation) {
        transportPlanLocationRepository.delete(TransportPlanLocationMapper.toEntity(transportPlanLocation, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportPlanLocationRepository.deleteById(id);        }
    }


    @Override
    public List<TransportPlanLocation> findAll() {
        return TransportPlanLocationMapper.toDtos(transportPlanLocationRepository.findAll(), false);
    }

    @Override
    public List<TransportPlanLocation> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanLocationMapper.toDtos(transportPlanLocationRepository.findAll(pageable), false);
    }



}

