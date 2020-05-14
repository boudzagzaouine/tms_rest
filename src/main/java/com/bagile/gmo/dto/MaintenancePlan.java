package com.bagile.gmo.dto;

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
    private Date startDate;
    private Date endDate;
    private MaintenanceType maintenanceType;
    private MaintenanceState maintenanceState;
    private Patrimony patrimony;
    private Double mileage = 0.0;
    private BigDecimal totalPrice;
    private List<MaintenanceLine> maintenanceLines;


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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Patrimony getPatrimony() {
        return patrimony;
    }

    public void setPatrimony(Patrimony patrimony) {
        this.patrimony = patrimony;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<MaintenanceLine> getMaintenanceLines() {
        return maintenanceLines;
    }

    public void setMaintenanceLineList(List<MaintenanceLine> maintenanceLines) {
        this.maintenanceLines = maintenanceLines;
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
