package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TransportPlanServiceCatalog extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private Product product;
    private Transport transport;

    private Address address;
    private Boolean invoice;
    private BigDecimal priceHT;
    private Vat vat;
    private BigDecimal priceTTC;
private Owner owner;
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

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public BigDecimal getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(BigDecimal priceHT) {
        this.priceHT = priceHT;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public BigDecimal getPriceTTC() {
        return priceTTC;
    }

    public void setPriceTTC(BigDecimal priceTTC) {
        this.priceTTC = priceTTC;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportPlanServiceCatalog badgeType = (TransportPlanServiceCatalog) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
