package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 21/04/2016.
 */

@Entity
@Table(name = "cmd_deliveryline_arc")

public class CmdDeliveryLineArc {
    private long cmdDeliveryLineId;
    @Max(999999999)
    private Long cmdDeliveryLinelineNumber;
    private CmdSaleOrderLineArc cmdSaleOrderLine;
    @NotNull
    private PdtProduct pdtProduct;
    @Size(max = 255)
    private String cmdDeliveryLineProductDescription;
    @NotNull
    @Max(999999999)
    private BigDecimal cmdDeliveryLineOrderQuantity;
    private PdtUom pdtUom;
    @Max(999999999)
    private BigDecimal cmdDeliveryLineQuantityServed;
    private PrmBlockType prmBlockType;
    @NotNull
    private WrhWarehouse wrhWarehouse;

    private StkContainerArc cmdDeliveryLineContainer;

    private PrmOrderStatus prmOrderStatus;
    @Size(max = 255)
    private String cmdDeliveryLineSerialNo;
    @Size(max = 255)
    private String cmdDeliveryLineLot;
    private PrmColor cmdDeliveryLineColor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineDluo;
    private String cmdDeliveryLineComment;
    @NotNull
    private OwnOwner ownOwner;
    private CmdDeliveryArc cmdDelivery;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineUpdateDate;
    private String cmdDeliveryLineQuality;
    @Max(999999999)
    private BigDecimal cmdDeliveryLineWeight;
    private LocLocation locLocation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_deliveryline_arc", allocationSize = 1)
    @Column(name = "cmd_deliverylineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdDeliveryLineId() {
        return cmdDeliveryLineId;
    }

    public void setCmdDeliveryLineId(long cmdDeliveryLineId) {
        this.cmdDeliveryLineId = cmdDeliveryLineId;
    }

    public Long getCmdDeliveryLinelineNumber() {
        return cmdDeliveryLinelineNumber;
    }

    public void setCmdDeliveryLinelineNumber(Long cmdDeliveryLinelineNumber) {
        this.cmdDeliveryLinelineNumber = cmdDeliveryLinelineNumber;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinesaleorderlineid", nullable = false)
    public CmdSaleOrderLineArc getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLineArc cmdSaleOrderLine) {
        this.cmdSaleOrderLine = cmdSaleOrderLine;
    }

    @Column(name = "cmd_deliverylinedescription")
    public String getCmdDeliveryLineProductDescription() {
        return cmdDeliveryLineProductDescription;
    }

    public void setCmdDeliveryLineProductDescription(String cmdDeliveryLineProductDescription) {
        this.cmdDeliveryLineProductDescription = cmdDeliveryLineProductDescription;
    }
    @Column(name = "cmd_deliverylinequantity", nullable = false, precision = 12, scale = 5)
    public BigDecimal getCmdDeliveryLineOrderQuantity() {
        return cmdDeliveryLineOrderQuantity;
    }

    public void setCmdDeliveryLineOrderQuantity(BigDecimal cmdDeliveryLineOrderQuantity) {
        this.cmdDeliveryLineOrderQuantity = cmdDeliveryLineOrderQuantity;
    }


    @Column(name = "cmd_deliveryquantityserved", precision = 12, scale = 5)
    public BigDecimal getCmdDeliveryLineQuantityServed() {
        return cmdDeliveryLineQuantityServed;
    }

