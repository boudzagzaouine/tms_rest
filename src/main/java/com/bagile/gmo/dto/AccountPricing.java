package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountPricing extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private Account account ;
    private CatalogTransportType catalogTransportType;

    private Transport transport;
    private BigDecimal price;

private Owner owner;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CatalogTransportType getCatalogTransportType() {
        return catalogTransportType;
    }

    public void setCatalogTransportType(CatalogTransportType catalogTransportType) {
        this.catalogTransportType = catalogTransportType;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        AccountPricing badgeType = (AccountPricing) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
