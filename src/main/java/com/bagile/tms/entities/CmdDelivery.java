package com.bagile.tms.entities;

import com.bagile.tms.dto.EmsDto;
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
 * Created by pc on 20/04/2016.
 */
@Entity
@Table(name = "cmd_delivery", uniqueConstraints = @UniqueConstraint(columnNames = "cmd_deliverycode"))
public class CmdDelivery extends EmsDto {
    private long cmdDeliveryId;
    @Size(max = 30)
    @NotNull
    private String cmdDeliveryCode;
    @Size(max = 255)
    private String cmdDeliveryDescription;
    private CmdAccount cmdAccount;
    @NotNull
    private WrhWarehouse wrhWarehouse;
    private TrpTransport trpTransport;
    private AdrAddressInfo deliveryAddress;
    private AdrAddressInfo invoiceAddress;
    @NotNull
    private OwnOwner ownOwner;
    private PrmOrderStatus prmOrderStatus;
    private CmdSaleOrder cmdSaleOrder;
    private PrmOrderType prmOrderType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryExpectedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryUpdateDate;

    @Size(max = 255)
    private String cmdDeliveryComment;
    @Max(999999999)
    private Long cmdDeliveryContainerCount;
    private String cmdDeliveryTransportTel;
    @Size(max = 255)
    private String cmdDeliveryRemarks;
    @Size(max = 100)
    private String cmdDeliveryTransportContact;
    @Size(max = 50)
    private String cmdDeliveryImmatriculation;
    @Size(max = 50)
    private String cmdDeliveryTransfertCode;
    private Boolean cmdDeliverySendedToEms;
    private BigDecimal cmdDeliveryTotalPriceHT;
    private BigDecimal cmdDeliveryTotalPriceTTC;
    private BigDecimal cmdDeliveryDiscount;
    private BigDecimal cmdDeliveryVat;
    private Set<CmdDeliveryLine> cmdDeliveryLines = new HashSet<CmdDeliveryLine>(0);
    private Boolean cmdDeliveryActive;
    private Boolean cmdDeliveryAccounted;
    private BigDecimal cmdDeliveryTotalPriceHTDefaultCurrency;
    private BigDecimal cmdDeliveryTotalPriceTTCDefaultCurrency;
    private BigDecimal cmdDeliveryVatDefaultCurrency;
    private BigDecimal cmdDeliveryExchangeRate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_delivery", allocationSize = 1)
    @Column(name = "cmd_deliveryid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdDeliveryId() {
        return cmdDeliveryId;
    }

