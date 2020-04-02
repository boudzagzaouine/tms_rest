package com.bagile.tms.entities;


import com.bagile.tms.dto.EmsDto;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;





@Entity
@Table(name = "tms_turnline")
public class TmsTurnLine extends EmsDto implements Serializable  {


    private long tmsTurnLineeId;
   // private OwnOwner ownOwner;
    private String tmsTurnLineDescription;
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
    private BigDecimal  tmsTurnLineQuantityServed;
    private BigDecimal tmsTurnLineSalePrice;
    private PrmVat prmVat;
    private BigDecimal tmsTurnLineTotalPriceHT;
    private BigDecimal tmsTurnLineTotalPriceTTC;
    private PdtProductPack pdtProductPack;
    private CmdSaleOrderLine cmdSaleOrderLine;
    private TmsTurn tmsTurn ;
    private CmdSaleOrder cmdSaleOrder;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turnline", allocationSize = 1)
    @Column(name = "tms_turnlineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsTurnLineeId() {
        return tmsTurnLineeId;
    }

    public void setTmsTurnLineeId(long tmsTurnLineeId) {
        this.tmsTurnLineeId = tmsTurnLineeId;
    }


  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlineuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlinevatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "tms_turnlineserved")
    public BigDecimal getTmsTurnLineQuantityServed() {
        return tmsTurnLineQuantityServed;
    }

    public void setTmsTurnLineQuantityServed(BigDecimal tmsTurnLineQuantityServed) {
        this.tmsTurnLineQuantityServed = tmsTurnLineQuantityServed;
    }

    @Column(name = "tms_turnlinedescription")
    public String getTmsTurnLineDescription() {
        return tmsTurnLineDescription;
    }

    public void setTmsTurnLineDescription(String tmsTurnLineDescription) {
        this.tmsTurnLineDescription = tmsTurnLineDescription;
    }

    @Column(name = "tms_turnlinesaleprice")
    public BigDecimal getTmsTurnLineSalePrice() {
        return tmsTurnLineSalePrice;
    }

    public void setTmsTurnLineSalePrice(BigDecimal tmsTurnLineSalePrice) {
        this.tmsTurnLineSalePrice = tmsTurnLineSalePrice;
    }

    @Column(name = "tms_turnlinetotalpriceht")
    public BigDecimal getTmsTurnLineTotalPriceHT() {
        return tmsTurnLineTotalPriceHT;
    }

    public void setTmsTurnLineTotalPriceHT(BigDecimal tmsTurnLineTotalPriceHT) {
        this.tmsTurnLineTotalPriceHT = tmsTurnLineTotalPriceHT;
    }


    @Column(name = "tms_turnlinetotalpricettc")
    public BigDecimal getTmsTurnLineTotalPriceTTC() {
        return tmsTurnLineTotalPriceTTC;
    }

    public void setTmsTurnLineTotalPriceTTC(BigDecimal tmsTurnLineTotalPriceTTC) {
        this.tmsTurnLineTotalPriceTTC = tmsTurnLineTotalPriceTTC;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlinepackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlinesaleorderlineid")
    public CmdSaleOrderLine getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLine cmdSaleOrderLine) {
        this.cmdSaleOrderLine = cmdSaleOrderLine;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnlineturnid")
    public TmsTurn getTmsTurn() {
        return tmsTurn;
    }

    public void setTmsTurn(TmsTurn tmsTurn) {
        this.tmsTurn = tmsTurn;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_turnlinesaleorderid")
    public CmdSaleOrder getCmdSaleOrder() {
        return this.cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }

}

