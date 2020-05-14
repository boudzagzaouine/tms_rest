package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class MaintenanceLine extends EmsDto {

	private static final long serialVersionUID = -2523885174048641991L;

	private long id;
	private MaintenanceLineRef maintenanceLineRef;
    private Set<MaintenanceProduct> maintenanceProducts;
    private String description;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal amountVat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MaintenanceLineRef getMaintenanceLineRef() {
		return maintenanceLineRef;
	}

	public void setMaintenanceLineRef(MaintenanceLineRef maintenanceLineRef) {
		this.maintenanceLineRef = maintenanceLineRef;
	}

	public Set<MaintenanceProduct> getMaintenanceProducts() {
        return maintenanceProducts;
    }

    public void setMaintenanceProducts(Set<MaintenanceProduct> maintenanceProducts) {
        this.maintenanceProducts = maintenanceProducts;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        MaintenanceLine that = (MaintenanceLine) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
    
}
