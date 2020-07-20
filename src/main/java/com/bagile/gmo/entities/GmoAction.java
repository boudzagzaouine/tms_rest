package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="gmo_action")
public class GmoAction extends EmsEntity {

	private static final long serialVersionUID = -6143066188263513604L;
	private long gmoActionId;
    private GmoActionType gmoActionType;
    private GmoMaintenance gmoMaintenance;
    private GmoMaintenancePlan gmoMaintenancePlan;

    private GmoMaintenanceState gmoMaintenanceState ;
    private Set<GmoActionLine> gmoActionLines = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_gmo_action_id", allocationSize = 1)
    @Column(name = "gmo_actionid")
    public long getGmoActionId() {
        return gmoActionId;
    }

    public void setGmoActionId(long gmoMaintenanceLineId) {
        this.gmoActionId = gmoMaintenanceLineId;
    }



    @OneToMany(mappedBy = "gmoAction", cascade = CascadeType.ALL,fetch = FetchType.LAZY , orphanRemoval=true)
    public Set<GmoActionLine> getGmoActionLines() {
        return gmoActionLines;
    }

    public void setGmoActionLines(Set<GmoActionLine> gmoActionLine) {
        this.gmoActionLines = gmoActionLine;
    }






    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_actiontypeid")

    public GmoActionType getGmoActionType() {
        return gmoActionType;
    }

    public void setGmoActionType(GmoActionType gmoActionType) {
        this.gmoActionType = gmoActionType;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_maintenancestateid")
    public GmoMaintenanceState getGmoMaintenanceState() {
        return gmoMaintenanceState;
    }

    public void setGmoMaintenanceState(GmoMaintenanceState gmoMaintenanceState) {
        this.gmoMaintenanceState = gmoMaintenanceState;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_maintenanceid")
    public GmoMaintenance getGmoMaintenance() {
        return gmoMaintenance;
    }

    public void setGmoMaintenance(GmoMaintenance gmoMaintenancePlan) {
        this.gmoMaintenance = gmoMaintenancePlan;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_maintenanceplanid")
    public GmoMaintenancePlan getGmoMaintenancePlan() {
        return gmoMaintenancePlan;
    }

    public void setGmoMaintenancePlan(GmoMaintenancePlan gmoMaintenancePreventive) {
        this.gmoMaintenancePlan = gmoMaintenancePreventive;
    }
}
