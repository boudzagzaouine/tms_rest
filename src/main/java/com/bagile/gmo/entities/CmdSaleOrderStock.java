package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * CmdSaleOrderstock generated by hbm2java
 */
@Entity
@Table(name = "cmd_saleorderstock")
public class CmdSaleOrderStock extends EmsEntity implements Serializable  {

    /**
     *
     */
    private static final long serialVersionUID = -2420807901768365828L;

    private Long cmdSaleOrderStockId;
    private CmdDelivery cmdDelivery;

    private CmdDeliveryLine cmdDeliveryLine;

   // private LocLocation locLocation;
    @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private PdtProduct pdtProduct;
   // private PrmBlockType prmBlockType;
    private StkContainer stkContainer;
    @NotNull
    private WrhWarehouse wrhWarehouse;
   // private PrmColor prmColor;

    @Max(999999999)
    private Long cmdSaleOrderStockLineNumber;


    @Max(999999999)
    private BigDecimal cmdSaleOrderStockQuantityServed;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderStockDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderStockDluo;
    @Size(max = 255)
    private String cmdSaleOrderStockSerialNo;
    @Size(max = 255)
    private String cmdSaleOrderStockLot;
    private PdtUom pdtUom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderStockOrderDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderStockCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdSaleOrderStockUpdateDate;
    @Size(max = 50)
    private String cmdSaleOrderStockQuality;
    @Max(999999999)
    private BigDecimal cmdSaleOrderStockWeight;
  //  private StkStock stkStock;
   // private PdtProductDimension pdtProductDimension;
    private PdtProductPack pdtProductPack;

    //private GmoTurn gmoTurn;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_saleorderstock", allocationSize = 1)
    @Column(name = "cmd_saleorderstockid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getCmdSaleOrderStockId() {
        return this.cmdSaleOrderStockId;
    }

