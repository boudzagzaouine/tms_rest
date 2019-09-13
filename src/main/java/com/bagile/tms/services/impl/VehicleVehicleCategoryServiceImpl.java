package com.bagile.tms.services.impl;

import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleCategoryMapper;
import com.bagile.tms.repositories.VehicleCategoryRepository;
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
    private VehicleCategoryRepository VehicleCategoryRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleCategoryService.class);
    @Override
    public VehicleCategory save(VehicleCategory VehicleCategory) {
        LOGGER.info("save VehicleCategory");


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
        VehicleCategory VehicleCategory = VehicleCategoryMapper.toDto(VehicleCategoryRepository.findById(id).get(), false);
        if (null != VehicleCategory) {
            return VehicleCategory;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<VehicleCategory> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(Search.expression(search, TmsVehicleCategory.class)), false);
    }
    @Override
    public List<VehicleCategory> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(Search.expression(search, TmsVehicleCategory.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return VehicleCategoryRepository.count(Search.expression(search, TmsVehicleCategory.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save VehicleCategory");
        VehicleCategoryRepository.deleteById(id);
    }
    @Override
    public void delete(VehicleCategory VehicleCategory) {
        LOGGER.info("delete VehicleCategory");
        VehicleCategoryRepository.delete(VehicleCategoryMapper.toEntity(VehicleCategory, false));
    }
    @Override
    public List<VehicleCategory> findAll() {
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(), false);
    }
    @Override
    public List<VehicleCategory> findAll(Pageable pageable) {
        return VehicleCategoryMapper.toDtos(VehicleCategoryRepository.findAll(pageable), false);
    }



}
