package com.bagile.tms.dto;

import java.io.Serializable;

public class VacationType extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4646546414658712225L;
    private int id;
    private String type;

    public VacationType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
