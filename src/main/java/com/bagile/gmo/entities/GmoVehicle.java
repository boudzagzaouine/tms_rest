package com.bagile.gmo.entities;

import com.bagile.gmo.dto.Driver;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gmo_vehicule")
@DiscriminatorValue("vehicule")
public class GmoVehicle extends GmoPatrimony {

	private static final long serialVersionUID = 612360418697069780L;

	//private Long gmoVehicleId;
    private String gmoRegistrationNumber;
    private Date gmoVehicleTechnicalVisit;
    private BigDecimal gmoVehicleValueTechnicalvisit;
    private GmoVehicleCategory gmoVehicleCategory;
    private GmoBadgeType gmoBadgeType;
    private GmoInsurance gmoInsurance;
    private GmoContractType gmoContractType;
    private GmoConsumptionType gmoConsumptionType;
    private Date gmoAquisitionDate;
    private BigDecimal gmoAamount;
    private BigDecimal gmoVehicleEngineOil ;
    private BigDecimal  gmoVehicleRearDeck ;
    private BigDecimal gmoVehicleDirection ;
    private BigDecimal gmoVehicleAirFilter ;
    private BigDecimal gmoVehicleRadiator ;
    private BigDecimal gmoVehicleGearBox ;
    private BigDecimal gmoVehicleDesiccantFilter ;
    private String  gmoVehicleGrayCard ;
    private BigDecimal gmoVehicleNumberCylinder ;
    private BigDecimal gmoVehicleFiscalPower ;
    private String gmoVehicleBody;
    private String gmoVehicleChassisNumber ;
    private String gmoVehicleEnergy ;
    private  Date gmoVehicleVignette;
    private BigDecimal gmoVehicleValueVignete;
    private BigDecimal gmoVehicleInitialMileage;
    private BigDecimal gmoVehicleCurrentMileage;

    //private Set<GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules=new HashSet<>();

    private TrpTransport trpTransport;

 //   private Set<TmsTurn> gmoTurns=new HashSet<>();

    private OwnOwner ownOwner;

    private Date gmoVehicleRelease;

    private GmoDriver gmoDriver ;
    private String gmoVehicleFixOrVariable ;
    private Date gmoVehicledateDriver;

    private Set<GmoVehicleProduct> gmoVehicleProductSet = new HashSet<>();

    private String gmoVehicleInterneOrExterne ;
    private Long gmoVehicleDurationInMonths ;

  /*  @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehicule_id", allocationSize = 1)
    @Column(name = "gmo_vehiculeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoVehicleId() {
        return gmoVehicleId;
    }

    public void setGmoVehicleId(Long gmoVehicleId) {
        this.gmoVehicleId = gmoVehicleId;
    }*/

    @Column(name = "gmo_vehiculeregistrationnumber")
    public String getGmoRegistrationNumber() {
        return gmoRegistrationNumber;
    }

    public void setGmoRegistrationNumber(String gmoRegistrationNumber) {
        this.gmoRegistrationNumber = gmoRegistrationNumber;
    }

  /*  @Column(name = "gmo_vehiculecode", unique = true, nullable = false, length = 90)
    public String getGmoPatrimonyCode() {
        return gmoPatrimonyCode;
    }

    public void setGmoPatrimonyCode(String gmoVehicleCode) {
        this.gmoPatrimonyCode = gmoVehicleCode;
    }
*/
    @Temporal(TemporalType.DATE)
    @Column(name = "gmo_vehiculetechnicalvisit")
    public Date getGmoVehicleTechnicalVisit() {
        return gmoVehicleTechnicalVisit;
    }

    public void setGmoVehicleTechnicalVisit(Date gmoVehicleTechnicalVisit) {
        this.gmoVehicleTechnicalVisit = gmoVehicleTechnicalVisit;
    }

    @Column(name = "gmo_vehiculevaluetechnicalvisit")
    public BigDecimal getGmoVehicleValueTechnicalvisit() {
        return gmoVehicleValueTechnicalvisit;
    }

    public void setGmoVehicleValueTechnicalvisit(BigDecimal gmoVehicleValueTechnicalvisit) {
        this.gmoVehicleValueTechnicalvisit = gmoVehicleValueTechnicalvisit;
    }

    @Column(name = "gmo_vehiculeinterneorexterne")
    public String getGmoVehicleInterneOrExterne() {
        return gmoVehicleInterneOrExterne;
    }

    public void setGmoVehicleInterneOrExterne(String gmoVehicleInterneOrExterne) {
        this.gmoVehicleInterneOrExterne = gmoVehicleInterneOrExterne;
    }

    @Column(name = "gmo_vehiculedurationinmonths")
    public Long getGmoVehicleDurationInMonths() {
        return gmoVehicleDurationInMonths;
    }

