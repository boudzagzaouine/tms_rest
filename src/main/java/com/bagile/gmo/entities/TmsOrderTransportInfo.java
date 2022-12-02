
package com.bagile.gmo.entities;

import com.bagile.gmo.dto.OrderTransportInfoLine;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_ordertransportinfo")
public class TmsOrderTransportInfo extends EmsEntity {

    private Long tmsOrderTransportInfoId;
    private TmsPackagingType tmsOrderTransportInfoPackagingType ;

    private Set<TmsPackageDetail> tmsPackageDetails=new HashSet<>();
    private TmsAddressContactOrderTransportInfo tmsAddressContactOrderTransportInitial;
    private TmsAddressContactOrderTransportInfo tmsAddressContactOrderTransportFinal;

    private Set<TmsOrderTransportInfoLine> tmsOrderTransportInfoLines=new HashSet<>();

    private BigDecimal tmsOrderTransportInfoWeight;
    private BigDecimal tmsOrderTransportInfoCapacity;

    private BigDecimal tmsOrderTransportInfoPriceTTC;

    private TmsTurnStatus tmsTurnStatus;

    private String tmsOrderTransportInfoType ;

    private Boolean tmsOrderTransportInfoTrajetUnique;

    private BigDecimal tmsOrderTransportInfoNumberOfPallet;
    private TmsOrderTransport tmsOrderTransport;
    private PrmVille prmVilleSource;
    private PrmVille prmVilleDistination;
    private Date tmsOrderTransportInfoDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransportinfo_id", allocationSize = 1)
    @Column(name = "tms_ordertransportinfoid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportInfoId() {
        return tmsOrderTransportInfoId;
    }

    public void setTmsOrderTransportInfoId(Long tmsOrderTransportInfoId) {
        this.tmsOrderTransportInfoId = tmsOrderTransportInfoId;
    }

    @OneToOne()
    @JoinColumn(name = "tms_ordertransport")
    public TmsOrderTransport getTmsOrderTransport() {
        return tmsOrderTransport;
    }

