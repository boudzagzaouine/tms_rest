package com.bagile.gmo.services;

import com.bagile.gmo.dto.TurnType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TurnTypeService {
    TurnType save(TurnType turnType);

    Long size();

    Boolean isExist(Long id);

    TurnType findById(Long id) throws IdNotFound;

    List<TurnType> find(String search) throws AttributesNotFound, ErrorType;

    List<TurnType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TurnType turnType);
    void deleteAll(List<Long> ids);
    List<TurnType> findAll();

    List<TurnType> findAll(int page, int size);
}
