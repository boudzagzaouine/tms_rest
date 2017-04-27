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
    private long drvDriverBadgeId;
    @NotNull
    private TmsBadge drvDriverBadgeBadge;
    @NotNull
    private TmsDriver drvDriverBadgeDriver;

    public DrvDriverBadge() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name="drv_driverbadgeid",unique = true, nullable = false, precision = 10, scale = 0)
    public long getDrvDriverBadgeId() {
        return drvDriverBadgeId;
    }

    public void setDrvDriverBadgeId(long drvDriverBadgeId) {
        this.drvDriverBadgeId = drvDriverBadgeId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drv_driverbadgebadgeid", nullable = false)
    public TmsBadge getDrvDriverBadgeBadge() {
        return drvDriverBadgeBadge;
    }

    public void setDrvDriverBadgeBadge(TmsBadge drvDriverBadgeBadge) {
        this.drvDriverBadgeBadge = drvDriverBadgeBadge;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drv_driverbadgedriverid", nullable = false)
    public TmsDriver getDrvDriverBadgeDriver() {
        return drvDriverBadgeDriver;
    }

    public void setDrvDriverBadgeDriver(TmsDriver drvDriverBadgeDriver) {
        this.drvDriverBadgeDriver = drvDriverBadgeDriver;
    }
}
