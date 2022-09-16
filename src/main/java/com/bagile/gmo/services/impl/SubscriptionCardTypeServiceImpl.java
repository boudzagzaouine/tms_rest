package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SubscriptionCardType;
import com.bagile.gmo.entities.GmoSubscriptionCardType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SubscriptionCardTypeMapper;
import com.bagile.gmo.repositories.SubscriptionCardTypeRepository;
import com.bagile.gmo.services.SubscriptionCardTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubscriptionCardTypeServiceImpl implements SubscriptionCardTypeService {
    private final SubscriptionCardTypeRepository subscriptionCardTypeRepository;

    public SubscriptionCardTypeServiceImpl(SubscriptionCardTypeRepository subscriptionCardTypeRepository) {
        this.subscriptionCardTypeRepository = subscriptionCardTypeRepository;
    }

    @Override
    public SubscriptionCardType save(SubscriptionCardType subscriptionCardType) {
        return SubscriptionCardTypeMapper.toDto(subscriptionCardTypeRepository.saveAndFlush(SubscriptionCardTypeMapper.toEntity(subscriptionCardType, false)), false);
    }

    @Override
    public Long size() {
        return subscriptionCardTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return subscriptionCardTypeRepository.existsById(id);
    }

    @Override
    public SubscriptionCardType findById(Long id) throws IdNotFound {
        return SubscriptionCardTypeMapper.toDto(subscriptionCardTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<SubscriptionCardType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SubscriptionCardTypeMapper.toDtos(subscriptionCardTypeRepository.findAll(Search.expression(search, GmoSubscriptionCardType.class)), false);
    }

    @Override
    public List<SubscriptionCardType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SubscriptionCardTypeMapper.toDtos(subscriptionCardTypeRepository.findAll(Search.expression(search, GmoSubscriptionCardType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return subscriptionCardTypeRepository.count(Search.expression(search, GmoSubscriptionCardType.class));
    }

    @Override
    public void delete(Long id) {
        subscriptionCardTypeRepository.deleteById(id);
    }

    @Override
    public void delete(SubscriptionCardType subscriptionCardType) {
        subscriptionCardTypeRepository.delete(SubscriptionCardTypeMapper.toEntity(subscriptionCardType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            subscriptionCardTypeRepository.deleteById(id);        }
    }


    @Override
    public List<SubscriptionCardType> findAll()
    {
        return SubscriptionCardTypeMapper.toDtos(subscriptionCardTypeRepository.findAll(), false);
    }

    @Override
    public List<SubscriptionCardType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SubscriptionCardTypeMapper.toDtos(subscriptionCardTypeRepository.findAll(pageable), false);
    }

}