    public void setCmdDeliveryId(long cmdDeliveryId) {
        this.cmdDeliveryId = cmdDeliveryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverysaleorderid")
    public CmdSaleOrder getCmdSaleOrder() {
        return cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliveryordertypeid")
    public PrmOrderType getPrmOrderType() {
        return prmOrderType;
    }

    public void setPrmOrderType(PrmOrderType prmOrderType) {
        this.prmOrderType = prmOrderType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliveryaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverywarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverytransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "adrAddressLine1", column = @Column(name = "cmd_deliverydeliveryaddressline1")),
            @AttributeOverride(name = "adrAddressLine2", column = @Column(name = "cmd_deliverydeliveryaddressline2")),
            @AttributeOverride(name = "adrAddressZip", column = @Column(name = "cmd_deliverydeliveryaddresszip")),
            @AttributeOverride(name = "adrAddressCity", column = @Column(name = "cmd_deliverydeliveryaddresscity")),
            @AttributeOverride(name = "adrAddressState", column = @Column(name = "cmd_deliverydeliveryaddressstate")),
            @AttributeOverride(name = "adrAddressCountry", column = @Column(name = "cmd_deliverydeliveryaddresscountry")),
            @AttributeOverride(name = "adrAddressDigiCode", column = @Column(name = "cmd_deliverydeliveryaddressdigicode")),
    })
    public AdrAddressInfo getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AdrAddressInfo deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "adrAddressLine1", column = @Column(name = "cmd_deliveryinvoiceaddresaddressline1")),
            @AttributeOverride(name = "adrAddressLine2", column = @Column(name = "cmd_deliveryinvoiceaddresaddressline2")),
            @AttributeOverride(name = "adrAddressZip", column = @Column(name = "cmd_deliveryinvoiceaddresaddresszip")),
            @AttributeOverride(name = "adrAddressCity", column = @Column(name = "cmd_deliveryinvoiceaddresaddresscity")),
            @AttributeOverride(name = "adrAddressState", column = @Column(name = "cmd_deliveryinvoiceaddresaddressstate")),
            @AttributeOverride(name = "adrAddressCountry", column = @Column(name = "cmd_deliveryinvoiceaddresaddresscountry")),
            @AttributeOverride(name = "adrAddressDigiCode", column = @Column(name = "cmd_deliveryinvoiceaddresaddressdigicode")),
    })
    public AdrAddressInfo getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(AdrAddressInfo invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliveryownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliveryorderstatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_deliveryexpecteddate", length = 13)
    public Date getCmdDeliveryExpectedDate() {
        return cmdDeliveryExpectedDate;
    }

    public void setCmdDeliveryExpectedDate(Date cmdDeliveryExpectedDate) {
        this.cmdDeliveryExpectedDate = cmdDeliveryExpectedDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_deliveryloaddate")
    public Date getCmdDeliveryDate() {
        return cmdDeliveryDate;
    }

    public void setCmdDeliveryDate(Date cmdDeliveryDate) {
        this.cmdDeliveryDate = cmdDeliveryDate;
    }

    @Column(name = "cmd_deliverycomment", length = 255)
    public String getCmdDeliveryComment() {
        return cmdDeliveryComment;
    }

    public void setCmdDeliveryComment(String cmdDeliveryComment) {
        this.cmdDeliveryComment = cmdDeliveryComment;
    }

    @Column(name = "cmd_deliverydescription", length = 255)
    public String getCmdDeliveryDescription() {
        return cmdDeliveryDescription;
    }

    public void setCmdDeliveryDescription(String cmdDeliveryDescription) {
        this.cmdDeliveryDescription = cmdDeliveryDescription;
    }

    @Column(name = "cmd_deliverycontainercount", precision = 12, scale = 0)
    public Long getCmdDeliveryContainerCount() {
        return cmdDeliveryContainerCount;
    }

    public void setCmdDeliveryContainerCount(Long cmdDeliveryContainerCount) {
        this.cmdDeliveryContainerCount = cmdDeliveryContainerCount;
    }

    @Column(name = "cmd_deliverycode", nullable = false, length = 30)
    public String getCmdDeliveryCode() {
        return cmdDeliveryCode;
    }

    public void setCmdDeliveryCode(String cmdDeliveryCode) {
        this.cmdDeliveryCode = cmdDeliveryCode;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cmdDelivery", orphanRemoval = true)
    public Set<CmdDeliveryLine> getCmdDeliveryLines() {
        return cmdDeliveryLines;
    }

    public void setCmdDeliveryLines(Set<CmdDeliveryLine> cmdDeliveryLines) {
        this.cmdDeliveryLines = cmdDeliveryLines;
    }




    @Column(name = "cmd_deliverytransporttel")
    public String getCmdDeliveryTransportTel() {
        return cmdDeliveryTransportTel;
    }

    public void setCmdDeliveryTransportTel(String cmdDeliveryTransportTel) {
        this.cmdDeliveryTransportTel = cmdDeliveryTransportTel;
    }

    @Column(name = "cmd_deliveryremarks", length = 255)
    public String getCmdDeliveryRemarks() {
        return cmdDeliveryRemarks;
    }

    public void setCmdDeliveryRemarks(String cmdDeliveryRemarks) {
        this.cmdDeliveryRemarks = cmdDeliveryRemarks;
    }

    @Column(name = "cmd_deliverytransportcontact", length = 100)
    public String getCmdDeliveryTransportContact() {
        return cmdDeliveryTransportContact;
    }

    public void setCmdDeliveryTransportContact(String cmdDeliveryTransportContact) {
        this.cmdDeliveryTransportContact = cmdDeliveryTransportContact;
    }

    @Column(name = "cmd_deliveryimmatriculation", length = 50)
    public String getCmdDeliveryImmatriculation() {
        return cmdDeliveryImmatriculation;
    }

    public void setCmdDeliveryImmatriculation(String cmdDeliveryImmatriculation) {
        this.cmdDeliveryImmatriculation = cmdDeliveryImmatriculation;
    }

    @Column(name = "cmd_deliverycreationdate")
    public Date getCmdDeliveryCreationDate() {
        return cmdDeliveryCreationDate;
    }

    public void setCmdDeliveryCreationDate(Date cmdDeliveryCreationDate) {
        this.cmdDeliveryCreationDate = cmdDeliveryCreationDate;
    }

    @Column(name = "cmd_deliveryupdatedate")

    public Date getCmdDeliveryUpdateDate() {
        return cmdDeliveryUpdateDate;
    }

    public void setCmdDeliveryUpdateDate(Date cmdDeliveryUpdateDate) {
        this.cmdDeliveryUpdateDate = cmdDeliveryUpdateDate;
    }

    @Column(name = "cmd_deliverytransfertcode", length = 50)
    public String getCmdDeliveryTransfertCode() {
        return cmdDeliveryTransfertCode;
    }

    public void setCmdDeliveryTransfertCode(String cmdDeliveryTransfertCode) {
        this.cmdDeliveryTransfertCode = cmdDeliveryTransfertCode;
    }

    @Column(name = "cmd_deliverysendedtowms")
    public Boolean getCmdDeliverySendedToEms() {
        return cmdDeliverySendedToEms;
    }

    public void setCmdDeliverySendedToEms(Boolean cmdDeliverySendedToEms) {
        this.cmdDeliverySendedToEms = cmdDeliverySendedToEms;
    }


    @Column(name = "cmd_deliverytotalpriceht")

    public BigDecimal getCmdDeliveryTotalPriceHT() {
        return cmdDeliveryTotalPriceHT;
    }

    public void setCmdDeliveryTotalPriceHT(BigDecimal cmdDeliveryTotalPriceHT) {
        this.cmdDeliveryTotalPriceHT = cmdDeliveryTotalPriceHT;
    }

    @Column(name = "cmd_deliverytotalpricettc")

    public BigDecimal getCmdDeliveryTotalPriceTTC() {
        return cmdDeliveryTotalPriceTTC;
    }

    public void setCmdDeliveryTotalPriceTTC(BigDecimal cmdDeliveryTotalPriceTTC) {
        this.cmdDeliveryTotalPriceTTC = cmdDeliveryTotalPriceTTC;
    }

    @Column(name = "cmd_deliverydiscount")

    public BigDecimal getCmdDeliveryDiscount() {
        return cmdDeliveryDiscount;
    }

    public void setCmdDeliveryDiscount(BigDecimal cmdDeliveryDiscount) {
        this.cmdDeliveryDiscount = cmdDeliveryDiscount;
    }


    @Column(name = "cmd_deliveryvat")
    public BigDecimal getCmdDeliveryVat() {
        return cmdDeliveryVat;
    }

    public void setCmdDeliveryVat(BigDecimal cmdDeliveryVat) {
        this.cmdDeliveryVat = cmdDeliveryVat;
    }


    @Column(name = "cmd_deliveryactive")

    public Boolean getCmdDeliveryActive() {
        return cmdDeliveryActive;
    }

    public void setCmdDeliveryActive(Boolean cmdDeliveryActive) {
        this.cmdDeliveryActive = cmdDeliveryActive;
    }

    @Column(name = "cmd_deliveryaccounted")
    public Boolean getCmdDeliveryAccounted() {
        return cmdDeliveryAccounted;
    }

    public void setCmdDeliveryAccounted(Boolean cmdDeliveryAccounted) {
        this.cmdDeliveryAccounted = cmdDeliveryAccounted;
    }

    @Column(name = "cmd_deliverytotalpricehtdefaultcurrency")
    public BigDecimal getCmdDeliveryTotalPriceHTDefaultCurrency() {
        return cmdDeliveryTotalPriceHTDefaultCurrency;
    }

    public void setCmdDeliveryTotalPriceHTDefaultCurrency(BigDecimal cmdDeliveryTotalPriceHTDefaultCurrency) {
        this.cmdDeliveryTotalPriceHTDefaultCurrency = cmdDeliveryTotalPriceHTDefaultCurrency;
    }

    @Column(name = "cmd_deliverytotalpricettcdefaultcurrency")

    public BigDecimal getCmdDeliveryTotalPriceTTCDefaultCurrency() {
        return cmdDeliveryTotalPriceTTCDefaultCurrency;
    }

    public void setCmdDeliveryTotalPriceTTCDefaultCurrency(BigDecimal cmdDeliveryTotalPriceTTCDefaultCurrency) {
        this.cmdDeliveryTotalPriceTTCDefaultCurrency = cmdDeliveryTotalPriceTTCDefaultCurrency;
    }

    @Column(name = "cmd_deliveryvatdefaultcurrency")

    public BigDecimal getCmdDeliveryVatDefaultCurrency() {
        return cmdDeliveryVatDefaultCurrency;
    }

    public void setCmdDeliveryVatDefaultCurrency(BigDecimal cmdDeliveryVatDefaultCurrency) {
        this.cmdDeliveryVatDefaultCurrency = cmdDeliveryVatDefaultCurrency;
    }

    @Column(name = "cmd_deliveryexchangerate")

    public BigDecimal getCmdDeliveryExchangeRate() {
        return cmdDeliveryExchangeRate;
    }

    public void setCmdDeliveryExchangeRate(BigDecimal cmdDeliveryExchangeRate) {
        this.cmdDeliveryExchangeRate = cmdDeliveryExchangeRate;
    }
}
