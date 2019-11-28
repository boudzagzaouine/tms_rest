package com.bagile.tms.services;

import com.bagile.tms.dto.InsuranceTerm;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TermInsuranceService {

    InsuranceTerm save(InsuranceTerm insuranceTerm);

    Long size();

    Boolean isExist(Long id);

    InsuranceTerm findById(Long id) throws IdNotFound;

    List<InsuranceTerm> find(String search) throws AttributesNotFound, ErrorType;

    List<InsuranceTerm> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    InsuranceTerm findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InsuranceTerm insuranceTerm);

    List<InsuranceTerm> findAll() throws AttributesNotFound, ErrorType;

    List<InsuranceTerm> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

}
