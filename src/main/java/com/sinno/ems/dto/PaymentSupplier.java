package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PaymentSupplier {
    private long id;
    private Date paymentDate;
    private Date creationDate;
    private Date updateDate;
    private BigDecimal amount;
    private Supplier supplier;
    private PaymentType paymentType;
    private String number;//Number Of payment type {cheque or trait or versement)
    private SupplierInvoice supplierInvoice;
    private AssetSupplier assetSupplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
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

    public AssetSupplier getAssetSupplier() {
        return assetSupplier;
    }

    public void setAssetSupplier(AssetSupplier assetSupplier) {
        this.assetSupplier = assetSupplier;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
