package com.bagile.tms.services;

import com.bagile.tms.dto.Warehouse;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WarehouseService {

    Warehouse save(Warehouse warehouse) throws IdNotFound;

    Long size();

    Boolean isExist(Long id);

    Warehouse findById(Long id) throws IdNotFound;

    Warehouse findOne(String search) throws AttributesNotFound, ErrorType;

    List<Warehouse> find(String search) throws AttributesNotFound, ErrorType;

    List<Warehouse> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws Exception;

    void delete(Warehouse warehouse);

    List<Warehouse> findAll() throws AttributesNotFound, ErrorType;

    List<Warehouse> findAll(Pageable pageable);


}