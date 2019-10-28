package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_maintenancetype")
public class TmsMaintenanceType  extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = 3900860221690635278L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_maintenance_type_id", allocationSize = 1)
    @Column(name = "tms_maintenancetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long tmsMaintenanceTypeId;
    @Column(name = "tms_maintenancetypecode")
    private String tmsMaintenanceTypeCode;
    @Column(name = "tms_maintenancetypedescription")
    private String tmsMaintenanceTypeDescription;


    public TmsMaintenanceType() {
    }

    public Long getTmsMaintenanceTypeId() {
        return tmsMaintenanceTypeId;
    }

    public void setTmsMaintenanceTypeId(Long tmsMaintenanceTypeId) {
        this.tmsMaintenanceTypeId = tmsMaintenanceTypeId;
    }

    public String getTmsMaintenanceTypeCode() {
        return tmsMaintenanceTypeCode;
    }

    public void setTmsMaintenanceTypeCode(String tmsMaintenanceTypeCode) {
        this.tmsMaintenanceTypeCode = tmsMaintenanceTypeCode;
    }

    public String getTmsMaintenanceTypeDescription() {
        return tmsMaintenanceTypeDescription;
    }

    public void setTmsMaintenanceTypeDescription(String tmsMaintenanceTypeDescription) {
        this.tmsMaintenanceTypeDescription = tmsMaintenanceTypeDescription;
    }
}
