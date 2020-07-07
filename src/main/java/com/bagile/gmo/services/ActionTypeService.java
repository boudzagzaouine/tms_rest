package com.bagile.gmo.services;

import java.util.List;

import com.bagile.gmo.dto.ActionType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

public interface ActionTypeService {
    ActionType save(ActionType action);

    Long size();

    Boolean isExist(Long id);

    ActionType findById(Long id) throws IdNotFound;

    List<ActionType> find(String search) throws AttributesNotFound, ErrorType;

    List<ActionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActionType action);
    void deleteAll (List<Long> ids);

    List<ActionType> findAll();

    List<ActionType> findAll(int page, int size);

	ActionType findOne(String search) throws AttributesNotFound, ErrorType;

}
