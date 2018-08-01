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
    private Badge badge;
    private Date lastMedicalVisit;
    private Zone workArea;
    private Vacation vacation;
    private BigDecimal commission;
    private Contact contact;
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

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Date getLastMedicalVisit() {
        return lastMedicalVisit;
    }

    public void setLastMedicalVisit(Date lastMedicalVisit) {
        this.lastMedicalVisit = lastMedicalVisit;
    }

    public Zone getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Zone workArea) {
        this.workArea = workArea;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
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
}
