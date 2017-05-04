package com.sinno.ems.service.impl;

import com.sinno.ems.dto.ProductForm;
import com.sinno.ems.dto.ProductForm;
import com.sinno.ems.entities.PdtProductForm;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProductFormMapper;
import com.sinno.ems.repositories.ProductFormRepository;
import com.sinno.ems.service.ProductFormService;
import com.sinno.ems.service.ProductFormService;
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
 * Created by Enissay on 13/03/2017.
 */
@Service
public class ProductFormServiceImpl implements ProductFormService {

    @Autowired
    private ProductFormRepository productFormRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductFormService.class);

    @Override
    public ProductForm save(ProductForm productForm) {
        LOGGER.info("save ProductForm");
        productForm.setUpdateDate(EmsDate.getDateNow());
        if (0 >= productForm.getId()) {
            productForm.setCreationDate(EmsDate.getDateNow());
        }
        return ProductFormMapper.toDto(productFormRepository.saveAndFlush(ProductFormMapper.toEntity(productForm, false)), false);
    }

    @Override
    public Long size() {
        return productFormRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productFormRepository.exists(id);
    }

    @Override
    public ProductForm findById(Long id) throws IdNotFound {
        ProductForm productForm = ProductFormMapper.toDto(productFormRepository.findOne(id), false);
        if (null != productForm) {
            return productForm;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductForm> find(String search) throws AttributesNotFound, ErrorType {
        return ProductFormMapper.toDtos(productFormRepository.findAll(Search.expression(search, PdtProductForm.class)), false);
    }

    @Override
    public List<ProductForm> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProductFormUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ProductFormMapper.toDtos(productFormRepository.findAll(Search.expression(search, PdtProductForm.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productFormRepository.count(Search.expression(search, PdtProductForm.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductForm");
        productFormRepository.delete(id);
    }

    @Override
    public void delete(ProductForm productForm) {
        LOGGER.info("delete ProductForm");
        productFormRepository.delete(ProductFormMapper.toEntity(productForm, false));
    }

    @Override
    public List<ProductForm> findAll() {
        return ProductFormMapper.toDtos(productFormRepository.findAll(), false);
    }

    @Override
    public List<ProductForm> findAll(Pageable pageable) {
        return ProductFormMapper.toDtos(productFormRepository.findAll(pageable), false);
    }
}
