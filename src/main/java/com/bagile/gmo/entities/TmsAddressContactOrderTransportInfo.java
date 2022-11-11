package com.bagile.gmo.entities;


import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class TmsAddressContactOrderTransportInfo {



    private String tmsAddressContactOrderTransportName;
    private String tmsAddressContactOrderTransportTel1;
    private String tmsAddressContactOrderTransportEmail;
    private String tmsAddressContactOrderTransportCompany;

    private String tmsAddressContactOrderTransportLine1;

    private String tmsAddressContactOrderTransportCity;
    private String tmsAddressContactOrderTransportZip;

    private String tmsAddressContactOrderTransportCountry;

    private Date tmsAddressContactOrderTransportDate;
    private Double tmsAddressContactOrderTransportLatitude;
    private Double tmsAddressContactOrderTransportLongitude;


    public String getTmsAddressContactOrderTransportName() {
        return tmsAddressContactOrderTransportName;
    }

    public void setTmsAddressContactOrderTransportName(String tmsAddressContactOrderTransportName) {
        this.tmsAddressContactOrderTransportName = tmsAddressContactOrderTransportName;
    }

    public String getTmsAddressContactOrderTransportTel1() {
        return tmsAddressContactOrderTransportTel1;
    }

    public void setTmsAddressContactOrderTransportTel1(String tmsAddressContactOrderTransportTel1) {
        this.tmsAddressContactOrderTransportTel1 = tmsAddressContactOrderTransportTel1;
    }

    public String getTmsAddressContactOrderTransportEmail() {
        return tmsAddressContactOrderTransportEmail;
    }

    public void setTmsAddressContactOrderTransportEmail(String tmsAddressContactOrderTransportEmail) {
        this.tmsAddressContactOrderTransportEmail = tmsAddressContactOrderTransportEmail;
    }

    public String getTmsAddressContactOrderTransportCompany() {
        return tmsAddressContactOrderTransportCompany;
    }

    public void setTmsAddressContactOrderTransportCompany(String tmsAddressContactOrderTransportCompany) {
        this.tmsAddressContactOrderTransportCompany = tmsAddressContactOrderTransportCompany;
    }

    public String getTmsAddressContactOrderTransportLine1() {
        return tmsAddressContactOrderTransportLine1;
    }

    public void setTmsAddressContactOrderTransportLine1(String tmsAddressContactOrderTransportLine1) {
        this.tmsAddressContactOrderTransportLine1 = tmsAddressContactOrderTransportLine1;
    }

    public String getTmsAddressContactOrderTransportCity() {
        return tmsAddressContactOrderTransportCity;
    }

    public void setTmsAddressContactOrderTransportCity(String tmsAddressContactOrderTransportCity) {
        this.tmsAddressContactOrderTransportCity = tmsAddressContactOrderTransportCity;
    }

    public String getTmsAddressContactOrderTransportZip() {
        return tmsAddressContactOrderTransportZip;
    }

    public void setTmsAddressContactOrderTransportZip(String tmsAddressContactOrderTransportZip) {
        this.tmsAddressContactOrderTransportZip = tmsAddressContactOrderTransportZip;
    }

    public String getTmsAddressContactOrderTransportCountry() {
        return tmsAddressContactOrderTransportCountry;
    }

    public void setTmsAddressContactOrderTransportCountry(String tmsAddressContactOrderTransportCountry) {
        this.tmsAddressContactOrderTransportCountry = tmsAddressContactOrderTransportCountry;
    }

    public Date getTmsAddressContactOrderTransportDate() {
        return tmsAddressContactOrderTransportDate;
    }

    public void setTmsAddressContactOrderTransportDate(Date tmsAddressContactOrderTransportDate) {
        this.tmsAddressContactOrderTransportDate = tmsAddressContactOrderTransportDate;
    }

    public Double getTmsAddressContactOrderTransportLatitude() {
        return tmsAddressContactOrderTransportLatitude;
    }

    public void setTmsAddressContactOrderTransportLatitude(Double tmsAddressContactOrderTransportLatitude) {
        this.tmsAddressContactOrderTransportLatitude = tmsAddressContactOrderTransportLatitude;
    }

    public Double getTmsAddressContactOrderTransportLongitude() {
        return tmsAddressContactOrderTransportLongitude;
    }

    public void setTmsAddressContactOrderTransportLongitude(Double tmsAddressContactOrderTransportLongitude) {
        this.tmsAddressContactOrderTransportLongitude = tmsAddressContactOrderTransportLongitude;
    }
}
