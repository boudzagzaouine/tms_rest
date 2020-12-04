package com.bagile.gmo.dto;

import java.math.BigDecimal;

public class InsuranceTermsVehicle extends EmsDto {

    private Long id;
    //private Vehicle vehicle;
    private InsuranceTerm insuranceTerm;
    private BigDecimal amount;
    private Insurance insurance;
    private Owner owner;

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

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
