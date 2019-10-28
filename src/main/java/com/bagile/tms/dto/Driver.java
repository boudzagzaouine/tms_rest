package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class Driver extends EmsDto implements Serializable {


    private static final long serialVersionUID = 9165430360445575972L;
    private long id;
    private String code;
    private String cin;
    private Date birthDate;
    private Date lastMedicalVisit;
    private Double commission;
    private Date creationDate;
    private Date upDate;
    private Contact contact;
    private boolean working;





    public Driver() {
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getLastMedicalVisit() {
        return lastMedicalVisit;
    }

    public void setLastMedicalVisit(Date lastMedicalVisit) {
        this.lastMedicalVisit = lastMedicalVisit;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDateDate) {
        this.upDate = upDateDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


}
