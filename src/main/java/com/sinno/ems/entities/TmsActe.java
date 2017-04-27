package com.sinno.ems.entities;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


/**
 * Created by khalil on 15/03/2017.
 */
@Entity
@Table(name="tms_acte",uniqueConstraints = @UniqueConstraint(columnNames ={"tms_actecode,tms","tms_acteownerid"}))

public class TmsActe implements java.io.Serializable {
    private long tmsActeId;
    @NotNull
    private String tmsActeCode;
    @Size(max = 255)
    @NotNull
    private String tmsActeNature;
    private Set<TmsMaintenancePlan>tmsActeMaintenancePlan;

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

    public void setTmsActedateLastAct(Date tmsActedateLastAct) {
        this.tmsActedateLastAct = tmsActedateLastAct;
    }

    public TmsActe(){
    }

    public TmsActe(long tmsActeId, String tmsActeCode, String tmsActeNature, Set<TmsMaintenancePlan> tmsActeMaintenancePlan, String tmsActeDescription, String tmsActePeriodicity, String tmsActeDuration, Date tmsActedateLastAct) {
        this.tmsActeId = tmsActeId;
        this.tmsActeCode = tmsActeCode;
        this.tmsActeNature = tmsActeNature;
        this.tmsActeMaintenancePlan = tmsActeMaintenancePlan;
        this.tmsActeDescription = tmsActeDescription;
        this.tmsActePeriodicity = tmsActePeriodicity;
        this.tmsActeDuration = tmsActeDuration;
        this.tmsActedateLastAct = tmsActedateLastAct;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_acteid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsActeId() {
        return tmsActeId;
    }

    public void setTmsActeCode(String tmsActeCode) {
        this.tmsActeCode = tmsActeCode;
    }

    public void setTmsActeId(long tmsActeId) {
        this.tmsActeId = tmsActeId;
    }
    @Column(name = "tms_actecode", nullable = false, length = 30)
    public String getTmsActeCode() {
        return this.tmsActeCode;
    }

    public void setTmsActeDescription(String tmsActeDescription) {
        this.tmsActeDescription = tmsActeDescription;
    }
    @Column(name = "tms_actedescription")
    public String getTmsActeDescription() {
        return this.tmsActeDescription;
    }

    public void tmsActeDescription(String tmsActeDescription) {
        this.tmsActeDescription =tmsActeDescription;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_actecreationdate")
    public Date tmsActedateLastAct() {
        return tmsActedateLastAct;
    }


    public String getTmsActeDuration() {
        return tmsActeDuration;
    }

    public void setTmsActeDuration(String tmsActeDuration) {
        this.tmsActeDuration = tmsActeDuration;
    }

    public Date getTmsActedateLastAct() {
        return tmsActedateLastAct;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsMaintenancePlanActes")
    public Set<TmsMaintenancePlan> getTmsActeMaintenancePlan() {
        return tmsActeMaintenancePlan;
    }

    public void setTmsActeMaintenancePlan(Set<TmsMaintenancePlan> tmsActeMaintenancePlan) {
        this.tmsActeMaintenancePlan = tmsActeMaintenancePlan;
    }


    public String getTmsActePeriodicity() {
        return tmsActePeriodicity;
    }
    public void setTmsActePeriodicity(String tmsActePeriodicity) {
        this.tmsActePeriodicity = tmsActePeriodicity;
    }

}


