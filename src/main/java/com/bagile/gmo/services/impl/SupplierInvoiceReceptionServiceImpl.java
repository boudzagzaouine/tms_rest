package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SupplierInvoiceReception;
import com.bagile.gmo.entities.InvSupplierInvoiceReception;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SupplierInvoiceReceptionMapper;
import com.bagile.gmo.repositories.SupplierInvoiceReceptionRepository;
import com.bagile.gmo.services.SupplierInvoiceReceptionService;

import com.bagile.gmo.util.Search;
import org.hibernate.jpa.internal.util.PersistenceUtilHelper;
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
public class SupplierInvoiceReceptionServiceImpl implements SupplierInvoiceReceptionService {

    @Autowired
    private SupplierInvoiceReceptionRepository deliveryInvoiceReceptionRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierInvoiceReceptionService.class);

    @Override
    public SupplierInvoiceReception save(SupplierInvoiceReception deliveryInvoiceReception) {
        LOGGER.info("save SupplierInvoiceReception");
  
        return SupplierInvoiceReceptionMapper.toDto(deliveryInvoiceReceptionRepository.saveAndFlush(SupplierInvoiceReceptionMapper.toEntity(deliveryInvoiceReception, false)), false);
    }
    @Override
    public SupplierInvoiceReception findOne(String search) throws AttributesNotFound, ErrorType
    {
        return SupplierInvoiceReceptionMapper.toDto(deliveryInvoiceReceptionRepository.findOne(Search.expression(search, InvSupplierInvoiceReception.class)).orElseThrow(()-> new AttributesNotFound(search)), false);
    }
    @Override
    public Long size() {
        return deliveryInvoiceReceptionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryInvoiceReceptionRepository.existsById(id);
    }

    @Override
    public SupplierInvoiceReception findById(Long id) throws IdNotFound {
        SupplierInvoiceReception deliveryInvoiceReception = SupplierInvoiceReceptionMapper.toDto(deliveryInvoiceReceptionRepository.findById(id).orElseThrow(()-> new IdNotFound(id)), false);
        if (null != deliveryInvoiceReception) {
            return deliveryInvoiceReception;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SupplierInvoiceReception> find(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceReceptionMapper.toDtos(deliveryInvoiceReceptionRepository.findAll(Search.expression(search, InvSupplierInvoiceReception.class)), false);
    }

    @Override
    public List<SupplierInvoiceReception> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceReceptionMapper.toDtos(deliveryInvoiceReceptionRepository.findAll(Search.expression(search, InvSupplierInvoiceReception.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return deliveryInvoiceReceptionRepository.count(Search.expression(search, InvSupplierInvoiceReception.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SupplierInvoiceReception");
        deliveryInvoiceReceptionRepository.deleteById(id);
    }

    @Override
    public void delete(SupplierInvoiceReception deliveryInvoiceReception) {
        LOGGER.info("delete SupplierInvoiceReception");
        deliveryInvoiceReceptionRepository.delete(SupplierInvoiceReceptionMapper.toEntity(deliveryInvoiceReception, false));
    }

    @Override
    public List<SupplierInvoiceReception> findAll() {
        return SupplierInvoiceReceptionMapper.toDtos(deliveryInvoiceReceptionRepository.findAll(), false);
    }

    @Override
    public List<SupplierInvoiceReception> findAll(Pageable pageable) {
        return SupplierInvoiceReceptionMapper.toDtos(deliveryInvoiceReceptionRepository.findAll(pageable), false);
    }
}