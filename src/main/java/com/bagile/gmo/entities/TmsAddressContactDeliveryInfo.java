package com.bagile.gmo.entities;


import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class TmsAddressContactDeliveryInfo {



    private String tmsAddressContactDeliveryInfoName;
    private String tmsAddressContactDeliveryInfoTel1;
    private String tmsAddressContactDeliveryInfoEmail;
    private String tmsAddressContactDeliveryInfoCompany;

    private String tmsAddressContactDeliveryInfoLine1;

    private String tmsAddressContactDeliveryInfoCity;
    private String tmsAddressContactDeliveryInfoZip;

    private String tmsAddressContactDeliveryInfoCountry;

    private Date tmsAddressContactDeliveryInfoDate;
    private Double tmsAddressContactDeliveryInfoLatitude;
    private Double tmsAddressContactDeliveryInfoLongitude;


    public String getTmsAddressContactDeliveryInfoName() {
        return tmsAddressContactDeliveryInfoName;
    }

    public void setTmsAddressContactDeliveryInfoName(String tmsAddressContactDeliveryInfoName) {
        this.tmsAddressContactDeliveryInfoName = tmsAddressContactDeliveryInfoName;
    }

    public String getTmsAddressContactDeliveryInfoTel1() {
        return tmsAddressContactDeliveryInfoTel1;
    }

    public void setTmsAddressContactDeliveryInfoTel1(String tmsAddressContactDeliveryInfoTel1) {
        this.tmsAddressContactDeliveryInfoTel1 = tmsAddressContactDeliveryInfoTel1;
    }

    public String getTmsAddressContactDeliveryInfoEmail() {
        return tmsAddressContactDeliveryInfoEmail;
    }

    public void setTmsAddressContactDeliveryInfoEmail(String tmsAddressContactDeliveryInfoEmail) {
        this.tmsAddressContactDeliveryInfoEmail = tmsAddressContactDeliveryInfoEmail;
    }

    public String getTmsAddressContactDeliveryInfoCompany() {
        return tmsAddressContactDeliveryInfoCompany;
    }

    public void setTmsAddressContactDeliveryInfoCompany(String tmsAddressContactDeliveryInfoCompany) {
        this.tmsAddressContactDeliveryInfoCompany = tmsAddressContactDeliveryInfoCompany;
    }

    public String getTmsAddressContactDeliveryInfoLine1() {
        return tmsAddressContactDeliveryInfoLine1;
    }

    public void setTmsAddressContactDeliveryInfoLine1(String tmsAddressContactDeliveryInfoLine1) {
        this.tmsAddressContactDeliveryInfoLine1 = tmsAddressContactDeliveryInfoLine1;
    }

    public String getTmsAddressContactDeliveryInfoCity() {
        return tmsAddressContactDeliveryInfoCity;
    }

    public void setTmsAddressContactDeliveryInfoCity(String tmsAddressContactDeliveryInfoCity) {
        this.tmsAddressContactDeliveryInfoCity = tmsAddressContactDeliveryInfoCity;
    }

    public String getTmsAddressContactDeliveryInfoZip() {
        return tmsAddressContactDeliveryInfoZip;
    }

    public void setTmsAddressContactDeliveryInfoZip(String tmsAddressContactDeliveryInfoZip) {
        this.tmsAddressContactDeliveryInfoZip = tmsAddressContactDeliveryInfoZip;
    }

    public String getTmsAddressContactDeliveryInfoCountry() {
        return tmsAddressContactDeliveryInfoCountry;
    }

    public void setTmsAddressContactDeliveryInfoCountry(String tmsAddressContactDeliveryInfoCountry) {
        this.tmsAddressContactDeliveryInfoCountry = tmsAddressContactDeliveryInfoCountry;
    }

    public Date getTmsAddressContactDeliveryInfoDate() {
        return tmsAddressContactDeliveryInfoDate;
    }

    public void setTmsAddressContactDeliveryInfoDate(Date tmsAddressContactDeliveryInfoDate) {
        this.tmsAddressContactDeliveryInfoDate = tmsAddressContactDeliveryInfoDate;
    }

    public Double getTmsAddressContactDeliveryInfoLatitude() {
        return tmsAddressContactDeliveryInfoLatitude;
    }

    public void setTmsAddressContactDeliveryInfoLatitude(Double tmsAddressContactDeliveryInfoLatitude) {
        this.tmsAddressContactDeliveryInfoLatitude = tmsAddressContactDeliveryInfoLatitude;
    }

    public Double getTmsAddressContactDeliveryInfoLongitude() {
        return tmsAddressContactDeliveryInfoLongitude;
    }

    public void setTmsAddressContactDeliveryInfoLongitude(Double tmsAddressContactDeliveryInfoLongitude) {
        this.tmsAddressContactDeliveryInfoLongitude = tmsAddressContactDeliveryInfoLongitude;
    }
}
