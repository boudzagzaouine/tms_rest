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
public class PrmVehicleType implements Serializable {
    private long prmVehicleTypeId;
    @Size(max = 30)
    @NotNull
    private String prmVehicleTypeCode;
    @Size(max = 100)
    @NotNull
    private String prmVehicleTypeType;
    @NotNull
    private Set<PrmVehicle> prmVehicleTypeVehicules;

    public PrmVehicleType() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "prm_vehicletypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmVehicleTypeId() {
        return prmVehicleTypeId;
    }

    public void setPrmVehicleTypeId(long prmVehicleTypeId) {
        this.prmVehicleTypeId = prmVehicleTypeId;
    }
    @Column(name = "prm_vehicletypecode", nullable = false, length = 30)
    public String getPrmVehicleTypeCode() {
        return prmVehicleTypeCode;
    }

    public void setPrmVehicleTypeCode(String prmVehicleTypeCode) {
        this.prmVehicleTypeCode = prmVehicleTypeCode;
    }
    @Column(name = "prm_vehicletypetype")
    public String getPrmVehicleTypeType() {
        return prmVehicleTypeType;
    }

    public void setPrmVehicleTypeType(String prmVehicleTypeType) {
        this.prmVehicleTypeType = prmVehicleTypeType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehicletypevehicleid", nullable = false)
    public Set<PrmVehicle> getPrmVehicleTypeVehicules() {
        return prmVehicleTypeVehicules;
    }

    public void setPrmVehicleTypeVehicules(Set<PrmVehicle> prmVehicleTypeVehicules) {
        this.prmVehicleTypeVehicules = prmVehicleTypeVehicules;
    }

}
