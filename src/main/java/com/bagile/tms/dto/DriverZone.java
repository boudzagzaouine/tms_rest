package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class DriverZone extends EmsDto implements Serializable {

   
    private static final long serialVersionUID = -3071499212575016582L;
    private long id;
    private Driver driver;
    private  Zone  zone ;


    public DriverZone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverZone that = (DriverZone) o;
        return getId() ==that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
