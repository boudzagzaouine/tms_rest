package com.bagile.gmo.services;

import com.bagile.gmo.dto.PaymentStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentStatusService {

    PaymentStatus save(PaymentStatus paymentStatus);

    Long size();

    Boolean isExist(Long id);

    PaymentStatus findById(Long id) throws IdNotFound;

    List<PaymentStatus> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    PaymentStatus findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PaymentStatus paymentStatus);

    List<PaymentStatus> findAll();

    List<PaymentStatus> findAll(Pageable pageable);

    default PaymentStatus payedStatus() {
        try {
            return findById(1L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }

    default PaymentStatus partialPayedStatus() {
        try {
            return findById(2L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }

    default PaymentStatus onProgressPayedStatus() {
        try {
            return findById(3L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }

    default PaymentStatus unpaidStatus() {
        try {
            return findById(4L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }
    default PaymentStatus waitingConfirmStatus() {
        try {
            return findById(5L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }
    default PaymentStatus exchangedStatus() {
        try {
            return findById(6L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }
    default PaymentStatus toDepose() {
        try {
            return findById(7L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }
}