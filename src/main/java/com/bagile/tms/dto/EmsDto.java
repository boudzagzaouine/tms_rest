package com.bagile.tms.dto;

import java.io.Serializable;

public abstract class EmsDto implements Serializable {
  
    private static final long serialVersionUID = 391108110104512461L;
    private String createdBy;
    private String updatedBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
