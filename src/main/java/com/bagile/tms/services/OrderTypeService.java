package com.bagile.tms.services;

import com.sinno.ems.dto.OrderType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderTypeService {

    public OrderType save(OrderType orderType);

    public Long size();

    public Boolean isExist(Long id);

    public OrderType findById(Long id) throws IdNotFound;

    public List<OrderType> find(String search) throws AttributesNotFound, ErrorType;

    public List<OrderType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(OrderType orderType);

    public List<OrderType> findAll();

    public List<OrderType> findAll(Pageable pageable);
}