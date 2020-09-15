package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderType;
import com.bagile.gmo.entities.PrmOrderType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTypeMapper;
import com.bagile.gmo.repositories.OrderTypeRepository;
import com.bagile.gmo.services.OrderTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrderTypeServiceImpl implements OrderTypeService {
    private final OrderTypeRepository orderStatusRepository;
    public OrderTypeServiceImpl(OrderTypeRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderType save(OrderType orderType) {
        return OrderTypeMapper.toDto(orderStatusRepository.saveAndFlush(OrderTypeMapper.toEntity(orderType, false)), false);
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
    public OrderType findById(Long id) throws IdNotFound {
        return OrderTypeMapper.toDto(orderStatusRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public OrderType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<OrderType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTypeMapper.toDtos(orderStatusRepository.findAll(Search.expression(search, PrmOrderType.class)), false);
    }

    @Override
    public List<OrderType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTypeMapper.toDtos(orderStatusRepository.findAll(Search.expression(search, PrmOrderType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderStatusRepository.count(Search.expression(search, PrmOrderType.class));
    }

    @Override
    public void delete(Long id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public void delete(OrderType orderType) {
        orderStatusRepository.delete(OrderTypeMapper.toEntity(orderType, false));
    }

    @Override
    public List<OrderType> findAll() {
        return OrderTypeMapper.toDtos(orderStatusRepository.findAll(), false);
    }



    

    @Override
    public List<OrderType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTypeMapper.toDtos(orderStatusRepository.findAll(pageable), false);
    }

}

