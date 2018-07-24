package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * Created by khalil on 23/03/2017.
 */
@Entity
@Table(name="tms_DriverSituation",uniqueConstraints = @UniqueConstraint(columnNames={"tms_driversituationcode","tms_driverid"}))
public class TmsDriverSituation implements java.io.Serializable {
    private long tmsDriverId;
    @NotNull
    private String tmsDriverSituationCode;
    private String tmsDriverSituationDescription;
    private Set<TmsDriver> tmsDrivers;
    public TmsDriverSituation(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name="tms_driverid",unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }
    @Column(name="tms_driversituationcode",unique = true, nullable = false, precision = 10, scale = 0)

    public String getTmsDriverSituationCode() {
        return tmsDriverSituationCode;
    }

    public void setTmsDriverSituationCode(String tmsDriverSituationCode) {
        this.tmsDriverSituationCode = tmsDriverSituationCode;
    }

    @Column(name="tms_driversituationdescription",unique = true, nullable = false, precision = 10, scale = 0)

    public String getTmsDriverSituationDescription() {
        return tmsDriverSituationDescription;
    }

    public void setTmsDriverSituationDescription(String tmsDriverSituationDescription) {
        this.tmsDriverSituationDescription = tmsDriverSituationDescription;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsDriverSituation")

    public Set<TmsDriver> getTmsDrivers() {
        return tmsDrivers;
    }

    public void setTmsDrivers(Set<TmsDriver> tmsDrivers) {
        this.tmsDrivers = tmsDrivers;
    }
}
