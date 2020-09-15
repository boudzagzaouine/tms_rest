package com.bagile.gmo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ActionLineMaintenance extends EmsDto {

	private static final long serialVersionUID = -2523885174048641991L;

	private long id;
	private Product product;
    private String description;
    private BigDecimal quantity;
    private BigDecimal quantityServed;
    private BigDecimal totalPriceHT;
    private BigDecimal unitPrice;
    private BigDecimal totalPriceTTC;
    private BigDecimal amountVat;
    private ActionMaintenance actionMaintenance;
    private MaintenanceState maintenanceState;

    @JsonIgnore
    private List<MaintenanceStock> maintenanceStocks;

    public List<MaintenanceStock> getMaintenanceStocks() {
        return maintenanceStocks;
    }

    public void setMaintenanceStocks(List<MaintenanceStock> maintenanceStocks) {
        this.maintenanceStocks = maintenanceStocks;
    }

    public MaintenanceState getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(MaintenanceState maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantityServed() {
        return quantityServed;
    }

    public void setQuantityServed(BigDecimal quantityServed) {
        this.quantityServed = quantityServed;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BigDecimal getAmountVat() {
        return amountVat;
    }

    public void setAmountVat(BigDecimal amountVat) {
        this.amountVat = amountVat;
    }




    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }


    public ActionMaintenance getActionMaintenance() {
        return actionMaintenance;
    }

    public void setActionMaintenance(ActionMaintenance actionMaintenance) {
        this.actionMaintenance = actionMaintenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        ActionLineMaintenance that = (ActionLineMaintenance) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
    
}
