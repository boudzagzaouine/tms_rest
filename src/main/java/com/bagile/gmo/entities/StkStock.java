package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * StkStock generated by hbm2java
 */
@Entity
@Table(name = "stk_stock")
public class StkStock extends EmsEntity implements java.io.Serializable {

    private long stkStockId;
   private LocLocation locLocation;
   // @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private PdtProduct pdtProduct;
    private PdtUom pdtUom;
   // private PrmBlockType prmBlockType;
   // private PrmColor prmColor;
    private RcpSupplier rcpSupplier;
    private StkContainer stkContainer;

    @Max(999999999)
    @NotNull
    private BigDecimal stkStockQuantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date stkStockDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date stkStockDluo;
    @Size(max = 255)
    private String stkStockSerialNo;
    @Size(max = 255)
    private String stkStockLot;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockReceptionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockUpdateDate;

    //TODO
    private Boolean stkStockKit;

    @Size(max = 255)
    private String stkStockVariable1;
    @Size(max = 255)
    private String stkStockVariable2;
    @Size(max = 255)
    private String stkStockVariable3;
    @Size(max = 255)
    private String stkStockVariable4;
    @Size(max = 255)
    private String stkStockVariable5;
    @Size(max = 255)
    private String stkStockVariable6;
    @Size(max = 255)
    private String stkStockVariable7;
    @Size(max = 255)
    private String stkStockVariable8;
    @Size(max = 255)
    private String stkStockVariable9;
    @Size(max = 255)
    private String stkStockVariable10;
    @Size(max = 50)
    private String stkStockQuality;
    @Max(999999999)
    private BigDecimal stkStockWeight;
  private RcpReceptionLine rcpReceptionLine;
  private RcpReceptionStock rcpReceptionStock;
    @Size(max = 255)
    private String stkStockComment;
   private WrhWarehouse wrhWarehouse;
    private PdtProductPack pdtProductPack;
    private Boolean stkStockAccountedSale;
    private Boolean stkStockAccountedPurchase;
    private BigDecimal stkStockQuantityBaseUom;
    private BigDecimal stkStockPurchasePrice;
    private BigDecimal stkStockSalePrice;
    private Boolean stkStockActive;
    private Boolean stkStockAppliedBruteToNet;


    public StkStock() {
    }

