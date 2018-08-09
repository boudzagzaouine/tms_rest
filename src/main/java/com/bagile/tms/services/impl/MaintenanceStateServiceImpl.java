package com.bagile.tms.services.impl;

import com.bagile.tms.dto.MaintenanceState;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.MaintenanceStateMapper;
import com.bagile.tms.repositories.MaintenanceStateRepository;
import com.bagile.tms.services.MaintenanceStateService;
import com.bagile.tms.services.VehicleService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaintenanceStateServiceImpl implements MaintenanceStateService {

    @Autowired
    private MaintenanceStateRepository maintenanceStateRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);

    @Override
    public MaintenanceState save(MaintenanceState maintenanceState) {
        LOGGER.info("save MaintenanceState");

        return MaintenanceStateMapper.toDto(maintenanceStateRepository.saveAndFlush(MaintenanceStateMapper.toEntity(maintenanceState, false)), false);
    }

    @Override
    public Long size() {
        return maintenanceStateRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceStateRepository.existsById(id);
    }

    @Override
    public MaintenanceState findById(Long id) throws IdNotFound {
        MaintenanceState maintenanceState = MaintenanceStateMapper.toDto(maintenanceStateRepository.findById(id).get(), false);
        if (null != maintenanceState) {
            return maintenanceState;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<MaintenanceState> find(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(Search.expression(search, TmsVehicle.class)), false);
    }

    @Override
    public List<MaintenanceState> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(Search.expression(search, TmsVehicle.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return maintenanceStateRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete MaintenanceState");
        maintenanceStateRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceState maintenanceState) {
        LOGGER.info("delete MaintenanceState");
        maintenanceStateRepository.delete(MaintenanceStateMapper.toEntity(maintenanceState, false));
    }

    @Override
    public List<MaintenanceState> findAll() {
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(), false);
    }

    @Override
    public List<MaintenanceState> findAll(Pageable pageable) {
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(pageable), false);
    }
}
