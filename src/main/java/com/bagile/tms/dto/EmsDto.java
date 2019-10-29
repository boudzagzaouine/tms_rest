package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public abstract class EmsDto implements Serializable {

    private static final long serialVersionUID = 391108110104512461L;
    protected String createdBy;
    protected String updatedBy;

    protected Date creationDate;
    protected Date updateDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


}
