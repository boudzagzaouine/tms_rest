package com.sinno.ems.service.impl;

import com.sinno.ems.dto.SupplierInvoice;
import com.sinno.ems.entities.InvSupplierInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.SupplierInvoiceMapper;
import com.sinno.ems.repositories.SupplierInvoiceRepository;
import com.sinno.ems.service.SupplierInvoiceService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class SupplierInvoiceServiceImpl implements SupplierInvoiceService {
    @Autowired
    private SupplierInvoiceRepository supplierInvoiceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierInvoiceService.class);

    @Override
    public SupplierInvoice save(SupplierInvoice supplierInvoice) {
        LOGGER.info("save SupplierInvoice");
        supplierInvoice.setUpdateDate(EmsDate.getDateNow());
        if (0 >= supplierInvoice.getId()) {
            supplierInvoice.setCreationDate(EmsDate.getDateNow());
        }
        return SupplierInvoiceMapper.toDto(supplierInvoiceRepository.saveAndFlush(SupplierInvoiceMapper.toEntity(supplierInvoice, false)), false);
    }

    @Override
    public Long size() {
        return supplierInvoiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierInvoiceRepository.exists(id);
    }

    @Override
    public SupplierInvoice findById(Long id) throws IdNotFound {
        SupplierInvoice paymentSupplier = SupplierInvoiceMapper.toDto(supplierInvoiceRepository.findOne(id), false);
        if (null != paymentSupplier) {
            return paymentSupplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SupplierInvoice> find(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(Search.expression(search, InvSupplierInvoice.class)), false);
    }

    @Override
    public List<SupplierInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "invSupplierInvoiceUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(Search.expression(search, InvSupplierInvoice.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return supplierInvoiceRepository.count(Search.expression(search, InvSupplierInvoice.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SupplierInvoice");
        supplierInvoiceRepository.delete(id);
    }

    @Override
    public void delete(SupplierInvoice paymentSupplier) {
        LOGGER.info("delete SupplierInvoice");
        supplierInvoiceRepository.delete(SupplierInvoiceMapper.toEntity(paymentSupplier, false));
    }

    @Override
    public List<SupplierInvoice> findAll() {
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(), false);
    }

    @Override
    public List<SupplierInvoice> findAll(Pageable pageable) {
        return SupplierInvoiceMapper.toDtos(supplierInvoiceRepository.findAll(pageable), false);
    }
    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = supplierInvoiceRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }
}
