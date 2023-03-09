package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportDocument;
import com.bagile.gmo.entities.TmsOrderTransportDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportDocumentMapper;
import com.bagile.gmo.repositories.OrderTransportDocumentRepository;
import com.bagile.gmo.services.OrderTransportDocumentService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderTransportDocumentServiceImpl implements OrderTransportDocumentService {
    
    private final OrderTransportDocumentRepository orderTransportDocumentRepository;

    public OrderTransportDocumentServiceImpl(OrderTransportDocumentRepository orderTransportDocumentRepository) {
        this.orderTransportDocumentRepository = orderTransportDocumentRepository;
    }

    @Override
    public OrderTransportDocument save(OrderTransportDocument orderTransportDocument) {
        return OrderTransportDocumentMapper.toDto(orderTransportDocumentRepository.saveAndFlush(OrderTransportDocumentMapper.toEntity(orderTransportDocument, false)), false);
    }

    @Override
    public Long size() {
        return orderTransportDocumentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportDocumentRepository.existsById(id);
    }

    @Override
    public OrderTransportDocument findById(Long id) throws IdNotFound {
        return OrderTransportDocumentMapper.toDto(orderTransportDocumentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportDocument> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(Search.expression(search, TmsOrderTransportDocument.class)), false);
    }

    @Override
    public List<OrderTransportDocument> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(Search.expression(search, TmsOrderTransportDocument.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportDocumentRepository.count(Search.expression(search, TmsOrderTransportDocument.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportDocumentRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportDocument orderTransportDocument) {
        orderTransportDocumentRepository.delete(OrderTransportDocumentMapper.toEntity(orderTransportDocument, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportDocumentRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportDocument> findAll() {
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportDocument> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportDocumentMapper.toDtos(orderTransportDocumentRepository.findAll(pageable), false);
    }


}

