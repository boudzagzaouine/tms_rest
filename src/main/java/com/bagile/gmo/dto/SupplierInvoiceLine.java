package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 05/12/2016.
 */
public class SupplierInvoiceLine extends EmsDto implements Serializable {
    private long id;
    private Long number;
    private String description;
    private Date creationDate;
    private Date updateDate;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal tarifPrice;
    private BigDecimal discount;
    private BigDecimal quantity;
    private Product product;
    private Uom uom;
    private SupplierInvoice supplierInvoice;
    private BigDecimal vat;
    private ProductPack productPack;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public BigDecimal getTarifPrice() {
        return tarifPrice;
    }

    public void setTarifPrice(BigDecimal tarifPrice) {
        this.tarifPrice = tarifPrice;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public ProductPack getProductPack() {
        return productPack;
    }

    public void setProductPack(ProductPack productPack) {
        this.productPack = productPack;
    }
}
