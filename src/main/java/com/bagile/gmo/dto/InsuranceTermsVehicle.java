package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InsuranceTermsVehicle extends EmsDto {

    private Long id;
    //private Vehicle vehicle;
    private InsuranceTerm insuranceTerm;
    private BigDecimal amount;
    private Insurance insurance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    /*public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/

    public InsuranceTerm getInsuranceTerm() {
        return insuranceTerm;
    }

    public void setInsuranceTerm(InsuranceTerm insuranceTerm) {
        this.insuranceTerm = insuranceTerm;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
