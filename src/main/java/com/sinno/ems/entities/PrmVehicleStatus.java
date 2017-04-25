package com.sinno.ems.entities;

import com.sinno.ems.dto.Vehicule;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
public class PrmVehicleStatus implements Serializable {
    private long prmVehiculeStatusId;
    @Size(max = 30)
    @NotNull
    private String prmVehiculeStatusCode;
    @Size(max = 30)
    private String prmVehiculeStatusActivity;
    @Size(max = 255)
    private String prmVehiculeStatusDescritpion;
    @NotNull
    private Set<PrmVehicle> prmVehiculeStatusVehicules;

    public PrmVehicleStatus() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "prm_vehiclestatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmVehiculeStatusId() {
        return prmVehiculeStatusId;
    }

    public void setPrmVehiculeStatusId(long prmVehiculeStatusId) {
        this.prmVehiculeStatusId = prmVehiculeStatusId;
    }
    @Column(name = "prm_vehiclestatuscode", nullable = false, length = 30)
    public String getPrmVehiculeStatusCode() {
        return prmVehiculeStatusCode;
    }

    public void setPrmVehiculeStatusCode(String prmVehiculeStatusCode) {
        this.prmVehiculeStatusCode = prmVehiculeStatusCode;
    }
    @Column(name = "prm_vehiclestatusactivity", nullable = false, length = 30)
    public String getPrmVehiculeStatusActivity() {
        return prmVehiculeStatusActivity;
    }

    public void setPrmVehiculeStatusActivity(String prmVehiculeStatusActivity) {
        this.prmVehiculeStatusActivity = prmVehiculeStatusActivity;
    }
    @Column(name = "prm_vehiclestatusdescription", nullable = false, length = 30)
    public String getPrmVehiculeStatusDescritpion() {
        return prmVehiculeStatusDescritpion;
    }

    public void setPrmVehiculeStatusDescritpion(String prmVehiculeStatusDescritpion) {
        this.prmVehiculeStatusDescritpion = prmVehiculeStatusDescritpion;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "")
    @JoinColumn(name = "prm_vehiclestatusvehicleid", nullable = false)
    public Set<PrmVehicle> getPrmVehiculeStatusVehicules() {
        return prmVehiculeStatusVehicules;
    }

    public void setPrmVehiculeStatusVehicules(Set<PrmVehicle> prmVehiculeStatusVehicules) {
        this.prmVehiculeStatusVehicules = prmVehiculeStatusVehicules;
    }

}
