package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.BankMapper;
import com.sinno.ems.service.BankService;
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
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BankService.class);

    @Override
    public Bank save(Bank bank) {
        LOGGER.info("save Bank");
        bank.setUpdateDate(EmsDate.getDateNow());
        if (0 >= bank.getId()) {
            bank.setCreationDate(EmsDate.getDateNow());
        }
        return BankMapper.toDto(bankRepository.saveAndFlush(BankMapper.toEntity(bank, false)), false);
    }

    @Override
    public Long size() {
        return bankRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return bankRepository.exists(id);
    }

    @Override
    public Bank findById(Long id) throws IdNotFound {
        Bank bank = BankMapper.toDto(bankRepository.findOne(id), false);
        if (null != bank) {
            return bank;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Bank> find(String search) throws AttributesNotFound, ErrorType {
        return BankMapper.toDtos(bankRepository.findAll(Search.expression(search, PrmBank.class)), false);
    }

    @Override
    public List<Bank> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"prmBankUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return BankMapper.toDtos(bankRepository.findAll(Search.expression(search, PrmBank.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return bankRepository.count(Search.expression(search, PrmBank.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Bank");
        bankRepository.delete(id);
    }

    @Override
    public void delete(Bank bank) {
        LOGGER.info("delete Bank");
        bankRepository.delete(BankMapper.toEntity(bank, false));
    }

    @Override
    public List<Bank> findAll() {
        return BankMapper.toDtos(bankRepository.findAll(), false);
    }

    @Override
    public List<Bank> findAll(Pageable pageable) {
        return BankMapper.toDtos(bankRepository.findAll(pageable), false);
    }
}