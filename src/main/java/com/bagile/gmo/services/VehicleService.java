package com.bagile.gmo.services;

import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
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
