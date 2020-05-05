package com.bagile.tms.services;

import com.bagile.gmo.dto.Company;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyService {

    Company save(Company company);

    Company findOne(String search) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    Company findById(Long id) throws IdNotFound;

    List<Company> find(String search) throws AttributesNotFound, ErrorType;

    List<Company> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Company company);

    List<Company> findAll();

    List<Company> findAll(Pageable pageable);



    @Transactional
    Company loadWmsCompany(Company company);

    List<Company> exportWmsCompany(List<Company> company);

    String getNextVal();
}