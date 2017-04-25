package com.sinno.ems.entities;

import com.sinno.ems.dto.Driver;
import com.sinno.ems.dto.NatureIncident;
import com.sinno.ems.dto.Road;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by khalil on 22/03/2017.
 */
@Entity
@Table(name="prm_incident",uniqueConstraints = @UniqueConstraint(columnNames = {"prm_incidentcode","prm_incidentid"}))

public class PrmIncident implements java.io.Serializable {
    private long prmIncidentId;
    @NotNull
    private String prmIncidentCode;
    private Date prmIncidentTime;
    private String prmIncidentDescription;
    private IncNatureIncident prmIncidentNature;
    private PrmRoad prmRoad;
    private PrmDriver prmDriver;

    public PrmIncident(){

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

    public PrmRoad getPrmRoad() {
        return prmRoad;
    }

    public void setPrmRoad(PrmRoad prmRoad) {
        this.prmRoad = prmRoad;
    }

    public PrmDriver getPrmDriver() {
        return prmDriver;
    }

    public void setPrmDriver(PrmDriver prmDriver) {
        this.prmDriver = prmDriver;
    }


}
