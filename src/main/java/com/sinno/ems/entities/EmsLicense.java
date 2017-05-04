package com.sinno.ems.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Enissay on 28/11/2016.
 */
@Entity
@Table(name = "ems_licence")
public class EmsLicense implements Serializable{

    private EmsLicenceId id;
    private long usersNumber;
    private Date beginDate;
    private Date endDate;
    private String key;

    @EmbeddedId
    public EmsLicenceId getId() {
        return id;
    }

    public void setId(EmsLicenceId id) {
        this.id = id;
    }

    @Column(name = "ems_usersnumber")
    public long getUsersNumber() {
        return usersNumber;
    }

    public void setUsersNumber(long usersNumber) {
        this.usersNumber = usersNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ems_begindate")
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ems_enddate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "ems_key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmsLicense)) return false;
        EmsLicense that = (EmsLicense) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
