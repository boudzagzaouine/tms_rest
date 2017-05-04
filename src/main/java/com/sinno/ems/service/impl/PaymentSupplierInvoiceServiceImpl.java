package com.sinno.ems.service.impl;

import com.sinno.ems.dto.PaymentSupplierInvoice;
import com.sinno.ems.entities.InvPaymentSupplierInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PaymentSupplierInvoiceMapper;
import com.sinno.ems.repositories.PaymentSupplierInvoiceRepository;
import com.sinno.ems.service.PaymentSupplierInvoiceService;
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
public class PaymentSupplierInvoiceServiceImpl implements PaymentSupplierInvoiceService{
    @Autowired
    private PaymentSupplierInvoiceRepository paymentSupplierInvoiceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentSupplierInvoiceService.class);

    @Override
    public PaymentSupplierInvoice save(PaymentSupplierInvoice paymentSupplierInvoice) {
        LOGGER.info("save PaymentSupplierInvoice");

        return PaymentSupplierInvoiceMapper.toDto(paymentSupplierInvoiceRepository.saveAndFlush(PaymentSupplierInvoiceMapper.toEntity(paymentSupplierInvoice, false)), false);
    }

    @Override
    public Long size() {
        return paymentSupplierInvoiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentSupplierInvoiceRepository.exists(id);
    }

    @Override
    public PaymentSupplierInvoice findById(Long id) throws IdNotFound {
        PaymentSupplierInvoice paymentSupplierInvoice = PaymentSupplierInvoiceMapper.toDto(paymentSupplierInvoiceRepository.findOne(id), false);
        if (null != paymentSupplierInvoice) {
            return paymentSupplierInvoice;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentSupplierInvoice> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentSupplierInvoiceMapper.toDtos(paymentSupplierInvoiceRepository.findAll(Search.expression(search, InvPaymentSupplierInvoice.class)), false);
    }

    @Override
    public List<PaymentSupplierInvoice> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmPaymentSupplierInvoiceUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return PaymentSupplierInvoiceMapper.toDtos(paymentSupplierInvoiceRepository.findAll(Search.expression(search, InvPaymentSupplierInvoice.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentSupplierInvoiceRepository.count(Search.expression(search, InvPaymentSupplierInvoice.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PaymentSupplierInvoice");
        paymentSupplierInvoiceRepository.delete(id);
    }

    @Override
    public void delete(PaymentSupplierInvoice paymentSupplierInvoice) {
        LOGGER.info("delete PaymentSupplierInvoice");
        paymentSupplierInvoiceRepository.delete(PaymentSupplierInvoiceMapper.toEntity(paymentSupplierInvoice, false));
    }

    @Override
    public List<PaymentSupplierInvoice> findAll() {
        return PaymentSupplierInvoiceMapper.toDtos(paymentSupplierInvoiceRepository.findAll(), false);
    }

    @Override
    public List<PaymentSupplierInvoice> findAll(Pageable pageable) {
        return PaymentSupplierInvoiceMapper.toDtos(paymentSupplierInvoiceRepository.findAll(pageable), false);
    }
}
