package com.bagile.tms.services.impl;


import com.bagile.tms.dto.OrderStatus;
import com.bagile.tms.entities.PrmOrderStatus;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.OrderStatusMapper;
import com.bagile.tms.repositories.OrderStatusRepository;
import com.bagile.tms.services.OrderStatusService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(OrderStatusService.class);

    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        LOGGER.info("save OrderStatus");
        return OrderStatusMapper.toDto(orderStatusRepository.saveAndFlush(OrderStatusMapper.toEntity(orderStatus, false)), false);
    }

    @Override
    public Long size() {
        return orderStatusRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderStatusRepository.existsById(id);
    }

    @Override
    public OrderStatus findById(Long id) throws IdNotFound {
        OrderStatus orderStatus = OrderStatusMapper.toDto(orderStatusRepository.findById(id).get(), false);
        if (null != orderStatus) {
            return orderStatus;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public OrderStatus findOne(String search) throws AttributesNotFound, ErrorType {
        return OrderStatusMapper.toDto(orderStatusRepository.findOne(Search.expression(search, PrmOrderStatus.class)).orElse(null), false);
    }

    @Override
    public List<OrderStatus> find(String search) throws AttributesNotFound, ErrorType {
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(Search.expression(search, PrmOrderStatus.class)), false);
    }

    @Override
    public List<OrderStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(Search.expression(search, PrmOrderStatus.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return orderStatusRepository.count(Search.expression(search, PrmOrderStatus.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete orderStatus");
        orderStatusRepository.deleteById(id);
    }

    @Override
    public void delete(OrderStatus orderStatus) {
        LOGGER.info("delete OrderStatus");
        orderStatusRepository.delete(OrderStatusMapper.toEntity(orderStatus, false));
    }

    @Override
    public List<OrderStatus> findAll() {
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(), false);
    }

    @Override
    public List<OrderStatus> findAll(Pageable pageable) {
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(pageable), false);
    }
    @Override

    public OrderStatus closedStatus() throws IdNotFound {
        return findById(1L);
    }
    @Override
    public  OrderStatus waitingStatus() throws IdNotFound {
        return findById(2L);
    }
    @Override
    public OrderStatus cancelledStatus() throws IdNotFound {
        return findById(3L);
    }
    @Override

    public OrderStatus completedStatus() throws IdNotFound {
        return findById(4L);
    }
    @Override

    public OrderStatus onProgressStatus() throws IdNotFound {
        return findById(5L);
    }
    @Override

    public OrderStatus partialStatus() throws IdNotFound {
        return findById(7L);
    }
    @Override

    public OrderStatus validStatus() throws IdNotFound{
        return findById(8L);
    }
    @Override

    public OrderStatus toPrepareStatus() throws IdNotFound{
        return findById(9L);
    }
    @Override

    public OrderStatus onProductionStatus() throws IdNotFound{
        return findById(10L);
    }
    @Override

    public OrderStatus finishedStatus() throws IdNotFound{
        return findById(11L);
    }
}