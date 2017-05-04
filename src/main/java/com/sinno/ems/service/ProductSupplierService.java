package com.sinno.ems.service;

import com.sinno.ems.dto.ProductSupplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 24/01/2017.
 */
public interface ProductSupplierService {
    ProductSupplier save(ProductSupplier productSupplier);

    Long size();

    Boolean isExist(Long id);

    ProductSupplier findById(Long id) throws IdNotFound;

    List<ProductSupplier> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductSupplier> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductSupplier productSupplier);

    List<ProductSupplier> findAll();

    List<ProductSupplier> findAll(Pageable pageable);
}
