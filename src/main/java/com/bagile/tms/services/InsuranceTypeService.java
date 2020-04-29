package com.bagile.tms.services;

import com.bagile.tms.dto.InsuranceType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface InsuranceTypeService {

    InsuranceType save(InsuranceType insuranceType);

    Long size();

    Boolean isExist(Long id);

    InsuranceType findById(Long id) throws IdNotFound;

    List<InsuranceType> find(String search) throws AttributesNotFound, ErrorType;

    List<InsuranceType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    InsuranceType findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InsuranceType insuranceType);
    void deleteAll (List<Long> ids);
    List<InsuranceType> findAll() throws AttributesNotFound, ErrorType;

    List<InsuranceType> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