    public void setGmoVehicleDurationInMonths(Long gmoVehicleDurationInMonths) {
        this.gmoVehicleDurationInMonths = gmoVehicleDurationInMonths;
    }

    @Column(name = "gmo_vehiculeaquisitiondate")
    public Date getGmoAquisitionDate() {
        return gmoAquisitionDate;
    }

    public void setGmoAquisitionDate(Date gmoAquisitionDate) {
        this.gmoAquisitionDate = gmoAquisitionDate;
    }

    @Column(name = "gmo_gmovehicleinitialmileage")
    public BigDecimal getGmoVehicleInitialMileage() {
        return gmoVehicleInitialMileage;
    }

    public void setGmoVehicleInitialMileage(BigDecimal gmoVehicleMileage) {
        this.gmoVehicleInitialMileage = gmoVehicleMileage;
    }

    @Column(name = "gmo_gmovehiclecurrentmileage")
    public BigDecimal getGmoVehicleCurrentMileage() {
        return gmoVehicleCurrentMileage;
    }

    public void setGmoVehicleCurrentMileage(BigDecimal gmoVehicleCurrentMileage) {
        this.gmoVehicleCurrentMileage = gmoVehicleCurrentMileage;
    }

    @Column(name = "gmo_vehiculeamount")
    public BigDecimal getGmoAamount() {
        return gmoAamount;
    }

