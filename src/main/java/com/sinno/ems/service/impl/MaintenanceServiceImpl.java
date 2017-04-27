package com.sinno.ems.service.impl;

import com.sinno.ems.dto.MaintenancePlan;
import com.sinno.ems.entities.TmsMaintenancePlan;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.MaintenancePlanMapper;
import com.sinno.ems.repositories.MaintenancePlanRepository;
import com.sinno.ems.service.MaintenanceService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    private MaintenancePlanRepository maintenancePlanRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaintenanceService.class);
    @Override
    public MaintenancePlan save(MaintenancePlan maintenancePlan) {
        LOGGER.info("save Maintenance");
        return MaintenancePlanMapper.toDto(maintenancePlanRepository.saveAndFlush(MaintenancePlanMapper.toEntity(maintenancePlan, false)), false);
    }
    @Override
    public Long size() {
        return maintenancePlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenancePlanRepository.exists(id);
    }

    @Override
    public MaintenancePlan findById(Long id) throws IdNotFound {
        MaintenancePlan maintenancePlan = MaintenancePlanMapper.toDto(maintenancePlanRepository.findOne(id), false);
        if (null != maintenancePlan) {
            return maintenancePlan;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType {
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(Search.expression(search, TmsMaintenancePlan.class)), false);
    }

    @Override
    public List<MaintenancePlan> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(Search.expression(search, TmsMaintenancePlan.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return maintenancePlanRepository.count(Search.expression(search, TmsMaintenancePlan.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Maintenance");
        maintenancePlanRepository.delete(id);
    }

    @Override
    public void delete(MaintenancePlan maintenancePlan) {
        LOGGER.info("delete Maintenance");
        maintenancePlanRepository.delete(MaintenancePlanMapper.toEntity(maintenancePlan, false));
    }

    @Override
    public List<MaintenancePlan> findAll() {
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(), false);
    }
    @Override
    public List<MaintenancePlan> findAll(Pageable pageable) {
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(pageable), false);
    }
}
