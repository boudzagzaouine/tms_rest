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
@Table(name = "tms_driverbadge")
public class TmsDriverBadge implements Serializable {
    private long tmsDriverBadgeId;
    @NotNull
    private TmsBadge tmsDriverBadgeBadge;
    @NotNull
    private TmsDriver tmsDriverBadgeDriver;

    public TmsDriverBadge() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name="tms_driverbadgeid",unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsDriverBadgeId() {
        return tmsDriverBadgeId;
    }

    public void setTmsDriverBadgeId(long tmsDriverBadgeId) {
        this.tmsDriverBadgeId = tmsDriverBadgeId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverbadgebadgeid", nullable = false)
    public TmsBadge getTmsDriverBadgeBadge() {
        return tmsDriverBadgeBadge;
    }

    public void setTmsDriverBadgeBadge(TmsBadge tmsDriverBadgeBadge) {
        this.tmsDriverBadgeBadge = tmsDriverBadgeBadge;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverbadgedriverid", nullable = false)
    public TmsDriver getTmsDriverBadgeDriver() {
        return tmsDriverBadgeDriver;
    }

    public void setTmsDriverBadgeDriver(TmsDriver tmsDriverBadgeDriver) {
        this.tmsDriverBadgeDriver = tmsDriverBadgeDriver;
    }
}
