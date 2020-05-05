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

	private static final long serialVersionUID = 8367002459707515086L;

	private long gmoVehicleCategoryId;
    private String gmoVehicleCategoryCode;
    private  String gmoVehicleCategoryConsumption;
    private BigDecimal gmoVehicleCategoryWeight;
    private  BigDecimal gmoVehicleCategoryWidth;
    private BigDecimal gmoVehicleCategoryDepth;
    private BigDecimal gmoVehicleCategoryTonnage;
    private  BigDecimal gmoVehicleCategoryEmptyWeight;
    private BigDecimal gmoVehicleCategoryTotalWeight;

    //private TmsInsuranceType gmoInsuranceType;

   // private Set<TmsTransportCategoryVehicle> gmoTransportCategoryVehicles=new HashSet<>();

    // private Set<TmsVehicle> gmoVehicles=new HashSet<>();


    public GmoVehicleCategory() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehicle_category_id", allocationSize = 1)
    @Column(name = "gmo_vehiclecategoryid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehicleCategoryId() {
        return gmoVehicleCategoryId;
    }

    public void setTmsVehicleCategoryId(long gmoVehicleCategoryId) {
        this.gmoVehicleCategoryId = gmoVehicleCategoryId;
    }

    @Column(name = "gmo_vehiclecategorycode",  unique = true, nullable = false, length = 90)
    public String getTmsVehicleCategoryCode() {
        return gmoVehicleCategoryCode;
    }

    public void setTmsVehicleCategoryCode(String gmoVehicleCategoryCode) {
        this.gmoVehicleCategoryCode = gmoVehicleCategoryCode;
    }

    @Column(name = "gmo_vehiclecategoryconsumption")
    public String getTmsVehicleCategoryConsumption() {
        return gmoVehicleCategoryConsumption;
    }

    public void setTmsVehicleCategoryConsumption(String gmoVehicleCategoryConsumption) {
        this.gmoVehicleCategoryConsumption = gmoVehicleCategoryConsumption;
    }

    @Column(name = "gmo_vehiclecategoryweight")
    public BigDecimal getTmsVehicleCategoryWeight() {
        return gmoVehicleCategoryWeight;
    }

    public void setTmsVehicleCategoryWeight(BigDecimal gmoVehicleCategoryWeight) {
        this.gmoVehicleCategoryWeight = gmoVehicleCategoryWeight;
    }

    @Column(name = "gmo_vehiclecategorywidth")
    public BigDecimal getTmsVehicleCategoryWidth() {
        return gmoVehicleCategoryWidth;
    }

    public void setTmsVehicleCategoryWidth(BigDecimal gmoVehicleCategoryWidth) {
        this.gmoVehicleCategoryWidth = gmoVehicleCategoryWidth;
    }

    @Column(name = "gmo_vehiclecategorydepth")
    public BigDecimal getTmsVehicleCategoryDepth() {
        return gmoVehicleCategoryDepth;
    }

    public void setTmsVehicleCategoryDepth(BigDecimal gmoVehicleCategoryDepth) {
        this.gmoVehicleCategoryDepth = gmoVehicleCategoryDepth;
    }

    @Column(name = "gmo_vehiclecategorytonnage")
    public BigDecimal getTmsVehicleCategoryTonnage() {
        return gmoVehicleCategoryTonnage;
    }

    public void setTmsVehicleCategoryTonnage(BigDecimal gmoVehicleCategoryTonnage) {
        this.gmoVehicleCategoryTonnage = gmoVehicleCategoryTonnage;
    }

    @Column(name = "gmo_vehiclecategoryemptyweight")
    public BigDecimal getTmsVehicleCategoryEmptyWeight() {
        return gmoVehicleCategoryEmptyWeight;
    }

    public void setTmsVehicleCategoryEmptyWeight(BigDecimal gmoVehicleCategoryEmptyWeight) {
        this.gmoVehicleCategoryEmptyWeight = gmoVehicleCategoryEmptyWeight;
    }

    @Column(name = "gmo_vehiclecategorytotalweight")
    public BigDecimal getTmsVehicleCategoryTotalWeight() {
        return gmoVehicleCategoryTotalWeight;
    }

    public void setTmsVehicleCategoryTotalWeight(BigDecimal gmoVehicleCategoryTotalWeight) {
        this.gmoVehicleCategoryTotalWeight = gmoVehicleCategoryTotalWeight;
    }

//cascade =  {CascadeType.MERGE,CascadeType.PERSIST}
//    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "gmo_insurancetypeid")
//    public TmsInsuranceType getTmsInsuranceType() {
//        return gmoInsuranceType;
//    }
//    public void setTmsInsuranceType(TmsInsuranceType gmoInsuranceType) {
//        this.gmoInsuranceType = gmoInsuranceType;
//    }

    /*@OneToMany(mappedBy = "gmoVehicleCategory",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsTransportCategoryVehicle> getTmsTransportCategoryVehicles() {
        return gmoTransportCategoryVehicles;
    }

    public void setTmsTransportCategoryVehicles(Set<TmsTransportCategoryVehicle> gmoTransportCategoryVehicles) {
        this.gmoTransportCategoryVehicles = gmoTransportCategoryVehicles;
    }*/

   /* @OneToMany(mappedBy = "gmoVehicleCategory", cascade = CascadeType.ALL)
    public Set<TmsVehicle> getTmsVehicles() {
        return gmoVehicles;
    }

    public void setTmsVehicles(Set<TmsVehicle> gmoVehicles) {
        this.gmoVehicles = gmoVehicles;
    }*/

}
