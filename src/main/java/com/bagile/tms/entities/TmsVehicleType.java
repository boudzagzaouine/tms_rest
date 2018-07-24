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
@Table(name="tms_vehiculetype")
public class TmsVehicleType implements Serializable {
    private long tmsVehicleTypeId;
    @Size(max = 30)
    @NotNull
    private String tmsVehicleTypeCode;
    @Size(max = 100)
    @NotNull
    private String tmsVehicleTypeType;
    @NotNull
    private Set<TmsVehicle> tmsVehicleTypeVehicules;

    public TmsVehicleType() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_vehicletypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehicleTypeId() {
        return tmsVehicleTypeId;
    }

    public void setTmsVehicleTypeId(long tmsVehicleTypeId) {
        this.tmsVehicleTypeId = tmsVehicleTypeId;
    }
    @Column(name = "tms_vehicletypecode", nullable = false, length = 30)
    public String getTmsVehicleTypeCode() {
        return tmsVehicleTypeCode;
    }

    public void setTmsVehicleTypeCode(String tmsVehicleTypeCode) {
        this.tmsVehicleTypeCode = tmsVehicleTypeCode;
    }
    @Column(name = "tms_vehicletypetype")
    public String getTmsVehicleTypeType() {
        return tmsVehicleTypeType;
    }

    public void setTmsVehicleTypeType(String tmsVehicleTypeType) {
        this.tmsVehicleTypeType = tmsVehicleTypeType;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsVehicleType")
    public Set<TmsVehicle> getTmsVehicleTypeVehicules() {
        return tmsVehicleTypeVehicules;
    }

    public void setTmsVehicleTypeVehicules(Set<TmsVehicle> tmsVehicleTypeVehicules) {
        this.tmsVehicleTypeVehicules = tmsVehicleTypeVehicules;
    }

}
