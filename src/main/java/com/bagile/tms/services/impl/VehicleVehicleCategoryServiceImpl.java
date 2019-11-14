package com.bagile.tms.services.impl;

import com.bagile.tms.dto.VehicleCategory;
import com.bagile.tms.entities.TmsVehicleCategory;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleCategoryMapper;
import com.bagile.tms.repositories.VehicleCategoryRepository;
import com.bagile.tms.services.VehicleCategoryService;
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
public class VehicleVehicleCategoryServiceImpl implements VehicleCategoryService {


    private final VehicleCategoryRepository VehicleCategoryRepository;

    public VehicleVehicleCategoryServiceImpl(VehicleCategoryRepository VehicleCategoryRepository) {
        this.VehicleCategoryRepository = VehicleCategoryRepository;
    }

    @Override
    public VehicleCategory save(VehicleCategory VehicleCategory) {
        return VehicleCategoryMapper.toDto(VehicleCategoryRepository.saveAndFlush(VehicleCategoryMapper.toEntity(VehicleCategory, false)), false);
    }

    @Override
    public Long size() {
        return VehicleCategoryRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return VehicleCategoryRepository.existsById(id);
    }

    @Override
    public VehicleCategory findById(Long id) throws IdNotFound {
        return VehicleCategoryMapper.toDto(VehicleCategoryRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VehicleCategory> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(Search.expression(search, TmsVehicleCategory.class)), false);
    }

    @Override
    public List<VehicleCategory> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(Search.expression(search, TmsVehicleCategory.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return VehicleCategoryRepository.count(Search.expression(search, TmsVehicleCategory.class));
    }

    @Override
    public void delete(Long id) {
        VehicleCategoryRepository.deleteById(id);
    }

    @Override
    public void delete(VehicleCategory VehicleCategory) {
        VehicleCategoryRepository.delete(VehicleCategoryMapper.toEntity(VehicleCategory, false));
    }

    @Override
    public List<VehicleCategory> findAll() {
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(), false);
    }

    @Override
    public List<VehicleCategory> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(pageable), false);
    }


}
