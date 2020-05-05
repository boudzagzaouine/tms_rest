package com.bagile.tms.services;


import com.bagile.gmo.dto.ProductType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductTypeService {

    ProductType save(ProductType productType);

    Long size();

    Boolean isExist(Long id);

    ProductType findById(Long id) throws IdNotFound;

    ProductType findOne(String search) throws AttributesNotFound, ErrorType;

    List<ProductType> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductType productType);

    List<ProductType> findAll();

    List<ProductType> findAll(Pageable pageable);

    ProductType findByCode(String code);

    List<ProductType> getProductTypeChildrens(Long productType, List<ProductType> productTypes) throws AttributesNotFound, ErrorType;
}