package com.bagile.gmo.services;

import com.bagile.gmo.dto.Warehouse;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WarehouseService {

    Warehouse save(Warehouse warehouse) throws IdNotFound;

    Long size();

    Boolean isExist(long id);

    Warehouse findById(long id) throws IdNotFound;

    Warehouse findOne(String search) throws AttributesNotFound, ErrorType;

    List<Warehouse> find(String search) throws AttributesNotFound, ErrorType;

    List<Warehouse> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(long id) throws Exception;

    void delete(Warehouse warehouse);

    List<Warehouse> findAll() throws AttributesNotFound, ErrorType;

    List<Warehouse> findAll(int page,int size);


}