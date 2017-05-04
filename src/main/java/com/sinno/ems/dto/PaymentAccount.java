package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PaymentAccount {
    private long id;
    private Date paymentDate;
    private Date creationDate;
    private BigDecimal amount;
    private Date updateDate;
    private Account account;
    private PaymentType paymentType;
    private String number;//Number Of payment type {cheque or trait or versement)
    private AccountInvoice accountInvoice;
    private AssetAccount assetAccount;
    private Currency currency;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public AccountInvoice getAccountInvoice() {
        return accountInvoice;
    }

    public void setAccountInvoice(AccountInvoice accountInvoice) {
        this.accountInvoice = accountInvoice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AssetAccount getAssetAccount() {
        return assetAccount;
    }

    public void setAssetAccount(AssetAccount assetAccount) {
        this.assetAccount = assetAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
