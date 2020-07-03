package com.bagile.gmo.services;

import com.bagile.gmo.dto.PeriodicityType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface PeriodicityTypeService {
    PeriodicityType save(PeriodicityType periodicityType);

    Long size();

    Boolean isExist(Long id);

    PeriodicityType findById(Long id) throws IdNotFound;

    List<PeriodicityType> find(String search) throws AttributesNotFound, ErrorType;

    List<PeriodicityType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PeriodicityType periodicityType);
    void deleteAll(List<Long> ids);
    List<PeriodicityType> findAll();

    List<PeriodicityType> findAll(int page, int size);
}
