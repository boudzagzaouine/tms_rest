package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BadgeTypeDriver extends EmsDto implements Serializable {
    /**
     *
     */

    private long id;
    private Driver driver;
    private BadgeType badgeType;


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

    public BadgeType getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(BadgeType badgeType) {
        this.badgeType = badgeType;
    }
}
