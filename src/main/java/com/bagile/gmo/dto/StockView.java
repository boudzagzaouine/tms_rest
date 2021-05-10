package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class StockView  implements Serializable {

    private static final long serialVersionUID = -1872267403174822706L;


    private long id;

    private Product product;

    private BigDecimal quantity;
    private BigDecimal price;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }






    /*public Warehouse getWarehouse() {
         return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
         this.warehouse = warehouse;
    }*/
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            StockView obj = (StockView) object;
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