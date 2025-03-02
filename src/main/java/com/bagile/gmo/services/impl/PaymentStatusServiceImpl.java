package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.PaymentStatus;
import com.bagile.gmo.entities.PrmPaymentStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PaymentStatusMapper;
import com.bagile.gmo.repositories.PaymentStatusRepository;
import com.bagile.gmo.services.PaymentStatusService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

    @Autowired
    private PaymentStatusRepository paymentStatusRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentStatusService.class);

    @Override
    public PaymentStatus save(PaymentStatus paymentStatus) {
        LOGGER.info("save PaymentStatus");
        return PaymentStatusMapper.toDto(paymentStatusRepository.saveAndFlush(PaymentStatusMapper.toEntity(paymentStatus, false)), false);
    }

    @Override
    public Long size() {
        return paymentStatusRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentStatusRepository.existsById(id);
    }

    @Override
    public PaymentStatus findById(Long id) throws IdNotFound {
        PaymentStatus paymentStatus = PaymentStatusMapper.toDto(paymentStatusRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        if (null != paymentStatus) {
            return paymentStatus;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentStatus> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentStatusMapper.toDtos(paymentStatusRepository.findAll(Search.expression(search, PrmPaymentStatus.class)), false);
    }

    @Override
    public List<PaymentStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PaymentStatusMapper.toDtos(paymentStatusRepository.findAll(Search.expression(search, PrmPaymentStatus.class), pageable), false);
    }
    @Override
    public PaymentStatus findOne(String search) throws AttributesNotFound, ErrorType {
        return PaymentStatusMapper.toDto(paymentStatusRepository.findOne(Search.expression(search, PrmPaymentStatus.class)).orElseThrow(()-> new AttributesNotFound(search)), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentStatusRepository.count(Search.expression(search, PrmPaymentStatus.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete paymentStatus");
        paymentStatusRepository.deleteById(id);
    }

    @Override
    public void delete(PaymentStatus paymentStatus) {
        LOGGER.info("delete PaymentStatus");
        paymentStatusRepository.delete(PaymentStatusMapper.toEntity(paymentStatus, false));
    }

    @Override
    public List<PaymentStatus> findAll() {
        return PaymentStatusMapper.toDtos(paymentStatusRepository.findAll(), false);
    }

    @Override
    public List<PaymentStatus> findAll(Pageable pageable) {
        return PaymentStatusMapper.toDtos(paymentStatusRepository.findAll(pageable), false);
    }
}