    @Column(name = "stk_stockkit")
    public Boolean getStkStockKit() {
        return stkStockKit;
    }
    public void setStkStockKit(Boolean stkStockKit) {
        this.stkStockKit = stkStockKit;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_stk_stock", allocationSize = 1)
    @Column(name = "stk_stockid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getStkStockId() {
        return this.stkStockId;
    }

    public void setStkStockId(long stkStockId) {
        this.stkStockId = stkStockId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stocklocationid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockuomid")
    public PdtUom getPdtUom() {
        return this.pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockblockid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockcolorid")
    public PrmColor getPrmColor() {
        return this.prmColor;
    }

    public void setPrmColor(PrmColor prmColor) {
        this.prmColor = prmColor;
    }*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stocksupplierid")
    public RcpSupplier getRcpSupplier() {
        return this.rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockcontainerid")
    public StkContainer getStkContainer() {
        return this.stkContainer;
    }

    public void setStkContainer(StkContainer stkContainer) {
        this.stkContainer = stkContainer;
    }

    @Column(name = "stk_stockquantity", nullable = false, precision = 17, scale = 5)
    public BigDecimal getStkStockQuantity() {
        return this.stkStockQuantity;
    }

    public void setStkStockQuantity(BigDecimal stkStockQuantity) {
        this.stkStockQuantity = stkStockQuantity;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "stk_stockdlc", length = 13)
    public Date getStkStockDlc() {
        return this.stkStockDlc;
    }

    public void setStkStockDlc(Date stkStockDlc) {
        this.stkStockDlc = stkStockDlc;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "stk_stockdluo", length = 13)
    public Date getStkStockDluo() {
        return this.stkStockDluo;
    }

    public void setStkStockDluo(Date stkStockDluo) {
        this.stkStockDluo = stkStockDluo;
    }

    @Column(name = "stk_stockserialno", length = 50)
    public String getStkStockSerialNo() {
        return this.stkStockSerialNo;
    }

    public void setStkStockSerialNo(String stkStockSerialNo) {
        this.stkStockSerialNo = stkStockSerialNo;
    }

    @Column(name = "stk_stocklot", length = 50)
    public String getStkStockLot() {
        return this.stkStockLot;
    }

    public void setStkStockLot(String stkStockLot) {
        this.stkStockLot = stkStockLot;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_stockreceptiondate")
    public Date getStkStockReceptionDate() {
        return this.stkStockReceptionDate;
    }

    public void setStkStockReceptionDate(Date stkStockReceptionDate) {
        this.stkStockReceptionDate = stkStockReceptionDate;
    }


    public void setStkStockUpdateDate(Date stkStockUpdateDate) {
        this.stkStockUpdateDate = stkStockUpdateDate;
    }

    @Column(name = "stk_stockvariable1")
    public String getStkStockVariable1() {
        return this.stkStockVariable1;
    }

    public void setStkStockVariable1(String stkStockVariable1) {
        this.stkStockVariable1 = stkStockVariable1;
    }

    @Column(name = "stk_stockvariable2")
    public String getStkStockVariable2() {
        return this.stkStockVariable2;
    }

    public void setStkStockVariable2(String stkStockVariable2) {
        this.stkStockVariable2 = stkStockVariable2;
    }

    @Column(name = "stk_stockvariable3")
    public String getStkStockVariable3() {
        return this.stkStockVariable3;
    }

    public void setStkStockVariable3(String stkStockVariable3) {
        this.stkStockVariable3 = stkStockVariable3;
    }

    @Column(name = "stk_stockvariable4")
    public String getStkStockVariable4() {
        return this.stkStockVariable4;
    }

    public void setStkStockVariable4(String stkStockVariable4) {
        this.stkStockVariable4 = stkStockVariable4;
    }

    @Column(name = "stk_stockvariable5")
    public String getStkStockVariable5() {
        return this.stkStockVariable5;
    }

    public void setStkStockVariable5(String stkStockVariable5) {
        this.stkStockVariable5 = stkStockVariable5;
    }

    @Column(name = "stk_stockvariable6")
    public String getStkStockVariable6() {
        return this.stkStockVariable6;
    }

    public void setStkStockVariable6(String stkStockVariable6) {
        this.stkStockVariable6 = stkStockVariable6;
    }

    @Column(name = "stk_stockvariable7")
    public String getStkStockVariable7() {
        return this.stkStockVariable7;
    }

    public void setStkStockVariable7(String stkStockVariable7) {
        this.stkStockVariable7 = stkStockVariable7;
    }

    @Column(name = "stk_stockvariable8")
    public String getStkStockVariable8() {
        return this.stkStockVariable8;
    }

    public void setStkStockVariable8(String stkStockVariable8) {
        this.stkStockVariable8 = stkStockVariable8;
    }

    @Column(name = "stk_stockvariable9")
    public String getStkStockVariable9() {
        return this.stkStockVariable9;
    }

    public void setStkStockVariable9(String stkStockVariable9) {
        this.stkStockVariable9 = stkStockVariable9;
    }

    @Column(name = "stk_stockvariable10")
    public String getStkStockVariable10() {
        return this.stkStockVariable10;
    }

    public void setStkStockVariable10(String stkStockVariable10) {
        this.stkStockVariable10 = stkStockVariable10;
    }

    @Column(name = "stk_stockquality", length = 50)

    public String getStkStockQuality() {
        return stkStockQuality;
    }

    public void setStkStockQuality(String stkStockQuality) {
        this.stkStockQuality = stkStockQuality;
    }

    @Column(name = "stk_stockweight", precision = 10, scale = 0)

    public BigDecimal getStkStockWeight() {
        return stkStockWeight;
    }

    public void setStkStockWeight(BigDecimal stkStockWeight) {
        this.stkStockWeight = stkStockWeight;
    }

 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockreceptionlineid")
    public RcpReceptionLine getRcpReceptionLine() {
        return rcpReceptionLine;
    }

    public void setRcpReceptionLine(RcpReceptionLine rcpReceptionLine) {
        this.rcpReceptionLine = rcpReceptionLine;
    }


  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockreceptionstockid")
    public RcpReceptionStock getRcpReceptionStock() {
        return rcpReceptionStock;
    }

    public void setRcpReceptionStock(RcpReceptionStock rcpReceptionStock) {
        this.rcpReceptionStock = rcpReceptionStock;
    }


    @Column(name = "stk_stockcomment", length = 255)


    public String getStkStockComment() {
        return stkStockComment;
    }

    public void setStkStockComment(String stkStockComment) {
        this.stkStockComment = stkStockComment;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }*/

  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockpackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }

    @Column(name = "stk_stockaccountedsale")
    public Boolean getStkStockAccountedSale() {
        return stkStockAccountedSale;
    }

    public void setStkStockAccountedSale(Boolean stkStockAccountedSale) {
        this.stkStockAccountedSale = stkStockAccountedSale;
    }

    @Column(name = "stk_stockaccountedpurchase")

    public Boolean getStkStockAccountedPurchase() {
        return stkStockAccountedPurchase;
    }

    public void setStkStockAccountedPurchase(Boolean stkStockAccountedPurchase) {
        this.stkStockAccountedPurchase = stkStockAccountedPurchase;
    }

    @Column(name = "stk_stockactive")
    public Boolean getStkStockActive() {
        return stkStockActive;
    }

    public void setStkStockActive(Boolean stkStockActive) {
        this.stkStockActive = stkStockActive;
    }

    @Column(name = "stk_stockquantitybaseuom")
    public BigDecimal getStkStockQuantityBaseUom() {
        return stkStockQuantityBaseUom;
    }

    public void setStkStockQuantityBaseUom(BigDecimal stkStockQuantityBaseUom) {
        this.stkStockQuantityBaseUom = stkStockQuantityBaseUom;
    }

    @Column(name = "stk_stockpurchaseprice")
    public BigDecimal getStkStockPurchasePrice() {
        return stkStockPurchasePrice;
    }

    public void setStkStockPurchasePrice(BigDecimal stkStockPurchasePrice) {
        this.stkStockPurchasePrice = stkStockPurchasePrice;
    }

    @Column(name = "stk_stocksaleprice")
    public BigDecimal getStkStockSalePrice() {
        return stkStockSalePrice;
    }

    public void setStkStockSalePrice(BigDecimal stkStockSalePrice) {
        this.stkStockSalePrice = stkStockSalePrice;
    }

    @Column(name = "stk_stockappliedbrutetonet")
    public Boolean getStkStockAppliedBruteToNet() {
        return stkStockAppliedBruteToNet;
    }

    public void setStkStockAppliedBruteToNet(Boolean stkStockAppliedBruteToNet) {
        this.stkStockAppliedBruteToNet = stkStockAppliedBruteToNet;
    }


}
