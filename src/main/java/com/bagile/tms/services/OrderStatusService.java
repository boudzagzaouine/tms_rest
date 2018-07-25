package com.bagile.tms.services;

import com.bagile.tms.dto.OrderStatus;

import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderStatusService {

    public OrderStatus save(OrderStatus orderStatus);

    public Long size();

    public Boolean isExist(Long id);

    public OrderStatus findById(Long id) throws IdNotFound;

    OrderStatus findOne(String search) throws AttributesNotFound, ErrorType;

    public List<OrderStatus> find(String search) throws AttributesNotFound, ErrorType;

    public List<OrderStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(OrderStatus orderStatus);

    public List<OrderStatus> findAll();

    public List<OrderStatus> findAll(Pageable pageable);

    OrderStatus closedStatus() throws IdNotFound;

    OrderStatus waitingStatus() throws IdNotFound;

    abstract OrderStatus cancelledStatus() throws IdNotFound;

    abstract OrderStatus completedStatus() throws IdNotFound;

    abstract OrderStatus onProgressStatus() throws IdNotFound;

    abstract OrderStatus partialStatus() throws IdNotFound;

    abstract OrderStatus validStatus() throws IdNotFound;

    abstract OrderStatus toPrepareStatus() throws IdNotFound;

    abstract OrderStatus onProductionStatus() throws IdNotFound;

    abstract OrderStatus finishedStatus() throws IdNotFound;
}