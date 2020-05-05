package com.bagile.gmo.services;

import com.bagile.gmo.dto.CommissionType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface CommissionTypeService {

    CommissionType save(CommissionType commissionType);

    Long size();

    Boolean isExist(Long id);

    CommissionType findById(Long id) throws IdNotFound;

    List<CommissionType> find(String search) throws AttributesNotFound, ErrorType;

    List<CommissionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    CommissionType findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);
    void deleteAll (List<Long> ids);
    void delete(CommissionType commissionType);

    List<CommissionType> findAll() throws AttributesNotFound, ErrorType;

    List<CommissionType> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
