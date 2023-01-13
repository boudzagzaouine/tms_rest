package com.bagile.gmo.services;

import com.bagile.gmo.dto.BrandVehicleType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface BrandVehicleTypeService {
    BrandVehicleType save(BrandVehicleType brandVehicleType);

    Long size();

    Boolean isExist(Long id);

    BrandVehicleType findById(Long id) throws IdNotFound;

    List<BrandVehicleType> find(String search) throws AttributesNotFound, ErrorType;

    List<BrandVehicleType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(BrandVehicleType brandVehicleType);
    void deleteAll (List<Long> ids);

    List<BrandVehicleType> findAll();

    List<BrandVehicleType> findAll(int page, int size);

	BrandVehicleType findOne(String search) throws AttributesNotFound, ErrorType;

}
