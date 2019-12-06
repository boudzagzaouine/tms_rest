package com.bagile.tms.services;

import com.bagile.tms.dto.VehicleFeature;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;


public interface VehicleFeatureService {
    VehicleFeature save(VehicleFeature vehicleFeature);

    Long size();

    Boolean isExist(Long id);

    VehicleFeature findById(Long id) throws IdNotFound;

    List<VehicleFeature> find(String search) throws AttributesNotFound, ErrorType;

    List<VehicleFeature> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehicleFeature vehicleFeature);

    List<VehicleFeature> findAll();

    List<VehicleFeature> findAll(int page, int size);
}
