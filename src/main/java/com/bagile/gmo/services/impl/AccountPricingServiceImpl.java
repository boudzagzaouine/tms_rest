package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.AccountPricing;
import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.entities.TmsAccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AccountPricingMapper;
import com.bagile.gmo.repositories.AccountPricingRepository;
import com.bagile.gmo.services.AccountPricingService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountPricingServiceImpl implements AccountPricingService {
    
    private final AccountPricingRepository actionTypeRepository;

    public AccountPricingServiceImpl(AccountPricingRepository actionTypeRepository) {
        this.actionTypeRepository = actionTypeRepository;
    }

    @Override
    public AccountPricing save(AccountPricing actionType) {
        return AccountPricingMapper.toDto(actionTypeRepository.saveAndFlush(AccountPricingMapper.toEntity(actionType, false)), false);
    }

    @Override
    public List<AccountPricing> saveAll(List<AccountPricing> accountPricings) throws AttributesNotFound, ErrorType {

        List<AccountPricing> accountPricingList = new ArrayList<>();

        for (AccountPricing accountPricing : accountPricings) {
            accountPricingList.add(save(accountPricing));
        }

        return accountPricingList;

    }

    @Override
    public Long size() {
        return actionTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionTypeRepository.existsById(id);
    }

    @Override
    public AccountPricing findById(Long id) throws IdNotFound {
        return AccountPricingMapper.toDto(actionTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<AccountPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(Search.expression(search, TmsAccountPricing.class)), false);
    }

    @Override
    public List<AccountPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(Search.expression(search, TmsAccountPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionTypeRepository.count(Search.expression(search, TmsAccountPricing.class));
    }

    @Override
    public void delete(Long id) {
        actionTypeRepository.deleteById(id);
    }

    @Override
    public void delete(AccountPricing actionType) {
        actionTypeRepository.delete(AccountPricingMapper.toEntity(actionType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionTypeRepository.deleteById(id);        }
    }


    @Override
    public List<AccountPricing> findAll() {
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(), false);
    }

    @Override
    public List<AccountPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(pageable), false);
    }

    @Override
    public AccountPricing findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

