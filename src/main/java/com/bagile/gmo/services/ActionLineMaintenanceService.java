package com.bagile.gmo.services;

import com.bagile.gmo.dto.ActionLineMaintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ActionLineMaintenanceService {
    ActionLineMaintenance save(ActionLineMaintenance action);

    Long size();

    Boolean isExist(Long id);

    ActionLineMaintenance findById(Long id) throws IdNotFound;

    List<ActionLineMaintenance> find(String search) throws AttributesNotFound, ErrorType;

    List<ActionLineMaintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActionLineMaintenance action);
    void deleteAll(List<Long> ids);

    List<ActionLineMaintenance> findAll();

    List<ActionLineMaintenance> findAll(int page, int size);

	ActionLineMaintenance findOne(String search) throws AttributesNotFound, ErrorType;

}
