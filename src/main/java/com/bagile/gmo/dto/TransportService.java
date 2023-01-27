package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TransportService extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private Transport transport ;

   private Product product;
    private BigDecimal purchaseAmountHt;
    private BigDecimal purchaseAmountTtc;
    private BigDecimal purchaseAmountTva;
    private Vat purchaseVat;

private Owner owner;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportService badgeType = (TransportService) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
