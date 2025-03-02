package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OrderTransportInfo;
import com.bagile.gmo.entities.TmsOrderTransportInfo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportInfoMapper;
import com.bagile.gmo.repositories.DeliveryInfoRepository;
import com.bagile.gmo.services.DeliveryInfoService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {
    
    private final DeliveryInfoRepository deliveryInfoRepository;

    public DeliveryInfoServiceImpl(DeliveryInfoRepository deliveryInfoRepository) {
        this.deliveryInfoRepository = deliveryInfoRepository;
    }

    @Override
    public OrderTransportInfo save(OrderTransportInfo deliveryInfo) {
        return OrderTransportInfoMapper.toDto(deliveryInfoRepository.saveAndFlush(OrderTransportInfoMapper.toEntity(deliveryInfo, false)), false);
    }

    @Override
    public Long size() {
        return deliveryInfoRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryInfoRepository.existsById(id);
    }

    @Override
    public OrderTransportInfo findById(Long id) throws IdNotFound {
        return OrderTransportInfoMapper.toDto(deliveryInfoRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransportInfo> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportInfoMapper.toDtos(deliveryInfoRepository.findAll(Search.expression(search, TmsOrderTransportInfo.class)), false);
    }

    @Override
    public List<OrderTransportInfo> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoMapper.toDtos(deliveryInfoRepository.findAll(Search.expression(search, TmsOrderTransportInfo.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return deliveryInfoRepository.count(Search.expression(search, TmsOrderTransportInfo.class));
    }

    @Override
    public void delete(Long id) {
        deliveryInfoRepository.deleteById(id);
    }

    @Override
    public void delete(OrderTransportInfo deliveryInfo) {
        deliveryInfoRepository.delete(OrderTransportInfoMapper.toEntity(deliveryInfo, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            deliveryInfoRepository.deleteById(id);        }
    }


    @Override
    public List<OrderTransportInfo> findAll() {
        return OrderTransportInfoMapper.toDtos(deliveryInfoRepository.findAll(), false);
    }

    @Override
    public List<OrderTransportInfo> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportInfoMapper.toDtos(deliveryInfoRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransportInfo findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }



}

