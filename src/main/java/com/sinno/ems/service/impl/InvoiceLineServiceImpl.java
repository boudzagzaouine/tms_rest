package com.sinno.ems.service.impl;

import com.sinno.ems.dto.InvoiceLine;
import com.sinno.ems.entities.InvInvoiceLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceLineMapper;
import com.sinno.ems.repositories.InvoiceLineRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.InvoiceLineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineServiceImpl implements InvoiceLineService {

    @Autowired
    private InvoiceLineRepository invoiceLineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceLineService.class);

    @Override
    public InvoiceLine save(InvoiceLine invoiceLine) {
        LOGGER.info("save InvoiceLine");
        invoiceLine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= invoiceLine.getId()) {
            invoiceLine.setCreationDate(EmsDate.getDateNow());
        }
        return InvoiceLineMapper.toDto(invoiceLineRepository.saveAndFlush(InvoiceLineMapper.toEntity(invoiceLine, false)), false);
    }

    @Override
    public Long size() {
        return invoiceLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceLineRepository.exists(id);
    }

    @Override
    public InvoiceLine findById(Long id) throws IdNotFound {
        InvoiceLine invoiceLine = InvoiceLineMapper.toDto(invoiceLineRepository.findOne(id), false);
        if (null != invoiceLine) {
            return invoiceLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InvoiceLine> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceLineMapper.toDtos(invoiceLineRepository.findAll(Search.expression(search, InvInvoiceLine.class)), false);
    }

    @Override
    public List<InvoiceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"invInvoiceLinesUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return InvoiceLineMapper.toDtos(invoiceLineRepository.findAll(Search.expression(search, InvInvoiceLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceLineRepository.count(Search.expression(search, InvInvoiceLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceLine");
        invoiceLineRepository.delete(id);
    }

    @Override
    public void delete(InvoiceLine invoiceLine) {
        LOGGER.info("delete InvoiceLine");
        invoiceLineRepository.delete(InvoiceLineMapper.toEntity(invoiceLine, false));
    }

    @Override
    public List<InvoiceLine> findAll() {
        return InvoiceLineMapper.toDtos(invoiceLineRepository.findAll(), false);
    }

    @Override
    public List<InvoiceLine> findAll(Pageable pageable) {
        return InvoiceLineMapper.toDtos(invoiceLineRepository.findAll(pageable), false);
    }
}