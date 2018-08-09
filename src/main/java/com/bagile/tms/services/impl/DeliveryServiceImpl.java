package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Delivery;
import com.bagile.tms.entities.CmdDelivery;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.WarehouseException;
import com.bagile.tms.mapper.DeliveryMapper;
import com.bagile.tms.repositories.DeliveryRepository;
import com.bagile.tms.services.DeliveryService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DeliveryService.class);



    @Transactional
    @Override
    public Delivery save(Delivery delivery) throws WarehouseException {
        LOGGER.info("save Delivery");
        delivery.setUpdateDate(EmsDate.getDateNow());

        if (0 >= delivery.getId()) {
            delivery.setCreationDate(EmsDate.getDateNow());
        }

        if (0 != delivery.getId() && (3 == delivery.getOrderStatus().getId() || 1 == delivery.getOrderStatus().getId())) {
            delivery = DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(delivery, false)), false);

        } else {
            delivery = DeliveryMapper.toDto(deliveryRepository.saveAndFlush(DeliveryMapper.toEntity(delivery, false)), false);
        }//}




        return delivery;
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
        Delivery delivery = DeliveryMapper.toDto(deliveryRepository.findById(id).get(), false);
        if (null != delivery) {
            return delivery;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Delivery> find(String search) throws AttributesNotFound, ErrorType {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class)), false);
    }

    @Override
    public List<Delivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdDeliveryUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return DeliveryMapper.toDtos(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return deliveryRepository.count(Search.expression(search, CmdDelivery.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Delivery");
        deliveryRepository.deleteById(id);
    }

    @Override
    public void delete(Delivery delivery) {
        LOGGER.info("delete Delivery");
        deliveryRepository.delete(DeliveryMapper.toEntity(delivery, false));
    }

    @Override
    public List<Delivery> findAll() {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(), false);
    }

    @Override
    public List<Delivery> findAll(Pageable pageable) {
        return DeliveryMapper.toDtos(deliveryRepository.findAll(pageable), false);
    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = deliveryRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }










}
