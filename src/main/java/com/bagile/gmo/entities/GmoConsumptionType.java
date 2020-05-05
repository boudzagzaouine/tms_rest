package com.bagile.gmo.entities;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name="gmo_consumptiontype")

public class GmoConsumptionType extends EmsEntity{

    private long gmoConsumptionTypeId;
    private String gmoConsumptionTypeCode;
    private String gmoConsumptionTypeDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_consumptiontype_id", allocationSize = 1)
    @Column(name = "gmo_consumptiontype_id", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoConsumptionTypeId() {
        return gmoConsumptionTypeId;
    }

    public void setGmoConsumptionTypeId(long gmoConsumptionTypeId) {
        this.gmoConsumptionTypeId = gmoConsumptionTypeId;
    }

    @Column(name = "gmo_consumptiontypecode", unique = true, nullable = false, length = 90)
    public String getGmoConsumptionTypeCode() {
        return gmoConsumptionTypeCode;
    }

    public void setGmoConsumptionTypeCode(String gmoConsumptionTypeCode) {
        this.gmoConsumptionTypeCode = gmoConsumptionTypeCode;
    }




    @Column(name = "gmo_consumptiontypedescription")
    public String getGmoConsumptionTypeDescription() {
        return gmoConsumptionTypeDescription;
    }

    public void setGmoConsumptionTypeDescription(String gmoConsumptionTypeDescription) {
        this.gmoConsumptionTypeDescription = gmoConsumptionTypeDescription;
    }
}
