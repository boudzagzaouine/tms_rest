package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.MaintenanceProduct;
import com.bagile.gmo.entities.GmoMaintenanceProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceProductMapper;
import com.bagile.gmo.repositories.MaintenanceProductRepository;
import com.bagile.gmo.services.MaintenanceProductService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MaintenanceProductServiceImpl implements MaintenanceProductService {

    private final MaintenanceProductRepository maintenanceProductRepository;

    public MaintenanceProductServiceImpl(MaintenanceProductRepository maintenanceProductRepository) {
        this.maintenanceProductRepository = maintenanceProductRepository;
    }

    @Override
    public MaintenanceProduct save(MaintenanceProduct maintenanceProduct) {
        return MaintenanceProductMapper.toDto(maintenanceProductRepository.save(MaintenanceProductMapper.toEntity(maintenanceProduct, false)), false);
    }

    @Override
    public Long size() {
        return maintenanceProductRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceProductRepository.existsById(id);
    }

    @Override
    public MaintenanceProduct findById(Long id) throws IdNotFound {
        return MaintenanceProductMapper.toDto(maintenanceProductRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<MaintenanceProduct> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenanceProductMapper.toDtos(maintenanceProductRepository.findAll(Search.expression(search, GmoMaintenanceProduct.class)), false);
    }

    @Override
    public List<MaintenanceProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceProductMapper.toDtos(maintenanceProductRepository.findAll(Search.expression(search, GmoMaintenanceProduct.class), pageable), false);
    }

    @Override
    public MaintenanceProduct findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceProductMapper.toDto (maintenanceProductRepository.findOne (Search.expression (search, GmoMaintenanceProduct.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenanceProductRepository.count(Search.expression(search, GmoMaintenanceProduct.class));
    }

    @Override
    public void delete(Long id) {
        maintenanceProductRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceProduct maintenanceProduct) {
        maintenanceProductRepository.delete(MaintenanceProductMapper.toEntity(maintenanceProduct, false));
    }

    @Override
    public List<MaintenanceProduct> findAll() {
        return MaintenanceProductMapper.toDtos(maintenanceProductRepository.findAll(), false);
    }

    @Override
    public List<MaintenanceProduct> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceProductMapper.toDtos(maintenanceProductRepository.findAll(pageable), false);
    }



}

