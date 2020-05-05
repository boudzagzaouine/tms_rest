package com.bagile.tms.services;

import com.bagile.gmo.dto.InsuranceTermLigne;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface InsuranceTermLigneService {

    InsuranceTermLigne save(InsuranceTermLigne insuranceTermInsurance);

    Long size();

    Boolean isExist(Long id);

    InsuranceTermLigne findById(Long id) throws IdNotFound;

    List<InsuranceTermLigne> find(String search) throws AttributesNotFound, ErrorType;

    List<InsuranceTermLigne> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    InsuranceTermLigne findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InsuranceTermLigne insuranceTermInsurance);
    void deleteAll (List<Long> ids);
    List<InsuranceTermLigne> findAll() throws AttributesNotFound, ErrorType;

    List<InsuranceTermLigne> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
