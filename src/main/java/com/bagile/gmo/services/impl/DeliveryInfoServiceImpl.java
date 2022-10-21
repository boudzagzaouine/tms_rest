package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.DeliveryInfo;
import com.bagile.gmo.entities.TmsDeliveryInfo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.DeliveryInfoMapper;
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
    public DeliveryInfo save(DeliveryInfo deliveryInfo) {
        return DeliveryInfoMapper.toDto(deliveryInfoRepository.saveAndFlush(DeliveryInfoMapper.toEntity(deliveryInfo, false)), false);
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
    public DeliveryInfo findById(Long id) throws IdNotFound {
        return DeliveryInfoMapper.toDto(deliveryInfoRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<DeliveryInfo> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DeliveryInfoMapper.toDtos(deliveryInfoRepository.findAll(Search.expression(search, TmsDeliveryInfo.class)), false);
    }

    @Override
    public List<DeliveryInfo> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DeliveryInfoMapper.toDtos(deliveryInfoRepository.findAll(Search.expression(search, TmsDeliveryInfo.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return deliveryInfoRepository.count(Search.expression(search, TmsDeliveryInfo.class));
    }

    @Override
    public void delete(Long id) {
        deliveryInfoRepository.deleteById(id);
    }

    @Override
    public void delete(DeliveryInfo deliveryInfo) {
        deliveryInfoRepository.delete(DeliveryInfoMapper.toEntity(deliveryInfo, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            deliveryInfoRepository.deleteById(id);        }
    }


    @Override
    public List<DeliveryInfo> findAll() {
        return DeliveryInfoMapper.toDtos(deliveryInfoRepository.findAll(), false);
    }

    @Override
    public List<DeliveryInfo> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DeliveryInfoMapper.toDtos(deliveryInfoRepository.findAll(pageable), false);
    }

    @Override
    public DeliveryInfo findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }



}

