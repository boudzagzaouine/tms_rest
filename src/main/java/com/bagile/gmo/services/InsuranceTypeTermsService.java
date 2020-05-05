package com.bagile.gmo.services;

import com.bagile.gmo.dto.InsuranceTypeTerms;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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
