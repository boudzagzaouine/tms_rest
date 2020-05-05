package com.bagile.tms.services;

import com.bagile.gmo.dto.Vehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Long size();

    Boolean isExist(Long id);

    Vehicle findById(Long id) throws IdNotFound;

    List<Vehicle> find(String search) throws AttributesNotFound, ErrorType;

    List<Vehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Vehicle vehicle);

    List<Vehicle> findAll();

    List<Vehicle> findAll(int page, int size);
}
