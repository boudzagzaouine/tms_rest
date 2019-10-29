package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class MaintenanceState extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6010435708905017454L;
    private Long id;
    private String code;
    private String description;

    public MaintenanceState() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        MaintenanceState that = (MaintenanceState) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
