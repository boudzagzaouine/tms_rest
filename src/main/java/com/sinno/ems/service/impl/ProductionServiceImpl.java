package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Production;
import com.sinno.ems.entities.PrcProduction;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProductionMapper;
import com.sinno.ems.repositories.ProductionRepository;
import com.sinno.ems.service.AgencyService;
import com.sinno.ems.service.ProductionService;
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
 * Created by Enissay on 03/04/2017.
 */
@Service
public class ProductionServiceImpl implements ProductionService { @Autowired
private ProductionRepository productionRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AgencyService.class);
    @Override
    public Production save(Production production) {
        LOGGER.info("save Production");

        return ProductionMapper.toDto(productionRepository.saveAndFlush(ProductionMapper.toEntity(production, false)), false);
    }

    @Override
    public Long size() {
        return productionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productionRepository.exists(id);
    }

    @Override
    public Production findById(Long id) throws IdNotFound {
        Production production = ProductionMapper.toDto(productionRepository.findOne(id), false);
        if (null != production) {
            return production;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Production> find(String search) throws AttributesNotFound, ErrorType {
        return ProductionMapper.toDtos(productionRepository.findAll(Search.expression(search, PrcProduction.class)), false);
    }

    @Override
    public List<Production> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prcProductionUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return ProductionMapper.toDtos(productionRepository.findAll(Search.expression(search, PrcProduction.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productionRepository.count(Search.expression(search, PrcProduction.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Production");
        productionRepository.delete(id);
    }

    @Override
    public void delete(Production production) {
        LOGGER.info("delete Production");
        productionRepository.delete(ProductionMapper.toEntity(production, false));
    }

    @Override
    public List<Production> findAll() {
        return ProductionMapper.toDtos(productionRepository.findAll(), false);
    }

    @Override
    public List<Production> findAll(Pageable pageable) {
        return ProductionMapper.toDtos(productionRepository.findAll(pageable), false);
    }
}
