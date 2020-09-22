package com.bagile.gmo.services;

import com.bagile.gmo.dto.Supplier;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface SupplierService {
    Supplier save(Supplier supplier);

    Long size();

    Boolean isExist(Long id);

    Supplier findById(Long id) throws IdNotFound;

    List<Supplier> find(String search) throws AttributesNotFound, ErrorType;

    List<Supplier> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Supplier supplier);

    List<Supplier> findAll();

    List<Supplier> findAll(int page, int size);
    void deleteAll (List<Long> ids);
    String getNextVal();

}
