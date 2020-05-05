package com.bagile.gmo.services;

import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleCategoryService {
    VehicleCategory save(VehicleCategory vehicleCategory);

    Long size();

    Boolean isExist(Long id);

    VehicleCategory findById(Long id) throws IdNotFound;

    List<VehicleCategory> find(String search) throws AttributesNotFound, ErrorType;

    List<VehicleCategory> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehicleCategory vehicleCategory);

    void deleteAll (List<Long> ids);

    List<VehicleCategory> findAll();

    List<VehicleCategory> findAll(int page, int size);

}
