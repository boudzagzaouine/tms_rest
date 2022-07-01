package com.bagile.gmo.services;

import com.bagile.gmo.dto.SupplierType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface SupplierTypeService {
    SupplierType save(SupplierType supplier);

    Long size();

    Boolean isExist(Long id);

    SupplierType findById(Long id) throws IdNotFound;

    List<SupplierType> find(String search) throws AttributesNotFound, ErrorType;

    List<SupplierType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SupplierType supplier);
    void deleteAll (List<Long> ids);

    List<SupplierType> findAll();

    List<SupplierType> findAll(int page, int size);

	SupplierType findOne(String search) throws AttributesNotFound, ErrorType;

}
