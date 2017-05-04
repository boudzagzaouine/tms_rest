package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Vehicule;
import com.sinno.ems.entities.TmsVehicle;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.VehicleMapper;
import com.sinno.ems.repositories.VehicleRepository;
import com.sinno.ems.service.VehicleService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);



    @Override
    public Vehicule save(Vehicule vehicule) {
        LOGGER.info("save Vehicle");

        return VehicleMapper.toDto(vehicleRepository.saveAndFlush(VehicleMapper.toEntity(vehicule, false)), false);
    }

    @Override
    public Long size() {
        return vehicleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleRepository.exists(id);
    }

    @Override
    public Vehicule findById(Long id) throws IdNotFound {
        Vehicule vehicule = VehicleMapper.toDto(vehicleRepository.findOne(id), false);
        if (null != vehicule) {
            return vehicule;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Vehicule> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, TmsVehicle.class)), false);
    }

    @Override
    public List<Vehicule> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, TmsVehicle.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vehicleRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Vehicle");
        vehicleRepository.delete(id);
    }

    @Override
    public void delete(Vehicule vehicule) {
        LOGGER.info("delete Vehicle");
        vehicleRepository.delete(VehicleMapper.toEntity(vehicule, false));
    }

    @Override
    public List<Vehicule> findAll() {
        return VehicleMapper.toDtos(vehicleRepository.findAll(), false);
    }

    @Override
    public List<Vehicule> findAll(Pageable pageable) {
        return VehicleMapper.toDtos(vehicleRepository.findAll(pageable), false);
    }
}
