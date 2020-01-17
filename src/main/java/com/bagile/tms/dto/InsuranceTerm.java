package com.bagile.tms.dto;

import java.util.ArrayList;
import java.util.List;

public class InsuranceTerm extends EmsDto {

    private Long id;
    private String code;
    private String description;
    private boolean roofed=false;
    private List<InsuranceTermLigne> insuranceTermLignes=new ArrayList<>();

    public InsuranceTerm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isRoofed() {
        return roofed;
    }

    public void setRoofed(boolean roofed) {
        this.roofed = roofed;
    }

    public List<InsuranceTermLigne> getInsuranceTermLignes() {
        return insuranceTermLignes;
    }

    public void setInsuranceTermLignes(List<InsuranceTermLigne> insuranceTermLignes) {
        this.insuranceTermLignes = insuranceTermLignes;
    }
}
