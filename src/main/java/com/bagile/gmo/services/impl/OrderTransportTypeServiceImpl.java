package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportType;
import com.bagile.gmo.entities.TmsOrderTransportType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportTypeMapper;
import com.bagile.gmo.repositories.OrderTransportTypeRepository;
import com.bagile.gmo.services.OrderTransportTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTransportTypeServiceImpl implements OrderTransportTypeService {
    
    private final OrderTransportTypeRepository orderTransportServiceRepository;

    public OrderTransportTypeServiceImpl(OrderTransportTypeRepository orderTransportServiceRepository) {
        this.orderTransportServiceRepository = orderTransportServiceRepository;
    }

    @Override
    public OrderTransportType save(OrderTransportType orderDeliveryType) {
        return OrderTransportTypeMapper.toDto(orderTransportServiceRepository.saveAndFlush(OrderTransportTypeMapper.toEntity(orderDeliveryType, false)), false);
    }

    @Override
    public Long size() {
        return orderTransportServiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportServiceRepository.existsById(id);
    }

    @Override
    public OrderTransportType findById(Long id) throws IdNotFound {
        return OrderTransportTypeMapper.toDto(orderTransportServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportTypeMapper.toDtos(orderTransportServiceRepository.findAll(Search.expression(search, TmsOrderTransportType.class)), false);
    }

    @Override
    public List<OrderTransportType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportTypeMapper.toDtos(orderTransportServiceRepository.findAll(Search.expression(search, TmsOrderTransportType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportServiceRepository.count(Search.expression(search, TmsOrderTransportType.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportServiceRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportType orderDeliveryType) {
        orderTransportServiceRepository.delete(OrderTransportTypeMapper.toEntity(orderDeliveryType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportServiceRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportType> findAll() {
        return OrderTransportTypeMapper.toDtos(orderTransportServiceRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportTypeMapper.toDtos(orderTransportServiceRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransportType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

