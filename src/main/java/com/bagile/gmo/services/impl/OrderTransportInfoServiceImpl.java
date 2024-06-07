package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportInfo;
import com.bagile.gmo.dto.OrderTransportInfoLine;
import com.bagile.gmo.entities.TmsOrderTransportInfo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportInfoMapper;
import com.bagile.gmo.repositories.OrderTransportInfoRepository;
import com.bagile.gmo.services.OrderTransportDocumentService;
import com.bagile.gmo.services.OrderTransportInfoLineDocumentService;
import com.bagile.gmo.services.OrderTransportInfoLineService;
import com.bagile.gmo.services.OrderTransportInfoService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderTransportInfoServiceImpl implements OrderTransportInfoService {
    
    private final OrderTransportInfoRepository orderTransportInfoRepository;
    private final OrderTransportInfoLineService orderTransportInfoLineService;


    @Autowired
    private OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService;
    @Autowired
    private OrderTransportDocumentService orderTransportDocumentService;

    public OrderTransportInfoServiceImpl(OrderTransportInfoRepository orderTransportInfoRepository, OrderTransportInfoLineService orderTransportInfoLineService) {
        this.orderTransportInfoRepository = orderTransportInfoRepository;
        this.orderTransportInfoLineService = orderTransportInfoLineService;
    }

    @Override
    public OrderTransportInfo save(OrderTransportInfo orderTransportInfo) throws ErrorType, AttributesNotFound {
      OrderTransportInfo transportInfo =  OrderTransportInfoMapper.toDto(orderTransportInfoRepository.saveAndFlush(OrderTransportInfoMapper.toEntity(orderTransportInfo, false)), false);
        if (orderTransportInfo.getOrderTransportInfoLines().size() > 0) {

            orderTransportInfo.getOrderTransportInfoLines().forEach(line -> {
                line.setOrderTransportInfo(transportInfo);
            });


      this.orderTransportInfoLineService.saveAll(orderTransportInfo.getOrderTransportInfoLines());
    }
      /* if(orderTransportInfo.getOrderTransportInfoLines()==null) {
           List<OrderTransportInfoLine> orderTransportInfoLines = this.orderTransportInfoLineService.find("orderTransportInfo.id:" + orderTransportInfo.getId());
           if (orderTransportInfoLines.size() > 0) {
               orderTransportInfo.setOrderTransportInfoLines(orderTransportInfoLines);
           }
       }
        */

        return transportInfo;
    }

    @Override
    public Long size() {
        return orderTransportInfoRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportInfoRepository.existsById(id);
    }

    @Override
    public OrderTransportInfo findById(Long id) throws IdNotFound {
        return OrderTransportInfoMapper.toDto(orderTransportInfoRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportInfo> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportInfoMapper.toDtos(orderTransportInfoRepository.findAll(Search.expression(search, TmsOrderTransportInfo.class)), false);
    }

    @Override
    public List<OrderTransportInfo> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoMapper.toDtos(orderTransportInfoRepository.findAll(Search.expression(search, TmsOrderTransportInfo.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportInfoRepository.count(Search.expression(search, TmsOrderTransportInfo.class));
    }

    @Override
    public void delete(Long id) {
        orderTransportInfoRepository.deleteById(id);
    }

    @Override
    public void deleteByOT(Long idOT) throws ErrorType, AttributesNotFound {
        List<Long> orderTransportInfos =find("orderTransport.id:"+idOT).stream().map(m-> m.getId()).collect(Collectors.toList());

        if(orderTransportInfos.size()>0){
            orderTransportInfoLineService.deleteByOtInfo(orderTransportInfos);
        }
        deleteAll(orderTransportInfos);

    }

    @Override
    public void delete(OrderTransportInfo orderTransportInfo) {
        orderTransportInfoRepository.delete(OrderTransportInfoMapper.toEntity(orderTransportInfo, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {


            orderTransportInfoRepository.deleteById(id);
        }
    }


    @Override
    public List<OrderTransportInfo> findAll() {
        return OrderTransportInfoMapper.toDtos(orderTransportInfoRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportInfo> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoMapper.toDtos(orderTransportInfoRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransportInfo findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

