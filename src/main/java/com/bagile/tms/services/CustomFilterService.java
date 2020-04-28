package com.bagile.tms.services;


import java.util.List;

import com.bagile.tms.dto.CustomFilter;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

public interface CustomFilterService {

    CustomFilter save(CustomFilter customFilter);

    Long size();

    Boolean isExist(Long id);

    CustomFilter findById(Long id) throws IdNotFound;

    List<CustomFilter> find(String search) throws AttributesNotFound, ErrorType;

    List<CustomFilter> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    CustomFilter findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(long id) throws IdNotFound;

    void delete(CustomFilter customFilter);

    List<CustomFilter> findAll() throws AttributesNotFound, ErrorType;

    List<CustomFilter> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}