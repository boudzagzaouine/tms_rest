package com.sinno.ems.entities;

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
 * RcpReceptionLine generated by hbm2java
 */
@Entity
@Table(name = "rcp_receptionline")
public class RcpReceptionLine implements java.io.Serializable {

    private long rcpReceptionLineId;
    private LocLocation locLocation;
    @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
    private PrmBlockType prmBlockType;
    private PrmColor prmColor;
    private PrmOrderStatus prmOrderStatus;
    private RcpPurshaseOrderLine rcpPurshaseOrderLine;
    @NotNull
    private RcpReception rcpReception;
    private WrhWarehouse wrhWarehouse;
    private PdtUom pdtUomReceived;


    @Max(999999999)
    @NotNull
    private Long rcpReceptionLineLineNumber;

    @Max(999999999)
    private Long rcpReceptionQuantityClosed;
    @Max(999999999)
    private Long rcpReceptionSuppOfLife;

    @Max(999999999)
    @NotNull
    private BigDecimal rcpReceptionLineQuantity;

    @Max(999999999)

    private BigDecimal rcpReceptionLineQuantityReceived;
    @Max(999999999)
    private BigDecimal rcpReceptionLineBlockedQuantity;
    @Size(max = 255)
    private String rcpReceptionLineDescription;
    @Size(max = 50)
    private String rcpReceptionLineContainerCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionLineDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionLineDluo;
    @Size(max = 50)
    private String rcpReceptionLineSerialNo;
    @Size(max = 50)
    private String rcpReceptionLineLot;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionLineReceptionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionLineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionLineUpdateDate;
    @Size(max = 255)
    private String rcpReceptionLineVariable1;
    @Size(max = 255)
    private String rcpReceptionLineVariable2;
    @Size(max = 255)
    private String rcpReceptionLineVariable3;
    @Size(max = 255)
    private String rcpReceptionLineVariable4;
    @Size(max = 255)
    private String rcpReceptionLineVariable5;
    @Size(max = 255)
    private String rcpReceptionLineVariable6;
    @Size(max = 255)
    private String rcpReceptionLineVariable7;
    @Size(max = 255)
    private String rcpReceptionLineVariable8;
    @Size(max = 255)
    private String rcpReceptionLineVariable9;
    @Size(max = 255)
    private String rcpReceptionLineVariable10;
    @Size(max=50)
    private String rcpReceptionLineQuality;
    @Max(999999999)
    private BigDecimal rcpReceptionLineWeight;
    @Size(max=255)
    private String rcpReceptionLineComment;

    private Set<RcpReceptionStock> rcpReceptionStocks = new HashSet<RcpReceptionStock>(
            0);

    private Set<RcpReceptionStockArc> rcpReceptionStockArcs = new HashSet<RcpReceptionStockArc>(
            0);
    @Max(999999999)
    private BigDecimal rcpReceptionLineTotalPriceHT;
    @Max(999999999)
    private BigDecimal rcpReceptionLineTotalPriceTTC;
    private PrmVat prmVat;
    @Max(999999999)
    private BigDecimal rcpReceptionLineDiscount;
    @Max(999999999)
    private BigDecimal rcpReceptionLinePurshasePrice;
    private PdtProductDimension pdtProductDimension;

    public RcpReceptionLine() {
    }

    public RcpReceptionLine(long rcpReceptionLineId, OwnOwner ownOwner,
                            PdtProduct pdtProduct, PdtUom pdtUom,
                            PrmOrderStatus prmOrderStatus,
                            RcpPurshaseOrderLine rcpPurshaseOrderLine,
                            RcpReception rcpReception, WrhWarehouse wrhWarehouse,
                            Long rcpReceptionLineLineNumber,
                            BigDecimal rcpReceptionLineQuantity,
                            BigDecimal rcpReceptionLineQuantityReceived) {
        this.rcpReceptionLineId = rcpReceptionLineId;
        this.ownOwner = ownOwner;
        this.pdtProduct = pdtProduct;
        this.pdtUom = pdtUom;
        this.prmOrderStatus = prmOrderStatus;
        this.rcpPurshaseOrderLine = rcpPurshaseOrderLine;
        this.rcpReception = rcpReception;
        this.wrhWarehouse = wrhWarehouse;
        this.rcpReceptionLineLineNumber = rcpReceptionLineLineNumber;
        this.rcpReceptionLineQuantity = rcpReceptionLineQuantity;
        this.rcpReceptionLineQuantityReceived = rcpReceptionLineQuantityReceived;
    }

