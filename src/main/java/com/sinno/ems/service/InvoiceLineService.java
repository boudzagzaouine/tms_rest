package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceLineService {

    public InvoiceLine save(InvoiceLine invoiceLine);

    public Long size();

    public Boolean isExist(Long id);

    public InvoiceLine findById(Long id) throws IdNotFound;

    public List<InvoiceLine> find(String search) throws AttributesNotFound, ErrorType;

    public List<InvoiceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(InvoiceLine invoiceLine);

    public List<InvoiceLine> findAll();

    public List<InvoiceLine> findAll(Pageable pageable);
}