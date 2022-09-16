package com.bagile.gmo.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 03/12/2016.
 */
public class SupplierInvoice extends EmsDto implements Serializable {
    private long id;
    private String code;
    private String description;
    private String supplierInvoiceCode;
    private Date creationDate;
    private Date updateDate;
    private Supplier supplier;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal discount;
    private BigDecimal vat;
    private Date deadLine;
    private InvoiceStatus invoiceStatus;
    private PurshaseOrder purshaseOrder;
    private Warehouse warehouse;
    private Owner owner;
    private BigDecimal amountPayed = BigDecimal.ZERO;
    private Currency currency;
    private PaymentType paymentType;
    private Boolean active;
    //private BillingTermPurshase billingTermPurshase;
    private PaymentStatus paymentStatus;
    private Date invoiceDate;
    private SupplierInvoice parent;
    private Set<SupplierInvoice> childes;
    private Set<SupplierInvoiceLine> supplierInvoiceLines = new HashSet<SupplierInvoiceLine>();
    private Set<SupplierInvoiceReception> supplierInvoiceReceptions = new HashSet<>();
    private Set<SupplierInvoicePurchaseOrder> supplierInvoicePurchaseOrders = new HashSet<>();

    private Boolean gmao;
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

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

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Boolean getGmao() {
        return gmao;
    }

    public void setGmao(Boolean gmao) {
        this.gmao = gmao;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Set<SupplierInvoiceLine> getSupplierInvoiceLines() {
        return supplierInvoiceLines;
    }

    public void setSupplierInvoiceLines(Set<SupplierInvoiceLine> supplierInvoiceLines) {
        this.supplierInvoiceLines = supplierInvoiceLines;
    }

    public PurshaseOrder getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(PurshaseOrder purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(BigDecimal amountPayed) {
        this.amountPayed = amountPayed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

//    public BillingTermPurshase getBillingTermPurshase() {
//        return billingTermPurshase;
//    }
//
//    public void setBillingTermPurshase(BillingTermPurshase billingTermPurshase) {
//        this.billingTermPurshase = billingTermPurshase;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public SupplierInvoice getParent() {
        return parent;
    }

    public void setParent(SupplierInvoice parent) {
        this.parent = parent;
    }

    public Set<SupplierInvoice> getChildes() {
        return childes;
    }

    public void setChildes(Set<SupplierInvoice> childes) {
        this.childes = childes;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSupplierInvoiceCode() {
        return supplierInvoiceCode;
    }

    public void setSupplierInvoiceCode(String supplierInvoiceCode) {
        this.supplierInvoiceCode = supplierInvoiceCode;
    }

    public Set<SupplierInvoiceReception> getSupplierInvoiceReceptions() {
        return supplierInvoiceReceptions;
    }

    public void setSupplierInvoiceReceptions(Set<SupplierInvoiceReception> supplierInvoiceReceptions) {
        this.supplierInvoiceReceptions = supplierInvoiceReceptions;
    }

    public Set<SupplierInvoicePurchaseOrder> getSupplierInvoicePurchaseOrders() {
        return supplierInvoicePurchaseOrders;
    }

    public void setSupplierInvoicePurchaseOrders(Set<SupplierInvoicePurchaseOrder> supplierInvoicePurchaseOrders) {
        this.supplierInvoicePurchaseOrders = supplierInvoicePurchaseOrders;
    }
}
