package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Uom implements Serializable {

    private static final long serialVersionUID = -8406204934400528949L;

    private long id;
    private Owner owner;
    private String code;
    private String description;
    private Date updateDate;
    private Date creationDate;
    private Set<StockReserved> stockReserveds;
    private Set<Stock> stocks;
    private Set<StockArc> stockArcs;
    private Set<ReceptionLine> receptionLines;
    private Set<ReceptionLineArc> receptionLineArcs;
    private Set<PurshaseOrderLineArc> purshaseOrderLineArcs;
    private Set<SaleOrderStockArc> saleOrderStockArcs;
    private Set<SaleOrderLineArc> saleOrderLineArcs;
    private Set<SaleOrderLine> saleOrderLines;
    private Set<ProductPack> productPacks;
    private Set<PurshaseOrderLine> purshaseOrderLines;
    private Set<SaleOrderStock> saleOrderStocks;
    private Set<Product> productsForProductUomPurshase;
    private Set<Product> productsForProductUomSale;
    private Set<Product> productsForProductUomBase;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Set<StockArc> getStockArcs() {
        return stockArcs;
    }

    public void setStockArcs(Set<StockArc> stockArcs) {
        this.stockArcs = stockArcs;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<StockReserved> getStockReserveds() {
        return stockReserveds;
    }

    public void setStockReserveds(Set<StockReserved> stockReserveds) {
        this.stockReserveds = stockReserveds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ReceptionLine> getReceptionLines() {
        return receptionLines;
    }

    public void setReceptionLines(Set<ReceptionLine> receptionLines) {
        this.receptionLines = receptionLines;
    }

    public Set<ReceptionLineArc> getReceptionLineArcs() {
        return receptionLineArcs;
    }

    public void setReceptionLineArcs(Set<ReceptionLineArc> receptionLineArcs) {
        this.receptionLineArcs = receptionLineArcs;
    }

    public Set<PurshaseOrderLineArc> getPurshaseOrderLineArcs() {
        return purshaseOrderLineArcs;
    }

    public void setPurshaseOrderLineArcs(Set<PurshaseOrderLineArc> purshaseOrderLineArcs) {
        this.purshaseOrderLineArcs = purshaseOrderLineArcs;
    }

    public Set<SaleOrderStockArc> getSaleOrderStockArcs() {
        return saleOrderStockArcs;
    }

    public void setSaleOrderStockArcs(Set<SaleOrderStockArc> saleOrderStockArcs) {
        this.saleOrderStockArcs = saleOrderStockArcs;
    }

    public Set<SaleOrderLineArc> getSaleOrderLineArcs() {
        return saleOrderLineArcs;
    }

    public void setSaleOrderLineArcs(Set<SaleOrderLineArc> saleOrderLineArcs) {
        this.saleOrderLineArcs = saleOrderLineArcs;
    }

    public Set<SaleOrderLine> getSaleOrderLines() {
        return saleOrderLines;
    }

    public void setSaleOrderLines(Set<SaleOrderLine> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }

    public Set<ProductPack> getProductPacks() {
        return productPacks;
    }

    public void setProductPacks(Set<ProductPack> productPacks) {
        this.productPacks = productPacks;
    }

    public Set<PurshaseOrderLine> getPurshaseOrderLines() {
        return purshaseOrderLines;
    }

    public void setPurshaseOrderLines(Set<PurshaseOrderLine> purshaseOrderLines) {
        this.purshaseOrderLines = purshaseOrderLines;
    }

    public Set<SaleOrderStock> getSaleOrderStocks() {
        return saleOrderStocks;
    }

    public void setSaleOrderStocks(Set<SaleOrderStock> saleOrderStocks) {
        this.saleOrderStocks = saleOrderStocks;
    }

    public Set<Product> getProductsForProductUomPurshase() {
        return productsForProductUomPurshase;
    }

    public void setProductsForProductUomPurshase(Set<Product> productsForProductUomPurshase) {
        this.productsForProductUomPurshase = productsForProductUomPurshase;
    }

    public Set<Product> getProductsForProductUomSale() {
        return productsForProductUomSale;
    }

    public void setProductsForProductUomSale(Set<Product> productsForProductUomSale) {
        this.productsForProductUomSale = productsForProductUomSale;
    }

    public Set<Product> getProductsForProductUomBase() {
        return productsForProductUomBase;
    }

    public void setProductsForProductUomBase(Set<Product> productsForProductUomBase) {
        this.productsForProductUomBase = productsForProductUomBase;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Uom obj = (Uom) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }
}