package com.bagile.tms.entities;

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
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vacationtypeid", allocationSize = 1)
    @Column(name = "tms_vacationtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private int id;
    @Column(name = "tms_vacationtypecode")
    private String code;
    @Column(name = "tms_vacationtypedescription")
    private String description;

    public TmsVacationType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return code;
    }

    public void setType(String type) {
        this.code = type;
    }

    


}
