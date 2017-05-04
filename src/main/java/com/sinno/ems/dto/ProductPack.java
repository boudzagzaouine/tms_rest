package com.sinno.ems.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductPack implements Serializable {

    private static final long serialVersionUID = 2363111932810486334L;

    private long id;
    private BigDecimal size;
    private Owner owner;
    private Date updateDate;
    private Date creationDate;
    private Product product;
    private Alias alias;
    private Uom uom;
    private BigDecimal weight;
    private BigDecimal height;
    private Boolean weightControl;
    private BigDecimal lenght;
    private BigDecimal depth;
    private Long typePck;
    private BigDecimal quantity;
    private BigDecimal salePrice;
    private BigDecimal purshasePrice;
    private BigDecimal width;
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
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

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Alias getAlias() {
        return this.alias;
    }

    public void setAlias(Alias alias) {
        this.alias = alias;
    }

    public Uom getUom() {
        return this.uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getHeight() {
        return this.height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLenght() {
        return this.lenght;
    }

    public void setLenght(BigDecimal lenght) {
        this.lenght = lenght;
    }

    public BigDecimal getDepth() {
        return this.depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public Long getTypePck() {
        return typePck;
    }

    public void setTypePck(Long typePck) {
        this.typePck = typePck;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public Boolean getWeightControl() {
        return weightControl;
    }

    public void setWeightControl(Boolean weightControl) {
        this.weightControl = weightControl;
    }

    public BigDecimal getPurshasePrice() {
        return purshasePrice;
    }

    public void setPurshasePrice(BigDecimal purshasePrice) {
        this.purshasePrice = purshasePrice;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            ProductPack obj = (ProductPack) object;
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

