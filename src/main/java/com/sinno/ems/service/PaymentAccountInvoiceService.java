package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 15/12/2016.
 */
public interface PaymentAccountInvoiceService {
    PaymentAccountInvoice save(PaymentAccountInvoice paymentAccountInvoice);

    Long size();

    Boolean isExist(Long id);

    PaymentAccountInvoice findById(Long id) throws IdNotFound;

    List<PaymentAccountInvoice> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentAccountInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PaymentAccountInvoice paymentAccountInvoice);

    List<PaymentAccountInvoice> findAll();

    List<PaymentAccountInvoice> findAll(Pageable pageable);
}
