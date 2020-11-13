package com.bagile.gmo.services;

import com.bagile.gmo.dto.ConditionalType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ConditionalTypeService {
    ConditionalType save(ConditionalType conditionalType);

    Long size();

    Boolean isExist(Long id);

    ConditionalType findById(Long id) throws IdNotFound;

    List<ConditionalType> find(String search) throws AttributesNotFound, ErrorType;

    List<ConditionalType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ConditionalType conditionalType);
    void deleteAll(List<Long> ids);
    List<ConditionalType> findAll();

    List<ConditionalType> findAll(int page, int size);
}
