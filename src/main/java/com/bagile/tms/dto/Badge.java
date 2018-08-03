package com.bagile.tms.dto;

import com.bagile.tms.entities.TmsBadgeType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


public class Badge implements Serializable {
    private String code;
    private long id;
    private BadgeType type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BadgeType getType() {
        return type;
    }

    public void setType(BadgeType type) {
        this.type = type;
    }
}

