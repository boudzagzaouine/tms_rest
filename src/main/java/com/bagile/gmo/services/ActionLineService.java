package com.bagile.gmo.services;

import com.bagile.gmo.dto.ActionLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ActionLineService {
    ActionLine save(ActionLine action);

    Long size();

    Boolean isExist(Long id);

    ActionLine findById(Long id) throws IdNotFound;

    List<ActionLine> find(String search) throws AttributesNotFound, ErrorType;

    List<ActionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActionLine action);
    void deleteAll(List<Long> ids);

    List<ActionLine> findAll();

    List<ActionLine> findAll(int page, int size);

	ActionLine findOne(String search) throws AttributesNotFound, ErrorType;

}
