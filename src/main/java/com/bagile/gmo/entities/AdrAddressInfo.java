package com.bagile.gmo.entities;


import javax.persistence.Embeddable;

@Embeddable
public class AdrAddressInfo {

    private String adrAddressLine1;


    private String adrAddressLine2;

    private String adrAddressZip;

    private String adrAddressCity;

    private String adrAddressState;

    private String adrAddressCountry;

    private String adrAddressDigiCode;

    public String getAdrAddressLine1() {
        return adrAddressLine1;
    }

    public void setAdrAddressLine1(String adrAddressLine1) {
        this.adrAddressLine1 = adrAddressLine1;
    }

    public String getAdrAddressLine2() {
        return adrAddressLine2;
    }

    public void setAdrAddressLine2(String adrAddressLine2) {
        this.adrAddressLine2 = adrAddressLine2;
    }

    public String getAdrAddressZip() {
        return adrAddressZip;
    }

    public void setAdrAddressZip(String adrAddressZip) {
        this.adrAddressZip = adrAddressZip;
    }

    public String getAdrAddressCity() {
        return adrAddressCity;
    }

    public void setAdrAddressCity(String adrAddressCity) {
        this.adrAddressCity = adrAddressCity;
    }

    public String getAdrAddressState() {
        return adrAddressState;
    }

    public void setAdrAddressState(String adrAddressState) {
        this.adrAddressState = adrAddressState;
    }

    public String getAdrAddressCountry() {
        return adrAddressCountry;
    }

    public void setAdrAddressCountry(String adrAddressCountry) {
        this.adrAddressCountry = adrAddressCountry;
    }

    public String getAdrAddressDigiCode() {
        return adrAddressDigiCode;
    }

    public void setAdrAddressDigiCode(String adrAddressDigiCode) {
        this.adrAddressDigiCode = adrAddressDigiCode;
    }
}
