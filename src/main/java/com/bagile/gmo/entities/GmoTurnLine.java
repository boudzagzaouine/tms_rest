package com.bagile.gmo.entities;


import javax.persistence.*;

import com.bagile.gmo.dto.EmsDto;

import java.io.Serializable;
import java.math.BigDecimal;





@Entity
@Table(name = "gmo_turnline")
public class GmoTurnLine extends EmsDto implements Serializable  {


    private long gmoTurnLineeId;
   // private OwnOwner ownOwner;
    private String gmoTurnLineDescription;
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
    private BigDecimal  gmoTurnLineQuantityServed;
    private BigDecimal gmoTurnLineSalePrice;
    private PrmVat prmVat;
    private BigDecimal gmoTurnLineTotalPriceHT;
    private BigDecimal gmoTurnLineTotalPriceTTC;
    private PdtProductPack pdtProductPack;
    private CmdSaleOrderLine cmdSaleOrderLine;
    private GmoTurn gmoTurn ;
    private CmdSaleOrder cmdSaleOrder;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_turnline", allocationSize = 1)
    @Column(name = "gmo_turnlineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoTurnLineeId() {
        return gmoTurnLineeId;
    }

    public void setGmoTurnLineeId(long gmoTurnLineeId) {
        this.gmoTurnLineeId = gmoTurnLineeId;
    }


  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlineuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlinevatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "gmo_turnlineserved")
    public BigDecimal getGmoTurnLineQuantityServed() {
        return gmoTurnLineQuantityServed;
    }

    public void setGmoTurnLineQuantityServed(BigDecimal gmoTurnLineQuantityServed) {
        this.gmoTurnLineQuantityServed = gmoTurnLineQuantityServed;
    }

    @Column(name = "gmo_turnlinedescription")
    public String getGmoTurnLineDescription() {
        return gmoTurnLineDescription;
    }

    public void setGmoTurnLineDescription(String gmoTurnLineDescription) {
        this.gmoTurnLineDescription = gmoTurnLineDescription;
    }

    @Column(name = "gmo_turnlinesaleprice")
    public BigDecimal getGmoTurnLineSalePrice() {
        return gmoTurnLineSalePrice;
    }

    public void setGmoTurnLineSalePrice(BigDecimal gmoTurnLineSalePrice) {
        this.gmoTurnLineSalePrice = gmoTurnLineSalePrice;
    }

    @Column(name = "gmo_turnlinetotalpriceht")
    public BigDecimal getGmoTurnLineTotalPriceHT() {
        return gmoTurnLineTotalPriceHT;
    }

    public void setGmoTurnLineTotalPriceHT(BigDecimal gmoTurnLineTotalPriceHT) {
        this.gmoTurnLineTotalPriceHT = gmoTurnLineTotalPriceHT;
    }


    @Column(name = "gmo_turnlinetotalpricettc")
    public BigDecimal getGmoTurnLineTotalPriceTTC() {
        return gmoTurnLineTotalPriceTTC;
    }

    public void setGmoTurnLineTotalPriceTTC(BigDecimal gmoTurnLineTotalPriceTTC) {
        this.gmoTurnLineTotalPriceTTC = gmoTurnLineTotalPriceTTC;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlinepackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlinesaleorderlineid")
    public CmdSaleOrderLine getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLine cmdSaleOrderLine) {
        this.cmdSaleOrderLine = cmdSaleOrderLine;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_turnlineturnid")
    public GmoTurn getGmoTurn() {
        return gmoTurn;
    }

    public void setGmoTurn(GmoTurn gmoTurn) {
        this.gmoTurn = gmoTurn;
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

