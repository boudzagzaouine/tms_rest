package com.bagile.gmo.services;

import com.bagile.gmo.dto.Company;
import com.bagile.gmo.dto.Company;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyService {

    Company save(Company company);

    Long size();

    Boolean isExist(Long id);

    Company findById(Long id) throws IdNotFound;

    List<Company> find(String search) throws AttributesNotFound, ErrorType;

    List<Company> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Company company);
    void deleteAll (List<Long> ids);
    List<Company> findAll();

    List<Company> findAll(int page, int size);
}