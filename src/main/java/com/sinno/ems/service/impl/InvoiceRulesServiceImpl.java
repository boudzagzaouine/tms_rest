package com.sinno.ems.service.impl;

import com.sinno.ems.dto.InvoiceRules;
import com.sinno.ems.entities.InvInvoiceRules;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceRulesMapper;
import com.sinno.ems.repositories.InvoiceRulesRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.InvoiceRulesService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceRulesServiceImpl implements InvoiceRulesService {

    @Autowired
    private InvoiceRulesRepository invoiceRulesRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceRulesService.class);

    @Override
    public InvoiceRules save(InvoiceRules invoiceRules) {
        LOGGER.info("save InvoiceRules");
        return InvoiceRulesMapper.toDto(invoiceRulesRepository.saveAndFlush(InvoiceRulesMapper.toEntity(invoiceRules, false)), false);
    }

    @Override
    public Long size() {
        return invoiceRulesRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceRulesRepository.exists(id);
    }

    @Override
    public InvoiceRules findById(Long id) throws IdNotFound {
        InvoiceRules invoiceRules = InvoiceRulesMapper.toDto(invoiceRulesRepository.findOne(id), false);
        if (null != invoiceRules) {
            return invoiceRules;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InvoiceRules> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceRulesMapper.toDtos(invoiceRulesRepository.findAll(Search.expression(search, InvInvoiceRules.class)), false);
    }

    @Override
    public List<InvoiceRules> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return InvoiceRulesMapper.toDtos(invoiceRulesRepository.findAll(Search.expression(search, InvInvoiceRules.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceRulesRepository.count(Search.expression(search, InvInvoiceRules.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceRules");
        invoiceRulesRepository.delete(id);
    }

    @Override
    public void delete(InvoiceRules invoiceRules) {
        LOGGER.info("delete InvoiceRules");
        invoiceRulesRepository.delete(InvoiceRulesMapper.toEntity(invoiceRules, false));
    }

    @Override
    public List<InvoiceRules> findAll() {
        return InvoiceRulesMapper.toDtos(invoiceRulesRepository.findAll(), false);
    }

    @Override
    public List<InvoiceRules> findAll(Pageable pageable) {
        return InvoiceRulesMapper.toDtos(invoiceRulesRepository.findAll(pageable), false);
    }
}