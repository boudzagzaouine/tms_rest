package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransport;
import com.bagile.gmo.entities.TmsOrderTransport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportMapper;
import com.bagile.gmo.repositories.OrderTransportRepository;
import com.bagile.gmo.services.OrderTransportService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTransportServiceImpl implements OrderTransportService {
    
    private final OrderTransportRepository orderDeliveryRepository;

    public OrderTransportServiceImpl(OrderTransportRepository orderDeliveryRepository) {
        this.orderDeliveryRepository = orderDeliveryRepository;
    }

    @Override
    public OrderTransport save(OrderTransport orderDelivery) {
        return OrderTransportMapper.toDto(orderDeliveryRepository.saveAndFlush(OrderTransportMapper.toEntity(orderDelivery, false)), false);
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
    public OrderTransport findById(Long id) throws IdNotFound {
        return OrderTransportMapper.toDto(orderDeliveryRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransport> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportMapper.toDtos(orderDeliveryRepository.findAll(Search.expression(search, TmsOrderTransport.class)), false);
    }

    @Override
    public List<OrderTransport> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportMapper.toDtos(orderDeliveryRepository.findAll(Search.expression(search, TmsOrderTransport.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderDeliveryRepository.count(Search.expression(search, TmsOrderTransport.class));
    }

    @Override
    public void delete(Long id) {
        orderDeliveryRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransport orderDelivery) {
        orderDeliveryRepository.delete(OrderTransportMapper.toEntity(orderDelivery, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderDeliveryRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransport> findAll() {
        return OrderTransportMapper.toDtos(orderDeliveryRepository.findAll(), false);
    }

    @Override
    public List<OrderTransport> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportMapper.toDtos(orderDeliveryRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransport findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public String getNextVal() {
        String value="OT" + orderDeliveryRepository.getNextVal().get(0);
        return value;


    }

}

