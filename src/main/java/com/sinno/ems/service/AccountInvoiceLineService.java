package com.sinno.ems.service;

import com.sinno.ems.dto.AccountInvoiceLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 05/12/2016.
 */
public interface AccountInvoiceLineService {
    AccountInvoiceLine save(AccountInvoiceLine paymentSupplier);

    Long size();

    Boolean isExist(Long id);

    AccountInvoiceLine findById(Long id) throws IdNotFound;

    List<AccountInvoiceLine> find(String search) throws AttributesNotFound, ErrorType;

    List<AccountInvoiceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AccountInvoiceLine paymentSupplier);

    List<AccountInvoiceLine> findAll();

    List<AccountInvoiceLine> findAll(Pageable pageable);

}
