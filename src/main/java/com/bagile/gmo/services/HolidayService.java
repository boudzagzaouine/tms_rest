package com.bagile.gmo.services;

import com.bagile.gmo.dto.Holiday;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface HolidayService {
    Holiday save(Holiday Holiday);

    Long size();

    Boolean isExist(Long id);

    Holiday findById(Long id) throws IdNotFound;

    List<Holiday> find(String search) throws AttributesNotFound, ErrorType;

    List<Holiday> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Holiday Holiday);
    void deleteAll(List<Long> ids);
    List<Holiday> findAll();

    List<Holiday> findAll(int page, int size);
}
