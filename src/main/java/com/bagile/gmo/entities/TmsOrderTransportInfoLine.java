
package com.bagile.gmo.entities;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.dto.PaymentType;
import com.bagile.gmo.mapper.PaymentRuleMapper;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_ordertransportinfolineinfoline")
public class TmsOrderTransportInfoLine extends EmsEntity {

    private Long tmsOrderTransportInfoLineId;
    private TmsOrderTransportType tmsOrderTransportType;

    private CmdAccount cmdAccount;

    private AdrAddress adrAddress;
    private PrmContact prmContact;
    //private TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfo;
    private Date tmsOrderTranspotInfoLineDateArriver;
    private Date tmsOrderTranspotInfoLineDateCommancerChargement;
    private Date tmsOrderTranspotInfoLineDateCommancerDechargement;
    private Date tmsOrderTranspotInfoLineDateFinDechargement;
    private Date tmsOrderTranspotInfoLineDateFinChargement;
    private BigDecimal tmsAddressContactDeliveryInfoNumberOfPalletEnlevement;
    private BigDecimal tmsOrderTransportWeightEnlevement ;
    private BigDecimal tmsOrderTransportCapacityEnlevement;
    private String  tmsOrderTransportCommentEnlevement;
    private Boolean  tmsOrderTransportContreBlEnlevement;
    private Boolean  tmsOrderTransportContreFactureEnlevement;
    private PrmPaymentType prmPaymentTypeEnlevement;
    private BigDecimal tmsPaymentAmountEnlevement;
    private Date tmsOrderTransportDateEnlevement;


    private TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfoLivraison;
    private BigDecimal tmsAddressContactDeliveryInfoNumberOfPalletLivraison;

    private BigDecimal tmsOrderTransportWeightLivraison ;
    private BigDecimal tmsOrderTransportCapacityLivraison;
    private String  tmsOrderTransportCommentLivraison;
    private Boolean  tmsOrderTransportContreBlLivraison;
    private Boolean  tmsOrderTransportContreFactureLivraison;
    private PrmPaymentType prmPaymentTypeLivraison;
    private BigDecimal tmsPaymentAmountLivraison;
    private Date  tmsOrderTransportDateLivraison;

    private TmsTurnStatus tmsTurnStatus;

    private Long  tmsOrderTransportLineNumber ;
    private TmsOrderTransportInfo tmsOrderTransportInfo;

    private  BigDecimal tmsOrderTransportLinePriceHT;
    private PrmVat tmsOrderTransportLineVat;
    private  BigDecimal tmsOrderTransportLinePriceTTC;

    //private Set<TmsOrderTransportInfoLineDocument> tmsOrderTransportInfoLineDocumentSet = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransportinfolineinfo_id", allocationSize = 1)
    @Column(name = "tms_ordertransportinfolineinfoid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportInfoLineId() {
        return tmsOrderTransportInfoLineId;
    }

    public void setTmsOrderTransportInfoLineId(Long tmsOrderTransportInfoLineId) {
        this.tmsOrderTransportInfoLineId = tmsOrderTransportInfoLineId;
    }
    @Column(name = "tms_ordertransportinfolinedatearriver")
    public Date getTmsOrderTranspotInfoLineDateArriver() {
        return tmsOrderTranspotInfoLineDateArriver;
    }

    public void setTmsOrderTranspotInfoLineDateArriver(Date tmsOrderTranspotInfoLineDateArriver) {
        this.tmsOrderTranspotInfoLineDateArriver = tmsOrderTranspotInfoLineDateArriver;
    }
    @Column(name = "tms_ordertransportinfolinedatecommancerchargement")

    public Date getTmsOrderTranspotInfoLineDateCommancerChargement() {
        return tmsOrderTranspotInfoLineDateCommancerChargement;
    }

    public void setTmsOrderTranspotInfoLineDateCommancerChargement(Date tmsOrderTranspotInfoLineDateCommancerChargement) {
        this.tmsOrderTranspotInfoLineDateCommancerChargement = tmsOrderTranspotInfoLineDateCommancerChargement;
    }
    @Column(name = "tms_ordertransportinfolinedatecommancerdechargement")
    public Date getTmsOrderTranspotInfoLineDateCommancerDechargement() {
        return tmsOrderTranspotInfoLineDateCommancerDechargement;
    }

    public void setTmsOrderTranspotInfoLineDateCommancerDechargement(Date tmsOrderTranspotInfoLineDateCommancerDechargement) {
        this.tmsOrderTranspotInfoLineDateCommancerDechargement = tmsOrderTranspotInfoLineDateCommancerDechargement;
    }
    @Column(name = "tms_ordertransportinfolinedatefindechargement")
    public Date getTmsOrderTranspotInfoLineDateFinDechargement() {
        return tmsOrderTranspotInfoLineDateFinDechargement;
    }

