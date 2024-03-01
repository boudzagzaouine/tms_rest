package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Vehicle extends Patrimony implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6072929769333595397L;
   // private long id;
    private String registrationNumber;
    //private String code;
    private Date technicalVisit;
    private BigDecimal valueTechnicalVisit;
    private Date creationDate;
    private VehicleCategory vehicleCategory;
    private BadgeType badgeType;
   // private Insurance insurance;
    private ContractType contractType;
    private ConsumptionType consumptionType;
    private BigDecimal engineOil ;
   private BigDecimal  rearDeck ;
   private BigDecimal direction ;
   private BigDecimal airFilter ;
   private BigDecimal radiator ;
    private BigDecimal gearBox ;
   private BigDecimal desiccantFilter ;
   private String  grayCard ;
   private BigDecimal numberCylinder ;
   private BigDecimal fiscalPower ;
   private String body;
   private String chassisNumber ;
   private String energy ;
   private Date     vignette ;
   private BigDecimal valueVignette;
   private Date aquisitionDate;
   private BigDecimal amount;
   private Transport transport;
    private BigDecimal initialMileage;
    private BigDecimal currentMileage;
//    private List<InsuranceTermsVehicle> insuranceTermVehicles=new ArrayList<>();
    private List<Turn> turns=new ArrayList<>();

    private Date release; // mise en circulation
    private BigDecimal age;
 private Owner owner;
    private Driver driver ;
    private String fixOrVariable ;
    private Date dateDriver;
    private String interneOrExterne ;
    private Long durationInMonths ;
    private List<VehicleProduct> vehicleProducts = new ArrayList<>();

    private VehicleTray vehicleTray;
    private BrandVehicleType brandVehicleType;
    private String codeRegistrationNumber; // local

    private Double latitude;
    private Double longitude;
    private Long disponible; //1 trajet //2 panne //3 maintenance // 4 disponible //
    private String lastPointCity;
    private Date lastPointDate;



    public Vehicle() {
    }

  /*  public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
*/

    public String getCodeRegistrationNumber() {
        return this.getCode() +" - "+this.registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

  /* public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
*/

    public String getLastPointCity() {
        return lastPointCity;
    }

    public void setLastPointCity(String lastPointCity) {
        this.lastPointCity = lastPointCity;
    }

    public Date getLastPointDate() {
        return lastPointDate;
    }

    public void setLastPointDate(Date lastPointDate) {
        this.lastPointDate = lastPointDate;
    }

    public VehicleTray getVehicleTray() {
        return vehicleTray;
    }

    public void setVehicleTray(VehicleTray vehicleTray) {
        this.vehicleTray = vehicleTray;
    }

    public String getInterneOrExterne() {
        return interneOrExterne;
    }

    public void setInterneOrExterne(String interneOrExterne) {
        this.interneOrExterne = interneOrExterne;
    }

    public BigDecimal getInitialMileage() {
        return initialMileage;
    }

    public void setInitialMileage(BigDecimal initialMileage) {
        this.initialMileage = initialMileage;
    }

    public BigDecimal getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(BigDecimal currentMileage) {
        this.currentMileage = currentMileage;
    }

    public Date getTechnicalVisit() {
        return technicalVisit;
    }

    public void setTechnicalVisit(Date technicalVisit) {
        this.technicalVisit = technicalVisit;
    }

    public Date getAquisitionDate() {
        return aquisitionDate;
    }

    public void setAquisitionDate(Date aquisitionDate) {
        this.aquisitionDate = aquisitionDate;
    }

    public BrandVehicleType getBrandVehicleType() {
        return brandVehicleType;
    }

    public void setBrandVehicleType(BrandVehicleType brandVehicleType) {
        this.brandVehicleType = brandVehicleType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getValueTechnicalVisit() {
        return valueTechnicalVisit;
    }

    public void setValueTechnicalVisit(BigDecimal valueTechnicalVisit) {
        this.valueTechnicalVisit = valueTechnicalVisit;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public BadgeType getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(BadgeType badgeType) {
        this.badgeType = badgeType;
    }

  /*  public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }


*/
    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }


    public BigDecimal getEngineOil() {
        return engineOil;
    }

    public void setEngineOil(BigDecimal engineOil) {
        this.engineOil = engineOil;
    }

    public BigDecimal getRearDeck() {
        return rearDeck;
    }

    public void setRearDeck(BigDecimal rearDeck) {
        this.rearDeck = rearDeck;
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

    public Long getDisponible() {
        return disponible;
    }

    public void setDisponible(Long disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getDirection() {
        return direction;
    }

    public void setDirection(BigDecimal direction) {
        this.direction = direction;
    }

    public BigDecimal getAirFilter() {
        return airFilter;
    }

    public void setAirFilter(BigDecimal airFilter) {
        this.airFilter = airFilter;
    }

    public BigDecimal getRadiator() {
        return radiator;
    }

    public void setRadiator(BigDecimal radiator) {
        this.radiator = radiator;
    }

    public BigDecimal getGearBox() {
        return gearBox;
    }

    public void setGearBox(BigDecimal gearBox) {
        this.gearBox = gearBox;
    }

    public BigDecimal getDesiccantFilter() {
        return desiccantFilter;
    }

    public void setDesiccantFilter(BigDecimal desiccantFilter) {
        this.desiccantFilter = desiccantFilter;
    }

    public String getGrayCard() {
        return grayCard;
    }

    public void setGrayCard(String grayCard) {
        this.grayCard = grayCard;
    }

    public BigDecimal getNumberCylinder() {
        return numberCylinder;
    }

    public void setNumberCylinder(BigDecimal numberCylinder) {
        this.numberCylinder = numberCylinder;
    }

    public BigDecimal getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(BigDecimal fiscalPower) {
        this.fiscalPower = fiscalPower;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public Date getVignette() {
        return vignette;
    }

    public void setVignette(Date vignette) {
        this.vignette = vignette;
    }

    public BigDecimal getValueVignette() {
        return valueVignette;
    }

    public void setValueVignette(BigDecimal valueVignette) {
        this.valueVignette = valueVignette;
    }

    /*public List<InsuranceTermsVehicle> getInsuranceTermVehicles() {
        return insuranceTermVehicles;
    }

    public void setInsuranceTermVehicles(List<InsuranceTermsVehicle> insuranceTermVehicles) {
        this.insuranceTermVehicles = insuranceTermVehicles;
    }*/

    public ConsumptionType getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(ConsumptionType consumptionType) {
        this.consumptionType = consumptionType;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getFixOrVariable() {
        return fixOrVariable;
    }

    public void setFixOrVariable(String fixOrVariable) {
        this.fixOrVariable = fixOrVariable;
    }

    public Date getDateDriver() {
        return dateDriver;
    }

    public void setDateDriver(Date dateDriver) {
        this.dateDriver = dateDriver;
    }

    public List<VehicleProduct> getVehicleProducts() {
        return vehicleProducts;
    }

    public void setVehicleProducts(List<VehicleProduct> vehicleProducts) {
        this.vehicleProducts = vehicleProducts;
    }

    public Long getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Long durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getId() == vehicle.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
