package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by khalil on 22/03/2017.
 */
@Entity
@Table(name="prm_incident",uniqueConstraints = @UniqueConstraint(columnNames = {"prm_incidentcode","prm_incidentid"}))

public class TmsIncident implements java.io.Serializable {
    private long prmIncidentId;
    @NotNull
    private String prmIncidentCode;
    private Date prmIncidentTime;
    private String prmIncidentDescription;
    private IncNatureIncident prmIncidentNature;
    private TmsRoad prmIncidentRoad;
    private TmsDriver prmIncidentDriver;

    public TmsIncident(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "prm_incidentid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrmIncidentId() {
        return prmIncidentId;
    }

    public void setPrmIncidentId(long prmIncidentId) {
        this.prmIncidentId = prmIncidentId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "prm_incidentcode", nullable = false, length = 30)

    public String getPrmIncidentCode() {
        return prmIncidentCode;
    }

    public void setPrmIncidentCode(String prmIncidentCode) {
        this.prmIncidentCode = prmIncidentCode;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prmIncidentTime")

    public Date getPrmIncidentTime() {
        return prmIncidentTime;
    }

    public void setPrmIncidentTime(Date prmIncidentTime) {
        this.prmIncidentTime = prmIncidentTime;
    }
    @Column(name = "prm_incidentdescription", nullable = false, length = 30)

    public String getPrmIncidentDescription() {
        return prmIncidentDescription;
    }

    public void setPrmIncidentDescription(String prmIncidentDescription) {
        this.prmIncidentDescription = prmIncidentDescription;
    }

    public IncNatureIncident getPrmIncidentNature() {
        return prmIncidentNature;
    }

    public void setPrmIncidentNature(IncNatureIncident prmIncidentNature) {
        this.prmIncidentNature = prmIncidentNature;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_incidentroadid", nullable = false)
    public TmsRoad getPrmIncidentRoad() {
        return prmIncidentRoad;
    }

    public void setPrmIncidentRoad(TmsRoad prmIncidentRoad) {
        this.prmIncidentRoad = prmIncidentRoad;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_incidentdriverid", nullable = false)
    public TmsDriver getPrmIncidentDriver() {
        return prmIncidentDriver;
    }

    public void setPrmIncidentDriver(TmsDriver prmIncidentDriver) {
        this.prmIncidentDriver = prmIncidentDriver;
    }


}
