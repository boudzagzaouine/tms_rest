package com.bagile.gmo.services;

import com.bagile.gmo.dto.Sinister;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface SinisterService {
    Sinister save(Sinister sinister);

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    Sinister findById(Long id) throws IdNotFound;

    List<Sinister> find(String search) throws AttributesNotFound, ErrorType;

    List<Sinister> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Sinister sinister);

    List<Sinister> findAll();

    List<Sinister> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    void deleteAll (List<Long> ids);


}
