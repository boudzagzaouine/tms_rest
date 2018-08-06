package com.bagile.tms.services;

import com.bagile.tms.dto.MaintenanceState;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaintenanceStateService {
    MaintenanceState save(MaintenanceState maintenanceState);

    Long size();

    Boolean isExist(Long id);

    MaintenanceState findById(Long id) throws IdNotFound;

    List<MaintenanceState> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceState> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenanceState maintenanceState);

    List<MaintenanceState> findAll();

    List<MaintenanceState> findAll(Pageable pageable);
}
