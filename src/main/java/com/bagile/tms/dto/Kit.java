package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by adadi on 12/30/2015.
 */
public class Kit implements Serializable {
    private long id;
    private Product product;
    private Product component;
    private BigDecimal quantity;
    private Uom uom;
    private Uom componentUom;
    private Long version;
    private BigDecimal marginFalling;

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

    public Product getComponent() {
        return component;
    }

    public void setComponent(Product component) {
        this.component = component;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public Uom getComponentUom() {
        return componentUom;
    }

    public void setComponentUom(Uom componentUom) {
        this.componentUom = componentUom;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public BigDecimal getMarginFalling() {
        return marginFalling;
    }

    public void setMarginFalling(BigDecimal marginFalling) {
        this.marginFalling = marginFalling;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Kit obj = (Kit) object;
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
