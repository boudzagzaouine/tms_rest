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

    private Account account;
    private Boolean invoice;
    private BigDecimal purchasePriceHT;
    private Vat purchaseVat;
    private BigDecimal purchasePriceTTC;
    private BigDecimal purchasePriceVat;
  private Long quantity ;
    private BigDecimal salePriceHT;
    private Vat saleVat;
    private BigDecimal salePriceTTC;
    private BigDecimal salePriceVat;

    private BigDecimal totalSalePriceHT;
    private BigDecimal totalSalePriceTTC;
    private BigDecimal totalSalePriceVat;

    private BigDecimal totalPurchasePriceHT;
    private BigDecimal totalPurchaseVat;
    private BigDecimal totalPurchasePriceTTC;

private Owner owner;

private OrderTransport orderTransport;
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

    public BigDecimal getTotalSalePriceHT() {
        return totalSalePriceHT;
    }

    public void setTotalSalePriceHT(BigDecimal totalSalePriceHT) {
        this.totalSalePriceHT = totalSalePriceHT;
    }

    public BigDecimal getTotalSalePriceTTC() {
        return totalSalePriceTTC;
    }

    public void setTotalSalePriceTTC(BigDecimal totalSalePriceTTC) {
        this.totalSalePriceTTC = totalSalePriceTTC;
    }

    public BigDecimal getPurchasePriceVat() {
        return purchasePriceVat;
    }

    public void setPurchasePriceVat(BigDecimal purchasePriceVat) {
        this.purchasePriceVat = purchasePriceVat;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPurchasePriceHT() {
        return totalPurchasePriceHT;
    }

    public void setTotalPurchasePriceHT(BigDecimal totalPurchasePriceHT) {
        this.totalPurchasePriceHT = totalPurchasePriceHT;
    }

    public BigDecimal getTotalPurchaseVat() {
        return totalPurchaseVat;
    }

    public void setTotalPurchaseVat(BigDecimal totalPurchaseVat) {
        this.totalPurchaseVat = totalPurchaseVat;
    }

    public BigDecimal getTotalPurchasePriceTTC() {
        return totalPurchasePriceTTC;
    }

    public void setTotalPurchasePriceTTC(BigDecimal totalPurchasePriceTTC) {
        this.totalPurchasePriceTTC = totalPurchasePriceTTC;
    }

    public BigDecimal getTotalSalePriceVat() {
        return totalSalePriceVat;
    }

    public void setTotalSalePriceVat(BigDecimal totalSalePriceVat) {
        this.totalSalePriceVat = totalSalePriceVat;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public BigDecimal getPurchasePriceHT() {
        return purchasePriceHT;
    }

    public void setPurchasePriceHT(BigDecimal purchasePriceHT) {
        this.purchasePriceHT = purchasePriceHT;
    }

    public BigDecimal getSalePriceVat() {
        return salePriceVat;
    }

    public void setSalePriceVat(BigDecimal salePriceVat) {
        this.salePriceVat = salePriceVat;
    }



    public OrderTransport getOrderTransport() {
        return orderTransport;
    }

    public void setOrderTransport(OrderTransport orderTransport) {
        this.orderTransport = orderTransport;
    }

    public Vat getPurchaseVat() {
        return purchaseVat;
    }

    public void setPurchaseVat(Vat purchaseVat) {
        this.purchaseVat = purchaseVat;
    }

    public BigDecimal getPurchasePriceTTC() {
        return purchasePriceTTC;
    }

    public void setPurchasePriceTTC(BigDecimal purchasePriceTTC) {
        this.purchasePriceTTC = purchasePriceTTC;
    }

    public BigDecimal getSalePriceHT() {
        return salePriceHT;
    }

    public void setSalePriceHT(BigDecimal salePriceHT) {
        this.salePriceHT = salePriceHT;
    }

    public Vat getSaleVat() {
        return saleVat;
    }

    public void setSaleVat(Vat saleVat) {
        this.saleVat = saleVat;
    }

    public BigDecimal getSalePriceTTC() {
        return salePriceTTC;
    }

    public void setSalePriceTTC(BigDecimal salePriceTTC) {
        this.salePriceTTC = salePriceTTC;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
