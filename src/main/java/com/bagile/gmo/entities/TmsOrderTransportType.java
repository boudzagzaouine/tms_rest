package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_order_transport_type")
public class TmsOrderTransportType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsOrderTransportTypeId;
    private String tmsOrderTransportTypeCode;
    private String tmsOrderTransportTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_order_transport_type_id", allocationSize = 1)
    @Column(name = "tms_order_transport_typeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportTypeId() {
        return tmsOrderTransportTypeId;
    }

    public void setTmsOrderTransportTypeId(Long tmsOrderTransportTypeId) {
        this.tmsOrderTransportTypeId = tmsOrderTransportTypeId;
    }

    @Column(name = "tms_order_transport_typecode", unique = true, nullable = false, length = 90)
    public String getTmsOrderTransportTypeCode() {
        return tmsOrderTransportTypeCode;
    }

    public void setTmsOrderTransportTypeCode(String tmsOrderTransportTypeCode) {
        this.tmsOrderTransportTypeCode = tmsOrderTransportTypeCode;
    }

    @Column(name = "tms_order_transport_typedescription")
    public String getTmsOrderTransportTypeDescription() {
        return tmsOrderTransportTypeDescription;
    }

    public void setTmsOrderTransportTypeDescription(String tmsOrderTransportTypeDescription) {
        this.tmsOrderTransportTypeDescription = tmsOrderTransportTypeDescription;
    }



    @ManyToOne
    @JoinColumn(name = "gmo_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


}
