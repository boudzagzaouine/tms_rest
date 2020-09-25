package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PdtProduct generated by hbm2java
 */
@Entity
@Subselect("select * from schema_emsgc.pdt_productview")
@Immutable
public class PdtProductView extends EmsEntity implements java.io.Serializable {

    private long pdtProductId;
    private LocLocation locLocation;
    @NotNull
    private OwnOwner ownOwner;
    private PdtProductView pdtProductParent;
    private PdtProductType pdtProductTypeByPdtProductTypeId;
    private PdtProductType pdtProductTypeByPdtProductSubTypeId;
    private PdtUom pdtUomByPdtProductUomSaleId;
    private PdtUom pdtUomByPdtProductUomBaseId;
    private PdtUom pdtUomByPdtProductUomPurshaseId;
    private PrmBlockType prmBlockType;
   // private Set<PrmImage> prmImages;
    private RcpSupplier rcpSupplier;
    private WrhWarehouse wrhWarehouse;
    @NotNull
    private PrmVat prmVat;

    @Size(max = 30)
    @NotNull
    private String pdtProductCode;
    @Size(max = 1)
    @NotNull
    private String pdtProductMaterialABCCode;
    private Boolean pdtProductDlcControl;
    private Boolean pdtProductDluoControl;
    private Boolean pdtProductSerialNoControl;
    private Boolean pdtProductLotControl;
    private Boolean pdtProductColorControl;
    private Boolean pdtProductControlWeight;

    private BigDecimal pdtProductCoefficient;
    private BigDecimal pdtProductProductionCost;

    @Max(999999999)
    private BigDecimal pdtProductSalePriceUB;
    @Max(999999999)
    private BigDecimal pdtProductPurshasePriceUB;
    //TODO Value 1 to LIFO, 2 to FIFO, 3 to CUMB, 4 to NIFO
    @Max(999999999)
    private Long pdtProductRaisonToOut;
    @Size(max = 255)
    private String pdtProductDesc;
    @Size(max = 80)
    private String pdtProductShortDesc;
    private Integer pdtProductDaysOfLife;
    private Byte pdtProductContainerStack;
    @Size(max = 80)
    private String pdtProductPickMessage;
    @Size(max = 80)
    private String pdtProductManipulationDesc;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductMinTemp;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductMaxTemp;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductMaxStock;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductMinStock;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductManipulationPrice;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductPickingPrice;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductExpeditionPrice;

    @DecimalMax("999999999.0000")
    private BigDecimal pdtProductConditionningPrice;

    @Max(999999999)
    private Long pdtProductPaletConditionning;
    @NotNull
    private Boolean pdtProductIsActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtProductCreationDate;

    private Boolean pdtProductIsKit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtProductUpdateDate;

    @Size(max = 255)
    private String pdtProductVariable1;
    @Size(max = 255)
    private String pdtProductVariable2;
    @Size(max = 255)
    private String pdtProductVariable3;
    @Size(max = 255)
    private String pdtProductVariable4;
    @Size(max = 255)
    private String pdtProductVariable5;
    @Size(max = 255)
    private String pdtProductVariable6;
    @Size(max = 255)
    private String pdtProductVariable7;
    @Size(max = 255)
    private String pdtProductVariable8;
    @Size(max = 255)
    private String pdtProductVariable9;
    @Size(max = 255)
    private String pdtProductVariable10;
    private Boolean pdtProductQualityOfControl;
    private LocLocation pickingLocLocation;
    private PdtUom pickingPdtUom;
    private BigDecimal pdtMinimalThreshold;
    private BigDecimal pdtCapacity;
    private Boolean pdtIsReception;
   // private PdtAlias pdtAlias;
    private PdtProductPack pdtProductPack;
    private Boolean pdtProductReqExp;
    private Boolean pdtProductReqRec;
    private Boolean pdtProductWarrantyManagement;
    private BigDecimal pdtProductDiscount;
   // private PrmWarrantyPeriod prmWarrantyPeriod;
   // private PrmCurrency prmCurrencySale;
   // private PrmCurrency prmCurrencyPurshase;
    private Boolean pdtProductStockManaged;
   // private PdtProductForm pdtProductForm;
    private Boolean pdtProductDimension;
   // private PdtProcess pdtProcess;
    @NotNull
    private Boolean pdtProductStocked;
    private Boolean pdtProductOutOfStock;
    private Integer pdtProductSupplierDelay;
    private BigDecimal pdtProductMarginOfPurchase;
    private BigDecimal pdtProductProMarginOfPurchase;
    private BigDecimal pdtProductMarginOfCostsOfReturn;
    private BigDecimal pdtProductCostsOfReturn;
   // private Set<PdtAlias> pdtAliases = new HashSet<PdtAlias>(0);
    private Set<PdtProductPack> pdtProductPacks = new HashSet<PdtProductPack>(0);
    private Date pdtProductLastInventoryDate;
  //  private Set<PdtProductDimension> pdtProductDimensions = new HashSet<PdtProductDimension>(0);
    private Long pdtProductVersion;
    private Boolean pdtProductForBuying;
    private String pdtProductTechnicalSheet;
    private BigDecimal pdtProductStockedQuantity;
    private BigDecimal pdtProductBlockedQuantity;
    private BigDecimal pdtProductReservedQuantity;
    private BigDecimal pdtProductQuantityToReceive;
    private BigDecimal pdtProductOrderedQuantity;
    private Boolean pdtProductCharge;
    private Boolean pdtProductPackaging;
    private BigDecimal pdtProductAveragePurchaseCost;
   // private PdtProductCategory pdtProductCategory;
    private BigDecimal pdtProductProfessionalSalePrice;
    private Boolean pdtProductVariableWeight;
    private PrmVat prmVatPurchase;
    private BigDecimal pdtProductCustomsPercentage;
    private BigDecimal pdtProductTTCSalePriceUB;
    private BigDecimal pdtProductTTCPurshasePriceUB;
    private BigDecimal pdtProductProfessionalTTCSalePrice;


