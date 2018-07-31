package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tms_driver")
public class TmsDriver implements java.io.Serializable {

    private long tmsDriverId;
    @Size(max = 255)
    private String tmsDriverCode;
    private String tmsDriverCin;
    private Date tmdDriverBirthDate;

    //private TmsBadge tmsDriverbadge;
    private Set<TmsBadge> tmsDriverBadges;

    private Date tmsDriverlastMedicalVisit;
    private TmsZone tmsDriverWorkArea;
    private TmsVacation tmsDriverVacation;
    private BigDecimal tmsDriverCommission;
    private PrmContact tmsDrivercontact;
    private Date tmsDriverCreationDate;
    private UsrUser tmsDriverCreationUser;
    private UsrUser tmsDriverUpDateDate;

    @Size(max = 30)
    @NotNull
   /* private TmsDriverSituation tmsDriverSituation;

    private Set<TmsDriverBadge> tmsDriverBadges;*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_driversequence")
    @Column(name = "tms_driverid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }

    public String getTmsDriverCode() {
        return tmsDriverCode;
    }

    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }

    public String getTmsDriverCin() {
        return tmsDriverCin;
    }

    public void setTmsDriverCin(String tmsDriverCin) {
        this.tmsDriverCin = tmsDriverCin;
    }

    public Date getTmdDriverBirthDate() {
        return tmdDriverBirthDate;
    }

    public void setTmdDriverBirthDate(Date tmdDriverBirthDate) {
        this.tmdDriverBirthDate = tmdDriverBirthDate;
    }

    public Set<TmsBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }

    public Date getTmsDriverlastMedicalVisit() {
        return tmsDriverlastMedicalVisit;
    }

    public void setTmsDriverlastMedicalVisit(Date tmsDriverlastMedicalVisit) {
        this.tmsDriverlastMedicalVisit = tmsDriverlastMedicalVisit;
    }

    public TmsZone getTmsDriverWorkArea() {
        return tmsDriverWorkArea;
    }

    public void setTmsDriverWorkArea(TmsZone tmsDriverWorkArea) {
        this.tmsDriverWorkArea = tmsDriverWorkArea;
    }

    public TmsVacation getTmsDriverVacation() {
        return tmsDriverVacation;
    }

    public void setTmsDriverVacation(TmsVacation tmsDriverVacation) {
        this.tmsDriverVacation = tmsDriverVacation;
    }

    public BigDecimal getTmsDriverCommission() {
        return tmsDriverCommission;
    }

    public void setTmsDriverCommission(BigDecimal tmsDriverCommission) {
        this.tmsDriverCommission = tmsDriverCommission;
    }

    public PrmContact getTmsDrivercontact() {
        return tmsDrivercontact;
    }

    public void setTmsDrivercontact(PrmContact tmsDrivercontact) {
        this.tmsDrivercontact = tmsDrivercontact;
    }

    public Date getTmsDriverCreationDate() {
        return tmsDriverCreationDate;
    }

    public void setTmsDriverCreationDate(Date tmsDriverCreationDate) {
        this.tmsDriverCreationDate = tmsDriverCreationDate;
    }

    public UsrUser getTmsDriverCreationUser() {
        return tmsDriverCreationUser;
    }

    public void setTmsDriverCreationUser(UsrUser tmsDriverCreationUser) {
        this.tmsDriverCreationUser = tmsDriverCreationUser;
    }

    public UsrUser getTmsDriverUpDateDate() {
        return tmsDriverUpDateDate;
    }

    public void setTmsDriverUpDateDate(UsrUser tmsDriverUpDateDate) {
        this.tmsDriverUpDateDate = tmsDriverUpDateDate;
    }
}
