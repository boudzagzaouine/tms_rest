package com.sinno.ems.service.impl;

import com.sinno.ems.dto.VehiculeType;
import com.sinno.ems.entities.PrmVehicleType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.VehicleTypeMapper;
import com.sinno.ems.repositories.VehicleTypeRepository;
import com.sinno.ems.service.VehicleTypeService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * Created by bouzi on 4/4/2017.
 */
public class VehicleTypeServiceImpl implements VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleTypeService.class);



    @Override
    public VehiculeType save(VehiculeType vehiculeType) {
        LOGGER.info("save VehiculeType");

        return VehicleTypeMapper.toDto(vehicleTypeRepository.saveAndFlush(VehicleTypeMapper.toEntity(vehiculeType, false)), false);
    }

    @Override
    public Long size() {
        return vehicleTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleTypeRepository.exists(id);
    }

    @Override
    public VehiculeType findById(Long id) throws IdNotFound {
        VehiculeType vehiculeType = VehicleTypeMapper.toDto(vehicleTypeRepository.findOne(id), false);
        if (null != vehiculeType) {
            return vehiculeType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<VehiculeType> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(Search.expression(search, PrmVehicleType.class)), false);
    }

    @Override
    public List<VehiculeType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(Search.expression(search, PrmVehicleType.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vehicleTypeRepository.count(Search.expression(search, PrmVehicleType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save VehiculeType");
        vehicleTypeRepository.delete(id);
    }

    @Override
    public void delete(VehiculeType vehiculeType) {
        LOGGER.info("delete VehiculeType");
        vehicleTypeRepository.delete(VehicleTypeMapper.toEntity(vehiculeType, false));
    }

    @Override
    public List<VehiculeType> findAll() {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(), false);
    }

    @Override
    public List<VehiculeType> findAll(Pageable pageable) {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(pageable), false);
    }
}
