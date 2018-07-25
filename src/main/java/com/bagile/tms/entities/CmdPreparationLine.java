package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

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


    private PdtUom pdtUom;
    private PdtProductPack pdtProductPack;


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
    @SequenceGenerator(name = "seq", sequenceName = "schema_emsgc.cmd_preparationline_cmd_preparationlineid_seq", allocationSize = 1)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationlineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationpackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }
}
