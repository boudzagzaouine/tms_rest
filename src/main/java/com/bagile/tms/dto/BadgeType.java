package com.bagile.tms.dto;

import java.io.Serializable;

public class BadgeType extends EmsDto implements Serializable {
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
}
