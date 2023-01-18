package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CatalogService extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private Product product;

    private BigDecimal purchaseAmountHt;
    private BigDecimal purchaseAmountTtc;
    private BigDecimal purchaseAmountTva;
    private Vat purchaseVat;

    private BigDecimal saleAmountHt;
    private BigDecimal saleAmountTtc;
    private BigDecimal saleAmountTva;
    private Vat saleVat;

  private Owner owner;



    public CatalogService() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }



    public BigDecimal getPurchaseAmountHt() {
        return purchaseAmountHt;
    }

    public void setPurchaseAmountHt(BigDecimal purchaseAmountHt) {
        this.purchaseAmountHt = purchaseAmountHt;
    }

    public BigDecimal getPurchaseAmountTtc() {
        return purchaseAmountTtc;
    }

    public void setPurchaseAmountTtc(BigDecimal purchaseAmountTtc) {
        this.purchaseAmountTtc = purchaseAmountTtc;
    }

    public BigDecimal getPurchaseAmountTva() {
        return purchaseAmountTva;
    }

    public void setPurchaseAmountTva(BigDecimal purchaseAmountTva) {
        this.purchaseAmountTva = purchaseAmountTva;
    }

    public Vat getPurchaseVat() {
        return purchaseVat;
    }

    public void setPurchaseVat(Vat purchaseVat) {
        this.purchaseVat = purchaseVat;
    }

    public BigDecimal getSaleAmountHt() {
        return saleAmountHt;
    }

    public void setSaleAmountHt(BigDecimal saleAmountHt) {
        this.saleAmountHt = saleAmountHt;
    }

    public BigDecimal getSaleAmountTtc() {
        return saleAmountTtc;
    }

    public void setSaleAmountTtc(BigDecimal saleAmountTtc) {
        this.saleAmountTtc = saleAmountTtc;
    }

    public BigDecimal getSaleAmountTva() {
        return saleAmountTva;
    }

    public void setSaleAmountTva(BigDecimal saleAmountTva) {
        this.saleAmountTva = saleAmountTva;
    }

    public Vat getSaleVat() {
        return saleVat;
    }

    public void setSaleVat(Vat saleVat) {
        this.saleVat = saleVat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogService badge = (CatalogService) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
