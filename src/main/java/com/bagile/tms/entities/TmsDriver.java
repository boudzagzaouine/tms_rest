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
    private Date birthDate;
    private TmsBadge Driverbadge;
    private Date lastMedicalVisit;
    private TmsZone workArea;
    private TmsVacation vacation;
    private BigDecimal commission;
    private PrmContact contact;
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

    @Column(name = "tms_drivercode", nullable = false, unique = true)
    public String getTmsDriverCode() {
        return tmsDriverCode;
    }


    @Column(name = "tms_drivercin")
    public String getTmsDriverCin() {
        return tmsDriverCin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_driverbirthdate")
    public Date getBirthDate() {
        return birthDate;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public TmsBadge getBadge() {
        return badge;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="tms_driverlastmedicalvisit")
    public Date getLastMedicalVisit() {
        return lastMedicalVisit;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverworkareaid")
    public TmsZone getWorkArea() {
        return workArea;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="tms_drivervacation")
    public TmsVacation getVacation() {
        return vacation;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="tms_commission")
    public BigDecimal getCommission() {
        return commission;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tms_drivercode")
    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tms_drivercontact")
    public PrmContact getPrmContact() {
        return prmContact;
    }


    @JoinColumn(name="tms_drivercin")
    public void setTmsDriverCin(String tmsDriverCin) {
        this.tmsDriverCin = tmsDriverCin;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tms_driverbadge")
    public void setBadge(TmsBadge badge) {
        this.badge = badge;
    }

    @JoinColumn(name="tms_driverlastmedicalvisit")
    public void setLastMedicalVisit(Date lastMedicalVisit) {
        this.lastMedicalVisit = lastMedicalVisit;
    }


    public void setWorkArea(TmsZone workArea) {
        this.workArea = workArea;
    }

    public void setVacation(TmsVacation vacation) {
        this.vacation = vacation;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public PrmContact getContact() {
        return contact;
    }

    public void setContact(PrmContact contact) {
        this.contact = contact;
    }

    public UsrUser getTmsDriverCreationUser() {
        return tmsDriverCreationUser;
    }

    public UsrUser getTmsDriverUpDateUser() {
        return tmsDriverUpDateUser;
    }

    public void setTmsDriverUpDateUser(UsrUser tmsDriverUpDateUser) {
        this.tmsDriverUpDateUser = tmsDriverUpDateUser;
    }

    public Set<TmsBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsBadges(Set<TmsBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }

    public void setTmsDriverCreationUser(UsrUser tmsDriverCreationUser) {
        this.tmsDriverCreationUser = tmsDriverCreationUser;
    }

    public void setPrmContact(com.bagile.tms.entities.PrmContact prmContact) {
        this.prmContact = prmContact;
    }
}
