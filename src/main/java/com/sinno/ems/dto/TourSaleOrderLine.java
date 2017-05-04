package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Enissay on 19/04/2017.
 */
public class TourSaleOrderLine {
    private Long lineNumber;
    private String product;
    private BigDecimal orderedQuantity;
    private BigDecimal servedQuantity;
    private Date dlc;
    private Date dluo;
    private BigDecimal weight;
    private String lot;
    private String dimension;
    private String serialNo;
    private String quality;
    private BigDecimal blockedQuantity;
    private String blockType;
    private String container;
    private BigDecimal salePrice;
    private BigDecimal vat;
    private BigDecimal priceHt;
    private BigDecimal priceTtc;
    private BigDecimal discount;
    private String uom;
    private List<TourSaleOrderStock> tourSaleOrderStocks;

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public BigDecimal getServedQuantity() {
        return servedQuantity;
    }

    public void setServedQuantity(BigDecimal servedQuantity) {
        this.servedQuantity = servedQuantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public BigDecimal getBlockedQuantity() {
        return blockedQuantity;
    }

    public void setBlockedQuantity(BigDecimal blockedQuantity) {
        this.blockedQuantity = blockedQuantity;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getPriceHt() {
        return priceHt;
    }

    public void setPriceHt(BigDecimal priceHt) {
        this.priceHt = priceHt;
    }

    public BigDecimal getPriceTtc() {
        return priceTtc;
    }

    public void setPriceTtc(BigDecimal priceTtc) {
        this.priceTtc = priceTtc;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Date getDlc() {
        return dlc;
    }

    public Date getDluo() {
        return dluo;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public void setDluo(Date dluo) {
        this.dluo = dluo;
    }

    public List<TourSaleOrderStock> getTourSaleOrderStocks() {
        return tourSaleOrderStocks;
    }

    public void setTourSaleOrderStocks(List<TourSaleOrderStock> tourSaleOrderStocks) {
        this.tourSaleOrderStocks = tourSaleOrderStocks;
    }
}
