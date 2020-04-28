package com.bagile.tms.entities;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name="tms_consumptiontype")

public class TmsConsumptionType extends EmsEntity{

    private long tmsConsumptionTypeId;
    private String tmsConsumptionTypeCode;
    private String tmsConsumptionTypeDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_consumptiontype_id", allocationSize = 1)
    @Column(name = "tms_consumptiontype_id", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsConsumptionTypeId() {
        return tmsConsumptionTypeId;
    }

    public void setTmsConsumptionTypeId(long tmsConsumptionTypeId) {
        this.tmsConsumptionTypeId = tmsConsumptionTypeId;
    }

    @Column(name = "tms_consumptiontypecode", unique = true, nullable = false, length = 90)
    public String getTmsConsumptionTypeCode() {
        return tmsConsumptionTypeCode;
    }

    public void setTmsConsumptionTypeCode(String tmsConsumptionTypeCode) {
        this.tmsConsumptionTypeCode = tmsConsumptionTypeCode;
    }




    @Column(name = "tms_consumptiontypedescription")
    public String getTmsConsumptionTypeDescription() {
        return tmsConsumptionTypeDescription;
    }

    public void setTmsConsumptionTypeDescription(String tmsConsumptionTypeDescription) {
        this.tmsConsumptionTypeDescription = tmsConsumptionTypeDescription;
    }
}
