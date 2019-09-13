package com.bagile.tms.entities;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.dto.Contact;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_driver")
public class TmsDriver  {

    @Id
    @GeneratedValue
    @Column(name = "tms_driverid")
    private long tmsDriverid;
    @Column(name = "tms_drivercode")
    private String tmsDrivercode;
    @Column(name = "tms_drivercin")
    private String tmsDrivercin;
    @Column(name = "tms_driverbirthdate")
    private Date tmsDriverbirthDate;
    @Column(name = "tms_driverlastmedicalvisit")
    private Date tmsDriverlastMedicalVisit;
    @Column(name = "tms_drivercommission")
    private Double tmsDrivercommission;
    @Column(name = "tms_drivercreationdate")
    private Date tmsDrivercreationDate;
    @Column(name = "tms_driverupdate")
    private Date tmsDriverupDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_contactid")
    private TmsContact tmsContact;
    @Column(name = "tms_driverworkin")
    private boolean tmWorking;






    public TmsDriver() {
    }

    public boolean isTmWorking() {
        return tmWorking;
    }

    public void setTmWorking(boolean tmWorking) {
        this.tmWorking = tmWorking;
    }

    public long getTmsDriverid() {
        return tmsDriverid;
    }

    public void setTmsDriverid(long tmsDriverid) {
        this.tmsDriverid = tmsDriverid;
    }

    public String getTmsDrivercode() {
        return tmsDrivercode;
    }

    public void setTmsDrivercode(String tmsDrivercode) {
        this.tmsDrivercode = tmsDrivercode;
    }

    public String getTmsDrivercin() {
        return tmsDrivercin;
    }

    public void setTmsDrivercin(String tmsDrivercin) {
        this.tmsDrivercin = tmsDrivercin;
    }

    public Date getTmsDriverbirthDate() {
        return tmsDriverbirthDate;
    }

    public void setTmsDriverbirthDate(Date tmsDriverbirthDate) {
        this.tmsDriverbirthDate = tmsDriverbirthDate;
    }

    public Date getTmsDriverlastMedicalVisit() {
        return tmsDriverlastMedicalVisit;
    }

    public void setTmsDriverlastMedicalVisit(Date tmsDriverlastMedicalVisit) {
        this.tmsDriverlastMedicalVisit = tmsDriverlastMedicalVisit;
    }

    public Double getTmsDrivercommission() {
        return tmsDrivercommission;
    }

    public void setTmsDrivercommission(Double tmsDrivercommission) {
        this.tmsDrivercommission = tmsDrivercommission;
    }

    public Date getTmsDrivercreationDate() {
        return tmsDrivercreationDate;
    }

    public void setTmsDrivercreationDate(Date tmsDrivercreationDate) {
        this.tmsDrivercreationDate = tmsDrivercreationDate;
    }

    public Date getTmsDriverupDate() {
        return tmsDriverupDate;
    }

    public void setTmsDriverupDateDate(Date tmsDriverupDateDate) {
        this.tmsDriverupDate = tmsDriverupDateDate;
    }

    public TmsContact getTmsContact() {
        return tmsContact;
    }

    public void setTmsContact(TmsContact tmsContact) {
        this.tmsContact = tmsContact;
    }


}
