package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tms_vehicule")
public class TmsVehicle extends EmsEntity {

    private long tmsVehicleId;
    private String tmsRegistrationNumber;
    private String tmsVehicleCode;
    private Date tmsVehicleTechnicalVisit;
    private BigDecimal tmsVehicleValueTechnicalvisit;
    private TmsVehicleCategory tmsVehicleCategory;
    private TmsBadgeType tmsBadgeType;
    private TmsInsurance tmsInsurance;
    private TmsContractType tmsContractType;

    private BigDecimal tmsVehicleEngineOil ;
    private BigDecimal  tmsVehicleRearDeck ;
    private BigDecimal tmsVehicleDirection ;
    private BigDecimal tmsVehicleAirFilter ;
    private BigDecimal tmsVehicleRadiator ;
    private BigDecimal tmsVehicleGearBox ;
    private BigDecimal tmsVehicleDesiccantFilter ;
    private String  tmsVehicleGrayCard ;
    private BigDecimal tmsVehicleNumberCylinder ;
    private BigDecimal tmsVehicleFiscalPower ;
    private String tmsVehicleBody;
    private String tmsVehicleChassisNumber ;
    private String tmsVehicleEnergy ;
    private  Date tmsVehicleVignette;
    private BigDecimal tmsVehicleValueVignete;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicule_id", allocationSize = 1)
    @Column(name = "tms_vehiculeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }

    @Column(name = "tms_vehiculeregistrationnumber")
    public String getTmsRegistrationNumber() {
        return tmsRegistrationNumber;
    }

    public void setTmsRegistrationNumber(String tmsRegistrationNumber) {
        this.tmsRegistrationNumber = tmsRegistrationNumber;
    }

    @Column(name = "tms_vehiculecode", unique = true, nullable = false, length = 90)
    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tms_vehiculetechnicalvisit")
    public Date getTmsVehicleTechnicalVisit() {
        return tmsVehicleTechnicalVisit;
    }

    public void setTmsVehicleTechnicalVisit(Date tmsVehicleTechnicalVisit) {
        this.tmsVehicleTechnicalVisit = tmsVehicleTechnicalVisit;
    }

    @Column(name = "tms_vehiculevaluetechnicalvisit")
    public BigDecimal getTmsVehicleValueTechnicalvisit() {
        return tmsVehicleValueTechnicalvisit;
    }

    public void setTmsVehicleValueTechnicalvisit(BigDecimal tmsVehicleValueTechnicalvisit) {
        this.tmsVehicleValueTechnicalvisit = tmsVehicleValueTechnicalvisit;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_vehiculecategorieid")
    public TmsVehicleCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(TmsVehicleCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_badgetypeid")
    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tms_vehicleinsuranceid")
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_contracttypeid")
    public TmsContractType getTmsContractType() {
        return tmsContractType;
    }

    public void setTmsContractType(TmsContractType tmsContractType) {
        this.tmsContractType = tmsContractType;
    }

    @Column(name = "tms_vehiculeengineoil")

    public BigDecimal getTmsVehicleEngineOil() {
        return tmsVehicleEngineOil;
    }

    public void setTmsVehicleEngineOil(BigDecimal tmsVehicleEngineOil) {
        this.tmsVehicleEngineOil = tmsVehicleEngineOil;
    }

    @Column(name = "tms_vehiculereardeck")
    public BigDecimal getTmsVehicleRearDeck() {
        return tmsVehicleRearDeck;
    }

    public void setTmsVehicleRearDeck(BigDecimal tmsVehicleRearDeck) {
        this.tmsVehicleRearDeck = tmsVehicleRearDeck;
    }

    @Column(name = "tms_vehiculedirection")
    public BigDecimal getTmsVehicleDirection() {
        return tmsVehicleDirection;
    }

    public void setTmsVehicleDirection(BigDecimal tmsVehicleDirection) {
        this.tmsVehicleDirection = tmsVehicleDirection;
    }

    @Column(name = "tms_vehiculeairfilter")
    public BigDecimal getTmsVehicleAirFilter() {
        return tmsVehicleAirFilter;
    }

    public void setTmsVehicleAirFilter(BigDecimal tmsVehicleAirFilter) {
        this.tmsVehicleAirFilter = tmsVehicleAirFilter;
    }

    @Column(name = "tms_vehiculeradiator")
    public BigDecimal getTmsVehicleRadiator() {
        return tmsVehicleRadiator;
    }

    public void setTmsVehicleRadiator(BigDecimal tmsVehicleRadiator) {
        this.tmsVehicleRadiator = tmsVehicleRadiator;
    }

    @Column(name = "tms_vehiculegearbox")
    public BigDecimal getTmsVehicleGearBox() {
        return tmsVehicleGearBox;
    }

    public void setTmsVehicleGearBox(BigDecimal tmsVehicleGearBox) {
        this.tmsVehicleGearBox = tmsVehicleGearBox;
    }

    @Column(name = "tms_vehiculedesiccantfilter")
    public BigDecimal getTmsVehicleDesiccantFilter() {
        return tmsVehicleDesiccantFilter;
    }

    public void setTmsVehicleDesiccantFilter(BigDecimal tmsVehicleDesiccantFilter) {
        this.tmsVehicleDesiccantFilter = tmsVehicleDesiccantFilter;
    }

    @Column(name = "tms_vehiculegraycard")
    public String getTmsVehicleGrayCard() {
        return tmsVehicleGrayCard;
    }

    public void setTmsVehicleGrayCard(String tmsVehicleGrayCard) {
        this.tmsVehicleGrayCard = tmsVehicleGrayCard;
    }

    @Column(name = "tms_vehiculenumbercylinder")
    public BigDecimal getTmsVehicleNumberCylinder() {
        return tmsVehicleNumberCylinder;
    }

    public void setTmsVehicleNumberCylinder(BigDecimal tmsVehicleNumberCylinder) {
        this.tmsVehicleNumberCylinder = tmsVehicleNumberCylinder;
    }

    @Column(name = "tms_vehiculefiscalpower")
    public BigDecimal getTmsVehicleFiscalPower() {
        return tmsVehicleFiscalPower;
    }

    public void setTmsVehicleFiscalPower(BigDecimal tmsVehicleFiscalPower) {
        this.tmsVehicleFiscalPower = tmsVehicleFiscalPower;
    }

    @Column(name = "tms_vehiculebody")
    public String getTmsVehicleBody() {
        return tmsVehicleBody;
    }

    public void setTmsVehicleBody(String tmsVehicleBody) {
        this.tmsVehicleBody = tmsVehicleBody;
    }

    @Column(name = "tms_vehiculechassisnumber")
    public String getTmsVehicleChassisNumber() {
        return tmsVehicleChassisNumber;
    }

    public void setTmsVehicleChassisNumber(String tmsVehicleChassisNumber) {
        this.tmsVehicleChassisNumber = tmsVehicleChassisNumber;
    }

    @Column(name = "tms_vehiculeenergy")
    public String getTmsVehicleEnergy() {
        return tmsVehicleEnergy;
    }

    public void setTmsVehicleEnergy(String tmsVehicleEnergy) {
        this.tmsVehicleEnergy = tmsVehicleEnergy;
    }

    @Column(name = "tms_vehiculevignette")
    public Date getTmsVehicleVignette() {
        return tmsVehicleVignette;
    }

    public void setTmsVehicleVignette(Date tmsVehicleVignette) {
        this.tmsVehicleVignette = tmsVehicleVignette;
    }
    @Column(name = "tms_vehiculevaluevignette")
    public BigDecimal getTmsVehicleValueVignete() {
        return tmsVehicleValueVignete;
    }

    public void setTmsVehicleValueVignete(BigDecimal tmsVehicleValueVignete) {
        this.tmsVehicleValueVignete = tmsVehicleValueVignete;
    }
}
