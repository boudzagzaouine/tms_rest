package com.bagile.gmo.services;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.Patrimony;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.io.IOException;
import java.util.List;

public interface MaintenanceService {
    Maintenance save(Maintenance maintenance) throws AttributesNotFound, ErrorType;
    List<Maintenance> saveAll(List<Maintenance> maintenances) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    List<Maintenance> generateMaintenance(Patrimony patrimony) throws IOException, AttributesNotFound, ErrorType, IdNotFound;

    Maintenance findById(Long id) throws IdNotFound;

    List<Maintenance> find(String search) throws AttributesNotFound, ErrorType;

    List<Maintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws AttributesNotFound, ErrorType;

    void delete(Maintenance maintenancePlan) throws AttributesNotFound, ErrorType;

    void deleteAll (List<Long> ids) throws AttributesNotFound, ErrorType;

    List<Maintenance> findAll();

    List<Maintenance> findAll(int page, int size);

	Maintenance findOne(String search) throws AttributesNotFound, ErrorType;


    String getNextVal();

     void updateMaintenance(Maintenance maintenance);

     Maintenance getMaintenanceByActionType(long actionTypeId, long patrimonyId);

     Maintenance closeMaintenance(Maintenance maintenance) throws IdNotFound, AttributesNotFound, ErrorType;
    }
