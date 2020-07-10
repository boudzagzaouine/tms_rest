package com.bagile.gmo.services;

import com.bagile.gmo.dto.Action;
import com.bagile.gmo.dto.TurnLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ActionService {
    Action save(Action action);
    List<Action> saveAll(List<Action> actions);
    Long size();

    Boolean isExist(Long id);

    Action findById(Long id) throws IdNotFound;

    List<Action> find(String search) throws AttributesNotFound, ErrorType;

    List<Action> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Action action);
    void deleteAll(List<Long> ids);

    List<Action> findAll();

    List<Action> findAll(int page, int size);

	Action findOne(String search) throws AttributesNotFound, ErrorType;

}
