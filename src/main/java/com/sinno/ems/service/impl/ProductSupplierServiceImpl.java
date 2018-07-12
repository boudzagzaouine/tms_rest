package com.sinno.ems.service.impl;

import com.sinno.ems.dto.ProductSupplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProductSupplierMapper;
import com.sinno.ems.repositories.ProductSupplierRepository;
import com.sinno.ems.service.ProductSupplierService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 24/01/2017.
 */
public class ProductSupplierServiceImpl implements ProductSupplierService{

    @Autowired
    private ProductSupplierRepository productSupplierRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductSupplierService.class);

    @Override
    public ProductSupplier save(ProductSupplier productSupplier) {
        LOGGER.info("save ProductSupplier");
        return ProductSupplierMapper.toDto(productSupplierRepository.saveAndFlush(ProductSupplierMapper.toEntity(productSupplier, false)), false);
    }

    @Override
    public Long size() {
        return productSupplierRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productSupplierRepository.exists(id);
    }

    @Override
    public ProductSupplier findById(Long id) throws IdNotFound {
        ProductSupplier productSupplier = ProductSupplierMapper.toDto(productSupplierRepository.findOne(id), false);
        if (null != productSupplier) {
            return productSupplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductSupplier> find(String search) throws AttributesNotFound, ErrorType {
        return ProductSupplierMapper.toDtos(productSupplierRepository.findAll(Search.expression(search, PdtProductSupplier.class)), false);
    }

    @Override
    public List<ProductSupplier> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ProductSupplierMapper.toDtos(productSupplierRepository.findAll(Search.expression(search, PdtProductSupplier.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productSupplierRepository.count(Search.expression(search, PdtProductSupplier.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductSupplier");
        productSupplierRepository.delete(id);
    }

    @Override
    public void delete(ProductSupplier productSupplier) {
        LOGGER.info("delete ProductSupplier");
        productSupplierRepository.delete(ProductSupplierMapper.toEntity(productSupplier, false));
    }

    @Override
    public List<ProductSupplier> findAll() {
        return ProductSupplierMapper.toDtos(productSupplierRepository.findAll(), false);
    }

    @Override
    public List<ProductSupplier> findAll(Pageable pageable) {
        return ProductSupplierMapper.toDtos(productSupplierRepository.findAll(pageable), false);
    }

}

