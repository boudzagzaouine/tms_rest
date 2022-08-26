package com.bagile.gmo.services;


import com.bagile.gmo.dto.InvoiceStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InvoiceStatusService {

    InvoiceStatus save(InvoiceStatus invoiceStatus);

    Long size();

    Boolean isExist(Long id);

    InvoiceStatus findById(Long id) throws IdNotFound;

    List<InvoiceStatus> find(String search) throws AttributesNotFound, ErrorType;

    InvoiceStatus findOne(String search) throws AttributesNotFound, ErrorType;

    List<InvoiceStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InvoiceStatus invoiceStatus);

    List<InvoiceStatus> findAll();

    List<InvoiceStatus> findAll(Pageable pageable);


    InvoiceStatus getDispute();

    InvoiceStatus getCreated();

    InvoiceStatus getTransferred();

    InvoiceStatus getClosed();

    InvoiceStatus getCanceled();
}