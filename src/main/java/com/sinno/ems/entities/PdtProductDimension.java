package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 14/03/2017.
 */
@Entity
@Table(name = "pdt_productdimension")
public class PdtProductDimension {
    private long pdtProductDimensionId;
    private BigDecimal pdtProductDimensionHeight;
    private BigDecimal pdtProductDimensionDepth;
    private BigDecimal pdtProductDimensionWidth;
    @NotNull
    private PdtProduct pdtProduct;
    private BigDecimal pdtProductDimensionPrice;
    private Date pdtProductDimensionCreationDate;
    private Date pdtProductDimensionUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_productdimension", allocationSize = 1)
    @Column(name = "pdt_productdimensionid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtProductDimensionId() {
        return pdtProductDimensionId;
    }

    public void setPdtProductDimensionId(long pdtProductDimensionId) {
        this.pdtProductDimensionId = pdtProductDimensionId;
    }

    @Column(name = "pdt_productdimensionheight")
    public BigDecimal getPdtProductDimensionHeight() {
        return pdtProductDimensionHeight;
    }

    public void setPdtProductDimensionHeight(BigDecimal pdtProductDimensionHeight) {
        this.pdtProductDimensionHeight = pdtProductDimensionHeight;
    }

    @Column(name = "pdt_productdimensiondepth")
    public BigDecimal getPdtProductDimensionDepth() {
        return pdtProductDimensionDepth;
    }

    public void setPdtProductDimensionDepth(BigDecimal pdtProductDimensionDepth) {
        this.pdtProductDimensionDepth = pdtProductDimensionDepth;
    }

    @Column(name = "pdt_productdimensionwidth")
    public BigDecimal getPdtProductDimensionWidth() {
        return pdtProductDimensionWidth;
    }

    public void setPdtProductDimensionWidth(BigDecimal pdtProductDimensionWidth) {
        this.pdtProductDimensionWidth = pdtProductDimensionWidth;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pdt_productdimensionproductid",nullable = false)
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @Column(name = "pdt_productdimensionprice")
    public BigDecimal getPdtProductDimensionPrice() {
        return pdtProductDimensionPrice;
    }

    public void setPdtProductDimensionPrice(BigDecimal pdtProductDimensionPrice) {
        this.pdtProductDimensionPrice = pdtProductDimensionPrice;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_productdimensioncreationdate")
    public Date getPdtProductDimensionCreationDate() {
        return pdtProductDimensionCreationDate;
    }

    public void setPdtProductDimensionCreationDate(Date pdtProductDimensionCreationDate) {
        this.pdtProductDimensionCreationDate = pdtProductDimensionCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_productdimensionupdatedate")
    public Date getPdtProductDimensionUpdateDate() {
        return pdtProductDimensionUpdateDate;
    }

    public void setPdtProductDimensionUpdateDate(Date pdtProductDimensionUpdateDate) {
        this.pdtProductDimensionUpdateDate = pdtProductDimensionUpdateDate;
    }
}
