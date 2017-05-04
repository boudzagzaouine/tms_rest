package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 16/12/2016.
 */
public class AssetSupplier {
    private long id;
    private String code;
    private BigDecimal amount;
    private Date beginDate;
    private Date expirationDate;
    private Currency currency;
    private Date creationDate;
    private Date updateDate;
    private Boolean used;
    private PurshaseOrder purshaseOrder;
    private SupplierInvoice supplierInvoice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public PurshaseOrder getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(PurshaseOrder purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }

    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

}
