package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class Badge extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private String code;
    private String description;
    private BadgeType badgeType;

    public Badge() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
