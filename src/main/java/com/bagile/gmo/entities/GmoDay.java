package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_day")
public class GmoDay extends EmsEntity{

    private Long gmoDayId;
    private String gmoDayCode;
    private String gmoDayDescription;
    private Long gmoValue;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_day_id", allocationSize = 1)
    @Column(name = "gmo_dayid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoDayId() {
        return gmoDayId;
    }

    public void setGmoDayId(Long gmoDayId) {
        this.gmoDayId = gmoDayId;
    }

    @Column(name = "gmo_daycode", unique = true, nullable = false, length = 90)
    public String getGmoDayCode() {
        return gmoDayCode;
    }

    public void setGmoDayCode(String gmoDayCode) {
        this.gmoDayCode = gmoDayCode;
    }

    @Column(name = "gmo_dayvalue", nullable = false, length = 90)

    public Long getGmoValue() {
        return gmoValue;
    }

    public void setGmoValue(Long value) {
        this.gmoValue = value;
    }

    @Column(name = "gmo_daydescription")
    public String getGmoDayDescription() {
        return gmoDayDescription;
    }

    public void setGmoDayDescription(String gmoDayDescription) {
        this.gmoDayDescription = gmoDayDescription;
    }
}
