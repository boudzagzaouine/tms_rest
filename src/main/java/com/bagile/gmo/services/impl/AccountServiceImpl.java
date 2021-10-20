package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Account;
import com.bagile.gmo.entities.CmdAccount;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AccountMapper;
import com.bagile.gmo.repositories.AccountRepository;
import com.bagile.gmo.services.AccountService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return AccountMapper.toDto(accountRepository.saveAndFlush(AccountMapper.toEntity(account, false)), false);
    }

    @Override
    public Long size() {
        return accountRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountRepository.existsById(id);
    }

    @Override
    public Account findById(Long id) throws IdNotFound {
        return AccountMapper.toDto(accountRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public Account findByCode(String code) {
        return null;
    }

    @Override
    public List<Account> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AccountMapper.toDtos(accountRepository.findAll(Search.expression(search, CmdAccount.class)), false);
    }

    @Override
    public List<Account> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "cmdAccountUpdateDate");
        Pageable pageable = PageRequest.of(page, size);
        return AccountMapper.toDtos(accountRepository.findAll(Search.expression(search, CmdAccount.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return accountRepository.count(Search.expression(search, CmdAccount.class));
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(AccountMapper.toEntity(account, false));
    }

    @Override
    public Account findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return AccountMapper.toDtos(accountRepository.findAll(), false);
    }

    @Override
    public List<Account> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountMapper.toDtos(accountRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        return null;
    }

}

