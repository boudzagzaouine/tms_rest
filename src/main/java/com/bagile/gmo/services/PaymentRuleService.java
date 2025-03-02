package com.bagile.gmo.services;

import com.bagile.gmo.dto.PaymentRule;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface PaymentRuleService {
    PaymentRule save(PaymentRule paymentRule);

    Long size();

    Boolean isExist(Long id);

    PaymentRule findById(Long id) throws IdNotFound;

    List<PaymentRule> find(String search) throws AttributesNotFound, ErrorType;

    List<PaymentRule> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PaymentRule paymentRule);
    void deleteAll (List<Long> ids);

    List<PaymentRule> findAll();

    List<PaymentRule> findAll(int page, int size);

	PaymentRule findOne(String search) throws AttributesNotFound, ErrorType;

}
