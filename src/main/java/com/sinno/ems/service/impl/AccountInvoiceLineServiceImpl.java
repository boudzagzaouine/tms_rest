package com.sinno.ems.service.impl;

import com.sinno.ems.dto.AccountInvoiceLine;
import com.sinno.ems.entities.InvAccountInvoiceLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AccountInvoiceLineMapper;
import com.sinno.ems.repositories.AccountInvoiceLineRepository;
import com.sinno.ems.service.AccountInvoiceLineService;
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

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class AccountInvoiceLineServiceImpl implements AccountInvoiceLineService {
    @Autowired
    private AccountInvoiceLineRepository accountInvoiceLineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AccountInvoiceLineService.class);


    @Override
    public AccountInvoiceLine save(AccountInvoiceLine accountInvoiceLine) {
        LOGGER.info("save AccountInvoiceLine");
        accountInvoiceLine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= accountInvoiceLine.getId()) {
            accountInvoiceLine.setCreationDate(EmsDate.getDateNow());
        }
        return AccountInvoiceLineMapper.toDto(accountInvoiceLineRepository.saveAndFlush(AccountInvoiceLineMapper.toEntity(accountInvoiceLine, false)), false);
    }

    @Override
    public Long size() {
        return accountInvoiceLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountInvoiceLineRepository.exists(id);
    }

    @Override
    public AccountInvoiceLine findById(Long id) throws IdNotFound {
        AccountInvoiceLine accountInvoiceLine = AccountInvoiceLineMapper.toDto(accountInvoiceLineRepository.findOne(id), false);
        if (null != accountInvoiceLine) {
            return accountInvoiceLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<AccountInvoiceLine> find(String search) throws AttributesNotFound, ErrorType {
        return AccountInvoiceLineMapper.toDtos(accountInvoiceLineRepository.findAll(Search.expression(search, InvAccountInvoiceLine.class)), false);
    }

    @Override
    public List<AccountInvoiceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "InvAccountInvoiceLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return AccountInvoiceLineMapper.toDtos(accountInvoiceLineRepository.findAll(Search.expression(search, InvAccountInvoiceLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return accountInvoiceLineRepository.count(Search.expression(search, InvAccountInvoiceLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete AccountInvoiceLine");
        accountInvoiceLineRepository.delete(id);
    }

    @Override
    public void delete(AccountInvoiceLine accountInvoiceLine) {
        LOGGER.info("delete AccountInvoiceLine");
        accountInvoiceLineRepository.delete(AccountInvoiceLineMapper.toEntity(accountInvoiceLine, false));
    }

    @Override
    public List<AccountInvoiceLine> findAll() {
        return AccountInvoiceLineMapper.toDtos(accountInvoiceLineRepository.findAll(), false);
    }

    @Override
    public List<AccountInvoiceLine> findAll(Pageable pageable) {
        return AccountInvoiceLineMapper.toDtos(accountInvoiceLineRepository.findAll(pageable), false);
    }

}
