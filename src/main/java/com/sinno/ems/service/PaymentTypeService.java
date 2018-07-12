package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PaymentTypeService {
    PaymentType save(PaymentType paymentType);

    Long size();

    Boolean isExist(Long id);

    PaymentType findById(Long id) throws IdNotFound;

    List<PaymentType> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PaymentType paymentType);

    List<PaymentType> findAll();

    List<PaymentType> findAll(Pageable pageable);
}
