package com.bagile.tms.services.impl;

import com.sinno.ems.dto.VehiculeStatus;
import com.sinno.ems.entities.TmsVehicleStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.VehicleStatusMapper;
import com.sinno.ems.repositories.VehicleStatusRepository;
import com.sinno.ems.service.VehicleStatusService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleStatusService.class);



    @Override
    public VehiculeStatus save(VehiculeStatus vehiculeStatus) {
        LOGGER.info("save VehiculeStatus");

        return VehicleStatusMapper.toDto(vehicleStatusRepository.saveAndFlush(VehicleStatusMapper.toEntity(vehiculeStatus, false)), false);
    }

    @Override
    public Long size() {
        return vehicleStatusRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleStatusRepository.exists(id);
    }

    @Override
    public VehiculeStatus findById(Long id) throws IdNotFound {
        VehiculeStatus vehiculeStatus = VehicleStatusMapper.toDto(vehicleStatusRepository.findOne(id), false);
        if (null != vehiculeStatus) {
            return vehiculeStatus;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<VehiculeStatus> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleStatusMapper.toDtos(vehicleStatusRepository.findAll(Search.expression(search,TmsVehicleStatus.class)), false);
    }

    @Override
    public List<VehiculeStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleStatusMapper.toDtos(vehicleStatusRepository.findAll(Search.expression(search, TmsVehicleStatus.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vehicleStatusRepository.count(Search.expression(search, TmsVehicleStatus.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save VehiculeStatus");
        vehicleStatusRepository.delete(id);
    }

    @Override
    public void delete(VehiculeStatus vehiculeStatus) {
        LOGGER.info("delete VehiculeStatus");
        vehicleStatusRepository.delete(VehicleStatusMapper.toEntity(vehiculeStatus, false));
    }

    @Override
    public List<VehiculeStatus> findAll() {
        return VehicleStatusMapper.toDtos(vehicleStatusRepository.findAll(), false);
    }

    @Override
    public List<VehiculeStatus> findAll(Pageable pageable) {
        return VehicleStatusMapper.toDtos(vehicleStatusRepository.findAll(pageable), false);
    }
}
