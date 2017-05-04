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
@Table(name = "inv_paymentsupplier")
public class InvPaymentSupplier {
    private long invPaymentSupplierId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invPaymentSupplierDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invPaymentSupplierCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invPaymentSupplierUpdateDate;
    private BigDecimal invPaymentSupplierAmount;
    private RcpSupplier rcpSupplier;
    @NotNull
    private PrmPaymentType prmPaymentType;
    @NotNull
    private InvSupplierInvoice invSupplierInvoice;
    private String invPaymentSupplierNumber;
    private RcpAssetSupplier rcpAssetSupplier;
    private PrmCurrency prmCurrency;
    private PrmVat prmVat;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_paymentsupplier_inv_paymentsupplierid_seq", allocationSize = 1)
    @Column(name = "inv_paymentsupplierid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getInvPaymentSupplierId() {
        return invPaymentSupplierId;
    }

    public void setInvPaymentSupplierId(long invPaymentSupplierId) {
        this.invPaymentSupplierId = invPaymentSupplierId;
    }

    @Column(name = "inv_paymentsupplierdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvPaymentSupplierDate() {
        return invPaymentSupplierDate;
    }

    public void setInvPaymentSupplierDate(Date invPaymentSupplierDate) {
        this.invPaymentSupplierDate = invPaymentSupplierDate;
    }

    @Column(name = "inv_paymentsuppliercreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvPaymentSupplierCreationDate() {
        return invPaymentSupplierCreationDate;
    }

    public void setInvPaymentSupplierCreationDate(Date invPaymentSupplierCreationDate) {
        this.invPaymentSupplierCreationDate = invPaymentSupplierCreationDate;
    }

    @Column(name = "inv_paymentsupplierupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getInvPaymentSupplierUpdateDate() {
        return invPaymentSupplierUpdateDate;
    }

    public void setInvPaymentSupplierUpdateDate(Date invPaymentSupplierUpdateDate) {
        this.invPaymentSupplierUpdateDate = invPaymentSupplierUpdateDate;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_paymentsuppliersupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_paymentsuppliertypeid")
    public PrmPaymentType getPrmPaymentType() {
        return prmPaymentType;
    }

    public void setPrmPaymentType(PrmPaymentType prmPaymentType) {
        this.prmPaymentType = prmPaymentType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_paymentsupplierinvoiceid")
    public InvSupplierInvoice getInvSupplierInvoice() {
        return invSupplierInvoice;
    }

    public void setInvSupplierInvoice(InvSupplierInvoice invSupplierInvoice) {
        this.invSupplierInvoice = invSupplierInvoice;
    }

    @Column(name = "inv_paymentsupplieramount")
    public BigDecimal getInvPaymentSupplierAmount() {
        return invPaymentSupplierAmount;
    }

    public void setInvPaymentSupplierAmount(BigDecimal invPaymentSupplierAmount) {
        this.invPaymentSupplierAmount = invPaymentSupplierAmount;
    }
    @Column(name="inv_paymentsuppliernumber")
    public String getInvPaymentSupplierNumber() {
        return invPaymentSupplierNumber;
    }

    public void setInvPaymentSupplierNumber(String invPaymentSupplierNumber) {
        this.invPaymentSupplierNumber = invPaymentSupplierNumber;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inv_paymentsupplierassetsupplierid")
    public RcpAssetSupplier getRcpAssetSupplier() {
        return rcpAssetSupplier;
    }

    public void setRcpAssetSupplier(RcpAssetSupplier rcpAssetSupplier) {
        this.rcpAssetSupplier = rcpAssetSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inv_paymentsuppliercurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inv_paymentsuppliervatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }
}
