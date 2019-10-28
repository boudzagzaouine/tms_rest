package com.bagile.tms.services.impl;

import com.bagile.tms.dto.MaintenancePlan;
import com.bagile.tms.entities.TmsMaintenancePlan;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.MaintenancePlanMapper;
import com.bagile.tms.repositories.MaintenancePlanRepository;
import com.bagile.tms.services.MaintenancePlanService;
import com.bagile.tms.util.EmsDate;
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
public class MaintenanceServiceImpl implements MaintenancePlanService {
    @Autowired
    private MaintenancePlanRepository maintenancePlanRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaintenancePlanService.class);

    @Override
    public MaintenancePlan save(MaintenancePlan maintenancePlan) {
        LOGGER.info("save Maintenance");
        maintenancePlan.setUpdateDate(EmsDate.getDateNow());
        if(0>=maintenancePlan.getId())
        {
            maintenancePlan.setCreationDate(EmsDate.getDateNow());
        }
        return MaintenancePlanMapper.toDto(maintenancePlanRepository.saveAndFlush(MaintenancePlanMapper.toEntity(maintenancePlan, false)), false);
    }

    @Override
    public Long size() {
        return maintenancePlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenancePlanRepository.existsById(id);
    }

    @Override
    public MaintenancePlan findById(Long id) throws IdNotFound {
        MaintenancePlan maintenancePlan = MaintenancePlanMapper.toDto(maintenancePlanRepository.findById(id).get(), false);
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
        LOGGER.info("delete Maintenance");
        maintenancePlanRepository.deleteById(id);
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
