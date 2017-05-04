package com.sinno.ems.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Enissay on 24/01/2017.
 */
@Entity
@Table(name="pdt_productsupplier")
public class PdtProductSupplier {
    private long pdtProductSupplierId;
    private PdtProduct pdtProduct;
    private RcpSupplier rcpSupplier;
    private BigDecimal pdtProductSupplierPrice;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_product_supplier", allocationSize = 1)
    @Column(name = "pdt_productsupplierid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtProductSupplierId() {
        return pdtProductSupplierId;
    }

    public void setPdtProductSupplierId(long pdtProductSupplierId) {
        this.pdtProductSupplierId = pdtProductSupplierId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productsupplierproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productsuppliersupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }
    @Column(name = "pdt_productsupplierprice")
    public BigDecimal getPdtProductSupplierPrice() {
        return pdtProductSupplierPrice;
    }

    public void setPdtProductSupplierPrice(BigDecimal pdtProductSupplierPrice) {
        this.pdtProductSupplierPrice = pdtProductSupplierPrice;
    }
}
