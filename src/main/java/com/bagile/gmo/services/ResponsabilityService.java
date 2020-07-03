package com.bagile.gmo.services;

import com.bagile.gmo.dto.Responsability;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ResponsabilityService {
    Responsability save(Responsability responsability);

    Long size();

    Boolean isExist(Long id);

    Responsability findById(Long id) throws IdNotFound;

    List<Responsability> find(String search) throws AttributesNotFound, ErrorType;

    List<Responsability> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Responsability responsability);
    void deleteAll(List<Long> ids);
    List<Responsability> findAll();

    List<Responsability> findAll(int page, int size);
}
