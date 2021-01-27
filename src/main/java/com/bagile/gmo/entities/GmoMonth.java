package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_month")
public class GmoMonth extends EmsEntity{

    private Long gmoMonthId;
    private String gmoMonthCode;
    private String gmoMonthDescription;
    private Long gmoValue;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_month_id", allocationSize = 1)
    @Column(name = "gmo_monthid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoMonthId() {
        return gmoMonthId;
    }

    public void setGmoMonthId(Long gmoMonthId) {
        this.gmoMonthId = gmoMonthId;
    }

    @Column(name = "gmo_monthcode", unique = true, nullable = false, length = 90)
    public String getGmoMonthCode() {
        return gmoMonthCode;
    }

    public void setGmoMonthCode(String gmoMonthCode) {
        this.gmoMonthCode = gmoMonthCode;
    }

    @Column(name = "gmo_monthvalue", nullable = false, length = 90)

    public Long getGmoValue() {
        return gmoValue;
    }

    public void setGmoValue(Long value) {
        this.gmoValue = value;
    }

    @Column(name = "gmo_monthdescription")
    public String getGmoMonthDescription() {
        return gmoMonthDescription;
    }

    public void setGmoMonthDescription(String gmoMonthDescription) {
        this.gmoMonthDescription = gmoMonthDescription;
    }



}
