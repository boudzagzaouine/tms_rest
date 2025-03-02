package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportInfo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface DeliveryInfoService {
    OrderTransportInfo save(OrderTransportInfo deliveryInfo);

    Long size();

    Boolean isExist(Long id);

    OrderTransportInfo findById(Long id) throws IdNotFound;

    List<OrderTransportInfo> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportInfo> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransportInfo deliveryInfo);
    void deleteAll (List<Long> ids);

    List<OrderTransportInfo> findAll();

    List<OrderTransportInfo> findAll(int page, int size);

	OrderTransportInfo findOne(String search) throws AttributesNotFound, ErrorType;

}
