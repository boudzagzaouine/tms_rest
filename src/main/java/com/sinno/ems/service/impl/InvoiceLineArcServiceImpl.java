package com.sinno.ems.service.impl;

import com.sinno.ems.dto.InvoiceLineArc;
import com.sinno.ems.entities.InvInvoiceLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceLineArcMapper;
import com.sinno.ems.repositories.InvoiceLineArcRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.InvoiceLineArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineArcServiceImpl implements InvoiceLineArcService {

    @Autowired
    private InvoiceLineArcRepository invoiceLineArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceLineArcService.class);

    @Override
    public InvoiceLineArc save(InvoiceLineArc invoiceLineArc) {
        LOGGER.info("save InvoiceLineArc");
        return InvoiceLineArcMapper.toDto(invoiceLineArcRepository.saveAndFlush(InvoiceLineArcMapper.toEntity(invoiceLineArc, false)), false);
    }

    @Override
    public Long size() {
        return invoiceLineArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceLineArcRepository.exists(id);
    }

    @Override
    public InvoiceLineArc findById(Long id) throws IdNotFound {
        InvoiceLineArc invoiceLineArc = InvoiceLineArcMapper.toDto(invoiceLineArcRepository.findOne(id), false);
        if (null != invoiceLineArc) {
            return invoiceLineArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InvoiceLineArc> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceLineArcMapper.toDtos(invoiceLineArcRepository.findAll(Search.expression(search, InvInvoiceLineArc.class)), false);
    }

    @Override
    public List<InvoiceLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return InvoiceLineArcMapper.toDtos(invoiceLineArcRepository.findAll(Search.expression(search, InvInvoiceLineArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceLineArcRepository.count(Search.expression(search, InvInvoiceLineArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceLineArc");
        invoiceLineArcRepository.delete(id);
    }

    @Override
    public void delete(InvoiceLineArc invoiceLineArc) {
        LOGGER.info("delete InvoiceLineArc");
        invoiceLineArcRepository.delete(InvoiceLineArcMapper.toEntity(invoiceLineArc, false));
    }

    @Override
    public List<InvoiceLineArc> findAll() {
        return InvoiceLineArcMapper.toDtos(invoiceLineArcRepository.findAll(), false);
    }

    @Override
    public List<InvoiceLineArc> findAll(Pageable pageable) {
        return InvoiceLineArcMapper.toDtos(invoiceLineArcRepository.findAll(pageable), false);
    }
}