package com.bagile.gmo.services;

import com.bagile.gmo.dto.Agency;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface AgencyService {
    Agency save(Agency agency);

    Long size();

    Boolean isExist(Long id);

    Agency findById(Long id) throws IdNotFound;

    List<Agency> find(String search) throws AttributesNotFound, ErrorType;

    List<Agency> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Agency agency);
    void deleteAll (List<Long> ids);
    List<Agency> findAll();

    List<Agency> findAll(int page, int size);
}
