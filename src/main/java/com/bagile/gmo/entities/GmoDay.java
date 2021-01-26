package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name="gmo_day")
public class GmoDay extends EmsEntity{

    private long gmoDayId;
    private String gmoDayCode;
    private String gmoDayDescription;
    private long gmoValue;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_day_id", allocationSize = 1)
    @Column(name = "gmo_dayid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoDayId() {
        return gmoDayId;
    }

    public void setGmoDayId(long gmoDayId) {
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

    public long getGmoValue() {
        return gmoValue;
    }

    public void setGmoValue(long value) {
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
