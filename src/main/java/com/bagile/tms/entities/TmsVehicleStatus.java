package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name="tms_vehiculestatus")
public class TmsVehicleStatus implements Serializable {
    private long tmsVehiculeStatusId;
    @Size(max = 30)
    @NotNull
    private String tmsVehiculeStatusCode;
    @Size(max = 30)
    private String tmsVehiculeStatusActivity;
    @Size(max = 255)
    private String tmsVehiculeStatusDescritpion;
    @NotNull
    private Set<TmsVehicle> tmsVehiculeStatusVehicules;

    public TmsVehicleStatus() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_vehiclestatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehiculeStatusId() {
        return tmsVehiculeStatusId;
    }

    public void setTmsVehiculeStatusId(long tmsVehiculeStatusId) {
        this.tmsVehiculeStatusId = tmsVehiculeStatusId;
    }
    @Column(name = "tms_vehiclestatuscode", nullable = false, length = 30)
    public String getTmsVehiculeStatusCode() {
        return tmsVehiculeStatusCode;
    }

    public void setTmsVehiculeStatusCode(String tmsVehiculeStatusCode) {
        this.tmsVehiculeStatusCode = tmsVehiculeStatusCode;
    }
    @Column(name = "tms_vehiclestatusactivity", nullable = false, length = 30)
    public String getTmsVehiculeStatusActivity() {
        return tmsVehiculeStatusActivity;
    }

    public void setTmsVehiculeStatusActivity(String tmsVehiculeStatusActivity) {
        this.tmsVehiculeStatusActivity = tmsVehiculeStatusActivity;
    }
    @Column(name = "tms_vehiclestatusdescription", nullable = false, length = 30)
    public String getTmsVehiculeStatusDescritpion() {
        return tmsVehiculeStatusDescritpion;
    }

    public void setTmsVehiculeStatusDescritpion(String tmsVehiculeStatusDescritpion) {
        this.tmsVehiculeStatusDescritpion = tmsVehiculeStatusDescritpion;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsVehicleStatus")
    public Set<TmsVehicle> getTmsVehiculeStatusVehicules() {
        return tmsVehiculeStatusVehicules;
    }

    public void setTmsVehiculeStatusVehicules(Set<TmsVehicle> tmsVehiculeStatusVehicules) {
        this.tmsVehiculeStatusVehicules = tmsVehiculeStatusVehicules;
    }

}
