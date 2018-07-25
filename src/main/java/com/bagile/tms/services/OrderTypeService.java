package com.bagile.tms.services;

import com.bagile.tms.dto.OrderType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderTypeService {

    public OrderType save(OrderType orderType);

    public Long size();

    public Boolean isExist(Long id);

    public OrderType findById(Long id) throws IdNotFound;

    OrderType findOne(String search) throws AttributesNotFound, ErrorType;

    public List<OrderType> find(String search) throws AttributesNotFound, ErrorType;

    public List<OrderType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(OrderType orderType);

    public List<OrderType> findAll();

    public List<OrderType> findAll(Pageable pageable);
}