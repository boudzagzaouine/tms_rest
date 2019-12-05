package com.bagile.tms.entities;

import javax.persistence.*;

@Entity
@Table(name="tms_maintenancestate")
public class TmsMaintenanceState  extends EmsEntity {

    private static final long serialVersionUID = 6583945389627755380L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_maintenancestateid", allocationSize = 1)
    @Column(name = "tms_maintenancestateid", unique = true, nullable = false, length = 90, precision = 10, scale = 0)
    private Long tmsMaintenanceStateId;
    @Column(name = "tms_maintenancestatecode", unique = true, nullable = false, length = 90)
    private String tmsMaintenanceStateCode;
    @Column(name = "tms_maintenancestatedescription")
    private String tmsMaintenanceStateDescription;

    public TmsMaintenanceState() {
    }

    public Long getTmsMaintenanceStateId() {
        return tmsMaintenanceStateId;
    }

    public void setTmsMaintenanceStateId(Long tmsMaintenanceStateId) {
        this.tmsMaintenanceStateId = tmsMaintenanceStateId;
    }

    public String getTmsMaintenanceStateCode() {
        return tmsMaintenanceStateCode;
    }

    public void setTmsMaintenanceStateCode(String tmsMaintenanceStateCode) {
        this.tmsMaintenanceStateCode = tmsMaintenanceStateCode;
    }

    public String getTmsMaintenanceStateDescription() {
        return tmsMaintenanceStateDescription;
    }

    public void setTmsMaintenanceStateDescription(String tmsMaintenanceStateDescription) {
        this.tmsMaintenanceStateDescription = tmsMaintenanceStateDescription;
    }


}
