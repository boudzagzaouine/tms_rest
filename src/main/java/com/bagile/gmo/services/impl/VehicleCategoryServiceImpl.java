package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.gmo.entities.GmoVehicleCategory;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VehicleCategoryMapper;
import com.bagile.gmo.repositories.VehicleCategoryRepository;
import com.bagile.gmo.services.VehicleCategoryService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    private final VehicleCategoryRepository VehicleCategoryRepository;

    public VehicleCategoryServiceImpl(VehicleCategoryRepository VehicleCategoryRepository) {
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
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(Search.expression(search, GmoVehicleCategory.class)), false);
    }

    @Override
    public List<VehicleCategory> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(Search.expression(search, GmoVehicleCategory.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return VehicleCategoryRepository.count(Search.expression(search, GmoVehicleCategory.class));
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
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            VehicleCategoryRepository.deleteById(id);        }
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
