package com.sinno.ems.service;

import com.sinno.ems.dto.PaymentStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentStatusService {

   PaymentStatus save(PaymentStatus paymentStatus);

   Long size();

   Boolean isExist(Long id);

   PaymentStatus findById(Long id) throws IdNotFound;

   List<PaymentStatus> find(String search) throws AttributesNotFound, ErrorType;

   List<PaymentStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

   Long size(String search) throws AttributesNotFound, ErrorType;

   void delete(Long id);

   void delete(PaymentStatus paymentStatus);

   List<PaymentStatus> findAll();

   List<PaymentStatus> findAll(Pageable pageable);
}