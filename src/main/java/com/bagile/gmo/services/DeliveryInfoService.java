package com.bagile.gmo.services;

import com.bagile.gmo.dto.DeliveryInfo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface DeliveryInfoService {
    DeliveryInfo save(DeliveryInfo deliveryInfo);

    Long size();

    Boolean isExist(Long id);

    DeliveryInfo findById(Long id) throws IdNotFound;

    List<DeliveryInfo> find(String search) throws AttributesNotFound, ErrorType;

    List<DeliveryInfo> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DeliveryInfo deliveryInfo);
    void deleteAll (List<Long> ids);

    List<DeliveryInfo> findAll();

    List<DeliveryInfo> findAll(int page, int size);

	DeliveryInfo findOne(String search) throws AttributesNotFound, ErrorType;

}
