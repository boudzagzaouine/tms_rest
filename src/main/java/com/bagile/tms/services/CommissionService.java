package com.bagile.tms.services;

import com.bagile.tms.dto.Commission;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface CommissionService {

    Commission save(Commission commission);

    Long size();

    Boolean isExist(Long id);

    Commission findById(Long id) throws IdNotFound;

    List<Commission> find(String search) throws AttributesNotFound, ErrorType;

    List<Commission> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Commission findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Commission commission);

    List<Commission> findAll() throws AttributesNotFound, ErrorType;

    List<Commission> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
