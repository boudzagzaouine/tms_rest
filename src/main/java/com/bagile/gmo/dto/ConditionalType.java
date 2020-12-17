package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class ConditionalType extends EmsDto implements Serializable {
    /**
     *
     */

    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private String code;
    private String description;
 private Owner owner;

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionalType badgeType = (ConditionalType) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
