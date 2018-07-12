package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceLineArcService {

    public InvoiceLineArc save(InvoiceLineArc invoiceLineArc);

    public Long size();

    public Boolean isExist(Long id);

    public InvoiceLineArc findById(Long id) throws IdNotFound;

    public List<InvoiceLineArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<InvoiceLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(InvoiceLineArc invoiceLineArc);

    public List<InvoiceLineArc> findAll();

    public List<InvoiceLineArc> findAll(Pageable pageable);
}