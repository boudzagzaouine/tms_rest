package com.bagile.gmo.services;

import com.bagile.gmo.dto.SubscriptionCard;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface SubscriptionCardService {
    
    SubscriptionCard save(SubscriptionCard subscriptionCard);

    Long size();

    Boolean isExist(Long id);

    SubscriptionCard findById(Long id) throws IdNotFound;

    List<SubscriptionCard> find(String search) throws AttributesNotFound, ErrorType;

    List<SubscriptionCard> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(SubscriptionCard subscriptionCard);
    void deleteAll(List<Long> ids);
    List<SubscriptionCard> findAll();

    List<SubscriptionCard> findAll(int page, int size);
}
