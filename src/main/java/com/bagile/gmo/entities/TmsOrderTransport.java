package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_ordertransport")
public class TmsOrderTransport extends EmsEntity {

    private Long tmsOrderTransportId;
    private String tmsOrderTransportCode;
    private Date tmsOrderTransportDate;

    private TmsPackagingType tmsOrderTransportPackagingType;
    private Boolean tmsOrderTransportConsignment;
    private String tmsOrderTransportPort; // payé  , du
    private String tmsOrderTransportPalletResponsibility ; //true prestataire /false client
    private TmsMarchandiseType tmsOrderTransportMarchandiseType;
    private TmsTurnType tmsOrderTransportType;
    private TmsLoadingType  tmsOrderTransportLoadingType;
    private CmdAccount cmdAccount;
    private PrmContact prmContact;
    private TmsTurnStatus tmsTurnStatus;
    private GmoVehicleCategory gmoVehicleCategory ;
    private TmsVehicleTray tmsVehicleTray;

    private TmsTrajet tmsTrajet;
  // private TmsOrderTransportInfo tmsOrderTransportInfoAller;
   //private TmsOrderTransportInfo tmsOrderTransportInfoRetour;
  private Set<TmsTransportPlanServiceCatalog> orderTransportServiceCatalogs = new HashSet<>();


   private BigDecimal tmsOrderTransportPriceHT;
    private BigDecimal tmsOrderTransportNumberKm;
   private PrmVat prmVat;
    private BigDecimal tmsOrderTransportPriceTTC;
    private BigDecimal tmsOrderTransportPriceVat;

    private BigDecimal tmsOrderTransportMarginRate;


    private BigDecimal tmsOrderTransportMarginValue;

    private BigDecimal tmsOrderTransportTotalServiceHT;
    private BigDecimal tmsOrderTransportTotalServiceVat;
    private BigDecimal tmsOrderTransportTotalServiceTTC;

    private BigDecimal tmsOrderTransportTotalPriceHT;
    private BigDecimal tmsOrderTransportTotalPriceVat;
    private BigDecimal tmsOrderTransportTotalPriceTTC;

    private Boolean tmsOrderTransportGroupageUnique;


    private Set<TmsOrderTransportAccompaniment> tmsOrderTransportAccompaniments = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransport_id", allocationSize = 1)
    @Column(name = "tms_ordertransportid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportId() {
        return tmsOrderTransportId;
    }

    public void setTmsOrderTransportId(Long tmsOrderTransportId) {
        this.tmsOrderTransportId = tmsOrderTransportId;
    }

    @Column(name="tms_ordertransportnumberkm")
    public BigDecimal getTmsOrderTransportNumberKm() {
        return tmsOrderTransportNumberKm;
    }
    public void setTmsOrderTransportNumberKm(BigDecimal tmsOrderTransportNumberKm) {
        this.tmsOrderTransportNumberKm = tmsOrderTransportNumberKm;
    }
    @Column(name = "tms_ordertransportcode",nullable = false)
    public String getTmsOrderTransportCode() {
        return tmsOrderTransportCode;
    }

    public void setTmsOrderTransportCode(String tmsOrderTransportCode) {
        this.tmsOrderTransportCode = tmsOrderTransportCode;
    }

    @Column(name = "tms_ordertransportgroupageunique")
    public Boolean getTmsOrderTransportGroupageUnique() {
        return tmsOrderTransportGroupageUnique;
    }

    public void setTmsOrderTransportGroupageUnique(Boolean tmsOrderTransportGroupageUnique) {
        this.tmsOrderTransportGroupageUnique = tmsOrderTransportGroupageUnique;
    }





    @Column(name="tms_ordertransportdate")
    public Date getTmsOrderTransportDate() {
        return tmsOrderTransportDate;
    }

    public void setTmsOrderTransportDate(Date dateDelivery) {
        this.tmsOrderTransportDate = dateDelivery;
    }

    @Column(name="tms_ordertransportpricevat")

    public BigDecimal getTmsOrderTransportPriceVat() {
        return tmsOrderTransportPriceVat;
    }

    public void setTmsOrderTransportPriceVat(BigDecimal tmsOrderTransportPriceVat) {
        this.tmsOrderTransportPriceVat = tmsOrderTransportPriceVat;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "tmsOrderTransport", orphanRemoval=true)
    public Set<TmsTransportPlanServiceCatalog> getOrderTransportServiceCatalogs() {
        return orderTransportServiceCatalogs;
    }

