package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 19/04/2017.
 */
public class TourSaleOrderStock {
    private Long id;
    private String product;
    private BigDecimal servedQuantity;
    private BigDecimal weight;
    private String  lot;
    private String dimension;
    private String serialNo;
    private String quality;
    private Date dlc;
    private Date dluo;
    private String container;
    private String uom;
    private Long StockId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public Date getDlc() {
        return dlc;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public Date getDluo() {
        return dluo;
    }

    public void setDluo(Date dluo) {
        this.dluo = dluo;

    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Long getStockId() {
        return StockId;
    }

    public void setStockId(Long stockId) {
        StockId = stockId;
    }

}
