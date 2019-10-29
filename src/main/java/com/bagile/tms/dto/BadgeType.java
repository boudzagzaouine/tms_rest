package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class BadgeType extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private String code;


    public BadgeType() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadgeType badgeType = (BadgeType) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
