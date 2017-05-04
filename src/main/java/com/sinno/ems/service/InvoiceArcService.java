package com.sinno.ems.service;

import com.sinno.ems.dto.InvoiceArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceArcService {

    public InvoiceArc save(InvoiceArc invoiceArc);

    public Long size();

    public Boolean isExist(Long id);

    public InvoiceArc findById(Long id) throws IdNotFound;

    public List<InvoiceArc> find(String search) throws AttributesNotFound, ErrorType;

    public List<InvoiceArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(InvoiceArc invoiceArc);

    public List<InvoiceArc> findAll();

    public List<InvoiceArc> findAll(Pageable pageable);
}