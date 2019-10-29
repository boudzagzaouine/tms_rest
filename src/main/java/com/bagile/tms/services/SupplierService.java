package com.bagile.tms.services;

import com.bagile.tms.dto.Supplier;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

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
}
