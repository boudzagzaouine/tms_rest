package com.sinno.ems.entities;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Enissay on 07/10/2016.
 */
@Entity
@Table(name = "ntf_product_stock ")
public class NotificationStockProduct {
    private long productId;
    private BigDecimal stockQuantity;
    private BigDecimal productThreshold;
    private String productCode;
    @Id
    @Column(name = "ntfproductstockproductid")
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Column(name = "ntfproductstockquantity")
    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Column(name = "ntfproductstockproductthreshold")
    public BigDecimal getProductThreshold() {
        return productThreshold;
    }

    public void setProductThreshold(BigDecimal productThreshold) {
        this.productThreshold = productThreshold;
    }
    @Column(name="ntfproductstockcode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
