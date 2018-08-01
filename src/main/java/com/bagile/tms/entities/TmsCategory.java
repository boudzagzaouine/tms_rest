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
    private DoorType tmsCategoryDoor;
    private BigDecimal tmsCategoryDepth;
    private BigDecimal tmsCategoryTonnage;
    private BigDecimal tmsCategoryEmptyWeight;
    private BigDecimal tmsCategoryTotalWeight;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_categoryId", unique = true, nullable = false, precision = 10, scale = 0)


    public long getTmsCategoryId() {
        return tmsCategoryId;
    }

    public void setTmsCategoryId(int tmsCategoryId) {
        this.tmsCategoryId = tmsCategoryId;
    }


    @Column(name = "tms_categorycunsumption", nullable = false, length = 30)
    public BigDecimal getTmsCategoryConsumption() {
        return tmsCategoryConsumption;
    }

    public void setTmsCategoryConsumption(BigDecimal tmsCategoryConsumption) {
        this.tmsCategoryConsumption = tmsCategoryConsumption;
    }

    @Column(name = "tms_categoryweight", nullable = false, length = 30)
    public BigDecimal getTmsCategoryWeight() {
        return tmsCategoryWeight;
    }

    public void setTmsCategoryWeight(BigDecimal tmsCategoryWeight) {
        this.tmsCategoryWeight = tmsCategoryWeight;
    }


    @Column(name = "tms_categorywidth", nullable = false, length = 30)
    public BigDecimal getTmsCategoryWidth() {
        return tmsCategoryWidth;
    }

    public void setTmsCategoryWidth(BigDecimal tmsCategoryWidth) {
        this.tmsCategoryWidth = tmsCategoryWidth;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @Column(name = "tms_categorydoor", nullable = false, length = 30)
    public DoorType getTmsCategoryDoor() {
        return tmsCategoryDoor;
    }

    public void setTmsCategoryDoor(DoorType tmsCategoryDoor) {
        this.tmsCategoryDoor = tmsCategoryDoor;
    }

    @Column(name = "tms_categorydepth", nullable = false, length = 30)
    public BigDecimal getTmsCategoryDepth() {
        return tmsCategoryDepth;
    }

    public void setTmsCategoryDepth(BigDecimal tmsCategoryDepth) {
        this.tmsCategoryDepth = tmsCategoryDepth;
    }

    @Column(name = "tms_categorytonnage", nullable = false, length = 30)
    public BigDecimal getTmsCategoryTonnage() {
        return tmsCategoryTonnage;
    }

    public void setTmsCategoryTonnage(BigDecimal tmsCategoryTonnage) {
        this.tmsCategoryTonnage = tmsCategoryTonnage;
    }

    @Column(name = "tms_categoryemptyweight", nullable = false, length = 30)
    public BigDecimal getTmsCategoryEmptyWeight() {
        return tmsCategoryEmptyWeight;
    }

    public void setTmsCategoryEmptyWeight(BigDecimal tmsCategoryEmptyWeight) {
        this.tmsCategoryEmptyWeight = tmsCategoryEmptyWeight;
    }

    @Column(name = "tms_categorytotalweight", nullable = false, length = 30)
    public BigDecimal getTmsCategoryTotalWeight() {
        return tmsCategoryTotalWeight;
    }

    public void setTmsCategoryTotalWeight(BigDecimal tmsCategoryTotalWeight) {
        this.tmsCategoryTotalWeight = tmsCategoryTotalWeight;
    }
}
