package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportRejectType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportRejectTypeService {
    OrderTransportRejectType save(OrderTransportRejectType orderTransportRejectType);

    Long size();

    Boolean isExist(Long id);

    OrderTransportRejectType findById(Long id) throws IdNotFound;

    List<OrderTransportRejectType> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportRejectType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransportRejectType orderTransportRejectType);
    void deleteAll (List<Long> ids);

    List<OrderTransportRejectType> findAll();

    List<OrderTransportRejectType> findAll(int page, int size);

	OrderTransportRejectType findOne(String search) throws AttributesNotFound, ErrorType;

}
