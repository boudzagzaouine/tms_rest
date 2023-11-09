package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportInfoLine;
import com.bagile.gmo.dto.OrderTransportInfoLineDocument;
import com.bagile.gmo.entities.TmsOrderTransportInfoLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportInfoLineMapper;
import com.bagile.gmo.repositories.OrderTransportInfoLineRepository;
import com.bagile.gmo.services.OrderTransportInfoLineDocumentService;
import com.bagile.gmo.services.OrderTransportInfoLineService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderTransportInfoLineServiceImpl implements OrderTransportInfoLineService {

    private final OrderTransportInfoLineRepository orderTransportInfoLineRepository;
    @Autowired
    private OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService;


    public OrderTransportInfoLineServiceImpl(OrderTransportInfoLineRepository orderTransportInfoLineRepository) {
        this.orderTransportInfoLineRepository = orderTransportInfoLineRepository;
    }

    @Override
    public OrderTransportInfoLine save(OrderTransportInfoLine orderTransportInfoLine) {
        OrderTransportInfoLine orderTransportInfoLine1 = OrderTransportInfoLineMapper.toDto(orderTransportInfoLineRepository.saveAndFlush(OrderTransportInfoLineMapper.toEntity(orderTransportInfoLine, false)), false);

        if (orderTransportInfoLine.getOrderTransportInfoLineDocuments().size() > 0) {
            orderTransportInfoLine.getOrderTransportInfoLineDocuments().forEach(document -> {
                document.setOrderTransportInfoLine(orderTransportInfoLine1);
            });

            try {
                this.orderTransportInfoLineDocumentService.saveAll(orderTransportInfoLine.getOrderTransportInfoLineDocuments());
            } catch (AttributesNotFound e) {
                throw new RuntimeException(e);
            } catch (ErrorType e) {
                throw new RuntimeException(e);
            }

        }
        return orderTransportInfoLine1;
    }

    @Override
    public List<OrderTransportInfoLine> saveAll(List<OrderTransportInfoLine> orderTransportInfoLines) throws AttributesNotFound, ErrorType {

        List<OrderTransportInfoLine> infoLines = new ArrayList<>();

        for (OrderTransportInfoLine orderTransportInfoLineDocument : orderTransportInfoLines) {
            infoLines.add(save(orderTransportInfoLineDocument));
        }

        return infoLines;

    }

    @Override
    public Long size() {
        return orderTransportInfoLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportInfoLineRepository.existsById(id);
    }

    @Override
    public OrderTransportInfoLine findById(Long id) throws IdNotFound {
        return OrderTransportInfoLineMapper.toDto(orderTransportInfoLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportInfoLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll();
        }
        return OrderTransportInfoLineMapper.toDtos(orderTransportInfoLineRepository.findAll(Search.expression(search, TmsOrderTransportInfoLine.class)), false);
    }

    @Override
    public List<OrderTransportInfoLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll(page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoLineMapper.toDtos(orderTransportInfoLineRepository.findAll(Search.expression(search, TmsOrderTransportInfoLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return size();
        }
        return orderTransportInfoLineRepository.count(Search.expression(search, TmsOrderTransportInfoLine.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportInfoLineRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportInfoLine orderDeliveryType) {
        orderTransportInfoLineRepository.delete(OrderTransportInfoLineMapper.toEntity(orderDeliveryType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            orderTransportInfoLineRepository.deleteById(id);
        }
    }


    @Override
    public List<OrderTransportInfoLine> findAll() {
        return OrderTransportInfoLineMapper.toDtos(orderTransportInfoLineRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportInfoLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoLineMapper.toDtos(orderTransportInfoLineRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransportInfoLine findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

