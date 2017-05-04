package com.sinno.ems.service;

import com.sinno.ems.dto.OrderStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderStatusService {

    public OrderStatus save(OrderStatus orderStatus);

    public Long size();

    public Boolean isExist(Long id);

    public OrderStatus findById(Long id) throws IdNotFound;

    public List<OrderStatus> find(String search) throws AttributesNotFound, ErrorType;

    public List<OrderStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(OrderStatus orderStatus);

    public List<OrderStatus> findAll();

    public List<OrderStatus> findAll(Pageable pageable);
}