package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RcpReception generated by hbm2java
 */
@Entity
@Table(name = "rcp_reception", uniqueConstraints = {
        @UniqueConstraint(columnNames = "rcp_receptioncode")})
public class RcpReception extends EmsEntity implements java.io.Serializable {

    private long rcpReceptionId;
   // @NotNull
    private OwnOwner ownOwner;
    private AdrAddressInfo adrAddress;
    private CmdDelivery cmdDelivery;
    @NotNull
    private PrmOrderType prmOrderType;
    private RcpPurshaseOrder rcpPurshaseOrder;
    private RcpSupplier rcpSupplier;
    private TrpTransport trpTransport;
   // @NotNull
    private WrhWarehouse wrhWarehouse;
    @Max(999999999)
    private Long rcpReceptionNumberOfContainers;

    @NotNull
    @Size(max = 30)
    private String rcpReceptionCode;
    @Size(max = 255)
    private String rcpReceptionRemarks;
    @Size(max = 30)
    private String rcpReceptionOrderCode;
    @Size(max = 255)
    private String rcpReceptionDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionExpectedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionReceptionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionUpdateDate;
    @Size(max = 255)
    private String rcpReceptionVariable1;
    @Size(max = 255)
    private String rcpReceptionVariable2;
    @Size(max = 255)
    private String rcpReceptionVariable3;
    @Size(max = 255)
    private String rcpReceptionVariable4;
    @Size(max = 255)
    private String rcpReceptionVariable5;
    @Size(max = 255)
    private String rcpReceptionVariable6;
    @Size(max = 255)
    private String rcpReceptionVariable7;
    @Size(max = 255)
    private String rcpReceptionVariable8;
    @Size(max = 255)
    private String rcpReceptionVariable9;
    @Size(max = 255)
    private String rcpReceptionVariable10;
    @Size(max = 50)
    private String rcpReceptionImmatriculation;
    @Size(max = 50)
    private String rcpReceptionTransportContact;
    private CmdAccount cmdAccount;
    private PrmOrderStatus prmOrderStatus;
    private LocLocation locLocation;
    private String rcpReceptionTransportTel;
    @Size(max = 50)
    private String rcpReceptionTransfertCode;
    private Set<RcpReceptionLine> rcpReceptionLines = new HashSet<RcpReceptionLine>(
            0);
    private Set<RcpReceptionStock> rcpReceptionStocks = new HashSet<RcpReceptionStock>(
            0);
    private Boolean rcpReceptionSendedToWms;
    private BigDecimal rcpReceptionDiscount;
    private BigDecimal rcpReceptionTotalPriceHT;
    private BigDecimal rcpReceptionTotalPriceTTC;
  //  private PrmCurrency prmCurrency;
    private BigDecimal rcpReceptionVat;
    private Boolean rcpReceptionActive;
    private Boolean rcpReceptionAccounted;
    private BigDecimal rcpReceptionTotalPriceHTDefaultCurrency;
    private BigDecimal rcpReceptionTotalPriceTTCDefaultCurrency;
    private BigDecimal rcpReceptionVatDefaultCurrency;
    private BigDecimal rcpReceptionExchangeRate;
   // private UsrBox usrBox;
    private BigDecimal rcpReceptionProvisionalCost;
    private Date rcpReceptionSupplierDeliveryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_rcp_reception", allocationSize = 1)
    @Column(name = "rcp_receptionid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getRcpReceptionId() {
        return this.rcpReceptionId;
    }

