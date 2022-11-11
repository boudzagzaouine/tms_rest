package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportTypeService {
    OrderTransportType save(OrderTransportType orderTransportType);

    Long size();

    Boolean isExist(Long id);

    OrderTransportType findById(Long id) throws IdNotFound;

    List<OrderTransportType> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransportType orderTransportType);
    void deleteAll (List<Long> ids);

    List<OrderTransportType> findAll();

    List<OrderTransportType> findAll(int page, int size);

	OrderTransportType findOne(String search) throws AttributesNotFound, ErrorType;

}
