package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;

public class TmsVacation {
    private int idVacation;
    private Date debutVacation;
    private Date finVacation;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idVacation", unique = true, nullable = false, scale = 0)

    public int getIdVacation() {
        return idVacation;
    }

    public void setIdVacation(int idVacation) {
        this.idVacation = idVacation;
    }

    public Date getDebutVacation() {
        return debutVacation;
    }

    public void setDebutVacation(Date debutVacation) {
        this.debutVacation = debutVacation;
    }

    public Date getFinVacation() {
        return finVacation;
    }

    public void setFinVacation(Date finVacation) {
        this.finVacation = finVacation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TmsVacation{" +
                "idVacation=" + idVacation +
                ", debutVacation=" + debutVacation +
                ", finVacation=" + finVacation +
                ", type='" + type + '\'' +
                '}';
    }
}
