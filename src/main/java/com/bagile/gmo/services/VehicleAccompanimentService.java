package com.bagile.gmo.services;

import com.bagile.gmo.dto.VehicleAccompaniment;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface VehicleAccompanimentService {
    VehicleAccompaniment save(VehicleAccompaniment vehicleAccompaniment);

    Long size();

    Boolean isExist(Long id);

    VehicleAccompaniment findById(Long id) throws IdNotFound;

    List<VehicleAccompaniment> find(String search) throws AttributesNotFound, ErrorType;

    List<VehicleAccompaniment> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehicleAccompaniment vehicleAccompaniment);
    void deleteAll (List<Long> ids);
    List<VehicleAccompaniment> findAll();

    List<VehicleAccompaniment> findAll(int page, int size);
}
