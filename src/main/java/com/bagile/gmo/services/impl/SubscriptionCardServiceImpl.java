package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SubscriptionCard;
import com.bagile.gmo.entities.GmoSubscriptionCard;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SubscriptionCardMapper;
import com.bagile.gmo.repositories.SubscriptionCardRepository;
import com.bagile.gmo.services.SubscriptionCardService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SubscriptionCardServiceImpl implements SubscriptionCardService {
    private final SubscriptionCardRepository subscriptionCardRepository;

    public SubscriptionCardServiceImpl(SubscriptionCardRepository subscriptionCardRepository) {
        this.subscriptionCardRepository = subscriptionCardRepository;
    }

    @Override
    public SubscriptionCard save(SubscriptionCard subscriptionCard) {
        return SubscriptionCardMapper.toDto(subscriptionCardRepository.saveAndFlush(SubscriptionCardMapper.toEntity(subscriptionCard, false)), false);
    }

    @Override
    public Long size() {
        return subscriptionCardRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return subscriptionCardRepository.existsById(id);
    }

    @Override
    public SubscriptionCard findById(Long id) throws IdNotFound {
        return SubscriptionCardMapper.toDto(subscriptionCardRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<SubscriptionCard> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SubscriptionCardMapper.toDtos(subscriptionCardRepository.findAll(Search.expression(search, GmoSubscriptionCard.class)), false);
    }

    @Override
    public List<SubscriptionCard> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SubscriptionCardMapper.toDtos(subscriptionCardRepository.findAll(Search.expression(search, GmoSubscriptionCard.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return subscriptionCardRepository.count(Search.expression(search, GmoSubscriptionCard.class));
    }

    @Override
    public void delete(Long id) {
        subscriptionCardRepository.deleteById(id);
    }

    @Override
    public void delete(SubscriptionCard subscriptionCard) {
        subscriptionCardRepository.delete(SubscriptionCardMapper.toEntity(subscriptionCard, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            subscriptionCardRepository.deleteById(id);        }
    }


    @Override
    public List<SubscriptionCard> findAll()
    {
        return SubscriptionCardMapper.toDtos(subscriptionCardRepository.findAll(), false);
    }

    @Override
    public List<SubscriptionCard> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SubscriptionCardMapper.toDtos(subscriptionCardRepository.findAll(pageable), false);
    }

}

