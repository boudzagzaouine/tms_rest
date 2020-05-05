package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="gmo_turn")
public class GmoTurn extends EmsEntity {

    private Long GmoTurnId;
    private Set<GmoDriver> gmoDrivers=new HashSet<>();
    private GmoVehicle gmoVehicle;
    private TrpTransport trpTransport;
    private Date dateDelivery ;
    private Set<GmoTurnLine> gmoTurnLines = new HashSet<>();



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_turn_id", allocationSize = 1)
    @Column(name = "gmo_turnid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoTurnId() {
        return GmoTurnId;
    }

    public void setGmoTurnId(Long gmoTurnId) {
        GmoTurnId = gmoTurnId;
    }

    @ManyToMany
    @JoinTable(
            name = "gmo_tour_driver",
            joinColumns = @JoinColumn(name = "gmo_tour_id"),
            inverseJoinColumns = @JoinColumn(name = "gmo_driver_id"))
    public Set<GmoDriver> getGmoDrivers() {
        return gmoDrivers;
    }

    public void setGmoDrivers(Set<GmoDriver> gmoDrivers) {
        this.gmoDrivers = gmoDrivers;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_turnvehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_turntransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }
    @Column(name = "gmo_turndate")
    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    @OneToMany(mappedBy = "gmoTurn")
    public Set<GmoTurnLine> getGmoTurnLines() {
        return gmoTurnLines;
    }

    public void setGmoTurnLines(Set<GmoTurnLine> gmoTurnLines) {
        this.gmoTurnLines = gmoTurnLines;
    }
}
