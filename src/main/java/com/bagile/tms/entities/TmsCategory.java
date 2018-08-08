package com.bagile.tms.entities;

import com.bagile.tms.dto.DoorType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tms_category", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_categoryId"}))
public class TmsCategory {
    private long tmsCategoryId;
    private BigDecimal tmsCategoryConsumption;
    private BigDecimal tmsCategoryWeight;
    private BigDecimal tmsCategoryWidth;
    private TmsDoorType tmsCategoryDoor;
    private BigDecimal tmsCategoryDepth;
    private BigDecimal tmsCategoryTonnage;
    private BigDecimal tmsCategoryEmptyWeight;
    private BigDecimal tmsCategoryTotalWeight;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_categoryId")


    public long getTmsCategoryId() {
        return tmsCategoryId;
    }

    public void setTmsCategoryId(long tmsCategoryId) {
        this.tmsCategoryId = tmsCategoryId;
    }


    @Column(name = "tms_categorycunsumption")
    public BigDecimal getTmsCategoryConsumption() {
        return tmsCategoryConsumption;
    }

    public void setTmsCategoryConsumption(BigDecimal tmsCategoryConsumption) {
        this.tmsCategoryConsumption = tmsCategoryConsumption;
    }

    @Column(name = "tms_categoryweight")
    public BigDecimal getTmsCategoryWeight() {
        return tmsCategoryWeight;
    }

    public void setTmsCategoryWeight(BigDecimal tmsCategoryWeight) {
        this.tmsCategoryWeight = tmsCategoryWeight;
    }


    @Column(name = "tms_categorywidth")
    public BigDecimal getTmsCategoryWidth() {
        return tmsCategoryWidth;
    }

    public void setTmsCategoryWidth(BigDecimal tmsCategoryWidth) {
        this.tmsCategoryWidth = tmsCategoryWidth;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tms_categorydoorid")
    public TmsDoorType getTmsCategoryDoor() {
        return tmsCategoryDoor;
    }

    public void setTmsCategoryDoor(TmsDoorType tmsCategoryDoor) {
        this.tmsCategoryDoor = tmsCategoryDoor;
    }

    @Column(name = "tms_categorydepth")
    public BigDecimal getTmsCategoryDepth() {
        return tmsCategoryDepth;
    }

    public void setTmsCategoryDepth(BigDecimal tmsCategoryDepth) {
        this.tmsCategoryDepth = tmsCategoryDepth;
    }

    @Column(name = "tms_categorytonnage")
    public BigDecimal getTmsCategoryTonnage() {
        return tmsCategoryTonnage;
    }

    public void setTmsCategoryTonnage(BigDecimal tmsCategoryTonnage) {
        this.tmsCategoryTonnage = tmsCategoryTonnage;
    }

    @Column(name = "tms_categoryemptyweight")
    public BigDecimal getTmsCategoryEmptyWeight() {
        return tmsCategoryEmptyWeight;
    }

    public void setTmsCategoryEmptyWeight(BigDecimal tmsCategoryEmptyWeight) {
        this.tmsCategoryEmptyWeight = tmsCategoryEmptyWeight;
    }

    @Column(name = "tms_categorytotalweight")
    public BigDecimal getTmsCategoryTotalWeight() {
        return tmsCategoryTotalWeight;
    }

    public void setTmsCategoryTotalWeight(BigDecimal tmsCategoryTotalWeight) {
        this.tmsCategoryTotalWeight = tmsCategoryTotalWeight;
    }
}
