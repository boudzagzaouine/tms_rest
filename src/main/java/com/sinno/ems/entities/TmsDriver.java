package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by khalil on 16/03/2017.
 */
@Entity
@Table(name = "tms_driver")

public class TmsDriver implements java.io.Serializable {
    private long tmsDriverId;

    @Size(max = 255)
    private String tmsDriverPassportNumber;
    private PrmContact prmContact;
    private Set<TmsIncident> pincidents;
     private AdrAddress adrAddress;
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




    @Column(name = "tms_driverpassportNumber", nullable = false, length = 20)

    public String getTmsDriverPassportNumber() {
        return tmsDriverPassportNumber;
    }

    public void setTmsDriverPassportNumber(String tmsDriverPassportNumber) {
        this.tmsDriverPassportNumber = tmsDriverPassportNumber;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsIncidentDriver")

    public Set<TmsIncident> getPincidents() {
        return pincidents;
    }

    public void setPincidents(Set<TmsIncident> pincidents) {
        this.pincidents = pincidents;
    }


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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsDriverBadgeDriver")
    public Set<TmsDriverBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsDriverBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tms_driveraddressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tms_drivercontactid")
    public PrmContact getPrmContact() {
        return prmContact;
    }

    public void setPrmContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }
}
