package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 06/12/2016.
 */
@Entity
@Table(name = "cmd_devisline")
public class CmdDevisLine {
    private long cmdDevisLineId;
    @NotNull
    private CmdDevis cmdDevis;
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
    private long cmdDevisLineLineNumber;
    @NotNull

    @Max(999999999)
    private BigDecimal cmdDevisLineQuantity;
    @Max(999999999)
    private BigDecimal cmdDevisLineSalePrice;
    @Max(999999999)
    private BigDecimal cmdDevisLineDiscount;

    @Max(999999999)
    private BigDecimal cmdDevisLineQuantityServed;
    @Size(max = 255)
    private String cmdDevisLineDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdDevisLineDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdDevisLineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdDevisLineUpdateDate;

    @Size(max = 255)
    private String cmdDevisLineComment;
    private PrmVat prmVat;
    private BigDecimal cmdDevisLineTotalPriceHT;
    private BigDecimal cmdDevisLineTotalPriceTTC;
    private PdtProductDimension pdtProductDimension;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_devisline", allocationSize = 1)
    @Column(name = "cmd_devislineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdDevisLineId() {
        return this.cmdDevisLineId;
    }

    public void setCmdDevisLineId(long cmdDevisLineId) {
        this.cmdDevisLineId = cmdDevisLineId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devislinedevisid", nullable = false)
    public CmdDevis getCmdDevis() {
        return cmdDevis;
    }

    public void setCmdDevis(CmdDevis cmdDevis) {
        this.cmdDevis = cmdDevis;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devislineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devislineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devislineuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devislineblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devislinestatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return this.prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }



    @Column(name = "cmd_devislinelinenumber", nullable = false, precision = 10, scale = 0)
    public long getCmdDevisLineLineNumber() {
        return this.cmdDevisLineLineNumber;
    }

    public void setCmdDevisLineLineNumber(long cmdDevisLineLineNumber) {
        this.cmdDevisLineLineNumber = cmdDevisLineLineNumber;
    }

    @Column(name = "cmd_devislinequantity", nullable = false, precision = 12, scale = 5)
    public BigDecimal getCmdDevisLineQuantity() {
        return this.cmdDevisLineQuantity;
    }

    public void setCmdDevisLineQuantity(BigDecimal cmdDevisLineQuantity) {
        this.cmdDevisLineQuantity = cmdDevisLineQuantity;
    }


    @Column(name = "cmd_devislinedescription")
    public String getCmdDevisLineDescription() {
        return this.cmdDevisLineDescription;
    }

    public void setCmdDevisLineDescription(
            String cmdDevisLineDescription) {
        this.cmdDevisLineDescription = cmdDevisLineDescription;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_devislinecreationdate")
    public Date getCmdDevisLineCreationDate() {
        return this.cmdDevisLineCreationDate;
    }

    public void setCmdDevisLineCreationDate(
            Date cmdDevisLineCreationDate) {
        this.cmdDevisLineCreationDate = cmdDevisLineCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_devislineupdatedate")
    public Date getCmdDevisLineUpdateDate() {
        return this.cmdDevisLineUpdateDate;
    }

    public void setCmdDevisLineUpdateDate(Date cmdDevisLineUpdateDate) {
        this.cmdDevisLineUpdateDate = cmdDevisLineUpdateDate;
    }

    @Column(name = "cmd_devislinecomment")
    public String getCmdDevisLineComment() {
        return cmdDevisLineComment;
    }

    public void setCmdDevisLineComment(String cmdDevisLineComment) {
        this.cmdDevisLineComment = cmdDevisLineComment;
    }

    @Column(name = "cmd_devislinesaleprice", nullable = false, precision = 12, scale = 5)

    public BigDecimal getCmdDevisLineSalePrice() {
        return cmdDevisLineSalePrice;
    }

    public void setCmdDevisLineSalePrice(BigDecimal cmdDevisLineSalePrice) {
        this.cmdDevisLineSalePrice = cmdDevisLineSalePrice;
    }

    @Column(name = "cmd_devislinediscount", precision = 12, scale = 5)

    public BigDecimal getCmdDevisLineDiscount() {
        return cmdDevisLineDiscount;
    }

    public void setCmdDevisLineDiscount(BigDecimal cmdDevisLineDiscount) {
        this.cmdDevisLineDiscount = cmdDevisLineDiscount;
    }
    @Column(name="cmd_devislinepriceht")

    public BigDecimal getCmdDevisLineTotalPriceHT() {
        return cmdDevisLineTotalPriceHT;
    }

    public void setCmdDevisLineTotalPriceHT(BigDecimal cmdDevisLineTotalPriceHT) {
        this.cmdDevisLineTotalPriceHT = cmdDevisLineTotalPriceHT;
    }
    @Column(name="cmd_devislinepricettc")
    public BigDecimal getCmdDevisLineTotalPriceTTC() {
        return cmdDevisLineTotalPriceTTC;
    }

    public void setCmdDevisLineTotalPriceTTC(BigDecimal cmdDevisLineTotalPriceTTC) {
        this.cmdDevisLineTotalPriceTTC = cmdDevisLineTotalPriceTTC;
    }
    @JoinColumn(name="cmd_devislinevatid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

}
