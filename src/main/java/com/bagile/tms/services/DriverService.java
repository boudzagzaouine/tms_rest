package com.bagile.tms.services;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 28/03/2017.
 */
public interface DriverService {
    Driver save(Driver driver);

    Long size();

    Boolean isExist(Long id);

    Driver findById(Long id) throws IdNotFound;

    List<Driver> find(String search) throws AttributesNotFound, ErrorType;

    List<Driver> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Driver driver);

    List<Driver> findAll();

    List<Driver> findAll(Pageable pageable);
}
