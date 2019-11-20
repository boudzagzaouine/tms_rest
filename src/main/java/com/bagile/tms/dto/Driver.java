package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Driver extends EmsDto implements Serializable {


    private static final long serialVersionUID = 9165430360445575972L;
    private long id;
    private String code;
    private String cin;
    private Date birthDate;
    private Date lastMedicalVisit;
    private BigDecimal commission;
    private Contact contact;
    private boolean working;
    private Badge badge;



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

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getId() == driver.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
