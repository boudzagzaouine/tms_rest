package com.bagile.gmo.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gmo_vehiclecategory")
public class GmoVehicleCategory  extends EmsEntity {


	private static final long serialVersionUID = 7061065493531979221L;

	private long gmoVehicleCategoryId;
    private String gmoVehicleCategoryCode;
    private  String gmoVehicleCategoryConsumption;
    private BigDecimal gmoVehicleCategoryLength;
    private  BigDecimal gmoVehicleCategoryWidth;
    private BigDecimal gmoVehicleCategoriyheight;
    private BigDecimal gmoVehicleCategoryDepth;
    private BigDecimal gmoVehicleCategoryTonnage;
    private  BigDecimal gmoVehicleCategoryEmptyWeight;
    private BigDecimal gmoVehicleCategoryTotalWeight;



    public GmoVehicleCategory() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehicle_category_id", allocationSize = 1)
    @Column(name = "gmo_vehiclecategoryid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoVehicleCategoryId() {
        return gmoVehicleCategoryId;
    }

    public void setGmoVehicleCategoryId(long gmoVehicleCategoryId) {
        this.gmoVehicleCategoryId = gmoVehicleCategoryId;
    }

    @Column(name = "gmo_vehiclecategorycode",  unique = true, nullable = false, length = 90)
    public String getGmoVehicleCategoryCode() {
        return gmoVehicleCategoryCode;
    }

    public void setGmoVehicleCategoryCode(String gmoVehicleCategoryCode) {
        this.gmoVehicleCategoryCode = gmoVehicleCategoryCode;
    }

    @Column(name = "gmo_vehiclecategoryconsumption")
    public String getGmoVehicleCategoryConsumption() {
        return gmoVehicleCategoryConsumption;
    }

    public void setGmoVehicleCategoryConsumption(String gmoVehicleCategoryConsumption) {
        this.gmoVehicleCategoryConsumption = gmoVehicleCategoryConsumption;
    }

    @Column(name = "gmo_vehiclecategorylength")
    public BigDecimal getGmoVehicleCategoryLength() {
        return gmoVehicleCategoryLength;
    }

    public void setGmoVehicleCategoryLength(BigDecimal gmoVehicleCategoryLength) {
        this.gmoVehicleCategoryLength = gmoVehicleCategoryLength;
    }




    @Column(name = "gmo_vehiclecategorywidth")
    public BigDecimal getGmoVehicleCategoryWidth() {
        return gmoVehicleCategoryWidth;
    }

    public void setGmoVehicleCategoryWidth(BigDecimal gmoVehicleCategoryWidth) {
        this.gmoVehicleCategoryWidth = gmoVehicleCategoryWidth;
    }
    @Column(name = "gmo_vehiclecategoryheight")
    public BigDecimal getGmoVehicleCategoriyheight() {
        return gmoVehicleCategoriyheight;
    }

    public void setGmoVehicleCategoriyheight(BigDecimal gmoVehicleCategoriyheight) {
        this.gmoVehicleCategoriyheight = gmoVehicleCategoriyheight;
    }

    @Column(name = "gmo_vehiclecategorydepth")
    public BigDecimal getGmoVehicleCategoryDepth() {
        return gmoVehicleCategoryDepth;
    }

    public void setGmoVehicleCategoryDepth(BigDecimal gmoVehicleCategoryDepth) {
        this.gmoVehicleCategoryDepth = gmoVehicleCategoryDepth;
    }

    @Column(name = "gmo_vehiclecategorytonnage")
    public BigDecimal getGmoVehicleCategoryTonnage() {
        return gmoVehicleCategoryTonnage;
    }

    public void setGmoVehicleCategoryTonnage(BigDecimal gmoVehicleCategoryTonnage) {
        this.gmoVehicleCategoryTonnage = gmoVehicleCategoryTonnage;
    }

    @Column(name = "gmo_vehiclecategoryemptyweight")
    public BigDecimal getGmoVehicleCategoryEmptyWeight() {
        return gmoVehicleCategoryEmptyWeight;
    }

    public void setGmoVehicleCategoryEmptyWeight(BigDecimal gmoVehicleCategoryEmptyWeight) {
        this.gmoVehicleCategoryEmptyWeight = gmoVehicleCategoryEmptyWeight;
    }

    @Column(name = "gmo_vehiclecategorytotalweight")
    public BigDecimal getGmoVehicleCategoryTotalWeight() {
        return gmoVehicleCategoryTotalWeight;
    }

    public void setGmoVehicleCategoryTotalWeight(BigDecimal gmoVehicleCategoryTotalWeight) {
        this.gmoVehicleCategoryTotalWeight = gmoVehicleCategoryTotalWeight;
    }



}
