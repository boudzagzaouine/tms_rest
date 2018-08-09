package com.bagile.tms.services.impl;

import com.bagile.tms.dto.TypeMaintenance;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.TypeMaintenanceMapper;
import com.bagile.tms.repositories.TypeMaintenanceRepository;
import com.bagile.tms.services.TypeMaintenanceService;
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
public class TypeMaintenanceServiceImpl implements TypeMaintenanceService {

    @Autowired
    private TypeMaintenanceRepository typeMaintenanceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);

    @Override
    public TypeMaintenance save(TypeMaintenance typeMaintenance) {
        LOGGER.info("save TypeMaintenance");

        return TypeMaintenanceMapper.toDto(typeMaintenanceRepository.saveAndFlush(TypeMaintenanceMapper.toEntity(typeMaintenance)));
    }

    @Override
    public Long size() {
        return typeMaintenanceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return typeMaintenanceRepository.existsById(id);
    }

    @Override
    public TypeMaintenance findById(Long id) throws IdNotFound {
        TypeMaintenance typeMaintenance = TypeMaintenanceMapper.toDto(typeMaintenanceRepository.findById(id).get());
        if (null != typeMaintenance) {
            return typeMaintenance;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<TypeMaintenance> find(String search) throws AttributesNotFound, ErrorType {
        return TypeMaintenanceMapper.toDtos(typeMaintenanceRepository.findAll(Search.expression(search, TmsVehicle.class)));
    }

    @Override
    public List<TypeMaintenance> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return TypeMaintenanceMapper.toDtos(typeMaintenanceRepository.findAll(Search.expression(search, TmsVehicle.class),pageable));
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return typeMaintenanceRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete TypeMaintenance");
        typeMaintenanceRepository.deleteById(id);
    }

    @Override
    public void delete(TypeMaintenance typeMaintenance) {
        LOGGER.info("delete TypeMaintenance");
        typeMaintenanceRepository.delete(TypeMaintenanceMapper.toEntity(typeMaintenance));
    }

    @Override
    public List<TypeMaintenance> findAll() {
        return TypeMaintenanceMapper.toDtos(typeMaintenanceRepository.findAll());
    }

    @Override
    public List<TypeMaintenance> findAll(Pageable pageable) {
        return TypeMaintenanceMapper.toDtos(typeMaintenanceRepository.findAll(pageable));
    }
}
