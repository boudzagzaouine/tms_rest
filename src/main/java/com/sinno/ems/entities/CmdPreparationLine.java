package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 03/12/2016.
 */
@Entity
@Table(name = "cmd_preparationline")
public class CmdPreparationLine {

    private long cmdPreparationLineId;
    @NotNull
    private Long cmdPreparationLineNumber;
    @NotNull
    private CmdPreparation cmdPreparation;
    @NotNull
    private CmdSaleOrderLine cmdSaleOrderLine;
    @NotNull
    private PdtProduct pdtProduct;
    private BigDecimal cmdPreparationLineQuantity;
    private BigDecimal cmdPreparationLineQuantityFound;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdPreparationLineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdPreparationLineUpdateDate;
    @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private WrhWarehouse wrhWarehouse;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdPreparationLineDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdPreparationLineDluo;
    @Size(max = 255)
    private String cmdPreparationLineSerialNo;
    @Size(max = 255)
    private String cmdPreparationLineLot;
    private String cmdPreparationLineQuality;
    @Max(999999999)
    private BigDecimal cmdPreparationLineWeight;
    private PrmColor prmColor;
    private PdtUom pdtUom;
    private PdtProductDimension pdtProductDimension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationlineownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationlinewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_ems.cmd_preparationline_cmd_preparationlineid_seq", allocationSize = 1)
    @Column(name = "cmd_preparationlineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdPreparationLineId() {
        return cmdPreparationLineId;
    }
    public void setCmdPreparationLineId(long cmdPreparationLineId) {
        this.cmdPreparationLineId = cmdPreparationLineId;
    }
    @Column(name="cmd_preparationlinenumber")

    public Long getCmdPreparationLineNumber() {
        return cmdPreparationLineNumber;
    }
    public void setCmdPreparationLineNumber(Long cmdPreparationLineNumber) {
        this.cmdPreparationLineNumber = cmdPreparationLineNumber;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_preparationlinepreparationid")

    public CmdPreparation getCmdPreparation() {
        return cmdPreparation;
    }

    public void setCmdPreparation(CmdPreparation cmdPreparation) {
        this.cmdPreparation = cmdPreparation;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_preparationlinesorderlineid")
    public CmdSaleOrderLine getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLine cmdPreparationLine) {
        this.cmdSaleOrderLine = cmdPreparationLine;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_preparationlineproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @Column(name="cmd_preparationlinequantity")
    public BigDecimal getCmdPreparationLineQuantity() {
        return cmdPreparationLineQuantity;
    }

    public void setCmdPreparationLineQuantity(BigDecimal cmdPreparationLineQuantity) {
        this.cmdPreparationLineQuantity = cmdPreparationLineQuantity;
    }
    @Column(name="cmd_preparationlinequantityfound")

    public BigDecimal getCmdPreparationLineQuantityFound() {
        return cmdPreparationLineQuantityFound;
    }

    public void setCmdPreparationLineQuantityFound(BigDecimal cmdPreparationLineQuantityFound) {
        this.cmdPreparationLineQuantityFound = cmdPreparationLineQuantityFound;
    }
    @Column(name="cmd_preparationlinecreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCmdPreparationLineCreationDate() {
        return cmdPreparationLineCreationDate;
    }

    public void setCmdPreparationLineCreationDate(Date cmdPreparationLineCreationDate) {
        this.cmdPreparationLineCreationDate = cmdPreparationLineCreationDate;
    }
    @Column(name="cmd_preparationlineupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCmdPreparationLineUpdateDate() {
        return cmdPreparationLineUpdateDate;
    }

    public void setCmdPreparationLineUpdateDate(Date cmdPreparationLineUpdateDate) {
        this.cmdPreparationLineUpdateDate = cmdPreparationLineUpdateDate;
    }

    @Column(name="cmd_preparationlinedlc")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCmdPreparationLineDlc() {
        return cmdPreparationLineDlc;
    }

    public void setCmdPreparationLineDlc(Date cmdPreparationLineDlc) {
        this.cmdPreparationLineDlc = cmdPreparationLineDlc;
    }
    @Column(name="cmd_preparationlineduo")

    public Date getCmdPreparationLineDluo() {
        return cmdPreparationLineDluo;
    }

    public void setCmdPreparationLineDluo(Date cmdPreparationLineDluo) {
        this.cmdPreparationLineDluo = cmdPreparationLineDluo;
    }
    @Column(name="cmd_preparationlineserialno")
    public String getCmdPreparationLineSerialNo() {
        return cmdPreparationLineSerialNo;
    }


    public void setCmdPreparationLineSerialNo(String cmdPreparationLineSerialNo) {
        this.cmdPreparationLineSerialNo = cmdPreparationLineSerialNo;
    }
    @Column(name="cmd_preparationlinelot")

    public String getCmdPreparationLineLot() {
        return cmdPreparationLineLot;
    }

    public void setCmdPreparationLineLot(String cmdPreparationLineLot) {
        this.cmdPreparationLineLot = cmdPreparationLineLot;
    }
    @Column(name="cmd_preparationlinequality")

    public String getCmdPreparationLineQuality() {
        return cmdPreparationLineQuality;
    }

    public void setCmdPreparationLineQuality(String cmdPreparationLineQuality) {
        this.cmdPreparationLineQuality = cmdPreparationLineQuality;
    }
    @Column(name="cmd_preparationlineweight")

    public BigDecimal getCmdPreparationLineWeight() {
        return cmdPreparationLineWeight;
    }

    public void setCmdPreparationLineWeight(BigDecimal cmdPreparationLineWeight) {
        this.cmdPreparationLineWeight = cmdPreparationLineWeight;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationlinecolorid")
    public PrmColor getPrmColor() {
        return prmColor;
    }

    public void setPrmColor(PrmColor prmColor) {
        this.prmColor = prmColor;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationlineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationlineyproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }

}
