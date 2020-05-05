package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Date;

public class BadgeTypeDriver extends EmsDto implements Serializable {
    /**
     *
     */

    private long id;
    private Driver driver;
    private BadgeType badgeType;
    private String badgeNumber;
    private Date   deliveranceDate;
    private Date   validityEndDate;




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


    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Date getDeliveranceDate() {
        return deliveranceDate;
    }

    public void setDeliveranceDate(Date deliveranceDate) {
        this.deliveranceDate = deliveranceDate;
    }

    public Date getValidityEndDate() {
        return validityEndDate;
    }

    public void setValidityEndDate(Date validityEndDate) {
        this.validityEndDate = validityEndDate;
    }
}
