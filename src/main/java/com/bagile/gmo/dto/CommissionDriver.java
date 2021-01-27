package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommissionDriver extends EmsDto implements Serializable {
    /**
     *
     */

    private long id;
    private Driver driver;
    private CommissionType commissionType;
    private Date datee;





    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }
}
