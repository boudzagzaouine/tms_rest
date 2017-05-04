package com.sinno.ems.service.impl;

import com.sinno.ems.dto.AccountLitigation;
import com.sinno.ems.entities.InvAccountLitigation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AccountLitigationMapper;
import com.sinno.ems.repositories.AccountLitigationRepository;
import com.sinno.ems.service.AccountLitigationService;
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
public class AccountLitigationServiceImpl implements AccountLitigationService {
    @Autowired
    private AccountLitigationRepository accountLitigationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AccountLitigationService.class);

    @Override
    public AccountLitigation save(AccountLitigation paymentSupplier) {
        LOGGER.info("save AccountLitigation");
        paymentSupplier.setUpdateDate(EmsDate.getDateNow());
        if (0 >= paymentSupplier.getId()) {
            paymentSupplier.setCreationDate(EmsDate.getDateNow());
        }
        return AccountLitigationMapper.toDto(accountLitigationRepository.saveAndFlush(AccountLitigationMapper.toEntity(paymentSupplier, false)), false);
    }

    @Override
    public Long size() {
        return accountLitigationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountLitigationRepository.exists(id);
    }

    @Override
    public AccountLitigation findById(Long id) throws IdNotFound {
        AccountLitigation paymentSupplier = AccountLitigationMapper.toDto(accountLitigationRepository.findOne(id), false);
        if (null != paymentSupplier) {
            return paymentSupplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<AccountLitigation> find(String search) throws AttributesNotFound, ErrorType {
        return AccountLitigationMapper.toDtos(accountLitigationRepository.findAll(Search.expression(search, InvAccountLitigation.class)), false);
    }

    @Override
    public List<AccountLitigation> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "InvAccountLitigationUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return AccountLitigationMapper.toDtos(accountLitigationRepository.findAll(Search.expression(search, InvAccountLitigation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return accountLitigationRepository.count(Search.expression(search, InvAccountLitigation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete AccountLitigation");
        accountLitigationRepository.delete(id);
    }

    @Override
    public void delete(AccountLitigation paymentSupplier) {
        LOGGER.info("delete AccountLitigation");
        accountLitigationRepository.delete(AccountLitigationMapper.toEntity(paymentSupplier, false));
    }

    @Override
    public List<AccountLitigation> findAll() {
        return AccountLitigationMapper.toDtos(accountLitigationRepository.findAll(), false);
    }

    @Override
    public List<AccountLitigation> findAll(Pageable pageable) {
        return AccountLitigationMapper.toDtos(accountLitigationRepository.findAll(pageable), false);
    }
}
