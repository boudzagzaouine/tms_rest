package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.dto.SaleOrderStock;
import com.bagile.tms.dto.Transport;
import com.bagile.tms.dto.Vehicle;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_turn")
public class TmsTurn extends EmsEntity {

    private Long TmsTurnId;
    private Set<TmsDriver> tmsDrivers=new HashSet<>();
    private TmsVehicle tmsVehicle;
    private TrpTransport trpTransport;
    private Date dateDelivery ;
    private Set<CmdSaleOrderStock> cmdSaleOrderStocks = new HashSet<>();



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turn_id", allocationSize = 1)
    @Column(name = "tms_turnid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTurnId() {
        return TmsTurnId;
    }

    public void setTmsTurnId(Long tmsTurnId) {
        TmsTurnId = tmsTurnId;
    }

    @ManyToMany
    @JoinTable(
            name = "tms_tour_driver",
            joinColumns = @JoinColumn(name = "tms_tour_id"),
            inverseJoinColumns = @JoinColumn(name = "tms_driver_id"))
    public Set<TmsDriver> getTmsDrivers() {
        return tmsDrivers;
    }

    public void setTmsDrivers(Set<TmsDriver> tmsDrivers) {
        this.tmsDrivers = tmsDrivers;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turnvehicleid")
    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turntransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }
    @Column(name = "tms_turndate")
    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    @OneToMany
    @JoinTable(
            name = "tms_tour_sale_order_stock",
            joinColumns = @JoinColumn(name = "tms_tour_id",referencedColumnName="tms_turnid"),
            inverseJoinColumns = @JoinColumn(name = "tms_sale_order_stock_id",referencedColumnName="cmd_saleorderstockid"))
    public Set<CmdSaleOrderStock> getCmdSaleOrderStocks() {
        return cmdSaleOrderStocks;
    }

    public void setCmdSaleOrderStocks(Set<CmdSaleOrderStock> cmdSaleOrderStocks) {
        this.cmdSaleOrderStocks = cmdSaleOrderStocks;
    }
}
