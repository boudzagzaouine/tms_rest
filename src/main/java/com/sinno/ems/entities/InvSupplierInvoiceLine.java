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
@Table(name = "inv_supplierinvoiceline")
public class InvSupplierInvoiceLine {
    private long invSupplierInvoiceLineId;
    @NotNull
    private Long invSupplierInvoiceLineNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierInvoiceLineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invSupplierInvoiceLineUpdateDate;
    private BigDecimal invSupplierInvoiceLinePriceHt;
    private BigDecimal InvSupplierInvoiceLinePriceTTC;
    private BigDecimal invSupplierInvoiceLineDiscount;
    private BigDecimal invSupplierInvoiceLineQuantity;
    private BigDecimal invSupplierInvoiceLineTarifPrice;
    private PrmVat prmVat;
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
    private InvSupplierInvoice invSupplierInvoice;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_supplierinvoiceline_inv_supplierinvoicelineid_seq", allocationSize = 1)
    @Column(name = "inv_supplierinvoicelineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getInvSupplierInvoiceLineId() {
        return invSupplierInvoiceLineId;
    }

    public void setInvSupplierInvoiceLineId(long invSupplierInvoiceLineId) {
        this.invSupplierInvoiceLineId = invSupplierInvoiceLineId;
    }

    @Column(name = "inv_supplierinvoicelinenumber")
    public Long getInvSupplierInvoiceLineNumber() {
        return invSupplierInvoiceLineNumber;
    }

    public void setInvSupplierInvoiceLineNumber(Long invSupplierInvoiceLineNumber) {
        this.invSupplierInvoiceLineNumber = invSupplierInvoiceLineNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoicelinecreationdate")
    public Date getInvSupplierInvoiceLineCreationDate() {
        return invSupplierInvoiceLineCreationDate;
    }

    public void setInvSupplierInvoiceLineCreationDate(Date invSupplierInvoiceLineCreationDate) {
        this.invSupplierInvoiceLineCreationDate = invSupplierInvoiceLineCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_supplierinvoicelineupdatedate")
    public Date getInvSupplierInvoiceLineUpdateDate() {
        return invSupplierInvoiceLineUpdateDate;
    }

    public void setInvSupplierInvoiceLineUpdateDate(Date invSupplierInvoiceLineUpdateDate) {
        this.invSupplierInvoiceLineUpdateDate = invSupplierInvoiceLineUpdateDate;
    }

    @Column(name = "inv_supplierinvoicelinepriceht")

    public BigDecimal getInvSupplierInvoiceLinePriceHt() {
        return invSupplierInvoiceLinePriceHt;
    }

    public void setInvSupplierInvoiceLinePriceHt(BigDecimal invSupplierInvoiceLinePriceHt) {
        this.invSupplierInvoiceLinePriceHt = invSupplierInvoiceLinePriceHt;
    }

    @Column(name = "inv_supplierinvoicelinepricettc")

    public BigDecimal getInvSupplierInvoiceLinePriceTTC() {
        return InvSupplierInvoiceLinePriceTTC;
    }

    public void setInvSupplierInvoiceLinePriceTTC(BigDecimal invSupplierInvoiceLinePriceTTC) {
        InvSupplierInvoiceLinePriceTTC = invSupplierInvoiceLinePriceTTC;
    }

    @Column(name = "inv_supplierinvoicelinediscount")

    public BigDecimal getInvSupplierInvoiceLineDiscount() {
        return invSupplierInvoiceLineDiscount;
    }

    public void setInvSupplierInvoiceLineDiscount(BigDecimal invSupplierInvoiceLineDiscount) {
        this.invSupplierInvoiceLineDiscount = invSupplierInvoiceLineDiscount;
    }

    @Column(name = "inv_supplierinvoicelinequantity")
    public BigDecimal getInvSupplierInvoiceLineQuantity() {
        return invSupplierInvoiceLineQuantity;
    }

    public void setInvSupplierInvoiceLineQuantity(BigDecimal invSupplierInvoiceLineQuantity) {
        this.invSupplierInvoiceLineQuantity = invSupplierInvoiceLineQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicelineproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicelineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_supplierinvoicelineinvoiceid")
    public InvSupplierInvoice getInvSupplierInvoice() {
        return invSupplierInvoice;
    }

    public void setInvSupplierInvoice(InvSupplierInvoice invSupplierInvoice) {
        this.invSupplierInvoice = invSupplierInvoice;
    }
    @Column(name="inv_supplierinvoicelinetarifprice")
    public BigDecimal getInvSupplierInvoiceLineTarifPrice() {
        return invSupplierInvoiceLineTarifPrice;
    }

    public void setInvSupplierInvoiceLineTarifPrice(BigDecimal invSupplierInvoiceLineTarifPrice) {
        this.invSupplierInvoiceLineTarifPrice = invSupplierInvoiceLineTarifPrice;
    }
    @JoinColumn(name="inv_supplierinvoicelinevatid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }
}
