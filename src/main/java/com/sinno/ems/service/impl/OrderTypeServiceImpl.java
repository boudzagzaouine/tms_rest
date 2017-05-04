package com.sinno.ems.service.impl;

import com.sinno.ems.dto.OrderType;
import com.sinno.ems.entities.PrmOrderType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.OrderTypeMapper;
import com.sinno.ems.repositories.OrderTypeRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.OrderTypeService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTypeServiceImpl implements OrderTypeService {

    @Autowired
    private OrderTypeRepository orderTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(OrderTypeService.class);

    @Override
    public OrderType save(OrderType orderType) {
        LOGGER.info("save OrderType");
        orderType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= orderType.getId()) {
            orderType.setCreationDate(EmsDate.getDateNow());
        }
        return OrderTypeMapper.toDto(orderTypeRepository.saveAndFlush(OrderTypeMapper.toEntity(orderType, false)), false);
    }

    @Override
    public Long size() {
        return orderTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTypeRepository.exists(id);
    }

    @Override
    public OrderType findById(Long id) throws IdNotFound {
        OrderType orderType = OrderTypeMapper.toDto(orderTypeRepository.findOne(id), false);
        if (null != orderType) {
            return orderType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<OrderType> find(String search) throws AttributesNotFound, ErrorType {
        return OrderTypeMapper.toDtos(orderTypeRepository.findAll(Search.expression(search, PrmOrderType.class)), false);
    }

    @Override
    public List<OrderType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"prmOrderTypeUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return OrderTypeMapper.toDtos(orderTypeRepository.findAll(Search.expression(search, PrmOrderType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return orderTypeRepository.count(Search.expression(search, PrmOrderType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete OrderType");
        orderTypeRepository.delete(id);
    }

    @Override
    public void delete(OrderType orderType) {
        LOGGER.info("delete OrderType");
        orderTypeRepository.delete(OrderTypeMapper.toEntity(orderType, false));
    }

    @Override
    public List<OrderType> findAll() {
        return OrderTypeMapper.toDtos(orderTypeRepository.findAll(), false);
    }

    @Override
    public List<OrderType> findAll(Pageable pageable) {
        return OrderTypeMapper.toDtos(orderTypeRepository.findAll(pageable), false);
    }
}