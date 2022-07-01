package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.VehicleProduct;
import com.bagile.gmo.entities.GmoVehicleProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VehicleProductMapper;
import com.bagile.gmo.repositories.VehicleProductRepository;
import com.bagile.gmo.services.VehicleProductService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleProductServiceImpl implements VehicleProductService {
    
    private final VehicleProductRepository vehicleProductRepository;

    public VehicleProductServiceImpl(VehicleProductRepository vehicleProductRepository) {
        this.vehicleProductRepository = vehicleProductRepository;
    }

    @Override
    public VehicleProduct save(VehicleProduct vehicleProduct) {
        return VehicleProductMapper.toDto(vehicleProductRepository.saveAndFlush(VehicleProductMapper.toEntity(vehicleProduct, false)), false);
    }

    @Override
    public Long size() {
        return vehicleProductRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleProductRepository.existsById(id);
    }

    @Override
    public VehicleProduct findById(Long id) throws IdNotFound {
        return VehicleProductMapper.toDto(vehicleProductRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VehicleProduct> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleProductMapper.toDtos(vehicleProductRepository.findAll(Search.expression(search, GmoVehicleProduct.class)), false);
    }

    @Override
    public List<VehicleProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleProductMapper.toDtos(vehicleProductRepository.findAll(Search.expression(search, GmoVehicleProduct.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleProductRepository.count(Search.expression(search, GmoVehicleProduct.class));
    }

    @Override
    public void delete(Long id) {
        vehicleProductRepository.deleteById(id);
    }

    @Override
    public void delete(VehicleProduct vehicleProduct) {
        vehicleProductRepository.delete(VehicleProductMapper.toEntity(vehicleProduct, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            vehicleProductRepository.deleteById(id);        }
    }


    @Override
    public List<VehicleProduct> findAll() {
        return VehicleProductMapper.toDtos(vehicleProductRepository.findAll(), false);
    }

    @Override
    public List<VehicleProduct> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleProductMapper.toDtos(vehicleProductRepository.findAll(pageable), false);
    }

    @Override
    public VehicleProduct findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

