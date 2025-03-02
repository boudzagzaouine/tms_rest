package com.bagile.gmo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import com.bagile.gmo.dto.EmsDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CmdSaleOrder generated by hbm2java
 */
@Entity
@Table(name = "cmd_saleorder", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cmd_saleordercode")})
public class CmdSaleOrder extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4700899893257928381L;

    private Long cmdSaleOrderId;
    private CmdAccount cmdAccount;
    @NotNull
    private OwnOwner ownOwner;



    private AdrAddressInfo deliveryAddress;


    private AdrAddressInfo invoiceAddress;

    private PrmOrderStatus prmOrderStatus;
    private PrmOrderType prmOrderType;
    private RcpSupplier rcpSupplier;
    private TrpTransport trpTransport;
    private WrhWarehouse wrhWarehouseSource;
    private WrhWarehouse wrhWarehouseDestination;
    @Size(max = 30)
    @NotNull
    private String cmdSaleOrderCode;
    @Size(max = 255)
    private String cmdSaleOrderRemarks;
    @Size(max = 30)
    private String cmdSaleOrderCustomerCode;
    @Size(max = 255)
    private String cmdSaleOrderDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderExpectedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderLoadDate;
    private Short cmdSaleOrderContainers;
    @Size(max = 50)
    private String cmdSaleOrderTransportContact;
    @Size(max = 20)
    private String cmdSaleOrderImmatriculation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdSaleOrderCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;
    @Size(max = 255)
    private String cmdSaleOrderVariable1;
    @Size(max = 255)
    private String cmdSaleOrderVariable2;
    @Size(max = 255)
    private String cmdSaleOrderVariable3;
    @Size(max = 255)
    private String cmdSaleOrderVariable4;
    @Size(max = 255)
    private String cmdSaleOrderVariable5;
    @Size(max = 255)
    private String cmdSaleOrderVariable6;
    @Size(max = 255)
    private String cmdSaleOrderVariable7;
    @Size(max = 255)
    private String cmdSaleOrderVariable8;
    @Size(max = 255)
    private String cmdSaleOrderVariable9;
    @Size(max = 255)
    private String cmdSaleOrderVariable10;
    @Size(max = 20)
    private String cmdSaleOrderTransportTel;
    @Size(max = 50)
    private String cmdSaleOrderTransfertCode;
    private Boolean cmdSaleOrderSendedToWms;
    private BigDecimal cmdSaleOrderTotalPriceHT;
    private BigDecimal cmdSaleOrderTotalPriceTTC;
    private BigDecimal cmdSaleOrderDiscount;
    private BigDecimal cmdSaleOrderVat;
    @NotNull
    private Boolean cmdSaleOrderActive;
    private BigDecimal cmdSaleOrderPayedAmount;
    private Set<CmdSaleOrderLine> cmdSaleOrderLines = new HashSet<CmdSaleOrderLine>(
            0);
    private Boolean cmdSaleOrderAccounted;
    private BigDecimal cmdSaleOrderTotalPriceHTDefaultCurrency;
    private BigDecimal cmdSaleOrderTotalPriceTTCDefaultCurrency;
    private BigDecimal cmdSaleOrderVatDefaultCurrency;
    private BigDecimal cmdSaleOrderExchangeRate;
    private String cmdSaleOrderDealCode;
    private Boolean cmdSaleOrderConfirmed;

    private Boolean cmdSaleOrderGmao;



    public CmdSaleOrder() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_saleorder", allocationSize = 1)
    @Column(name = "cmd_saleorderid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getCmdSaleOrderId() {
        return this.cmdSaleOrderId;
    }

    public void setCmdSaleOrderId(Long cmdSaleOrderId) {
        this.cmdSaleOrderId = cmdSaleOrderId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderaccountid")
    public CmdAccount getCmdAccount() {
        return this.cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }



    @AttributeOverrides(value = {
            @AttributeOverride(name = "adrAddressLine1", column = @Column(name = "cmd_sorderdeliveryaddressline1")),
            @AttributeOverride(name = "adrAddressLine2", column = @Column(name = "cmd_sorderdeliveryaddressline2")),
            @AttributeOverride(name = "adrAddressZip", column = @Column(name = "cmd_sorderdeliveryaddresszip")),
            @AttributeOverride(name = "adrAddressCity", column = @Column(name = "cmd_sorderdeliveryaddresscity")),
            @AttributeOverride(name = "adrAddressState", column = @Column(name = "cmd_sorderdeliveryaddressstate")),
            @AttributeOverride(name = "adrAddressCountry", column = @Column(name = "cmd_sorderdeliveryaddresscountry")),
            @AttributeOverride(name = "adrAddressDigiCode", column = @Column(name = "cmd_sorderdeliveryaddressdigicode")),
            @AttributeOverride(name = "adrAddressLatitude", column = @Column(name = "cmd_deliverydeliveryaddresslatitude")),
            @AttributeOverride(name = "adrAddressLongitude", column = @Column(name = "cmd_deliverydeliveryaddresslongitude")),
    })
    @Embedded
    public AdrAddressInfo getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(
            AdrAddressInfo deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }




    public void setInvoiceAddress(
            AdrAddressInfo invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    @AttributeOverrides(value = {
            @AttributeOverride(name = "adrAddressLine1", column = @Column(name = "cmd_sorderinvoiceeaddressline1")),
            @AttributeOverride(name = "adrAddressLine2", column = @Column(name = "cmd_sorderinvoiceeaddressline2")),
            @AttributeOverride(name = "adrAddressZip", column = @Column(name = "cmd_sorderinvoiceeaddresszip")),
            @AttributeOverride(name = "adrAddressCity", column = @Column(name = "cmd_sorderinvoiceeaddresscity")),
            @AttributeOverride(name = "adrAddressState", column = @Column(name = "cmd_sorderinvoiceeaddressstate")),
            @AttributeOverride(name = "adrAddressCountry", column = @Column(name = "cmd_sorderinvoiceeaddresscountry")),
            @AttributeOverride(name = "adrAddressDigiCode", column = @Column(name = "cmd_sorderinvoiceeaddressdigicode")),
    })
    @Embedded
    public AdrAddressInfo getInvoiceAddress() {
        return invoiceAddress;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderwarehousesourceid")
    public WrhWarehouse getWrhWarehouseSource() {
        return wrhWarehouseSource;
    }

    public void setWrhWarehouseSource(WrhWarehouse wrhWarehouseSource) {
        this.wrhWarehouseSource = wrhWarehouseSource;

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderwarehousedestinationid")
    public WrhWarehouse getWrhWarehouseDestination() {
        return wrhWarehouseDestination;
    }

    public void setWrhWarehouseDestination(WrhWarehouse wrhWarehouseDestination) {
        this.wrhWarehouseDestination = wrhWarehouseDestination;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return this.prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleordertypeid", nullable = false)
    public PrmOrderType getPrmOrderType() {
        return this.prmOrderType;
    }

    public void setPrmOrderType(PrmOrderType prmOrderType) {
        this.prmOrderType = prmOrderType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleordersupplierid")
    public RcpSupplier getRcpSupplier() {
        return this.rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleordertransportid")
    public TrpTransport getTrpTransport() {
        return this.trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @Column(name = "cmd_saleordercode", unique = true, nullable = false, length = 30)
    public String getCmdSaleOrderCode() {
        return this.cmdSaleOrderCode;
    }

    public void setCmdSaleOrderCode(String cmdSaleOrderCode) {
        this.cmdSaleOrderCode = cmdSaleOrderCode;
    }

    @Column(name = "cmd_saleorderRemarks")
    public String getCmdSaleOrderRemarks() {
        return this.cmdSaleOrderRemarks;
    }

    public void setCmdSaleOrderRemarks(String cmdSaleOrderRemarks) {
        this.cmdSaleOrderRemarks = cmdSaleOrderRemarks;
    }

    @Column(name = "cmd_saleordercustomercode", length = 30)
    public String getCmdSaleOrderCustomerCode() {
        return this.cmdSaleOrderCustomerCode;
    }

    public void setCmdSaleOrderCustomerCode(String cmdSaleOrderCustomerCode) {
        this.cmdSaleOrderCustomerCode = cmdSaleOrderCustomerCode;
    }

    @Column(name = "cmd_saleorderdescription")
    public String getCmdSaleOrderDescription() {
        return this.cmdSaleOrderDescription;
    }

    public void setCmdSaleOrderDescription(String cmdSaleOrderDescription) {
        this.cmdSaleOrderDescription = cmdSaleOrderDescription;
    }

    @Column(name = "cmd_saleordergmao")
    public Boolean getCmdSaleOrderGmao() {
        return cmdSaleOrderGmao;
    }

    public void setCmdSaleOrderGmao(Boolean cmdSaleOrderGmao) {
        this.cmdSaleOrderGmao = cmdSaleOrderGmao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_saleorderexpecteddate", length = 13)
    public Date getCmdSaleOrderExpectedDate() {
        return this.cmdSaleOrderExpectedDate;
    }

    public void setCmdSaleOrderExpectedDate(Date cmdSaleOrderExpectedDate) {
        this.cmdSaleOrderExpectedDate = cmdSaleOrderExpectedDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderloaddate")
    public Date getCmdSaleOrderLoadDate() {
        return this.cmdSaleOrderLoadDate;
    }

    public void setCmdSaleOrderLoadDate(Date cmdSaleOrderLoadDate) {
        this.cmdSaleOrderLoadDate = cmdSaleOrderLoadDate;
    }

    @Column(name = "cmd_saleordercontainers", precision = 4, scale = 0)
    public Short getCmdSaleOrderContainers() {
        return this.cmdSaleOrderContainers;
    }

    public void setCmdSaleOrderContainers(Short cmdSaleOrderContainers) {
        this.cmdSaleOrderContainers = cmdSaleOrderContainers;
    }

    @Column(name = "cmd_saleordertransportcontact", length = 50)
    public String getCmdSaleOrderTransportContact() {
        return this.cmdSaleOrderTransportContact;
    }

    public void setCmdSaleOrderTransportContact(
            String cmdSaleOrderTransportContact) {
        this.cmdSaleOrderTransportContact = cmdSaleOrderTransportContact;
    }

    @Column(name = "cmd_saleorderimmatriculation", length = 20)
    public String getCmdSaleOrderImmatriculation() {
        return this.cmdSaleOrderImmatriculation;
    }

    public void setCmdSaleOrderImmatriculation(
            String cmdSaleOrderImmatriculation) {
        this.cmdSaleOrderImmatriculation = cmdSaleOrderImmatriculation;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleordercreationdate")
    public Date getCmdSaleOrderCreationDate() {
        return this.cmdSaleOrderCreationDate;
    }

    public void setCmdSaleOrderCreationDate(Date cmdSaleOrderCreationDate) {
        this.cmdSaleOrderCreationDate = cmdSaleOrderCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderupdatedate")
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "cmd_saleordervariable1")
    public String getCmdSaleOrderVariable1() {
        return this.cmdSaleOrderVariable1;
    }

    public void setCmdSaleOrderVariable1(String cmdSaleOrderVariable1) {
        this.cmdSaleOrderVariable1 = cmdSaleOrderVariable1;
    }

    @Column(name = "cmd_saleordervariable2")
    public String getCmdSaleOrderVariable2() {
        return this.cmdSaleOrderVariable2;
    }

    public void setCmdSaleOrderVariable2(String cmdSaleOrderVariable2) {
        this.cmdSaleOrderVariable2 = cmdSaleOrderVariable2;
    }

    @Column(name = "cmd_saleordervariable3")
    public String getCmdSaleOrderVariable3() {
        return this.cmdSaleOrderVariable3;
    }

    public void setCmdSaleOrderVariable3(String cmdSaleOrderVariable3) {
        this.cmdSaleOrderVariable3 = cmdSaleOrderVariable3;
    }

    @Column(name = "cmd_saleordervariable4")
    public String getCmdSaleOrderVariable4() {
        return this.cmdSaleOrderVariable4;
    }

    public void setCmdSaleOrderVariable4(String cmdSaleOrderVariable4) {
        this.cmdSaleOrderVariable4 = cmdSaleOrderVariable4;
    }

    @Column(name = "cmd_saleordervariable5")
    public String getCmdSaleOrderVariable5() {
        return this.cmdSaleOrderVariable5;
    }

    public void setCmdSaleOrderVariable5(String cmdSaleOrderVariable5) {
        this.cmdSaleOrderVariable5 = cmdSaleOrderVariable5;
    }

    @Column(name = "cmd_saleordervariable6")
    public String getCmdSaleOrderVariable6() {
        return this.cmdSaleOrderVariable6;
    }

    public void setCmdSaleOrderVariable6(String cmdSaleOrderVariable6) {
        this.cmdSaleOrderVariable6 = cmdSaleOrderVariable6;
    }

    @Column(name = "cmd_saleordervariable7")
    public String getCmdSaleOrderVariable7() {
        return this.cmdSaleOrderVariable7;
    }

    public void setCmdSaleOrderVariable7(String cmdSaleOrderVariable7) {
        this.cmdSaleOrderVariable7 = cmdSaleOrderVariable7;
    }

    @Column(name = "cmd_saleordervariable8")
    public String getCmdSaleOrderVariable8() {
        return this.cmdSaleOrderVariable8;
    }

    public void setCmdSaleOrderVariable8(String cmdSaleOrderVariable8) {
        this.cmdSaleOrderVariable8 = cmdSaleOrderVariable8;
    }

    @Column(name = "cmd_saleordervariable9")
    public String getCmdSaleOrderVariable9() {
        return this.cmdSaleOrderVariable9;
    }

    public void setCmdSaleOrderVariable9(String cmdSaleOrderVariable9) {
        this.cmdSaleOrderVariable9 = cmdSaleOrderVariable9;
    }

    @Column(name = "cmd_saleordervariable10")
    public String getCmdSaleOrderVariable10() {
        return this.cmdSaleOrderVariable10;
    }

    public void setCmdSaleOrderVariable10(String cmdSaleOrderVariable10) {
        this.cmdSaleOrderVariable10 = cmdSaleOrderVariable10;
    }


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cmdSaleOrder", orphanRemoval = true)
    public Set<CmdSaleOrderLine> getCmdSaleOrderLines() {
        return this.cmdSaleOrderLines;
    }

    public void setCmdSaleOrderLines(Set<CmdSaleOrderLine> cmdSaleOrderLines) {
        this.cmdSaleOrderLines = cmdSaleOrderLines;
    }

    @Column(name = "cmd_saleordertransporttel")
    public String getCmdSaleOrderTransportTel() {
        return cmdSaleOrderTransportTel;
    }

    public void setCmdSaleOrderTransportTel(String cmdSaleOrderTransportTel) {
        this.cmdSaleOrderTransportTel = cmdSaleOrderTransportTel;
    }

    @Column(name = "cmd_saleordertransfertcode", length = 50)
    public String getCmdSaleOrderTransfertCode() {
        return cmdSaleOrderTransfertCode;
    }

    public void setCmdSaleOrderTransfertCode(String cmdSaleOrderTransfertCode) {
        this.cmdSaleOrderTransfertCode = cmdSaleOrderTransfertCode;
    }

    @Column(name = "cmd_saleordersendedtowms")
    public Boolean getCmdSaleOrderSendedToWms() {
        return cmdSaleOrderSendedToWms;
    }

    public void setCmdSaleOrderSendedToWms(Boolean cmdSaleOrderSendedToWms) {
        this.cmdSaleOrderSendedToWms = cmdSaleOrderSendedToWms;
    }


    @Column(name = "cmd_saleOrdertotalpriceht")
    public BigDecimal getCmdSaleOrderTotalPriceHT() {
        return cmdSaleOrderTotalPriceHT;
    }

    public void setCmdSaleOrderTotalPriceHT(BigDecimal cmdSaleOrderTotalPriceHT) {
        this.cmdSaleOrderTotalPriceHT = cmdSaleOrderTotalPriceHT;
    }

    @Column(name = "cmd_saleOrdertotalpricettc")

    public BigDecimal getCmdSaleOrderTotalPriceTTC() {
        return cmdSaleOrderTotalPriceTTC;
    }

    public void setCmdSaleOrderTotalPriceTTC(BigDecimal cmdSaleOrderTotalPriceTTC) {
        this.cmdSaleOrderTotalPriceTTC = cmdSaleOrderTotalPriceTTC;
    }

    @Column(name = "cmd_saleOrderdiscount")

    public BigDecimal getCmdSaleOrderDiscount() {
        return cmdSaleOrderDiscount;
    }

    public void setCmdSaleOrderDiscount(BigDecimal cmdSaleOrderDiscount) {
        this.cmdSaleOrderDiscount = cmdSaleOrderDiscount;
    }


    @Column(name = "cmd_saleordervat")
    public BigDecimal getCmdSaleOrderVat() {
        return cmdSaleOrderVat;
    }

    public void setCmdSaleOrderVat(BigDecimal cmdSaleOrderVat) {
        this.cmdSaleOrderVat = cmdSaleOrderVat;
    }

    @Column(name = "cmd_saleorderactive", nullable = false)
    public Boolean getCmdSaleOrderActive() {
        return cmdSaleOrderActive;
    }

    public void setCmdSaleOrderActive(Boolean cmdSaleOrderActive) {
        this.cmdSaleOrderActive = cmdSaleOrderActive;
    }


    @Column(name = "cmd_saleorderaccounted")
    public Boolean getCmdSaleOrderAccounted() {
        return cmdSaleOrderAccounted;
    }

    public void setCmdSaleOrderAccounted(Boolean cmdSaleOrderAccounted) {
        this.cmdSaleOrderAccounted = cmdSaleOrderAccounted;
    }

    @Column(name = "cmd_saleorderpayedamount")
    public BigDecimal getCmdSaleOrderPayedAmount() {
        return cmdSaleOrderPayedAmount;
    }

    public void setCmdSaleOrderPayedAmount(BigDecimal cmdSaleOrderPayedAmount) {
        this.cmdSaleOrderPayedAmount = cmdSaleOrderPayedAmount;
    }




    @Column(name = "cmd_saleordertotalpricehtdefaultcurrency")
    public BigDecimal getCmdSaleOrderTotalPriceHTDefaultCurrency() {
        return cmdSaleOrderTotalPriceHTDefaultCurrency;
    }

    public void setCmdSaleOrderTotalPriceHTDefaultCurrency(BigDecimal cmdSaleOrderTotalPriceHTDefaultCurrency) {
        this.cmdSaleOrderTotalPriceHTDefaultCurrency = cmdSaleOrderTotalPriceHTDefaultCurrency;
    }

    @Column(name = "cmd_saleordervatdefaultcurrency")

    public BigDecimal getCmdSaleOrderVatDefaultCurrency() {
        return cmdSaleOrderVatDefaultCurrency;
    }

    public void setCmdSaleOrderVatDefaultCurrency(BigDecimal cmdSaleOrderVatDefaultCurrency) {
        this.cmdSaleOrderVatDefaultCurrency = cmdSaleOrderVatDefaultCurrency;
    }

    @Column(name = "cmd_saleorderexchangerate")

    public BigDecimal getCmdSaleOrderExchangeRate() {
        return cmdSaleOrderExchangeRate;
    }

    public void setCmdSaleOrderExchangeRate(BigDecimal cmdSaleOrderExchangeRate) {
        this.cmdSaleOrderExchangeRate = cmdSaleOrderExchangeRate;
    }

    @Column(name = "cmd_saleordertotalpricettcdefaultcurrency")

    public BigDecimal getCmdSaleOrderTotalPriceTTCDefaultCurrency() {
        return cmdSaleOrderTotalPriceTTCDefaultCurrency;
    }

    public void setCmdSaleOrderTotalPriceTTCDefaultCurrency(BigDecimal cmdSaleOrderTotalPriceTTCDefaultCurrency) {
        this.cmdSaleOrderTotalPriceTTCDefaultCurrency = cmdSaleOrderTotalPriceTTCDefaultCurrency;
    }



    @Column(name = "cmd_saleorderdealcode")
    public String getCmdSaleOrderDealCode() {
        return cmdSaleOrderDealCode;
    }

    public void setCmdSaleOrderDealCode(String cmdSaleOrderDealCode) {
        this.cmdSaleOrderDealCode = cmdSaleOrderDealCode;
    }
@Column(name = "cmd_saleorderconfirmed")
    public Boolean getCmdSaleOrderConfirmed() {
        return cmdSaleOrderConfirmed;
    }

    public void setCmdSaleOrderConfirmed(Boolean cmdSaleOrderConfirmed) {
        this.cmdSaleOrderConfirmed = cmdSaleOrderConfirmed;
    }
}
