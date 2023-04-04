package com.bagile.gmo.entities;


import javax.persistence.*;


@Entity
@Table(name = "tms_ordertransportaccompaniment")
public class TmsOrderTransportAccompaniment extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsOrderTransportAccompanimentId;


    private TmsOrderTransport tmsOrderTransport;
    private TmsVehicleAccompaniment tmsVehicleAccompaniment;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_marchandise_type_id", allocationSize = 1)
    @Column(name = "tms_marchandisetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportAccompanimentId() {
        return tmsOrderTransportAccompanimentId;
    }

    public void setTmsOrderTransportAccompanimentId(Long tmsVehicleAccompanimentId) {
        this.tmsOrderTransportAccompanimentId = tmsVehicleAccompanimentId;
    }

    @ManyToOne
    @JoinColumn(name = "tms_ordertrasnportid")
    public TmsOrderTransport getTmsOrderTransport() {
        return tmsOrderTransport;
    }

    public void setTmsOrderTransport(TmsOrderTransport tmsOrderTransport) {
        this.tmsOrderTransport = tmsOrderTransport;
    }

    @ManyToOne
    @JoinColumn(name = "tms_vehicleaccompanimentid")
    public TmsVehicleAccompaniment getTmsVehicleAccompaniment() {
        return tmsVehicleAccompaniment;
    }

    public void setTmsVehicleAccompaniment(TmsVehicleAccompaniment tmsVehicleAccompaniment) {
        this.tmsVehicleAccompaniment = tmsVehicleAccompaniment;
    }

    @ManyToOne
    @JoinColumn(name = "tms_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


}
