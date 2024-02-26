package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportAccompaniment;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportAccompanimentService {
    OrderTransportAccompaniment save(OrderTransportAccompaniment orderTransportAccompaniment) throws ErrorType, AttributesNotFound;


    Long size();

    Boolean isExist(Long id);

    OrderTransportAccompaniment findById(Long id) throws IdNotFound;

    List<OrderTransportAccompaniment> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportAccompaniment> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransportAccompaniment orderTransportAccompaniment);

    void deleteAll(List<Long> ids);

    List<OrderTransportAccompaniment> findAll();

    List<OrderTransportAccompaniment> findAll(int page, int size);

    OrderTransportAccompaniment findOne(String search) throws AttributesNotFound, ErrorType;

}
