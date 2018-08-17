package com.bagile.tms.services.impl;

import com.bagile.tms.dto.VehicleCategory;
import com.bagile.tms.entities.TmsVehicleCategory;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleCategoryMapper;
import com.bagile.tms.repositories.CategoryRepository;
import com.bagile.tms.services.VehicleCategoryService;
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
public class VehicleVehicleCategoryServiceImpl implements VehicleCategoryService {


    @Autowired
    private CategoryRepository CategoryRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleCategoryService.class);
    @Override
    public VehicleCategory save(VehicleCategory VehicleCategory) {
        LOGGER.info("save VehicleCategory");


        return VehicleCategoryMapper.toDto(CategoryRepository.saveAndFlush(VehicleCategoryMapper.toEntity(VehicleCategory, false)), false);
    }

    @Override
    public Long size() {
        return CategoryRepository.count();
    }
    @Override
    public Boolean isExist(Long id) {
        return CategoryRepository.existsById(id);
    }
    @Override
    public VehicleCategory findById(Long id) throws IdNotFound {
        VehicleCategory VehicleCategory = VehicleCategoryMapper.toDto(CategoryRepository.findById(id).get(), false);
        if (null != VehicleCategory) {
            return VehicleCategory;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<VehicleCategory> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleCategoryMapper.toDtos(CategoryRepository.findAll(Search.expression(search, TmsVehicleCategory.class)), false);
    }
    @Override
    public List<VehicleCategory> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleCategoryMapper.toDtos(CategoryRepository.findAll(Search.expression(search, TmsVehicleCategory.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return CategoryRepository.count(Search.expression(search, TmsVehicleCategory.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save VehicleCategory");
        CategoryRepository.deleteById(id);
    }
    @Override
    public void delete(VehicleCategory VehicleCategory) {
        LOGGER.info("delete VehicleCategory");
        CategoryRepository.delete(VehicleCategoryMapper.toEntity(VehicleCategory, false));
    }
    @Override
    public List<VehicleCategory> findAll() {
        return VehicleCategoryMapper.toDtos(CategoryRepository.findAll(), false);
    }
    @Override
    public List<VehicleCategory> findAll(Pageable pageable) {
        return VehicleCategoryMapper.toDtos(CategoryRepository.findAll(pageable), false);
    }



}