    public void setCmdSaleOrderStockId(Long cmdSaleOrderStockId) {
        this.cmdSaleOrderStockId = cmdSaleOrderStockId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockdeliveryid", nullable = false)
    public CmdDelivery getCmdDelivery() {
        return this.cmdDelivery;
    }

    public void setCmdDelivery(CmdDelivery cmdDelivery) {
        this.cmdDelivery = cmdDelivery;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockdeliverylineid", nullable = false)
    public CmdDeliveryLine getCmdDeliveryLine() {
        return this.cmdDeliveryLine;
    }

    public void setCmdDeliveryLine(CmdDeliveryLine cmdSaleOrderLine) {
        this.cmdDeliveryLine = cmdSaleOrderLine;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstocklocid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }


   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockcontainerid")
    public StkContainer getStkContainer() {
        return this.stkContainer;
    }

    public void setStkContainer(StkContainer stkContainer) {
        this.stkContainer = stkContainer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockcolorid")
    public PrmColor getPrmColor() {
        return prmColor;
    }

    public void setPrmColor(PrmColor prmColor) {
        this.prmColor = prmColor;
    }
*/
    @Column(name = "cmd_saleorderstocklinenumber", nullable = false, precision = 10, scale = 0)
    public Long getCmdSaleOrderStockLineNumber() {
        return this.cmdSaleOrderStockLineNumber;
    }

    public void setCmdSaleOrderStockLineNumber(Long cmdSaleOrderStockLineNumber) {
        this.cmdSaleOrderStockLineNumber = cmdSaleOrderStockLineNumber;
    }

    @Column(name = "cmd_saleorderstockquantityserved", nullable = false, precision = 12, scale = 5)
    public BigDecimal getCmdSaleOrderStockQuantityServed() {
        return this.cmdSaleOrderStockQuantityServed;
    }

    public void setCmdSaleOrderStockQuantityServed(
            BigDecimal cmdSaleOrderStockQuantityServed) {
        this.cmdSaleOrderStockQuantityServed = cmdSaleOrderStockQuantityServed;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_saleorderstockdlc", length = 13)
    public Date getCmdSaleOrderStockDlc() {
        return this.cmdSaleOrderStockDlc;
    }

    public void setCmdSaleOrderStockDlc(Date cmdSaleOrderStockDlc) {
        this.cmdSaleOrderStockDlc = cmdSaleOrderStockDlc;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_saleorderstockdluo", length = 13)
    public Date getCmdSaleOrderStockDluo() {
        return this.cmdSaleOrderStockDluo;
    }

    public void setCmdSaleOrderStockDluo(Date cmdSaleOrderStockDluo) {
        this.cmdSaleOrderStockDluo = cmdSaleOrderStockDluo;
    }

    @Column(name = "cmd_saleorderstockserialno", length = 50)
    public String getCmdSaleOrderStockSerialNo() {
        return this.cmdSaleOrderStockSerialNo;
    }

    public void setCmdSaleOrderStockSerialNo(String cmdSaleOrderStockSerialNo) {
        this.cmdSaleOrderStockSerialNo = cmdSaleOrderStockSerialNo;
    }

    @Column(name = "cmd_saleorderstocklot", length = 50)
    public String getCmdSaleOrderStockLot() {
        return this.cmdSaleOrderStockLot;
    }

    public void setCmdSaleOrderStockLot(String cmdSaleOrderStockLot) {
        this.cmdSaleOrderStockLot = cmdSaleOrderStockLot;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockuomid", nullable = false)
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderstockorderdate")
    public Date getCmdSaleOrderStockOrderDate() {
        return this.cmdSaleOrderStockOrderDate;
    }

    public void setCmdSaleOrderStockOrderDate(Date cmdSaleOrderStockOrderDate) {
        this.cmdSaleOrderStockOrderDate = cmdSaleOrderStockOrderDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderstockcreationdate")
    public Date getCmdSaleOrderStockCreationDate() {
        return this.cmdSaleOrderStockCreationDate;
    }

    public void setCmdSaleOrderStockCreationDate(
            Date cmdSaleOrderStockCreationDate) {
        this.cmdSaleOrderStockCreationDate = cmdSaleOrderStockCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_saleorderstockupdatedate")
    public Date getCmdSaleOrderStockUpdateDate() {
        return this.cmdSaleOrderStockUpdateDate;
    }

    public void setCmdSaleOrderStockUpdateDate(Date cmdSaleOrderStockUpdateDate) {
        this.cmdSaleOrderStockUpdateDate = cmdSaleOrderStockUpdateDate;
    }

    @Column(name = "cmd_saleorderstockquality", length = 50)

    public String getCmdSaleOrderStockQuality() {
        return cmdSaleOrderStockQuality;
    }

    public void setCmdSaleOrderStockQuality(String cmdSaleOrderStockQuality) {
        this.cmdSaleOrderStockQuality = cmdSaleOrderStockQuality;
    }

    @Column(name = "cmd_saleorderstockweight", precision = 10, scale = 0)

    public BigDecimal getCmdSaleOrderStockWeight() {
        return cmdSaleOrderStockWeight;
    }

    public void setCmdSaleOrderStockWeight(BigDecimal cmdSaleOrderStockWeight) {
        this.cmdSaleOrderStockWeight = cmdSaleOrderStockWeight;
    }

    /*@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cmd_saleorderstockstockid")
    public StkStock getStkStock() {
        return stkStock;
    }

    public void setStkStock(StkStock stkStock) {
        this.stkStock = stkStock;
    }
    @ManyToOne
    @JoinColumn(name = "cmd_saleorderstockyproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_saleorderstockpackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }


   /* @ManyToOne()
    @JoinColumn(name = "cmd_saleorderstockturnid")
    public GmoTurn getGmoTurn() {
        return gmoTurn;
    }

    public void setGmoTurn(GmoTurn gmoTurn) {
        this.gmoTurn = gmoTurn;
    }*/
}

