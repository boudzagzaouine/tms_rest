package com.bagile.gmo.services;

import com.bagile.gmo.dto.Patrimony;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface PatrimonyService {

    Patrimony save(Patrimony patrimony);

    Long size();

    Boolean isExist(Long id);

    Patrimony findById(Long id) throws IdNotFound;

    List<Patrimony> find(String search) throws AttributesNotFound, ErrorType;

    List<Patrimony> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Patrimony patrimony);
    void deleteAll(List<Long> ids);
    List<Patrimony> findAll();

    List<Patrimony> findAll(int page, int size);
}
