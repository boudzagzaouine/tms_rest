package com.bagile.tms.services;

import com.bagile.tms.dto.TermInsurance;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TermInsuranceService {

    TermInsurance save(TermInsurance termInsurance);

    Long size();

    Boolean isExist(Long id);

    TermInsurance findById(Long id) throws IdNotFound;

    List<TermInsurance> find(String search) throws AttributesNotFound, ErrorType;

    List<TermInsurance> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    TermInsurance findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TermInsurance termInsurance);

    List<TermInsurance> findAll() throws AttributesNotFound, ErrorType;

    List<TermInsurance> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

}
