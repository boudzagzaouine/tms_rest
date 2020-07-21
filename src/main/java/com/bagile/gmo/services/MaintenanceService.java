package com.bagile.gmo.services;

import java.util.List;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

public interface MaintenanceService {
    Maintenance save(Maintenance maintenance);
    List<Maintenance> saveAll(List<Maintenance> maintenances);

    Long size();

    Boolean isExist(Long id);

    List<Maintenance> generateMaintenance(MaintenancePlan maintenancePlan);

    Maintenance findById(Long id) throws IdNotFound;

    List<Maintenance> find(String search) throws AttributesNotFound, ErrorType;

    List<Maintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Maintenance maintenancePlan);

    void deleteAll (List<Long> ids);

    List<Maintenance> findAll();

    List<Maintenance> findAll(int page, int size);

	Maintenance findOne(String search) throws AttributesNotFound, ErrorType;

}
