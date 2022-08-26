package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.SupplierInvoicePurchaseOrder;
import com.bagile.gmo.entities.InvSupplierInvoicePurchaseOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SupplierInvoicePurchaseOrderMapper;
import com.bagile.gmo.repositories.SupplierInvoicePurchaseOrderRepository;
import com.bagile.gmo.services.SupplierInvoicePurchaseOrderService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this entity is not used yet in out project
 */
@Service
public class SupplierInvoicePurchaseOrderServiceImpl implements SupplierInvoicePurchaseOrderService {

    @Autowired
    private SupplierInvoicePurchaseOrderRepository deliveryInvoicePurchaseOrderRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierInvoicePurchaseOrderService.class);

    @Override
    public SupplierInvoicePurchaseOrder save(SupplierInvoicePurchaseOrder deliveryInvoicePurchaseOrder) {
        LOGGER.info("save SupplierInvoicePurchaseOrder");
  
        return SupplierInvoicePurchaseOrderMapper.toDto(deliveryInvoicePurchaseOrderRepository.saveAndFlush(SupplierInvoicePurchaseOrderMapper.toEntity(deliveryInvoicePurchaseOrder, false)), false);
    }
    @Override
    public SupplierInvoicePurchaseOrder findOne(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoicePurchaseOrderMapper.toDto(deliveryInvoicePurchaseOrderRepository.findOne(Search.expression(search, InvSupplierInvoicePurchaseOrder.class)).orElseThrow(()-> new AttributesNotFound(search)), false);
    }
    @Override
    public Long size() {
        return deliveryInvoicePurchaseOrderRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryInvoicePurchaseOrderRepository.existsById(id);
    }

    @Override
    public SupplierInvoicePurchaseOrder findById(Long id) throws IdNotFound {
        SupplierInvoicePurchaseOrder deliveryInvoicePurchaseOrder = SupplierInvoicePurchaseOrderMapper.toDto(deliveryInvoicePurchaseOrderRepository.findById(id).orElseThrow(()-> new IdNotFound(id)), false);
        if (null != deliveryInvoicePurchaseOrder) {
            return deliveryInvoicePurchaseOrder;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SupplierInvoicePurchaseOrder> find(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoicePurchaseOrderMapper.toDtos(deliveryInvoicePurchaseOrderRepository.findAll(Search.expression(search, InvSupplierInvoicePurchaseOrder.class)), false);
    }

    @Override
    public List<SupplierInvoicePurchaseOrder> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return SupplierInvoicePurchaseOrderMapper.toDtos(deliveryInvoicePurchaseOrderRepository.findAll(Search.expression(search, InvSupplierInvoicePurchaseOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return deliveryInvoicePurchaseOrderRepository.count(Search.expression(search, InvSupplierInvoicePurchaseOrder.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SupplierInvoicePurchaseOrder");
        deliveryInvoicePurchaseOrderRepository.deleteById(id);
    }

    @Override
    public void delete(SupplierInvoicePurchaseOrder deliveryInvoicePurchaseOrder) {
        LOGGER.info("delete SupplierInvoicePurchaseOrder");
        deliveryInvoicePurchaseOrderRepository.delete(SupplierInvoicePurchaseOrderMapper.toEntity(deliveryInvoicePurchaseOrder, false));
    }

    @Override
    public List<SupplierInvoicePurchaseOrder> findAll() {
        return SupplierInvoicePurchaseOrderMapper.toDtos(deliveryInvoicePurchaseOrderRepository.findAll(), false);
    }

    @Override
    public List<SupplierInvoicePurchaseOrder> findAll(Pageable pageable) {
        return SupplierInvoicePurchaseOrderMapper.toDtos(deliveryInvoicePurchaseOrderRepository.findAll(pageable), false);
    }
}