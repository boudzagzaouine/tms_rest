package com.bagile.tms.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class EmsEntity  implements Serializable {
    protected String createdBy;
    protected String updatedBy;
    protected UsrUser createdByUser;
    protected UsrUser updatedByUser;

    @CreatedBy
    @Column(name = "createdby")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "updatedby")
    @LastModifiedBy
    public String getUpdatedBy() {
        return updatedBy;
    }


    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    @JoinColumn(name = "createdbyuserid")
    @ManyToOne(fetch = FetchType.LAZY)
    public UsrUser getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UsrUser createdByUser) {
        this.createdByUser = createdByUser;
    }
    @JoinColumn(name = "updatedbyuserid")
    @ManyToOne(fetch = FetchType.LAZY)
    public UsrUser getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(UsrUser updatedByUser) {
        this.updatedByUser = updatedByUser;
    }
}
