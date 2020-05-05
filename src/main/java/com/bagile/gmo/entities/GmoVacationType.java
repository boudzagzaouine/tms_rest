package com.bagile.gmo.entities;

import javax.persistence.*;



@Entity
@Table(name="tms_vacationtype")
public class TmsVacationType   extends EmsEntity{

    /**
     *
     */
    private static final long serialVersionUID = 796170659310976084L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vacation_type_id", allocationSize = 1)
    @Column(name = "tms_vacationtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long tmsVacationTypeId;
    @Column(name = "tms_vacationtypecode", unique = true, nullable = false, length = 90)
    private String tmsVacationTypeCode;
    @Column(name = "tms_vacationtypedescription")
    private String tmsVacationDescription;

    public Long getTmsVacationTypeId() {
        return tmsVacationTypeId;
    }

    public void setTmsVacationTypeId(Long tmsVacationTypeId) {
        this.tmsVacationTypeId = tmsVacationTypeId;
    }

    public String getTmsVacationTypeCode() {
        return tmsVacationTypeCode;
    }

    public void setTmsVacationTypeCode(String tmsVacationTypeCode) {
        this.tmsVacationTypeCode = tmsVacationTypeCode;
    }

    public String getTmsVacationDescription() {
        return tmsVacationDescription;
    }

    public void setTmsVacationDescription(String tmsVacationDescription) {
        this.tmsVacationDescription = tmsVacationDescription;
    }
}
