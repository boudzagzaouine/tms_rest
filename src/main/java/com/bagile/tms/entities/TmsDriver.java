package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tms_driver", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_drivercode","tms_driverId","tms_drivercin"}))
public class TmsDriver implements java.io.Serializable {

    private long tmsDriverId;
    @Size(max = 255)
    private String tmsDriverCode;
    @Size(max=30)
    private String tmsDriverCin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsDriverBirthDate;

    //private TmsBadge tmsDriverbadge;
    private Set<TmsBadge> tmsDriverBadges;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsDriverlastMedicalVisit;
    private TmsZone tmsDriverWorkArea;
    private TmsVacation tmsDriverVacation;
    private BigDecimal tmsDriverCommission;
    private PrmContact tmsDrivercontact;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsDriverCreationDate;
    private UsrUser tmsDriverCreationUser;
    private UsrUser tmsDriverUpDateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_driversequence")
    @Column(name = "tms_driverId", unique = true, nullable = false, precision = 10, scale = 0)



    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }

    @Column(name = "tms_drivercode", nullable = false, length = 30)
    public String getTmsDriverCode() {
        return tmsDriverCode;
    }

    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }

    @Column(name = "tms_drivercin", nullable = false, length = 30)
    public String getTmsDriverCin() {
        return tmsDriverCin;
    }


    public void setTmsDriverCin(String tmsDriverCin) {
        this.tmsDriverCin = tmsDriverCin;
    }

    @Column(name = "tms_badgecode", nullable = false, length = 30)
    public Date getTmsDriverBirthDate() {
        return tmsDriverBirthDate;
    }

    public void setTmsDriverBirthDate(Date tmsDriverBirthDate) {
        this.tmsDriverBirthDate = tmsDriverBirthDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_driverbadge", nullable = false, length = 30)
    public Set<TmsBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }

    @Column(name = "tms_driverlastmedicalvisit", nullable = false, length = 30)
    public Date getTmsDriverlastMedicalVisit() {
        return tmsDriverlastMedicalVisit;
    }

    public void setTmsDriverlastMedicalVisit(Date tmsDriverlastMedicalVisit) {
        this.tmsDriverlastMedicalVisit = tmsDriverlastMedicalVisit;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_driverworkarea", nullable = false, length = 30)
    public TmsZone getTmsDriverWorkArea() {
        return tmsDriverWorkArea;
    }

    public void setTmsDriverWorkArea(TmsZone tmsDriverWorkArea) {
        this.tmsDriverWorkArea = tmsDriverWorkArea;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_drivervacation", nullable = false, length = 30)
    public TmsVacation getTmsDriverVacation() {
        return tmsDriverVacation;
    }

    public void setTmsDriverVacation(TmsVacation tmsDriverVacation) {
        this.tmsDriverVacation = tmsDriverVacation;
    }


    @Column(name = "tms_drivercommission", nullable = false, length = 30)
    public BigDecimal getTmsDriverCommission() {
        return tmsDriverCommission;
    }

    public void setTmsDriverCommission(BigDecimal tmsDriverCommission) {
        this.tmsDriverCommission = tmsDriverCommission;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @Column(name = "tms_drivercontact", nullable = false, length = 30)
    public PrmContact getTmsDrivercontact() {
        return tmsDrivercontact;
    }

    public void setTmsDrivercontact(PrmContact tmsDrivercontact) {
        this.tmsDrivercontact = tmsDrivercontact;
    }

    @Column(name = "tms_drivercreationdate", nullable = false, length = 30)
    public Date getTmsDriverCreationDate() {
        return tmsDriverCreationDate;
    }

    public void setTmsDriverCreationDate(Date tmsDriverCreationDate) {
        this.tmsDriverCreationDate = tmsDriverCreationDate;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @Column(name = "tms_drivercreationuser", nullable = false, length = 30)
    public UsrUser getTmsDriverCreationUser() {
        return tmsDriverCreationUser;
    }

    public void setTmsDriverCreationUser(UsrUser tmsDriverCreationUser) {
        this.tmsDriverCreationUser = tmsDriverCreationUser;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @Column(name = "tms_driverupdatedate", nullable = false, length = 30)
    public UsrUser getTmsDriverUpDateDate() {
        return tmsDriverUpDateDate;
    }

    public void setTmsDriverUpDateDate(UsrUser tmsDriverUpDateDate) {
        this.tmsDriverUpDateDate = tmsDriverUpDateDate;
    }
}
