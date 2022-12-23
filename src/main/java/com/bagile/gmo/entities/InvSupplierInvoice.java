package com.bagile.gmo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 03/12/2016.
 */
@Entity
@Table(name = "inv_supplierinvoice", uniqueConstraints = {@UniqueConstraint(columnNames = "inv_supplierinvoicecode"),
        @UniqueConstraint(columnNames = {"inv_supplierinvoicesupplierinvoicecode", "inv_supplierinvoicesupplierid"})})
public class InvSupplierInvoice extends EmsEntity {
    private long invSupplierInvoiceId;
    @NotNull
    private String invSupplierInvoiceCode;
    private String invSupplierInvoiceSupplierInvoiceCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierInvoiceCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierInvoiceUpdateDate;
    private RcpSupplier rcpSupplier;
    private BigDecimal invSupplierInvoicePriceHt;
    private BigDecimal InvSupplierInvoicePriceTtc;
    private BigDecimal invSupplierInvoiceDiscount;
    private BigDecimal invSupplierInvoiceVat;
    private BigDecimal invSupplierInvoiceAmountPayed;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierInvoiceDeadLine;
  //  @NotNull
    private PrmInvoiceStatus prmInvoiceStatus;
    private Set<InvSupplierInvoiceLine> invSupplierInvoiceLines = new HashSet<InvSupplierInvoiceLine>();
    private RcpPurshaseOrder rcpPurshaseOrder;
    private WrhWarehouse wrhWarehouse;
    private OwnOwner ownOwner;
   // @NotNull
    private PrmCurrency prmCurrency;
    @NotNull
    private Boolean invSupplierInvoiceActive;
  //  private RcpBillingTerm rcpBillingTerm;
    private PrmPaymentType prmPaymentType;
    private Set<InvSupplierInvoice> childes = new HashSet<>(0);

    private PrmPaymentStatus prmPaymentStatus;
    private InvSupplierInvoice parent;
    private Date invSupplierInvoiceDate;
    private Set<InvSupplierInvoiceReception> invSupplierInvoiceReceptions=new HashSet<>();
    private Set<InvSupplierInvoicePurchaseOrder> invSupplierInvoicePurchaseOrders=new HashSet<>();

    private Boolean invSupplierInvoiceGmao;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_crmexpress.inv_supplierinvoice_inv_supplierinvoiceid_seq", allocationSize = 1)
    @Column(name = "inv_supplierinvoiceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getInvSupplierInvoiceId() {
        return invSupplierInvoiceId;
    }

    public void setInvSupplierInvoiceId(long invSupplierInvoiceId) {
        this.invSupplierInvoiceId = invSupplierInvoiceId;
    }

    @Column(name = "inv_supplierinvoicecode", unique = true, nullable = false, length = 50)
    public String getInvSupplierInvoiceCode() {
        return invSupplierInvoiceCode;
    }

    public void setInvSupplierInvoiceCode(String invSupplierInvoiceCode) {
        this.invSupplierInvoiceCode = invSupplierInvoiceCode;
    }
    @Column(name = "inv_supplierinvoicegmao")
    public Boolean getInvSupplierInvoiceGmao() {
        return invSupplierInvoiceGmao;
    }

