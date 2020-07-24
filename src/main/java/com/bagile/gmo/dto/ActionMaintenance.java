package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ActionMaintenance extends EmsDto {

	private static final long serialVersionUID = -2523885174048641991L;

	private long id;
	private ActionType actionType;
	private MaintenanceState maintenanceState;
    private Maintenance maintenance ;
    private List<ActionLineMaintenance> actionLineMaintenances = new ArrayList <>() ;



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public ActionType getActionType() {
        return actionType;
    }
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public List<ActionLineMaintenance> getActionLineMaintenances() {
        return actionLineMaintenances;
    }

    public void setActionLineMaintenances(List<ActionLineMaintenance> actionLineMaintenances) {
        this.actionLineMaintenances = actionLineMaintenances;
    }

    public MaintenanceState getMaintenanceState() {
        return maintenanceState;
    }
    public void setMaintenanceState(MaintenanceState maintenanceState) {
        this.maintenanceState = maintenanceState;
    }


    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        ActionMaintenance that = (ActionMaintenance) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
    
}
