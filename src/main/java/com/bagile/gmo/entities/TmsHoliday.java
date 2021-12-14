package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_holiday")
public class TmsHoliday extends EmsEntity{

    private Long tmsHolidayId;
    private String tmsHolidayCode;
    private String tmsHolidayDescription;
    private String tmsHolidayDay;
    private String tmsHolidayMonth;
    private Date tmsHolidayDate;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_holiday_id", allocationSize = 1)
    @Column(name = "tms_holidayid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsHolidayId() {
        return tmsHolidayId;
    }

    public void setTmsHolidayId(Long tmsHolidayId) {
        this.tmsHolidayId = tmsHolidayId;
    }

    @Column(name = "tms_holidaycode", unique = true, nullable = false)
    public String getTmsHolidayCode() {
        return tmsHolidayCode;
    }

    public void setTmsHolidayCode(String tmsHolidayCode) {
        this.tmsHolidayCode = tmsHolidayCode;
    }

    @Column(name = "tms_holidaydescription")
    public String getTmsHolidayDescription() {
        return tmsHolidayDescription;
    }

    public void setTmsHolidayDescription(String tmsHolidayDescription) {
        this.tmsHolidayDescription = tmsHolidayDescription;
    }

    @Column(name = "tms_holidaydate")
    public Date getTmsHolidayDate() {
        return tmsHolidayDate;
    }

    public void setTmsHolidayDate(Date tmsHolidayDate) {
        this.tmsHolidayDate = tmsHolidayDate;
    }

    @Column(name = "tms_holidayday")
    public String getTmsHolidayDay() {
        return tmsHolidayDay;
    }

    public void setTmsHolidayDay(String tmsHolidayDay) {
        this.tmsHolidayDay = tmsHolidayDay;
    }
    @Column(name = "tms_holidaymonth")
    public String getTmsHolidayMonth() {
        return tmsHolidayMonth;
    }

    public void setTmsHolidayMonth(String tmsHolidayMonth) {
        this.tmsHolidayMonth = tmsHolidayMonth;
    }
}
