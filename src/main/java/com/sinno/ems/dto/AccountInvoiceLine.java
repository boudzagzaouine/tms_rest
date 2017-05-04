package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 05/12/2016.
 */
public class AccountInvoiceLine {
    private long id;
    private Long number;
    private Date creationDate;
    private Date updateDate;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal tarifPrice;
    private BigDecimal discount;
    private BigDecimal quantity;
    private Product product;
    private Uom uom;
    private AccountInvoice accountInvoice;
    private Vat vat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public AccountInvoice getAccountInvoice() {
        return accountInvoice;
    }

    public void setAccountInvoice(AccountInvoice accountInvoice) {
        this.accountInvoice = accountInvoice;
    }

    public BigDecimal getTarifPrice() {
        return tarifPrice;
    }

    public void setTarifPrice(BigDecimal tarifPrice) {
        this.tarifPrice = tarifPrice;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }
}
