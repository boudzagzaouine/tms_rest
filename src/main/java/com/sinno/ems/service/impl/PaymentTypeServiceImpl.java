package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PaymentTypeMapper;
import com.sinno.ems.repositories.PaymentTypeRepository;
import com.sinno.ems.service.PaymentTypeService;
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
public class PaymentTypeServiceImpl implements PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentTypeService.class);

    @Override
    public PaymentType save(PaymentType paymentType) {
        LOGGER.info("save PaymentType");
        paymentType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= paymentType.getId()) {
            paymentType.setCreationDate(EmsDate.getDateNow());
        }
        return PaymentTypeMapper.toDto(paymentTypeRepository.saveAndFlush(PaymentTypeMapper.toEntity(paymentType, false)), false);
    }

    @Override
    public Long size() {
        return paymentTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentTypeRepository.exists(id);
    }

    @Override
    public PaymentType findById(Long id) throws IdNotFound {
        PaymentType paymentType = PaymentTypeMapper.toDto(paymentTypeRepository.findOne(id), false);
        if (null != paymentType) {
            return paymentType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentType> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentTypeMapper.toDtos(paymentTypeRepository.findAll(Search.expression(search, PrmPaymentType.class)), false);
    }

    @Override
    public List<PaymentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmPaymentTypeUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return PaymentTypeMapper.toDtos(paymentTypeRepository.findAll(Search.expression(search, PrmPaymentType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentTypeRepository.count(Search.expression(search, PrmPaymentType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PaymentType");
        paymentTypeRepository.delete(id);
    }

    @Override
    public void delete(PaymentType paymentType) {
        LOGGER.info("delete PaymentType");
        paymentTypeRepository.delete(PaymentTypeMapper.toEntity(paymentType, false));
    }

    @Override
    public List<PaymentType> findAll() {
        return PaymentTypeMapper.toDtos(paymentTypeRepository.findAll(), false);
    }

    @Override
    public List<PaymentType> findAll(Pageable pageable) {
        return PaymentTypeMapper.toDtos(paymentTypeRepository.findAll(pageable), false);
    }
}
