package com.bagile.tms.services;

import com.bagile.tms.dto.TransportCategoryVehicle;
import com.bagile.tms.dto.TransportCategoryVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;


public interface TransportCategoryVehicleService {
    TransportCategoryVehicle save(TransportCategoryVehicle transport);

    Long size();

    Boolean isExist(Long id);

    TransportCategoryVehicle findById(Long id) throws IdNotFound;

    List<TransportCategoryVehicle> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportCategoryVehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportCategoryVehicle transport);

    List<TransportCategoryVehicle> findAll();

    List<TransportCategoryVehicle> findAll(int page, int size);
}
