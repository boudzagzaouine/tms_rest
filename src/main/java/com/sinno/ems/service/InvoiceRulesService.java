package com.sinno.ems.service;

import com.sinno.ems.dto.InvoiceRules;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceRulesService {

    public InvoiceRules save(InvoiceRules invoiceRules);

    public Long size();

    public Boolean isExist(Long id);

    public InvoiceRules findById(Long id) throws IdNotFound;

    public List<InvoiceRules> find(String search) throws AttributesNotFound, ErrorType;

    public List<InvoiceRules> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(InvoiceRules invoiceRules);

    public List<InvoiceRules> findAll();

    public List<InvoiceRules> findAll(Pageable pageable);
}