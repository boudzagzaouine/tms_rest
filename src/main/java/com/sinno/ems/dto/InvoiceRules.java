package com.sinno.ems.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class InvoiceRules implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1918940634840455198L;

    private long id;
    private String code;
    private BigDecimal price;
    private Owner owner;
    private boolean productActive;
    private MovementType movementType;
    private Boolean relevantReception;
    private Boolean relevantDelivery;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    /**
     * @return the productActive
     */
    public boolean isProductActive() {
        return productActive;
    }

    /**
     * @param productActive the productActive to set
     */
    public void setProductActive(boolean productActive) {
        this.productActive = productActive;
    }

    /**
     * @return the movementType
     */
    public MovementType getMovementType() {
        return movementType;
    }

    /**
     * @param movementType the movementType to set
     */
    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Boolean getRelevantReception() {
        return relevantReception;
    }

    public void setRelevantReception(Boolean relevantReception) {
        this.relevantReception = relevantReception;
    }

    public Boolean getRelevantDelivery() {
        return relevantDelivery;
    }

    public void setRelevantDelivery(Boolean relevantDelivery) {
        this.relevantDelivery = relevantDelivery;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            InvoiceRules obj = (InvoiceRules) object;
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