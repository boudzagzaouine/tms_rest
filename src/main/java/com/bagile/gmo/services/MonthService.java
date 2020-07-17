package com.bagile.gmo.services;

import com.bagile.gmo.dto.Month;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface MonthService {
    Month save(Month month);
    List<Month> saveAll(List<Month> months);

    Long size();

    Boolean isExist(Long id);

    Month findById(Long id) throws IdNotFound;

    List<Month> find(String search) throws AttributesNotFound, ErrorType;

    List<Month> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Month month);

    void deleteAll(List<Long> ids);

    List<Month> findAll();

    List<Month> findAll(int page, int size);

	Month findOne(String search) throws AttributesNotFound, ErrorType;

}
