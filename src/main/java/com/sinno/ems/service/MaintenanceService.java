package com.sinno.ems.service;

import com.sinno.ems.dto.MaintenancePlan;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
public interface MaintenanceService {
    MaintenancePlan save(MaintenancePlan maintenancePlan);

    Long size();

    Boolean isExist(Long id);

    MaintenancePlan findById(Long id) throws IdNotFound;

    List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenancePlan> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenancePlan maintenancePlan);

    List<MaintenancePlan> findAll();

    List<MaintenancePlan> findAll(Pageable pageable);
}
