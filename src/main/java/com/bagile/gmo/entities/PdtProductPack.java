package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * PdtProductpack generated by hbm2java
 */
@Entity
@Table(name = "pdt_productpack")
public class PdtProductPack extends EmsEntity {

    private long pdtProductPackId;
   // @NotNull
    private OwnOwner ownOwner;
    private PdtAlias pdtAlias;


    @NotNull
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;

    @Max(999999999)

    private BigDecimal pdtProductPackWeight;

    @Max(999999999)

    private BigDecimal pdtProductPackSize;

    @Max(999999999)
    private BigDecimal pdtProductPackHeight;

    @Max(999999999)
    private BigDecimal pdtProductPackLenght;

    @Max(999999999)
    private BigDecimal pdtProductPackDepth;

    //TODO value 1 to EAN and 2 to code
    @Max(999999999)
    private Long pdtProductPackTypePck;
    @NotNull
    @Max(999999999)
    private BigDecimal pdtProductQuantity;

    @Max(999999999)
    private BigDecimal pdtProductPrice;


    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date pdtProductPackCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private BigDecimal pdtProductPackWidth;
    private Boolean pdtProductPackWeightControl;
    private BigDecimal pdtProductPackPickingPrice;
    private BigDecimal pdtProductPackAnotherPackQuantity;
    private PdtUom pdtUomAnotherPack;

    public PdtProductPack() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_productpack", allocationSize = 1)
    @Column(name = "pdt_productpackid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtProductPackId() {
        return this.pdtProductPackId;
    }

    public void setPdtProductPackId(long pdtProductPackId) {
        this.pdtProductPackId = pdtProductPackId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productpackownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productpackpdtid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productpackuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @Column(name = "pdt_productpackweight", precision = 12, scale = 5)
    public BigDecimal getPdtProductPackWeight() {
        return this.pdtProductPackWeight;
    }

    public void setPdtProductPackWeight(BigDecimal pdtProductPackWeight) {
        this.pdtProductPackWeight = pdtProductPackWeight;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "pdt_productpackaliasid")
    public PdtAlias getPdtAlias() {
        return this.pdtAlias;
    }

    public void setPdtAlias(PdtAlias pdtAlias) {
        this.pdtAlias = pdtAlias;
    }

    @Column(name = "pdt_productpacktypepck")
    public Long getPdtProductPackTypePck() {
        return pdtProductPackTypePck;
    }

    public void setPdtProductPackTypePck(Long pdtProductPackTypePck) {
        this.pdtProductPackTypePck = pdtProductPackTypePck;
    }

    @Column(name = "pdt_productpacksize", precision = 12, scale = 5)
    public BigDecimal getPdtProductPackSize() {
        return this.pdtProductPackSize;
    }

    public void setPdtProductPackSize(BigDecimal pdtProductPackSize) {
        this.pdtProductPackSize = pdtProductPackSize;
    }

    @Column(name = "pdt_productpackheight", precision = 12, scale = 5)
    public BigDecimal getPdtProductPackHeight() {
        return this.pdtProductPackHeight;
    }

    public void setPdtProductPackHeight(BigDecimal pdtProductPackHeight) {
        this.pdtProductPackHeight = pdtProductPackHeight;
    }

    @Column(name = "pdt_productpacklenght", precision = 12, scale = 5)
    public BigDecimal getPdtProductPackLenght() {
        return this.pdtProductPackLenght;
    }

    public void setPdtProductPackLenght(BigDecimal pdtProductPackLenght) {
        this.pdtProductPackLenght = pdtProductPackLenght;
    }

    @Column(name = "pdt_productpackdepth", precision = 12, scale = 5)
    public BigDecimal getPdtProductPackDepth() {
        return this.pdtProductPackDepth;
    }

    public void setPdtProductPackDepth(BigDecimal pdtProductPackDepth) {
        this.pdtProductPackDepth = pdtProductPackDepth;
    }

    @Column(name = "pdt_productpackprice", precision = 12, scale = 5)
    public BigDecimal getPdtProductPrice() {
        return pdtProductPrice;
    }

    public void setPdtProductPrice(BigDecimal pdtProductPrice) {
        this.pdtProductPrice = pdtProductPrice;
    }

    @Column(name = "pdt_productpackquantity", nullable = false)
    public BigDecimal getPdtProductQuantity() {
        return pdtProductQuantity;
    }

    public void setPdtProductQuantity(BigDecimal pdtProductQuantity) {
        this.pdtProductQuantity = pdtProductQuantity;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_productpackcreationdate")
    public Date getPdtProductPackCreationDate() {
        return this.pdtProductPackCreationDate;
    }

    public void setPdtProductPackCreationDate(Date pdtProductPackCreationDate) {
        this.pdtProductPackCreationDate = pdtProductPackCreationDate;
    }

    @Column(name = "pdt_productpackwidth")
    public BigDecimal getPdtProductPackWidth() {
        return pdtProductPackWidth;
    }

    public void setPdtProductPackWidth(BigDecimal pdtProductPackWidth) {
        this.pdtProductPackWidth = pdtProductPackWidth;
    }

    @Column(name = "pdt_productpackweightcontrol")

    public Boolean getPdtProductPackWeightControl() {
        return pdtProductPackWeightControl;
    }

    public void setPdtProductPackWeightControl(Boolean pdtProductPackWeightControl) {
        this.pdtProductPackWeightControl = pdtProductPackWeightControl;
    }

    @Column(name = "pdt_productpackpickingprice")
    public BigDecimal getPdtProductPackPickingPrice() {
        return pdtProductPackPickingPrice;
    }

    public void setPdtProductPackPickingPrice(BigDecimal pdtProductPackPickingPrice) {
        this.pdtProductPackPickingPrice = pdtProductPackPickingPrice;
    }

    @Column(name = "pdt_productpackanotherpackquantity")
    public BigDecimal getPdtProductPackAnotherPackQuantity() {
        return pdtProductPackAnotherPackQuantity;
    }

    public void setPdtProductPackAnotherPackQuantity(BigDecimal pdtProductPackAnotherPackQuantity) {
        this.pdtProductPackAnotherPackQuantity = pdtProductPackAnotherPackQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productpackanotherpackid")
    public PdtUom getPdtUomAnotherPack() {
        return pdtUomAnotherPack;
    }

    public void setPdtUomAnotherPack(PdtUom pdtUomAnotherPack) {
        this.pdtUomAnotherPack = pdtUomAnotherPack;
    }
}
