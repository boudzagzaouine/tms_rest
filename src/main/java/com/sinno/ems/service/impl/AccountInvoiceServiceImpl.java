package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AccountInvoiceMapper;
import com.sinno.ems.service.AccountInvoiceService;
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
public class AccountInvoiceServiceImpl implements AccountInvoiceService {
    @Autowired
    private AccountInvoiceRepository accountInvoiceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AccountInvoiceService.class);

    @Override
    public AccountInvoice save(AccountInvoice accountInvoice) {
        LOGGER.info("save AccountInvoice");
        accountInvoice.setUpdateDate(EmsDate.getDateNow());
        if (0 >= accountInvoice.getId()) {
            accountInvoice.setCreationDate(EmsDate.getDateNow());
        }
        return AccountInvoiceMapper.toDto(accountInvoiceRepository.saveAndFlush(AccountInvoiceMapper.toEntity(accountInvoice, false)), false);
    }

    @Override
    public Long size() {
        return accountInvoiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountInvoiceRepository.exists(id);
    }

    @Override
    public AccountInvoice findById(Long id) throws IdNotFound {
        AccountInvoice accountInvoice = AccountInvoiceMapper.toDto(accountInvoiceRepository.findOne(id), false);
        if (null != accountInvoice) {
            return accountInvoice;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<AccountInvoice> find(String search) throws AttributesNotFound, ErrorType {
        return AccountInvoiceMapper.toDtos(accountInvoiceRepository.findAll(Search.expression(search, InvAccountInvoice.class)), false);
    }

    @Override
    public List<AccountInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "invAccountInvoiceUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return AccountInvoiceMapper.toDtos(accountInvoiceRepository.findAll(Search.expression(search, InvAccountInvoice.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return accountInvoiceRepository.count(Search.expression(search, InvAccountInvoice.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete AccountInvoice");
        accountInvoiceRepository.delete(id);
    }

    @Override
    public void delete(AccountInvoice accountInvoice) {
        LOGGER.info("delete AccountInvoice");
        accountInvoiceRepository.delete(AccountInvoiceMapper.toEntity(accountInvoice, false));
    }

    @Override
    public List<AccountInvoice> findAll() {
        return AccountInvoiceMapper.toDtos(accountInvoiceRepository.findAll(), false);
    }

    @Override
    public List<AccountInvoice> findAll(Pageable pageable) {
        return AccountInvoiceMapper.toDtos(accountInvoiceRepository.findAll(pageable), false);
    }
    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = accountInvoiceRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }

}
