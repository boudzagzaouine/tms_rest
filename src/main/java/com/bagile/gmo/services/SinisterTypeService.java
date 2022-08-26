package com.bagile.gmo.services;

import com.bagile.gmo.dto.SinisterType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface SinisterTypeService {
    SinisterType save(SinisterType sinisterType);

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    SinisterType findById(Long id) throws IdNotFound;

    List<SinisterType> find(String search) throws AttributesNotFound, ErrorType;

    List<SinisterType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SinisterType sinisterType);

    List<SinisterType> findAll();

    List<SinisterType> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    void deleteAll (List<Long> ids);


}
