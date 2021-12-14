package com.bagile.gmo.entities;


import com.bagile.gmo.dto.EmsDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_turntransport")
public class TmsTurnTransport extends EmsDto implements Serializable  {


    private Long tmsTurnTransportId;
    private GmoVehicle gmoVehicle;
    private  GmoVehicleCategory gmoVehicleCategory;
    private   TrpTransport trpTransport;
    private Set<GmoDriver> gmoDrivers = new HashSet<>();
private TmsTurn tmsTurnn;
private long tmsTurnTransportNumberOfPalette;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turntransport", allocationSize = 1)
    @Column(name = "tms_turntransportid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTurnTransportId() {
        return tmsTurnTransportId;
    }

    public void setTmsTurnTransportId(Long tmsTurnTransportId) {
        this.tmsTurnTransportId = tmsTurnTransportId;
    }

    @Column(name = "tms_turntransportnumberofpalette")
    public long getTmsTurnTransportNumberOfPalette() {
        return tmsTurnTransportNumberOfPalette;
    }

    public void setTmsTurnTransportNumberOfPalette(long tmsTurnTransportNumberOfPalette) {
        this.tmsTurnTransportNumberOfPalette = tmsTurnTransportNumberOfPalette;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnsopoturnid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turntransportcategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turntransporttransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turntransportturnid")
    public TmsTurn getTmsTurnn() {
        return tmsTurnn;
    }

    public void setTmsTurnn(TmsTurn tmsTurn) {
        this.tmsTurnn = tmsTurn;
    }

    @ManyToMany
    @JoinTable(
            name = "tms_turn_transport_driver",
            joinColumns = @JoinColumn(name = "tms_turntransportid"),
            inverseJoinColumns = @JoinColumn(name = "tms_driver_id"))
    public Set<GmoDriver> getGmoDrivers() {
        return gmoDrivers;
    }


    public void setGmoDrivers(Set<GmoDriver> drivers) {
        this.gmoDrivers = drivers;
    }




  
   

}

