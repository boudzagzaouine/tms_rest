package com.bagile.gmo.services;

import com.bagile.gmo.dto.SupplierProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface SupplierProductService {
    SupplierProduct save(SupplierProduct supplierProduct);

    Long size();

    Boolean isExist(Long id);

    SupplierProduct findById(Long id) throws IdNotFound;

    List<SupplierProduct> find(String search) throws AttributesNotFound, ErrorType;

    List<SupplierProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SupplierProduct supplierProduct);
    void deleteAll (List<Long> ids);
    List<SupplierProduct> findAll();

    List<SupplierProduct> findAll(int page, int size);
}
