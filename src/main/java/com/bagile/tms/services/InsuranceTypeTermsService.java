package com.bagile.tms.services;

import com.bagile.tms.dto.InsuranceTypeTerms;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface InsuranceTypeTermsService {

    InsuranceTypeTerms save(InsuranceTypeTerms insuranceTypeTerms);

    Long size();

    Boolean isExist(Long id);

    InsuranceTypeTerms findById(Long id) throws IdNotFound;

    List<InsuranceTypeTerms> find(String search) throws AttributesNotFound, ErrorType;

    List<InsuranceTypeTerms> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    InsuranceTypeTerms findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InsuranceTypeTerms insuranceTypeTerms);

    List<InsuranceTypeTerms> findAll() throws AttributesNotFound, ErrorType;

    List<InsuranceTypeTerms> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
