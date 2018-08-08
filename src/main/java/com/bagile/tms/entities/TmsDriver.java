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
    private boolean tmsDriverWorking;

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
    private Date tmsDriverUpDateDate;

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

    @Column(name = "tms_drivercode")
    public String getTmsDriverCode() {
        return tmsDriverCode;
    }

    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }

    @Column(name = "tms_drivercin")
    public String getTmsDriverCin() {
        return tmsDriverCin;
    }


    public void setTmsDriverCin(String tmsDriverCin) {
        this.tmsDriverCin = tmsDriverCin;
    }

    @Column(name = "tms_badgecode")
    public Date getTmsDriverBirthDate() {
        return tmsDriverBirthDate;
    }

    public void setTmsDriverBirthDate(Date tmsDriverBirthDate) {
        this.tmsDriverBirthDate = tmsDriverBirthDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_driverbadge")
    public Set<TmsBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }

    @Column(name = "tms_driverlastmedicalvisit")
    public Date getTmsDriverlastMedicalVisit() {
        return tmsDriverlastMedicalVisit;
    }

    public void setTmsDriverlastMedicalVisit(Date tmsDriverlastMedicalVisit) {
        this.tmsDriverlastMedicalVisit = tmsDriverlastMedicalVisit;
    }

    @Column(name = "tms_driverworking")
    public boolean isTmsDriverWorking() {
        return tmsDriverWorking;
    }

    public void setTmsDriverWorking(boolean tmsDriverWorking) {
        this.tmsDriverWorking = tmsDriverWorking;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_driverworkarea")
    public TmsZone getTmsDriverWorkArea() {
        return tmsDriverWorkArea;
    }

    public void setTmsDriverWorkArea(TmsZone tmsDriverWorkArea) {
        this.tmsDriverWorkArea = tmsDriverWorkArea;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_drivervacationid")
    public TmsVacation getTmsDriverVacation() {
        return tmsDriverVacation;
    }

    public void setTmsDriverVacation(TmsVacation tmsDriverVacation) {
        this.tmsDriverVacation = tmsDriverVacation;
    }


    @Column(name = "tms_drivercommission")
    public BigDecimal getTmsDriverCommission() {
        return tmsDriverCommission;
    }

    public void setTmsDriverCommission(BigDecimal tmsDriverCommission) {
        this.tmsDriverCommission = tmsDriverCommission;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tms_drivercontactid")
    public PrmContact getTmsDrivercontact() {
        return tmsDrivercontact;
    }

    public void setTmsDrivercontact(PrmContact tmsDrivercontact) {
        this.tmsDrivercontact = tmsDrivercontact;
    }

    @Column(name = "tms_drivercreationdate")
    public Date getTmsDriverCreationDate() {
        return tmsDriverCreationDate;
    }

    public void setTmsDriverCreationDate(Date tmsDriverCreationDate) {
        this.tmsDriverCreationDate = tmsDriverCreationDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tms_drivercreationuserid")
    public UsrUser getTmsDriverCreationUser() {
        return tmsDriverCreationUser;
    }

    public void setTmsDriverCreationUser(UsrUser tmsDriverCreationUser) {
        this.tmsDriverCreationUser = tmsDriverCreationUser;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tms_driverupdatedate")
    public Date getTmsDriverUpDateDate() {
        return tmsDriverUpDateDate;
    }

    public void setTmsDriverUpDateDate(Date tmsDriverUpDateDate) {
        this.tmsDriverUpDateDate = tmsDriverUpDateDate;
    }
}
