package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

/**
 * Created by Enissay on 03/04/2017.
 */
@Entity
@Table(name = "prc_productionline")
public class PrcProductionLine {
    private long prcProductionLineId;
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
    private BigDecimal prcProductionLineQuantity;
    private PrcProduction prcProduction;
    @Max(999999999)
    private BigDecimal prcProductionLineTotalPriceHT;
    @Max(999999999)
    private BigDecimal prcProductionLineTotalPriceTTC;
    private PrmVat prmVat;
    @Max(999999999)
    private BigDecimal prcProductionLineDiscount;
    @Max(999999999)
    private BigDecimal prcProductionLinePrice;
    private BigDecimal prcProductionLineProducedQuantity;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prc_productionline", allocationSize = 1)
    @Column(name = "prc_productionlineid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrcProductionLineId() {
        return prcProductionLineId;
    }

    public void setPrcProductionLineId(long prcProductionLineId) {
        this.prcProductionLineId = prcProductionLineId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionlineproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionlineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }
    @Column(name = "prc_productionlinequantity")
    public BigDecimal getPrcProductionLineQuantity() {
        return prcProductionLineQuantity;
    }

    public void setPrcProductionLineQuantity(BigDecimal prcProductionLineQuantity) {
        this.prcProductionLineQuantity = prcProductionLineQuantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionlineproductionid")
    public PrcProduction getPrcProduction() {
        return prcProduction;
    }

    public void setPrcProduction(PrcProduction prcProduction) {
        this.prcProduction = prcProduction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionlinevatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "prc_productionlinetotalpriceht")
    public BigDecimal getPrcProductionLineTotalPriceHT() {
        return prcProductionLineTotalPriceHT;
    }

    public void setPrcProductionLineTotalPriceHT(BigDecimal prcProductionLineTotalPriceHT) {
        this.prcProductionLineTotalPriceHT = prcProductionLineTotalPriceHT;
    }
    @Column(name = "prc_productionlinetotalpricettc")
    public BigDecimal getPrcProductionLineTotalPriceTTC() {
        return prcProductionLineTotalPriceTTC;
    }

    public void setPrcProductionLineTotalPriceTTC(BigDecimal prcProductionLineTotalPriceTTC) {
        this.prcProductionLineTotalPriceTTC = prcProductionLineTotalPriceTTC;
    }
    @Column(name = "prc_productionlinediscount")
    public BigDecimal getPrcProductionLineDiscount() {
        return prcProductionLineDiscount;
    }

    public void setPrcProductionLineDiscount(BigDecimal prcProductionLineDiscount) {
        this.prcProductionLineDiscount = prcProductionLineDiscount;
    }

    @Column(name = "prc_productionlinepurshaseprice")
    public BigDecimal getPrcProductionLinePrice() {
        return prcProductionLinePrice;
    }

    public void setPrcProductionLinePrice(BigDecimal prcProductionLinePrice) {
        this.prcProductionLinePrice = prcProductionLinePrice;
    }
    @Column(name="prc_productionlineproducedquantity")
    public BigDecimal getPrcProductionLineProducedQuantity() {
        return prcProductionLineProducedQuantity;
    }

    public void setPrcProductionLineProducedQuantity(BigDecimal prcProductionLineProducedQuantity) {
        this.prcProductionLineProducedQuantity = prcProductionLineProducedQuantity;
    }
}
