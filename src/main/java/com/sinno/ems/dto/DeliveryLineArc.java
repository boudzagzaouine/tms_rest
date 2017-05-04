package com.sinno.ems.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ALae on 21/04/2016.
 */
public class DeliveryLineArc {


    private long id;
    private long lineNumber;
    private SaleOrderLineArc saleOrderLine;
    private Product product;
    private String productDescription;
    private BigDecimal orderedQuantity;
    private Uom uom;
    private BigDecimal quantityServed;
    private BlockType blockType;
    private Warehouse warehouse;
    private ContainerArc container;
    private OrderStatus orderStatus;
    private String serialNo;
    private String lot;
    private Color color;
    private Date dlc;
    private Date dluo;
    private String comment;
    private Owner owner;
    private Date creationDate;
    private Date updateDate;
    private DeliveryArc delivery;
    private String quality;
    private BigDecimal weight;
    private Location location;

    public DeliveryLineArc() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public SaleOrderLineArc getSaleOrderLine() {
        return saleOrderLine;
    }

    public void setSaleOrderLine(SaleOrderLineArc saleOrderLine) {
        this.saleOrderLine = saleOrderLine;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public BigDecimal getQuantityServed() {
        return quantityServed;
    }

    public void setQuantityServed(BigDecimal quantityServed) {
        this.quantityServed = quantityServed;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public ContainerArc getContainer() {
        return container;
    }

    public void setContainer(ContainerArc container) {
        this.container = container;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public DeliveryArc getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryArc delivery) {
        this.delivery = delivery;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
