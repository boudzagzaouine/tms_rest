package com.sinno.ems.service;

import com.sinno.ems.dto.AccountInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface AccountInvoiceService {
    public AccountInvoice save(AccountInvoice actions);

    public Long size();

    public Boolean isExist(Long id);

    public AccountInvoice findById(Long id) throws IdNotFound;

    public List<AccountInvoice> find(String search) throws AttributesNotFound, ErrorType;


    List<AccountInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(AccountInvoice actions);

    public List<AccountInvoice> findAll();

    public List<AccountInvoice> findAll(Pageable pageable);

    BigInteger getNextVal();
}
