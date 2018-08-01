package com.bagile.tms.entities;

import javax.persistence.*;

@Entity
@Table(name = "tms_doortype", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_doortypeId"}))
public class TmsDoorType {
    private long tmsDoorTypeId;
    private String tmsDoorTypeCode;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_doortypeId", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsDoorTypeId() {
        return tmsDoorTypeId;
    }


    public void setTmsDoorTypeId(long tmsDoorTypeId) {
        this.tmsDoorTypeId = tmsDoorTypeId;
    }

    @Column(name = "tms_doortypecode", unique = true, nullable = false, scale = 0)
    public String getTmsDoorTypeCode() {
        return tmsDoorTypeCode;
    }

    public void setTmsDoorTypeCode(String tmsDoorTypeCode) {
        this.tmsDoorTypeCode = tmsDoorTypeCode;
    }
}
