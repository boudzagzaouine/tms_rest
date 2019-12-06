package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MaintenancePlan extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6036580510935986433L;
    private long id;
    private String code;
    private String description;
    private Date begin;
    private Date end;
    private MaintenanceType maintenanceType;
    private MaintenanceState maintenanceState;
    private Vehicle vehicle;
    private double mileage;
   private BigDecimal totalPrice;
    private List<MaintenanceLine> maintenanceLineList;


    public MaintenancePlan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public MaintenanceState getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(MaintenanceState maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<MaintenanceLine> getMaintenanceLineList() {
        return maintenanceLineList;
    }

    public void setMaintenanceLineList(List<MaintenanceLine> maintenanceLineList) {
        this.maintenanceLineList = maintenanceLineList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        MaintenancePlan that = (MaintenancePlan) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
}
