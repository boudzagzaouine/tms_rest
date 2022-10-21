package com.bagile.gmo.entities;


import com.bagile.gmo.dto.EmsDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_orderdeliverytransport")
public class TmsOrderDeliveryTransport extends EmsDto implements Serializable  {


    private Long tmsOrderDeliveryTransportId;
    private GmoVehicle gmoVehicle;
    private  GmoVehicleCategory gmoVehicleCategory;
    private   TrpTransport trpTransport;
    private Set<GmoDriver> gmoDrivers = new HashSet<>();
private TmsOrderDelivery tmsOrderDelivery;


private long tmsOrderDeliveryTransportNumberOfPalette;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_orderdeliverytransport", allocationSize = 1)
    @Column(name = "tms_orderdeliverytransportid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderDeliveryTransportId() {
        return tmsOrderDeliveryTransportId;
    }

    public void setTmsOrderDeliveryTransportId(Long tmsOrderDeliveryTransportId) {
        this.tmsOrderDeliveryTransportId = tmsOrderDeliveryTransportId;
    }

    @Column(name = "tms_orderdeliverytransportnumberofpalette")
    public long getTmsOrderDeliveryTransportNumberOfPalette() {
        return tmsOrderDeliveryTransportNumberOfPalette;
    }

    public void setTmsOrderDeliveryTransportNumberOfPalette(long tmsOrderDeliveryTransportNumberOfPalette) {
        this.tmsOrderDeliveryTransportNumberOfPalette = tmsOrderDeliveryTransportNumberOfPalette;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_orderdeliveryvehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_orderdeliverytransportcategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_orderdeliverytransporttransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_orderdeliverytransportordedeliveryid")
    public TmsOrderDelivery getTmsOrderDelivery() {
        return tmsOrderDelivery;
    }

    public void setTmsOrderDelivery(TmsOrderDelivery tmsOrderDelivery) {
        this.tmsOrderDelivery = tmsOrderDelivery;
    }

    @ManyToMany
    @JoinTable(
            name = "tms_orderdelivery_transport_driver",
            joinColumns = @JoinColumn(name = "tms_orderDeliverytransportid"),
            inverseJoinColumns = @JoinColumn(name = "tms_driver_id"))
    public Set<GmoDriver> getGmoDrivers() {
        return gmoDrivers;
    }


    public void setGmoDrivers(Set<GmoDriver> drivers) {
        this.gmoDrivers = drivers;
    }




  
   

}

