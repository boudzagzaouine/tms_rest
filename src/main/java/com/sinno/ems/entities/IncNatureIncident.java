package com.sinno.ems.entities;

import com.sinno.ems.dto.Incident;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "inc_natureincident")
public class IncNatureIncident implements java.io.Serializable  {

    private long incNatureIncidentId;
    @NotNull
    private Set<Incident> incidents;
    @Size(max = 30)
    @NotNull
    private String incNatureIncidentCode;
    @Size(max = 255)
    private String incNatureIncidentDescription;

    public IncNatureIncident(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_inc_natureincident", allocationSize = 1)
    @Column(name = "inc_natureincidentid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getIncNatureIncidentId() {
        return incNatureIncidentId;
    }

    public void setIncNatureIncidentId(long incNatureIncidentId) {
        this.incNatureIncidentId = incNatureIncidentId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inc_incidentid", nullable = false)

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }
    @Column(name = "inc_natureincidentcode", nullable = false, length = 30)
    public String getIncNatureIncidentCode() {
        return incNatureIncidentCode;
    }

    public void setIncNatureIncidentCode(String incNatureIncidentCode) {
        this.incNatureIncidentCode = incNatureIncidentCode;
    }
    @Column(name = "inc_natureincidentdescription")
    public String getIncNatureIncidentDescription() {
        return incNatureIncidentDescription;
    }

    public void setIncNatureIncidentDescription(String incNatureIncidentDescription) {
        this.incNatureIncidentDescription = incNatureIncidentDescription;
    }

}
