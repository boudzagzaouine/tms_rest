package com.bagile.tms.dto;

import com.bagile.tms.entities.*;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


public class Driver implements Serializable {

    private long id;
    @Size(max = 255)
    private String code;
    @Size(max = 30)
    private String cin;
    @Size(max = 30)
    private Date date;
    private TmsBadge badge;
    private Date lastMedicalVisit;
    private TmsZone workArea;
    private TmsVacation vacation;
    private BigDecimal commission;
    private PrmContact contact;
    private Date creationDate;
    private UsrUser creationUser;
    private UsrUser upDateDate;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TmsBadge getBadge() {
        return badge;
    }

    public void setBadge(TmsBadge badge) {
        this.badge = badge;
    }

    public Date getLastMedicalVisit() {
        return lastMedicalVisit;
    }

    public void setLastMedicalVisit(Date lastMedicalVisit) {
        this.lastMedicalVisit = lastMedicalVisit;
    }

    public TmsZone getWorkArea() {
        return workArea;
    }

    public void setWorkArea(TmsZone workArea) {
        this.workArea = workArea;
    }

    public TmsVacation getVacation() {
        return vacation;
    }

    public void setVacation(TmsVacation vacation) {
        this.vacation = vacation;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public PrmContact getContact() {
        return contact;
    }

    public void setContact(PrmContact contact) {
        this.contact = contact;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UsrUser getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(UsrUser creationUser) {
        this.creationUser = creationUser;
    }

    public UsrUser getUpDateDate() {
        return upDateDate;
    }

    public void setUpDateDate(UsrUser upDateDate) {
        this.upDateDate = upDateDate;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o == null || o.getClass() != getClass()) {
            result = false;
        } else {
            Driver obj = (Driver) o;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    };

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getCode(), getCin(), getDate(), getBadge(), getLastMedicalVisit(), getWorkArea(), getVacation(), getCommission(), getContact(), getCreationDate(), getCreationUser(), getUpDateDate());
    }
}
