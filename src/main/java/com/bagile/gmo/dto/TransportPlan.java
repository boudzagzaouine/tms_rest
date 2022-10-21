package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class TransportPlan extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private String code;
    private Set<Driver>drivers=new HashSet<>();
    private Vehicle  vehicle;
   private Transport transport;
    private Date dateDelivery;
   private List<TurnSoPo> turnSoPos = new ArrayList<>();
    private List<TurnTransport> turnTransports = new ArrayList<>();

    private TurnType turnType;
    private BigDecimal totalSoTTC;
    private BigDecimal totalPoTTC;
    private BigDecimal totalSoQnt;
    private BigDecimal totalPoQnt ;
    private BigDecimal totalSoPriceTurn ;
    private BigDecimal totalPoPriceTurn;
  private String packagingType;
  private String loadingType;

    public TransportPlan() {
    }


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
public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public List<TurnSoPo> getTurnSoPos() {
        return turnSoPos;
    }

    public void setTurnSoPos(List<TurnSoPo> turnSoPos) {
        this.turnSoPos = turnSoPos;
    }

    public TurnType getTurnType() {
        return turnType;
    }

    public void setTurnType(TurnType turnType) {
        this.turnType = turnType;
    }

    public BigDecimal getTotalSoTTC() {
        return totalSoTTC;
    }

    public void setTotalSoTTC(BigDecimal totalSoTTC) {
        this.totalSoTTC = totalSoTTC;
    }

    public BigDecimal getTotalPoTTC() {
        return totalPoTTC;
    }

    public void setTotalPoTTC(BigDecimal totalPoTTC) {
        this.totalPoTTC = totalPoTTC;
    }

    public BigDecimal getTotalSoQnt() {
        return totalSoQnt;
    }

    public void setTotalSoQnt(BigDecimal totalSoQnt) {
        this.totalSoQnt = totalSoQnt;
    }

    public BigDecimal getTotalPoQnt() {
        return totalPoQnt;
    }

    public void setTotalPoQnt(BigDecimal totalPoQnt) {
        this.totalPoQnt = totalPoQnt;
    }

    public BigDecimal getTotalSoPriceTurn() {
        return totalSoPriceTurn;
    }

    public void setTotalSoPriceTurn(BigDecimal totalSoPriceTurn) {
        this.totalSoPriceTurn = totalSoPriceTurn;
    }

    public BigDecimal getTotalPoPriceTurn() {
        return totalPoPriceTurn;
    }

    public void setTotalPoPriceTurn(BigDecimal totalPoPriceTurn) {
        this.totalPoPriceTurn = totalPoPriceTurn;
    }


    public List<TurnTransport> getTurnTransports() {
        return turnTransports;
    }

    public void setTurnTransports(List<TurnTransport> turnTransports) {
        this.turnTransports = turnTransports;
    }


    public String getLoadingType() {
        return loadingType;
    }

    public void setLoadingType(String loadingType) {
        this.loadingType = loadingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportPlan turn = (TransportPlan) o;
        return getId() == turn.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
