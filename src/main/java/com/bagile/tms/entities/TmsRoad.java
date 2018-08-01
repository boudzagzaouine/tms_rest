package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tms_road",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_roadId","tms_roadcode"}))
public class TmsRoad implements Serializable {

    private long tmsRoadId;
    @Size(max = 30)
    @NotNull
    private String tmsRoadCode;
    @NotNull
    private BigDecimal tmsRoadDuration;
    @NotNull
    @Size(max = 30)
    private BigDecimal tmsRoadCost;
    @NotNull
    @Size(max = 30)
    private BigDecimal tmsRoadDistance;
    @Size(max = 30)
    private TmsDriver tmsRoadDriver;
    @NotNull
    private TmsDriver tmsRoadadjunct;
    private Date date;
    @NotNull
    private TmsRoadState tmsRoadroadState;
    @NotNull
    private CmdSaleOrder tmsRoadSaleOrder;
    @NotNull
    private AdrAddress tmsRoadStockAdress;
    @NotNull
    private TmsVehicle tmsRoadVehicle;
    @NotNull

    private Date tmsRoadCreationDate;
    private UsrUser tmsRoadCreationUser;
    private UsrUser tmsRoadUpDateUser;

    public TmsRoad() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name =  "seq")
    @Column(name = "tms_roadid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsRoadId() {
        return tmsRoadId;
    }

    public void setTmsRoadId(long tmsRoadId) {
        this.tmsRoadId = tmsRoadId;
    }

    @Column(name = "tms_roadcode", unique = true, nullable = false, scale = 0)
    public String getTmsRoadCode() {
        return tmsRoadCode;
    }

    public void setTmsRoadCode(String tmsRoadCode) {
        this.tmsRoadCode = tmsRoadCode;
    }

    @Column(name = "tms_roadduration", unique = true, nullable = false, scale = 0)
    public BigDecimal getTmsRoadDuration() {
        return tmsRoadDuration;
    }

    public void setTmsRoadDuration(BigDecimal tmsRoadDuration) {
        this.tmsRoadDuration = tmsRoadDuration;
    }

    @Column(name = "tms_roadcoast", unique = true, nullable = false, scale = 0)
    public BigDecimal getTmsRoadCost() {
        return tmsRoadCost;
    }

    public void setTmsRoadCost(BigDecimal tmsRoadCost) {
        this.tmsRoadCost = tmsRoadCost;
    }

    @Column(name = "tms_roaddistance", unique = true, nullable = false, scale = 0)
    public BigDecimal getTmsRoadDistance() {
        return tmsRoadDistance;
    }

    public void setTmsRoadDistance(BigDecimal tmsRoadDistance) {
        this.tmsRoadDistance = tmsRoadDistance;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roaddriver", unique = true, nullable = false, scale = 0)
    public TmsDriver getTmsRoadDriver() {
        return tmsRoadDriver;
    }

    public void setTmsRoadDriver(TmsDriver tmsRoadDriver) {
        this.tmsRoadDriver = tmsRoadDriver;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roadadjunct", unique = true, nullable = false)
    public TmsDriver getTmsRoadadjunct() {
        return tmsRoadadjunct;
    }

    public void setTmsRoadadjunct(TmsDriver tmsRoadadjunct) {
        this.tmsRoadadjunct = tmsRoadadjunct;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_roaddate", unique = true, nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_roadroadstate", unique = true, nullable = false, scale = 0)
    public TmsRoadState getTmsRoadroadState() {
        return tmsRoadroadState;
    }

    public void setTmsRoadroadState(TmsRoadState tmsRoadroadState) {
        this.tmsRoadroadState = tmsRoadroadState;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roadsaleorder", nullable = false)
    public CmdSaleOrder getTmsRoadSaleOrder() {
        return tmsRoadSaleOrder;
    }

    public void setTmsRoadSaleOrder(CmdSaleOrder tmsRoadSaleOrder) {
        this.tmsRoadSaleOrder = tmsRoadSaleOrder;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roadstockadress",nullable = false)
    public AdrAddress getTmsRoadStockAdress() {
        return tmsRoadStockAdress;
    }

    public void setTmsRoadStockAdress(AdrAddress tmsRoadStockAdress) {
        this.tmsRoadStockAdress = tmsRoadStockAdress;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_roadvehicle", unique = true, nullable = false)
    public TmsVehicle getTmsRoadVehicle() {
        return tmsRoadVehicle;
    }

    public void setTmsRoadVehicle(TmsVehicle tmsRoadVehicle) {
        this.tmsRoadVehicle = tmsRoadVehicle;
    }

    @Column(name = "tms_roadcreationdate", unique = true, nullable = false)
    public Date getTmsRoadCreationDate() {
        return tmsRoadCreationDate;
    }

    public void setTmsRoadCreationDate(Date tmsRoadCreationDate) {
        this.tmsRoadCreationDate = tmsRoadCreationDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roadcreationuser", unique = true, nullable = false)
    public UsrUser getTmsRoadCreationUser() {
        return tmsRoadCreationUser;
    }

    public void setTmsRoadCreationUser(UsrUser tmsRoadCreationUser) {
        this.tmsRoadCreationUser = tmsRoadCreationUser;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roadupdateuser", unique = true, nullable = false)
    public UsrUser getTmsRoadUpDateDate() {
        return tmsRoadUpDateUser;
    }


    public void setTmsRoadUpDateUser(UsrUser tmsRoadUpDateUser) {
        this.tmsRoadUpDateUser = tmsRoadUpDateUser;
    }
}
