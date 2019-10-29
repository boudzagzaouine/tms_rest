package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class VacationType extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4646546414658712225L;
    private long id;
    private String code;
    private String description;

    public VacationType() {
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
        VacationType that = (VacationType) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
