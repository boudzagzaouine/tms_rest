package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaintenancePlan extends EmsDto implements Serializable {


    /**
     *
     */

    private static final long serialVersionUID = 6036580510935986433L;
    private long id;
    private String code;
    private String description;
    private List<ActionPlan> actionPlans    = new ArrayList<>();


    public MaintenancePlan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ActionPlan> getActionPlans() {
        return actionPlans;
    }

    public void setActionPlans(List<ActionPlan> actionPlans) {
        this.actionPlans = actionPlans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        MaintenancePlan that = (MaintenancePlan) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
}
