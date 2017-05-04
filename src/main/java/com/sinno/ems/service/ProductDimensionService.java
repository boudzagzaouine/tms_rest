package com.sinno.ems.service;

import com.sinno.ems.dto.ProductDimension;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 15/03/2017.
 */
public interface ProductDimensionService {
    ProductDimension save(ProductDimension productForm);

    Long size();

    Boolean isExist(Long id);

    ProductDimension findById(Long id) throws IdNotFound;

    List<ProductDimension> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductDimension> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductDimension productForm);

    List<ProductDimension> findAll();

    List<ProductDimension> findAll(Pageable pageable);
}
