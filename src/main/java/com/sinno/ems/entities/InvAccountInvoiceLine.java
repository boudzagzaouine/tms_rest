package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 05/12/2016.
 */
@Entity
@Table(name = "inv_accountinvoiceline")
public class InvAccountInvoiceLine {
    private long invAccountInvoiceLineId;
    @NotNull
    private Long invAccountInvoiceLineNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountInvoiceLineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invAccountInvoiceLineUpdateDate;
    @NotNull
    private BigDecimal invAccountInvoiceLinePriceHt;
    @NotNull
    private BigDecimal InvAccountInvoiceLinePriceTTC;
    private BigDecimal invAccountInvoiceLineDiscount;
    @NotNull
    private BigDecimal invAccountInvoiceLineQuantity;
    @NotNull
    private BigDecimal invAccountInvoiceLineTarifPrice;
    @NotNull
    private PdtProduct pdtProduct;
    @NotNull
    private PdtUom pdtUom;
    @NotNull
    private InvAccountInvoice invAccountInvoice;
    @NotNull
    private PrmVat prmVat;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_accountinvoiceline_inv_accountinvoicelineid_seq", allocationSize = 1)
    @Column(name = "inv_accountinvoicelineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getInvAccountInvoiceLineId() {
        return invAccountInvoiceLineId;
    }

    public void setInvAccountInvoiceLineId(long invAccountInvoiceLineId) {
        this.invAccountInvoiceLineId = invAccountInvoiceLineId;
    }

    @Column(name = "inv_accountinvoicelinenumber")
    public Long getInvAccountInvoiceLineNumber() {
        return invAccountInvoiceLineNumber;
    }

    public void setInvAccountInvoiceLineNumber(Long invAccountInvoiceLineNumber) {
        this.invAccountInvoiceLineNumber = invAccountInvoiceLineNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_accountinvoicelinecreationdate")
    public Date getInvAccountInvoiceLineCreationDate() {
        return invAccountInvoiceLineCreationDate;
    }

    public void setInvAccountInvoiceLineCreationDate(Date invAccountInvoiceLineCreationDate) {
        this.invAccountInvoiceLineCreationDate = invAccountInvoiceLineCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_accountinvoicelineupdatedate")
    public Date getInvAccountInvoiceLineUpdateDate() {
        return invAccountInvoiceLineUpdateDate;
    }

    public void setInvAccountInvoiceLineUpdateDate(Date invAccountInvoiceLineUpdateDate) {
        this.invAccountInvoiceLineUpdateDate = invAccountInvoiceLineUpdateDate;
    }

    @Column(name = "inv_accountinvoicelinepriceht")

    public BigDecimal getInvAccountInvoiceLinePriceHt() {
        return invAccountInvoiceLinePriceHt;
    }

    public void setInvAccountInvoiceLinePriceHt(BigDecimal invAccountInvoiceLinePriceHt) {
        this.invAccountInvoiceLinePriceHt = invAccountInvoiceLinePriceHt;
    }

    @Column(name = "inv_accountinvoicelinepricettc")

    public BigDecimal getInvAccountInvoiceLinePriceTTC() {
        return InvAccountInvoiceLinePriceTTC;
    }

    public void setInvAccountInvoiceLinePriceTTC(BigDecimal invAccountInvoiceLinePriceTTC) {
        InvAccountInvoiceLinePriceTTC = invAccountInvoiceLinePriceTTC;
    }

    @Column(name = "inv_accountinvoicelinediscount")

    public BigDecimal getInvAccountInvoiceLineDiscount() {
        return invAccountInvoiceLineDiscount;
    }

    public void setInvAccountInvoiceLineDiscount(BigDecimal invAccountInvoiceLineDiscount) {
        this.invAccountInvoiceLineDiscount = invAccountInvoiceLineDiscount;
    }

    @Column(name = "inv_accountinvoicelinequantity")
    public BigDecimal getInvAccountInvoiceLineQuantity() {
        return invAccountInvoiceLineQuantity;
    }

    public void setInvAccountInvoiceLineQuantity(BigDecimal invAccountInvoiceLineQuantity) {
        this.invAccountInvoiceLineQuantity = invAccountInvoiceLineQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoicelineproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoicelineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoicelineinvoiceid")
    public InvAccountInvoice getInvAccountInvoice() {
        return invAccountInvoice;
    }

    public void setInvAccountInvoice(InvAccountInvoice invAccountInvoice) {
        this.invAccountInvoice = invAccountInvoice;
    }

    @Column(name = "inv_accountinvoicelinetarifprice")
    public BigDecimal getInvAccountInvoiceLineTarifPrice() {
        return invAccountInvoiceLineTarifPrice;
    }

    public void setInvAccountInvoiceLineTarifPrice(BigDecimal invAccountInvoiceLineTarifPrice) {
        this.invAccountInvoiceLineTarifPrice = invAccountInvoiceLineTarifPrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_accountinvoicelinevatid")

    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }
}
