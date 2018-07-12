package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceDataMapper;
import com.sinno.ems.service.InvoiceDataService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by Enissay on 31/10/2016.
 */
public class InvoiceDataServiceImpl implements InvoiceDataService {
    @Autowired
    private InvoiceDataRepository invoiceDataRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceDataService.class);

    @Override
    public InvoiceData save(InvoiceData invoiceData) {
        LOGGER.info("save InvoiceData");
        return InvoiceDataMapper.toDto(invoiceDataRepository.saveAndFlush(InvoiceDataMapper.toEntity(invoiceData, false)), false);
    }

    @Override
    public Long size() {
        return invoiceDataRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceDataRepository.exists(id);
    }

    @Override
    public InvoiceData findById(Long id) throws IdNotFound {
        InvoiceData invoiceData = InvoiceDataMapper.toDto(invoiceDataRepository.findOne(id), false);
        if (null != invoiceData) {
            return invoiceData;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InvoiceData> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceDataMapper.toDtos(invoiceDataRepository.findAll(Search.expression(search, InvInvoiceData.class)), false);
    }

    @Override
    public List<InvoiceData> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "invInvoiceDataUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return InvoiceDataMapper.toDtos(invoiceDataRepository.findAll(Search.expression(search, InvInvoiceData.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceDataRepository.count(Search.expression(search, InvInvoiceData.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceData");
        invoiceDataRepository.delete(id);
    }

    @Override
    public void delete(InvoiceData invoiceData) {
        LOGGER.info("delete InvoiceData");
        invoiceDataRepository.delete(InvoiceDataMapper.toEntity(invoiceData, false));
    }

    @Override
    public List<InvoiceData> findAll() {
        return InvoiceDataMapper.toDtos(invoiceDataRepository.findAll(), false);
    }

    @Override
    public List<InvoiceData> findAll(Pageable pageable) {
        return InvoiceDataMapper.toDtos(invoiceDataRepository.findAll(pageable), false);
    }
}
