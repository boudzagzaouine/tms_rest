package com.bagile.gmo.services;

import com.bagile.gmo.dto.Pump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface PumpService {
    Pump save(Pump pump);

    Long size();

    Boolean isExist(Long id);

    Pump findById(Long id) throws IdNotFound;

    List<Pump> find(String search) throws AttributesNotFound, ErrorType;

    List<Pump> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Pump pump);

    List<Pump> findAll();

    List<Pump> findAll(int page, int size);
}
