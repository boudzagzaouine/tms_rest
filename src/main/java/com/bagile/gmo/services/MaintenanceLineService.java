package com.bagile.gmo.services;

import java.util.List;

import com.bagile.gmo.dto.MaintenanceLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

public interface MaintenanceLineService {
    MaintenanceLine save(MaintenanceLine maintenanceLine);

    Long size();

    Boolean isExist(Long id);

    MaintenanceLine findById(Long id) throws IdNotFound;

    List<MaintenanceLine> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenanceLine maintenanceLine);

    List<MaintenanceLine> findAll();

    List<MaintenanceLine> findAll(int page, int size);

	MaintenanceLine findOne(String search) throws AttributesNotFound, ErrorType;

}
