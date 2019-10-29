package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class Badge extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3467898889038526418L;
    private long id;
    private String code;
    private BadgeType badgeType;
    private Driver driver;

    public Badge() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Badge badge = (Badge) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
