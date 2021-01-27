package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_vehiclecategory")
public class GmoVehicleCategory  extends EmsEntity {


	private static final long serialVersionUID = 7061065493531979221L;

	private Long gmoVehicleCategoryId;
    private String gmoVehicleCategoryCode;
    private  String gmoVehicleCategoryDescription;
    private BigDecimal gmoVehicleCategoryLength;
    private  BigDecimal gmoVehicleCategoryWidth;
    private BigDecimal gmoVehicleCategoriyheight;
    private BigDecimal gmoVehicleCategoryDepth;
    private BigDecimal gmoVehicleCategoryTonnage;
    private  BigDecimal gmoVehicleCategoryEmptyWeight;
    private BigDecimal gmoVehicleCategoryTotalWeight;
  private OwnOwner ownOwner;


    public GmoVehicleCategory() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehicle_category_id", allocationSize = 1)
    @Column(name = "gmo_vehiclecategoryid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoVehicleCategoryId() {
        return gmoVehicleCategoryId;
    }

    public void setGmoVehicleCategoryId(Long gmoVehicleCategoryId) {
        this.gmoVehicleCategoryId = gmoVehicleCategoryId;
    }

    @Column(name = "gmo_vehiclecategorycode",  unique = true, nullable = false, length = 90)
    public String getGmoVehicleCategoryCode() {
        return gmoVehicleCategoryCode;
    }

    public void setGmoVehicleCategoryCode(String gmoVehicleCategoryCode) {
        this.gmoVehicleCategoryCode = gmoVehicleCategoryCode;
    }

    @Column(name = "gmo_vehiclecategorydescription")
    public String getGmoVehicleCategoryDescription() {
        return gmoVehicleCategoryDescription;
    }

    public void setGmoVehicleCategoryDescription(String gmoVehicleCategoryConsumption) {
        this.gmoVehicleCategoryDescription = gmoVehicleCategoryConsumption;
    }

    @Column(name = "gmo_vehiclecategorylength")
    public BigDecimal getGmoVehicleCategoryLength() {
        return gmoVehicleCategoryLength;
    }

    public void setGmoVehicleCategoryLength(BigDecimal gmoVehicleCategoryLength) {
        this.gmoVehicleCategoryLength = gmoVehicleCategoryLength;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
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
