package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yasser on 22/09/2016.
 */
public class Incident implements Serializable {

    private long id;
    private String code;
    private Date dateTime;
    private String description;
    private NatureIncident natureIncident;
    private Road road;
    private Driver driver;

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NatureIncident getNatureIncident() {
        return natureIncident;
    }

    public void setNatureIncident(NatureIncident natureIncident) {
        this.natureIncident = natureIncident;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Incident obj = (Incident) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }
}
