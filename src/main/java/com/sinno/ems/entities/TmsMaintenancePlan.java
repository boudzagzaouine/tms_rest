package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "tms_maintenanceplan")
public class TmsMaintenancePlan implements java.io.Serializable{
    private long tmsMaintenancePlanId;
    @NotNull
    private TmsVehicle tmsVehicle;
    @Size(max = 30)
    @NotNull
    private String tmsMaintenancePlanCode;
    @Size(max = 255)
    private String tmsDescription;
    //TODO
/*    private Set<TmsActe> tmsMaintenancePlanActes;*/

    public TmsMaintenancePlan(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsMaintenancePlanId() {
        return tmsMaintenancePlanId;
    }

    public void setTmsMaintenancePlanId(long tmsMaintenancePlanId) {
        this.tmsMaintenancePlanId = tmsMaintenancePlanId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tms_maintenanceplanvehiculeid")
    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
    }

    @Column(name = "tms_maintenanceplancode", nullable = false, length = 30)
    public String getTmsMaintenancePlanCode() {
        return tmsMaintenancePlanCode;
    }
    public void setTmsMaintenancePlanCode(String tmsMaintenancePlanCode) {
        this.tmsMaintenancePlanCode = tmsMaintenancePlanCode;
    }
    @Column(name = "tmsDescription")
    public String getTmsDescription() {
        return tmsDescription;
    }
    public void setTmsDescription(String tmsDescription) {
        this.tmsDescription = tmsDescription;
    }

  /*  @OneToMany(fetch = FetchType.LAZY,mappedBy = "")
    public Set<TmsActe> getTmsMaintenancePlanActes() {
        return tmsMaintenancePlanActes;
    }

    public void setTmsMaintenancePlanActes(Set<TmsActe> tmsMaintenancePlanActes) {
        this.tmsMaintenancePlanActes = tmsMaintenancePlanActes;
    }*/

}
