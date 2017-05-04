package com.sinno.ems.service;

import com.sinno.ems.dto.GenerateInvoice;
import com.sinno.ems.dto.Invoice;
import com.sinno.ems.dto.Owner;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface InvoiceService {

    public Invoice save(Invoice invoice);

    public Long size();

    public Boolean isExist(Long id);

    public Invoice findById(Long id) throws IdNotFound;

    public List<Invoice> find(String search) throws AttributesNotFound, ErrorType;

    public List<Invoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Invoice invoice);

    public List<Invoice> findAll();

    public List<Invoice> findAll(Pageable pageable);

    public BigInteger getNextVal();

    Invoice createInvoice(Date startDate, Date endDate, Owner owner) throws AttributesNotFound, ErrorType;

    Invoice generateInvoiceFromOwner(GenerateInvoice generateInvoice) throws AttributesNotFound, ErrorType;
}