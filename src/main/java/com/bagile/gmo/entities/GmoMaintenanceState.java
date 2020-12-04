package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_maintenancestate")
public class GmoMaintenanceState  extends EmsEntity {

    private static final long serialVersionUID = 6583945389627755380L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenancestateid", allocationSize = 1)
    @Column(name = "gmo_maintenancestateid", unique = true, nullable = false, length = 90, precision = 10, scale = 0)
    private Long gmoMaintenanceStateId;
    @Column(name = "gmo_maintenancestatecode", unique = true, nullable = false, length = 90)
    private String gmoMaintenanceStateCode;
    @Column(name = "gmo_maintenancestatedescription")
    private String gmoMaintenanceStateDescription;

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    private OwnOwner ownOwner;

    public GmoMaintenanceState() {
    }

    public Long getGmoMaintenanceStateId() {
        return gmoMaintenanceStateId;
    }

    public void setGmoMaintenanceStateId(Long gmoMaintenanceStateId) {
        this.gmoMaintenanceStateId = gmoMaintenanceStateId;
    }

    public String getGmoMaintenanceStateCode() {
        return gmoMaintenanceStateCode;
    }

    public void setGmoMaintenanceStateCode(String gmoMaintenanceStateCode) {
        this.gmoMaintenanceStateCode = gmoMaintenanceStateCode;
    }

    public String getGmoMaintenanceStateDescription() {
        return gmoMaintenanceStateDescription;
    }

    public void setGmoMaintenanceStateDescription(String gmoMaintenanceStateDescription) {
        this.gmoMaintenanceStateDescription = gmoMaintenanceStateDescription;
    }

    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
