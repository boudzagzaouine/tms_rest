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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_acteid")
    private long tmsActeId;

    @NotNull
    @Column(name = "tms_actecode")
    private String tmsActeCode;

    @Size(max = 255)
    @NotNull
    private String tmsActeNature;

    //private Set<TmsMaintenancePlan> tmsActeMaintenancePlan;

    @Size(max = 240)
    @NotNull
    @Column(name = "tms_actedescription")
    private String tmsActeDescription;

    @Size(max = 240)
    @NotNull
    @Column(name = "tms_acteperiodicity")
    private String tmsActePeriodicity;

    @Size(max = 240)
    @NotNull
    @Column(name = "tms_acteduration")
    private String tmsActeDuration;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_actedatelastact")
    private Date tmsActeDateLastAct;


    public long getTmsActeId() {
        return tmsActeId;
    }

    public void setTmsActeId(long tmsActeId) {
        this.tmsActeId = tmsActeId;
    }

    public String getTmsActeCode() {
        return this.tmsActeCode;
    }

    public void setTmsActeCode(String tmsActeCode) {
        this.tmsActeCode = tmsActeCode;
    }

    public String getTmsActeDescription() {
        return this.tmsActeDescription;
    }

    public void setTmsActeDescription(String tmsActeDescription) {
        this.tmsActeDescription = tmsActeDescription;
    }

    public Date tmsActeDateLastAct() {
        return tmsActeDateLastAct;
    }

    public void setTmsActeDateLastAct(Date tmsActeDateLastAct) {
        this.tmsActeDateLastAct = tmsActeDateLastAct;
    }

    public String getTmsActeDuration() {
        return tmsActeDuration;
    }

    public void setTmsActeDuration(String tmsActeDuration) {
        this.tmsActeDuration = tmsActeDuration;
    }

    public Date getTmsActeDateLastAct() {
        return tmsActeDateLastAct;
    }

    public String getTmsActePeriodicity() {
        return tmsActePeriodicity;
    }

    public void setTmsActePeriodicity(String tmsActePeriodicity) {
        this.tmsActePeriodicity = tmsActePeriodicity;
    }

    public void setTmsActeNature(String tmsActeNature) {
        this.tmsActeNature = tmsActeNature;
    }

    public String getTmsActeNature() {
        return tmsActeNature;
    }

    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsMaintenancePlanActes")
    public Set<TmsMaintenancePlan> getTmsActeMaintenancePlan() {
        return tmsActeMaintenancePlan;
    }

    public void setTmsActeMaintenancePlan(Set<TmsMaintenancePlan> tmsActeMaintenancePlan) {
        this.tmsActeMaintenancePlan = tmsActeMaintenancePlan;
    }
    */

}


