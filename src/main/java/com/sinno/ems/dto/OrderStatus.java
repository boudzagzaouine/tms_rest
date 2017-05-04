package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Set;

public class OrderStatus implements Serializable {

    private static final long serialVersionUID = -6801259640957229378L;

    private long id;
    private String code;
    private String description;
    private boolean orderType;
    private Boolean archivable;
    private Organisation organisation;
    private Set<SaleOrderArc> saleOrderArcs;
    private Set<SaleOrder> saleOrders;
    private Set<PurshaseOrderArc> purshaseOrderArcs;
    private Set<ReceptionLineArc> receptionLineArcs;
    private Set<PurshaseOrderLineArc> purshaseOrderLineArcs;
    private Set<SaleOrderLineArc> saleOrderLineArcs;
    private Set<SaleOrderLine> saleOrderLines;
    private Set<PurshaseOrder> purshaseOrders;
    private Set<PurshaseOrderLine> purshaseOrderLines;
    private Set<ReceptionLine> receptionLines;

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

    public Set<SaleOrderArc> getSaleOrderArcs() {
        return saleOrderArcs;
    }

    public void setSaleOrderArcs(Set<SaleOrderArc> saleOrderArcs) {
        this.saleOrderArcs = saleOrderArcs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PurshaseOrderArc> getPurshaseOrderArcs() {
        return purshaseOrderArcs;
    }

    public void setPurshaseOrderArcs(Set<PurshaseOrderArc> purshaseOrderArcs) {
        this.purshaseOrderArcs = purshaseOrderArcs;
    }

    public Set<ReceptionLineArc> getReceptionLineArcs() {
        return receptionLineArcs;
    }

    public void setReceptionLineArcs(Set<ReceptionLineArc> receptionLineArcs) {
        this.receptionLineArcs = receptionLineArcs;
    }

    public Set<PurshaseOrderLineArc> getPurshaseOrderLineArcs() {
        return purshaseOrderLineArcs;
    }

    public void setPurshaseOrderLineArcs(Set<PurshaseOrderLineArc> purshaseOrderLineArcs) {
        this.purshaseOrderLineArcs = purshaseOrderLineArcs;
    }

    public Set<SaleOrderLineArc> getSaleOrderLineArcs() {
        return saleOrderLineArcs;
    }

    public void setSaleOrderLineArcs(Set<SaleOrderLineArc> saleOrderLineArcs) {
        this.saleOrderLineArcs = saleOrderLineArcs;
    }

    public Set<SaleOrderLine> getSaleOrderLines() {
        return saleOrderLines;
    }

    public void setSaleOrderLines(Set<SaleOrderLine> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }

    public Set<PurshaseOrder> getPurshaseOrders() {
        return purshaseOrders;
    }

    public void setPurshaseOrders(Set<PurshaseOrder> purshaseOrders) {
        this.purshaseOrders = purshaseOrders;
    }

    public Set<PurshaseOrderLine> getPurshaseOrderLines() {
        return purshaseOrderLines;
    }

    public void setPurshaseOrderLines(Set<PurshaseOrderLine> purshaseOrderLines) {
        this.purshaseOrderLines = purshaseOrderLines;
    }

    public boolean isOrderType() {
        return orderType;
    }

    public void setOrderType(boolean orderType) {
        this.orderType = orderType;
    }

    public Set<ReceptionLine> getReceptionLines() {
        return receptionLines;
    }

    public void setReceptionLines(Set<ReceptionLine> receptionLines) {
        this.receptionLines = receptionLines;
    }

    public Boolean getArchivable() {
        return archivable;
    }

    public void setArchivable(Boolean archivable) {
        this.archivable = archivable;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
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