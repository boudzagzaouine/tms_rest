package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
@Entity
@Table(name = "inv_accountlitigation")
public class InvAccountLitigation {
    private long invAccountLitigationId;
    private BigDecimal invAccountLitigationAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountLitigationCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountLitigationUpdateDate;
    private InvAccountInvoice invAccountInvoice;
    private String invAccountLitigationObject;
    private String invAccountLitigationComment;
    private CmdAccount cmdAccount;
    private PrmCurrency prmCurrency;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_accountlitigation_inv_accountlitigationid_seq", allocationSize = 1)
    @Column(name = "inv_accountlitigationid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getInvAccountLitigationId() {
        return invAccountLitigationId;
    }

    public void setInvAccountLitigationId(long invAccountLitigationId) {
        this.invAccountLitigationId = invAccountLitigationId;
    }

    @Column(name = "inv_accountlitigationamount")
    public BigDecimal getInvAccountLitigationAmount() {
        return invAccountLitigationAmount;
    }

    public void setInvAccountLitigationAmount(BigDecimal invAccountLitigationAmount) {
        this.invAccountLitigationAmount = invAccountLitigationAmount;
    }

    @Column(name = "inv_accountlitigationcreationdate")

    public Date getInvAccountLitigationCreationDate() {
        return invAccountLitigationCreationDate;
    }

    public void setInvAccountLitigationCreationDate(Date invAccountLitigationCreationDate) {
        this.invAccountLitigationCreationDate = invAccountLitigationCreationDate;
    }

    @Column(name = "inv_accountlitigationupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvAccountLitigationUpdateDate() {
        return invAccountLitigationUpdateDate;
    }

    public void setInvAccountLitigationUpdateDate(Date invAccountLitigationUpdateDate) {
        this.invAccountLitigationUpdateDate = invAccountLitigationUpdateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountlitigationinvoiceid")
    public InvAccountInvoice getInvAccountInvoice() {
        return invAccountInvoice;
    }

    public void setInvAccountInvoice(InvAccountInvoice invAccountInvoice) {
        this.invAccountInvoice = invAccountInvoice;
    }

    @Column(name = "inv_accountlitigationobject")

    public String getInvAccountLitigationObject() {
        return invAccountLitigationObject;
    }

    public void setInvAccountLitigationObject(String invAccountLitigationObject) {
        this.invAccountLitigationObject = invAccountLitigationObject;
    }

    @Column(name = "inv_accountlitigationcomment")
    public String getInvAccountLitigationComment() {
        return invAccountLitigationComment;
    }

    public void setInvAccountLitigationComment(String invAccountLitigationComment) {
        this.invAccountLitigationComment = invAccountLitigationComment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountlitigationaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @JoinColumn(name = "inv_accountlitigationcurrencyid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }

}
