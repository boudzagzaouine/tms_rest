package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class FuelPump extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private String code;
    private Product product;
    private Pump pump;
     private BigDecimal quantity;
    private Location location;
    public FuelPump() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Pump getPump() {
        return pump;
    }

    public void setPump(Pump pump) {
        this.pump = pump;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelPump badge = (FuelPump) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
