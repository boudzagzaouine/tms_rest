package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface MaintenanceStateService {
    MaintenanceState save(MaintenanceState maintenanceState);

    Long size();

    Boolean isExist(Long id);

    MaintenanceState findById(Long id) throws IdNotFound;

    List<MaintenanceState> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceState> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(long id);
    void deleteAll(List<Long> ids);

    void delete(MaintenanceState maintenanceState);

    List<MaintenanceState> findAll();

    List<MaintenanceState> findAll(int page, int size);
}
