package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name="gmo_maintenancetype")
public class GmoMaintenanceType  extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = 3900860221690635278L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenance_type_id", allocationSize = 1)
    @Column(name = "gmo_maintenancetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoMaintenanceTypeId;
    @Column(name = "gmo_maintenancetypecode", unique = true, nullable = false, length = 90)
    private String gmoMaintenanceTypeCode;
    @Column(name = "gmo_maintenancetypedescription")
    private String gmoMaintenanceTypeDescription;

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    private OwnOwner ownOwner;
    public GmoMaintenanceType() {
    }

    public Long getGmoMaintenanceTypeId() {
        return gmoMaintenanceTypeId;
    }

    public void setGmoMaintenanceTypeId(Long gmoMaintenanceTypeId) {
        this.gmoMaintenanceTypeId = gmoMaintenanceTypeId;
    }

    public String getGmoMaintenanceTypeCode() {
        return gmoMaintenanceTypeCode;
    }

    public void setGmoMaintenanceTypeCode(String gmoMaintenanceTypeCode) {
        this.gmoMaintenanceTypeCode = gmoMaintenanceTypeCode;
    }

    public String getGmoMaintenanceTypeDescription() {
        return gmoMaintenanceTypeDescription;
    }

    public void setGmoMaintenanceTypeDescription(String gmoMaintenanceTypeDescription) {
        this.gmoMaintenanceTypeDescription = gmoMaintenanceTypeDescription;
    }

    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
