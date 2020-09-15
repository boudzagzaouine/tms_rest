package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="gmo_actionmaintenance")
public class GmoActionMaintenance extends EmsEntity {

	private static final long serialVersionUID = -6143066188263513604L;
	private long gmoActionMaintenanceId;
    private GmoActionType gmoActionType;
    private GmoMaintenance gmoMaintenance;
    private GmoMaintenanceState gmoMaintenanceState ;
    private Set<GmoActionLineMaintenance> gmoActionLineMaintenances = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_gmo_action_maintenance_id", allocationSize = 1)
    @Column(name = "gmo_actionmaintenanceid")
    public long getGmoActionMaintenanceId() {
        return gmoActionMaintenanceId;
    }

    public void setGmoActionMaintenanceId(long gmoMaintenanceLineId) {
        this.gmoActionMaintenanceId = gmoMaintenanceLineId;
    }

    @OneToMany(mappedBy = "gmoActionMaintenance", cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE} , orphanRemoval=true)
    public Set<GmoActionLineMaintenance> getGmoActionLineMaintenances() {
        return gmoActionLineMaintenances;
    }

    public void setGmoActionLineMaintenances(Set<GmoActionLineMaintenance> gmoActionLineMaintenances) {
        this.gmoActionLineMaintenances = gmoActionLineMaintenances;
    }




    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_actiontypeid")
    public GmoActionType getGmoActionType() {
        return gmoActionType;
    }

    public void setGmoActionType(GmoActionType gmoActionType) {
        this.gmoActionType = gmoActionType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenancestateid")
    public GmoMaintenanceState getGmoMaintenanceState() {
        return gmoMaintenanceState;
    }

    public void setGmoMaintenanceState(GmoMaintenanceState gmoMaintenanceState) {
        this.gmoMaintenanceState = gmoMaintenanceState;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceid")
    public GmoMaintenance getGmoMaintenance() {
        return gmoMaintenance;
    }

    public void setGmoMaintenance(GmoMaintenance gmoMaintenancePlan) {
        this.gmoMaintenance = gmoMaintenancePlan;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GmoActionMaintenance gmoAction = (GmoActionMaintenance) o;
        return gmoActionMaintenanceId == gmoAction.gmoActionMaintenanceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gmoActionMaintenanceId);
    }
}
