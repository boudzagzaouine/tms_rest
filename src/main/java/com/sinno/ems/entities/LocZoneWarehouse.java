package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by adadi on 6/21/2016.
 */
@Entity
@Table(name = "loc_zone_warehouse")
public class LocZoneWarehouse {
    private long locZoneWarehouseId;
    @NotNull
    private LocZone locZone;
    @NotNull
    private WrhWarehouse wrhWarehouse;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "loc_zone_warehouse_loc_zone_warehouse_seq", allocationSize = 1)
    @Column(name = "loc_zone_warehouse_id")
    public long getLocZoneWarehouseId() {
        return locZoneWarehouseId;
    }

    public void setLocZoneWarehouseId(long locZoneWarehouseId) {
        this.locZoneWarehouseId = locZoneWarehouseId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loc_zone", nullable = false)
    public LocZone getLocZone() {
        return locZone;
    }

    public void setLocZone(LocZone locZone) {
        this.locZone = locZone;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wrh_warehouse", nullable = false)
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }
}
