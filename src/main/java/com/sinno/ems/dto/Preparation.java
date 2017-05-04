package com.sinno.ems.dto;

import com.sinno.ems.entities.CmdAccount;
import com.sinno.ems.entities.CmdSaleOrder;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by Enissay on 03/12/2016.
 */
public class Preparation {
    private long id;
    private String code;
    private SaleOrder saleOrder;
    private Account account;
    private Date preparationDate;
    private Date creationDate;
    private Date updateDate;
    private Warehouse warehouse;
    private Owner owner;
    private OrderStatus orderStatus;
    private Set<PreparationLine> preparationLines;
    private OrderType orderType;


    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

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

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getPreparationDate() {
        return preparationDate;
    }

    public void setPreparationDate(Date preparationDate) {
        this.preparationDate = preparationDate;
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

    public Set<PreparationLine> getPreparationLines() {
        return preparationLines;
    }

    public void setPreparationLines(Set<PreparationLine> preparationLines) {
        this.preparationLines = preparationLines;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}
