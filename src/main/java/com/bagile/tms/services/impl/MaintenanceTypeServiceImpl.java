package com.bagile.tms.services.impl;

import com.bagile.tms.dto.MaintenanceType;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.MaintenanceTypeMapper;
import com.bagile.tms.repositories.MaintenanceTypeRepository;
import com.bagile.tms.services.MaintenanceTypeService;
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
public class MaintenanceTypeServiceImpl implements MaintenanceTypeService {

    @Autowired
    private MaintenanceTypeRepository MaintenancetypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);

    @Override
    public MaintenanceType save(MaintenanceType maintenancetype) {
        LOGGER.info("save TypeMaintenance");

        return MaintenanceTypeMapper.toDto(MaintenancetypeRepository.saveAndFlush(MaintenanceTypeMapper.toEntity(maintenancetype,false)),false);
    }

    @Override
    public Long size() {
        return MaintenancetypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return MaintenancetypeRepository.existsById(id);
    }

    @Override
    public MaintenanceType findById(Long id) throws IdNotFound {
        MaintenanceType typeMaintenance = MaintenanceTypeMapper.toDto(MaintenancetypeRepository.findById(id).get(),false);
        if (null != typeMaintenance) {
            return typeMaintenance;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<MaintenanceType> find(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll(Search.expression(search, TmsVehicle.class)));
    }

    @Override
    public List<MaintenanceType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll(Search.expression(search, TmsVehicle.class),pageable));
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return MaintenancetypeRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete TypeMaintenance");
        MaintenancetypeRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceType maintenancetype) {
        LOGGER.info("delete TypeMaintenance");
        MaintenancetypeRepository.delete(MaintenanceTypeMapper.toEntity(maintenancetype,true));
    }

    @Override
    public List<MaintenanceType> findAll() {
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll());
    }

    @Override
    public List<MaintenanceType> findAll(Pageable pageable) {
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll(pageable));
    }
}
