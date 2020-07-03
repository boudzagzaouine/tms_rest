package com.bagile.gmo.services;

import com.bagile.gmo.dto.OperationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OperationTypeService {
    OperationType save(OperationType operationType);

    Long size();

    Boolean isExist(Long id);

    OperationType findById(Long id) throws IdNotFound;

    List<OperationType> find(String search) throws AttributesNotFound, ErrorType;

    List<OperationType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OperationType operationType);
    void deleteAll(List<Long> ids);
    List<OperationType> findAll();

    List<OperationType> findAll(int page, int size);
}
