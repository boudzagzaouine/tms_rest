package com.bagile.tms.services.impl;

import com.sinno.ems.dto.ProductDimension;
import com.sinno.ems.entities.PdtProductDimension;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProductDimensionMapper;
import com.sinno.ems.repositories.ProductDimensionRepository;
import com.sinno.ems.service.ProductDimensionService;
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
 * Created by Enissay on 15/03/2017.
 */
@Service
public class ProductDimensionServiceImpl implements ProductDimensionService{
    @Autowired
    private ProductDimensionRepository productDimensionRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductDimensionService.class);

    @Override
    public ProductDimension save(ProductDimension productDimension) {
        LOGGER.info("save ProductDimension");
        productDimension.setUpdateDate(EmsDate.getDateNow());
        if (0 >= productDimension.getId()) {
            productDimension.setCreationDate(EmsDate.getDateNow());
        }
        return ProductDimensionMapper.toDto(productDimensionRepository.saveAndFlush(ProductDimensionMapper.toEntity(productDimension, false)), false);
    }

    @Override
    public Long size() {
        return productDimensionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productDimensionRepository.exists(id);
    }

    @Override
    public ProductDimension findById(Long id) throws IdNotFound {
        ProductDimension productDimension = ProductDimensionMapper.toDto(productDimensionRepository.findOne(id), false);
        if (null != productDimension) {
            return productDimension;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductDimension> find(String search) throws AttributesNotFound, ErrorType {
        return ProductDimensionMapper.toDtos(productDimensionRepository.findAll(Search.expression(search, PdtProductDimension.class)), false);
    }

    @Override
    public List<ProductDimension> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProductDimensionUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ProductDimensionMapper.toDtos(productDimensionRepository.findAll(Search.expression(search, PdtProductDimension.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productDimensionRepository.count(Search.expression(search, PdtProductDimension.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductDimension");
        productDimensionRepository.delete(id);
    }

    @Override
    public void delete(ProductDimension productDimension) {
        LOGGER.info("delete ProductDimension");
        productDimensionRepository.delete(ProductDimensionMapper.toEntity(productDimension, false));
    }

    @Override
    public List<ProductDimension> findAll() {
        return ProductDimensionMapper.toDtos(productDimensionRepository.findAll(), false);
    }

    @Override
    public List<ProductDimension> findAll(Pageable pageable) {
        return ProductDimensionMapper.toDtos(productDimensionRepository.findAll(pageable), false);
    }
}
