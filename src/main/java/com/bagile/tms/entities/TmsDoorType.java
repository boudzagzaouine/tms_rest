package com.bagile.tms.entities;

import javax.persistence.*;

@Entity
@Table(name = "tms_doortype", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_doortypeId"}))
public class TmsDoorType {
    private long tmsDoorTypeId;
    private Boolean tmsDoorTypeSide;
    private Boolean tmsDoorTypeBack;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_doortypesequence")
    @Column(name = "tms_doortypeId")
    public long getTmsDoorTypeId() {
        return tmsDoorTypeId;
    }

    public void setTmsDoorTypeId(long tmsDoorTypeId) {
        this.tmsDoorTypeId = tmsDoorTypeId;
    }

    @Column(name = "tms_doortypeside")
    public Boolean getTmsDoorTypeSide() {
        return tmsDoorTypeSide;
    }

    public void setTmsDoorTypeSide(Boolean tmsDoorTypeSide) {
        this.tmsDoorTypeSide = tmsDoorTypeSide;
    }

    @Column(name = "tms_doortypeback")
    public Boolean getTmsDoorTypeBack() {
        return tmsDoorTypeBack;
    }

    public void setTmsDoorTypeBack(Boolean tmsDoorTypeBack) {
        this.tmsDoorTypeBack = tmsDoorTypeBack;
    }
}

