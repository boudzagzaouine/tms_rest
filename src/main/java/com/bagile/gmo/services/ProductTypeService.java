package com.bagile.gmo.services;

import com.bagile.gmo.dto.ProductType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ProductTypeService {
    ProductType save(ProductType productType);

    Long size();

    Boolean isExist(Long id);

    ProductType findById(Long id) throws IdNotFound;

    List<ProductType> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductType productType);
    void deleteAll(List<Long> ids);
    List<ProductType> findAll();

    List<ProductType> findAll(int page, int size);
}
