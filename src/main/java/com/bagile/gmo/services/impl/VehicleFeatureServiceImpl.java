package com.bagile.tms.services.impl;

import com.bagile.gmo.dto.VehicleFeature;
import com.bagile.gmo.entities.TmsVehicleFeature;
import com.bagile.gmo.mapper.VehicleFeatureMapper;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.repositories.VehicleFeatureRepository;
import com.bagile.tms.services.VehicleFeatureService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class VehicleFeatureServiceImpl implements VehicleFeatureService {
    private final VehicleFeatureRepository vehicleFeatureRepository;
    public VehicleFeatureServiceImpl(VehicleFeatureRepository vehicleFeatureRepository) {
        this.vehicleFeatureRepository = vehicleFeatureRepository;
    }

    @Override
    public VehicleFeature save(VehicleFeature vehicleFeature) {
        return VehicleFeatureMapper.toDto(vehicleFeatureRepository .saveAndFlush(VehicleFeatureMapper.toEntity(vehicleFeature, false)), false);
    }

    @Override
    public Long size() {
        return vehicleFeatureRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleFeatureRepository.existsById(id);
    }

    @Override
    public VehicleFeature findById(Long id) throws IdNotFound {
        return VehicleFeatureMapper.toDto(vehicleFeatureRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VehicleFeature> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleFeatureMapper.toDtos(vehicleFeatureRepository.findAll(Search.expression(search, TmsVehicleFeature.class)), false);
    }

    @Override
    public List<VehicleFeature> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleFeatureMapper.toDtos(vehicleFeatureRepository.findAll(Search.expression(search, TmsVehicleFeature.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleFeatureRepository.count(Search.expression(search, TmsVehicleFeature.class));
    }

    @Override
    public void delete(Long id) {
        vehicleFeatureRepository.deleteById(id);
    }

    @Override
    public void delete(VehicleFeature vehicleFeature) {
        vehicleFeatureRepository.delete(VehicleFeatureMapper.toEntity(vehicleFeature, false));
    }

    @Override
    public List<VehicleFeature> findAll() {
        return VehicleFeatureMapper.toDtos(vehicleFeatureRepository.findAll(), false);
    }

    @Override
    public List<VehicleFeature> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleFeatureMapper.toDtos(vehicleFeatureRepository.findAll(pageable), false);
    }

}

