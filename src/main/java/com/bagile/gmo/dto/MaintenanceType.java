package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class MaintenanceType extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4187067877993165608L;
    private long id;
    private String code;
    private String description;


    public MaintenanceType() {
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
        MaintenanceType that = (MaintenanceType) o;
        return getId()==(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
