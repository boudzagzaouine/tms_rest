package com.sinno.ems.entities;

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
@Table(name = "inv_accountinvoice", uniqueConstraints = @UniqueConstraint(columnNames = "inv_accountinvoicecode"))
public class InvAccountInvoice {
    private long InvAccountInvoiceId;
    @NotNull
    private String invAccountInvoiceCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountInvoiceCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountInvoiceUpdateDate;
    private CmdAccount cmdAccount;
    @NotNull
    private BigDecimal invAccountInvoicePriceHt;
    @NotNull
    private BigDecimal invAccountInvoicePriceTTC;
    private BigDecimal invAccountInvoiceDiscount;
    private BigDecimal invAccountInvoiceVat;
    private BigDecimal invAccountInvoiceAmountPayed;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountInvoiceDeadLine;
    private Long invAccountInvoiceState;
    private Set<InvAccountInvoiceLine> invAccountInvoiceLines = new HashSet<InvAccountInvoiceLine>();
    private CmdSaleOrder cmdSaleOrder;
    private OwnOwner ownOwner;
    private WrhWarehouse wrhWarehouse;
    private PrmCurrency prmCurrency;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_ems.inv_accountinvoice_inv_accountinvoiceid_seq", allocationSize = 1)
    @Column(name = "inv_accountinvoiceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getInvAccountInvoiceId() {
        return InvAccountInvoiceId;
    }

    public void setInvAccountInvoiceId(long invAccountInvoiceId) {
        InvAccountInvoiceId = invAccountInvoiceId;
    }

    @Column(name = "inv_accountinvoicecode", unique = true, nullable = false, length = 50)
    public String getInvAccountInvoiceCode() {
        return invAccountInvoiceCode;
    }

    public void setInvAccountInvoiceCode(String invAccountInvoiceCode) {
        this.invAccountInvoiceCode = invAccountInvoiceCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_accountinvoicecreationdate")
    public Date getInvAccountInvoiceCreationDate() {
        return invAccountInvoiceCreationDate;
    }

    public void setInvAccountInvoiceCreationDate(Date invAccountInvoiceCreationDate) {
        this.invAccountInvoiceCreationDate = invAccountInvoiceCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_accountinvoiceupdatedate")
    public Date getInvAccountInvoiceUpdateDate() {
        return invAccountInvoiceUpdateDate;
    }

    public void setInvAccountInvoiceUpdateDate(Date invAccountInvoiceUpdateDate) {
        this.invAccountInvoiceUpdateDate = invAccountInvoiceUpdateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoiceaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @Column(name = "inv_accountinvoicepriceht", nullable = false)
    public BigDecimal getInvAccountInvoicePriceHt() {
        return invAccountInvoicePriceHt;
    }

    public void setInvAccountInvoicePriceHt(BigDecimal invAccountInvoicePriceHt) {
        this.invAccountInvoicePriceHt = invAccountInvoicePriceHt;
    }

    @Column(name = "inv_accountinvoicepricettc", nullable = false)
    public BigDecimal getInvAccountInvoicePriceTTC() {
        return invAccountInvoicePriceTTC;
    }

    public void setInvAccountInvoicePriceTTC(BigDecimal invAccountInvoicePriceTTC) {
        this.invAccountInvoicePriceTTC = invAccountInvoicePriceTTC;
    }

    @Column(name = "inv_accountinvoicediscount")

    public BigDecimal getInvAccountInvoiceDiscount() {
        return invAccountInvoiceDiscount;
    }

    public void setInvAccountInvoiceDiscount(BigDecimal invAccountInvoiceDiscount) {
        this.invAccountInvoiceDiscount = invAccountInvoiceDiscount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_accountinvoicedeadline")

    public Date getInvAccountInvoiceDeadLine() {
        return invAccountInvoiceDeadLine;
    }

    public void setInvAccountInvoiceDeadLine(Date invAccountInvoiceDeadLine) {
        this.invAccountInvoiceDeadLine = invAccountInvoiceDeadLine;
    }

    @Column(name = "inv_accountinvoicestate")
    public Long getInvAccountInvoiceState() {
        return invAccountInvoiceState;
    }

    public void setInvAccountInvoiceState(Long invAccountInvoiceState) {
        this.invAccountInvoiceState = invAccountInvoiceState;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "invAccountInvoice", orphanRemoval = true)

    public Set<InvAccountInvoiceLine> getInvAccountInvoiceLines() {
        return invAccountInvoiceLines;
    }

    public void setInvAccountInvoiceLines(Set<InvAccountInvoiceLine> invAccountInvoiceLines) {
        this.invAccountInvoiceLines = invAccountInvoiceLines;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoicesorderid")
    public CmdSaleOrder getCmdSaleOrder() {
        return cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoiceownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoicewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "inv_accountinvoicevat")
    public BigDecimal getInvAccountInvoiceVat() {
        return invAccountInvoiceVat;
    }

    public void setInvAccountInvoiceVat(BigDecimal invAccountInvoiceVat) {
        this.invAccountInvoiceVat = invAccountInvoiceVat;
    }

    @Column(name = "inv_accountinvoiceamountpayed")
    public BigDecimal getInvAccountInvoiceAmountPayed() {
        return invAccountInvoiceAmountPayed;
    }

    public void setInvAccountInvoiceAmountPayed(BigDecimal invAccountInvoiceAmountPayed) {
        this.invAccountInvoiceAmountPayed = invAccountInvoiceAmountPayed;
    }

    @JoinColumn(name = "inv_accountinvoicecurrencyid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
}
