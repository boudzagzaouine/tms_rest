package com.bagile.tms.dto;

import java.io.Serializable;

public class Badge implements Serializable {

    private long id;
    private String code;
    private BadgeType badgetype;
    private Driver driver;

    public Badge() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public BadgeType getBadgetype() {
        return badgetype;
    }

    public void setBadgetype(BadgeType badgetype) {
        this.badgetype = badgetype;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
