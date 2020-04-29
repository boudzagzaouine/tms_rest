package com.bagile.tms.entities;

import com.bagile.tms.dto.InsuranceType;
import org.springframework.cache.interceptor.CacheAspectSupport;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_vehiclecategory")
public class TmsVehicleCategory  extends EmsEntity {

    private long tmsVehicleCategoryId;
    private String tmsVehicleCategoryCode;
    private  String tmsVehicleCategoryConsumption;
    private BigDecimal tmsVehicleCategoryLength;
    private  BigDecimal tmsVehicleCategoryWidth;
    private BigDecimal tmsVehicleCategoriyheight;
    private BigDecimal tmsVehicleCategoryDepth;
    private BigDecimal tmsVehicleCategoryTonnage;
    private  BigDecimal tmsVehicleCategoryEmptyWeight;
    private BigDecimal tmsVehicleCategoryTotalWeight;



    public TmsVehicleCategory() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicle_category_id", allocationSize = 1)
    @Column(name = "tms_vehiclecategoryid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehicleCategoryId() {
        return tmsVehicleCategoryId;
    }

    public void setTmsVehicleCategoryId(long tmsVehicleCategoryId) {
        this.tmsVehicleCategoryId = tmsVehicleCategoryId;
    }

    @Column(name = "tms_vehiclecategorycode",  unique = true, nullable = false, length = 90)
    public String getTmsVehicleCategoryCode() {
        return tmsVehicleCategoryCode;
    }

    public void setTmsVehicleCategoryCode(String tmsVehicleCategoryCode) {
        this.tmsVehicleCategoryCode = tmsVehicleCategoryCode;
    }

    @Column(name = "tms_vehiclecategoryconsumption")
    public String getTmsVehicleCategoryConsumption() {
        return tmsVehicleCategoryConsumption;
    }

    public void setTmsVehicleCategoryConsumption(String tmsVehicleCategoryConsumption) {
        this.tmsVehicleCategoryConsumption = tmsVehicleCategoryConsumption;
    }

    @Column(name = "tms_vehiclecategorylength")
    public BigDecimal getTmsVehicleCategoryLength() {
        return tmsVehicleCategoryLength;
    }

    public void setTmsVehicleCategoryLength(BigDecimal tmsVehicleCategoryLength) {
        this.tmsVehicleCategoryLength = tmsVehicleCategoryLength;
    }




    @Column(name = "tms_vehiclecategorywidth")
    public BigDecimal getTmsVehicleCategoryWidth() {
        return tmsVehicleCategoryWidth;
    }

    public void setTmsVehicleCategoryWidth(BigDecimal tmsVehicleCategoryWidth) {
        this.tmsVehicleCategoryWidth = tmsVehicleCategoryWidth;
    }
    @Column(name = "tms_vehiclecategoryheight")
    public BigDecimal getTmsVehicleCategoriyheight() {
        return tmsVehicleCategoriyheight;
    }

    public void setTmsVehicleCategoriyheight(BigDecimal tmsVehicleCategoriyheight) {
        this.tmsVehicleCategoriyheight = tmsVehicleCategoriyheight;
    }

    @Column(name = "tms_vehiclecategorydepth")
    public BigDecimal getTmsVehicleCategoryDepth() {
        return tmsVehicleCategoryDepth;
    }

    public void setTmsVehicleCategoryDepth(BigDecimal tmsVehicleCategoryDepth) {
        this.tmsVehicleCategoryDepth = tmsVehicleCategoryDepth;
    }

    @Column(name = "tms_vehiclecategorytonnage")
    public BigDecimal getTmsVehicleCategoryTonnage() {
        return tmsVehicleCategoryTonnage;
    }

    public void setTmsVehicleCategoryTonnage(BigDecimal tmsVehicleCategoryTonnage) {
        this.tmsVehicleCategoryTonnage = tmsVehicleCategoryTonnage;
    }

    @Column(name = "tms_vehiclecategoryemptyweight")
    public BigDecimal getTmsVehicleCategoryEmptyWeight() {
        return tmsVehicleCategoryEmptyWeight;
    }

    public void setTmsVehicleCategoryEmptyWeight(BigDecimal tmsVehicleCategoryEmptyWeight) {
        this.tmsVehicleCategoryEmptyWeight = tmsVehicleCategoryEmptyWeight;
    }

    @Column(name = "tms_vehiclecategorytotalweight")
    public BigDecimal getTmsVehicleCategoryTotalWeight() {
        return tmsVehicleCategoryTotalWeight;
    }

    public void setTmsVehicleCategoryTotalWeight(BigDecimal tmsVehicleCategoryTotalWeight) {
        this.tmsVehicleCategoryTotalWeight = tmsVehicleCategoryTotalWeight;
    }



}
