package com.bagile.gmo.services;

import com.bagile.gmo.dto.AccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface AccountPricingService {
    AccountPricing save(AccountPricing accountPricing);

    Long size();

    Boolean isExist(Long id);

    AccountPricing findById(Long id) throws IdNotFound;

    List<AccountPricing> find(String search) throws AttributesNotFound, ErrorType;

    List<AccountPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AccountPricing accountPricing);
    void deleteAll (List<Long> ids);

    List<AccountPricing> findAll();

    List<AccountPricing> findAll(int page, int size);

	AccountPricing findOne(String search) throws AttributesNotFound, ErrorType;

}
