package com.bagile.gmo.services;

import com.bagile.gmo.dto.AccountPricingService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface AccountPricingServiceService {
    AccountPricingService save(AccountPricingService accopuntServiceService);
    List<AccountPricingService> saveAll(List<AccountPricingService> accopuntServiceServices) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    AccountPricingService findById(Long id) throws IdNotFound;

    List<AccountPricingService> find(String search) throws AttributesNotFound, ErrorType;

    List<AccountPricingService> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AccountPricingService accopuntServiceService);
    void deleteAll (List<Long> ids);

    List<AccountPricingService> findAll();

    List<AccountPricingService> findAll(int page, int size);

	AccountPricingService findOne(String search) throws AttributesNotFound, ErrorType;

}
