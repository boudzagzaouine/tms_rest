package com.sinno.ems.entities;

import javax.persistence.*;

/**
 * Created by Adil on 3/21/2017.
 */
@Entity
@Table(name = "prm_variable")
@SequenceGenerator(name = "seq", sequenceName = "seq_prm_variable")
public class PrmVariable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "prm_variableid")
    private long prmVariableId;

    @Column(name = "prm_variablecode")
    private String prmVariableCode;

    @Column(name = "description")
    private String prmVariableDescription;

    @Column(name = "prm_variableactive")
    private boolean prmVariableActive;

    public long getPrmVariableId() {
        return prmVariableId;
    }

    public void setPrmVariableId(long prmVariableId) {
        this.prmVariableId = prmVariableId;
    }

    public String getPrmVariableCode() {
        return prmVariableCode;
    }

    public void setPrmVariableCode(String prmVariableCode) {
        this.prmVariableCode = prmVariableCode;
    }

    public String getPrmVariableDescription() {
        return prmVariableDescription;
    }

    public void setPrmVariableDescription(String prmVariableDescription) {
        this.prmVariableDescription = prmVariableDescription;
    }

    public boolean getPrmVariableActive() {
        return prmVariableActive;
    }

    public void setPrmVariableActive(boolean prmVariableActive) {
        this.prmVariableActive = prmVariableActive;
    }
}
