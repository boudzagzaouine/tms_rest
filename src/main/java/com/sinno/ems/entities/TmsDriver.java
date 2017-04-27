package com.sinno.ems.entities;

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
@Table(name = "tms_driver", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_driverecode","tms_driverid"}))

public class TmsDriver implements java.io.Serializable{
    private long tmsDriverId;

    @Size(max = 255)
    private String tmsDriverPassportNumber;

    private Set<TmsIncident> pincidents;
    private Set<TmsBadge> pbadges;
    //  private Adresse adresse;
  private Date tmsDriverDateCreation;
    private Date tmsDriverDateUpDate;
    private UsrUser tmsDriverCreationUser;
    private UsrUser tmsDriverUpDateUser;
    @Size(max = 30)
    @NotNull
    private TmsDriverSituation tmsDriverSituation;

    private Set<TmsDriverBadge> tmsDriverBadges;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_driverid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }


    /* @Column(name = "tms_drivercode", nullable = false, length = 20)

   public String getTmsDriverCode() {
        return tmsDriverCode;
    }

    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }
    */

    @Column(name = "tms_driverpassportNumber", nullable = false, length = 20)

    public String getTmsDriverPassportNumber() {
        return tmsDriverPassportNumber;
    }

    public void setTmsDriverPassportNumber(String tmsDriverPassportNumber) {
        this.tmsDriverPassportNumber = tmsDriverPassportNumber;
    }
    /*  @Column(name = "tms_driverpassportLink", nullable = false, length = 20)
/*
      public String getTmsDriverPassportLink() {
          return tmsDriverPassportLink;
      }

      public void setTmsDriverPassportLink(String tmsDriverPassportLink) {
          this.tmsDriverPassportLink = tmsDriverPassportLink;
      }
    @Column(name = "tms_tmsDriverLastName", nullable = false, length = 20)

    public String getTmsDriverLastName() {
        return tmsDriverLastName;
    }

    public void setTmsDriverLastName(String tmsDriverLastName) {
        this.tmsDriverLastName = tmsDriverLastName;
    }
    @Column(name = "tms_tmsDriverFirstName", nullable = false, length = 20)

    public String getTmsDriverFirstName() {
        return tmsDriverFirstName;
    }

    public void setTmsDriverFirstName(String tmsDriverFirstName) {
        this.tmsDriverFirstName = tmsDriverFirstName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_tmsDriverBirthDay")

    public Date getTmsDriverBirthDay() {
        return tmsDriverBirthDay;
    }

    public void setTmsDriverBirthDay(Date tmsDriverBirthDay) {
        this.tmsDriverBirthDay = tmsDriverBirthDay;
    }
    @Column(name = "tms_tmsDriverCellPhone", nullable = false, length = 20)

    public String getTmsDriverCellPhone() {
        return tmsDriverCellPhone;
    }

    public void setTmsDriverCellPhone(String tmsDriverCellPhone) {
        this.tmsDriverCellPhone = tmsDriverCellPhone;
    }*/

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsIncidentDriver")

    public Set<TmsIncident> getPincidents() {
        return pincidents;
    }

    public void setPincidents(Set<TmsIncident> pincidents) {
        this.pincidents = pincidents;
    }
   /* @Column(name="tms_roadDriver",nullable=false)

    public Set<TmsRoad> getProads() {
        return proads;
    }

    public void setProads(Set<TmsRoad> proads) {
        this.proads = proads;
    }*/

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsBadgeDriver")
    public Set<TmsBadge> getPbadges() {
        return pbadges;
    }

    public void setPbadges(Set<TmsBadge> pbadges) {
        this.pbadges = pbadges;
    }



    /*
        @Column(name="tms_adresseDriver",nullable=false)

        public Adresse getAdresse() {
            return adresse;
        }

        public void setAdresse(Adresse adresse) {
            this.adresse = adresse;
        }*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driversituationid")
    public TmsDriverSituation getTmsDriverSituation() {
        return tmsDriverSituation;
    }

    public void setTmsDriverSituation(TmsDriverSituation tmsDriverSituation) {
        this.tmsDriverSituation = tmsDriverSituation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_driverdatecreation")
    public Date getTmsDriverDateCreation() {
        return tmsDriverDateCreation;
    }

    public void setTmsDriverDateCreation(Date tmsDriverDateCreation) {
        this.tmsDriverDateCreation = tmsDriverDateCreation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_driverdateupdate")
    public Date getTmsDriverDateUpDate() {
        return tmsDriverDateUpDate;
    }

    public void setTmsDriverDateUpDate(Date tmsDriverDateUpDate) {
        this.tmsDriverDateUpDate = tmsDriverDateUpDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_drivercreationuserid")
    public UsrUser getTmsDriverCreationUser() {
        return tmsDriverCreationUser;
    }

    public void setTmsDriverCreationUser(UsrUser tmsDriverCreationUser) {
        this.tmsDriverCreationUser = tmsDriverCreationUser;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverupdateuserid")
    public UsrUser getTmsDriverUpDateUser() {
        return tmsDriverUpDateUser;
    }

    public void setTmsDriverUpDateUser(UsrUser tmsDriverUpDateUser) {
        this.tmsDriverUpDateUser = tmsDriverUpDateUser;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsDriverBadgeBadge")
    public Set<TmsDriverBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsDriverBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }
}
