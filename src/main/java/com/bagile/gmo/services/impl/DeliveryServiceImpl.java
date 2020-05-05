package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Delivery;
import com.bagile.gmo.dto.SaleOrder;
import com.bagile.gmo.entities.CmdDelivery;
import com.bagile.gmo.mapper.DeliveryMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.DeliveryRepository;
import com.bagile.gmo.services.DeliveryService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery save(Delivery delivery) {
        return DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(delivery, false)), false);
    }

    @Override
    public Long size() {
        return deliveryRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryRepository.existsById(id);
    }

    @Override
    public Delivery findById(Long id) throws IdNotFound {
        return DeliveryMapper.toDto(deliveryRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public Delivery findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<Delivery> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DeliveryMapper.toDtos(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class)), false);
    }

    @Override
    public List<Delivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DeliveryMapper.toDtos(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return deliveryRepository.count(Search.expression(search, CmdDelivery.class));
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public void delete(Delivery delivery) {
        deliveryRepository.delete(DeliveryMapper.toEntity(delivery, false));
    }

    @Override
    public List<Delivery> findAll() {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(), false);
    }


    @Override
    public String getNextVal() {
        return null;
    }

    @Override
    public List<Delivery> exportWmsSaleOrder(List<Delivery> deliveries) {
        return null;
    }

    @Override
    public void updateDelivery(Delivery delivery) {

    }

    @Override
    public Delivery generateDeliveryFromSaleOrder(SaleOrder saleOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return null;
    }

    @Override
    public void calculateAllLines(Delivery delivery) {

    }

    @Override
    public Delivery cancel(Delivery delivery) throws IdNotFound {
        return null;
    }


    @Override
    public Delivery close(Delivery delivery) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return null;
    }

    @Override
    public List<Delivery> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DeliveryMapper.toDtos(deliveryRepository.findAll(pageable), false);
    }

}

