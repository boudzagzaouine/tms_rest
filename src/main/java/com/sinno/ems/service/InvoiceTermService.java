package com.sinno.ems.service;

import com.sinno.ems.dto.InvoiceTerm;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface InvoiceTermService {
    InvoiceTerm save(InvoiceTerm invoiceTerm);

    Long size();

    Boolean isExist(Long id);

    InvoiceTerm findById(Long id) throws IdNotFound;

    List<InvoiceTerm> find(String search) throws AttributesNotFound, ErrorType;

    List<InvoiceTerm> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InvoiceTerm invoiceTerm);

    List<InvoiceTerm> findAll();

    List<InvoiceTerm> findAll(Pageable pageable);
}
