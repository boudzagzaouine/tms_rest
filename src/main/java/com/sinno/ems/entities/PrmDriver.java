package com.sinno.ems.entities;

import com.sinno.ems.dto.*;

import javax.persistence.*;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by khalil on 16/03/2017.
 */
@Entity
@Table(name = "prm_driver", uniqueConstraints = @UniqueConstraint(columnNames = {"prm_driverecode","prm_driverid"}))

public class PrmDriver implements java.io.Serializable{
    private long prmDriverId;
    @NotNull
    private String prmDriverCode;
    @Size(max = 255)
    private String prmDriverPassportNumber;
    private String prmDriverPassportLink;
    private String prmDriverLastName;
    private String prmDriverFirstName;
    private Date prmDriverBirthDay;
    private String prmDriverCellPhone;
    private Set<PrmIncident> pincidents;
    private Set<PrmRoad> proads;
    private Set<PrmBadge> pbadges;
    private Adresse adresse;
    @Size(max = 30)
    @NotNull
    private DriverSituation driverSituation;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_driver", allocationSize = 1)
    @Column(name = "prm_driverid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrmDriverId() {
        return prmDriverId;
    }

    public void setPrmDriverId(long prmDriverId) {
        this.prmDriverId = prmDriverId;
    }
    @Column(name = "prm_drivercode", nullable = false, length = 20)

    public String getPrmDriverCode() {
        return prmDriverCode;
    }

    public void setPrmDriverCode(String prmDriverCode) {
        this.prmDriverCode = prmDriverCode;
    }
    @Column(name = "prm_driverpassportNumber", nullable = false, length = 20)

    public String getPrmDriverPassportNumber() {
        return prmDriverPassportNumber;
    }

    public void setPrmDriverPassportNumber(String prmDriverPassportNumber) {
        this.prmDriverPassportNumber = prmDriverPassportNumber;
    }
    @Column(name = "prm_driverpassportLink", nullable = false, length = 20)

    public String getPrmDriverPassportLink() {
        return prmDriverPassportLink;
    }

    public void setPrmDriverPassportLink(String prmDriverPassportLink) {
        this.prmDriverPassportLink = prmDriverPassportLink;
    }
    @Column(name = "prm_prmDriverLastName", nullable = false, length = 20)

    public String getPrmDriverLastName() {
        return prmDriverLastName;
    }

    public void setPrmDriverLastName(String prmDriverLastName) {
        this.prmDriverLastName = prmDriverLastName;
    }
    @Column(name = "prm_prmDriverFirstName", nullable = false, length = 20)

    public String getPrmDriverFirstName() {
        return prmDriverFirstName;
    }

    public void setPrmDriverFirstName(String prmDriverFirstName) {
        this.prmDriverFirstName = prmDriverFirstName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_prmDriverBirthDay")

    public Date getPrmDriverBirthDay() {
        return prmDriverBirthDay;
    }

    public void setPrmDriverBirthDay(Date prmDriverBirthDay) {
        this.prmDriverBirthDay = prmDriverBirthDay;
    }
    @Column(name = "prm_prmDriverCellPhone", nullable = false, length = 20)

    public String getPrmDriverCellPhone() {
        return prmDriverCellPhone;
    }

    public void setPrmDriverCellPhone(String prmDriverCellPhone) {
        this.prmDriverCellPhone = prmDriverCellPhone;
    }
    @Column(name="prm_insidentDriver",nullable=false)

    public Set<PrmIncident> getPincidents() {
        return pincidents;
    }

    public void setPincidents(Set<PrmIncident> pincidents) {
        this.pincidents = pincidents;
    }
    @Column(name="prm_roadDriver",nullable=false)

    public Set<PrmRoad> getProads() {
        return proads;
    }

    public void setProads(Set<PrmRoad> proads) {
        this.proads = proads;
    }
    @Column(name="prm_badgeDriver",nullable=false)

    public Set<PrmBadge> getPbadges() {
        return pbadges;
    }

    public void setPbadges(Set<PrmBadge> pbadges) {
        this.pbadges = pbadges;
    }
    @Column(name="prm_adresseDriver",nullable=false)

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public DriverSituation getDriverSituation() {
        return driverSituation;
    }

    public void setDriverSituation(DriverSituation driverSituation) {
        this.driverSituation = driverSituation;
    }
}
