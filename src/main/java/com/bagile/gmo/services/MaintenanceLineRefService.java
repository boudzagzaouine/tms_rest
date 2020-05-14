package com.bagile.gmo.services;

import java.util.List;

import com.bagile.gmo.dto.MaintenanceLineRef;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

public interface MaintenanceLineRefService {
    MaintenanceLineRef save(MaintenanceLineRef maintenanceLineRef);

    Long size();

    Boolean isExist(Long id);

    MaintenanceLineRef findById(Long id) throws IdNotFound;

    List<MaintenanceLineRef> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceLineRef> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenanceLineRef maintenanceLineRef);

    List<MaintenanceLineRef> findAll();

    List<MaintenanceLineRef> findAll(int page, int size);

	MaintenanceLineRef findOne(String search) throws AttributesNotFound, ErrorType;

}