    public void setInvSupplierInvoiceGmao(Boolean invSupplierInvoiceGmao) {
        this.invSupplierInvoiceGmao = invSupplierInvoiceGmao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoicecreationdate")
    public Date getInvSupplierInvoiceCreationDate() {
        return invSupplierInvoiceCreationDate;
    }

    public void setInvSupplierInvoiceCreationDate(Date invSupplierInvoiceCreationDate) {
        this.invSupplierInvoiceCreationDate = invSupplierInvoiceCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoiceupdatedate")
    public Date getInvSupplierInvoiceUpdateDate() {
        return invSupplierInvoiceUpdateDate;
    }

    public void setInvSupplierInvoiceUpdateDate(Date invSupplierInvoiceUpdateDate) {
        this.invSupplierInvoiceUpdateDate = invSupplierInvoiceUpdateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicesupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @Column(name = "inv_supplierinvoicepriceht")
    public BigDecimal getInvSupplierInvoicePriceHt() {
        return invSupplierInvoicePriceHt;
    }

    public void setInvSupplierInvoicePriceHt(BigDecimal invSupplierInvoiceAmountHt) {
        invSupplierInvoicePriceHt = invSupplierInvoiceAmountHt;
    }

    @Column(name = "inv_supplierinvoicepricettc")
    public BigDecimal getInvSupplierInvoicePriceTtc() {
        return InvSupplierInvoicePriceTtc;
    }

    public void setInvSupplierInvoicePriceTtc(BigDecimal invSupplierInvoiceAmountHtt) {
        InvSupplierInvoicePriceTtc = invSupplierInvoiceAmountHtt;
    }


    @Column(name = "inv_supplierinvoicediscount")

    public BigDecimal getInvSupplierInvoiceDiscount() {
        return invSupplierInvoiceDiscount;
    }

    public void setInvSupplierInvoiceDiscount(BigDecimal invSupplierInvoiceDiscount) {
        this.invSupplierInvoiceDiscount = invSupplierInvoiceDiscount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoicedeadline")

    public Date getInvSupplierInvoiceDeadLine() {
        return invSupplierInvoiceDeadLine;
    }

    public void setInvSupplierInvoiceDeadLine(Date invSupplierInvoiceDeadLine) {
        this.invSupplierInvoiceDeadLine = invSupplierInvoiceDeadLine;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicestatusid")

    public PrmInvoiceStatus getPrmInvoiceStatus() {
        return prmInvoiceStatus;
    }

    public void setPrmInvoiceStatus(PrmInvoiceStatus prmInvoiceStatus) {
        this.prmInvoiceStatus = prmInvoiceStatus;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "invSupplierInvoice", orphanRemoval = true)
    public Set<InvSupplierInvoiceLine> getInvSupplierInvoiceLines() {
        return invSupplierInvoiceLines;
    }

    public void setInvSupplierInvoiceLines(Set<InvSupplierInvoiceLine> invSupplierInvoiceLines) {
        this.invSupplierInvoiceLines = invSupplierInvoiceLines;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoiceporderid", nullable = false)
    public RcpPurshaseOrder getRcpPurshaseOrder() {
        return rcpPurshaseOrder;
    }

    public void setRcpPurshaseOrder(RcpPurshaseOrder rcpPurshaseOrder) {
        this.rcpPurshaseOrder = rcpPurshaseOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoiceownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Column(name = "inv_supplierinvoicevat")
    public BigDecimal getInvSupplierInvoiceVat() {
        return invSupplierInvoiceVat;
    }

    public void setInvSupplierInvoiceVat(BigDecimal invSupplierInvoiceVat) {
        this.invSupplierInvoiceVat = invSupplierInvoiceVat;
    }

    @Column(name = "inv_supplierinvoiceamountpayed")
    public BigDecimal getInvSupplierInvoiceAmountPayed() {
        return invSupplierInvoiceAmountPayed;
    }

    public void setInvSupplierInvoiceAmountPayed(BigDecimal invSupplierInvoiceAmountPayed) {
        this.invSupplierInvoiceAmountPayed = invSupplierInvoiceAmountPayed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicecurrencyid", nullable = false)
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }

    @Column(name = "inv_supplierinvoiceactive", nullable = false)
    public Boolean getInvSupplierInvoiceActive() {
        return invSupplierInvoiceActive;
    }

    public void setInvSupplierInvoiceActive(Boolean invSupplierInvoiceActive) {
        this.invSupplierInvoiceActive = invSupplierInvoiceActive;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "inv_supplierinvoicetermid")
//    public RcpBillingTerm getRcpBillingTerm() {
//        return rcpBillingTerm;
//    }
//
//    public void setRcpBillingTerm(RcpBillingTerm rcpBillingTerm) {
//        this.rcpBillingTerm = rcpBillingTerm;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicepaymenttypeid")
    public PrmPaymentType getPrmPaymentType() {
        return prmPaymentType;
    }

    public void setPrmPaymentType(PrmPaymentType prmPaymentType) {
        this.prmPaymentType = prmPaymentType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicepaymentstatusid")
    public PrmPaymentStatus getPrmPaymentStatus() {
        return prmPaymentStatus;
    }

    public void setPrmPaymentStatus(PrmPaymentStatus prmPaymentStatus) {
        this.prmPaymentStatus = prmPaymentStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoiceparentid")
    public InvSupplierInvoice getParent() {
        return parent;
    }

    public void setParent(InvSupplierInvoice parent) {
        this.parent = parent;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    public Set<InvSupplierInvoice> getChildes() {
        return childes;
    }

    public void setChildes(Set<InvSupplierInvoice> childes) {
        this.childes = childes;
    }

    @Column(name = "inv_supplierinvoicesupplierinvoicecode")
    public String getInvSupplierInvoiceSupplierInvoiceCode() {
        return invSupplierInvoiceSupplierInvoiceCode;
    }

    public void setInvSupplierInvoiceSupplierInvoiceCode(String invSupplierInvoiceSupplierInvoiceCode) {
        this.invSupplierInvoiceSupplierInvoiceCode = invSupplierInvoiceSupplierInvoiceCode;
    }

    @Column(name = "inv_supplierinvoicedate")
    public Date getInvSupplierInvoiceDate() {
        return invSupplierInvoiceDate;
    }

    public void setInvSupplierInvoiceDate(Date invSupplierInvoiceDate) {
        this.invSupplierInvoiceDate = invSupplierInvoiceDate;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "invSupplierInvoice",cascade = CascadeType.ALL)
    public Set<InvSupplierInvoiceReception> getInvSupplierInvoiceReceptions() {
        return invSupplierInvoiceReceptions;
    }

    public void setInvSupplierInvoiceReceptions(Set<InvSupplierInvoiceReception> invSupplierInvoiceReceptions) {
        this.invSupplierInvoiceReceptions = invSupplierInvoiceReceptions;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "invSupplierInvoice",cascade = CascadeType.ALL)
    public Set<InvSupplierInvoicePurchaseOrder> getInvSupplierInvoicePurchaseOrders() {
        return invSupplierInvoicePurchaseOrders;
    }

    public void setInvSupplierInvoicePurchaseOrders(Set<InvSupplierInvoicePurchaseOrder> invSupplierInvoicePurchaseOrders) {
        this.invSupplierInvoicePurchaseOrders = invSupplierInvoicePurchaseOrders;
    }
}
