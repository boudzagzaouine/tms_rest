package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tms_road")
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
    private Date tmsRoadDate;
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

    public String getTmsRoadCode() {
        return tmsRoadCode;
    }

    public void setTmsRoadCode(String tmsRoadCode) {
        this.tmsRoadCode = tmsRoadCode;
    }

    public BigDecimal getTmsRoadDuration() {
        return tmsRoadDuration;
    }

    public void setTmsRoadDuration(BigDecimal tmsRoadDuration) {
        this.tmsRoadDuration = tmsRoadDuration;
    }

    public BigDecimal getTmsRoadCost() {
        return tmsRoadCost;
    }

    public void setTmsRoadCost(BigDecimal tmsRoadCost) {
        this.tmsRoadCost = tmsRoadCost;
    }

    public BigDecimal getTmsRoadDistance() {
        return tmsRoadDistance;
    }

    public void setTmsRoadDistance(BigDecimal tmsRoadDistance) {
        this.tmsRoadDistance = tmsRoadDistance;
    }

    public TmsDriver getTmsRoadDriver() {
        return tmsRoadDriver;
    }

    public void setTmsRoadDriver(TmsDriver tmsRoadDriver) {
        this.tmsRoadDriver = tmsRoadDriver;
    }

    public TmsDriver getTmsRoadadjunct() {
        return tmsRoadadjunct;
    }

    public void setTmsRoadadjunct(TmsDriver tmsRoadadjunct) {
        this.tmsRoadadjunct = tmsRoadadjunct;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TmsRoadState getTmsRoadroadState() {
        return tmsRoadroadState;
    }

    public void setTmsRoadroadState(TmsRoadState tmsRoadroadState) {
        this.tmsRoadroadState = tmsRoadroadState;
    }

    public CmdSaleOrder getTmsRoadSaleOrder() {
        return tmsRoadSaleOrder;
    }

    public void setTmsRoadSaleOrder(CmdSaleOrder tmsRoadSaleOrder) {
        this.tmsRoadSaleOrder = tmsRoadSaleOrder;
    }

    public AdrAddress getTmsRoadStockAdress() {
        return tmsRoadStockAdress;
    }

    public void setTmsRoadStockAdress(AdrAddress tmsRoadStockAdress) {
        this.tmsRoadStockAdress = tmsRoadStockAdress;
    }

    public TmsVehicle getTmsRoadVehicle() {
        return tmsRoadVehicle;
    }

    public void setTmsRoadVehicle(TmsVehicle tmsRoadVehicle) {
        this.tmsRoadVehicle = tmsRoadVehicle;
    }

    public Date getTmsRoadDate() {
        return tmsRoadDate;
    }

    public void setTmsRoadDate(Date tmsRoadDate) {
        this.tmsRoadDate = tmsRoadDate;
    }

    public Date getTmsRoadCreationDate() {
        return tmsRoadCreationDate;
    }

    public void setTmsRoadCreationDate(Date tmsRoadCreationDate) {
        this.tmsRoadCreationDate = tmsRoadCreationDate;
    }

    public UsrUser getTmsRoadCreationUser() {
        return tmsRoadCreationUser;
    }

    public void setTmsRoadCreationUser(UsrUser tmsRoadCreationUser) {
        this.tmsRoadCreationUser = tmsRoadCreationUser;
    }

    public UsrUser getTmsRoadUpDateUser() {
        return tmsRoadUpDateUser;
    }

    public void setTmsRoadUpDateUser(UsrUser tmsRoadUpDateUser) {
        this.tmsRoadUpDateUser = tmsRoadUpDateUser;
    }
}
