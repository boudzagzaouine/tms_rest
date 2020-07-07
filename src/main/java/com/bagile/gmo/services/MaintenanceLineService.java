package com.bagile.gmo.services;

import java.util.List;

import com.bagile.gmo.dto.Action;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

public interface MaintenanceLineService {
    Action save(Action maintenanceLine);

    Long size();

    Boolean isExist(Long id);

    Action findById(Long id) throws IdNotFound;

    List<Action> find(String search) throws AttributesNotFound, ErrorType;

    List<Action> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Action maintenanceLine);

    List<Action> findAll();

    List<Action> findAll(int page, int size);

	Action findOne(String search) throws AttributesNotFound, ErrorType;

}
