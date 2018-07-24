package com.bagile.tms.services.impl;

import com.sinno.ems.dto.OrderStatus;
import com.sinno.ems.entities.PrmOrderStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.OrderStatusMapper;
import com.sinno.ems.repositories.OrderStatusRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.OrderStatusService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return orderStatusRepository.exists(id);
    }

    @Override
    public OrderStatus findById(Long id) throws IdNotFound {
        OrderStatus orderStatus = OrderStatusMapper.toDto(orderStatusRepository.findOne(id), false);
        if (null != orderStatus) {
            return orderStatus;
        } else {
            throw new IdNotFound(id);
        }
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
        orderStatusRepository.delete(id);
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
}