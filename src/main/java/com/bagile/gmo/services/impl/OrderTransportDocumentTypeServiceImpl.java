package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportDocumentType;
import com.bagile.gmo.entities.TmsOrderTransportDocumentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportDocumentTypeMapper;
import com.bagile.gmo.repositories.OrderTransportDocumentTypeRepository;
import com.bagile.gmo.services.OrderTransportDocumentTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTransportDocumentTypeServiceImpl implements OrderTransportDocumentTypeService {
    
    private final OrderTransportDocumentTypeRepository orderTransportDocumentTypeRepository;

    public OrderTransportDocumentTypeServiceImpl(OrderTransportDocumentTypeRepository orderTransportDocumentTypeRepository) {
        this.orderTransportDocumentTypeRepository = orderTransportDocumentTypeRepository;
    }

    @Override
    public OrderTransportDocumentType save(OrderTransportDocumentType orderTransportDocumentType) {
        return OrderTransportDocumentTypeMapper.toDto(orderTransportDocumentTypeRepository.saveAndFlush(OrderTransportDocumentTypeMapper.toEntity(orderTransportDocumentType, false)), false);
    }

    @Override
    public Long size() {
        return orderTransportDocumentTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportDocumentTypeRepository.existsById(id);
    }

    @Override
    public OrderTransportDocumentType findById(Long id) throws IdNotFound {
        return OrderTransportDocumentTypeMapper.toDto(orderTransportDocumentTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportDocumentType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportDocumentTypeMapper.toDtos(orderTransportDocumentTypeRepository.findAll(Search.expression(search, TmsOrderTransportDocumentType.class)), false);
    }

    @Override
    public List<OrderTransportDocumentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportDocumentTypeMapper.toDtos(orderTransportDocumentTypeRepository.findAll(Search.expression(search, TmsOrderTransportDocumentType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportDocumentTypeRepository.count(Search.expression(search, TmsOrderTransportDocumentType.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportDocumentTypeRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportDocumentType orderTransportDocumentType) {
        orderTransportDocumentTypeRepository.delete(OrderTransportDocumentTypeMapper.toEntity(orderTransportDocumentType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportDocumentTypeRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportDocumentType> findAll() {
        return OrderTransportDocumentTypeMapper.toDtos(orderTransportDocumentTypeRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportDocumentType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportDocumentTypeMapper.toDtos(orderTransportDocumentTypeRepository.findAll(pageable), false);
    }


}

