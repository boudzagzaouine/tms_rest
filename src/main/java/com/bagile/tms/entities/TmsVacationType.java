package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_vacationtype")
public class TmsVacationType   extends EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vacationtypeid", allocationSize = 1)
    @Column(name = "tms_vacationtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private int id;
    @Column(name = "tms_vacationtypetype")
    private String type;

    public TmsVacationType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
