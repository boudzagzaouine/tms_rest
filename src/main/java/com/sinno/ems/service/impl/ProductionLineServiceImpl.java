package com.sinno.ems.service.impl;

import com.sinno.ems.dto.ProductionLine;
import com.sinno.ems.entities.PrcProductionLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProductionLineMapper;
import com.sinno.ems.repositories.ProductionLineRepository;
import com.sinno.ems.service.AgencyService;
import com.sinno.ems.service.ProductionLineService;
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
public class ProductionLineServiceImpl implements ProductionLineService {

    @Autowired
    private ProductionLineRepository productionLineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AgencyService.class);
    @Override
    public ProductionLine save(ProductionLine productionLine) {
        LOGGER.info("save ProductionLine");
      
        return ProductionLineMapper.toDto(productionLineRepository.saveAndFlush(ProductionLineMapper.toEntity(productionLine, false)), false);
    }

    @Override
    public Long size() {
        return productionLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productionLineRepository.exists(id);
    }

    @Override
    public ProductionLine findById(Long id) throws IdNotFound {
        ProductionLine productionLine = ProductionLineMapper.toDto(productionLineRepository.findOne(id), false);
        if (null != productionLine) {
            return productionLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductionLine> find(String search) throws AttributesNotFound, ErrorType {
        return ProductionLineMapper.toDtos(productionLineRepository.findAll(Search.expression(search, PrcProductionLine.class)), false);
    }

    @Override
    public List<ProductionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProductionUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return ProductionLineMapper.toDtos(productionLineRepository.findAll(Search.expression(search, PrcProductionLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productionLineRepository.count(Search.expression(search, PrcProductionLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductionLine");
        productionLineRepository.delete(id);
    }

    @Override
    public void delete(ProductionLine productionLine) {
        LOGGER.info("delete ProductionLine");
        productionLineRepository.delete(ProductionLineMapper.toEntity(productionLine, false));
    }

    @Override
    public List<ProductionLine> findAll() {
        return ProductionLineMapper.toDtos(productionLineRepository.findAll(), false);
    }

    @Override
    public List<ProductionLine> findAll(Pageable pageable) {
        return ProductionLineMapper.toDtos(productionLineRepository.findAll(pageable), false);
    }
}
