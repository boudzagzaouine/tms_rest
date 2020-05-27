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
    private String code;
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

//    private List<InsuranceTermsVehicle> insuranceTermVehicles=new ArrayList<>();

    private List<Turn> turns=new ArrayList<>();


    public Vehicle() {
    }

  /*  public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
*/
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
