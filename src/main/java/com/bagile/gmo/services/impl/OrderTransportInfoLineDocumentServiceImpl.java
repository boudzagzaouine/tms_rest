package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.dto.OrderTransportInfoLineDocument;
import com.bagile.gmo.entities.TmsOrderTransportInfoLineDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportInfoLineDocumentMapper;
import com.bagile.gmo.repositories.OrderTransportInfoLineDocumentRepository;
import com.bagile.gmo.services.DocumentService;
import com.bagile.gmo.services.OrderTransportDocumentService;
import com.bagile.gmo.services.OrderTransportInfoLineDocumentService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderTransportInfoLineDocumentServiceImpl implements OrderTransportInfoLineDocumentService {

    private final OrderTransportInfoLineDocumentRepository orderTransportInfoLineDocumentRepository;

    @Autowired
    private OrderTransportDocumentService orderTransportDocumentService;

    public OrderTransportInfoLineDocumentServiceImpl(OrderTransportInfoLineDocumentRepository orderTransportInfoLineDocumentRepository) {
        this.orderTransportInfoLineDocumentRepository = orderTransportInfoLineDocumentRepository;
    }

    @Override
    public OrderTransportInfoLineDocument save(OrderTransportInfoLineDocument orderTransportInfoLineDocument) {
           OrderTransportInfoLineDocument infoLineDocument = OrderTransportInfoLineDocumentMapper.toDto(orderTransportInfoLineDocumentRepository.saveAndFlush(OrderTransportInfoLineDocumentMapper.toEntity(orderTransportInfoLineDocument, false)), false);


        if(orderTransportInfoLineDocument.getOrderTransportDocumentList().size()>0) {
            orderTransportInfoLineDocument.getOrderTransportDocumentList().forEach(document -> {
                document.setOrderTransportInfoLineDocument(infoLineDocument);
            });

            try {
                this.orderTransportDocumentService.saveAll(   orderTransportInfoLineDocument.getOrderTransportDocumentList());
            } catch (ErrorType e) {
                throw new RuntimeException(e);
            } catch (IdNotFound e) {
                throw new RuntimeException(e);
            } catch (AttributesNotFound e) {
                throw new RuntimeException(e);
            }

        }
        return infoLineDocument;
    }

    @Override
    public List<OrderTransportInfoLineDocument> saveAll(List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments) throws AttributesNotFound, ErrorType {

        List<OrderTransportInfoLineDocument> orderTransportInfoLineDocumentList = new ArrayList<>();

        for (OrderTransportInfoLineDocument orderTransportInfoLineDocument : orderTransportInfoLineDocuments) {
            orderTransportInfoLineDocumentList.add(save(orderTransportInfoLineDocument));
        }

        return orderTransportInfoLineDocumentList;

    }
    @Override
    public Long size() {
        return orderTransportInfoLineDocumentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportInfoLineDocumentRepository.existsById(id);
    }

    @Override
    public OrderTransportInfoLineDocument findById(Long id) throws IdNotFound {
        return OrderTransportInfoLineDocumentMapper.toDto(orderTransportInfoLineDocumentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportInfoLineDocument> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(Search.expression(search, TmsOrderTransportInfoLineDocument.class)), false);
    }

    @Override
    public List<OrderTransportInfoLineDocument> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(Search.expression(search, TmsOrderTransportInfoLineDocument.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportInfoLineDocumentRepository.count(Search.expression(search, TmsOrderTransportInfoLineDocument.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportInfoLineDocumentRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportInfoLineDocument orderTransportInfoLineDocument) {
        orderTransportInfoLineDocumentRepository.delete(OrderTransportInfoLineDocumentMapper.toEntity(orderTransportInfoLineDocument, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportInfoLineDocumentRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportInfoLineDocument> findAll()
    {
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportInfoLineDocument> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoLineDocumentMapper.toDtos(orderTransportInfoLineDocumentRepository.findAll(pageable), false);
    }



}

