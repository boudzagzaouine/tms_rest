package com.bagile.tms.services;

import com.bagile.tms.dto.OrderType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderTypeService {

    OrderType save(OrderType orderType);

    Long size();

    Boolean isExist(Long id);

    OrderType findById(Long id) throws IdNotFound;

    OrderType findOne(String search) throws AttributesNotFound, ErrorType;

    List<OrderType> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderType orderType);

    List<OrderType> findAll() throws AttributesNotFound, ErrorType;

    List<OrderType> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}