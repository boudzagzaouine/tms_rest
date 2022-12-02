package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PaymentRule;
import com.bagile.gmo.entities.TmsPaymentRule;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PaymentRuleMapper;
import com.bagile.gmo.repositories.PaymentRuleRepository;
import com.bagile.gmo.services.PaymentRuleService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaymentRuleServiceImpl implements PaymentRuleService {
    
    private final PaymentRuleRepository paymentRuleRepository;

    public PaymentRuleServiceImpl(PaymentRuleRepository paymentRuleRepository) {
        this.paymentRuleRepository = paymentRuleRepository;
    }

    @Override
    public PaymentRule save(PaymentRule paymentRule) {
        return PaymentRuleMapper.toDto(paymentRuleRepository.saveAndFlush(PaymentRuleMapper.toEntity(paymentRule, false)), false);
    }

    @Override
    public Long size() {
        return paymentRuleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentRuleRepository.existsById(id);
    }

    @Override
    public PaymentRule findById(Long id) throws IdNotFound {
        return PaymentRuleMapper.toDto(paymentRuleRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<PaymentRule> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PaymentRuleMapper.toDtos(paymentRuleRepository.findAll(Search.expression(search, TmsPaymentRule.class)), false);
    }

    @Override
    public List<PaymentRule> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PaymentRuleMapper.toDtos(paymentRuleRepository.findAll(Search.expression(search, TmsPaymentRule.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return paymentRuleRepository.count(Search.expression(search, TmsPaymentRule.class));
    }

    @Override
    public void delete(Long id) {
        paymentRuleRepository.deleteById(id);
    }

    @Override
    public void delete(PaymentRule paymentRule) {
        paymentRuleRepository.delete(PaymentRuleMapper.toEntity(paymentRule, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            paymentRuleRepository.deleteById(id);        }
    }


    @Override
    public List<PaymentRule> findAll() {
        return PaymentRuleMapper.toDtos(paymentRuleRepository.findAll(), false);
    }

    @Override
    public List<PaymentRule> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PaymentRuleMapper.toDtos(paymentRuleRepository.findAll(pageable), false);
    }

    @Override
    public PaymentRule findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

