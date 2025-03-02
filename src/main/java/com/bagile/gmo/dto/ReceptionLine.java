package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class ReceptionLine extends EmsDto implements Serializable {

    private static final long serialVersionUID = -2756817780022540226L;

    //private Location location;
    private long id;
    private Long lineNumber;
    private Owner owner;
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
    private Date creationDate;
    private String description;
    private Set<ReceptionStock> receptionStocks;
    private Date receptionDate;
    private Warehouse warehouse;
    private Product product;
   private BlockType blockType;
   private Color color;
    private Date dlc;
    private Date dluo;
    private String serialNo;
    private String lot;
    private Reception reception;
    private String containerCode;
    private PurshaseOrderLine purshaseOrderLine;
    private OrderStatus orderStatus;
    private BigDecimal quantityReceived;
    private BigDecimal quantity;
    private BigDecimal blockedQuantity;
    private Uom uom;
    private Uom uomReceived;
    private String quality;
    private BigDecimal weight;
    private String comment;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private Vat vat;
    private BigDecimal discount;
    private BigDecimal purshasePrice;
   // private ProductDimension productDimension;
    private ProductPack productPack;
    private ProductPack productPackReceived;
    private BigDecimal provisionalCost;
    private BigDecimal extraCost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ReceptionStock> getReceptionStocks() {
        return receptionStocks;
    }

    public void setReceptionStocks(Set<ReceptionStock> receptionStocks) {
        this.receptionStocks = receptionStocks;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

   public BlockType getBlockType() {
        return blockType;
    }

    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }

   public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getDlc() {
        return dlc;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public Date getDluo() {
        return dluo;
    }

    public void setDluo(Date dluo) {
        this.dluo = dluo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public PurshaseOrderLine getPurshaseOrderLine() {
        return purshaseOrderLine;
    }

    public void setPurshaseOrderLine(PurshaseOrderLine purshaseOrderLine) {
        this.purshaseOrderLine = purshaseOrderLine;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(BigDecimal quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }


    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getBlockedQuantity() {
        return blockedQuantity;
    }

    public void setBlockedQuantity(BigDecimal blockedQuantity) {
        this.blockedQuantity = blockedQuantity;
    }

    public Uom getUomReceived() {
        return uomReceived;
    }

    public void setUomReceived(Uom uomReceived) {
        this.uomReceived = uomReceived;
    }

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPurshasePrice() {
        return purshasePrice;
    }

    public void setPurshasePrice(BigDecimal purshasePrice) {
        this.purshasePrice = purshasePrice;
    }

    /*public ProductDimension getProductDimension() {
        return productDimension;
    }

    public void setProductDimension(ProductDimension productDimension) {
        this.productDimension = productDimension;
    }
*/
    public ProductPack getProductPack() {
        return productPack;
    }

    public void setProductPack(ProductPack productPack) {
        this.productPack = productPack;
    }

    public ProductPack getProductPackReceived() {
        return productPackReceived;
    }

    public void setProductPackReceived(ProductPack productPackReceived) {
        this.productPackReceived = productPackReceived;
    }

    public BigDecimal getProvisionalCost() {
        return provisionalCost;
    }

    public void setProvisionalCost(BigDecimal provisionalCost) {
        this.provisionalCost = provisionalCost;
    }


    public BigDecimal getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(BigDecimal extraCost) {
        this.extraCost = extraCost;
    }
}
