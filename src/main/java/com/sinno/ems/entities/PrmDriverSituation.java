package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * Created by khalil on 23/03/2017.
 */
@Entity
@Table(name="prm_DriverSituation",uniqueConstraints = @UniqueConstraint(columnNames={"prm_driversituationcode","prm_driverid"}))
public class PrmDriverSituation implements java.io.Serializable {
    private long prmDriverId;
    @NotNull
    private String prmDriverSituationCode;
    private String prmDriverSituationDescription;
    private Set<PrmDriver> prmDrivers;
    public PrmDriverSituation(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name="prm_driverid",unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrmDriverId() {
        return prmDriverId;
    }

    public void setPrmDriverId(long prmDriverId) {
        this.prmDriverId = prmDriverId;
    }
    @Column(name="prm_driversituationcode",unique = true, nullable = false, precision = 10, scale = 0)

    public String getPrmDriverSituationCode() {
        return prmDriverSituationCode;
    }

    public void setPrmDriverSituationCode(String prmDriverSituationCode) {
        this.prmDriverSituationCode = prmDriverSituationCode;
    }

    @Column(name="prm_driversituationdescription",unique = true, nullable = false, precision = 10, scale = 0)

    public String getPrmDriverSituationDescription() {
        return prmDriverSituationDescription;
    }

    public void setPrmDriverSituationDescription(String prmDriverSituationDescription) {
        this.prmDriverSituationDescription = prmDriverSituationDescription;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmDriverSituation")

    public Set<PrmDriver> getPrmDrivers() {
        return prmDrivers;
    }

    public void setPrmDrivers(Set<PrmDriver> prmDrivers) {
        this.prmDrivers = prmDrivers;
    }
}
