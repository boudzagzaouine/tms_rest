package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
public class TmsVehicleType implements Serializable {
    private long prmVehicleTypeId;
    @Size(max = 30)
    @NotNull
    private String prmVehicleTypeCode;
    @Size(max = 100)
    @NotNull
    private String prmVehicleTypeType;
    @NotNull
    private Set<TmsVehicle> tmsVehicleTypeVehicules;

    public TmsVehicleType() {

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
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmVehicleType")
    public Set<TmsVehicle> getTmsVehicleTypeVehicules() {
        return tmsVehicleTypeVehicules;
    }

    public void setTmsVehicleTypeVehicules(Set<TmsVehicle> tmsVehicleTypeVehicules) {
        this.tmsVehicleTypeVehicules = tmsVehicleTypeVehicules;
    }

}
