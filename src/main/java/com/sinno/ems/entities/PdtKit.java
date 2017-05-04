package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by adadi on 12/30/2015.
 */
@Entity
@Table(name = "pdt_kit")
public class PdtKit implements Serializable {

    private long pdtKitId;
    @NotNull
    private PdtProduct pdtProduct;
    @NotNull
    private PdtProduct pdtKitComponent;

    @Max(999999999)
    @NotNull
    private BigDecimal pdtKitQuantity;
    @NotNull
    private PdtUom pdtUom;
    @NotNull
    private PdtUom pdtKitComponentUom;

    @Max(999999999)
    private Long pdtKitVersion;
    @Max(999999999)
    private BigDecimal pdtKitMarginFalling;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_kit", allocationSize = 1)
    @Column(name = "pdt_kitid", unique = true)
    public long getPdtKitId() {
        return pdtKitId;
    }

    public void setPdtKitId(long pdtKitId) {
        this.pdtKitId = pdtKitId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_kitproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_kitcomponentid")
    public PdtProduct getPdtKitComponent() {
        return pdtKitComponent;
    }

    public void setPdtKitComponent(PdtProduct pdtKitComponent) {
        this.pdtKitComponent = pdtKitComponent;
    }

    @Column(name = "pdt_kitquantity")
    public BigDecimal getPdtKitQuantity() {
        return pdtKitQuantity;
    }

    public void setPdtKitQuantity(BigDecimal pdtKitQuantity) {
        this.pdtKitQuantity = pdtKitQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_kituomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_kitcomponentuomid")
    public PdtUom getPdtKitComponentUom() {
        return pdtKitComponentUom;
    }

    public void setPdtKitComponentUom(PdtUom pdtKitComponentUom) {
        this.pdtKitComponentUom = pdtKitComponentUom;
    }

    @Column(name = "pdt_kitversion")
    public Long getPdtKitVersion() {
        return pdtKitVersion;
    }

    public void setPdtKitVersion(Long pdtKitVersion) {
        this.pdtKitVersion = pdtKitVersion;
    }

    @Column(name = "pdt_kitmarginfalling", precision = 12, scale = 5)
    public BigDecimal getPdtKitMarginFalling() {
        return pdtKitMarginFalling;
    }

    public void setPdtKitMarginFalling(BigDecimal pdtKitMarginFalling) {
        this.pdtKitMarginFalling = pdtKitMarginFalling;
    }
}
