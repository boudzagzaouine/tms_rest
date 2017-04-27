package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "asr_policeinsurance")
public class TmsPoliceInsurance implements Serializable {
    private long asrPoliceInsuranceId;
    @NotNull
    private TmsVehicle vehicules;
    @Size(max = 30)
    @NotNull
    private String asrPoliceInsuranceCode;
    @Size(max = 30)
    @NotNull
    private String asrPoliceInsuranceNumber;
    @Size(max = 30)
    @NotNull
    private String asrPoliceInsuranceType;
    @Size(max = 15)
    @NotNull

    private String asrPoliceInsurancePhoneNumber;

    private Date asrPoliceInsuranceStartDate;

    private Date asrPoliceInsuranceEndDate;

    public TmsPoliceInsurance(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "asr_policeinsuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getAsrPoliceInsuranceId() {
        return asrPoliceInsuranceId;
    }

    public void setAsrPoliceInsuranceId(long asrPoliceInsuranceId) {
        this.asrPoliceInsuranceId = asrPoliceInsuranceId;
    }

    public void setVehicules(TmsVehicle vehicules) {
        this.vehicules = vehicules;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asr_policeinsuranceid", nullable = false)

    @Column(name = "asr_policeinsurancecode", nullable = false, length = 30)

    public String getAsrPoliceInsuranceCode() {
        return asrPoliceInsuranceCode;
    }

    public void setAsrPoliceInsuranceCode(String asrPoliceInsuranceCode) {
        this.asrPoliceInsuranceCode = asrPoliceInsuranceCode;
    }

    @Column(name = "asr_policeinsuranceNumber", nullable = false, length = 30)
    public String getAsrPoliceInsuranceNumber() {
        return asrPoliceInsuranceNumber;
    }

    public void setAsrPoliceInsuranceNumber(String asrPoliceInsuranceNumber) {
        this.asrPoliceInsuranceNumber = asrPoliceInsuranceNumber;
    }

    @Column(name = "asr_policeinsuranceType", nullable = false, length = 30)

    public String getAsrPoliceInsuranceType() {
        return asrPoliceInsuranceType;
    }

    public void setAsrPoliceInsuranceType(String asrPoliceInsuranceType) {
        this.asrPoliceInsuranceType = asrPoliceInsuranceType;
    }

    @Column(name = "asr_policeinsurancephonenumber", nullable = false, length = 15)
    public String getAsrPoliceInsurancePhoneNumber() {
        return asrPoliceInsurancePhoneNumber;
    }

    public void setAsrPoliceInsurancePhoneNumber(String asrPoliceInsurancePhoneNumber) {
        this.asrPoliceInsurancePhoneNumber = asrPoliceInsurancePhoneNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "asr_policeinsurancestartdate")
    public Date getAsrPoliceInsuranceStartDate() {
        return asrPoliceInsuranceStartDate;
    }

    public void setAsrPoliceInsuranceStartDate(Date asrPoliceInsuranceStartDate) {
        this.asrPoliceInsuranceStartDate = asrPoliceInsuranceStartDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "asr_policeinsuranceenddate")
    public Date getAsrPoliceInsuranceEndDate() {
        return asrPoliceInsuranceEndDate;
    }

    public void setAsrPoliceInsuranceEndDate(Date asrPoliceInsuranceEndDate) {
        this.asrPoliceInsuranceEndDate = asrPoliceInsuranceEndDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "asr_policeinsurancevehicle")

    public TmsVehicle getVehicules() {
        return vehicules;
    }


}
