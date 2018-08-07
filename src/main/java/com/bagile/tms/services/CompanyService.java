package com.bagile.tms.services;

import com.bagile.tms.dto.Company;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyService {

    public Company save(Company company);

    public Long size();

    public Boolean isExist(Long id);

    public Company findById(Long id) throws IdNotFound;

    public List<Company> find(String search) throws AttributesNotFound, ErrorType;

    public List<Company> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Company company);

    public List<Company> findAll();

    public List<Company> findAll(Pageable pageable);

}