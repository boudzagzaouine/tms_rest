package com.bagile.gmo.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.entities.GmoVehicle;
import com.bagile.gmo.mapper.VehicleMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.VehicleRepository;
import com.bagile.gmo.services.VehicleService;
import com.bagile.gmo.util.Search;

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
        if (search.equals("")){
            return findAll ();
        }
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, GmoVehicle.class)), false);
    }

    @Override
    public List<Vehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, GmoVehicle.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleRepository.count(Search.expression(search, GmoVehicle.class));
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
        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);

        return VehicleMapper.toDtos(vehicleRepository.findAll(pageable), false);
    }
}