    public RcpReceptionLine(long rcpReceptionLineId, LocLocation locLocation,
                            OwnOwner ownOwner, PdtProduct pdtProduct, PdtUom pdtUom,
                            PrmBlockType prmBlockType, PrmColor prmColor,
                            PrmOrderStatus prmOrderStatus,
                            RcpPurshaseOrderLine rcpPurshaseOrderLine,
                            RcpReception rcpReception, WrhWarehouse wrhWarehouse,
                            Long rcpReceptionLineLineNumber,
                            BigDecimal rcpReceptionLineQuantity,
                            BigDecimal rcpReceptionLineQuantityReceived,
                            String rcpReceptionLineDescription,
                            String rcpReceptionLineContainerCode, Date rcpReceptionLineDlc,
                            Date rcpReceptionLineDluo, String rcpReceptionLineSerialNo,
                            String rcpReceptionLineLot, Date rcpReceptionLineReceptionDate,
                            Date rcpReceptionLineCreationDate, Date rcpReceptionLineUpdateDate,
                            String rcpReceptionLineVariable1, String rcpReceptionLineVariable2,
                            String rcpReceptionLineVariable3, String rcpReceptionLineVariable4,
                            String rcpReceptionLineVariable5, String rcpReceptionLineVariable6,
                            String rcpReceptionLineVariable7, String rcpReceptionLineVariable8,
                            String rcpReceptionLineVariable9,
                            String rcpReceptionLineVariable10,
                            Set<RcpReceptionStock> rcpReceptionStocks,
                            Set<RcpReceptionStockArc> rcpReceptionStockArcs)
                             {
        this.rcpReceptionLineId = rcpReceptionLineId;
        this.locLocation = locLocation;
        this.ownOwner = ownOwner;
        this.pdtProduct = pdtProduct;
        this.pdtUom = pdtUom;
        this.prmBlockType = prmBlockType;
        this.prmColor = prmColor;
        this.prmOrderStatus = prmOrderStatus;
        this.rcpPurshaseOrderLine = rcpPurshaseOrderLine;
        this.rcpReception = rcpReception;
        this.wrhWarehouse = wrhWarehouse;
        this.rcpReceptionLineLineNumber = rcpReceptionLineLineNumber;
        this.rcpReceptionLineQuantity = rcpReceptionLineQuantity;
        this.rcpReceptionLineQuantityReceived = rcpReceptionLineQuantityReceived;
        this.rcpReceptionLineDescription = rcpReceptionLineDescription;
        this.rcpReceptionLineContainerCode = rcpReceptionLineContainerCode;
        this.rcpReceptionLineDlc = rcpReceptionLineDlc;
        this.rcpReceptionLineDluo = rcpReceptionLineDluo;
        this.rcpReceptionLineSerialNo = rcpReceptionLineSerialNo;
        this.rcpReceptionLineLot = rcpReceptionLineLot;
        this.rcpReceptionLineReceptionDate = rcpReceptionLineReceptionDate;
        this.rcpReceptionLineCreationDate = rcpReceptionLineCreationDate;
        this.rcpReceptionLineUpdateDate = rcpReceptionLineUpdateDate;
        this.rcpReceptionLineVariable1 = rcpReceptionLineVariable1;
        this.rcpReceptionLineVariable2 = rcpReceptionLineVariable2;
        this.rcpReceptionLineVariable3 = rcpReceptionLineVariable3;
        this.rcpReceptionLineVariable4 = rcpReceptionLineVariable4;
        this.rcpReceptionLineVariable5 = rcpReceptionLineVariable5;
        this.rcpReceptionLineVariable6 = rcpReceptionLineVariable6;
        this.rcpReceptionLineVariable7 = rcpReceptionLineVariable7;
        this.rcpReceptionLineVariable8 = rcpReceptionLineVariable8;
        this.rcpReceptionLineVariable9 = rcpReceptionLineVariable9;
        this.rcpReceptionLineVariable10 = rcpReceptionLineVariable10;
        this.rcpReceptionStocks = rcpReceptionStocks;
        this.rcpReceptionStockArcs = rcpReceptionStockArcs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_rcp_receptionline", allocationSize = 1)
    @Column(name = "rcp_receptionlineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getRcpReceptionLineId() {
        return this.rcpReceptionLineId;
    }

    public void setRcpReceptionLineId(long rcpReceptionLineId) {
        this.rcpReceptionLineId = rcpReceptionLineId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlinelocid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlineuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlineblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlinecolorid")
    public PrmColor getPrmColor() {
        return this.prmColor;
    }

    public void setPrmColor(PrmColor prmColor) {
        this.prmColor = prmColor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlinestatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return this.prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlinepolineid")
    public RcpPurshaseOrderLine getRcpPurshaseOrderLine() {
        return this.rcpPurshaseOrderLine;
    }

    public void setRcpPurshaseOrderLine(
            RcpPurshaseOrderLine rcpPurshaseOrderLine) {
        this.rcpPurshaseOrderLine = rcpPurshaseOrderLine;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlinereceptionid", nullable = false)
    public RcpReception getRcpReception() {
        return this.rcpReception;
    }

    public void setRcpReception(RcpReception rcpReception) {
        this.rcpReception = rcpReception;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlinewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "rcp_receptionlinelinenumber", nullable = false, precision = 10, scale = 0)
    public Long getRcpReceptionLineLineNumber() {
        return this.rcpReceptionLineLineNumber;
    }

    @Column(name = "rcp_receptionlinesuppoflife", precision = 12, scale = 0)
    public Long getRcpReceptionSuppOfLife() {
        return rcpReceptionSuppOfLife;
    }

    public void setRcpReceptionSuppOfLife(Long rcpReceptionSuppOfLife) {
        this.rcpReceptionSuppOfLife = rcpReceptionSuppOfLife;
    }

    @Column(name = "rcp_receptionlinequantityclosed", precision = 12, scale = 0)
    public Long getRcpReceptionQuantityClosed() {
        return rcpReceptionQuantityClosed;
    }

    public void setRcpReceptionQuantityClosed(Long rcpReceptionQuantityClosed) {
        this.rcpReceptionQuantityClosed = rcpReceptionQuantityClosed;
    }

    public void setRcpReceptionLineLineNumber(Long rcpReceptionLineLineNumber) {
        this.rcpReceptionLineLineNumber = rcpReceptionLineLineNumber;
    }

    @Column(name = "rcp_receptionlinequantity", nullable = false, precision = 12, scale = 5)
    public BigDecimal getRcpReceptionLineQuantity() {
        return this.rcpReceptionLineQuantity;
    }

    public void setRcpReceptionLineQuantity(BigDecimal rcpReceptionLineQuantity) {
        this.rcpReceptionLineQuantity = rcpReceptionLineQuantity;
    }

    @Column(name = "rcp_receptionlinequantityreceived", precision = 12, scale = 5)
    public BigDecimal getRcpReceptionLineQuantityReceived() {
        return this.rcpReceptionLineQuantityReceived;
    }

    public void setRcpReceptionLineQuantityReceived(
            BigDecimal rcpReceptionLineQuantityReceived) {
        this.rcpReceptionLineQuantityReceived = rcpReceptionLineQuantityReceived;
    }
    @Column(name = "rcp_receptionlineblockedquantity", nullable = false, precision = 12, scale = 5)

    public BigDecimal getRcpReceptionLineBlockedQuantity() {
        return rcpReceptionLineBlockedQuantity;
    }

    public void setRcpReceptionLineBlockedQuantity(BigDecimal rcpReceptionLineBlockedQuantity) {
        this.rcpReceptionLineBlockedQuantity = rcpReceptionLineBlockedQuantity;
    }

    @Column(name = "rcp_receptionlinedescription")
    public String getRcpReceptionLineDescription() {
        return this.rcpReceptionLineDescription;
    }

    public void setRcpReceptionLineDescription(
            String rcpReceptionLineDescription) {
        this.rcpReceptionLineDescription = rcpReceptionLineDescription;
    }

    @Column(name = "rcp_receptionlinecontainercode", length = 50)
    public String getRcpReceptionLineContainerCode() {
        return this.rcpReceptionLineContainerCode;
    }

    public void setRcpReceptionLineContainerCode(
            String rcpReceptionLineContainerCode) {
        this.rcpReceptionLineContainerCode = rcpReceptionLineContainerCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rcp_receptionlinedlc", length = 13)
    public Date getRcpReceptionLineDlc() {
        return this.rcpReceptionLineDlc;
    }

    public void setRcpReceptionLineDlc(Date rcpReceptionLineDlc) {
        this.rcpReceptionLineDlc = rcpReceptionLineDlc;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rcp_receptionlinedluo", length = 13)
    public Date getRcpReceptionLineDluo() {
        return this.rcpReceptionLineDluo;
    }

    public void setRcpReceptionLineDluo(Date rcpReceptionLineDluo) {
        this.rcpReceptionLineDluo = rcpReceptionLineDluo;
    }

    @Column(name = "rcp_receptionlineserialno", length = 50)
    public String getRcpReceptionLineSerialNo() {
        return this.rcpReceptionLineSerialNo;
    }

    public void setRcpReceptionLineSerialNo(String rcpReceptionLineSerialNo) {
        this.rcpReceptionLineSerialNo = rcpReceptionLineSerialNo;
    }

    @Column(name = "rcp_receptionlinelot", length = 50)
    public String getRcpReceptionLineLot() {
        return this.rcpReceptionLineLot;
    }

    public void setRcpReceptionLineLot(String rcpReceptionLineLot) {
        this.rcpReceptionLineLot = rcpReceptionLineLot;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionlinereceptiondate")
    public Date getRcpReceptionLineReceptionDate() {
        return this.rcpReceptionLineReceptionDate;
    }

    public void setRcpReceptionLineReceptionDate(
            Date rcpReceptionLineReceptionDate) {
        this.rcpReceptionLineReceptionDate = rcpReceptionLineReceptionDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionlinecreationdate")
    public Date getRcpReceptionLineCreationDate() {
        return this.rcpReceptionLineCreationDate;
    }

    public void setRcpReceptionLineCreationDate(
            Date rcpReceptionLineCreationDate) {
        this.rcpReceptionLineCreationDate = rcpReceptionLineCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionlineupdatedate")
    public Date getRcpReceptionLineUpdateDate() {
        return this.rcpReceptionLineUpdateDate;
    }

    public void setRcpReceptionLineUpdateDate(Date rcpReceptionLineUpdateDate) {
        this.rcpReceptionLineUpdateDate = rcpReceptionLineUpdateDate;
    }

    @Column(name = "rcp_receptionlinevariable1")
    public String getRcpReceptionLineVariable1() {
        return this.rcpReceptionLineVariable1;
    }

    public void setRcpReceptionLineVariable1(String rcpReceptionLineVariable1) {
        this.rcpReceptionLineVariable1 = rcpReceptionLineVariable1;
    }

    @Column(name = "rcp_receptionlinevariable2")
    public String getRcpReceptionLineVariable2() {
        return this.rcpReceptionLineVariable2;
    }

    public void setRcpReceptionLineVariable2(String rcpReceptionLineVariable2) {
        this.rcpReceptionLineVariable2 = rcpReceptionLineVariable2;
    }

    @Column(name = "rcp_receptionlinevariable3")
    public String getRcpReceptionLineVariable3() {
        return this.rcpReceptionLineVariable3;
    }

    public void setRcpReceptionLineVariable3(String rcpReceptionLineVariable3) {
        this.rcpReceptionLineVariable3 = rcpReceptionLineVariable3;
    }

    @Column(name = "rcp_receptionlinevariable4")
    public String getRcpReceptionLineVariable4() {
        return this.rcpReceptionLineVariable4;
    }

    public void setRcpReceptionLineVariable4(String rcpReceptionLineVariable4) {
        this.rcpReceptionLineVariable4 = rcpReceptionLineVariable4;
    }

    @Column(name = "rcp_receptionlinevariable5")
    public String getRcpReceptionLineVariable5() {
        return this.rcpReceptionLineVariable5;
    }

    public void setRcpReceptionLineVariable5(String rcpReceptionLineVariable5) {
        this.rcpReceptionLineVariable5 = rcpReceptionLineVariable5;
    }

    @Column(name = "rcp_receptionlinevariable6")
    public String getRcpReceptionLineVariable6() {
        return this.rcpReceptionLineVariable6;
    }

    public void setRcpReceptionLineVariable6(String rcpReceptionLineVariable6) {
        this.rcpReceptionLineVariable6 = rcpReceptionLineVariable6;
    }

    @Column(name = "rcp_receptionlinevariable7")
    public String getRcpReceptionLineVariable7() {
        return this.rcpReceptionLineVariable7;
    }

    public void setRcpReceptionLineVariable7(String rcpReceptionLineVariable7) {
        this.rcpReceptionLineVariable7 = rcpReceptionLineVariable7;
    }

    @Column(name = "rcp_receptionlinevariable8")
    public String getRcpReceptionLineVariable8() {
        return this.rcpReceptionLineVariable8;
    }

    public void setRcpReceptionLineVariable8(String rcpReceptionLineVariable8) {
        this.rcpReceptionLineVariable8 = rcpReceptionLineVariable8;
    }

    @Column(name = "rcp_receptionlinevariable9")
    public String getRcpReceptionLineVariable9() {
        return this.rcpReceptionLineVariable9;
    }

    public void setRcpReceptionLineVariable9(String rcpReceptionLineVariable9) {
        this.rcpReceptionLineVariable9 = rcpReceptionLineVariable9;
    }

    @Column(name = "rcp_receptionlinevariable10")
    public String getRcpReceptionLineVariable10() {
        return this.rcpReceptionLineVariable10;
    }

    public void setRcpReceptionLineVariable10(String rcpReceptionLineVariable10) {
        this.rcpReceptionLineVariable10 = rcpReceptionLineVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rcpReceptionLine")
    public Set<RcpReceptionStock> getRcpReceptionStocks() {
        return this.rcpReceptionStocks;
    }

    public void setRcpReceptionStocks(Set<RcpReceptionStock> rcpReceptionStocks) {
        this.rcpReceptionStocks = rcpReceptionStocks;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rcpReceptionLine")
    public Set<RcpReceptionStockArc> getRcpReceptionStockArcs() {
        return this.rcpReceptionStockArcs;
    }

    public void setRcpReceptionStockArcs(
            Set<RcpReceptionStockArc> rcpReceptionStockArcs) {
        this.rcpReceptionStockArcs = rcpReceptionStockArcs;
    }



    @Column(name = "rcp_receptionlinequality",length = 50)

    public String getRcpReceptionLineQuality() {
        return rcpReceptionLineQuality;
    }

    public void setRcpReceptionLineQuality(String rcpReceptionLineQuality) {
        this.rcpReceptionLineQuality = rcpReceptionLineQuality;
    }
    @Column(name = "rcp_receptionlineweight",precision = 10,scale =0 )

    public BigDecimal getRcpReceptionLineWeight() {
        return rcpReceptionLineWeight;
    }

    public void setRcpReceptionLineWeight(BigDecimal rcpReceptionLineWeight) {
        this.rcpReceptionLineWeight = rcpReceptionLineWeight;
    }
    @Column(name = "rcp_receptionlinecomment",length = 255)

    public String getRcpReceptionLineComment() {
        return rcpReceptionLineComment;
    }

    public void setRcpReceptionLineComment(String rcpReceptionLineComment) {
        this.rcpReceptionLineComment = rcpReceptionLineComment;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_receptionuomreceived")
    public PdtUom getPdtUomReceived() {
        return pdtUomReceived;
    }

    public void setPdtUomReceived(PdtUom pdtUomReceived) {
        this.pdtUomReceived = pdtUomReceived;
    }

    @Column(name = "rcp_receptionlinetotalpriceht")

    public BigDecimal getRcpReceptionLineTotalPriceHT() {
        return rcpReceptionLineTotalPriceHT;
    }

    public void setRcpReceptionLineTotalPriceHT(BigDecimal rcpReceptionLineTotalPriceHT) {
        this.rcpReceptionLineTotalPriceHT = rcpReceptionLineTotalPriceHT;
    }
    @Column(name = "rcp_receptionlinetotalpricettc")
    public BigDecimal getRcpReceptionLineTotalPriceTTC() {
        return rcpReceptionLineTotalPriceTTC;
    }

    public void setRcpReceptionLineTotalPriceTTC(BigDecimal rcpReceptionLineTotalPriceTTC) {
        this.rcpReceptionLineTotalPriceTTC = rcpReceptionLineTotalPriceTTC;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_receptionlinevatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "rcp_receptionlinediscount")
    public BigDecimal getRcpReceptionLineDiscount() {
        return rcpReceptionLineDiscount;
    }

    public void setRcpReceptionLineDiscount(BigDecimal rcpReceptionLineDiscount) {
        this.rcpReceptionLineDiscount = rcpReceptionLineDiscount;
    }
    @Column(name = "rcp_receptionlinepurshaseprice")
    public BigDecimal getRcpReceptionLinePurshasePrice() {
        return rcpReceptionLinePurshasePrice;
    }

    public void setRcpReceptionLinePurshasePrice(BigDecimal rcpReceptionLinePurshasePrice) {
        this.rcpReceptionLinePurshasePrice = rcpReceptionLinePurshasePrice;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionlineproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }
}

