package com.bagile.tms.dto;

import java.io.Serializable;

public class DriverZone extends EmsDto implements Serializable {

   
    private static final long serialVersionUID = -3071499212575016582L;
    private Long id;
    private Driver driver;
    private  Zone  zone ;


    public DriverZone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
