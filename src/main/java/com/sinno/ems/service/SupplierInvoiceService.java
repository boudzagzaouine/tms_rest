package com.sinno.ems.service;

import com.sinno.ems.dto.SupplierInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface SupplierInvoiceService {
    public SupplierInvoice save(com.sinno.ems.dto.SupplierInvoice supplierInvoice);

    public Long size();

    public Boolean isExist(Long id);

    public SupplierInvoice findById(Long id) throws IdNotFound;

    public List<SupplierInvoice> find(String search) throws AttributesNotFound, ErrorType;

    List<SupplierInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(SupplierInvoice actions);

    public List<SupplierInvoice> findAll();

    public List<SupplierInvoice> findAll(Pageable pageable);

    BigInteger getNextVal();
}
