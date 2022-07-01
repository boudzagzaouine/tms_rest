package com.bagile.gmo.services;

import com.bagile.gmo.dto.VehicleProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface VehicleProductService {
    VehicleProduct save(VehicleProduct vehicleProduct);

    Long size();

    Boolean isExist(Long id);

    VehicleProduct findById(Long id) throws IdNotFound;

    List<VehicleProduct> find(String search) throws AttributesNotFound, ErrorType;

    List<VehicleProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehicleProduct vehicleProduct);
    void deleteAll (List<Long> ids);

    List<VehicleProduct> findAll();

    List<VehicleProduct> findAll(int page, int size);

	VehicleProduct findOne(String search) throws AttributesNotFound, ErrorType;

}
