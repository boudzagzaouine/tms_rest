package com.bagile.gmo.services;

import com.bagile.gmo.dto.ActionMaintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ActionMaintenanceService {
    ActionMaintenance save(ActionMaintenance action);
    List<ActionMaintenance> saveAll(List<ActionMaintenance> actions);
    Long size();

    Boolean isExist(Long id);

    ActionMaintenance findById(Long id) throws IdNotFound;

    List<ActionMaintenance> find(String search) throws AttributesNotFound, ErrorType;

    List<ActionMaintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActionMaintenance action);
    void deleteAll(List<Long> ids);

    List<ActionMaintenance> findAll();

    List<ActionMaintenance> findAll(int page, int size);

	ActionMaintenance findOne(String search) throws AttributesNotFound, ErrorType;

}
