package com.bagile.tms.services;

import com.bagile.tms.dto.Agency;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 02/01/2017.
 */
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

    List<Agency> findAll();

    List<Agency> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}
