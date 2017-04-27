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
@Table(name = "prm_driver", uniqueConstraints = @UniqueConstraint(columnNames = {"prm_driverecode","prm_driverid"}))

public class TmsDriver implements java.io.Serializable{
    private long prmDriverId;

    @Size(max = 255)
    private String prmDriverPassportNumber;

    private Set<TmsIncident> pincidents;
    private Set<TmsBadge> pbadges;
    //  private Adresse adresse;
  private Date prmDriverDateCreation;
    private Date prmDriverDateUpDate;
    private UsrUser prmDriverCreationUser;
    private UsrUser prmDriverUpDateUser;
    @Size(max = 30)
    @NotNull
    private TmsDriverSituation tmsDriverSituation;

    private Set<TmsDriverBadge> tmsDriverBadges;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "prm_driverid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrmDriverId() {
        return prmDriverId;
    }

    public void setPrmDriverId(long prmDriverId) {
        this.prmDriverId = prmDriverId;
    }


    /* @Column(name = "prm_drivercode", nullable = false, length = 20)

   public String getPrmDriverCode() {
        return prmDriverCode;
    }

    public void setPrmDriverCode(String prmDriverCode) {
        this.prmDriverCode = prmDriverCode;
    }
    */

    @Column(name = "prm_driverpassportNumber", nullable = false, length = 20)

    public String getPrmDriverPassportNumber() {
        return prmDriverPassportNumber;
    }

    public void setPrmDriverPassportNumber(String prmDriverPassportNumber) {
        this.prmDriverPassportNumber = prmDriverPassportNumber;
    }
    /*  @Column(name = "prm_driverpassportLink", nullable = false, length = 20)
/*
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
    }*/

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmIncidentDriver")

    public Set<TmsIncident> getPincidents() {
        return pincidents;
    }

    public void setPincidents(Set<TmsIncident> pincidents) {
        this.pincidents = pincidents;
    }
   /* @Column(name="prm_roadDriver",nullable=false)

    public Set<TmsRoad> getProads() {
        return proads;
    }

    public void setProads(Set<TmsRoad> proads) {
        this.proads = proads;
    }*/

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmBadgeDriver")
    public Set<TmsBadge> getPbadges() {
        return pbadges;
    }

    public void setPbadges(Set<TmsBadge> pbadges) {
        this.pbadges = pbadges;
    }



    /*
        @Column(name="prm_adresseDriver",nullable=false)

        public Adresse getAdresse() {
            return adresse;
        }

        public void setAdresse(Adresse adresse) {
            this.adresse = adresse;
        }*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_driversituationid")
    public TmsDriverSituation getTmsDriverSituation() {
        return tmsDriverSituation;
    }

    public void setTmsDriverSituation(TmsDriverSituation tmsDriverSituation) {
        this.tmsDriverSituation = tmsDriverSituation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_driverdatecreation")
    public Date getPrmDriverDateCreation() {
        return prmDriverDateCreation;
    }

    public void setPrmDriverDateCreation(Date prmDriverDateCreation) {
        this.prmDriverDateCreation = prmDriverDateCreation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_driverdateupdate")
    public Date getPrmDriverDateUpDate() {
        return prmDriverDateUpDate;
    }

    public void setPrmDriverDateUpDate(Date prmDriverDateUpDate) {
        this.prmDriverDateUpDate = prmDriverDateUpDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_drivercreationuserid")
    public UsrUser getPrmDriverCreationUser() {
        return prmDriverCreationUser;
    }

    public void setPrmDriverCreationUser(UsrUser prmDriverCreationUser) {
        this.prmDriverCreationUser = prmDriverCreationUser;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_driverupdateuserid")
    public UsrUser getPrmDriverUpDateUser() {
        return prmDriverUpDateUser;
    }

    public void setPrmDriverUpDateUser(UsrUser prmDriverUpDateUser) {
        this.prmDriverUpDateUser = prmDriverUpDateUser;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "drvDriverBadgeBadge")
    public Set<TmsDriverBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsDriverBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }
}
