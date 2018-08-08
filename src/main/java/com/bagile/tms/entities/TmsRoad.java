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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name =  "seq")
    @Column(name = "tms_roadid")
    private long tmsRoadId;
    
    @Size(max = 30)
    @NotNull
    @Column(name = "tms_roadcode")
    private String tmsRoadCode;
    
    @NotNull
    @Column(name = "tms_roadduration")
    private BigDecimal tmsRoadDuration;
    
    @NotNull
    @Column(name = "tms_roadcoast")
    private BigDecimal tmsRoadCost;
    
    @NotNull
    @Column(name = "tms_roaddistance")
    private BigDecimal tmsRoadDistance;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roaddriver")
    private TmsDriver tmsRoadDriver;
    
    @NotNull
    //@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadadjunct")
    private TmsDriver tmsRoadAdjunct;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_roaddate")
    private Date tmsRoadDate;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadroadstate")
    private TmsRoadState tmsRoadRoadState;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadsaleorder")
    private CmdSaleOrder tmsRoadSaleOrder;
    
    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadstockadress")
    private Set<AdrAddress> tmsRoadStockAddresses;
    
    @NotNull
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadvehicle")
    private TmsVehicle tmsRoadVehicle;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_roadcreationdate")
    private Date tmsRoadCreationDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadcreationuser")
    private UsrUser tmsRoadCreationUser;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_roadupdatedate")
    private Date tmsRoadUpDateDate;

    public TmsRoad() {

    }

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

    public TmsDriver getTmsRoadAdjunct() {
        return tmsRoadAdjunct;
    }

    public void setTmsRoadAdjunct(TmsDriver tmsRoadAdjunct) {
        this.tmsRoadAdjunct = tmsRoadAdjunct;
    }

    public Date getTmsRoadDate() {
        return tmsRoadDate;
    }

    public void setTmsRoadDate(Date tmsRoadDate) {
        this.tmsRoadDate = tmsRoadDate;
    }

    public TmsRoadState getTmsRoadRoadState() {
        return tmsRoadRoadState;
    }

    public void setTmsRoadRoadState(TmsRoadState tmsRoadRoadState) {
        this.tmsRoadRoadState = tmsRoadRoadState;
    }

    public CmdSaleOrder getTmsRoadSaleOrder() {
        return tmsRoadSaleOrder;
    }

    public void setTmsRoadSaleOrder(CmdSaleOrder tmsRoadSaleOrder) {
        this.tmsRoadSaleOrder = tmsRoadSaleOrder;
    }

    public TmsVehicle getTmsRoadVehicle() {
        return tmsRoadVehicle;
    }

    public void setTmsRoadVehicle(TmsVehicle tmsRoadVehicle) {
        this.tmsRoadVehicle = tmsRoadVehicle;
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

    public Date getTmsRoadUpDateDate() {
        return tmsRoadUpDateDate;
    }


    public void setTmsRoadUpDateDate(Date tmsRoadUpDateDate) {
        this.tmsRoadUpDateDate = tmsRoadUpDateDate;
    }

    public Set<AdrAddress> getTmsRoadStockAddresses() {
        return tmsRoadStockAddresses;
    }

    public void setTmsRoadStockAddresses(Set<AdrAddress> tmsRoadStockAddresses) {
        this.tmsRoadStockAddresses = tmsRoadStockAddresses;
    }
}
