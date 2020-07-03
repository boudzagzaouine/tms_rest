package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class ServiceProvider extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private String code;
    private String description;


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
        ServiceProvider badgeType = (ServiceProvider) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
