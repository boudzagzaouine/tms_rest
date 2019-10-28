package com.bagile.tms.dto;

import java.io.Serializable;

public class MaintenanceType extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4187067877993165608L;
    private int id;
    private String code;
    private String description;


    public MaintenanceType() {
    }

    public int getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
