package com.bagile.gmo.services;

import com.bagile.gmo.dto.Driver;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface DriverService {

    Driver save(Driver driver);

    Long size();

    Boolean isExist(Long id);

    Driver findById(Long id) throws IdNotFound;

    List<Driver> find(String search) throws AttributesNotFound, ErrorType;

    List<Driver> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Driver driver);
    void deleteAll (List<Long> ids);

    List<Driver> findAll();

    List<Driver> findAll(int page, int size);

    String getNextVal();
    void archive(Long id) throws IdNotFound;
}
