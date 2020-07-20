package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Action extends EmsDto {

	private static final long serialVersionUID = -2523885174048641991L;

	private long id;
	private ActionType actionType;
	private MaintenanceState maintenanceState;
    private Maintenance maintenancePlan ;
    private List<ActionLine> actionLines = new ArrayList <>() ;



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

    public List<ActionLine> getActionLines() {
        return actionLines;
    }

    public void setActionLines(List<ActionLine> actionLines) {
        this.actionLines = actionLines;
    }

    public MaintenanceState getMaintenanceState() {
        return maintenanceState;
    }
    public void setMaintenanceState(MaintenanceState maintenanceState) {
        this.maintenanceState = maintenanceState;
    }
    public Maintenance getMaintenancePlan() {
        return maintenancePlan;
    }
    public void setMaintenancePlan(Maintenance maintenancePlan) {
        this.maintenancePlan = maintenancePlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        Action that = (Action) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
    
}
