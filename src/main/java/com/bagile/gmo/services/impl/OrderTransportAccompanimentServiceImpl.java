package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportAccompaniment;
import com.bagile.gmo.entities.TmsOrderTransportAccompaniment;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportAccompanimentMapper;
import com.bagile.gmo.repositories.OrderTransportAccompanimentRepository;
import com.bagile.gmo.services.OrderTransportAccompanimentService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTransportAccompanimentServiceImpl implements OrderTransportAccompanimentService {

    private final OrderTransportAccompanimentRepository orderTransportAccompanimentRepository;

    public OrderTransportAccompanimentServiceImpl(OrderTransportAccompanimentRepository orderTransportAccompanimentRepository) {
        this.orderTransportAccompanimentRepository = orderTransportAccompanimentRepository;
    }

    @Override
    public OrderTransportAccompaniment save(OrderTransportAccompaniment orderTransportAccompaniment) throws ErrorType, AttributesNotFound {

        return OrderTransportAccompanimentMapper.toDto(orderTransportAccompanimentRepository.saveAndFlush(OrderTransportAccompanimentMapper.toEntity(orderTransportAccompaniment, false)), false);

    }

    @Override
    public Long size() {
        return orderTransportAccompanimentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportAccompanimentRepository.existsById(id);
    }

    @Override
    public OrderTransportAccompaniment findById(Long id) throws IdNotFound {
        return OrderTransportAccompanimentMapper.toDto(orderTransportAccompanimentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportAccompaniment> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll();
        }
        return OrderTransportAccompanimentMapper.toDtos(orderTransportAccompanimentRepository.findAll(Search.expression(search, TmsOrderTransportAccompaniment.class)), false);
    }

    @Override
    public List<OrderTransportAccompaniment> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll(page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportAccompanimentMapper.toDtos(orderTransportAccompanimentRepository.findAll(Search.expression(search, TmsOrderTransportAccompaniment.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return size();
        }
        return orderTransportAccompanimentRepository.count(Search.expression(search, TmsOrderTransportAccompaniment.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportAccompanimentRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportAccompaniment orderTransportAccompaniment) {
        orderTransportAccompanimentRepository.delete(OrderTransportAccompanimentMapper.toEntity(orderTransportAccompaniment, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {


            orderTransportAccompanimentRepository.deleteById(id);
        }
    }


    @Override
    public List<OrderTransportAccompaniment> findAll() {
        return OrderTransportAccompanimentMapper.toDtos(orderTransportAccompanimentRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportAccompaniment> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportAccompanimentMapper.toDtos(orderTransportAccompanimentRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransportAccompaniment findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

