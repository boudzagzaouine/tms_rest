package com.bagile.gmo.services;

import com.bagile.gmo.dto.ActionTypeRepair;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ActionTypeRepairService {
    ActionTypeRepair save(ActionTypeRepair action);

    Long size();

    Boolean isExist(Long id);

    ActionTypeRepair findById(Long id) throws IdNotFound;

    List<ActionTypeRepair> find(String search) throws AttributesNotFound, ErrorType;

    List<ActionTypeRepair> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActionTypeRepair action);
    void deleteAll (List<Long> ids);

    List<ActionTypeRepair> findAll();

    List<ActionTypeRepair> findAll(int page, int size);

	ActionTypeRepair findOne(String search) throws AttributesNotFound, ErrorType;

}
