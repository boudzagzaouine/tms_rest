package com.bagile.gmo.services;

import com.bagile.gmo.dto.Service;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OperationTypeService {
    Service save(Service operationType);

    Long size();

    Boolean isExist(Long id);

    Service findById(Long id) throws IdNotFound;

    List<Service> find(String search) throws AttributesNotFound, ErrorType;

    List<Service> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Service operationType);
    void deleteAll(List<Long> ids);
    List<Service> findAll();

    List<Service> findAll(int page, int size);
}
