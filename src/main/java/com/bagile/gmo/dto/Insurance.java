package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Insurance extends EmsDto{

    private long id;
    private String code;
    private String description;
    private String number;
    private Date startDate;
    private Date endDate;
    private BigDecimal amount;
    private Supplier supplier;
    private Vehicle vehicle;
    private String vehicleCode;
    private InsuranceType insuranceType;
   // private List<InsuranceTermLigne> insuranceTermLignes = new ArrayList<>();


    public Insurance() {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

   /* public List<InsuranceTermLigne> getInsuranceTermLignes() {
        return insuranceTermLignes;
    }

    public void setInsuranceTermLignes(List<InsuranceTermLigne> insuranceTermLignes) {
        this.insuranceTermLignes = insuranceTermLignes;
    }*/

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }
}
