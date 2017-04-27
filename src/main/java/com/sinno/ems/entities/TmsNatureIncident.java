package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "tms_naturetmsident")
public class TmsNatureIncident implements java.io.Serializable  {

    private long tmsNatureIncidentId;
    @NotNull
    private Set<TmsIncident> tmsidents;
    @Size(max = 30)
    @NotNull
    private String tmsNatureIncidentCode;
    @Size(max = 255)
    private String tmsNatureIncidentDescription;

    public TmsNatureIncident(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_naturetmsidentid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getIncNatureIncidentId() {
        return tmsNatureIncidentId;
    }

    public void setIncNatureIncidentId(long tmsNatureIncidentId) {
        this.tmsNatureIncidentId = tmsNatureIncidentId;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmIncidentNature")

    public Set<TmsIncident> getIncidents() {
        return tmsidents;
    }

    public void setIncidents(Set<TmsIncident> tmsidents) {
        this.tmsidents = tmsidents;
    }
    @Column(name = "tms_naturetmsidentcode", nullable = false, length = 30)
    public String getIncNatureIncidentCode() {
        return tmsNatureIncidentCode;
    }

    public void setIncNatureIncidentCode(String tmsNatureIncidentCode) {
        this.tmsNatureIncidentCode = tmsNatureIncidentCode;
    }
    @Column(name = "tms_naturetmsidentdescription")
    public String getIncNatureIncidentDescription() {
        return tmsNatureIncidentDescription;
    }

    public void setIncNatureIncidentDescription(String tmsNatureIncidentDescription) {
        this.tmsNatureIncidentDescription = tmsNatureIncidentDescription;
    }


}
