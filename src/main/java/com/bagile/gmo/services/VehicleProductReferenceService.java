package com.bagile.gmo.services;

import com.bagile.gmo.dto.VehicleProductReference;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface VehicleProductReferenceService {
    VehicleProductReference save(VehicleProductReference vehicleProductReference);

    Long size();

    Boolean isExist(Long id);

    VehicleProductReference findById(Long id) throws IdNotFound;

    List<VehicleProductReference> find(String search) throws AttributesNotFound, ErrorType;

    List<VehicleProductReference> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehicleProductReference vehicleProductReference);
    void deleteAll (List<Long> ids);

    List<VehicleProductReference> findAll();

    List<VehicleProductReference> findAll(int page, int size);

	VehicleProductReference findOne(String search) throws AttributesNotFound, ErrorType;

}
