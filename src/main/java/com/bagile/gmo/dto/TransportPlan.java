package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class TransportPlan extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;

    private OrderTransport orderTransport;
    private Vehicle vehicle ;
    private String vehicleExterne;

    private Driver driver;
    private String driverExterne;

    private VehicleCategory vehicleCategory;
    private Transport  transport;
    private Account account;
    private TurnStatus turnStatus;

    private BigDecimal purchasePrice;
    private BigDecimal purchasePriceNegotiated;
    private Vat purchaseVat;

    private BigDecimal purchasePriceTtc;
    private BigDecimal purchasePriceVat;


    private String  remark ;
    private BigDecimal salePrice;

    private BigDecimal marginRate;
    private BigDecimal margineService;

    private Trajet trajet;
    private Ville villeSource;
    private Ville villeDistination;
    private Date dateDepart;
    private Date dateDepartDriver;

    private Date dateValidate;

    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal totalPriceVat;

    private BigDecimal totalServiceHT;
    private BigDecimal totalServiceTTC;
    private BigDecimal totalServiceVat;
    private  Date closeDate;

    private Double latitude;
    private Double longitude;
    // private List<TransportPlanServiceCatalog> transportPlanServiceCatalogs = new ArrayList<>();

    public TransportPlan() {
    }

    public Date getDateDepartDriver() {
        return dateDepartDriver;
    }

    public void setDateDepartDriver(Date dateDepartDriver) {
        this.dateDepartDriver = dateDepartDriver;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderTransport getOrderTransport() {
        return orderTransport;
    }

    public void setOrderTransport(OrderTransport orderTransport) {
        this.orderTransport = orderTransport;
    }

    public String getVehicleExterne() {
        return vehicleExterne;
    }

    public void setVehicleExterne(String vehicleExterne) {
        this.vehicleExterne = vehicleExterne;
    }

    public String getDriverExterne() {
        return driverExterne;
    }

    public void setDriverExterne(String driverExterne) {
        this.driverExterne = driverExterne;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public BigDecimal getPurchasePriceNegotiated() {
        return purchasePriceNegotiated;
    }

    public void setPurchasePriceNegotiated(BigDecimal purchasePriceNegotiated) {
        this.purchasePriceNegotiated = purchasePriceNegotiated;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(BigDecimal marginRate) {
        this.marginRate = marginRate;
    }

    public Date getDateValidate() {
        return dateValidate;
    }

    public void setDateValidate(Date dateValidate) {
        this.dateValidate = dateValidate;
    }

    public BigDecimal getMargineService() {
        return margineService;
    }

    public void setMargineService(BigDecimal margineService) {
        this.margineService = margineService;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vat getPurchaseVat() {
        return purchaseVat;
    }

    public void setPurchaseVat(Vat purchaseVat) {
        this.purchaseVat = purchaseVat;
    }

    public BigDecimal getPurchasePriceTtc() {
        return purchasePriceTtc;
    }

    public void setPurchasePriceTtc(BigDecimal purchasePriceTtc) {
        this.purchasePriceTtc = purchasePriceTtc;
    }

    public BigDecimal getPurchasePriceVat() {
        return purchasePriceVat;
    }

    public void setPurchasePriceVat(BigDecimal purchasePriceVat) {
        this.purchasePriceVat = purchasePriceVat;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }

    public BigDecimal getTotalPriceVat() {
        return totalPriceVat;
    }

    public BigDecimal getTotalServiceHT() {
        return totalServiceHT;
    }

    public void setTotalServiceHT(BigDecimal totalServiceHT) {
        this.totalServiceHT = totalServiceHT;
    }

    public BigDecimal getTotalServiceTTC() {
        return totalServiceTTC;
    }

    public void setTotalServiceTTC(BigDecimal totalServiceTTC) {
        this.totalServiceTTC = totalServiceTTC;
    }

    public BigDecimal getTotalServiceVat() {
        return totalServiceVat;
    }

    public void setTotalServiceVat(BigDecimal totalServiceVat) {
        this.totalServiceVat = totalServiceVat;
    }

    public void setTotalPriceVat(BigDecimal totalPriceVat) {
        this.totalPriceVat = totalPriceVat;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Ville getVilleSource() {
        return villeSource;
    }

    public void setVilleSource(Ville villeSource) {
        this.villeSource = villeSource;
    }


    public Ville getVilleDistination() {
        return villeDistination;
    }

    public void setVilleDistination(Ville villeDistination) {
        this.villeDistination = villeDistination;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

//    public List<TransportPlanServiceCatalog> getTransportPlanServiceCatalogs() {
//        return transportPlanServiceCatalogs;
//    }
//
//    public void setTransportPlanServiceCatalogs(List<TransportPlanServiceCatalog> transportPlanServiceCatalogs) {
//        this.transportPlanServiceCatalogs = transportPlanServiceCatalogs;
//    }

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
