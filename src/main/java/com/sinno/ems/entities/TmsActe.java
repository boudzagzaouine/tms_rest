package com.sinno.ems.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


/**
 * Created by khalil on 15/03/2017.
 */
@Entity
@Table(name="prm_acte",uniqueConstraints = @UniqueConstraint(columnNames ={"prm_actecode,prm","prm_acteownerid"}))

public class TmsActe implements java.io.Serializable {
    private long prmActeId;
    @NotNull
    private String prmActeCode;
    @Size(max = 255)
    @NotNull
    private String prmActeNature;

    public void setPrmActeNature(String prmActeNature) {
        this.prmActeNature = prmActeNature;
    }

    public String getPrmActeNature() {
        return prmActeNature;
    }

    @Size(max = 240)

    @NotNull
    private String prmActeDescription;
    @Size(max = 240)
    @NotNull
    private String prmActePeriodicity;

    public void setPrmActePeriodicity(String prmActePeriodicity) {
        this.prmActePeriodicity = prmActePeriodicity;
    }

    public String getPrmActePeriodicity() {
        return prmActePeriodicity;
    }

    @Size(max = 240)
    @NotNull

    private String prmActeDuration;
    @Size(max = 240)
    @NotNull
    private Date prmActedateLastAct;

    public TmsActe(){
    }
    public TmsActe(long prmActeId, String prmActeCode, String prmActeNature, String prmActeDescription, String prmActePeriodicity) {
        this.prmActeId = prmActeId;
        this.prmActeCode=prmActeCode;
        this.prmActeNature=prmActeNature;
        this.prmActeDescription=prmActeDescription;
        this.prmActePeriodicity=prmActePeriodicity;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "prm_acteid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrmActeId() {
        return prmActeId;
    }

    public void setPrmActeCode(String prmActeCode) {
        this.prmActeCode = prmActeCode;
    }

    public void setPrmActeId(long prmActeId) {
        this.prmActeId = prmActeId;
    }
    @Column(name = "prm_actecode", nullable = false, length = 30)
    public String getPrmActeCode() {
        return this.prmActeCode;
    }

    public void setPrmActeDescription(String prmActeDescription) {
        this.prmActeDescription = prmActeDescription;
    }
    @Column(name = "prm_actedescription")
    public String getPrmActeDescription() {
        return this.prmActeDescription;
    }

    public void prmActeDescription(String prmActeDescription) {
        this.prmActeDescription =prmActeDescription;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_actecreationdate")
    public Date prmActedateLastAct() {
        return prmActedateLastAct;
    }

    public void setprmActedateLastAct(Date prmActedateLastAct) {
        this.prmActedateLastAct = prmActedateLastAct;
    }

    public String getPrmActeDuration() {
        return prmActeDuration;
    }

    public void setPrmActeDuration(String prmActeDuration) {
        this.prmActeDuration = prmActeDuration;
    }

    public Date getPrmActedateLastAct() {
        return prmActedateLastAct;
    }

    public void setPrmActedateLastAct(Date prmActedateLastAct) {
        this.prmActedateLastAct = prmActedateLastAct;
    }
}


