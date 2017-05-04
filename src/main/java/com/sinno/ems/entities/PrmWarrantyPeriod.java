package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Enissay on 15/12/2016.
 */
@Entity
@Table(name = "prm_warrantyperiod", uniqueConstraints = @UniqueConstraint(columnNames = "prm_warrantyperiodcode"))
public class PrmWarrantyPeriod {
    private long prmWarrantyPeriodId;
    @NotNull
    private String prmWarrantyPeriodCode;
    private String prmWarrantyPeriodDescription;
    private Date prmWarrantyPeriodCreationDate;
    private Date prmWarrantyPeriodUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_ems.prm_warrantyperiod_prm_warrantyperiodid_seq", allocationSize = 1)
    @Column(name = "prm_warrantyperiodid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmWarrantyPeriodId() {
        return this.prmWarrantyPeriodId;
    }

    public void setPrmWarrantyPeriodId(long prmWarrantyPeriodId) {
        this.prmWarrantyPeriodId = prmWarrantyPeriodId;
    }
    @Column(name = "prm_warrantyperiodcode")
    public String getPrmWarrantyPeriodCode() {
        return this.prmWarrantyPeriodCode;
    }

    public void setPrmWarrantyPeriodCode(String prmWarrantyPeriodCode) {
        this.prmWarrantyPeriodCode = prmWarrantyPeriodCode;
    }
    @Column(name = "prm_warrantyperioddescription")

    public String getPrmWarrantyPeriodDescription() {
        return this.prmWarrantyPeriodDescription;
    }

    public void setPrmWarrantyPeriodDescription(String prmWarrantyPeriodDescription) {
        this.prmWarrantyPeriodDescription = prmWarrantyPeriodDescription;
    }
    @Column(name = "prm_warrantyperiodcreationdate")
    @Temporal(TemporalType.TIMESTAMP)

    public Date getPrmWarrantyPeriodCreationDate() {
        return this.prmWarrantyPeriodCreationDate;
    }

    public void setPrmWarrantyPeriodCreationDate(Date prmWarrantyPeriodCreationDate) {
        this.prmWarrantyPeriodCreationDate = prmWarrantyPeriodCreationDate;
    }
    @Column(name = "prm_warrantyperiodupdatedate")
    @Temporal(TemporalType.TIMESTAMP)

    public Date getPrmWarrantyPeriodUpdateDate() {
        return this.prmWarrantyPeriodUpdateDate;
    }

    public void setPrmWarrantyPeriodUpdateDate(Date prmWarrantyPeriodUpdateDate) {
        this.prmWarrantyPeriodUpdateDate = prmWarrantyPeriodUpdateDate;
    }
}
