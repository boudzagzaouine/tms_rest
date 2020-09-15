package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.io.IOException;
import java.util.List;

public interface MaintenancePlanService {

    MaintenancePlan save(MaintenancePlan maintenancePreventive) throws AttributesNotFound, ErrorType, IOException;

    List<MaintenancePlan> saveAll(List<MaintenancePlan> maintenancePlans) throws AttributesNotFound, ErrorType, IOException;

    Long size();

    Boolean isExist(Long id);

    MaintenancePlan findById(Long id) throws IdNotFound;

    List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenancePlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenancePlan maintenancePreventive);

    void deleteAll(List<Long> ids) throws AttributesNotFound, ErrorType;

    List<MaintenancePlan> findAll();

    List<MaintenancePlan> findAll(int page, int size);

	MaintenancePlan findOne(String search) throws AttributesNotFound, ErrorType;

    String getNextVal();


}
