package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderDelivery;
import com.bagile.gmo.entities.TmsOrderDelivery;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderDeliveryMapper;
import com.bagile.gmo.repositories.OrderDeliveryRepository;
import com.bagile.gmo.services.OrderDeliveryService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderDeliveryServiceImpl implements OrderDeliveryService {
    
    private final OrderDeliveryRepository orderDeliveryRepository;

    public OrderDeliveryServiceImpl(OrderDeliveryRepository orderDeliveryRepository) {
        this.orderDeliveryRepository = orderDeliveryRepository;
    }

    @Override
    public OrderDelivery save(OrderDelivery orderDelivery) {
        return OrderDeliveryMapper.toDto(orderDeliveryRepository.saveAndFlush(OrderDeliveryMapper.toEntity(orderDelivery, false)), false);
    }

    @Override
    public Long size() {
        return orderDeliveryRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderDeliveryRepository.existsById(id);
    }

    @Override
    public OrderDelivery findById(Long id) throws IdNotFound {
        return OrderDeliveryMapper.toDto(orderDeliveryRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderDelivery> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderDeliveryMapper.toDtos(orderDeliveryRepository.findAll(Search.expression(search, TmsOrderDelivery.class)), false);
    }

    @Override
    public List<OrderDelivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderDeliveryMapper.toDtos(orderDeliveryRepository.findAll(Search.expression(search, TmsOrderDelivery.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderDeliveryRepository.count(Search.expression(search, TmsOrderDelivery.class));
    }

    @Override
    public void delete(Long id) {
        orderDeliveryRepository.deleteById(id);
    }

    @Override
    public void delete(OrderDelivery orderDelivery) {
        orderDeliveryRepository.delete(OrderDeliveryMapper.toEntity(orderDelivery, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderDeliveryRepository.deleteById(id);        }
    }


    @Override
    public List<OrderDelivery> findAll() {
        return OrderDeliveryMapper.toDtos(orderDeliveryRepository.findAll(), false);
    }

    @Override
    public List<OrderDelivery> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderDeliveryMapper.toDtos(orderDeliveryRepository.findAll(pageable), false);
    }

    @Override
    public OrderDelivery findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public String getNextVal() {
        String value="CL" + orderDeliveryRepository.getNextVal().get(0);
        return value;


    }

}

