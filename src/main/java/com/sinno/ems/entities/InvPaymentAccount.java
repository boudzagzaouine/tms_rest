package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
@Entity
@Table(name = "inv_paymentaccount")
public class InvPaymentAccount {
    private long invPaymentAccountId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invPaymentAccountDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invPaymentAccountCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invPaymentAccountUpdateDate;
    @NotNull
    private CmdAccount cmdAccount;
    @NotNull
    private PrmPaymentType prmPaymentType;
    private BigDecimal InvPaymentAccountAmount;
    @NotNull
    private InvAccountInvoice invAccountInvoice;
    private String invPaymentAccountNumber;
    private CmdAssetAccount cmdAssetAccount;
    private PrmCurrency prmCurrency;
    private PrmVat prmVat;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_paymentaccount_inv_paymentaccountid_seq", allocationSize = 1)
    @Column(name = "inv_paymentaccountid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getInvPaymentAccountId() {
        return invPaymentAccountId;
    }

    public void setInvPaymentAccountId(long invPaymentAccountId) {
        this.invPaymentAccountId = invPaymentAccountId;
    }
    @Column(name = "inv_paymentaccountdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvPaymentAccountDate() {
        return invPaymentAccountDate;
    }

    public void setInvPaymentAccountDate(Date invPaymentAccountDate) {
        this.invPaymentAccountDate = invPaymentAccountDate;
    }
    @Column(name = "inv_paymentaccountcreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvPaymentAccountCreationDate() {
        return invPaymentAccountCreationDate;
    }

    public void setInvPaymentAccountCreationDate(Date invPaymentAccountCreationDate) {
        this.invPaymentAccountCreationDate = invPaymentAccountCreationDate;
    }
    @Column(name = "inv_paymentaccountupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvPaymentAccountUpdateDate() {
        return invPaymentAccountUpdateDate;
    }

    public void setInvPaymentAccountUpdateDate(Date invPaymentAccountUpdateDate) {
        this.invPaymentAccountUpdateDate = invPaymentAccountUpdateDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_paymentaccountaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_paymentaccounttypeid")
    public PrmPaymentType getPrmPaymentType() {
        return prmPaymentType;
    }

    public void setPrmPaymentType(PrmPaymentType prmPaymentType) {
        this.prmPaymentType = prmPaymentType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_paymentaccountinvoiceid")
    public InvAccountInvoice getInvAccountInvoice() {
        return invAccountInvoice;
    }

    public void setInvAccountInvoice(InvAccountInvoice invAccountInvoice) {
        this.invAccountInvoice = invAccountInvoice;
    }
    @Column(name = "inv_paymentaccountamount")

    public BigDecimal getInvPaymentAccountAmount() {
        return InvPaymentAccountAmount;
    }

    public void setInvPaymentAccountAmount(BigDecimal invPaymentAccountAmount) {
        InvPaymentAccountAmount = invPaymentAccountAmount;
    }
    @Column(name="inv_paymentaccountnumber")
    public String getInvPaymentAccountNumber() {
        return invPaymentAccountNumber;
    }

    public void setInvPaymentAccountNumber(String invPaymentAccountNumber) {
        this.invPaymentAccountNumber = invPaymentAccountNumber;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inv_paymentaccountassetaccountid")
    public CmdAssetAccount getCmdAssetAccount() {
        return cmdAssetAccount;
    }

    public void setCmdAssetAccount(CmdAssetAccount cmdAssetAccount) {
        this.cmdAssetAccount = cmdAssetAccount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inv_paymentaccountassetcurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inv_paymentaccountvatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }
}
