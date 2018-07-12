package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 15/12/2016.
 */
public interface PaymentSupplierInvoiceService {
    PaymentSupplierInvoice save(PaymentSupplierInvoice paymentSupplierInvoice);

    Long size();

    Boolean isExist(Long id);

    PaymentSupplierInvoice findById(Long id) throws IdNotFound;

    List<PaymentSupplierInvoice> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentSupplierInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PaymentSupplierInvoice paymentSupplierInvoice);

    List<PaymentSupplierInvoice> findAll();

    List<PaymentSupplierInvoice> findAll(Pageable pageable);
}
