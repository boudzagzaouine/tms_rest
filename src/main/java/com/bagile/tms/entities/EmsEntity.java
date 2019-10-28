package com.bagile.tms.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class EmsEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4865263538755924621L;
    protected String createdBy;
    protected String updatedBy;

    protected Date creationDate;
    protected Date updateDate;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(name = "creationdate")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @JoinColumn(name = "updateddate")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
