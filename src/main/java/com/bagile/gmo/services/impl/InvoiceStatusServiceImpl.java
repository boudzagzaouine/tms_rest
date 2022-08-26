package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.InvoiceStatus;
import com.bagile.gmo.entities.PrmInvoiceStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.InvoiceStatusMapper;
import com.bagile.gmo.repositories.InvoiceStatusRepository;
import com.bagile.gmo.services.InvoiceStatusService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class InvoiceStatusServiceImpl implements InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    private InvoiceStatus dispute;
    private InvoiceStatus created;
    private InvoiceStatus transferred;
    private InvoiceStatus closed;
    private InvoiceStatus canceled;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(InvoiceStatusService.class);

    @PostConstruct
    public void init() throws IdNotFound {
        dispute = findById(5L);
        created = findById(1L);
        transferred = findById(2L);
        closed = findById(3L);
        canceled = findById(4L);

    }

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
        return invoiceStatusRepository.existsById(id);
    }

    @Override
    public InvoiceStatus findById(Long id) throws IdNotFound {
        InvoiceStatus invoiceStatus = InvoiceStatusMapper.toDto(invoiceStatusRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
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
    public InvoiceStatus findOne(String search) throws AttributesNotFound, ErrorType {
        return InvoiceStatusMapper.toDto(invoiceStatusRepository.findOne(Search.expression(search, PrmInvoiceStatus.class)).orElseThrow(() -> new AttributesNotFound(search)), false);
    }

    @Override
    public List<InvoiceStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort =  Sort.by(Sort.Direction.DESC, "prmInvoiceStatusUpdateDate");

        Pageable pageable =  PageRequest.of(page, size, sort);
        return InvoiceStatusMapper.toDtos(invoiceStatusRepository.findAll(Search.expression(search, PrmInvoiceStatus.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return invoiceStatusRepository.count(Search.expression(search, PrmInvoiceStatus.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete InvoiceStatus");
        invoiceStatusRepository.deleteById(id);
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

    @Override

    public InvoiceStatus getDispute() {
        return dispute;
    }

    @Override

    public InvoiceStatus getCreated() {
        return created;
    }

    @Override

    public InvoiceStatus getTransferred() {
        return transferred;
    }

    @Override

    public InvoiceStatus getClosed() {
        return closed;
    }

    @Override
    public InvoiceStatus getCanceled() {
        return canceled;
    }
}