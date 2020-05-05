package com.bagile.gmo.services;

import com.bagile.gmo.dto.VehicleFeature;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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
