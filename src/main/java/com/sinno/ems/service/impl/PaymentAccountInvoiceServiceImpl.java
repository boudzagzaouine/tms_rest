package com.sinno.ems.service.impl;

import com.sinno.ems.dto.PaymentAccountInvoice;
import com.sinno.ems.entities.InvPaymentAccountInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PaymentAccountInvoiceMapper;
import com.sinno.ems.repositories.PaymentAccountInvoiceRepository;
import com.sinno.ems.service.PaymentAccountInvoiceService;
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
 * Created by Enissay on 15/12/2016.
 */
 @Service
public class PaymentAccountInvoiceServiceImpl implements PaymentAccountInvoiceService{
    @Autowired
    private PaymentAccountInvoiceRepository paymentAccountInvoiceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentAccountInvoiceService.class);

    @Override
    public PaymentAccountInvoice save(PaymentAccountInvoice paymentAccountInvoice) {
        LOGGER.info("save PaymentAccountInvoice");

        return PaymentAccountInvoiceMapper.toDto(paymentAccountInvoiceRepository.saveAndFlush(PaymentAccountInvoiceMapper.toEntity(paymentAccountInvoice, false)), false);
    }

    @Override
    public Long size() {
        return paymentAccountInvoiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentAccountInvoiceRepository.exists(id);
    }

    @Override
    public PaymentAccountInvoice findById(Long id) throws IdNotFound {
        PaymentAccountInvoice paymentAccountInvoice = PaymentAccountInvoiceMapper.toDto(paymentAccountInvoiceRepository.findOne(id), false);
        if (null != paymentAccountInvoice) {
            return paymentAccountInvoice;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentAccountInvoice> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentAccountInvoiceMapper.toDtos(paymentAccountInvoiceRepository.findAll(Search.expression(search, InvPaymentAccountInvoice.class)), false);
    }

    @Override
    public List<PaymentAccountInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmPaymentAccountInvoiceUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return PaymentAccountInvoiceMapper.toDtos(paymentAccountInvoiceRepository.findAll(Search.expression(search, InvPaymentAccountInvoice.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentAccountInvoiceRepository.count(Search.expression(search, InvPaymentAccountInvoice.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PaymentAccountInvoice");
        paymentAccountInvoiceRepository.delete(id);
    }

    @Override
    public void delete(PaymentAccountInvoice paymentAccountInvoice) {
        LOGGER.info("delete PaymentAccountInvoice");
        paymentAccountInvoiceRepository.delete(PaymentAccountInvoiceMapper.toEntity(paymentAccountInvoice, false));
    }

    @Override
    public List<PaymentAccountInvoice> findAll() {
        return PaymentAccountInvoiceMapper.toDtos(paymentAccountInvoiceRepository.findAll(), false);
    }

    @Override
    public List<PaymentAccountInvoice> findAll(Pageable pageable) {
        return PaymentAccountInvoiceMapper.toDtos(paymentAccountInvoiceRepository.findAll(pageable), false);
    }
}
