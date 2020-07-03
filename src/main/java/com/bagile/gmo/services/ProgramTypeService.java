package com.bagile.gmo.services;

import com.bagile.gmo.dto.ProgramType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ProgramTypeService {
    ProgramType save(ProgramType programType);

    Long size();

    Boolean isExist(Long id);

    ProgramType findById(Long id) throws IdNotFound;

    List<ProgramType> find(String search) throws AttributesNotFound, ErrorType;

    List<ProgramType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProgramType programType);
    void deleteAll(List<Long> ids);
    List<ProgramType> findAll();

    List<ProgramType> findAll(int page, int size);
}
