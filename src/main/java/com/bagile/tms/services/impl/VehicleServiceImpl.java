package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleMapper;
import com.bagile.tms.repositories.VehicleRepository;
import com.bagile.tms.services.VehicleService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return VehicleMapper.toDto
                (vehicleRepository.saveAndFlush(VehicleMapper.toEntity(vehicle, false)), false);
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
        return VehicleMapper.toDto(vehicleRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Vehicle> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, TmsVehicle.class)), false);
    }

    @Override
    public List<Vehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, TmsVehicle.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vehicleRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(VehicleMapper.toEntity(vehicle, false));
    }

    @Override
    public List<Vehicle> findAll() {
        return VehicleMapper.toDtos(vehicleRepository.findAll(), false);
    }

    @Override
    public List<Vehicle> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return VehicleMapper.toDtos(vehicleRepository.findAll(pageable), false);
    }
}
