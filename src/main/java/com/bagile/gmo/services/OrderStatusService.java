package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderStatusService {

    OrderStatus save(OrderStatus orderStatus);

    Long size();

    Boolean isExist(Long id);

    OrderStatus findById(Long id) throws IdNotFound;

    OrderStatus findOne(String search) throws AttributesNotFound, ErrorType;

    List<OrderStatus> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderStatus orderStatus);

    List<OrderStatus> findAll();

    List<OrderStatus> findAll(int page, int size);

    OrderStatus closedStatus();

    OrderStatus waitingStatus() throws IdNotFound;

    OrderStatus cancelledStatus();

    OrderStatus completedStatus() throws IdNotFound;

    OrderStatus onProgressStatus() throws IdNotFound;

    OrderStatus partialStatus() throws IdNotFound;

    OrderStatus validStatus() throws IdNotFound;

    OrderStatus toPrepareStatus() throws IdNotFound;

    OrderStatus onProductionStatus() throws IdNotFound;

    OrderStatus finishedStatus() throws IdNotFound;
}