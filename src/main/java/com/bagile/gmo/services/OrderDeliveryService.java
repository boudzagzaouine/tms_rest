package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderDelivery;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderDeliveryService {
    OrderDelivery save(OrderDelivery orderDelivery);

    Long size();

    Boolean isExist(Long id);

    OrderDelivery findById(Long id) throws IdNotFound;

    List<OrderDelivery> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderDelivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderDelivery orderDelivery);
    void deleteAll (List<Long> ids);

    List<OrderDelivery> findAll();

    List<OrderDelivery> findAll(int page, int size);

	OrderDelivery findOne(String search) throws AttributesNotFound, ErrorType;

    String getNextVal();
}
