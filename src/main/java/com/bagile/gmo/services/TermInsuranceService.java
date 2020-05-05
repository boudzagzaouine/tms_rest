package com.bagile.gmo.services;

import com.bagile.gmo.dto.InsuranceTerm;
import com.bagile.gmo.dto.TurnLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
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
    void deleteAll (List<Long> ids);

    List<InsuranceTerm> findAll() throws AttributesNotFound, ErrorType;

    List<InsuranceTerm> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

}
