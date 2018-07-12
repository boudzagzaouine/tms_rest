package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PaymentSupplierMapper;
import com.sinno.ems.repositories.PaymentSupplierRepository;
import com.sinno.ems.service.SupplierInvoiceService;
import com.sinno.ems.service.AssetSupplierService;
import com.sinno.ems.service.PaymentSupplierService;
import com.sinno.ems.util.EmsClone;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class PaymentSupplierServiceImpl implements PaymentSupplierService {
    @Autowired
    private PaymentSupplierRepository paymentSupplierRepository;
    @Autowired
    private SupplierInvoiceService supplierInvoiceService;
    @Autowired
    private AssetSupplierService assetSupplierService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentSupplierService.class);

    @Override
    @Transactional
    public PaymentSupplier save(PaymentSupplier paymentSupplier) throws IOException {
        LOGGER.info("save PaymentSupplier");
        paymentSupplier.setUpdateDate(EmsDate.getDateNow());
        if (0 >= paymentSupplier.getId()) {
            paymentSupplier.setCreationDate(EmsDate.getDateNow());
        }
        BigDecimal amountPayed = checkQantityToChangeStatus(paymentSupplier, paymentSupplier.getAmount());
        if (null != amountPayed)
            paymentSupplier.setAmount(amountPayed);
        else
            return paymentSupplier;
        return PaymentSupplierMapper.toDto(paymentSupplierRepository.saveAndFlush(PaymentSupplierMapper.toEntity(paymentSupplier, false)), false);
    }

    @Override
    public Long size() {
        return paymentSupplierRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentSupplierRepository.exists(id);
    }

    @Override
    public PaymentSupplier findById(Long id) throws IdNotFound {
        PaymentSupplier paymentSupplier = PaymentSupplierMapper.toDto(paymentSupplierRepository.findOne(id), false);
        if (null != paymentSupplier) {
            return paymentSupplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentSupplier> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentSupplierMapper.toDtos(paymentSupplierRepository.findAll(Search.expression(search, InvPaymentSupplier.class)), false);
    }

    @Override
    public List<PaymentSupplier> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "invPaymentSupplierUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return PaymentSupplierMapper.toDtos(paymentSupplierRepository.findAll(Search.expression(search, InvPaymentSupplier.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentSupplierRepository.count(Search.expression(search, InvPaymentSupplier.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PaymentSupplier");
        paymentSupplierRepository.delete(id);
    }

    @Override
    public void delete(PaymentSupplier paymentSupplier) {
        LOGGER.info("delete PaymentSupplier");
        paymentSupplierRepository.delete(PaymentSupplierMapper.toEntity(paymentSupplier, false));
    }

    @Override
    public List<PaymentSupplier> findAll() {
        return PaymentSupplierMapper.toDtos(paymentSupplierRepository.findAll(), false);
    }

    @Override
    public List<PaymentSupplier> findAll(Pageable pageable) {
        return PaymentSupplierMapper.toDtos(paymentSupplierRepository.findAll(pageable), false);
    }

    private BigDecimal checkQantityToChangeStatus(PaymentSupplier paymentSupplier, BigDecimal qPayed) throws IOException {
        SupplierInvoice supplierInvoice = paymentSupplier.getSupplierInvoice();
        try {
            supplierInvoice = supplierInvoiceService.findById(supplierInvoice.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        if (5 == paymentSupplier.getPaymentType().getId()) {
            if (!paymentSupplier.getAssetSupplier().getUsed()&&paymentSupplier.getAssetSupplier().getExpirationDate().compareTo(EmsDate.getDateNow())>=0) {
                AssetSupplier assetSupplier = paymentSupplier.getAssetSupplier();
                assetSupplier.setUsed(true);
                if (qPayed.compareTo(assetSupplier.getAmount()) == 1) {
                    qPayed = assetSupplier.getAmount();
                } else if (qPayed.compareTo(assetSupplier.getAmount()) == -1) {
                    AssetSupplier assetSupplier1 = EmsClone.clone(assetSupplier, AssetSupplier.class);
                    assetSupplier1.setId(0);
                    assetSupplier1.setAmount(assetSupplier.getAmount().subtract(qPayed));
                    assetSupplier1.setUsed(false);
                    assetSupplierService.save(assetSupplier1);
                }
                assetSupplierService.save(assetSupplier);
            } else return null;
        }
        List<PaymentSupplier> paymentSuppliers = null;
        try {
            paymentSuppliers = find("supplierInvoice.code:" + supplierInvoice.getCode());
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        BigDecimal quantity = qPayed;
        if (null != paymentSuppliers)
            for (PaymentSupplier pa : paymentSuppliers) {
                quantity = quantity.add(pa.getAmount());
            }
        if (quantity == null)
            quantity = BigDecimal.ZERO;
        if (quantity.compareTo(supplierInvoice.getTotalPriceTTC()) > -1) {
            supplierInvoice.setState(3L);
        } else {
            supplierInvoice.setState(4L);
        }
        supplierInvoice.setAmountPayed(quantity);
        supplierInvoiceService.save(supplierInvoice);
        return qPayed;
    }

}