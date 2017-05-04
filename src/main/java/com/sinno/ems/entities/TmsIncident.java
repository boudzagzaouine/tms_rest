package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by khalil on 22/03/2017.
 */
@Entity
@Table(name="tms_incident",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_incidentcode","tms_incidentid"}))

public class TmsIncident implements java.io.Serializable {
    private long tmsIncidentId;
    @NotNull
    private String tmsIncidentCode;
    private Date tmsIncidentTime;
    private String tmsIncidentDescription;
    private TmsNatureIncident tmsIncidentNature;
    private TmsRoad tmsIncidentRoad;
    private TmsDriver tmsIncidentDriver;

    public TmsIncident(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_incidentid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsIncidentId() {
        return tmsIncidentId;
    }

    public void setTmsIncidentId(long tmsIncidentId) {
        this.tmsIncidentId = tmsIncidentId;
    }
    @Column(name = "tms_incidentcode", nullable = false, length = 30)

    public String getTmsIncidentCode() {
        return tmsIncidentCode;
    }

    public void setTmsIncidentCode(String tmsIncidentCode) {
        this.tmsIncidentCode = tmsIncidentCode;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tmsIncidentTime")

    public Date getTmsIncidentTime() {
        return tmsIncidentTime;
    }

    public void setTmsIncidentTime(Date tmsIncidentTime) {
        this.tmsIncidentTime = tmsIncidentTime;
    }
    @Column(name = "tms_incidentdescription", nullable = false, length = 30)

    public String getTmsIncidentDescription() {
        return tmsIncidentDescription;
    }

    public void setTmsIncidentDescription(String tmsIncidentDescription) {
        this.tmsIncidentDescription = tmsIncidentDescription;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tms_incidentnatureid")
    public TmsNatureIncident getTmsIncidentNature() {
        return tmsIncidentNature;
    }

    public void setTmsIncidentNature(TmsNatureIncident tmsIncidentNature) {
        this.tmsIncidentNature = tmsIncidentNature;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_incidentroadid", nullable = false)
    public TmsRoad getTmsIncidentRoad() {
        return tmsIncidentRoad;
    }

    public void setTmsIncidentRoad(TmsRoad tmsIncidentRoad) {
        this.tmsIncidentRoad = tmsIncidentRoad;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_incidentdriverid", nullable = false)
    public TmsDriver getTmsIncidentDriver() {
        return tmsIncidentDriver;
    }

    public void setTmsIncidentDriver(TmsDriver tmsIncidentDriver) {
        this.tmsIncidentDriver = tmsIncidentDriver;
    }


}
