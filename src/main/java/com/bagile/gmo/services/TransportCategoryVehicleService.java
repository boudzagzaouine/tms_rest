package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportCategoryVehicle;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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
    void deleteAll (List<Long> ids);

    void delete(TransportCategoryVehicle transport);

    List<TransportCategoryVehicle> findAll();

    List<TransportCategoryVehicle> findAll(int page, int size);
}
