package com.bagile.gmo.services;

import com.bagile.gmo.dto.SubscriptionCardType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface SubscriptionCardTypeService {
    
    SubscriptionCardType save(SubscriptionCardType subscriptionCardType);

    Long size();

    Boolean isExist(Long id);

    SubscriptionCardType findById(Long id) throws IdNotFound;

    List<SubscriptionCardType> find(String search) throws AttributesNotFound, ErrorType;

    List<SubscriptionCardType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SubscriptionCardType subscriptionCardType);
    void deleteAll(List<Long> ids);
    List<SubscriptionCardType> findAll();

    List<SubscriptionCardType> findAll(int page, int size);
}
