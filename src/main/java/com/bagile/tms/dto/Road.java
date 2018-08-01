package com.bagile.tms.dto;

import com.bagile.tms.entities.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Road implements Serializable {

    private long id;

    private String code;

    private BigDecimal duration;

    private BigDecimal cost;

    private BigDecimal distance;

    private TmsDriver driver;

    private Driver adjunct;
    private Date date;

    private RoadState state;

    private SaleOrder saleOrder;

    private Address stockAdress;

    private Vehicle tmsRoadVehicle;

    private Date roadDate;
    private Date creationDate;
    private User creationUser;
    private User upDateUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public TmsDriver getDriver() {
        return driver;
    }

    public void setDriver(TmsDriver driver) {
        this.driver = driver;
    }

    public Driver getAdjunct() {
        return adjunct;
    }

    public void setAdjunct(Driver adjunct) {
        this.adjunct = adjunct;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RoadState getState() {
        return state;
    }

    public void setState(RoadState state) {
        this.state = state;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public Address getStockAdress() {
        return stockAdress;
    }

    public void setStockAdress(Address stockAdress) {
        this.stockAdress = stockAdress;
    }

    public Vehicle getTmsRoadVehicle() {
        return tmsRoadVehicle;
    }

    public void setTmsRoadVehicle(Vehicle tmsRoadVehicle) {
        this.tmsRoadVehicle = tmsRoadVehicle;
    }

    public Date getRoadDate() {
        return roadDate;
    }

    public void setRoadDate(Date roadDate) {
        this.roadDate = roadDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public User getUpDateUser() {
        return upDateUser;
    }

    public void setUpDateUser(User upDateUser) {
        this.upDateUser = upDateUser;
    }
}
