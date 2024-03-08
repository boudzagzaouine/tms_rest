package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PaymentType;
import com.bagile.gmo.entities.PrmPaymentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PaymentTypeMapper;
import com.bagile.gmo.repositories.PaymentTypeRepository;
import com.bagile.gmo.services.PaymentTypeService;
import com.bagile.gmo.util.AddActive;

import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService, AddActive {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;
    private PaymentType wireTransfer;
    private PaymentType cash;
    private PaymentType check;
    private PaymentType creditCard;
    private PaymentType negotiableInstrument;
    private PaymentType asset;
    private PaymentType effet;
    private PaymentType compensation;
    private PaymentType bankTransfer;
    private PaymentType discount;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentTypeService.class);

    @PostConstruct
    public void init() {
        try {
            check = findById(1L);
            wireTransfer = findById(2L);

            compensation = findById(4L);
            asset = findById(5L);
            cash = findById(12L);
            negotiableInstrument = findById(13L);
            effet = findById(13L);
            creditCard = findById(14L);
            bankTransfer = findById(15L);
            discount = findById(16L);
        } catch (IdNotFound idNotFound) {

        }
    }

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
    public Long size() throws AttributesNotFound, ErrorType {
        return size("");
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentTypeRepository.existsById(id);
    }

    @Override
    public PaymentType findById(Long id) throws IdNotFound {
        PaymentType paymentType = PaymentTypeMapper.toDto(paymentTypeRepository.findById(id).orElseThrow(()-> new IdNotFound(id)), false);
        if (null != paymentType) {
            return paymentType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentType> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentTypeMapper.toDtos(paymentTypeRepository.findAll(Search.expression(addActiveToSearch(search), PrmPaymentType.class)), false);
    }

    @Override
    public PaymentType findOne(String search) throws AttributesNotFound, ErrorType {
        return PaymentTypeMapper.toDto(paymentTypeRepository.findOne(Search.expression(addActiveToSearch(search), PrmPaymentType.class)).orElseThrow(()-> new AttributesNotFound(search)), false);
    }

    @Override
    public List<PaymentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort =  Sort.by(Sort.Direction.DESC, "prmPaymentTypeUpdateDate");
        Pageable pageable =  PageRequest.of(page, size, sort);
        return PaymentTypeMapper.toDtos(paymentTypeRepository.findAll(Search.expression(addActiveToSearch(search), PrmPaymentType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentTypeRepository.count(Search.expression(addActiveToSearch(search), PrmPaymentType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PaymentType");
        paymentTypeRepository.deleteById(id);
    }

    @Override
    public void delete(PaymentType paymentType) {
        LOGGER.info("delete PaymentType");
        paymentTypeRepository.delete(PaymentTypeMapper.toEntity(paymentType, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            paymentTypeRepository.deleteById(id);        }
    }
    @Override
    public List<PaymentType> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<PaymentType> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("", pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public PaymentType getWireTransfer() {
        return wireTransfer;
    }

    @Override
    public PaymentType getCash() {
        return cash;
    }

    @Override
    public PaymentType getCheck() {
        return check;
    }

    @Override
    public PaymentType getCreditCard() {
        return creditCard;
    }

    @Override
    public PaymentType getNegotiableInstrument() {
        return negotiableInstrument;
    }

    @Override
    public PaymentType getAsset() {
        return asset;
    }


    @Override
    public PaymentType getEffet() {
        return effet;
    }

    @Override
    public PaymentType getBankTransfer() {
        return bankTransfer;
    }

    @Override
    public void setBankTransfer(PaymentType bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public PaymentType getDiscount() {
        return discount;
    }

    public void setDiscount(PaymentType discount) {
        this.discount = discount;
    }
}
