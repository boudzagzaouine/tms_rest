package com.bagile.tms.services;

import com.bagile.gmo.dto.CommissionDriver;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface CommissionDriverService {

    CommissionDriver save(CommissionDriver commission);

    Long size();

    Boolean isExist(Long id);

    CommissionDriver findById(Long id) throws IdNotFound;

    List<CommissionDriver> find(String search) throws AttributesNotFound, ErrorType;

    List<CommissionDriver> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    CommissionDriver findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(CommissionDriver commission);

    List<CommissionDriver> findAll() throws AttributesNotFound, ErrorType;

    List<CommissionDriver> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