    public void setRcpReceptionId(long rcpReceptionId) {
        this.rcpReceptionId = rcpReceptionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "adrAddressLine1", column = @Column(name = "rcp_receptionaddressline1")),
            @AttributeOverride(name = "adrAddressLine2", column = @Column(name = "rcp_receptionaddressline2")),
            @AttributeOverride(name = "adrAddressZip", column = @Column(name = "rcp_receptionaddresszip")),
            @AttributeOverride(name = "adrAddressCity", column = @Column(name = "rcp_receptionaddresscity")),
            @AttributeOverride(name = "adrAddressState", column = @Column(name = "rcp_receptionaddressstate")),
            @AttributeOverride(name = "adrAddressCountry", column = @Column(name = "rcp_receptionaddresscountry")),
            @AttributeOverride(name = "adrAddressDigiCode", column = @Column(name = "rcp_receptionaddressdigicode")),
    })
    public AdrAddressInfo getAdrAddress() {
        return this.adrAddress;
    }

    public void setAdrAddress(AdrAddressInfo adrAddress) {
        this.adrAddress = adrAddress;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionordertypeid", nullable = false)
    public PrmOrderType getPrmOrderType() {
        return this.prmOrderType;
    }

    public void setPrmOrderType(PrmOrderType prmOrderType) {
        this.prmOrderType = prmOrderType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionpurshaseorderid", nullable = false)
    public RcpPurshaseOrder getRcpPurshaseOrder() {
        return this.rcpPurshaseOrder;
    }

    public void setRcpPurshaseOrder(RcpPurshaseOrder rcpPurshaseOrder) {
        this.rcpPurshaseOrder = rcpPurshaseOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionsupplierid")
    public RcpSupplier getRcpSupplier() {
        return this.rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptiontransportid")
    public TrpTransport getTrpTransport() {
        return this.trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptiondeliveryid")
    public CmdDelivery getCmdDelivery() {
        return cmdDelivery;
    }

    public void setCmdDelivery(CmdDelivery cmdDelivery) {
        this.cmdDelivery = cmdDelivery;
    }

    @Column(name = "rcp_receptioncode", unique = true, nullable = false, length = 30)
    public String getRcpReceptionCode() {
        return this.rcpReceptionCode;
    }

    public void setRcpReceptionCode(String rcpReceptionCode) {
        this.rcpReceptionCode = rcpReceptionCode;
    }

    @Column(name = "rcp_receptionnumberofcontainers", precision = 12, scale = 0)
    public Long getRcpReceptionNumberOfContainers() {
        return rcpReceptionNumberOfContainers;
    }

    public void setRcpReceptionNumberOfContainers(Long rcpReceptionNumberOfContainers) {
        this.rcpReceptionNumberOfContainers = rcpReceptionNumberOfContainers;
    }

    @Column(name = "rcp_receptionremarks")
    public String getRcpReceptionRemarks() {
        return this.rcpReceptionRemarks;
    }

    public void setRcpReceptionRemarks(String rcpReceptionRemarks) {
        this.rcpReceptionRemarks = rcpReceptionRemarks;
    }

    @Column(name = "rcp_receptionordercode", length = 30)
    public String getRcpReceptionOrderCode() {
        return this.rcpReceptionOrderCode;
    }

    public void setRcpReceptionOrderCode(String rcpReceptionOrderCode) {
        this.rcpReceptionOrderCode = rcpReceptionOrderCode;
    }

    @Column(name = "rcp_receptiondescription")
    public String getRcpReceptionDescription() {
        return this.rcpReceptionDescription;
    }

    public void setRcpReceptionDescription(String rcpReceptionDescription) {
        this.rcpReceptionDescription = rcpReceptionDescription;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rcp_receptionexpecteddate", length = 13)
    public Date getRcpReceptionExpectedDate() {
        return this.rcpReceptionExpectedDate;
    }

    public void setRcpReceptionExpectedDate(Date rcpReceptionExpectedDate) {
        this.rcpReceptionExpectedDate = rcpReceptionExpectedDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionreceptiondate")
    public Date getRcpReceptionReceptionDate() {
        return this.rcpReceptionReceptionDate;
    }

    public void setRcpReceptionReceptionDate(Date rcpReceptionReceptionDate) {
        this.rcpReceptionReceptionDate = rcpReceptionReceptionDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptioncreationdate")
    public Date getRcpReceptionCreationDate() {
        return this.rcpReceptionCreationDate;
    }

    public void setRcpReceptionCreationDate(Date rcpReceptionCreationDate) {
        this.rcpReceptionCreationDate = rcpReceptionCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionupdatedate")
    public Date getRcpReceptionUpdateDate() {
        return this.rcpReceptionUpdateDate;
    }

    public void setRcpReceptionUpdateDate(Date rcpReceptionUpdateDate) {
        this.rcpReceptionUpdateDate = rcpReceptionUpdateDate;
    }

    @Column(name = "rcp_receptionvariable1")
    public String getRcpReceptionVariable1() {
        return this.rcpReceptionVariable1;
    }

    public void setRcpReceptionVariable1(String rcpReceptionVariable1) {
        this.rcpReceptionVariable1 = rcpReceptionVariable1;
    }

    @Column(name = "rcp_receptionvariable2")
    public String getRcpReceptionVariable2() {
        return this.rcpReceptionVariable2;
    }

    public void setRcpReceptionVariable2(String rcpReceptionVariable2) {
        this.rcpReceptionVariable2 = rcpReceptionVariable2;
    }

    @Column(name = "rcp_receptionvariable3")
    public String getRcpReceptionVariable3() {
        return this.rcpReceptionVariable3;
    }

    public void setRcpReceptionVariable3(String rcpReceptionVariable3) {
        this.rcpReceptionVariable3 = rcpReceptionVariable3;
    }

    @Column(name = "rcp_receptionvariable4")
    public String getRcpReceptionVariable4() {
        return this.rcpReceptionVariable4;
    }

    public void setRcpReceptionVariable4(String rcpReceptionVariable4) {
        this.rcpReceptionVariable4 = rcpReceptionVariable4;
    }

    @Column(name = "rcp_receptionvariable5")
    public String getRcpReceptionVariable5() {
        return this.rcpReceptionVariable5;
    }

    public void setRcpReceptionVariable5(String rcpReceptionVariable5) {
        this.rcpReceptionVariable5 = rcpReceptionVariable5;
    }

    @Column(name = "rcp_receptionvariable6")
    public String getRcpReceptionVariable6() {
        return this.rcpReceptionVariable6;
    }

    public void setRcpReceptionVariable6(String rcpReceptionVariable6) {
        this.rcpReceptionVariable6 = rcpReceptionVariable6;
    }

    @Column(name = "rcp_receptionvariable7")
    public String getRcpReceptionVariable7() {
        return this.rcpReceptionVariable7;
    }

    public void setRcpReceptionVariable7(String rcpReceptionVariable7) {
        this.rcpReceptionVariable7 = rcpReceptionVariable7;
    }

    @Column(name = "rcp_receptionvariable8")
    public String getRcpReceptionVariable8() {
        return this.rcpReceptionVariable8;
    }

    public void setRcpReceptionVariable8(String rcpReceptionVariable8) {
        this.rcpReceptionVariable8 = rcpReceptionVariable8;
    }

    @Column(name = "rcp_receptionvariable9")
    public String getRcpReceptionVariable9() {
        return this.rcpReceptionVariable9;
    }

    public void setRcpReceptionVariable9(String rcpReceptionVariable9) {
        this.rcpReceptionVariable9 = rcpReceptionVariable9;
    }

    @Column(name = "rcp_receptionvariable10")
    public String getRcpReceptionVariable10() {
        return this.rcpReceptionVariable10;
    }

    public void setRcpReceptionVariable10(String rcpReceptionVariable10) {
        this.rcpReceptionVariable10 = rcpReceptionVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rcpReception", orphanRemoval = true)
    public Set<RcpReceptionLine> getRcpReceptionLines() {
        return this.rcpReceptionLines;
    }

    public void setRcpReceptionLines(Set<RcpReceptionLine> rcpReceptionLines) {
        this.rcpReceptionLines = rcpReceptionLines;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rcpReception")
    public Set<RcpReceptionStock> getRcpReceptionStocks() {
        return this.rcpReceptionStocks;
    }

    public void setRcpReceptionStocks(Set<RcpReceptionStock> rcpReceptionStocks) {
        this.rcpReceptionStocks = rcpReceptionStocks;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlocationid")
    public LocLocation getLocLocation() {
        return locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @Column(name = "rcp_receptiontransporttel")
    public String getRcpReceptionTransportTel() {
        return rcpReceptionTransportTel;
    }

    public void setRcpReceptionTransportTel(String rcpReceptionTransportTel) {
        this.rcpReceptionTransportTel = rcpReceptionTransportTel;
    }


    @Column(name = "rcp_receptionimmatriculation", length = 50)

    public String getRcpReceptionImmatriculation() {
        return rcpReceptionImmatriculation;
    }

    public void setRcpReceptionImmatriculation(String rcpReceptionImmatriculation) {
        this.rcpReceptionImmatriculation = rcpReceptionImmatriculation;
    }

    @Column(name = "rcp_receptiontransportcontact", length = 50)

    public String getRcpReceptionTransportContact() {
        return rcpReceptionTransportContact;
    }

    public void setRcpReceptionTransportContact(String rcpReceptionTransportContact) {
        this.rcpReceptionTransportContact = rcpReceptionTransportContact;
    }

    @Column(name = "rcp_receptiontransfertcode")
    public String getRcpReceptionTransfertCode() {
        return rcpReceptionTransfertCode;
    }

    public void setRcpReceptionTransfertCode(String rcpReceptionTransfertCode) {
        this.rcpReceptionTransfertCode = rcpReceptionTransfertCode;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @Column(name = "rcp_receptionsendedtowms")

    public Boolean getRcpReceptionSendedToWms() {
        return rcpReceptionSendedToWms;
    }

    public void setRcpReceptionSendedToWms(Boolean rcpReceptionSendedToWms) {
        this.rcpReceptionSendedToWms = rcpReceptionSendedToWms;
    }

    @Column(name = "rcp_receptiondiscount")
    public BigDecimal getRcpReceptionDiscount() {
        return rcpReceptionDiscount;
    }

    public void setRcpReceptionDiscount(BigDecimal rcpReceptionDiscount) {
        this.rcpReceptionDiscount = rcpReceptionDiscount;
    }

    @Column(name = "rcp_receptiontotalpriceht")
    public BigDecimal getRcpReceptionTotalPriceHT() {
        return rcpReceptionTotalPriceHT;
    }

    public void setRcpReceptionTotalPriceHT(BigDecimal rcpReceptionTotalPriceHT) {
        this.rcpReceptionTotalPriceHT = rcpReceptionTotalPriceHT;
    }

    @Column(name = "rcp_receptiontotalpricettc")
    public BigDecimal getRcpReceptionTotalPriceTTC() {
        return rcpReceptionTotalPriceTTC;
    }

    public void setRcpReceptionTotalPriceTTC(BigDecimal rcpReceptionTotalPriceTTC) {
        this.rcpReceptionTotalPriceTTC = rcpReceptionTotalPriceTTC;
    }

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptioncurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }
*/
    @Column(name = "rcp_receptionvat")
    public BigDecimal getRcpReceptionVat() {
        return rcpReceptionVat;
    }

    public void setRcpReceptionVat(BigDecimal rcpReceptionVat) {
        this.rcpReceptionVat = rcpReceptionVat;
    }

    @Column(name = "rcp_receptionactive")
    public Boolean getRcpReceptionActive() {
        return rcpReceptionActive;
    }

    public void setRcpReceptionActive(Boolean rcpReceptionActive) {
        this.rcpReceptionActive = rcpReceptionActive;
    }

    @Column(name = "rcp_receptionaccounted")
    public Boolean getRcpReceptionAccounted() {
        return rcpReceptionAccounted;
    }

    public void setRcpReceptionAccounted(Boolean rcpReceptionAccounted) {
        this.rcpReceptionAccounted = rcpReceptionAccounted;
    }
    @Column(name = "rcp_receptiontotalpricehtdefaultcurrency")
    public BigDecimal getRcpPurshaseTotalPriceHTDefaultCurrency() {
        return rcpReceptionTotalPriceHTDefaultCurrency;
    }

    public void setRcpPurshaseTotalPriceHTDefaultCurrency(BigDecimal rcpReceptionTotalPriceHTDefaultCurrency) {
        this.rcpReceptionTotalPriceHTDefaultCurrency = rcpReceptionTotalPriceHTDefaultCurrency;
    }

    @Column(name = "rcp_receptiontotalpricettcdefaultcurrency")

    public BigDecimal getRcpPurshaseTotalPriceTTCDefaultCurrency() {
        return rcpReceptionTotalPriceTTCDefaultCurrency;
    }

    public void setRcpPurshaseTotalPriceTTCDefaultCurrency(BigDecimal rcpReceptionTotalPriceTTCDefaultCurrency) {
        this.rcpReceptionTotalPriceTTCDefaultCurrency = rcpReceptionTotalPriceTTCDefaultCurrency;
    }

    @Column(name = "rcp_receptionvatdefaultcurrency")

    public BigDecimal getRcpPurshaseVatDefaultCurrency() {
        return rcpReceptionVatDefaultCurrency;
    }

    public void setRcpPurshaseVatDefaultCurrency(BigDecimal rcpReceptionVatDefaultCurrency) {
        this.rcpReceptionVatDefaultCurrency = rcpReceptionVatDefaultCurrency;
    }

    @Column(name = "rcp_receptionexchangerate")

    public BigDecimal getRcpPurshaseExchangeRate() {
        return rcpReceptionExchangeRate;
    }

    public void setRcpPurshaseExchangeRate(BigDecimal rcpReceptionExchangeRate) {
        this.rcpReceptionExchangeRate = rcpReceptionExchangeRate;
    }

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionboxid")
    public UsrBox getUsrBox() {
        return usrBox;
    }

    public void setUsrBox(UsrBox usrBox) {
        this.usrBox = usrBox;
    }*/
    @Column(name = "rcp_receptionprovisionalcost")
    public BigDecimal getRcpReceptionProvisionalCost() {
        return rcpReceptionProvisionalCost;
    }

    public void setRcpReceptionProvisionalCost(BigDecimal rcpReceptionProvisionalCost) {
        this.rcpReceptionProvisionalCost = rcpReceptionProvisionalCost;
    }
    @Column(name = "rcp_receptionsupplierdeliverydate")
    @Temporal(TemporalType.DATE)
    public Date getRcpReceptionSupplierDeliveryDate() {
        return rcpReceptionSupplierDeliveryDate;
    }

    public void setRcpReceptionSupplierDeliveryDate(Date rcpReceptionSupplierDeliveryDate) {
        this.rcpReceptionSupplierDeliveryDate = rcpReceptionSupplierDeliveryDate;
    }
 }