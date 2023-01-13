package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportRejectType;
import com.bagile.gmo.entities.TmsOrderTransportRejectType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportRejectTypeMapper;
import com.bagile.gmo.repositories.OrderTransportRejectTypeRepository;
import com.bagile.gmo.services.OrderTransportRejectTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTransportRejectTypeServiceImpl implements OrderTransportRejectTypeService {
    
    private final OrderTransportRejectTypeRepository orderTransportRejectTypeRepository;

    public OrderTransportRejectTypeServiceImpl(OrderTransportRejectTypeRepository orderTransportRejectTypeRepository) {
        this.orderTransportRejectTypeRepository = orderTransportRejectTypeRepository;
    }

    @Override
    public OrderTransportRejectType save(OrderTransportRejectType OrderTransportRejectType) {
        return OrderTransportRejectTypeMapper.toDto(orderTransportRejectTypeRepository.saveAndFlush(OrderTransportRejectTypeMapper.toEntity(OrderTransportRejectType, false)), false);
    }

    @Override
    public Long size() {
        return orderTransportRejectTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportRejectTypeRepository.existsById(id);
    }

    @Override
    public OrderTransportRejectType findById(Long id) throws IdNotFound {
        return OrderTransportRejectTypeMapper.toDto(orderTransportRejectTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportRejectType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportRejectTypeMapper.toDtos(orderTransportRejectTypeRepository.findAll(Search.expression(search, TmsOrderTransportRejectType.class)), false);
    }

    @Override
    public List<OrderTransportRejectType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportRejectTypeMapper.toDtos(orderTransportRejectTypeRepository.findAll(Search.expression(search, TmsOrderTransportRejectType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportRejectTypeRepository.count(Search.expression(search, TmsOrderTransportRejectType.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportRejectTypeRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportRejectType OrderTransportRejectType) {
        orderTransportRejectTypeRepository.delete(OrderTransportRejectTypeMapper.toEntity(OrderTransportRejectType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportRejectTypeRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportRejectType> findAll() {
        return OrderTransportRejectTypeMapper.toDtos(orderTransportRejectTypeRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportRejectType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportRejectTypeMapper.toDtos(orderTransportRejectTypeRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransportRejectType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

