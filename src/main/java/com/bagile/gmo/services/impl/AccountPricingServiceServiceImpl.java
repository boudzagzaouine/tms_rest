package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.AccountPricingService;
import com.bagile.gmo.entities.TmsAccountPricingService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AccountPricingServiceMapper;
import com.bagile.gmo.repositories.AccountPricingServiceRepository;
import com.bagile.gmo.services.AccountPricingServiceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountPricingServiceServiceImpl implements AccountPricingServiceService {

    private final AccountPricingServiceRepository accountServiceRepository;

    public AccountPricingServiceServiceImpl(AccountPricingServiceRepository accountServiceRepository) {
        this.accountServiceRepository = accountServiceRepository;
    }

    @Override
    public AccountPricingService save(AccountPricingService accountService) {
        return AccountPricingServiceMapper.toDto(accountServiceRepository.saveAndFlush(AccountPricingServiceMapper.toEntity(accountService, false)), false);
    }

    @Override
    public List<AccountPricingService> saveAll(List<AccountPricingService> accountServices) throws AttributesNotFound, ErrorType {

        List<AccountPricingService> accountServiceList = new ArrayList<>();

        for (AccountPricingService accountService : accountServices) {
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
    public AccountPricingService findById(Long id) throws IdNotFound {
        return AccountPricingServiceMapper.toDto(accountServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<AccountPricingService> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AccountPricingServiceMapper.toDtos(accountServiceRepository.findAll(Search.expression(search, TmsAccountPricingService.class)), false);
    }

    @Override
    public List<AccountPricingService> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountPricingServiceMapper.toDtos(accountServiceRepository.findAll(Search.expression(search, TmsAccountPricingService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }

        return accountServiceRepository.count(Search.expression(search, TmsAccountPricingService.class));
    }

    @Override
    public void delete(Long id) {
        accountServiceRepository.deleteById(id);
    }

    @Override
    public void delete(AccountPricingService accountService) {
        accountServiceRepository.delete(AccountPricingServiceMapper.toEntity(accountService, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            accountServiceRepository.deleteById(id);        }
    }


    @Override
    public List<AccountPricingService> findAll() {
        return AccountPricingServiceMapper.toDtos(accountServiceRepository.findAll(), false);
    }

    @Override
    public List<AccountPricingService> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountPricingServiceMapper.toDtos(accountServiceRepository.findAll(pageable), false);
    }

    @Override
    public AccountPricingService findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

