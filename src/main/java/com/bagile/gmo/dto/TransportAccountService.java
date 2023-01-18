package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TransportAccountService extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private Transport transport ;
    private Company company ;

   private Product product;
    private BigDecimal saleAmountHt;
    private BigDecimal saleAmountTtc;
    private BigDecimal saleAmountTva;
    private Vat saleVat;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        TransportAccountService badgeType = (TransportAccountService) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
