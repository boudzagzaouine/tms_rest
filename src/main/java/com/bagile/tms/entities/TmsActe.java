package com.bagile.tms.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


/**
 * Created by khalil on 15/03/2017.
 */
@Entity
@Table(name = "tms_acte", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_actecode"}))

public class TmsActe implements java.io.Serializable {
    private long tmsActeId;
    @NotNull
    private String tmsActeCode;
    @Size(max = 255)
    @NotNull
    private String tmsActeNature;
/*
    private Set<TmsMaintenancePlan> tmsActeMaintenancePlan;
*/

    public void setTmsActeNature(String tmsActeNature) {
        this.tmsActeNature = tmsActeNature;
    }

    public String getTmsActeNature() {
        return tmsActeNature;
    }

    @Size(max = 240)

    @NotNull
    private String tmsActeDescription;
    @Size(max = 240)
    @NotNull
    private String tmsActePeriodicity;

    @Size(max = 240)
    @NotNull

    private String tmsActeDuration;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_actedatelastact")
    private Date tmsActedateLastAct;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_acteid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsActeId() {
        return tmsActeId;
    }

    public void setTmsActeId(long tmsActeId) {
        this.tmsActeId = tmsActeId;
    }

    @Column(name = "tms_actecode", nullable = false, length = 30)
    public String getTmsActeCode() {
        return this.tmsActeCode;
    }

    public void setTmsActeCode(String tmsActeCode) {
        this.tmsActeCode = tmsActeCode;
    }

    @Column(name = "tms_actedescription")
    public String getTmsActeDescription() {
        return this.tmsActeDescription;
    }

    public void setTmsActeDescription(String tmsActeDescription) {
        this.tmsActeDescription = tmsActeDescription;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_actecreationdate")
    public Date tmsActedateLastAct() {
        return tmsActedateLastAct;
    }

    public void setTmsActedateLastAct(Date tmsActedateLastAct) {
        this.tmsActedateLastAct = tmsActedateLastAct;
    }

    @Column(name = "tms_acteduration")
    public String getTmsActeDuration() {
        return tmsActeDuration;
    }

    public void setTmsActeDuration(String tmsActeDuration) {
        this.tmsActeDuration = tmsActeDuration;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_actedatelastact")
    public Date getTmsActedateLastAct() {
        return tmsActedateLastAct;
    }


    @Column(name = "tms_acteperiodicity")
    public String getTmsActePeriodicity() {
        return tmsActePeriodicity;
    }

    public void setTmsActePeriodicity(String tmsActePeriodicity) {
        this.tmsActePeriodicity = tmsActePeriodicity;
    }

  /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsMaintenancePlanActes")
    public Set<TmsMaintenancePlan> getTmsActeMaintenancePlan() {
        return tmsActeMaintenancePlan;
    }

    public void setTmsActeMaintenancePlan(Set<TmsMaintenancePlan> tmsActeMaintenancePlan) {
        this.tmsActeMaintenancePlan = tmsActeMaintenancePlan;
    }*/

}