    @Id
    @Column(name = "pdt_productid")
    public long getPdtProductId() {
        return this.pdtProductId;
    }

    public void setPdtProductId(long pdtProductId) {
        this.pdtProductId = pdtProductId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productlocationid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productaliasid")
    public PdtAlias getPdtAlias() {
        return pdtAlias;
    }

    public void setPdtAlias(PdtAlias pdtAlias) {
        this.pdtAlias = pdtAlias;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productaltproductid")
    public PdtProductView getPdtProductParent() {
        return this.pdtProductParent;
    }

    public void setPdtProductParent(PdtProductView pdtProductParent) {
        this.pdtProductParent = pdtProductParent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_producttypeid")
    public PdtProductType getPdtProductTypeByPdtProductTypeId() {
        return this.pdtProductTypeByPdtProductTypeId;
    }

    public void setPdtProductTypeByPdtProductTypeId(
            PdtProductType pdtProductTypeByPdtProductTypeId) {
        this.pdtProductTypeByPdtProductTypeId = pdtProductTypeByPdtProductTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productsubtypeid")
    public PdtProductType getPdtProductTypeByPdtProductSubTypeId() {
        return this.pdtProductTypeByPdtProductSubTypeId;
    }

    public void setPdtProductTypeByPdtProductSubTypeId(
            PdtProductType pdtProductTypeByPdtProductSubTypeId) {
        this.pdtProductTypeByPdtProductSubTypeId = pdtProductTypeByPdtProductSubTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productuomsaleid")
    public PdtUom getPdtUomByPdtProductUomSaleId() {
        return this.pdtUomByPdtProductUomSaleId;
    }

    public void setPdtUomByPdtProductUomSaleId(
            PdtUom pdtUomByPdtProductUomSaleId) {
        this.pdtUomByPdtProductUomSaleId = pdtUomByPdtProductUomSaleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productuombaseid")
    public PdtUom getPdtUomByPdtProductUomBaseId() {
        return this.pdtUomByPdtProductUomBaseId;
    }

    public void setPdtUomByPdtProductUomBaseId(
            PdtUom pdtUomByPdtProductUomBaseId) {
        this.pdtUomByPdtProductUomBaseId = pdtUomByPdtProductUomBaseId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productuompurshaseid")
    public PdtUom getPdtUomByPdtProductUomPurshaseId() {
        return this.pdtUomByPdtProductUomPurshaseId;
    }

    public void setPdtUomByPdtProductUomPurshaseId(
            PdtUom pdtUomByPdtProductUomPurshaseId) {
        this.pdtUomByPdtProductUomPurshaseId = pdtUomByPdtProductUomPurshaseId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productdefaultblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }

  /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PrmImage> getPrmImages() {
        return prmImages;
    }

    public void setPrmImages(Set<PrmImage> prmImages) {
        this.prmImages = prmImages;
    }*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productdefaultsupplierid")
    public RcpSupplier getRcpSupplier() {
        return this.rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "pdt_productraisontoout", precision = 12, scale = 0)
    public Long getPdtProductRaisonToOut() {
        return pdtProductRaisonToOut;
    }

    public void setPdtProductRaisonToOut(Long pdtProductRaisonToOut) {
        this.pdtProductRaisonToOut = pdtProductRaisonToOut;
    }

    @Column(name = "pdt_productcode", unique = true, nullable = false, length = 30)
    public String getPdtProductCode() {
        return this.pdtProductCode;
    }

    public void setPdtProductCode(String pdtProductCode) {
        this.pdtProductCode = pdtProductCode;
    }

    @Column(name = "pdt_productpriceub")
    public BigDecimal getPdtProductSalePriceUB() {
        return pdtProductSalePriceUB;
    }

    public void setPdtProductSalePriceUB(BigDecimal pdtProductSalePriceUB) {
        this.pdtProductSalePriceUB = pdtProductSalePriceUB;
    }

    @Column(name = "pdt_productmaterialabccode", nullable = false, precision = 1, scale = 0)
    public String getPdtProductMaterialABCCode() {
        return this.pdtProductMaterialABCCode;
    }

    public void setPdtProductMaterialABCCode(String pdtProductMaterialABCCode) {
        this.pdtProductMaterialABCCode = pdtProductMaterialABCCode;
    }

    @Column(name = "pdt_productdlccontrol")
    public Boolean getPdtProductDlcControl() {
        return this.pdtProductDlcControl;
    }

    public void setPdtProductDlcControl(Boolean pdtProductDlcControl) {
        this.pdtProductDlcControl = pdtProductDlcControl;
    }

    @Column(name = "pdt_productdluocontrol")
    public Boolean getPdtProductDluoControl() {
        return this.pdtProductDluoControl;
    }

    public void setPdtProductDluoControl(Boolean pdtProductDluoControl) {
        this.pdtProductDluoControl = pdtProductDluoControl;
    }

    @Column(name = "pdt_productserialnocontrol")
    public Boolean getPdtProductSerialNoControl() {
        return this.pdtProductSerialNoControl;
    }

    public void setPdtProductSerialNoControl(Boolean pdtProductSerialNoControl) {
        this.pdtProductSerialNoControl = pdtProductSerialNoControl;
    }

    @Column(name = "pdt_productlotcontrol")
    public Boolean getPdtProductLotControl() {
        return this.pdtProductLotControl;
    }

    public void setPdtProductLotControl(Boolean pdtProductLotControl) {
        this.pdtProductLotControl = pdtProductLotControl;
    }

    @Column(name = "pdt_productcolorcontrol")
    public Boolean getPdtProductColorControl() {
        return this.pdtProductColorControl;
    }

    public void setPdtProductColorControl(Boolean pdtProductColorControl) {
        this.pdtProductColorControl = pdtProductColorControl;
    }

    @Column(name = "pdt_productdesc")
    public String getPdtProductDesc() {
        return this.pdtProductDesc;
    }

    public void setPdtProductDesc(String pdtProductDesc) {
        this.pdtProductDesc = pdtProductDesc;
    }

    @Column(name = "pdt_productshortdesc", length = 80)
    public String getPdtProductShortDesc() {
        return this.pdtProductShortDesc;
    }

    public void setPdtProductShortDesc(String pdtProductShortDesc) {
        this.pdtProductShortDesc = pdtProductShortDesc;
    }

    @Column(name = "pdt_productdaysoflife", precision = 6, scale = 0)
    public Integer getPdtProductDaysOfLife() {
        return this.pdtProductDaysOfLife;
    }

    public void setPdtProductDaysOfLife(Integer pdtProductDaysOfLife) {
        this.pdtProductDaysOfLife = pdtProductDaysOfLife;
    }

    @Column(name = "pdt_productcontainerstack", precision = 2, scale = 0)
    public Byte getPdtProductContainerStack() {
        return this.pdtProductContainerStack;
    }

    public void setPdtProductContainerStack(Byte pdtProductContainerStack) {
        this.pdtProductContainerStack = pdtProductContainerStack;
    }

    @Column(name = "pdt_productpickmessage", length = 80)
    public String getPdtProductPickMessage() {
        return this.pdtProductPickMessage;
    }

    public void setPdtProductPickMessage(String pdtProductPickMessage) {
        this.pdtProductPickMessage = pdtProductPickMessage;
    }

    @Column(name = "pdt_productmanipulationdesc", length = 80)
    public String getPdtProductManipulationDesc() {
        return this.pdtProductManipulationDesc;
    }

    public void setPdtProductManipulationDesc(String pdtProductManipulationDesc) {
        this.pdtProductManipulationDesc = pdtProductManipulationDesc;
    }

    @Column(name = "pdt_productmintemp", precision = 12, scale = 5)
    public BigDecimal getPdtProductMinTemp() {
        return this.pdtProductMinTemp;
    }

    public void setPdtProductMinTemp(BigDecimal pdtProductMinTemp) {
        this.pdtProductMinTemp = pdtProductMinTemp;
    }

    @Column(name = "pdt_productmaxtemp", precision = 17, scale = 5)
    public BigDecimal getPdtProductMaxTemp() {
        return this.pdtProductMaxTemp;
    }

    public void setPdtProductMaxTemp(BigDecimal pdtProductMaxTemp) {
        this.pdtProductMaxTemp = pdtProductMaxTemp;
    }

    @Column(name = "pdt_productmaxstock", precision = 17, scale = 5)
    public BigDecimal getPdtProductMaxStock() {
        return this.pdtProductMaxStock;
    }

    public void setPdtProductMaxStock(BigDecimal pdtProductMaxStock) {
        this.pdtProductMaxStock = pdtProductMaxStock;
    }

    @Column(name = "pdt_productminstock", precision = 17, scale = 5)
    public BigDecimal getPdtProductMinStock() {
        return this.pdtProductMinStock;
    }

    public void setPdtProductMinStock(BigDecimal pdtProductMinStock) {
        this.pdtProductMinStock = pdtProductMinStock;
    }

    @Column(name = "pdt_productmanipulationprice", precision = 17, scale = 5)
    public BigDecimal getPdtProductManipulationPrice() {
        return this.pdtProductManipulationPrice;
    }

    public void setPdtProductManipulationPrice(
            BigDecimal pdtProductManipulationPrice) {
        this.pdtProductManipulationPrice = pdtProductManipulationPrice;
    }

    @Column(name = "pdt_productpickingprice", precision = 17, scale = 5)
    public BigDecimal getPdtProductPickingPrice() {
        return this.pdtProductPickingPrice;
    }

    public void setPdtProductPickingPrice(BigDecimal pdtProductPickingPrice) {
        this.pdtProductPickingPrice = pdtProductPickingPrice;
    }

    @Column(name = "pdt_productexpeditionprice", precision = 17, scale = 5)
    public BigDecimal getPdtProductExpeditionPrice() {
        return this.pdtProductExpeditionPrice;
    }

    public void setPdtProductExpeditionPrice(
            BigDecimal pdtProductExpeditionPrice) {
        this.pdtProductExpeditionPrice = pdtProductExpeditionPrice;
    }

    @Column(name = "pdt_productconditionningprice", precision = 17, scale = 5)
    public BigDecimal getPdtProductConditionningPrice() {
        return this.pdtProductConditionningPrice;
    }

    public void setPdtProductConditionningPrice(
            BigDecimal pdtProductConditionningPrice) {
        this.pdtProductConditionningPrice = pdtProductConditionningPrice;
    }

    @Column(name = "pdt_productpaletconditionning", precision = 10, scale = 0)
    public Long getPdtProductPaletConditionning() {
        return this.pdtProductPaletConditionning;
    }

    public void setPdtProductPaletConditionning(
            Long pdtProductPaletConditionning) {
        this.pdtProductPaletConditionning = pdtProductPaletConditionning;
    }

    @Column(name = "pdt_productisactive", nullable = false)
    public Boolean getPdtProductIsActive() {
        return this.pdtProductIsActive;
    }

    public void setPdtProductIsActive(Boolean pdtProductIsActive) {
        this.pdtProductIsActive = pdtProductIsActive;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_productcreationdate")
    public Date getPdtProductCreationDate() {
        return this.pdtProductCreationDate;
    }

    public void setPdtProductCreationDate(Date pdtProductCreationDate) {
        this.pdtProductCreationDate = pdtProductCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_productupdatedate")
    public Date getPdtProductUpdateDate() {
        return this.pdtProductUpdateDate;
    }

    public void setPdtProductUpdateDate(Date pdtProductUpdateDate) {
        this.pdtProductUpdateDate = pdtProductUpdateDate;
    }

    @Column(name = "pdt_productvariable1")
    public String getPdtProductVariable1() {
        return this.pdtProductVariable1;
    }

    public void setPdtProductVariable1(String pdtProductVariable1) {
        this.pdtProductVariable1 = pdtProductVariable1;
    }

    @Column(name = "pdt_productvariable2")
    public String getPdtProductVariable2() {
        return this.pdtProductVariable2;
    }

    public void setPdtProductVariable2(String pdtProductVariable2) {
        this.pdtProductVariable2 = pdtProductVariable2;
    }

    @Column(name = "pdt_productvariable3")
    public String getPdtProductVariable3() {
        return this.pdtProductVariable3;
    }

    public void setPdtProductVariable3(String pdtProductVariable3) {
        this.pdtProductVariable3 = pdtProductVariable3;
    }

    @Column(name = "pdt_productvariable4")
    public String getPdtProductVariable4() {
        return this.pdtProductVariable4;
    }

    public void setPdtProductVariable4(String pdtProductVariable4) {
        this.pdtProductVariable4 = pdtProductVariable4;
    }

    @Column(name = "pdt_productvariable5")
    public String getPdtProductVariable5() {
        return this.pdtProductVariable5;
    }

    public void setPdtProductVariable5(String pdtProductVariable5) {
        this.pdtProductVariable5 = pdtProductVariable5;
    }

    @Column(name = "pdt_productvariable6")
    public String getPdtProductVariable6() {
        return this.pdtProductVariable6;
    }

    public void setPdtProductVariable6(String pdtProductVariable6) {
        this.pdtProductVariable6 = pdtProductVariable6;
    }

    @Column(name = "pdt_productvariable7")
    public String getPdtProductVariable7() {
        return this.pdtProductVariable7;
    }

    public void setPdtProductVariable7(String pdtProductVariable7) {
        this.pdtProductVariable7 = pdtProductVariable7;
    }

    @Column(name = "pdt_productvariable8")
    public String getPdtProductVariable8() {
        return this.pdtProductVariable8;
    }

    public void setPdtProductVariable8(String pdtProductVariable8) {
        this.pdtProductVariable8 = pdtProductVariable8;
    }

    @Column(name = "pdt_productvariable9")
    public String getPdtProductVariable9() {
        return this.pdtProductVariable9;
    }

    public void setPdtProductVariable9(String pdtProductVariable9) {
        this.pdtProductVariable9 = pdtProductVariable9;
    }

    @Column(name = "pdt_productvariable10")
    public String getPdtProductVariable10() {
        return this.pdtProductVariable10;
    }

    public void setPdtProductVariable10(String pdtProductVariable10) {
        this.pdtProductVariable10 = pdtProductVariable10;
    }

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProduct")
    public Set<PdtAlias> getPdtAliases() {
        return this.pdtAliases;
    }

    public void setPdtAliases(Set<PdtAlias> pdtAliases) {
        this.pdtAliases = pdtAliases;
    }*/

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProduct")
    public Set<PdtProductPack> getPdtProductPacks() {
        return this.pdtProductPacks;
    }

    public void setPdtProductPacks(Set<PdtProductPack> pdtProductPacks) {
        this.pdtProductPacks = pdtProductPacks;
    }

    @Column(name = "pdt_productiskit")
    public Boolean getPdtProductIsKit() {
        return pdtProductIsKit;
    }

    public void setPdtProductIsKit(Boolean pdtProductIsKit) {
        this.pdtProductIsKit = pdtProductIsKit;
    }

    @Column(name = "pdt_productqualityofcontrol")
    public Boolean getPdtProductQualityOfControl() {
        return pdtProductQualityOfControl;
    }

    public void setPdtProductQualityOfControl(Boolean pdtProductQualityOfControl) {
        this.pdtProductQualityOfControl = pdtProductQualityOfControl;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productproductpackid")
    public PdtProductPack getPdtProductPack() {
        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }

    @ManyToOne
    @JoinColumn(name = "pdt_productpickinglocationid")
    public LocLocation getPickingLocLocation() {
        return pickingLocLocation;
    }

    public void setPickingLocLocation(LocLocation pickingLocLocation) {
        this.pickingLocLocation = pickingLocLocation;
    }

    @ManyToOne
    @JoinColumn(name = "pdt_productpickinguomid")
    public PdtUom getPickingPdtUom() {
        return pickingPdtUom;
    }

    public void setPickingPdtUom(PdtUom pickingPdtUom) {
        this.pickingPdtUom = pickingPdtUom;
    }

    @Column(name = "pdt_productcapacity")
    public BigDecimal getPdtCapacity() {
        return pdtCapacity;
    }

    public void setPdtCapacity(BigDecimal pdtCapacity) {
        this.pdtCapacity = pdtCapacity;
    }

    @Column(name = "pdt_productisreception")
    public Boolean getPdtIsReception() {
        return pdtIsReception;
    }

    public void setPdtIsReception(Boolean pdtIsReception) {
        this.pdtIsReception = pdtIsReception;
    }

    @Column(name = "pdt_productminimalthreshold")
    public BigDecimal getPdtMinimalThreshold() {
        return pdtMinimalThreshold;
    }

    public void setPdtMinimalThreshold(BigDecimal pdtMinimalThreshold) {
        this.pdtMinimalThreshold = pdtMinimalThreshold;

    }

    @Column(name = "pdt_productreqexp")

    public Boolean getPdtProductReqExp() {
        return pdtProductReqExp;
    }

    public void setPdtProductReqExp(Boolean pdtProductReqExp) {
        this.pdtProductReqExp = pdtProductReqExp;
    }

    @Column(name = "pdt_productreqrec")

    public Boolean getPdtProductReqRec() {
        return pdtProductReqRec;
    }

    public void setPdtProductReqRec(Boolean pdtProductReqRec) {
        this.pdtProductReqRec = pdtProductReqRec;
    }

    @Column(name = "pdt_productcontrolweight")
    public Boolean getPdtProductControlWeight() {
        return pdtProductControlWeight;
    }

    public void setPdtProductControlWeight(Boolean pdtProductControlWeight) {
        this.pdtProductControlWeight = pdtProductControlWeight;
    }

    @Column(name = "pdt_productwarrantymanagement")

    public Boolean getPdtProductWarrantyManagement() {
        return pdtProductWarrantyManagement;
    }

    public void setPdtProductWarrantyManagement(Boolean pdtProductWarrantyManagement) {
        this.pdtProductWarrantyManagement = pdtProductWarrantyManagement;
    }

    @Column(name = "pdt_productdiscount")
    public BigDecimal getPdtProductDiscount() {
        return pdtProductDiscount;
    }

    public void setPdtProductDiscount(BigDecimal pdtProductDiscount) {
        this.pdtProductDiscount = pdtProductDiscount;
    }

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productwarrantyperiodid")

    public PrmWarrantyPeriod getPrmWarrantyPeriod() {
        return prmWarrantyPeriod;
    }

    public void setPrmWarrantyPeriod(PrmWarrantyPeriod prmWarrantyPeriod) {
        this.prmWarrantyPeriod = prmWarrantyPeriod;
    }*/

    @Column(name = "pdt_productpurshasepriceub")

    public BigDecimal getPdtProductPurshasePriceUB() {
        return pdtProductPurshasePriceUB;
    }

    public void setPdtProductPurshasePriceUB(BigDecimal pdtProductPurshasePriceUB) {
        this.pdtProductPurshasePriceUB = pdtProductPurshasePriceUB;
    }

  /*  @JoinColumn(name = "pdt_productcurrencyid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmCurrency getPrmCurrencySale() {
        return prmCurrencySale;
    }

    public void setPrmCurrencySale(PrmCurrency prmCurrencySale) {
        this.prmCurrencySale = prmCurrencySale;
    }*/

  /*  @JoinColumn(name = "pdt_productformid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PdtProductForm getPdtProductForm() {
        return pdtProductForm;
    }

    public void setPdtProductForm(PdtProductForm pdtProductForm) {
        this.pdtProductForm = pdtProductForm;
    }
*/
  /*  @JoinColumn(name = "pdt_productcurrencypurshaseid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmCurrency getPrmCurrencyPurshase() {
        return prmCurrencyPurshase;
    }

    public void setPrmCurrencyPurshase(PrmCurrency prmCurrencyPurshase) {
        this.prmCurrencyPurshase = prmCurrencyPurshase;
    }*/

    @Column(name = "pdt_productdimension")
    public Boolean getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(Boolean pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }

 /*   @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PdtProductDimension> getPdtProductDimensions() {
        return pdtProductDimensions;
    }

    public void setPdtProductDimensions(Set<PdtProductDimension> pdtProductDimensions) {
        this.pdtProductDimensions = pdtProductDimensions;
    }*/

    @Column(name = "pdt_productcoefficient")
    public BigDecimal getPdtProductCoefficient() {
        return pdtProductCoefficient;
    }

    public void setPdtProductCoefficient(BigDecimal pdtProductCoefficient) {
        this.pdtProductCoefficient = pdtProductCoefficient;
    }

    @Column(name = "pdt_productproductioncost")
    public BigDecimal getPdtProductProductionCost() {
        return pdtProductProductionCost;
    }

    public void setPdtProductProductionCost(BigDecimal pdtProductProductionCost) {
        this.pdtProductProductionCost = pdtProductProductionCost;
    }

    @Column(name = "pdt_productversion")
    public Long getPdtProductVersion() {
        return pdtProductVersion;
    }

    public void setPdtProductVersion(Long pdtProductVersion) {
        this.pdtProductVersion = pdtProductVersion;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productprocessid")
    public PdtProcess getPdtProcess() {
        return pdtProcess;
    }

    public void setPdtProcess(PdtProcess pdtProcess) {
        this.pdtProcess = pdtProcess;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productvatid", nullable = false)
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "pdt_productstocked", nullable = false)
    public Boolean getPdtProductStocked() {
        return pdtProductStocked;
    }

    public void setPdtProductStocked(Boolean pdtProductStocked) {
        this.pdtProductStocked = pdtProductStocked;
    }

    @Column(name = "pdt_productforbuying")
    public Boolean getPdtProductForBuying() {
        return pdtProductForBuying;
    }

    public void setPdtProductForBuying(Boolean pdtProductForBuying) {
        this.pdtProductForBuying = pdtProductForBuying;
    }

    @Column(name = "pdt_productstockmanaged")
    public Boolean getPdtProductStockManaged() {
        return pdtProductStockManaged;
    }

    public void setPdtProductStockManaged(Boolean pdtProductStockManaged) {
        this.pdtProductStockManaged = pdtProductStockManaged;
    }

    @Column(name = "pdt_productoutofstock")
    public Boolean getPdtProductOutOfStock() {
        return pdtProductOutOfStock;
    }

    public void setPdtProductOutOfStock(Boolean pdtProductOutOfStock) {
        this.pdtProductOutOfStock = pdtProductOutOfStock;
    }

    @Column(name = "pdt_productmarginofpurchase")
    public BigDecimal getPdtProductMarginOfPurchase() {
        return pdtProductMarginOfPurchase;
    }

    public void setPdtProductMarginOfPurchase(BigDecimal pdtProductMarginOfPurchase) {
        this.pdtProductMarginOfPurchase = pdtProductMarginOfPurchase;
    }

    @Column(name = "pdt_productmarginofcostsofreturn")

    public BigDecimal getPdtProductMarginOfCostsOfReturn() {
        return pdtProductMarginOfCostsOfReturn;
    }

    public void setPdtProductMarginOfCostsOfReturn(BigDecimal pdtProductMarginOfCostsOfReturn) {
        this.pdtProductMarginOfCostsOfReturn = pdtProductMarginOfCostsOfReturn;
    }

    @Column(name = "pdt_productcostsofreturn")

    public BigDecimal getPdtProductCostsOfReturn() {
        return pdtProductCostsOfReturn;
    }

    public void setPdtProductCostsOfReturn(BigDecimal pdtProductCostsOfReturn) {
        this.pdtProductCostsOfReturn = pdtProductCostsOfReturn;
    }

    @Column(name = "pdt_producttechnicalsheet", columnDefinition = "TEXT")
    public String getPdtProductTechnicalSheet() {
        return pdtProductTechnicalSheet;
    }

    public void setPdtProductTechnicalSheet(String pdtProductTechnicalSheet) {
        this.pdtProductTechnicalSheet = pdtProductTechnicalSheet;
    }

    @Column(name = "pdt_productstockedquantity")
    public BigDecimal getPdtProductStockedQuantity() {
        return pdtProductStockedQuantity;
    }

    public void setPdtProductStockedQuantity(BigDecimal pdtProductStockedQuantity) {
        this.pdtProductStockedQuantity = pdtProductStockedQuantity;
    }

    @Column(name = "pdt_productreservedquantity")
    public BigDecimal getPdtProductReservedQuantity() {
        return pdtProductReservedQuantity;
    }

    public void setPdtProductReservedQuantity(BigDecimal pdtProductReservedQuantity) {
        this.pdtProductReservedQuantity = pdtProductReservedQuantity;
    }

    @Column(name = "pdt_productquantitytoreceive")
    public BigDecimal getPdtProductQuantityToReceive() {
        return pdtProductQuantityToReceive;
    }

    public void setPdtProductQuantityToReceive(BigDecimal pdtProductQuantityToReceive) {
        this.pdtProductQuantityToReceive = pdtProductQuantityToReceive;
    }

    @Column(name = "pdt_productordredquantity")
    public BigDecimal getPdtProductOrderedQuantity() {
        return pdtProductOrderedQuantity;
    }

    public void setPdtProductOrderedQuantity(BigDecimal pdtProductOrderedQuantity) {
        this.pdtProductOrderedQuantity = pdtProductOrderedQuantity;
    }

    @Column(name = "pdt_productblockedquantity")

    public BigDecimal getPdtProductBlockedQuantity() {
        return pdtProductBlockedQuantity;
    }

    public void setPdtProductBlockedQuantity(BigDecimal pdtProductBlockedQuantity) {
        this.pdtProductBlockedQuantity = pdtProductBlockedQuantity;
    }

    @Column(name = "pdt_productpackaging")
    public Boolean getPdtProductPackaging() {
        return pdtProductPackaging;
    }

    public void setPdtProductPackaging(Boolean pdtProductPackaging) {
        this.pdtProductPackaging = pdtProductPackaging;
    }

    @Column(name = "pdt_productcharge")

    public Boolean getPdtProductCharge() {
        return pdtProductCharge;
    }

    public void setPdtProductCharge(Boolean pdtProductCharge) {
        this.pdtProductCharge = pdtProductCharge;
    }

    @Column(name = "pdt_productaveragecost")
    public BigDecimal getPdtProductAveragePurchaseCost() {
        return pdtProductAveragePurchaseCost;
    }

    public void setPdtProductAveragePurchaseCost(BigDecimal pdtProductAveragePurchaseCost) {
        this.pdtProductAveragePurchaseCost = pdtProductAveragePurchaseCost;
    }

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productcategoryid")
    public PdtProductCategory getPdtProductCategory() {
        return pdtProductCategory;
    }

    public void setPdtProductCategory(PdtProductCategory pdtProductCategory) {
        this.pdtProductCategory = pdtProductCategory;
    }*/

    @Column(name = "pdt_productlastinventorydate")
    public Date getPdtProductLastInventoryDate() {
        return pdtProductLastInventoryDate;
    }

    public void setPdtProductLastInventoryDate(Date pdtProductLastInventoryDate) {
        this.pdtProductLastInventoryDate = pdtProductLastInventoryDate;
    }

    @Column(name = "pdt_productsuplierdelay")

    public Integer getPdtProductSupplierDelay() {
        return pdtProductSupplierDelay;
    }

    public void setPdtProductSupplierDelay(Integer pdtProductSupplierDelay) {
        this.pdtProductSupplierDelay = pdtProductSupplierDelay;
    }

    @Column(name = "pdt_productprofessionalsaleprice")
    public BigDecimal getPdtProductProfessionalSalePrice() {
        return pdtProductProfessionalSalePrice;
    }

    public void setPdtProductProfessionalSalePrice(BigDecimal pdtProductProfessionalSalePrice) {
        this.pdtProductProfessionalSalePrice = pdtProductProfessionalSalePrice;
    }
    @Column(name = "pdt_productvariableweight")
    public Boolean getPdtProductVariableWeight() {
        return pdtProductVariableWeight;
    }

    public void setPdtProductVariableWeight(Boolean pdtProductVariableWeight) {
        this.pdtProductVariableWeight = pdtProductVariableWeight;
    }
    @JoinColumn(name = "pdt_productvatpurchaseid")
    @ManyToOne(fetch = FetchType.LAZY)
    public PrmVat getPrmVatPurchase() {
        return prmVatPurchase;
    }

    public void setPrmVatPurchase(PrmVat prmVatPurchase) {
        this.prmVatPurchase = prmVatPurchase;
    }
    @Column(name = "pdt_productcustomspercentage")
    public BigDecimal getPdtProductCustomsPercentage() {
        return pdtProductCustomsPercentage;
    }

    public void setPdtProductCustomsPercentage(BigDecimal pdtProductCustomsPercentage) {
        this.pdtProductCustomsPercentage = pdtProductCustomsPercentage;
    }
    @Column(name = "pdt_productttcsaleprice")
    public BigDecimal getPdtProductTTCSalePriceUB() {
        return pdtProductTTCSalePriceUB;
    }

    public void setPdtProductTTCSalePriceUB(BigDecimal pdtProductTTCSalePriceUB) {
        this.pdtProductTTCSalePriceUB = pdtProductTTCSalePriceUB;
    }
    @Column(name = "pdt_productttcpurchaseprice")
    public BigDecimal getPdtProductTTCPurshasePriceUB() {
        return pdtProductTTCPurshasePriceUB;
    }

    public void setPdtProductTTCPurshasePriceUB(BigDecimal pdtProductTTCPurshasePriceUB) {
        this.pdtProductTTCPurshasePriceUB = pdtProductTTCPurshasePriceUB;
    }
    @Column(name = "pdt_productttcprofessionalttcsaleprice")
    public BigDecimal getPdtProductProfessionalTTCSalePrice() {
        return pdtProductProfessionalTTCSalePrice;
    }

    public void setPdtProductProfessionalTTCSalePrice(BigDecimal pdtProductProfessionalTTCSalePrice) {
        this.pdtProductProfessionalTTCSalePrice = pdtProductProfessionalTTCSalePrice;
    }
    @Column(name = "pdt_productpromarginofpurchase")
    public BigDecimal getPdtProductProMarginOfPurchase() {
        return pdtProductProMarginOfPurchase;
    }

    public void setPdtProductProMarginOfPurchase(BigDecimal pdtProductProMarginOfPurchase) {
        this.pdtProductProMarginOfPurchase = pdtProductProMarginOfPurchase;
    }

}
