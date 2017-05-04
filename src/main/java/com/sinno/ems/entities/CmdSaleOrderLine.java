package com.sinno.ems.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CmdSaleOrderLine generated by hbm2java
 */
@Entity
@Table(name = "cmd_saleorderline")
public class CmdSaleOrderLine implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -796228846507513413L;

    private long cmdSaleOrderLineId;
    @NotNull
    private CmdSaleOrder cmdSaleOrder;
    private LocLocation locLocation;
    @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
    private PrmBlockType prmBlockType;
    private PrmColor prmColor;
    private PrmOrderStatus prmOrderStatus;
    private TrpTransport trpTransport;
    private WrhWarehouse wrhWarehouse;
    @NotNull

    @Max(999999999)
    private long cmdSaleOrderLineLineNumber;
    @NotNull

    @Max(999999999)
    private BigDecimal cmdSaleOrderLineQuantity;

    @Max(999999999)
    private BigDecimal cmdSaleOrderLineQuantityServed;
    @Size(max = 255)
    private String cmdSaleOrderLineDescription;
    private StkContainer stkContainer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderLineDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderLineDluo;
    @Size(max = 255)
    private String cmdSaleOrderLineSerialNo;
    @Size(max = 255)
    private String cmdSaleOrderLineLot;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderLineDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderLineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderLineUpdateDate;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable1;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable2;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable3;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable4;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable5;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable6;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable7;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable8;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable9;
    @Size(max = 255)
    private String cmdSaleOrderLineVariable10;

    private Set<StkStockReserved> stkStockReserveds = new HashSet<StkStockReserved>(
            0);
    @Size(max = 255)
    private String cmdSaleOrderLineComment;
    private String cmdSaleOrderLineQuality;
    @Max(999999999)
    private BigDecimal cmdSaleOrderLineWeight;
    private String cmdSaleOrderLineContainerCode;
    private CmdDevisLine cmdDevisLine;
    private BigDecimal cmdSaleOrderLineSalePrice;
    private BigDecimal cmdSaleOrderLineDiscount;
    private PrmVat prmVat;
    private BigDecimal cmdSaleOrderLineTotalPriceHT;
    private BigDecimal cmdSaleOrderLineTotalPriceTTC;
    private Set<CmdSaleOrderLine> cmdSaleOrderCommentLines;
    private CmdSaleOrderLine cmdSaleOrderLine;
    private PdtProductDimension pdtProductDimension;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_saleorderline", allocationSize = 1)
    @Column(name = "cmd_saleorderlineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdSaleOrderLineId() {
        return this.cmdSaleOrderLineId;
    }

    public void setCmdSaleOrderLineId(long cmdSaleOrderLineId) {
        this.cmdSaleOrderLineId = cmdSaleOrderLineId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlineorderid", nullable = false)
    public CmdSaleOrder getCmdSaleOrder() {
        return this.cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinelocationid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlineuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlineblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinecolorid")
    public PrmColor getPrmColor() {
        return this.prmColor;
    }

    public void setPrmColor(PrmColor prmColor) {
        this.prmColor = prmColor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinestatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return this.prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinetransportid")
    public TrpTransport getTrpTransport() {
        return this.trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "cmd_saleorderlinelinenumber", nullable = false, precision = 10, scale = 0)
    public long getCmdSaleOrderLineLineNumber() {
        return this.cmdSaleOrderLineLineNumber;
    }

    public void setCmdSaleOrderLineLineNumber(long cmdSaleOrderLineLineNumber) {
        this.cmdSaleOrderLineLineNumber = cmdSaleOrderLineLineNumber;
    }

    @Column(name = "cmd_saleorderlinequantity", nullable = false, precision = 12, scale = 5)
    public BigDecimal getCmdSaleOrderLineQuantity() {
        return this.cmdSaleOrderLineQuantity;
    }

    public void setCmdSaleOrderLineQuantity(BigDecimal cmdSaleOrderLineQuantity) {
        this.cmdSaleOrderLineQuantity = cmdSaleOrderLineQuantity;
    }

    @Column(name = "cmd_saleorderlinequantityserved", precision = 12, scale = 5)
    public BigDecimal getCmdSaleOrderLineQuantityServed() {
        return this.cmdSaleOrderLineQuantityServed;
    }

    public void setCmdSaleOrderLineQuantityServed(
            BigDecimal cmdSaleOrderLineQuantityServed) {
        this.cmdSaleOrderLineQuantityServed = cmdSaleOrderLineQuantityServed;
    }

    @Column(name = "cmd_saleorderlinedescription")
    public String getCmdSaleOrderLineDescription() {
        return this.cmdSaleOrderLineDescription;
    }

    public void setCmdSaleOrderLineDescription(
            String cmdSaleOrderLineDescription) {
        this.cmdSaleOrderLineDescription = cmdSaleOrderLineDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinecontainerid")
    public StkContainer getStkContainer() {
        return stkContainer;
    }

    public void setStkContainer(StkContainer stkContainer) {
        this.stkContainer = stkContainer;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_saleorderlinedlc", length = 13)
    public Date getCmdSaleOrderLineDlc() {
        return this.cmdSaleOrderLineDlc;
    }

    public void setCmdSaleOrderLineDlc(Date cmdSaleOrderLineDlc) {
        this.cmdSaleOrderLineDlc = cmdSaleOrderLineDlc;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_saleorderlinedluo", length = 13)
    public Date getCmdSaleOrderLineDluo() {
        return this.cmdSaleOrderLineDluo;
    }

    public void setCmdSaleOrderLineDluo(Date cmdSaleOrderLineDluo) {
        this.cmdSaleOrderLineDluo = cmdSaleOrderLineDluo;
    }

    @Column(name = "cmd_saleorderlineserialno", length = 50)
    public String getCmdSaleOrderLineSerialNo() {
        return this.cmdSaleOrderLineSerialNo;
    }

    public void setCmdSaleOrderLineSerialNo(String cmdSaleOrderLineSerialNo) {
        this.cmdSaleOrderLineSerialNo = cmdSaleOrderLineSerialNo;
    }

    @Column(name = "cmd_saleorderlinelot", length = 50)
    public String getCmdSaleOrderLineLot() {
        return this.cmdSaleOrderLineLot;
    }

    public void setCmdSaleOrderLineLot(String cmdSaleOrderLineLot) {
        this.cmdSaleOrderLineLot = cmdSaleOrderLineLot;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderlinedate")
    public Date getCmdSaleOrderLineDate() {
        return this.cmdSaleOrderLineDate;
    }

    public void setCmdSaleOrderLineDate(Date cmdSaleOrderLineDate) {
        this.cmdSaleOrderLineDate = cmdSaleOrderLineDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderlinecreationdate")
    public Date getCmdSaleOrderLineCreationDate() {
        return this.cmdSaleOrderLineCreationDate;
    }

    public void setCmdSaleOrderLineCreationDate(
            Date cmdSaleOrderLineCreationDate) {
        this.cmdSaleOrderLineCreationDate = cmdSaleOrderLineCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderlineupdatedate")
    public Date getCmdSaleOrderLineUpdateDate() {
        return this.cmdSaleOrderLineUpdateDate;
    }

    public void setCmdSaleOrderLineUpdateDate(Date cmdSaleOrderLineUpdateDate) {
        this.cmdSaleOrderLineUpdateDate = cmdSaleOrderLineUpdateDate;
    }

    @Column(name = "cmd_saleorderlinevariable1")
    public String getCmdSaleOrderLineVariable1() {
        return this.cmdSaleOrderLineVariable1;
    }

    public void setCmdSaleOrderLineVariable1(String cmdSaleOrderLineVariable1) {
        this.cmdSaleOrderLineVariable1 = cmdSaleOrderLineVariable1;
    }

    @Column(name = "cmd_saleorderlinevariable2")
    public String getCmdSaleOrderLineVariable2() {
        return this.cmdSaleOrderLineVariable2;
    }

    public void setCmdSaleOrderLineVariable2(String cmdSaleOrderLineVariable2) {
        this.cmdSaleOrderLineVariable2 = cmdSaleOrderLineVariable2;
    }

    @Column(name = "cmd_saleorderlinevariable3")
    public String getCmdSaleOrderLineVariable3() {
        return this.cmdSaleOrderLineVariable3;
    }

    public void setCmdSaleOrderLineVariable3(String cmdSaleOrderLineVariable3) {
        this.cmdSaleOrderLineVariable3 = cmdSaleOrderLineVariable3;
    }

    @Column(name = "cmd_saleorderlinevariable4")
    public String getCmdSaleOrderLineVariable4() {
        return this.cmdSaleOrderLineVariable4;
    }

    public void setCmdSaleOrderLineVariable4(String cmdSaleOrderLineVariable4) {
        this.cmdSaleOrderLineVariable4 = cmdSaleOrderLineVariable4;
    }

    @Column(name = "cmd_saleorderlinevariable5")
    public String getCmdSaleOrderLineVariable5() {
        return this.cmdSaleOrderLineVariable5;
    }

    public void setCmdSaleOrderLineVariable5(String cmdSaleOrderLineVariable5) {
        this.cmdSaleOrderLineVariable5 = cmdSaleOrderLineVariable5;
    }

    @Column(name = "cmd_saleorderlinevariable6")
    public String getCmdSaleOrderLineVariable6() {
        return this.cmdSaleOrderLineVariable6;
    }

    public void setCmdSaleOrderLineVariable6(String cmdSaleOrderLineVariable6) {
        this.cmdSaleOrderLineVariable6 = cmdSaleOrderLineVariable6;
    }

    @Column(name = "cmd_saleorderlinevariable7")
    public String getCmdSaleOrderLineVariable7() {
        return this.cmdSaleOrderLineVariable7;
    }

    public void setCmdSaleOrderLineVariable7(String cmdSaleOrderLineVariable7) {
        this.cmdSaleOrderLineVariable7 = cmdSaleOrderLineVariable7;
    }

    @Column(name = "cmd_saleorderlinevariable8")
    public String getCmdSaleOrderLineVariable8() {
        return this.cmdSaleOrderLineVariable8;
    }

    public void setCmdSaleOrderLineVariable8(String cmdSaleOrderLineVariable8) {
        this.cmdSaleOrderLineVariable8 = cmdSaleOrderLineVariable8;
    }

    @Column(name = "cmd_saleorderlinevariable9")
    public String getCmdSaleOrderLineVariable9() {
        return this.cmdSaleOrderLineVariable9;
    }

    public void setCmdSaleOrderLineVariable9(String cmdSaleOrderLineVariable9) {
        this.cmdSaleOrderLineVariable9 = cmdSaleOrderLineVariable9;
    }

    @Column(name = "cmd_saleorderlinevariable10")
    public String getCmdSaleOrderLineVariable10() {
        return this.cmdSaleOrderLineVariable10;
    }

    public void setCmdSaleOrderLineVariable10(String cmdSaleOrderLineVariable10) {
        this.cmdSaleOrderLineVariable10 = cmdSaleOrderLineVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmdSaleOrderLine")
    public Set<StkStockReserved> getStkStockReserveds() {
        return this.stkStockReserveds;
    }

    public void setStkStockReserveds(Set<StkStockReserved> stkStockReserveds) {
        this.stkStockReserveds = stkStockReserveds;
    }

    @Column(name = "cmd_saleorderlinecomment")

    public String getCmdSaleOrderLineComment() {
        return cmdSaleOrderLineComment;
    }

    public void setCmdSaleOrderLineComment(String cmdSaleOrderLineComment) {
        this.cmdSaleOrderLineComment = cmdSaleOrderLineComment;
    }

    @Column(name = "cmd_saleorderlinequality", length = 50)

    public String getCmdSaleOrderLineQuality() {
        return cmdSaleOrderLineQuality;
    }

    public void setCmdSaleOrderLineQuality(String cmdSaleOrderLineQuality) {
        this.cmdSaleOrderLineQuality = cmdSaleOrderLineQuality;
    }

    @Column(name = "cmd_saleorderlineweight", precision = 10, scale = 0)

    public BigDecimal getCmdSaleOrderLineWeight() {
        return cmdSaleOrderLineWeight;
    }

    public void setCmdSaleOrderLineWeight(BigDecimal cmdSaleOrderLineWeight) {
        this.cmdSaleOrderLineWeight = cmdSaleOrderLineWeight;
    }

    @Column(name = "cmd_saleorderlinecontainercode")
    public String getCmdSaleOrderLineContainerCode() {
        return cmdSaleOrderLineContainerCode;
    }

    public void setCmdSaleOrderLineContainerCode(String cmdSaleOrderLineContainerCode) {
        this.cmdSaleOrderLineContainerCode = cmdSaleOrderLineContainerCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinedevislineid")
    public CmdDevisLine getCmdDevisLine() {
        return cmdDevisLine;
    }

    public void setCmdDevisLine(CmdDevisLine cmdDevisLine) {
        this.cmdDevisLine = cmdDevisLine;
    }

    @Column(name = "cmd_saleorderlinesaleprice")
    public BigDecimal getCmdSaleOrderLineSalePrice() {
        return cmdSaleOrderLineSalePrice;
    }

    public void setCmdSaleOrderLineSalePrice(BigDecimal cmdSaleOrderLineSalePrice) {
        this.cmdSaleOrderLineSalePrice = cmdSaleOrderLineSalePrice;
    }

    @Column(name = "cmd_saleorderlinediscount")
    public BigDecimal getCmdSaleOrderLineDiscount() {
        return cmdSaleOrderLineDiscount;
    }

    public void setCmdSaleOrderLineDiscount(BigDecimal cmdSaleOrderLineDiscount) {
        this.cmdSaleOrderLineDiscount = cmdSaleOrderLineDiscount;
    }

    @Column(name = "cmd_saleorderlinepriceht")

    public BigDecimal getCmdSaleOrderLineTotalPriceHT() {
        return cmdSaleOrderLineTotalPriceHT;
    }

    public void setCmdSaleOrderLineTotalPriceHT(BigDecimal cmdSaleOrderLineTotalPriceHT) {
        this.cmdSaleOrderLineTotalPriceHT = cmdSaleOrderLineTotalPriceHT;
    }

    @Column(name = "cmd_saleorderlinepricettc")

    public BigDecimal getCmdSaleOrderLineTotalPriceTTC() {
        return cmdSaleOrderLineTotalPriceTTC;
    }

    public void setCmdSaleOrderLineTotalPriceTTC(BigDecimal cmdSaleOrderLineTotalPriceTTC) {
        this.cmdSaleOrderLineTotalPriceTTC = cmdSaleOrderLineTotalPriceTTC;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinevatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cmdSaleOrderLine")

    public Set<CmdSaleOrderLine> getCmdSaleOrderCommentLines() {
        return cmdSaleOrderCommentLines;
    }

    public void setCmdSaleOrderCommentLines(Set<CmdSaleOrderLine> cmdSaleOrderCommentLines) {
        this.cmdSaleOrderCommentLines = cmdSaleOrderCommentLines;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderlinesaleorderlineid")
    public CmdSaleOrderLine getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLine cmdSaleOrderLine) {
        this.cmdSaleOrderLine = cmdSaleOrderLine;
    }
    @ManyToOne
    @JoinColumn(name = "cmd_saleorderlineyproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }
}
