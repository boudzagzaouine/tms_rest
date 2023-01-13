package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_orderTransportrejecttype")
public class TmsOrderTransportRejectType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsOrderTransportRejectTypeId;
    private String tmsOrderTransportRejectTypeCode;
    private String tmsOrderTransportRejectTypeDescription;

    private long tmsOrderTransportRejectTypeType ;//1 = rejeter(prestataire) // 2=refus (voie) ;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransportrejecttype_id", allocationSize = 1)
    @Column(name = "tms_ordertransportrejecttypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportRejectTypeId() {
        return tmsOrderTransportRejectTypeId;
    }

    public void setTmsOrderTransportRejectTypeId(Long tmsOrderTransportRejectTypeId) {
        this.tmsOrderTransportRejectTypeId = tmsOrderTransportRejectTypeId;
    }

    @Column(name = "tms_ordertransportrejecttypecode", unique = true, nullable = false, length = 90)
    public String getTmsOrderTransportRejectTypeCode() {
        return tmsOrderTransportRejectTypeCode;
    }

    public void setTmsOrderTransportRejectTypeCode(String tmsOrderTransportRejectTypeCode) {
        this.tmsOrderTransportRejectTypeCode = tmsOrderTransportRejectTypeCode;
    }

    @Column(name = "tms_ordertransportrejecttypetype")
    public long getTmsOrderTransportRejectTypeType() {
        return tmsOrderTransportRejectTypeType;
    }

    public void setTmsOrderTransportRejectTypeType(long tmsOrderTransportRejectTypeType) {
        this.tmsOrderTransportRejectTypeType = tmsOrderTransportRejectTypeType;
    }

    @Column(name = "tms_ordertransportrejecttypedescription")
    public String getTmsOrderTransportRejectTypeDescription() {
        return tmsOrderTransportRejectTypeDescription;
    }

    public void setTmsOrderTransportRejectTypeDescription(String tmsOrderTransportRejectTypeDescription) {
        this.tmsOrderTransportRejectTypeDescription = tmsOrderTransportRejectTypeDescription;
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
