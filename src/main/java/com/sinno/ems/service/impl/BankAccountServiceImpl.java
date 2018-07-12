package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.BankAccountMapper;
import com.sinno.ems.service.BankAccountService;
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
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BankAccountService.class);

    @Override
    public BankAccount save(BankAccount bankAccount) {
        LOGGER.info("save BankAccount");
        bankAccount.setUpdateDate(EmsDate.getDateNow());
        if (0 >= bankAccount.getId()) {
            bankAccount.setCreationDate(EmsDate.getDateNow());
        }
        return BankAccountMapper.toDto(bankAccountRepository.saveAndFlush(BankAccountMapper.toEntity(bankAccount, false)), false);
    }

    @Override
    public Long size() {
        return bankAccountRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return bankAccountRepository.exists(id);
    }

    @Override
    public BankAccount findById(Long id) throws IdNotFound {
        BankAccount bankAccount = BankAccountMapper.toDto(bankAccountRepository.findOne(id), false);
        if (null != bankAccount) {
            return bankAccount;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<BankAccount> find(String search) throws AttributesNotFound, ErrorType {
        return BankAccountMapper.toDtos(bankAccountRepository.findAll(Search.expression(search, PrmBankAccount.class)), false);
    }

    @Override
    public List<BankAccount> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"prmBankAccountUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return BankAccountMapper.toDtos(bankAccountRepository.findAll(Search.expression(search, PrmBankAccount.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return bankAccountRepository.count(Search.expression(search, PrmBankAccount.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete BankAccount");
        bankAccountRepository.delete(id);
    }

    @Override
    public void delete(BankAccount bankAccount) {
        LOGGER.info("delete BankAccount");
        bankAccountRepository.delete(BankAccountMapper.toEntity(bankAccount, false));
    }

    @Override
    public List<BankAccount> findAll() {
        return BankAccountMapper.toDtos(bankAccountRepository.findAll(), false);
    }

    @Override
    public List<BankAccount> findAll(Pageable pageable) {
        return BankAccountMapper.toDtos(bankAccountRepository.findAll(pageable), false);
    }
}