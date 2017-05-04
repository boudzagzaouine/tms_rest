package com.sinno.ems.service;

import com.sinno.ems.dto.InvoiceData;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 31/10/2016.
 */
public interface InvoiceDataService {
    InvoiceData save(InvoiceData invoiceData);

    Long size();

    Boolean isExist(Long id);

    InvoiceData findById(Long id) throws IdNotFound;

    List<InvoiceData> find(String search) throws AttributesNotFound, ErrorType;

    List<InvoiceData> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InvoiceData invoiceLine);

    List<InvoiceData> findAll();

    List<InvoiceData> findAll(Pageable pageable);
}
