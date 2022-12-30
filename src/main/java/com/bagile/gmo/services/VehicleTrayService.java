package com.bagile.gmo.services;

import com.bagile.gmo.dto.VehicleTray;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface VehicleTrayService {
    VehicleTray save(VehicleTray vehicleTray);

    Long size();

    Boolean isExist(Long id);

    VehicleTray findById(Long id) throws IdNotFound;

    List<VehicleTray> find(String search) throws AttributesNotFound, ErrorType;

    List<VehicleTray> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VehicleTray vehicleTray);
    void deleteAll(List<Long> ids);
    List<VehicleTray> findAll();

    List<VehicleTray> findAll(int page, int size);
}
