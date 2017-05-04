package com.sinno.ems.service;

import com.sinno.ems.dto.PaymentSupplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PaymentSupplierService {
    public PaymentSupplier save(PaymentSupplier actions) throws IOException;

    public Long size();

    public Boolean isExist(Long id);

    public PaymentSupplier findById(Long id) throws IdNotFound;

    public List<PaymentSupplier> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentSupplier> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(PaymentSupplier actions);

    public List<PaymentSupplier> findAll();

    public List<PaymentSupplier> findAll(Pageable pageable);
}
