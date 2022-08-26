package com.bagile.gmo.services;

import com.bagile.gmo.dto.SupplierInvoiceReception;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierInvoiceReceptionService {
    SupplierInvoiceReception save(SupplierInvoiceReception deliveryInvoiceReception);

    SupplierInvoiceReception findOne(String search) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    SupplierInvoiceReception findById(Long id) throws IdNotFound;

    List<SupplierInvoiceReception> find(String search) throws AttributesNotFound, ErrorType;

    List<SupplierInvoiceReception> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SupplierInvoiceReception deliveryInvoiceReception);

    List<SupplierInvoiceReception> findAll();

    List<SupplierInvoiceReception> findAll(Pageable pageable);
}
