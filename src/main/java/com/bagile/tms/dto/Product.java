package com.bagile.tms.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Product extends EmsDto {

    private static final long serialVersionUID = 2190494089191881319L;

    private long id;
    private Owner owner;
    private Uom uomByProductUomSale;
    private Uom uomByProductUomBase;
    private Uom uomByProductUomPurshase;
    private String code;
    private BigDecimal priceUB;
    private Long suppOfLife;
    private Long raisonToOut;
    private Date updateDate;
    private String variable1;
    private String variable2;
    private String variable3;
    private String variable4;
    private String variable5;
    private String variable6;
    private String variable7;
    private String variable8;
    private String variable9;
    private String variable10;
    private ProductType productType;
    private Boolean active;
    private Date creationDate;
    private ProductType productSubType;
    private Boolean colorControl;
    private Boolean serialNoControl;
    private Boolean dluoControl;
    private Boolean weightControl;
    private Byte containerStack;
    private String pickMessage;
    private String manipulationDesc;
    private BigDecimal manipulationPrice;
    private BigDecimal pickingPrice;
    private BigDecimal expeditionPrice;
    private BigDecimal conditionningPrice;
    private Long paletConditionning;
    private Warehouse warehouse;

    private Supplier supplier;
    private Boolean dlcControl;
    private Boolean lotControl;
    private String desc;
    private String descSecondLanguage;
    private String shortDesc;
    private Integer daysOfLife;
    private BigDecimal minTemp;
    private BigDecimal maxTemp;
    private BigDecimal maxStock;
    private BigDecimal minStock;
    private Boolean kit;
    private Boolean qualityOfControl;
    private BigDecimal samplingPercentage;
    private Boolean ReqRec;
    private Boolean ReqExp;
    private Set<ProductPack> productPacks;
    private Uom pickingUom;
    private BigDecimal minimalThreshold;
    private BigDecimal capacity;
    private Boolean isReception;
    private ProductPack productPack;
    private ProductPack kitProductPack;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Uom getUomByProductUomSale() {
        return uomByProductUomSale;
    }

    public void setUomByProductUomSale(Uom uomByProductUomSale) {
        this.uomByProductUomSale = uomByProductUomSale;
    }

    public Uom getUomByProductUomBase() {
        return uomByProductUomBase;
    }

    public void setUomByProductUomBase(Uom uomByProductUomBase) {
        this.uomByProductUomBase = uomByProductUomBase;
    }

    public Uom getUomByProductUomPurshase() {
        return uomByProductUomPurshase;
    }

    public void setUomByProductUomPurshase(Uom uomByProductUomPurshase) {
        this.uomByProductUomPurshase = uomByProductUomPurshase;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPriceUB() {
        return priceUB;
    }

    public void setPriceUB(BigDecimal priceUB) {
        this.priceUB = priceUB;
    }

    public Long getSuppOfLife() {
        return suppOfLife;
    }

    public void setSuppOfLife(Long suppOfLife) {
        this.suppOfLife = suppOfLife;
    }

    public Long getRaisonToOut() {
        return raisonToOut;
    }

    public void setRaisonToOut(Long raisonToOut) {
        this.raisonToOut = raisonToOut;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVariable1() {
        return variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVariable2() {
        return variable2;
    }

    public void setVariable2(String variable2) {
        this.variable2 = variable2;
    }

    public String getVariable3() {
        return variable3;
    }

    public void setVariable3(String variable3) {
        this.variable3 = variable3;
    }

    public String getVariable4() {
        return variable4;
    }

    public void setVariable4(String variable4) {
        this.variable4 = variable4;
    }

    public String getVariable5() {
        return variable5;
    }

    public void setVariable5(String variable5) {
        this.variable5 = variable5;
    }

    public String getVariable6() {
        return variable6;
    }

    public void setVariable6(String variable6) {
        this.variable6 = variable6;
    }

    public String getVariable7() {
        return variable7;
    }

    public void setVariable7(String variable7) {
        this.variable7 = variable7;
    }

    public String getVariable8() {
        return variable8;
    }

    public void setVariable8(String variable8) {
        this.variable8 = variable8;
    }

    public String getVariable9() {
        return variable9;
    }

    public void setVariable9(String variable9) {
        this.variable9 = variable9;
    }

    public String getVariable10() {
        return variable10;
    }

    public void setVariable10(String variable10) {
        this.variable10 = variable10;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ProductType getProductSubType() {
        return productSubType;
    }

    public void setProductSubType(ProductType productSubType) {
        this.productSubType = productSubType;
    }

    public Boolean getColorControl() {
        return colorControl;
    }

    public void setColorControl(Boolean colorControl) {
        this.colorControl = colorControl;
    }

    public Boolean getSerialNoControl() {
        return serialNoControl;
    }

    public void setSerialNoControl(Boolean serialNoControl) {
        this.serialNoControl = serialNoControl;
    }

    public Boolean getDluoControl() {
        return dluoControl;
    }

    public void setDluoControl(Boolean dluoControl) {
        this.dluoControl = dluoControl;
    }

    public Boolean getWeightControl() {
        return weightControl;
    }

    public void setWeightControl(Boolean weightControl) {
        this.weightControl = weightControl;
    }

    public Byte getContainerStack() {
        return containerStack;
    }

    public void setContainerStack(Byte containerStack) {
        this.containerStack = containerStack;
    }

    public String getPickMessage() {
        return pickMessage;
    }

    public void setPickMessage(String pickMessage) {
        this.pickMessage = pickMessage;
    }

    public String getManipulationDesc() {
        return manipulationDesc;
    }

    public void setManipulationDesc(String manipulationDesc) {
        this.manipulationDesc = manipulationDesc;
    }

    public BigDecimal getManipulationPrice() {
        return manipulationPrice;
    }

    public void setManipulationPrice(BigDecimal manipulationPrice) {
        this.manipulationPrice = manipulationPrice;
    }

    public BigDecimal getPickingPrice() {
        return pickingPrice;
    }

    public void setPickingPrice(BigDecimal pickingPrice) {
        this.pickingPrice = pickingPrice;
    }

    public BigDecimal getExpeditionPrice() {
        return expeditionPrice;
    }

    public void setExpeditionPrice(BigDecimal expeditionPrice) {
        this.expeditionPrice = expeditionPrice;
    }

    public BigDecimal getConditionningPrice() {
        return conditionningPrice;
    }

    public void setConditionningPrice(BigDecimal conditionningPrice) {
        this.conditionningPrice = conditionningPrice;
    }

    public Long getPaletConditionning() {
        return paletConditionning;
    }

    public void setPaletConditionning(Long paletConditionning) {
        this.paletConditionning = paletConditionning;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Boolean getDlcControl() {
        return dlcControl;
    }

    public void setDlcControl(Boolean dlcControl) {
        this.dlcControl = dlcControl;
    }

    public Boolean getLotControl() {
        return lotControl;
    }

    public void setLotControl(Boolean lotControl) {
        this.lotControl = lotControl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescSecondLanguage() {
        return descSecondLanguage;
    }

    public void setDescSecondLanguage(String descSecondLanguage) {
        this.descSecondLanguage = descSecondLanguage;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Integer getDaysOfLife() {
        return daysOfLife;
    }

    public void setDaysOfLife(Integer daysOfLife) {
        this.daysOfLife = daysOfLife;
    }

    public BigDecimal getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(BigDecimal minTemp) {
        this.minTemp = minTemp;
    }

    public BigDecimal getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(BigDecimal maxTemp) {
        this.maxTemp = maxTemp;
    }

    public BigDecimal getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(BigDecimal maxStock) {
        this.maxStock = maxStock;
    }

    public BigDecimal getMinStock() {
        return minStock;
    }

    public void setMinStock(BigDecimal minStock) {
        this.minStock = minStock;
    }

    public Boolean getKit() {
        return kit;
    }

    public void setKit(Boolean kit) {
        this.kit = kit;
    }

    public Boolean getQualityOfControl() {
        return qualityOfControl;
    }

    public void setQualityOfControl(Boolean qualityOfControl) {
        this.qualityOfControl = qualityOfControl;
    }

    public BigDecimal getSamplingPercentage() {
        return samplingPercentage;
    }

    public void setSamplingPercentage(BigDecimal samplingPercentage) {
        this.samplingPercentage = samplingPercentage;
    }

    public Boolean getReqRec() {
        return ReqRec;
    }

    public void setReqRec(Boolean reqRec) {
        ReqRec = reqRec;
    }

    public Boolean getReqExp() {
        return ReqExp;
    }

    public void setReqExp(Boolean reqExp) {
        ReqExp = reqExp;
    }

    public Set<ProductPack> getProductPacks() {
        return productPacks;
    }

    public void setProductPacks(Set<ProductPack> productPacks) {
        this.productPacks = productPacks;
    }

    public Uom getPickingUom() {
        return pickingUom;
    }

    public void setPickingUom(Uom pickingUom) {
        this.pickingUom = pickingUom;
    }

    public BigDecimal getMinimalThreshold() {
        return minimalThreshold;
    }

    public void setMinimalThreshold(BigDecimal minimalThreshold) {
        this.minimalThreshold = minimalThreshold;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public Boolean getReception() {
        return isReception;
    }

    public void setReception(Boolean reception) {
        isReception = reception;
    }

    public ProductPack getProductPack() {
        return productPack;
    }

    public void setProductPack(ProductPack productPack) {
        this.productPack = productPack;
    }

    public ProductPack getKitProductPack() {
        return kitProductPack;
    }

    public void setKitProductPack(ProductPack kitProductPack) {
        this.kitProductPack = kitProductPack;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Product obj = (Product) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }
}