    public void setTmsOrderTranspotInfoLineDateFinDechargement(Date tmsOrderTranspotInfoLineDateFinDechargement) {
        this.tmsOrderTranspotInfoLineDateFinDechargement = tmsOrderTranspotInfoLineDateFinDechargement;
    }
    @Column(name = "tms_ordertransportinfolinedatefinchargement")
    public Date getTmsOrderTranspotInfoLineDateFinChargement() {
        return tmsOrderTranspotInfoLineDateFinChargement;
    }

    public void setTmsOrderTranspotInfoLineDateFinChargement(Date tmsOrderTranspotInfoLineDateFinChargement) {
        this.tmsOrderTranspotInfoLineDateFinChargement = tmsOrderTranspotInfoLineDateFinChargement;
    }

    @Column(name = "tms_ordertransportinfolinedpriceht")

    public BigDecimal getTmsOrderTransportLinePriceHT() {
        return tmsOrderTransportLinePriceHT;
    }

    public void setTmsOrderTransportLinePriceHT(BigDecimal tmsOrderTransportLinePriceHT) {
        this.tmsOrderTransportLinePriceHT = tmsOrderTransportLinePriceHT;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertrasnportinfolinevatid")
    public PrmVat getTmsOrderTransportLineVat() {
        return tmsOrderTransportLineVat;
    }


    public void setTmsOrderTransportLineVat(PrmVat tmsOrderTransportLineVat) {
        this.tmsOrderTransportLineVat = tmsOrderTransportLineVat;
    }

    @Column(name = "tms_ordertransportinfolinedpricettc")

    public BigDecimal getTmsOrderTransportLinePriceTTC() {
        return tmsOrderTransportLinePriceTTC;
    }

    public void setTmsOrderTransportLinePriceTTC(BigDecimal tmsOrderTransportLinePriceTTC) {
        this.tmsOrderTransportLinePriceTTC = tmsOrderTransportLinePriceTTC;
    }

    @Column(name = "tms_ordertransportinfolinenimberofpalletenlevement")
    public BigDecimal getTmsAddressContactDeliveryInfoNumberOfPalletEnlevement() {
        return tmsAddressContactDeliveryInfoNumberOfPalletEnlevement;
    }

    public void setTmsAddressContactDeliveryInfoNumberOfPalletEnlevement(BigDecimal tmsAddressContactDeliveryInfoNumberOfPalletEnlevement) {
        this.tmsAddressContactDeliveryInfoNumberOfPalletEnlevement = tmsAddressContactDeliveryInfoNumberOfPalletEnlevement;
    }
    @Column(name = "tms_ordertransportinfolinenimberofpalletlivraison")
    public BigDecimal getTmsAddressContactDeliveryInfoNumberOfPalletLivraison() {
        return tmsAddressContactDeliveryInfoNumberOfPalletLivraison;
    }

    public void setTmsAddressContactDeliveryInfoNumberOfPalletLivraison(BigDecimal tmsAddressContactDeliveryInfoNumberOfPalletLivraison) {
        this.tmsAddressContactDeliveryInfoNumberOfPalletLivraison = tmsAddressContactDeliveryInfoNumberOfPalletLivraison;
    }

    @Column(name = "tms_ordertransportinfolinepaymentamountenlevement")
    public BigDecimal getTmsPaymentAmountEnlevement() {
        return tmsPaymentAmountEnlevement;
    }

    public void setTmsPaymentAmountEnlevement(BigDecimal tmsPaymentAmountEnlevement) {
        this.tmsPaymentAmountEnlevement = tmsPaymentAmountEnlevement;
    }

    @Column(name = "tms_ordertransportinfolinedateenlevement")

    public Date getTmsOrderTransportDateEnlevement() {
        return tmsOrderTransportDateEnlevement;
    }

    public void setTmsOrderTransportDateEnlevement(Date tmsOrderTransportDateEnlevement) {
        this.tmsOrderTransportDateEnlevement = tmsOrderTransportDateEnlevement;
    }

    @Column(name = "tms_ordertransportinfolinedatelivraison")

    public Date getTmsOrderTransportDateLivraison() {
        return tmsOrderTransportDateLivraison;
    }

    public void setTmsOrderTransportDateLivraison(Date tmsOrderTransportDateLivraison) {
        this.tmsOrderTransportDateLivraison = tmsOrderTransportDateLivraison;
    }

    @Column(name = "tms_ordertransportinfolinepaymentamountlivraison")

    public BigDecimal getTmsPaymentAmountLivraison() {
        return tmsPaymentAmountLivraison;
    }

    public void setTmsPaymentAmountLivraison(BigDecimal tmsPaymentAmountLivraison) {
        this.tmsPaymentAmountLivraison = tmsPaymentAmountLivraison;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertrasnportserviceid")
    public TmsOrderTransportType getTmsOrderTransportType() {
        return tmsOrderTransportType;
    }


    public void setTmsOrderTransportType(TmsOrderTransportType tmsOrderTransportService) {
        this.tmsOrderTransportType = tmsOrderTransportService;
    }

    @ManyToOne()
    @JoinColumn(name = "cmd_accountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @Column(name = "tms_ordertransportinfolinecontreblenlevement")
    public Boolean getTmsOrderTransportContreBlEnlevement() {
        return tmsOrderTransportContreBlEnlevement;
    }

    public void setTmsOrderTransportContreBlEnlevement(Boolean tmsOrderTransportContreBlEnlevement) {
        this.tmsOrderTransportContreBlEnlevement = tmsOrderTransportContreBlEnlevement;
    }
    @Column(name = "tms_ordertransportinfolinecontrefactureenlevement")
    public Boolean getTmsOrderTransportContreFactureEnlevement() {
        return tmsOrderTransportContreFactureEnlevement;
    }

    public void setTmsOrderTransportContreFactureEnlevement(Boolean tmsOrderTransportContreFactureEnlevement) {
        this.tmsOrderTransportContreFactureEnlevement = tmsOrderTransportContreFactureEnlevement;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_paymenttypeenlevementid")
    public PrmPaymentType getPrmPaymentTypeEnlevement() {
        return prmPaymentTypeEnlevement;
    }

    public void setPrmPaymentTypeEnlevement(PrmPaymentType prmPaymentTypeEnlevement) {
        this.prmPaymentTypeEnlevement = prmPaymentTypeEnlevement;
    }

    @Column(name = "tms_ordertransportinfolinecontrebllivraison")
    public Boolean getTmsOrderTransportContreBlLivraison() {
        return tmsOrderTransportContreBlLivraison;
    }

    public void setTmsOrderTransportContreBlLivraison(Boolean tmsOrderTransportContreBlLivraison) {
        this.tmsOrderTransportContreBlLivraison = tmsOrderTransportContreBlLivraison;
    }
    @Column(name = "tms_ordertransportinfolinecontrefacturelivraison")

    public Boolean getTmsOrderTransportContreFactureLivraison() {
        return tmsOrderTransportContreFactureLivraison;
    }

    public void setTmsOrderTransportContreFactureLivraison(Boolean tmsOrderTransportContreFactureLivraison) {
        this.tmsOrderTransportContreFactureLivraison = tmsOrderTransportContreFactureLivraison;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_paymenttypelivraisonid")
    public PrmPaymentType getPrmPaymentTypeLivraison() {
        return prmPaymentTypeLivraison;
    }

    public void setPrmPaymentTypeLivraison(PrmPaymentType prmPaymentTypeLivraison) {
        this.prmPaymentTypeLivraison = prmPaymentTypeLivraison;
    }

   // @OneToMany(mappedBy = "tmsOrderTransportInfoLine", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)

    //public Set<TmsOrderTransportInfoLineDocument> getTmsOrderTransportInfoLineDocumentSet() {
      //  return tmsOrderTransportInfoLineDocumentSet;
    //}

    //public void setTmsOrderTransportInfoLineDocumentSet(Set<TmsOrderTransportInfoLineDocument> tmsOrderTransportInfoLineDocumentSet) {
      //  this.tmsOrderTransportInfoLineDocumentSet = tmsOrderTransportInfoLineDocumentSet;
    //}

    @ManyToOne()
    @JoinColumn(name = "tms_turnstatusid")
    public TmsTurnStatus getTmsTurnStatus() {
        return tmsTurnStatus;
    }

    public void setTmsTurnStatus(TmsTurnStatus tmsTurnStatus) {
        this.tmsTurnStatus = tmsTurnStatus;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportinfoid")
    public TmsOrderTransportInfo getTmsOrderTransportInfo() {
        return tmsOrderTransportInfo;
    }

    public void setTmsOrderTransportInfo(TmsOrderTransportInfo tmsOrderTransportInfo) {
        this.tmsOrderTransportInfo = tmsOrderTransportInfo;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportinfolineid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }
    @ManyToOne
    @JoinColumn(name = "tms_contactid")
    public PrmContact getPrmContact() {
        return prmContact;
    }

    public void setPrmContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }

    //    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "tmsAddressContactOrderTransportName", column = @Column(name = "tms_infoenlevementname")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportTel1", column = @Column(name = "tms_infoenlevementtel1")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportEmail", column = @Column(name = "tms_infoenlevementemail")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportCompany", column = @Column(name = "tms_infoenlevementcompany")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportLine1", column = @Column(name = "tms_infoenlevementline")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportCity", column = @Column(name = "tms_infoenlevementcity")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportZip", column = @Column(name = "tms_infoenlevementzip")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportCountry", column = @Column(name = "tms_infoenlevementcountry")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportDate", column = @Column(name = "tms_infoenlevementdate")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportLatitude", column = @Column(name = "tms_infoenlevementlatitude")),
//            @AttributeOverride(name = "tmsAddressContactOrderTransportLongitude", column = @Column(name = "tms_infoenlevementlongitude")),
//    })
//    public TmsAddressContactOrderTransportInfo getTmsAddressContactDeliveryInfo() {
//        return tmsAddressContactDeliveryInfo;
//    }
//
//    public void setTmsAddressContactDeliveryInfo(TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfoEnlevement) {
//        this.tmsAddressContactDeliveryInfo = tmsAddressContactDeliveryInfoEnlevement;
//    }

    @Column(name = "tms_ordertransportinfolineweightenlevement")
    public BigDecimal getTmsOrderTransportWeightEnlevement() {
        return tmsOrderTransportWeightEnlevement;
    }

    public void setTmsOrderTransportWeightEnlevement(BigDecimal tmsOrderTransportWeightEnlevement) {
        this.tmsOrderTransportWeightEnlevement = tmsOrderTransportWeightEnlevement;
    }
    @Column(name = "tms_ordertransportinfolinecapacityenlevement")
    public BigDecimal getTmsOrderTransportCapacityEnlevement() {
        return tmsOrderTransportCapacityEnlevement;
    }

    public void setTmsOrderTransportCapacityEnlevement(BigDecimal tmsOrderTransportCapacityEnlevement) {
        this.tmsOrderTransportCapacityEnlevement = tmsOrderTransportCapacityEnlevement;
    }

    @Column(name = "tms_ordertransportinfolinelinenumber")
    public Long getTmsOrderTransportLineNumber() {
        return tmsOrderTransportLineNumber;
    }

    public void setTmsOrderTransportLineNumber(Long tmsOrderTransportLineNumber) {
        this.tmsOrderTransportLineNumber = tmsOrderTransportLineNumber;
    }

    @Column(name = "tms_ordertransportinfolinecommentenlevement")
    public String getTmsOrderTransportCommentEnlevement() {
        return tmsOrderTransportCommentEnlevement;
    }

    public void setTmsOrderTransportCommentEnlevement(String tmsOrderTransportCommentEnlevement) {
        this.tmsOrderTransportCommentEnlevement = tmsOrderTransportCommentEnlevement;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tmsAddressContactOrderTransportName", column = @Column(name = "tms_infolivraisonname")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportTel1", column = @Column(name = "tms_infolivraisontel1")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportEmail", column = @Column(name = "tms_infolivraisonemail")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCompany", column = @Column(name = "tms_infolivraisoncompany")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLine1", column = @Column(name = "tms_infolivraisonline")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCity", column = @Column(name = "tms_infolivraisoncity")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportZip", column = @Column(name = "tms_infolivraisonzip")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCountry", column = @Column(name = "tms_infolivraisoncountry")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportDate", column = @Column(name = "tms_infolivraisondate")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLatitude", column = @Column(name = "tms_infolivraisonlatitude")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLongitude", column = @Column(name = "tms_infolivraisonlongitude")),
    })
    public TmsAddressContactOrderTransportInfo getTmsAddressContactDeliveryInfoLivraison() {
        return tmsAddressContactDeliveryInfoLivraison;
    }

    public void setTmsAddressContactDeliveryInfoLivraison(TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfoLivraison) {
        this.tmsAddressContactDeliveryInfoLivraison = tmsAddressContactDeliveryInfoLivraison;
    }

    @Column(name = "tms_ordertransportinfolineweightlivraison")
    public BigDecimal getTmsOrderTransportWeightLivraison() {
        return tmsOrderTransportWeightLivraison;
    }

    public void setTmsOrderTransportWeightLivraison(BigDecimal tmsOrderTransportWeightLivraison) {
        this.tmsOrderTransportWeightLivraison = tmsOrderTransportWeightLivraison;
    }

    @Column(name = "tms_ordertransportinfolinecapacitylivraison")
    public BigDecimal getTmsOrderTransportCapacityLivraison() {
        return tmsOrderTransportCapacityLivraison;
    }

    public void setTmsOrderTransportCapacityLivraison(BigDecimal tmsOrderTransportCapacityLivraison) {
        this.tmsOrderTransportCapacityLivraison = tmsOrderTransportCapacityLivraison;
    }

    @Column(name = "tms_ordertransportinfolinecommentlivraison")
    public String getTmsOrderTransportCommentLivraison() {
        return tmsOrderTransportCommentLivraison;
    }

    public void setTmsOrderTransportCommentLivraison(String tmsOrderTransportCommentLivraison) {
        this.tmsOrderTransportCommentLivraison = tmsOrderTransportCommentLivraison;
    }
}
