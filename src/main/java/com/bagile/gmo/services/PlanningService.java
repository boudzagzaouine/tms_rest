package com.bagile.gmo.services;

import com.bagile.gmo.dto.Planning;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface PlanningService {

    Planning save(Planning planning);
    Long size();
    Boolean isExist(Long id);
    Planning findById(Long id) throws IdNotFound;
    List<Planning> find(String search) throws AttributesNotFound, ErrorType;
    List<Planning> find(String search, int page, int size) throws AttributesNotFound, ErrorType;
    Long size(String search) throws AttributesNotFound, ErrorType;
    void delete(Long id);
    void delete(Planning planning);
    void deleteAll(List<Long> ids);
    List<Planning> findAll();
    List<Planning> findAll(int page, int size);
}
