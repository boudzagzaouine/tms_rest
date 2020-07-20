package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface MaintenancePlanService {

    MaintenancePlan save(MaintenancePlan maintenancePreventive);

    List<MaintenancePlan> saveAll(List<MaintenancePlan> maintenancePlans);

    Long size();

    Boolean isExist(Long id);

    MaintenancePlan findById(Long id) throws IdNotFound;

    List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenancePlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenancePlan maintenancePreventive);

    void deleteAll(List<Long> ids);

    List<MaintenancePlan> findAll();

    List<MaintenancePlan> findAll(int page, int size);

	MaintenancePlan findOne(String search) throws AttributesNotFound, ErrorType;

}
