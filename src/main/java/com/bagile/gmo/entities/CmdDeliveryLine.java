package com.bagile.gmo.entities;

import com.bagile.gmo.dto.EmsDto;
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
@Table(name = "cmd_deliveryline")

public class CmdDeliveryLine extends EmsDto {
    private long cmdDeliveryLineId;
    @Max(999999999)
    private Long cmdDeliveryLinelineNumber;
    private CmdSaleOrderLine cmdSaleOrderLine;
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
    @NotNull
    private WrhWarehouse wrhWarehouse;


    private PrmOrderStatus prmOrderStatus;
    @Size(max = 255)
    private String cmdDeliveryLineSerialNo;
    @Size(max = 255)
    private String cmdDeliveryLineLot;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineDluo;
    private String cmdDeliveryLineComment;
    @NotNull
    private OwnOwner ownOwner;
    private CmdDelivery cmdDelivery;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineUpdateDate;
    private String cmdDeliveryLineQuality;
    @Max(999999999)
    private BigDecimal cmdDeliveryLineWeight;
    private String cmdDeliveryLineContainerCode;
    private BigDecimal cmdDeliveryLineSalePrice;
    private BigDecimal cmdDeliveryLineDiscount;
    private PrmVat prmVat;
    private BigDecimal cmdDeliveryLineTotalPriceHT;
    private BigDecimal cmdDeliveryLineTotalPriceTTC;
    private PdtProduct pdtMenu;
    private Long cmdDeliveryLineMenuNumber;
    private Long cmdDeliveryLineMenuQuantity;

    private PdtProductPack pdtProductPack;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_deliveryline", allocationSize = 1)
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
    @Column(name="cmddeliverylinelinenumber")
    public void setCmdDeliveryLinelineNumber(Long cmdDeliveryLinelineNumber) {
        this.cmdDeliveryLinelineNumber = cmdDeliveryLinelineNumber;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinesaleorderlineid", nullable = false)
    public CmdSaleOrderLine getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLine cmdSaleOrderLine) {
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
    public CmdDelivery getCmdDelivery() {
        return cmdDelivery;
    }

    public void setCmdDelivery(CmdDelivery cmdDelivery) {
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
    @Column(name = "cmd_deliverylinecontainercode")

    public String getCmdDeliveryLineContainerCode() {
        return cmdDeliveryLineContainerCode;
    }

    public void setCmdDeliveryLineContainerCode(String cmdDeliveryLineContainerCode) {
        this.cmdDeliveryLineContainerCode = cmdDeliveryLineContainerCode;
    }

    @Column(name = "cmd_deliverylinesaleprice")
    public BigDecimal getCmdDeliveryLineSalePrice() {
        return cmdDeliveryLineSalePrice;
    }

    public void setCmdDeliveryLineSalePrice(BigDecimal cmdDeliveryLineSalePrice) {
        this.cmdDeliveryLineSalePrice = cmdDeliveryLineSalePrice;
    }

    @Column(name = "cmd_deliverylinediscount")
    public BigDecimal getCmdDeliveryLineDiscount() {
        return cmdDeliveryLineDiscount;
    }

    public void setCmdDeliveryLineDiscount(BigDecimal cmdDeliveryLineDiscount) {
        this.cmdDeliveryLineDiscount = cmdDeliveryLineDiscount;
    }

    @Column(name = "cmd_deliverylinepriceht")

    public BigDecimal getCmdDeliveryLineTotalPriceHT() {
        return cmdDeliveryLineTotalPriceHT;
    }

    public void setCmdDeliveryLineTotalPriceHT(BigDecimal cmdDeliveryLineTotalPriceHT) {
        this.cmdDeliveryLineTotalPriceHT = cmdDeliveryLineTotalPriceHT;
    }

    @Column(name = "cmd_deliverylinepricettc")

    public BigDecimal getCmdDeliveryLineTotalPriceTTC() {
        return cmdDeliveryLineTotalPriceTTC;
    }

    public void setCmdDeliveryLineTotalPriceTTC(BigDecimal cmdDeliveryLineTotalPriceTTC) {
        this.cmdDeliveryLineTotalPriceTTC = cmdDeliveryLineTotalPriceTTC;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinevatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinemenuid")
    public PdtProduct getPdtMenu() {
        return pdtMenu;
    }

    public void setPdtMenu(PdtProduct pdtMenu) {
        this.pdtMenu = pdtMenu;
    }
    @Column(name = "cmd_deliverylinemenunumber")

    public Long getCmdDeliveryLineMenuNumber() {
        return cmdDeliveryLineMenuNumber;
    }

    public void setCmdDeliveryLineMenuNumber(Long cmdDeliveryLineMenuNumber) {
        this.cmdDeliveryLineMenuNumber = cmdDeliveryLineMenuNumber;
    }
    @Column(name = "cmd_deliverylinemenuquantity")

    public Long getCmdDeliveryLineMenuQuantity() {
        return cmdDeliveryLineMenuQuantity;
    }

    public void setCmdDeliveryLineMenuQuantity(Long cmdDeliveryLineMenuQuantity) {
        this.cmdDeliveryLineMenuQuantity = cmdDeliveryLineMenuQuantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinepackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }
}
