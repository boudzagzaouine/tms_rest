package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Set;

public class OrderStatus  extends EmsDto implements Serializable {

    private static final long serialVersionUID = -6801259640957229378L;

    private long id;
    private String code;
    private String description;
    private boolean orderType;
    private Boolean archivable;
   // private Organisation organisation;
    private Boolean devis;
    private Boolean purshaseOrder;
    private Boolean saleOrder;
    private Boolean preparation;
    private Boolean production;
    private Boolean delivery;
    private Boolean reception;
    private Set<SaleOrder> saleOrders;
    private Set<SaleOrderLine> saleOrderLines;
    private Boolean active;

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

    public Set<SaleOrder> getSaleOrders() {
        return saleOrders;
    }

    public void setSaleOrders(Set<SaleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SaleOrderLine> getSaleOrderLines() {
        return saleOrderLines;
    }

    public void setSaleOrderLines(Set<SaleOrderLine> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }



    public boolean isOrderType() {
        return orderType;
    }

    public void setOrderType(boolean orderType) {
        this.orderType = orderType;
    }


    public Boolean getArchivable() {
        return archivable;
    }

    public void setArchivable(Boolean archivable) {
        this.archivable = archivable;
    }



    public Boolean getDevis() {
        return devis;
    }

    public void setDevis(Boolean devis) {
        this.devis = devis;
    }

    public Boolean getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(Boolean purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }

    public Boolean getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(Boolean saleOrder) {
        this.saleOrder = saleOrder;
    }

    public Boolean getPreparation() {
        return preparation;
    }

    public void setPreparation(Boolean preparation) {
        this.preparation = preparation;
    }

    public Boolean getProduction() {
        return production;
    }

    public void setProduction(Boolean production) {
        this.production = production;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getReception() {
        return reception;
    }

    public void setReception(Boolean reception) {
        this.reception = reception;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            OrderStatus obj = (OrderStatus) object;
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