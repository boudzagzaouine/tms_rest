package com.bagile.gmo.services;

import com.bagile.gmo.dto.LoadingType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface LoadingTypeService {
    LoadingType save(LoadingType loadingType);

    Long size();

    Boolean isExist(Long id);

    LoadingType findById(Long id) throws IdNotFound;

    List<LoadingType> find(String search) throws AttributesNotFound, ErrorType;

    List<LoadingType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(LoadingType loadingType);
    void deleteAll(List<Long> ids);
    List<LoadingType> findAll();

    List<LoadingType> findAll(int page, int size);
}
