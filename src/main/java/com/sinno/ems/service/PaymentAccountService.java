package com.sinno.ems.service;

import com.sinno.ems.dto.PaymentAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PaymentAccountService {
    public PaymentAccount save(PaymentAccount actions) throws IOException;

    public Long size();

    public Boolean isExist(Long id);

    public PaymentAccount findById(Long id) throws IdNotFound;

    public List<PaymentAccount> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentAccount> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(PaymentAccount actions);

    public List<PaymentAccount> findAll();

    public List<PaymentAccount> findAll(Pageable pageable);
}
