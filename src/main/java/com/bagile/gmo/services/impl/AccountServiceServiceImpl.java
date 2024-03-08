package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.AccountService;
import com.bagile.gmo.entities.TmsAccountService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AccountServiceMapper;
import com.bagile.gmo.repositories.AccountServiceRepository;
import com.bagile.gmo.services.AccountServiceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountServiceServiceImpl implements AccountServiceService {

    private final AccountServiceRepository accountServiceRepository;

    public AccountServiceServiceImpl(AccountServiceRepository accountServiceRepository) {
        this.accountServiceRepository = accountServiceRepository;
    }

    @Override
    public AccountService save(AccountService accountService) {
        return AccountServiceMapper.toDto(accountServiceRepository.saveAndFlush(AccountServiceMapper.toEntity(accountService, false)), false);
    }

    @Override
    public List<AccountService> saveAll(List<AccountService> accountServices) throws AttributesNotFound, ErrorType {

        List<AccountService> accountServiceList = new ArrayList<>();

        for (AccountService accountService : accountServices) {
            accountServiceList.add(save(accountService));
        }

        return accountServiceList;

    }

    @Override
    public Long size() {
        return accountServiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountServiceRepository.existsById(id);
    }

    @Override
    public AccountService findById(Long id) throws IdNotFound {
        return AccountServiceMapper.toDto(accountServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<AccountService> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AccountServiceMapper.toDtos(accountServiceRepository.findAll(Search.expression(search, TmsAccountService.class)), false);
    }

    @Override
    public List<AccountService> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountServiceMapper.toDtos(accountServiceRepository.findAll(Search.expression(search, TmsAccountService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return accountServiceRepository.count(Search.expression(search, TmsAccountService.class));
    }

    @Override
    public void delete(Long id) {
        accountServiceRepository.deleteById(id);
    }

    @Override
    public void delete(AccountService accountService) {
        accountServiceRepository.delete(AccountServiceMapper.toEntity(accountService, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            accountServiceRepository.deleteById(id);        }
    }


    @Override
    public List<AccountService> findAll() {
        return AccountServiceMapper.toDtos(accountServiceRepository.findAll(), false);
    }

    @Override
    public List<AccountService> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountServiceMapper.toDtos(accountServiceRepository.findAll(pageable), false);
    }

    @Override
    public AccountService findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

