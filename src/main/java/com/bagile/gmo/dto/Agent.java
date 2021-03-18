package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Agent extends EmsDto implements Serializable {


    private static final long serialVersionUID = 9165430360445575972L;
    private long id;
    private String code;
    private String cin;
    private Date birthDate;
    private Date lastMedicalVisit;
    private Boolean working=false;
    private String name;
    private String tele1;
   private Responsability responsability;
    private Owner owner;

    public Agent() {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public Responsability getResponsability() {
        return responsability;
    }

    public void setResponsability(Responsability responsability) {
        this.responsability = responsability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent driver = (Agent) o;
        return getId() == driver.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
