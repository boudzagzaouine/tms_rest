package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderStatus;
import com.bagile.gmo.entities.PrmOrderStatus;
import com.bagile.gmo.mapper.OrderStatusMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.OrderStatusRepository;
import com.bagile.gmo.services.OrderStatusService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;
    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderStatus save(OrderStatus orderStatus) {
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
        return OrderStatusMapper.toDto(orderStatusRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public OrderStatus findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<OrderStatus> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(Search.expression(search, PrmOrderStatus.class)), false);
    }

    @Override
    public List<OrderStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(Search.expression(search, PrmOrderStatus.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderStatusRepository.count(Search.expression(search, PrmOrderStatus.class));
    }

    @Override
    public void delete(Long id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public void delete(OrderStatus orderStatus) {
        orderStatusRepository.delete(OrderStatusMapper.toEntity(orderStatus, false));
    }

    @Override
    public List<OrderStatus> findAll() {
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(), false);
    }



    @Override
    public OrderStatus closedStatus() {
        try {
            return findById(1L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
    }

    @Override
    public OrderStatus waitingStatus() throws IdNotFound {
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
    public OrderStatus validStatus() throws IdNotFound {
        return findById(8L);
    }

    @Override
    public OrderStatus toPrepareStatus() throws IdNotFound {
        return findById(9L);    }

    @Override
    public OrderStatus onProductionStatus() throws IdNotFound {
        return findById(10L);
    }


    @Override
    public OrderStatus finishedStatus() throws IdNotFound {
        return findById(11L);

    }

    @Override
    public List<OrderStatus> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderStatusMapper.toDtos(orderStatusRepository.findAll(pageable), false);
    }

}

