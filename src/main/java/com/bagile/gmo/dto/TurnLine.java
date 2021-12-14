package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TurnLine extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8747248049547537558L;

    private long id;
   // private Owner owner;

    private String description;
    private Product product;
    private BigDecimal quantityServed;
    private BigDecimal salePrice;
    private Uom uom;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private Vat vat;
    private ProductPack productPack;
    private TurnSoPo turnSoPo;
    private SaleOrderLine saleOrderLine;
    private PurshaseOrderLine purshaseOrderLine;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

   /* public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }*/


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantityServed() {
        return quantityServed;
    }

    public void setQuantityServed(BigDecimal quantityServed) {
        this.quantityServed = quantityServed;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public ProductPack getProductPack() {
        return productPack;
    }

    public void setProductPack(ProductPack productPack) {
        this.productPack = productPack;
    }

    public SaleOrderLine getSaleOrderLine() {
        return saleOrderLine;
    }

    public void setSaleOrderLine(SaleOrderLine saleOrderLine) {
        this.saleOrderLine = saleOrderLine;
    }

    public TurnSoPo getTurnSoPo() {
        return turnSoPo;
    }

    public void setTurnSoPo(TurnSoPo turnSoPo) {
        this.turnSoPo = turnSoPo;
    }

    public PurshaseOrderLine getPurshaseOrderLine() {
        return purshaseOrderLine;
    }

    public void setPurshaseOrderLine(PurshaseOrderLine purshaseOrderLine) {
        this.purshaseOrderLine = purshaseOrderLine;
    }
}