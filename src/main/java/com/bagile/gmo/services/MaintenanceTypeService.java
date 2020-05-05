package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenanceType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
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

    void delete(long id);

    void delete(MaintenanceType typeMaintenance);

    List<MaintenanceType> findAll();

    List<MaintenanceType> findAll(int page, int size);
}
