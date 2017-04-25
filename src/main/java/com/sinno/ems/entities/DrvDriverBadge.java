package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by bouzi on 4/25/2017.
 *     private long id;
 private Badge badge;
 private Driver driver;
 */
@Entity
@Table(name = "drv_driverbadge")
public class DrvDriverBadge implements Serializable {
    private long driverBadgeId;
    @NotNull
    private PrmBadge driverBadgeBadge;
    @NotNull
    private PrmDriver driverBadgeDriver;

    public DrvDriverBadge() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name="drv_driverbadgeid",unique = true, nullable = false, precision = 10, scale = 0)
    public long getDriverBadgeId() {
        return driverBadgeId;
    }

    public void setDriverBadgeId(long driverBadgeId) {
        this.driverBadgeId = driverBadgeId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drv_driverbadgebadge", nullable = false)
    public PrmBadge getDriverBadgeBadge() {
        return driverBadgeBadge;
    }

    public void setDriverBadgeBadge(PrmBadge driverBadgeBadge) {
        this.driverBadgeBadge = driverBadgeBadge;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drv_driverbadgedriver", nullable = false)
    public PrmDriver getDriverBadgeDriver() {
        return driverBadgeDriver;
    }

    public void setDriverBadgeDriver(PrmDriver driverBadgeDriver) {
        this.driverBadgeDriver = driverBadgeDriver;
    }
}
