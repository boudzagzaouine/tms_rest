package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class VehicleCategoryTray extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1545447956689771754L;
    private long id;
    private VehicleCategory vehicleCategory;
    private VehicleTray vehicleTray;
    public VehicleCategoryTray() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public VehicleTray getVehicleTray() {
        return vehicleTray;
    }

    public void setVehicleTray(VehicleTray vehicleTray) {
        this.vehicleTray = vehicleTray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCategoryTray that = (VehicleCategoryTray) o;
        return getId()==that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
