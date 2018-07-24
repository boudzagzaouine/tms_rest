package com.bagile.tms.entities;

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
    private String codeDriver;
    private com.sinno.ems.entities.PrmContact prmContact;
    private int idDriver;
    private String cin;
    private String lastName;
    private String firstName;
    private string tel;
    private Date yearBorn;
    private Badge badge;
    private Date lastMedicalVisit;
    private Zone workArea;
    private Vacation vacation;
    private double commission;
    private UsrUser tmsDriverCreationUser;
    private UsrUser tmsDriverUpDateUser;
    @Size(max = 30)
    @NotNull
    private TmsDriverSituation tmsDriverSituation;

    private Set<TmsDriverBadge> tmsDriverBadges;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idDriver", unique = true, nullable = false, precision = 10, scale = 0)
    @Column(name = "tms_idDriver", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }


    public String getCodeDriver() {
        return codeDriver;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public String getCin() {
        return cin;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public string getTel() {
        return tel;
    }

    public Date getYearBorn() {
        return yearBorn;
    }

    public Badge getBadge() {
        return badge;
    }

    public Date getLastMedicalVisit() {
        return lastMedicalVisit;
    }

    public Zone getWorkArea() {
        return workArea;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public double getCommission() {
        return commission;
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
    public com.sinno.ems.entities.PrmContact getPrmContact() {
        return prmContact;
    }

    public void setPrmContact(com.sinno.ems.entities.PrmContact prmContact) {
        this.prmContact = prmContact;
    }
}
