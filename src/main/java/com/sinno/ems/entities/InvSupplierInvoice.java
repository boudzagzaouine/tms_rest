package com.sinno.ems.entities;

import com.sinno.ems.dto.Currency;
import com.sinno.ems.dto.Warehouse;
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
@Table(name = "inv_supplierinvoice", uniqueConstraints = @UniqueConstraint(columnNames = "inv_supplierinvoicecode"))
public class InvSupplierInvoice {
    private long invSupplierInvoiceId;
    @NotNull
    private String invSupplierInvoiceCode;
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
    private Long invSupplierInvoiceState;
    private Set<InvSupplierInvoiceLine> invSupplierInvoiceLines = new HashSet<InvSupplierInvoiceLine>();
    private RcpPurshaseOrder rcpPurshaseOrder;
    private WrhWarehouse wrhWarehouse;
    private OwnOwner ownOwner;
    private PrmCurrency prmCurrency;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_ems.inv_supplierinvoice_inv_supplierinvoiceid_seq", allocationSize = 1)
    @Column(name = "inv_supplierinvoiceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getInvSupplierInvoiceId() {
        return invSupplierInvoiceId;
    }

    public void setInvSupplierInvoiceId(long invAccountInvoiceId) {
        invSupplierInvoiceId = invAccountInvoiceId;
    }

    @Column(name = "inv_supplierinvoicecode", unique = true, nullable = false, length = 50)
    public String getInvSupplierInvoiceCode() {
        return invSupplierInvoiceCode;
    }

    public void setInvSupplierInvoiceCode(String invAccountInvoiceCode) {
        invSupplierInvoiceCode = invAccountInvoiceCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoicecreationdate")
    public Date getInvSupplierInvoiceCreationDate() {
        return invSupplierInvoiceCreationDate;
    }

    public void setInvSupplierInvoiceCreationDate(Date invAccountInvoiceCreationDate) {
        invSupplierInvoiceCreationDate = invAccountInvoiceCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoiceupdatedate")
    public Date getInvSupplierInvoiceUpdateDate() {
        return invSupplierInvoiceUpdateDate;
    }

    public void setInvSupplierInvoiceUpdateDate(Date invAccountInvoiceUpdateDate) {
        invSupplierInvoiceUpdateDate = invAccountInvoiceUpdateDate;
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

    public void setInvSupplierInvoicePriceHt(BigDecimal invAccountInvoiceAmountHt) {
        invSupplierInvoicePriceHt = invAccountInvoiceAmountHt;
    }

    @Column(name = "inv_supplierinvoicepricettc")
    public BigDecimal getInvSupplierInvoicePriceTtc() {
        return InvSupplierInvoicePriceTtc;
    }

    public void setInvSupplierInvoicePriceTtc(BigDecimal invAccountInvoiceAmountHtt) {
        InvSupplierInvoicePriceTtc = invAccountInvoiceAmountHtt;
    }


    @Column(name = "inv_supplierinvoicediscount")

    public BigDecimal getInvSupplierInvoiceDiscount() {
        return invSupplierInvoiceDiscount;
    }

    public void setInvSupplierInvoiceDiscount(BigDecimal invAccountInvoiceDiscount) {
        invSupplierInvoiceDiscount = invAccountInvoiceDiscount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoicedeadline")

    public Date getInvSupplierInvoiceDeadLine() {
        return invSupplierInvoiceDeadLine;
    }

    public void setInvSupplierInvoiceDeadLine(Date invAccountInvoiceDeadLine) {
        invSupplierInvoiceDeadLine = invAccountInvoiceDeadLine;
    }

    @Column(name = "inv_supplierinvoicestate")
    public Long getInvSupplierInvoiceState() {
        return invSupplierInvoiceState;
    }

    public void setInvSupplierInvoiceState(Long invAccountInvoiceState) {
        invSupplierInvoiceState = invAccountInvoiceState;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "invSupplierInvoice", orphanRemoval = true)
    public Set<InvSupplierInvoiceLine> getInvSupplierInvoiceLines() {
        return invSupplierInvoiceLines;
    }

    public void setInvSupplierInvoiceLines(Set<InvSupplierInvoiceLine> invSupplierInvoiceLines) {
        this.invSupplierInvoiceLines = invSupplierInvoiceLines;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoiceporderid")
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
    @JoinColumn(name = "inv_supplierinvoicecurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
}
