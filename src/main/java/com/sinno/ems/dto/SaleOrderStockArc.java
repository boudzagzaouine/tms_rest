package com.sinno.ems.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaleOrderStockArc implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5509404836662114735L;

    private Location location;
    private long id;
    private Long lineNumber;
    private Owner owner;
    private Date updateDate;
    private Date creationDate;
    private Warehouse warehouse;
    private Product product;
    private BlockType blockType;
    private Date dlc;
    private Date dluo;
    private String serialNo;
    private String lot;
    //TODO DATATABLE
    private DeliveryArc delivery;
    private Container container;
    private Date orderDate;
    private BigDecimal quantityServed;
    private DeliveryLineArc deliveryLine;
    private Color color;
    private String transportContainerNo;
    private Uom uom;
    private StockArc stock;
    private String quality;

    private BigDecimal weight;

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BlockType getBlockType() {
        return this.blockType;
    }

    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }

    public Date getDlc() {
        return this.dlc;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public Date getDluo() {
        return this.dluo;
    }

    public void setDluo(Date dluo) {
        this.dluo = dluo;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLot() {
        return this.lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public DeliveryArc getDelivery() {
        return this.delivery;
    }

    public void setDelivery(DeliveryArc delivery) {
        this.delivery = delivery;
    }

    public Container getContainer() {
        return this.container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getQuantityServed() {
        return this.quantityServed;
    }

    public void setQuantityServed(BigDecimal quantityServed) {
        this.quantityServed = quantityServed;
    }

    public DeliveryLineArc getDeliveryLine() {
        return this.deliveryLine;
    }

    public void setDeliveryLine(DeliveryLineArc deliveryLine) {
        this.deliveryLine = deliveryLine;
    }

    public String getTransportContainerNo() {
        return this.transportContainerNo;
    }

    public void setTransportContainerNo(String transportContainerNo) {
        this.transportContainerNo = transportContainerNo;
    }


    public Uom getUom() {
        return this.uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public StockArc getStock() {
        return stock;
    }

    public void setStock(StockArc stock) {
        this.stock = stock;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            SaleOrderStockArc obj = (SaleOrderStockArc) object;
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