package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_turntype")
public class TmsTurnType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTurnTypeId;
    private String tmsTurnTypeCode;
    private String tmsTurnTypeDescription;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turn_type_id", allocationSize = 1)
    @Column(name = "tms_turntypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTurnTypeId() {
        return tmsTurnTypeId;
    }

    public void setTmsTurnTypeId(Long tmsTurnTypeId) {
        this.tmsTurnTypeId = tmsTurnTypeId;
    }

    @Column(name = "tms_turntypecode", unique = true, nullable = false, length = 90)
    public String getTmsTurnTypeCode() {
        return tmsTurnTypeCode;
    }

    public void setTmsTurnTypeCode(String tmsTurnTypeCode) {
        this.tmsTurnTypeCode = tmsTurnTypeCode;
    }

    @Column(name = "tms_turntypedescription")
    public String getTmsTurnTypeDescription() {
        return tmsTurnTypeDescription;
    }

    public void setTmsTurnTypeDescription(String tmsTurnTypeDescription) {
        this.tmsTurnTypeDescription = tmsTurnTypeDescription;
    }

    @ManyToOne()
    @JoinColumn(name="tms_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
