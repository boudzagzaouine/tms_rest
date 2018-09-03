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
    private BigDecimal tmsRoadCost;
    
    @NotNull
    private BigDecimal tmsRoadDistance;

    private long tmsRoadDriver;
    
    @NotNull
    private long tmsRoadAdjunct;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tmsRoadDate;
    
    @NotNull
    private TmsRoadState tmsRoadRoadState;
    
    @NotNull
    private CmdSaleOrder tmsRoadSaleOrder;
    
    @NotNull
    private Set<AdrAddress> tmsRoadStockAddresses;
    
    @NotNull
    private TmsVehicle tmsRoadVehicle;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmsRoadCreationDate;

    private UsrUser tmsRoadCreationUser;

    private Date tmsRoadUpDateDate;

    public TmsRoad() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_roadsequence")
    @Column(name = "tms_roadid")
    public long getTmsRoadId() {
        return tmsRoadId;
    }

    public void setTmsRoadId(long tmsRoadId) {
        this.tmsRoadId = tmsRoadId;
    }

    @Column(name = "tms_roadcode")
    public String getTmsRoadCode() {
        return tmsRoadCode;
    }

    public void setTmsRoadCode(String tmsRoadCode) {
        this.tmsRoadCode = tmsRoadCode;
    }

    @Column(name = "tms_roadduration")
    public BigDecimal getTmsRoadDuration() {
        return tmsRoadDuration;
    }

    public void setTmsRoadDuration(BigDecimal tmsRoadDuration) {
        this.tmsRoadDuration = tmsRoadDuration;
    }

    @Column(name = "tms_roadcoast")
    public BigDecimal getTmsRoadCost() {
        return tmsRoadCost;
    }

    public void setTmsRoadCost(BigDecimal tmsRoadCost) {
        this.tmsRoadCost = tmsRoadCost;
    }

    @Column(name = "tms_roaddistance")
    public BigDecimal getTmsRoadDistance() {
        return tmsRoadDistance;
    }

    public void setTmsRoadDistance(BigDecimal tmsRoadDistance) {
        this.tmsRoadDistance = tmsRoadDistance;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roaddriverid")

    public long getTmsRoadDriver() {
        return tmsRoadDriver;
    }

    public void setTmsRoadDriver(long tmsRoadDriver) {
        this.tmsRoadDriver = tmsRoadDriver;
    }

    //@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadadjunctid")
    public long getTmsRoadAdjunct() {
        return tmsRoadAdjunct;
    }

    public void setTmsRoadAdjunct(long tmsRoadAdjunct) {
        this.tmsRoadAdjunct = tmsRoadAdjunct;
    }

    @Column(name = "tms_roaddate")
    public Date getTmsRoadDate() {
        return tmsRoadDate;
    }

    public void setTmsRoadDate(Date tmsRoadDate) {
        this.tmsRoadDate = tmsRoadDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadroadstateid")
    public TmsRoadState getTmsRoadRoadState() {
        return tmsRoadRoadState;
    }

    public void setTmsRoadRoadState(TmsRoadState tmsRoadRoadState) {
        this.tmsRoadRoadState = tmsRoadRoadState;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadsaleorderid")
    public CmdSaleOrder getTmsRoadSaleOrder() {
        return tmsRoadSaleOrder;
    }

    public void setTmsRoadSaleOrder(CmdSaleOrder tmsRoadSaleOrder) {
        this.tmsRoadSaleOrder = tmsRoadSaleOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadvehicleid")
    public TmsVehicle getTmsRoadVehicle() {
        return tmsRoadVehicle;
    }

    public void setTmsRoadVehicle(TmsVehicle tmsRoadVehicle) {
        this.tmsRoadVehicle = tmsRoadVehicle;
    }

    @Column(name = "tms_roadcreationdate")
    public Date getTmsRoadCreationDate() {
        return tmsRoadCreationDate;
    }

    public void setTmsRoadCreationDate(Date tmsRoadCreationDate) {
        this.tmsRoadCreationDate = tmsRoadCreationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadcreationuserid")
    public UsrUser getTmsRoadCreationUser() {
        return tmsRoadCreationUser;
    }

    public void setTmsRoadCreationUser(UsrUser tmsRoadCreationUser) {
        this.tmsRoadCreationUser = tmsRoadCreationUser;
    }

    @Column(name = "tms_roadupdatedate")
    public Date getTmsRoadUpDateDate() {
        return tmsRoadUpDateDate;
    }


    public void setTmsRoadUpDateDate(Date tmsRoadUpDateDate) {
        this.tmsRoadUpDateDate = tmsRoadUpDateDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadstockadressid")
    public Set<AdrAddress> getTmsRoadStockAddresses() {
        return tmsRoadStockAddresses;
    }

    public void setTmsRoadStockAddresses(Set<AdrAddress> tmsRoadStockAddresses) {
        this.tmsRoadStockAddresses = tmsRoadStockAddresses;
    }
}