    public void setTmsOrderTransport(TmsOrderTransport tmsOrderTransport) {
        this.tmsOrderTransport = tmsOrderTransport;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_packagingtypeid")
    public TmsPackagingType getTmsOrderTransportInfoPackagingType() {
        return tmsOrderTransportInfoPackagingType;
    }

    public void setTmsOrderTransportInfoPackagingType(TmsPackagingType tmsOrderTransportInfoPackagingTypeAller) {
        this.tmsOrderTransportInfoPackagingType = tmsOrderTransportInfoPackagingTypeAller;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_villesourceid")
    public PrmVille getPrmVilleSource() {
        return prmVilleSource;
    }

    public void setPrmVilleSource(PrmVille prmVilleSource) {
        this.prmVilleSource = prmVilleSource;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_villedistinationid")
    public PrmVille getPrmVilleDistination() {
        return prmVilleDistination;
    }
    public void setPrmVilleDistination(PrmVille prmVilleDistination) {
        this.prmVilleDistination = prmVilleDistination;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turnstatusid")
    public TmsTurnStatus getTmsTurnStatus() {
        return tmsTurnStatus;
    }

    public void setTmsTurnStatus(TmsTurnStatus tmsTurnStatus) {
        this.tmsTurnStatus = tmsTurnStatus;
    }

    @OneToMany(mappedBy = "tmsOrderTransportInfo",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsPackageDetail> getTmsPackageDetails() {
        return tmsPackageDetails;
    }

    public void setTmsPackageDetails(Set<TmsPackageDetail> tmsPackageDetails) {
        this.tmsPackageDetails = tmsPackageDetails;
    }



    @OneToMany(mappedBy = "tmsOrderTransportInfo",cascade =CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsOrderTransportInfoLine> getTmsOrderTransportInfoLines() {
        return tmsOrderTransportInfoLines;
    }

    public void setTmsOrderTransportInfoLines(Set<TmsOrderTransportInfoLine> tmsOrderTransportInfoLines) {
        this.tmsOrderTransportInfoLines = tmsOrderTransportInfoLines;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tmsAddressContactOrderTransportName", column = @Column(name = "tms_infoinitialename")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportTel1", column = @Column(name = "tms_infoinitialtel1")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportEmail", column = @Column(name = "tms_infoinitialemail")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCompany", column = @Column(name = "tms_infoinitialcompany")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLine1", column = @Column(name = "tms_infoinitialline")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCity", column = @Column(name = "tms_infoinitialcity")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportZip", column = @Column(name = "tms_infoinitialzip")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCountry", column = @Column(name = "tms_infoinitialcountry")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportDate", column = @Column(name = "tms_infoinitialdate")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLatitude", column = @Column(name = "tms_infoinitiallatitude")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLongitude", column = @Column(name = "tms_infoinitiallongitude")),
    })
    public TmsAddressContactOrderTransportInfo getTmsAddressContactOrderTransportInitial() {
        return tmsAddressContactOrderTransportInitial;
    }

    public void setTmsAddressContactOrderTransportInitial(TmsAddressContactOrderTransportInfo tmsAddressContactOrderTransportInitial) {
        this.tmsAddressContactOrderTransportInitial = tmsAddressContactOrderTransportInitial;
    }




    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "tmsAddressContactOrderTransportName", column = @Column(name = "tms_infofinalname")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportTel1", column = @Column(name = "tms_infofinaltel1")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportEmail", column = @Column(name = "tms_infofinalemail")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCompany", column = @Column(name = "tms_infofinalcompany")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLine1", column = @Column(name = "tms_infofinalline")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCity", column = @Column(name = "tms_infofinalcity")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportZip", column = @Column(name = "tms_infofinalzip")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportCountry", column = @Column(name = "tms_infofinalcountry")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportDate", column = @Column(name = "tms_infofinaldate")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLatitude", column = @Column(name = "tms_infofinallatitude")),
            @AttributeOverride(name = "tmsAddressContactOrderTransportLongitude", column = @Column(name = "tms_infofinallongitude")),
    })
    public TmsAddressContactOrderTransportInfo getTmsAddressContactOrderTransportFinal() {
        return tmsAddressContactOrderTransportFinal;
    }

    public void setTmsAddressContactOrderTransportFinal(TmsAddressContactOrderTransportInfo tmsAddressContactOrderTransportFinal) {
        this.tmsAddressContactOrderTransportFinal = tmsAddressContactOrderTransportFinal;
    }

    @Column(name="tms_ordertransportinfotype")
    public String getTmsOrderTransportInfoType() {
        return tmsOrderTransportInfoType;
    }

    public void setTmsOrderTransportInfoType(String tmsOrderTransportInfoType) {
        this.tmsOrderTransportInfoType = tmsOrderTransportInfoType;
    }

    @Column(name="tms_ordertransportinfodate")

    public Date getTmsOrderTransportInfoDate() {
        return tmsOrderTransportInfoDate;
    }

    public void setTmsOrderTransportInfoDate(Date tmsOrderTransportInfoDate) {
        this.tmsOrderTransportInfoDate = tmsOrderTransportInfoDate;
    }

    @Column(name="tms_ordertransportinfonumberofpallet")

    public BigDecimal getTmsOrderTransportInfoNumberOfPallet() {
        return tmsOrderTransportInfoNumberOfPallet;
    }

    public void setTmsOrderTransportInfoNumberOfPallet(BigDecimal tmsOrderTransportInfoNumberOfPallet) {
        this.tmsOrderTransportInfoNumberOfPallet = tmsOrderTransportInfoNumberOfPallet;
    }

    @Column(name="tms_ordertransportinfotrajetunique")
    public Boolean getTmsOrderTransportInfoTrajetUnique() {
        return tmsOrderTransportInfoTrajetUnique;
    }

    public void setTmsOrderTransportInfoTrajetUnique(Boolean tmsOrderTransportInfoTrajetUnique) {
        this.tmsOrderTransportInfoTrajetUnique = tmsOrderTransportInfoTrajetUnique;
    }

    @Column(name="tms_ordertransportinfoweight")
    public BigDecimal getTmsOrderTransportInfoWeight() {
        return tmsOrderTransportInfoWeight;
    }

    public void setTmsOrderTransportInfoWeight(BigDecimal tmsOrderTransportInfoWeightTotal) {
        this.tmsOrderTransportInfoWeight = tmsOrderTransportInfoWeightTotal;
    }
    @Column(name="tms_ordertransportinfocapacity")

    public BigDecimal getTmsOrderTransportInfoCapacity() {
        return tmsOrderTransportInfoCapacity;
    }

    public void setTmsOrderTransportInfoCapacity(BigDecimal tmsOrderTransportInfoCapacityToal) {
        this.tmsOrderTransportInfoCapacity = tmsOrderTransportInfoCapacityToal;
    }

    @Column(name="tms_ordertransportinfopricettc")

    public BigDecimal getTmsOrderTransportInfoPriceTTC() {
        return tmsOrderTransportInfoPriceTTC;
    }

    public void setTmsOrderTransportInfoPriceTTC(BigDecimal tmsOrderTransportInfoPriceTTC) {
        this.tmsOrderTransportInfoPriceTTC = tmsOrderTransportInfoPriceTTC;
    }

}
