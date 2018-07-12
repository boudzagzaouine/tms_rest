package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PaymentAccountMapper;
import com.sinno.ems.repositories.PaymentAccountRepository;
import com.sinno.ems.service.AccountInvoiceService;
import com.sinno.ems.service.AssetAccountService;
import com.sinno.ems.service.PaymentAccountService;
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
public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Autowired
    private PaymentAccountRepository paymentAccountRepository;
    @Autowired
    private AccountInvoiceService accountInvoiceService;
    @Autowired
    private AssetAccountService assetAccountService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaymentAccountService.class);

    @Override
    @Transactional
    public PaymentAccount save(PaymentAccount paymentAccount) throws IOException {
        LOGGER.info("save PaymentAccount");
        paymentAccount.setUpdateDate(EmsDate.getDateNow());
        if (0 >= paymentAccount.getId()) {
            paymentAccount.setCreationDate(EmsDate.getDateNow());
        }
        BigDecimal amountPayed = checkQantityToChangeStatus(paymentAccount, paymentAccount.getAmount());
        if (null != amountPayed)
            paymentAccount.setAmount(amountPayed);
        else
            return paymentAccount;
        return PaymentAccountMapper.toDto(paymentAccountRepository.saveAndFlush(PaymentAccountMapper.toEntity(paymentAccount, false)), false);
    }

    @Override
    public Long size() {
        return paymentAccountRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return paymentAccountRepository.exists(id);
    }

    @Override
    public PaymentAccount findById(Long id) throws IdNotFound {
        PaymentAccount paymentAccount = PaymentAccountMapper.toDto(paymentAccountRepository.findOne(id), false);
        if (null != paymentAccount) {
            return paymentAccount;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PaymentAccount> find(String search) throws AttributesNotFound, ErrorType {
        return PaymentAccountMapper.toDtos(paymentAccountRepository.findAll(Search.expression(search, InvPaymentAccount.class)), false);
    }

    @Override
    public List<PaymentAccount> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "invPaymentAccountUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return PaymentAccountMapper.toDtos(paymentAccountRepository.findAll(Search.expression(search, InvPaymentAccount.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paymentAccountRepository.count(Search.expression(search, InvPaymentAccount.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PaymentAccount");
        paymentAccountRepository.delete(id);
    }

    @Override
    public void delete(PaymentAccount paymentAccount) {
        LOGGER.info("delete PaymentAccount");
        paymentAccountRepository.delete(PaymentAccountMapper.toEntity(paymentAccount, false));
    }

    @Override
    public List<PaymentAccount> findAll() {
        return PaymentAccountMapper.toDtos(paymentAccountRepository.findAll(), false);
    }

    @Override
    public List<PaymentAccount> findAll(Pageable pageable) {
        return PaymentAccountMapper.toDtos(paymentAccountRepository.findAll(pageable), false);
    }

    private BigDecimal checkQantityToChangeStatus(PaymentAccount paymentAccount, BigDecimal qPayed) throws IOException {
        AccountInvoice accountInvoice = paymentAccount.getAccountInvoice();
        try {
            accountInvoice = accountInvoiceService.findById(accountInvoice.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        if (5 == paymentAccount.getPaymentType().getId()) {
            if (!paymentAccount.getAssetAccount().getUsed() && paymentAccount.getAssetAccount().getExpirationDate().compareTo(EmsDate.getDateNow()) >=0) {
                AssetAccount assetAccount = paymentAccount.getAssetAccount();
                assetAccount.setUsed(true);
                if (qPayed.compareTo(assetAccount.getAmount()) == 1) {
                    qPayed = assetAccount.getAmount();
                } else if (qPayed.compareTo(assetAccount.getAmount()) == -1) {
                    AssetAccount assetAccount1 = EmsClone.clone(assetAccount, AssetAccount.class);
                    assetAccount1.setId(0);
                    assetAccount1.setAmount(assetAccount.getAmount().subtract(qPayed));
                    assetAccount1.setUsed(false);
                    assetAccountService.save(assetAccount1);
                }
                assetAccountService.save(assetAccount);
            } else return null;
        }
        List<PaymentAccount> paymentAccounts = null;
        try {
            paymentAccounts = find("accountInvoice.code:" + accountInvoice.getCode());
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        BigDecimal quantity = qPayed;
        if (null != paymentAccounts)
            for (PaymentAccount pa : paymentAccounts) {
                quantity = quantity.add(pa.getAmount());
            }
        if (quantity == null)
            quantity = BigDecimal.ZERO;
        if (quantity.compareTo(accountInvoice.getTotalPriceTTC()) > -1) {
            accountInvoice.setState(3L);
        } else {
            accountInvoice.setState(4L);
        }
        accountInvoice.setAmountPayed(quantity);
        accountInvoiceService.save(accountInvoice);
        return qPayed;
    }

}