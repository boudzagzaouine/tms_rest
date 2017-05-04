package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Enissay on 24/01/2017.
 */
@Entity
@Table(name = "pmt_promotion")
public class PmtPromotion {
    private long pmtPromotionId;
    @NotNull
    private PdtProduct pdtProduct;
    @NotNull
    private BigDecimal pmtPromotionQuantity;
    @NotNull
    private BigDecimal pmtPromotionPrice;
    @NotNull
    private RcpSupplier rcpSupplier;
    @NotNull
    private PrmCurrency prmCurrency;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pmt_promotion", allocationSize = 1)
    @Column(name = "pmt_promotionid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPmtPromotionId() {
        return pmtPromotionId;
    }

    public void setPmtPromotionId(long pmtPromotionId) {
        this.pmtPromotionId = pmtPromotionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pmt_promotionproductid",nullable = false)

    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @Column(name = "pmt_promotionquantity",nullable = false)
    public BigDecimal getPmtPromotionQuantity() {
        return pmtPromotionQuantity;
    }

    public void setPmtPromotionQuantity(BigDecimal pmtPromotionQuantity) {
        this.pmtPromotionQuantity = pmtPromotionQuantity;
    }

    @Column(name = "pmt_promotionprice",nullable = false)

    public BigDecimal getPmtPromotionPrice() {
        return pmtPromotionPrice;
    }

    public void setPmtPromotionPrice(BigDecimal pmtPromotionPrice) {
        this.pmtPromotionPrice = pmtPromotionPrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pmt_promotionsupplierid",nullable = false)
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pmt_promotioncurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
}
