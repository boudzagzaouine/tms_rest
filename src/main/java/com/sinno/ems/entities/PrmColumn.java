package com.sinno.ems.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by adadi on 2/12/2016.
 */

@Entity
@Table(name = "prm_column")
@SequenceGenerator(name = "seq", sequenceName = "seq_prm_column", initialValue = 1)
public class PrmColumn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long prmColumnId;

    @Column(name = "prm_columnposition")
    private int prmColumnPosition;

    @Column(name = "prm_columnname")
    private String prmColumnName;

   @Column(name = "prm_columnclasse")
    private String prmColumnClasse;

    @Column(name = "prm_columnvisible")
    private Boolean prmColumnVisible;

    public Long getPrmColumnId() {
        return prmColumnId;
    }

    public void setPrmColumnId(Long prmColumnId) {
        this.prmColumnId = prmColumnId;
    }
    public String getPrmColumnName() {
        return prmColumnName;
    }

    public void setPrmColumnName(String prmColumnName) {
        this.prmColumnName = prmColumnName;
    }

    public String getPrmColumnClasse() {
        return prmColumnClasse;
    }

    public void setPrmColumnClasse(String prmColumnClasse) {
        this.prmColumnClasse = prmColumnClasse;
    }

    public Boolean getPrmColumnVisible() {
        return prmColumnVisible;
    }

    public void setPrmColumnVisible(Boolean prmColumnVisible) {
        this.prmColumnVisible = prmColumnVisible;
    }

    public int getPrmColumnPosition() {
        return prmColumnPosition;
    }

    public void setPrmColumnPosition(int prmColumnPosition) {
        this.prmColumnPosition = prmColumnPosition;
    }
}