    public void setOrderTransportServiceCatalogs(Set<TmsTransportPlanServiceCatalog> transportPlanServiceCatalogs) {
        this.orderTransportServiceCatalogs = transportPlanServiceCatalogs;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL},mappedBy = "tmsOrderTransport", orphanRemoval=true)
    public Set<TmsOrderTransportAccompaniment> getTmsOrderTransportAccompaniments() {
        return tmsOrderTransportAccompaniments;
    }

    public void setTmsOrderTransportAccompaniments(Set<TmsOrderTransportAccompaniment> tmsOrderTransportAccompaniments) {
        this.tmsOrderTransportAccompaniments = tmsOrderTransportAccompaniments;
    }





    @Column(name="tms_ordertransportpriceht")
    public BigDecimal getTmsOrderTransportPriceHT() {
        return tmsOrderTransportPriceHT;
    }

    public void setTmsOrderTransportPriceHT(BigDecimal tmsOrderTransportPriceTTC) {
        this.tmsOrderTransportPriceHT = tmsOrderTransportPriceTTC;
    }
    @Column(name="tms_ordertransporttotalserviceht")

    public BigDecimal getTmsOrderTransportTotalServiceHT() {
        return tmsOrderTransportTotalServiceHT;
    }

    public void setTmsOrderTransportTotalServiceHT(BigDecimal tmsOrderTransportTotalServiceHT) {
        this.tmsOrderTransportTotalServiceHT = tmsOrderTransportTotalServiceHT;
    }
    @Column(name="tms_ordertransporttotalservicevat")

    public BigDecimal getTmsOrderTransportTotalServiceVat() {
        return tmsOrderTransportTotalServiceVat;
    }

    public void setTmsOrderTransportTotalServiceVat(BigDecimal tmsOrderTransportTotalServiceVat) {
        this.tmsOrderTransportTotalServiceVat = tmsOrderTransportTotalServiceVat;
    }

    @Column(name="tms_ordertransporttotalservicettc")

    public BigDecimal getTmsOrderTransportTotalServiceTTC() {
        return tmsOrderTransportTotalServiceTTC;
    }

    public void setTmsOrderTransportTotalServiceTTC(BigDecimal tmsOrderTransportTotalServiceTTC) {
        this.tmsOrderTransportTotalServiceTTC = tmsOrderTransportTotalServiceTTC;
    }

    @Column(name="tms_ordertransporttotalpriceht")

    public BigDecimal getTmsOrderTransportTotalPriceHT() {
        return tmsOrderTransportTotalPriceHT;
    }

    public void setTmsOrderTransportTotalPriceHT(BigDecimal tmsOrderTransportTotalPriceHT) {
        this.tmsOrderTransportTotalPriceHT = tmsOrderTransportTotalPriceHT;
    }
    @Column(name="tms_ordertransporttotalpricevat")

    public BigDecimal getTmsOrderTransportTotalPriceVat() {
        return tmsOrderTransportTotalPriceVat;
    }

    public void setTmsOrderTransportTotalPriceVat(BigDecimal tmsOrderTransportTotalPriceVat) {
        this.tmsOrderTransportTotalPriceVat = tmsOrderTransportTotalPriceVat;
    }
    @Column(name="tms_ordertransporttotalpricettc")

    public BigDecimal getTmsOrderTransportTotalPriceTTC() {
        return tmsOrderTransportTotalPriceTTC;
    }

    public void setTmsOrderTransportTotalPriceTTC(BigDecimal tmsOrderTransportTotalPriceTTC) {
        this.tmsOrderTransportTotalPriceTTC = tmsOrderTransportTotalPriceTTC;
    }

    @Column(name="tms_ordertransportpricettc")
    public BigDecimal getTmsOrderTransportPriceTTC() {
        return tmsOrderTransportPriceTTC;
    }

    public void setTmsOrderTransportPriceTTC(BigDecimal tmsOrderTransportPriceTTC) {
        this.tmsOrderTransportPriceTTC = tmsOrderTransportPriceTTC;
    }

    @Column(name="tms_ordertransportmarginrate")
    public BigDecimal getTmsOrderTransportMarginRate() {
        return tmsOrderTransportMarginRate;
    }
    public void setTmsOrderTransportMarginRate(BigDecimal tmsOrderTransportMarginRate) {
        this.tmsOrderTransportMarginRate = tmsOrderTransportMarginRate;
    }
    @Column(name="tms_ordertransportmarginvalue")

    public BigDecimal getTmsOrderTransportMarginValue() {
        return tmsOrderTransportMarginValue;
    }

    public void setTmsOrderTransportMarginValue(BigDecimal tmsOrderTransportMarginValue) {
        this.tmsOrderTransportMarginValue = tmsOrderTransportMarginValue;
    }

    @ManyToOne()
    @JoinColumn(name="tms_ordertransportpackagingtypeid")
    public TmsPackagingType getTmsOrderTransportPackagingType() {
        return tmsOrderTransportPackagingType;
    }

    public void setTmsOrderTransportPackagingType(TmsPackagingType tmsOrderTransportPackagingType) {
        this.tmsOrderTransportPackagingType = tmsOrderTransportPackagingType;
    }

    @Column(name="tms_ordertransportconsignment")
    public Boolean getTmsOrderTransportConsignment() {
        return tmsOrderTransportConsignment;
    }

    public void setTmsOrderTransportConsignment(Boolean tmsOrderTransportConsignment) {
        this.tmsOrderTransportConsignment = tmsOrderTransportConsignment;
    }
    @Column(name="tms_ordertransportport")

    public String getTmsOrderTransportPort() {
        return tmsOrderTransportPort;
    }

    public void setTmsOrderTransportPort(String tmsOrderTransportPort) {
        this.tmsOrderTransportPort = tmsOrderTransportPort;
    }

    @Column(name="tms_ordertransportpalletresponsibility")

    public String getTmsOrderTransportPalletResponsibility() {
        return tmsOrderTransportPalletResponsibility;
    }

    public void setTmsOrderTransportPalletResponsibility(String tmsOrderTransportPalletResponsibility) {
        this.tmsOrderTransportPalletResponsibility = tmsOrderTransportPalletResponsibility;
    }

    @ManyToOne()
    @JoinColumn(name="tms_ordertransportmarchandisetypeid")
    public TmsMarchandiseType getTmsOrderTransportMarchandiseType() {
        return tmsOrderTransportMarchandiseType;
    }

    public void setTmsOrderTransportMarchandiseType(TmsMarchandiseType tmsOrderTransportMarchandiseType) {
        this.tmsOrderTransportMarchandiseType = tmsOrderTransportMarchandiseType;
    }




    @ManyToOne()
 @JoinColumn(name = "tms_ordertransportTypeid")
    public TmsTurnType getTmsOrderTransportType() {
        return tmsOrderTransportType;
    }


    public void setTmsOrderTransportType(TmsTurnType tmsOrderTransportType) {
        this.tmsOrderTransportType = tmsOrderTransportType;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportTrajetid")
    public TmsTrajet getTmsTrajet() {
        return tmsTrajet;
    }

    public void setTmsTrajet(TmsTrajet tmsTrajet) {
        this.tmsTrajet = tmsTrajet;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportcontactid")
    public PrmContact getPrmContact() {
        return prmContact;
    }

    public void setPrmContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportvatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_vehicletrayid")
    public TmsVehicleTray getTmsVehicleTray() {
        return tmsVehicleTray;
    }

    public void setTmsVehicleTray(TmsVehicleTray tmsVehicleTray) {
        this.tmsVehicleTray = tmsVehicleTray;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }
    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tms_ordertransportdeliveryinfoaller")
//    public TmsOrderTransportInfo getTmsOrderTransportInfoAller() {
//        return tmsOrderTransportInfoAller;
//    }
//
//    public void setTmsOrderTransportInfoAller(TmsOrderTransportInfo tmsOrderTransportInfoAller) {
//        this.tmsOrderTransportInfoAller = tmsOrderTransportInfoAller;
//    }




//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tms_ordertransportdeliveryinforetour")
//    public TmsOrderTransportInfo getTmsOrderTransportInfoRetour() {
//        return tmsOrderTransportInfoRetour;
//    }
//
//    public void setTmsOrderTransportInfoRetour(TmsOrderTransportInfo tmsOrderTransportInfoRetour) {
//        this.tmsOrderTransportInfoRetour = tmsOrderTransportInfoRetour;
//    }




    @ManyToOne()
    @JoinColumn(name = "tms_turnstatusid")
    public TmsTurnStatus getTmsTurnStatus() {
        return tmsTurnStatus;
    }

    public void setTmsTurnStatus(TmsTurnStatus tmsTurnStatus) {
        this.tmsTurnStatus = tmsTurnStatus;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_loadingtypeid")
    public TmsLoadingType getTmsOrderTransportLoadingType() {
        return tmsOrderTransportLoadingType;
    }

    public void setTmsOrderTransportLoadingType(TmsLoadingType tmsOrderTransportLoadingType) {
        this.tmsOrderTransportLoadingType = tmsOrderTransportLoadingType;
    }

    @ManyToOne()
    @JoinColumn(name = "cmd_ordertransportaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }
}
