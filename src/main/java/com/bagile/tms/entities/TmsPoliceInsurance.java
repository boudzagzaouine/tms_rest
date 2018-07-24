package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "tms_policeinsurance")
public class TmsPoliceInsurance implements Serializable {
    private long tmsPoliceInsuranceId;
    @NotNull
    private TmsVehicle vehicules;
    @Size(max = 30)
    @NotNull
    private String tmsPoliceInsuranceCode;
    @Size(max = 30)
    @NotNull
    private String tmsPoliceInsuranceNumber;
    @Size(max = 30)
    @NotNull
    private String tmsPoliceInsuranceType;
    @Size(max = 15)
    @NotNull

    private String tmsPoliceInsurancePhoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date tmsPoliceInsuranceStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date tmsPoliceInsuranceEndDate;

    public TmsPoliceInsurance() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_policeinsuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsPoliceInsuranceId() {
        return tmsPoliceInsuranceId;
    }

    public void setTmsPoliceInsuranceId(long tmsPoliceInsuranceId) {
        this.tmsPoliceInsuranceId = tmsPoliceInsuranceId;
    }


    @Column(name = "tms_policeinsurancecode", nullable = false, length = 30)

    public String getTmsPoliceInsuranceCode() {
        return tmsPoliceInsuranceCode;
    }

    public void setTmsPoliceInsuranceCode(String tmsPoliceInsuranceCode) {
        this.tmsPoliceInsuranceCode = tmsPoliceInsuranceCode;
    }

    @Column(name = "tms_policeinsurancenumber", nullable = false, length = 30)
    public String getTmsPoliceInsuranceNumber() {
        return tmsPoliceInsuranceNumber;
    }

    public void setTmsPoliceInsuranceNumber(String tmsPoliceInsuranceNumber) {
        this.tmsPoliceInsuranceNumber = tmsPoliceInsuranceNumber;
    }

    @Column(name = "tms_policeinsurancetype", nullable = false, length = 30)

    public String getTmsPoliceInsuranceType() {
        return tmsPoliceInsuranceType;
    }

    public void setTmsPoliceInsuranceType(String tmsPoliceInsuranceType) {
        this.tmsPoliceInsuranceType = tmsPoliceInsuranceType;
    }

    @Column(name = "tms_policeinsurancephonenumber", nullable = false, length = 15)
    public String getTmsPoliceInsurancePhoneNumber() {
        return tmsPoliceInsurancePhoneNumber;
    }

    public void setTmsPoliceInsurancePhoneNumber(String tmsPoliceInsurancePhoneNumber) {
        this.tmsPoliceInsurancePhoneNumber = tmsPoliceInsurancePhoneNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_policeinsurancestartdate")
    public Date getTmsPoliceInsuranceStartDate() {
        return tmsPoliceInsuranceStartDate;
    }

    public void setTmsPoliceInsuranceStartDate(Date tmsPoliceInsuranceStartDate) {
        this.tmsPoliceInsuranceStartDate = tmsPoliceInsuranceStartDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_policeinsuranceenddate")
    public Date getTmsPoliceInsuranceEndDate() {
        return tmsPoliceInsuranceEndDate;
    }

    public void setTmsPoliceInsuranceEndDate(Date tmsPoliceInsuranceEndDate) {
        this.tmsPoliceInsuranceEndDate = tmsPoliceInsuranceEndDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_policeinsurancevehicleid")

    public TmsVehicle getVehicules() {
        return vehicules;
    }

    public void setVehicules(TmsVehicle vehicules) {
        this.vehicules = vehicules;
    }
}
