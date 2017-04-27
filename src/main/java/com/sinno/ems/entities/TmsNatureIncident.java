package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "inc_natureincident")
public class TmsNatureIncident implements java.io.Serializable  {

    private long incNatureIncidentId;
    @NotNull
    private Set<TmsIncident> incidents;
    @Size(max = 30)
    @NotNull
    private String incNatureIncidentCode;
    @Size(max = 255)
    private String incNatureIncidentDescription;

    public TmsNatureIncident(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "inc_natureincidentid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getIncNatureIncidentId() {
        return incNatureIncidentId;
    }

    public void setIncNatureIncidentId(long incNatureIncidentId) {
        this.incNatureIncidentId = incNatureIncidentId;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmIncidentNature")

    public Set<TmsIncident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<TmsIncident> incidents) {
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
