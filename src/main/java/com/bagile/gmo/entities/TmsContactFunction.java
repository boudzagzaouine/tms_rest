package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_contactfunction")
public class TmsContactFunction extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsContactFunctionId;
    private String tmsContactFunctionCode;
    private String tmsContactFunctionDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_contactfunction_id", allocationSize = 1)
    @Column(name = "tms_contactfunctionid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsContactFunctionId() {
        return tmsContactFunctionId;
    }

    public void setTmsContactFunctionId(Long tmsContactFunctionId) {
        this.tmsContactFunctionId = tmsContactFunctionId;
    }

    @Column(name = "tms_contactfunctioncode", unique = true, nullable = false, length = 90)
    public String getTmsContactFunctionCode() {
        return tmsContactFunctionCode;
    }

    public void setTmsContactFunctionCode(String tmsContactFunctionCode) {
        this.tmsContactFunctionCode = tmsContactFunctionCode;
    }

    @Column(name = "tms_contactfunctiondescription")
    public String getTmsContactFunctionDescription() {
        return tmsContactFunctionDescription;
    }

    public void setTmsContactFunctionDescription(String tmsContactFunctionDescription) {
        this.tmsContactFunctionDescription = tmsContactFunctionDescription;
    }



    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
