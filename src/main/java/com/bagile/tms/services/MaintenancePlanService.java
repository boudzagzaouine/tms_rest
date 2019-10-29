package com.bagile.tms.services;

import com.bagile.tms.dto.MaintenancePlan;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MaintenancePlanService {
    MaintenancePlan save(MaintenancePlan maintenancePlan);

    Long size();

    Boolean isExist(Long id);

    MaintenancePlan findById(Long id) throws IdNotFound;

    List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenancePlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenancePlan maintenancePlan);

    List<MaintenancePlan> findAll();

    List<MaintenancePlan> findAll(int page, int size);
}
