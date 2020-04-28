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
    private BigDecimal tmsVehicleCategoryWeight;
    private  BigDecimal tmsVehicleCategoryWidth;
    private BigDecimal tmsVehicleCategoryDepth;
    private BigDecimal tmsVehicleCategoryTonnage;
    private  BigDecimal tmsVehicleCategoryEmptyWeight;
    private BigDecimal tmsVehicleCategoryTotalWeight;

    //private TmsInsuranceType tmsInsuranceType;

   // private Set<TmsTransportCategoryVehicle> tmsTransportCategoryVehicles=new HashSet<>();

    // private Set<TmsVehicle> tmsVehicles=new HashSet<>();


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

    @Column(name = "tms_vehiclecategoryweight")
    public BigDecimal getTmsVehicleCategoryWeight() {
        return tmsVehicleCategoryWeight;
    }

    public void setTmsVehicleCategoryWeight(BigDecimal tmsVehicleCategoryWeight) {
        this.tmsVehicleCategoryWeight = tmsVehicleCategoryWeight;
    }

    @Column(name = "tms_vehiclecategorywidth")
    public BigDecimal getTmsVehicleCategoryWidth() {
        return tmsVehicleCategoryWidth;
    }

    public void setTmsVehicleCategoryWidth(BigDecimal tmsVehicleCategoryWidth) {
        this.tmsVehicleCategoryWidth = tmsVehicleCategoryWidth;
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

//cascade =  {CascadeType.MERGE,CascadeType.PERSIST}
//    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "tms_insurancetypeid")
//    public TmsInsuranceType getTmsInsuranceType() {
//        return tmsInsuranceType;
//    }
//    public void setTmsInsuranceType(TmsInsuranceType tmsInsuranceType) {
//        this.tmsInsuranceType = tmsInsuranceType;
//    }

    /*@OneToMany(mappedBy = "tmsVehicleCategory",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsTransportCategoryVehicle> getTmsTransportCategoryVehicles() {
        return tmsTransportCategoryVehicles;
    }

    public void setTmsTransportCategoryVehicles(Set<TmsTransportCategoryVehicle> tmsTransportCategoryVehicles) {
        this.tmsTransportCategoryVehicles = tmsTransportCategoryVehicles;
    }*/

   /* @OneToMany(mappedBy = "tmsVehicleCategory", cascade = CascadeType.ALL)
    public Set<TmsVehicle> getTmsVehicles() {
        return tmsVehicles;
    }

    public void setTmsVehicles(Set<TmsVehicle> tmsVehicles) {
        this.tmsVehicles = tmsVehicles;
    }*/

}
