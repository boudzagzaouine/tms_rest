package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 16/12/2016.
 */
@Entity
@Table(name = "cmd_assetaccount")
public class CmdAssetAccount {
    private long cmdAssetId;
    @NotNull
    private String cmdAssetCode;
    @NotNull
    private BigDecimal cmdAssetAmount;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdBeginDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdExpirationDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdUpdateDate;
    @NotNull
    private Boolean cmdUsed;
    @NotNull
    private CmdSaleOrder cmdSaleOrder;
    @NotNull
    private PrmCurrency prmCurrency;
    private InvAccountInvoice invAccountInvoice;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "cmd_cmdassetaccount_cmd_cmdassetaccountid_seq", allocationSize = 1)
    @Column(name = "cmd_assetaccountid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getCmdAssetId() {
        return cmdAssetId;
    }

    public void setCmdAssetId(long cmdAssetId) {
        this.cmdAssetId = cmdAssetId;
    }

    @Column(name = "cmd_assetaccountcode", nullable = false)
    public String getCmdAssetCode() {
        return cmdAssetCode;
    }

    public void setCmdAssetCode(String cmdAssetCode) {
        this.cmdAssetCode = cmdAssetCode;
    }

    @Column(name = "cmd_assetaccountamount", precision = 12, scale = 0,nullable = false)
    public BigDecimal getCmdAssetAmount() {
        return cmdAssetAmount;
    }

    public void setCmdAssetAmount(BigDecimal cmdAssetAmount) {
        this.cmdAssetAmount = cmdAssetAmount;
    }

    @Column(name = "cmd_begindate",nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getCmdBeginDate() {
        return cmdBeginDate;
    }

    public void setCmdBeginDate(Date cmdBeginDate) {
        this.cmdBeginDate = cmdBeginDate;
    }

    @Column(name = "cmd_expirationdate",nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getCmdExpirationDate() {
        return cmdExpirationDate;
    }

    public void setCmdExpirationDate(Date cmdExpirationDate) {
        this.cmdExpirationDate = cmdExpirationDate;
    }

    @Column(name = "cmd_assetaccountcreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCmdCreationDate() {
        return cmdCreationDate;
    }

    public void setCmdCreationDate(Date cmdCreationDate) {
        this.cmdCreationDate = cmdCreationDate;
    }

    @Column(name = "cmd_assetaccountupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCmdUpdateDate() {
        return cmdUpdateDate;
    }

    public void setCmdUpdateDate(Date cmdUpdateDate) {
        this.cmdUpdateDate = cmdUpdateDate;
    }

    @Column(name = "cmd_assetaccountisused",nullable = false)
    public Boolean getCmdUsed() {
        return cmdUsed;
    }

    public void setCmdUsed(Boolean cmdUsed) {
        this.cmdUsed = cmdUsed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_assetaccountsaleorderid",nullable = false)
    public CmdSaleOrder getCmdSaleOrder() {
        return cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }
    @JoinColumn(name="cmd_assetaccountcurrencyid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_assetaccountinvoiceid")
    public InvAccountInvoice getInvAccountInvoice() {
        return invAccountInvoice;
    }

    public void setInvAccountInvoice(InvAccountInvoice invAccountInvoice) {
        this.invAccountInvoice = invAccountInvoice;
    }
}
