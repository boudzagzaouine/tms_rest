package com.sinno.ems.service;

import com.sinno.ems.dto.ProductForm;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 13/03/2017.
 */
public interface ProductFormService {
    ProductForm save(ProductForm productForm);

    Long size();

    Boolean isExist(Long id);

    ProductForm findById(Long id) throws IdNotFound;

    List<ProductForm> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductForm> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductForm productForm);

    List<ProductForm> findAll();

    List<ProductForm> findAll(Pageable pageable);
}
