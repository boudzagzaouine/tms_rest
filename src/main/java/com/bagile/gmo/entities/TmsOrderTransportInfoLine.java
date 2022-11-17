
package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_ordertransportinfolineinfoline")
public class TmsOrderTransportInfoLine extends EmsEntity {

    private Long tmsOrderTransportInfoLineId;
    private TmsOrderTransportType tmsOrderTransportType;

    private TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfo;

    private BigDecimal tmsAddressContactDeliveryInfoNumberOfPalletEnlevement;
    private BigDecimal tmsOrderTransportWeightEnlevement ;
    private BigDecimal tmsOrderTransportCapacityEnlevement;
    private String  tmsOrderTransportCommentEnlevement;

    private TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfoLivraison;
    private BigDecimal tmsAddressContactDeliveryInfoNumberOfPalletLivraison;

    private BigDecimal tmsOrderTransportWeightLivraison ;
    private BigDecimal tmsOrderTransportCapacityLivraison;
    private String  tmsOrderTransportCommentLivraison;

    private TmsTurnStatus tmsTurnStatus;

    private Long  tmsOrderTransportLineNumber ;
    private TmsOrderTransportInfo tmsOrderTransportInfo;



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

    @ManyToOne()
    @JoinColumn(name = "tms_ordertrasnportserviceid")
    public TmsOrderTransportType getTmsOrderTransportType() {
        return tmsOrderTransportType;
    }


    public void setTmsOrderTransportType(TmsOrderTransportType tmsOrderTransportService) {
        this.tmsOrderTransportType = tmsOrderTransportService;
    }

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tmsAddressContactOrderTransportName", column = @Column(name = "tms_infoenlevementname")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportTel1", column = @Column(name = "tms_infoenlevementtel1")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportEmail", column = @Column(name = "tms_infoenlevementemail")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCompany", column = @Column(name = "tms_infoenlevementcompany")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLine1", column = @Column(name = "tms_infoenlevementline")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCity", column = @Column(name = "tms_infoenlevementcity")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportZip", column = @Column(name = "tms_infoenlevementzip")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCountry", column = @Column(name = "tms_infoenlevementcountry")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportDate", column = @Column(name = "tms_infoenlevementdate")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLatitude", column = @Column(name = "tms_infoenlevementlatitude")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLongitude", column = @Column(name = "tms_infoenlevementlongitude")),
    })
    public TmsAddressContactOrderTransportInfo getTmsAddressContactDeliveryInfo() {
        return tmsAddressContactDeliveryInfo;
    }

    public void setTmsAddressContactDeliveryInfo(TmsAddressContactOrderTransportInfo tmsAddressContactDeliveryInfoEnlevement) {
        this.tmsAddressContactDeliveryInfo = tmsAddressContactDeliveryInfoEnlevement;
    }

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
