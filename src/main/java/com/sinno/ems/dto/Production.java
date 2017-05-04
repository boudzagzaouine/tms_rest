package com.sinno.ems.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 03/04/2017.
 */
public class Production {
    private long id;
    private String code;
    private Date productionDate;
    private Date updateDate;
    private Date creationDate;
    private Owner owner;
    private Warehouse warehouse;
    private String description;
    private OrderStatus orderStatus;
    private Set<ProductionLine> productionLines=new HashSet<ProductionLine>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Set<ProductionLine> getProductionLines() {
        return productionLines;
    }

    public void setProductionLines(Set<ProductionLine> productionLines) {
        this.productionLines = productionLines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
