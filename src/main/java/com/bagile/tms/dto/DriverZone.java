package com.bagile.tms.dto;

import java.io.Serializable;

public class DriverZone extends EmsDto implements Serializable {

    private int  id;
    private Driver driver;
    private  Zone  zone ;


    public DriverZone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
