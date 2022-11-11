package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportService {
    OrderTransport save(OrderTransport orderDelivery);

    Long size();

    Boolean isExist(Long id);

    OrderTransport findById(Long id) throws IdNotFound;

    List<OrderTransport> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransport> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransport orderDelivery);
    void deleteAll (List<Long> ids);

    List<OrderTransport> findAll();

    List<OrderTransport> findAll(int page, int size);

	OrderTransport findOne(String search) throws AttributesNotFound, ErrorType;

    String getNextVal();
}
