package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceArcMapper;
import com.sinno.ems.service.InvoiceArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceArcServiceImpl implements InvoiceArcService {

    @Autowired
    private InvoiceArcRepository invoiceArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceArcService.class);

    @Override
    public InvoiceArc save(InvoiceArc invoiceArc) {
        LOGGER.info("save InvoiceArc");
        return InvoiceArcMapper.toDto(invoiceArcRepository.saveAndFlush(InvoiceArcMapper.toEntity(invoiceArc, false)), false);
    }

    @Override
    public Long size() {
        return invoiceArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceArcRepository.exists(id);
    }

    @Override
    public InvoiceArc findById(Long id) throws IdNotFound {
        InvoiceArc invoiceArc = InvoiceArcMapper.toDto(invoiceArcRepository.findOne(id), false);
        if (null != invoiceArc) {
            return invoiceArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InvoiceArc> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceArcMapper.toDtos(invoiceArcRepository.findAll(Search.expression(search, InvInvoiceArc.class)), false);
    }

    @Override
    public List<InvoiceArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return InvoiceArcMapper.toDtos(invoiceArcRepository.findAll(Search.expression(search, InvInvoiceArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceArcRepository.count(Search.expression(search, InvInvoiceArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceArc");
        invoiceArcRepository.delete(id);
    }

    @Override
    public void delete(InvoiceArc invoiceArc) {
        LOGGER.info("delete InvoiceArc");
        invoiceArcRepository.delete(InvoiceArcMapper.toEntity(invoiceArc, false));
    }

    @Override
    public List<InvoiceArc> findAll() {
        return InvoiceArcMapper.toDtos(invoiceArcRepository.findAll(), false);
    }

    @Override
    public List<InvoiceArc> findAll(Pageable pageable) {
        return InvoiceArcMapper.toDtos(invoiceArcRepository.findAll(pageable), false);
    }
}