    public void setGmoAamount(BigDecimal gmoAamount) {
        this.gmoAamount = gmoAamount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_vehiculecategorieid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_driverid")
    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }

    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
    }

    @Column(name = "gmo_vehiculefixorvariable")
    public String getGmoVehicleFixOrVariable() {
        return gmoVehicleFixOrVariable;
    }

    public void setGmoVehicleFixOrVariable(String gmoVehicleFixOrVariable) {
        this.gmoVehicleFixOrVariable = gmoVehicleFixOrVariable;
    }
    @Column(name = "gmo_vehiculedatedriver")
    public Date getGmoVehicledateDriver() {
        return gmoVehicledateDriver;
    }

    public void setGmoVehicledateDriver(Date gmoVehicledateDriver) {
        this.gmoVehicledateDriver = gmoVehicledateDriver;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_badgetypeid")
    public GmoBadgeType getGmoBadgeType() {
        return gmoBadgeType;
    }

    public void setGmoBadgeType(GmoBadgeType gmoBadgeType) {
        this.gmoBadgeType = gmoBadgeType;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gmo_vehicleinsuranceid")
    public GmoInsurance getGmoInsurance() {
        return gmoInsurance;
    }

    public void setGmoInsurance(GmoInsurance gmoInsurance) {
        this.gmoInsurance = gmoInsurance;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_contracttypeid")
    public GmoContractType getGmoContractType() {
        return gmoContractType;
    }

    public void setGmoContractType(GmoContractType gmoContractType) {
        this.gmoContractType = gmoContractType;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_conummptiontypeid")
    public GmoConsumptionType getGmoConsumptionType() {
        return gmoConsumptionType;
    }

    public void setGmoConsumptionType(GmoConsumptionType gmoConsumptionType) {
        this.gmoConsumptionType = gmoConsumptionType;
    }



    @Column(name = "gmo_vehiculeengineoil")

    public BigDecimal getGmoVehicleEngineOil() {
        return gmoVehicleEngineOil;
    }

    public void setGmoVehicleEngineOil(BigDecimal gmoVehicleEngineOil) {
        this.gmoVehicleEngineOil = gmoVehicleEngineOil;
    }

    @Column(name = "gmo_vehiculereardeck")
    public BigDecimal getGmoVehicleRearDeck() {
        return gmoVehicleRearDeck;
    }

    public void setGmoVehicleRearDeck(BigDecimal gmoVehicleRearDeck) {
        this.gmoVehicleRearDeck = gmoVehicleRearDeck;
    }

    @Column(name = "gmo_vehiculedirection")
    public BigDecimal getGmoVehicleDirection() {
        return gmoVehicleDirection;
    }

    public void setGmoVehicleDirection(BigDecimal gmoVehicleDirection) {
        this.gmoVehicleDirection = gmoVehicleDirection;
    }

    @Column(name = "gmo_vehiculeairfilter")
    public BigDecimal getGmoVehicleAirFilter() {
        return gmoVehicleAirFilter;
    }

    public void setGmoVehicleAirFilter(BigDecimal gmoVehicleAirFilter) {
        this.gmoVehicleAirFilter = gmoVehicleAirFilter;
    }

    @Column(name = "gmo_vehiculeradiator")
    public BigDecimal getGmoVehicleRadiator() {
        return gmoVehicleRadiator;
    }

    public void setGmoVehicleRadiator(BigDecimal gmoVehicleRadiator) {
        this.gmoVehicleRadiator = gmoVehicleRadiator;
    }

    @Column(name = "gmo_vehiculegearbox")
    public BigDecimal getGmoVehicleGearBox() {
        return gmoVehicleGearBox;
    }

    public void setGmoVehicleGearBox(BigDecimal gmoVehicleGearBox) {
        this.gmoVehicleGearBox = gmoVehicleGearBox;
    }

    @Column(name = "gmo_vehiculedesiccantfilter")
    public BigDecimal getGmoVehicleDesiccantFilter() {
        return gmoVehicleDesiccantFilter;
    }

    public void setGmoVehicleDesiccantFilter(BigDecimal gmoVehicleDesiccantFilter) {
        this.gmoVehicleDesiccantFilter = gmoVehicleDesiccantFilter;
    }

    @Column(name = "gmo_vehiculegraycard")
    public String getGmoVehicleGrayCard() {
        return gmoVehicleGrayCard;
    }

    public void setGmoVehicleGrayCard(String gmoVehicleGrayCard) {
        this.gmoVehicleGrayCard = gmoVehicleGrayCard;
    }

    @Column(name = "gmo_vehiculenumbercylinder")
    public BigDecimal getGmoVehicleNumberCylinder() {
        return gmoVehicleNumberCylinder;
    }

    public void setGmoVehicleNumberCylinder(BigDecimal gmoVehicleNumberCylinder) {
        this.gmoVehicleNumberCylinder = gmoVehicleNumberCylinder;
    }

    @Column(name = "gmo_vehiculefiscalpower")
    public BigDecimal getGmoVehicleFiscalPower() {
        return gmoVehicleFiscalPower;
    }

    public void setGmoVehicleFiscalPower(BigDecimal gmoVehicleFiscalPower) {
        this.gmoVehicleFiscalPower = gmoVehicleFiscalPower;
    }

    @Column(name = "gmo_vehiculebody")
    public String getGmoVehicleBody() {
        return gmoVehicleBody;
    }

    public void setGmoVehicleBody(String gmoVehicleBody) {
        this.gmoVehicleBody = gmoVehicleBody;
    }

    @Column(name = "gmo_vehiculechassisnumber")
    public String getGmoVehicleChassisNumber() {
        return gmoVehicleChassisNumber;
    }

    public void setGmoVehicleChassisNumber(String gmoVehicleChassisNumber) {
        this.gmoVehicleChassisNumber = gmoVehicleChassisNumber;
    }

    @Column(name = "gmo_vehiculeenergy")
    public String getGmoVehicleEnergy() {
        return gmoVehicleEnergy;
    }

    public void setGmoVehicleEnergy(String gmoVehicleEnergy) {
        this.gmoVehicleEnergy = gmoVehicleEnergy;
    }

    @Column(name = "gmo_vehiculevignette")
    public Date getGmoVehicleVignette() {
        return gmoVehicleVignette;
    }

    public void setGmoVehicleVignette(Date gmoVehicleVignette) {
        this.gmoVehicleVignette = gmoVehicleVignette;
    }
    @Column(name = "gmo_vehiculevaluevignette")
    public BigDecimal getGmoVehicleValueVignete() {
        return gmoVehicleValueVignete;
    }

    public void setGmoVehicleValueVignete(BigDecimal gmoVehicleValueVignete) {
        this.gmoVehicleValueVignete = gmoVehicleValueVignete;
    }

   /* @OneToMany(mappedBy = "gmoVehicle",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<GmoInsuranceTermsVehicule> getGmoInsuranceTermsVehicules() {
        return gmoInsuranceTermsVehicules;
    }

    public void setGmoInsuranceTermsVehicules(Set<GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules) {
        this.gmoInsuranceTermsVehicules = gmoInsuranceTermsVehicules;
    }*/
    @ManyToOne()
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }


   /* @OneToMany(mappedBy = "gmoVehicle",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsTurn> getGmoTurns() {
        return gmoTurns;
    }

    public void setGmoTurns(Set<TmsTurn> gmoTurns) {
        this.gmoTurns = gmoTurns;
    }*/

    @OneToMany(mappedBy = "gmoVehicle",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<GmoVehicleProduct> getGmoVehicleProductSet() {
        return gmoVehicleProductSet;
    }

    public void setGmoVehicleProductSet(Set<GmoVehicleProduct> gmoVehicleProductSet) {
        this.gmoVehicleProductSet = gmoVehicleProductSet;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Column(name = "gmo_vehiculerelease")
    public Date getGmoVehicleRelease() {
        return gmoVehicleRelease;
    }

    public void setGmoVehicleRelease(Date gmoVehicleRelease) {
        this.gmoVehicleRelease = gmoVehicleRelease;
    }


}
