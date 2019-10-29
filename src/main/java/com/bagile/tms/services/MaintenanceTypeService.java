package com.bagile.tms.services;

import com.bagile.tms.dto.MaintenanceType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaintenanceTypeService {
    MaintenanceType save(MaintenanceType typeMaintenance);

    Long size();

    Boolean isExist(Long id);

    MaintenanceType findById(Long id) throws IdNotFound;

    List<MaintenanceType> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenanceType typeMaintenance);

    List<MaintenanceType> findAll();

    List<MaintenanceType> findAll(int page, int size);
}
