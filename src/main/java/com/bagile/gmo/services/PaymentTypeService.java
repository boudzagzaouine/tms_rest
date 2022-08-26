package com.bagile.gmo.services;

import com.bagile.gmo.dto.PaymentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface PaymentTypeService {
    PaymentType save(PaymentType paymentType);

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    PaymentType findById(Long id) throws IdNotFound;

    List<PaymentType> find(String search) throws AttributesNotFound, ErrorType;

    PaymentType findOne(String search) throws AttributesNotFound, ErrorType;

    List<PaymentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PaymentType paymentType);

    List<PaymentType> findAll() throws AttributesNotFound, ErrorType;

    List<PaymentType> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

    PaymentType getWireTransfer();

    PaymentType getCash();

    PaymentType getCheck();

    PaymentType getCreditCard();

    PaymentType getNegotiableInstrument();

    PaymentType getAsset();

    PaymentType getEffet();

    PaymentType getBankTransfer();

    void setBankTransfer(PaymentType bankTransfer);
}
