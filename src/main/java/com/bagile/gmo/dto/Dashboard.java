package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Dashboard extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private long month;
    private BigDecimal value;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

   /*  public Maintenance getMaintenancePlan() {
        return maintenancePlan;
    }

    public void setMaintenancePlan(Maintenance maintenancePlan) {
        this.maintenancePlan = maintenancePlan;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dashboard badgeType = (Dashboard) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
