package com.sinno.ems.service.impl;

import com.sinno.ems.dto.InvoiceStatus;
import com.sinno.ems.entities.PrmInvoiceStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.InvoiceStatusMapper;
import com.sinno.ems.repositories.InvoiceStatusRepository;
import com.sinno.ems.service.InvoiceStatusService;
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
public class InvoiceStatusServiceImpl implements InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceStatusService.class);

    @Override
    public InvoiceStatus save(InvoiceStatus invoiceStatus) {
        LOGGER.info("save InvoiceStatus");
        invoiceStatus.setUpdateDate(EmsDate.getDateNow());
        if (0 >= invoiceStatus.getId()) {
            invoiceStatus.setCreationDate(EmsDate.getDateNow());
        }
        return InvoiceStatusMapper.toDto(invoiceStatusRepository.saveAndFlush(InvoiceStatusMapper.toEntity(invoiceStatus, false)), false);
    }

    @Override
    public Long size() {
        return invoiceStatusRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return invoiceStatusRepository.exists(id);
    }

    @Override
    public InvoiceStatus findById(Long id) throws IdNotFound {
        InvoiceStatus invoiceStatus = InvoiceStatusMapper.toDto(invoiceStatusRepository.findOne(id), false);
        if (null != invoiceStatus) {
            return invoiceStatus;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InvoiceStatus> find(String search) throws AttributesNotFound, ErrorType {
        return InvoiceStatusMapper.toDtos(invoiceStatusRepository.findAll(Search.expression(search, PrmInvoiceStatus.class)), false);
    }

    @Override
    public List<InvoiceStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"prmInvoiceStatusUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return InvoiceStatusMapper.toDtos(invoiceStatusRepository.findAll(Search.expression(search, PrmInvoiceStatus.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceStatusRepository.count(Search.expression(search, PrmInvoiceStatus.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceStatus");
        invoiceStatusRepository.delete(id);
    }

    @Override
    public void delete(InvoiceStatus invoiceStatus) {
        LOGGER.info("delete InvoiceStatus");
        invoiceStatusRepository.delete(InvoiceStatusMapper.toEntity(invoiceStatus, false));
    }

    @Override
    public List<InvoiceStatus> findAll() {
        return InvoiceStatusMapper.toDtos(invoiceStatusRepository.findAll(), false);
    }

    @Override
    public List<InvoiceStatus> findAll(Pageable pageable) {
        return InvoiceStatusMapper.toDtos(invoiceStatusRepository.findAll(pageable), false);
    }
}