package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
@Entity
@Table(name = "inv_supplierlitigation")
public class InvSupplierLitigation {

    private long invSupplierLitigationId;
    private BigDecimal invSupplierLitigationAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierLitigationCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierLitigationUpdateDate;
    private InvSupplierInvoice invSupplierInvoice;
    private String invSupplierLitigationObject;
    private String invSupplierLitigationComment;
    private RcpSupplier rcpSupplier;
    private PrmCurrency prmCurrency;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_supplierlitigation_inv_supplierlitigationid_seq", allocationSize = 1)
    @Column(name = "inv_supplierlitigationid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getInvSupplierLitigationId() {
        return invSupplierLitigationId;
    }

    public void setInvSupplierLitigationId(long invSupplierLitigationId) {
        this.invSupplierLitigationId = invSupplierLitigationId;
    }
    @Column(name = "inv_supplierlitigationamount")
    public BigDecimal getInvSupplierLitigationAmount() {
        return invSupplierLitigationAmount;
    }

    public void setInvSupplierLitigationAmount(BigDecimal invSupplierLitigationAmount) {
        this.invSupplierLitigationAmount = invSupplierLitigationAmount;
    }
    @Column(name = "inv_supplierlitigationcreationdate")

    public Date getInvSupplierLitigationCreationDate() {
        return invSupplierLitigationCreationDate;
    }

    public void setInvSupplierLitigationCreationDate(Date invSupplierLitigationCreationDate) {
        this.invSupplierLitigationCreationDate = invSupplierLitigationCreationDate;
    }
    @Column(name = "inv_supplierlitigationupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvSupplierLitigationUpdateDate() {
        return invSupplierLitigationUpdateDate;
    }

    public void setInvSupplierLitigationUpdateDate(Date invSupplierLitigationUpdateDate) {
        this.invSupplierLitigationUpdateDate = invSupplierLitigationUpdateDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierlitigationinvoiceid")
    public InvSupplierInvoice getInvSupplierInvoice() {
        return invSupplierInvoice;
    }

    public void setInvSupplierInvoice(InvSupplierInvoice invSupplierInvoice) {
        this.invSupplierInvoice = invSupplierInvoice;
    }
    @Column(name = "inv_supplierlitigationobject")

    public String getInvSupplierLitigationObject() {
        return invSupplierLitigationObject;
    }

    public void setInvSupplierLitigationObject(String invSupplierLitigationObject) {
        this.invSupplierLitigationObject = invSupplierLitigationObject;
    }
    @Column(name = "inv_supplierlitigationcomment")
    public String getInvSupplierLitigationComment() {
        return invSupplierLitigationComment;
    }

    public void setInvSupplierLitigationComment(String invSupplierLitigationComment) {
        this.invSupplierLitigationComment = invSupplierLitigationComment;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierlitigationsupplierid")

    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierlitigationcurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }

}
