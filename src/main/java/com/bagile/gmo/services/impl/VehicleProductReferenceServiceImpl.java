package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.VehicleProductReference;
import com.bagile.gmo.entities.GmoVehicleProductReference;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VehicleProductReferenceMapper;
import com.bagile.gmo.repositories.VehicleProductReferenceRepository;
import com.bagile.gmo.services.VehicleProductReferenceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleProductReferenceServiceImpl implements VehicleProductReferenceService {
    
    private final VehicleProductReferenceRepository vehicleProductReferenceRepository;

    public VehicleProductReferenceServiceImpl(VehicleProductReferenceRepository vehicleProductReferenceRepository) {
        this.vehicleProductReferenceRepository = vehicleProductReferenceRepository;
    }

    @Override
    public VehicleProductReference save(VehicleProductReference vehicleProductReference) {
        return VehicleProductReferenceMapper.toDto(vehicleProductReferenceRepository.saveAndFlush(VehicleProductReferenceMapper.toEntity(vehicleProductReference, false)), false);
    }

    @Override
    public Long size() {
        return vehicleProductReferenceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleProductReferenceRepository.existsById(id);
    }

    @Override
    public VehicleProductReference findById(Long id) throws IdNotFound {
        return VehicleProductReferenceMapper.toDto(vehicleProductReferenceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VehicleProductReference> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleProductReferenceMapper.toDtos(vehicleProductReferenceRepository.findAll(Search.expression(search, GmoVehicleProductReference.class)), false);
    }

    @Override
    public List<VehicleProductReference> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleProductReferenceMapper.toDtos(vehicleProductReferenceRepository.findAll(Search.expression(search, GmoVehicleProductReference.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleProductReferenceRepository.count(Search.expression(search, GmoVehicleProductReference.class));
    }

    @Override
    public void delete(Long id) {
        vehicleProductReferenceRepository.deleteById(id);
    }

    @Override
    public void delete(VehicleProductReference vehicleProductReference) {
        vehicleProductReferenceRepository.delete(VehicleProductReferenceMapper.toEntity(vehicleProductReference, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            vehicleProductReferenceRepository.deleteById(id);        }
    }


    @Override
    public List<VehicleProductReference> findAll() {
        return VehicleProductReferenceMapper.toDtos(vehicleProductReferenceRepository.findAll(), false);
    }

    @Override
    public List<VehicleProductReference> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleProductReferenceMapper.toDtos(vehicleProductReferenceRepository.findAll(pageable), false);
    }

    @Override
    public VehicleProductReference findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

