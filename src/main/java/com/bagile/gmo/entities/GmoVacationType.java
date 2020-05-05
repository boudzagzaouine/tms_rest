package com.bagile.gmo.entities;

import javax.persistence.*;



@Entity
@Table(name="gmo_vacationtype")
public class GmoVacationType   extends EmsEntity{

    /**
     *
     */
    private static final long serialVersionUID = 796170659310976084L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vacation_type_id", allocationSize = 1)
    @Column(name = "gmo_vacationtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoVacationTypeId;
    @Column(name = "gmo_vacationtypecode", unique = true, nullable = false, length = 90)
    private String gmoVacationTypeCode;
    @Column(name = "gmo_vacationtypedescription")
    private String gmoVacationDescription;

    public Long getGmoVacationTypeId() {
        return gmoVacationTypeId;
    }

    public void setGmoVacationTypeId(Long gmoVacationTypeId) {
        this.gmoVacationTypeId = gmoVacationTypeId;
    }

    public String getGmoVacationTypeCode() {
        return gmoVacationTypeCode;
    }

    public void setGmoVacationTypeCode(String gmoVacationTypeCode) {
        this.gmoVacationTypeCode = gmoVacationTypeCode;
    }

    public String getGmoVacationDescription() {
        return gmoVacationDescription;
    }

    public void setGmoVacationDescription(String gmoVacationDescription) {
        this.gmoVacationDescription = gmoVacationDescription;
    }
}
