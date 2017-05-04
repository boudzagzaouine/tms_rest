package com.sinno.ems.service.impl;

import com.sinno.ems.dto.WarrantyPeriod;
import com.sinno.ems.entities.PdtUom;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.WarrantyPeriodMapper;
import com.sinno.ems.repositories.WarrantyPeriodRepository;
import com.sinno.ems.service.UomService;
import com.sinno.ems.service.WarrantyPeriodService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 15/12/2016.
 */
@Service
public class WarrantyPeriodServiceImpl implements WarrantyPeriodService{
    @Autowired
    private WarrantyPeriodRepository warrantyPeriodRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UomService.class);

    @Override
    public WarrantyPeriod save(WarrantyPeriod warrantyPeriod) {
        LOGGER.info("save warranty Period");
        warrantyPeriod.setUpdateDate(EmsDate.getDateNow());
        if (0 >= warrantyPeriod.getId()) {
            warrantyPeriod.setCreationDate(EmsDate.getDateNow());
        }
        return WarrantyPeriodMapper.toDto(warrantyPeriodRepository.saveAndFlush(WarrantyPeriodMapper.toEntity(warrantyPeriod, false)), false);
    }

    @Override
    public Long size() {
        return warrantyPeriodRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return warrantyPeriodRepository.exists(id);
    }

    @Override
    public WarrantyPeriod findById(Long id) throws IdNotFound {
        WarrantyPeriod warrantyPeriod = WarrantyPeriodMapper.toDto(warrantyPeriodRepository.findOne(id), false);
        if (null != warrantyPeriod) {
            return warrantyPeriod;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<WarrantyPeriod> find(String search) throws AttributesNotFound, ErrorType {
        return WarrantyPeriodMapper.toDtos(warrantyPeriodRepository.findAll(Search.expression(search, PdtUom.class)), false);
    }

    @Override
    public List<WarrantyPeriod> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"pdtUomUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return WarrantyPeriodMapper.toDtos(warrantyPeriodRepository.findAll(Search.expression(search, PdtUom.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return warrantyPeriodRepository.count(Search.expression(search, PdtUom.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete warranty Period");
        warrantyPeriodRepository.delete(id);
    }

    @Override
    public void delete(WarrantyPeriod warrantyPeriod) {
        LOGGER.info("delete warranty Period");
        warrantyPeriodRepository.delete(WarrantyPeriodMapper.toEntity(warrantyPeriod, false));
    }

    @Override
    public List<WarrantyPeriod> findAll() {
        return WarrantyPeriodMapper.toDtos(warrantyPeriodRepository.findAll(), false);
    }

    @Override
    public List<WarrantyPeriod> findAll(Pageable pageable) {
        return WarrantyPeriodMapper.toDtos(warrantyPeriodRepository.findAll(pageable), false);
    }

}