    public void setCmdDeliveryLineQuantityServed(BigDecimal cmdDeliveryLineQuantityServed) {
        this.cmdDeliveryLineQuantityServed = cmdDeliveryLineQuantityServed;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinecontainerid")
    public StkContainerArc getCmdDeliveryLineContainer() {
        return cmdDeliveryLineContainer;
    }

    public void setCmdDeliveryLineContainer(StkContainerArc cmdDeliveryLineContainer) {
        this.cmdDeliveryLineContainer = cmdDeliveryLineContainer;
    }
    @Column(name = "cmd_deliverylineserialno", length = 50)
    public String getCmdDeliveryLineSerialNo() {
        return cmdDeliveryLineSerialNo;
    }

    public void setCmdDeliveryLineSerialNo(String cmdDeliveryLineSerialNo) {
        this.cmdDeliveryLineSerialNo = cmdDeliveryLineSerialNo;
    }
    @Column(name = "cmd_deliverylinelot", length = 50)
    public String getCmdDeliveryLineLot() {
        return cmdDeliveryLineLot;
    }

    public void setCmdDeliveryLineLot(String cmdDeliveryLineLot) {
        this.cmdDeliveryLineLot = cmdDeliveryLineLot;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinecolorid")
    public PrmColor getCmdDeliveryLineColor() {
        return cmdDeliveryLineColor;
    }

    public void setCmdDeliveryLineColor(PrmColor cmdDeliveryLineColor) {
        this.cmdDeliveryLineColor = cmdDeliveryLineColor;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_deliverylinedlc", length = 13)
    public Date getCmdDeliveryLineDlc() {
        return cmdDeliveryLineDlc;
    }

    public void setCmdDeliveryLineDlc(Date cmdDeliveryLineDlc) {
        this.cmdDeliveryLineDlc = cmdDeliveryLineDlc;
    }
    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_deliverylinedluo", length = 13)
    public Date getCmdDeliveryLineDluo() {
        return cmdDeliveryLineDluo;
    }

    public void setCmdDeliveryLineDluo(Date cmdDeliveryLineDluo) {
        this.cmdDeliveryLineDluo = cmdDeliveryLineDluo;
    }

    @Column(name = "cmd_deliverylinecomment", length = 255)
    public String getCmdDeliveryLineComment() {
        return cmdDeliveryLineComment;
    }

    public void setCmdDeliveryLineComment(String cmdDeliveryLineComment) {
        this.cmdDeliveryLineComment = cmdDeliveryLineComment;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinestatusid", nullable = false)
    public PrmOrderStatus getPrmOrderStatus() {
        return prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_deliverylinecreationdate")
    public Date getCmdDeliveryLineCreationDate() {
        return cmdDeliveryLineCreationDate;
    }

    public void setCmdDeliveryLineCreationDate(Date cmdDeliveryLineCreationDate) {
        this.cmdDeliveryLineCreationDate = cmdDeliveryLineCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_deliverylineupdatedate")
    public Date getCmdDeliveryLineUpdateDate() {
        return cmdDeliveryLineUpdateDate;
    }

    public void setCmdDeliveryLineUpdateDate(Date cmdDeliveryLineUpdateDate) {
        this.cmdDeliveryLineUpdateDate = cmdDeliveryLineUpdateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_deliverylinedeliveryid",nullable = false)
    public CmdDeliveryArc getCmdDelivery() {
        return cmdDelivery;
    }

    public void setCmdDelivery(CmdDeliveryArc cmdDelivery) {
        this.cmdDelivery = cmdDelivery;
    }

    @Column(name = "cmd_deliverylinequality",length = 50)

    public String getCmdDeliveryLineQuality() {
        return cmdDeliveryLineQuality;
    }

    public void setCmdDeliveryLineQuality(String cmdDeliveryLineQuality) {
        this.cmdDeliveryLineQuality = cmdDeliveryLineQuality;
    }
    @Column(name = "cmd_deliverylineweight",precision = 10,scale =0 )

    public BigDecimal getCmdDeliveryLineWeight() {
        return cmdDeliveryLineWeight;
    }

    public void setCmdDeliveryLineWeight(BigDecimal cmdDeliveryLineWeight) {
        this.cmdDeliveryLineWeight = cmdDeliveryLineWeight;
    }
    @JoinColumn(name = "cmd_deliverylinelocationid")
    @ManyToOne(fetch = FetchType.LAZY)
    public LocLocation getLocLocation() {
        return locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }
}
