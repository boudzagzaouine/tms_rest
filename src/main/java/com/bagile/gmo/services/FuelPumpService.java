package com.bagile.gmo.services;

import com.bagile.gmo.dto.FuelPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface FuelPumpService {
    FuelPump save(FuelPump fuelPump);

    Long size();

    Boolean isExist(Long id);

    FuelPump findById(Long id) throws IdNotFound;

    List<FuelPump> find(String search) throws AttributesNotFound, ErrorType;

    List<FuelPump> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(FuelPump fuelPump);

    List<FuelPump> findAll();

    List<FuelPump> findAll(int page, int size);
}
