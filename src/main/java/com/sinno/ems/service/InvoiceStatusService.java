package com.sinno.ems.service;

import com.sinno.ems.dto.InvoiceStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceStatusService {

    InvoiceStatus save(InvoiceStatus invoiceStatus);

    Long size();

    Boolean isExist(Long id);

    InvoiceStatus findById(Long id) throws IdNotFound;

    List<InvoiceStatus> find(String search) throws AttributesNotFound, ErrorType;

    List<InvoiceStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InvoiceStatus invoiceStatus);

    List<InvoiceStatus> findAll();

    List<InvoiceStatus> findAll(Pageable pageable);
}