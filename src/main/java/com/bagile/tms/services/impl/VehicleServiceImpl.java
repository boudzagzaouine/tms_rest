package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleMapper;
import com.bagile.tms.repositories.VehicleRepository;
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
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);

    @Override
    public Vehicle save(Vehicle vehicle) {
        LOGGER.info("save Vehicle");

        return VehicleMapper.toDto
                (vehicleRepository.saveAndFlush(VehicleMapper.toEntity(vehicle , false)), false);
    }

    @Override
    public Long size() {
        return vehicleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleRepository.existsById(id);
    }

    @Override
    public Vehicle findById(Long id) throws IdNotFound {
        Vehicle vehicle = VehicleMapper.toDto(vehicleRepository.findById(id).get(), false);
        if (null != vehicle) {
            return vehicle;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Vehicle> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, TmsVehicle.class)), false);
    }

    @Override
    public List<Vehicle> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, TmsVehicle.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vehicleRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Vehicle");
        vehicleRepository.deleteById(id);
    }

    @Override
    public void delete(Vehicle vehicle) {
        LOGGER.info("delete Vehicle");
        vehicleRepository.delete(VehicleMapper.toEntity(vehicle, false));
    }

    @Override
    public List<Vehicle> findAll() {
        return VehicleMapper.toDtos(vehicleRepository.findAll(), false);
    }

    @Override
    public List<Vehicle> findAll(Pageable pageable) {
        return VehicleMapper.toDtos(vehicleRepository.findAll(pageable), false);
    }
}
