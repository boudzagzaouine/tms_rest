package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class OrderType  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -361646146477953897L;

    private long id;
    private String code;
    private Date updateDate;
    private Set<SaleOrder> saleOrders;
    private Set<Reception> receptions;
    private Date creationDate;
    private String description;
    private Long flow;
    private Boolean active;
    private Set<PurshaseOrder> purshaseOrders;
    private Organisation organisation;


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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set<SaleOrder> getSaleOrders() {
        return saleOrders;
    }

    public void setSaleOrders(Set<SaleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }

    public Set<Reception> getReceptions() {
        return receptions;
    }

    public void setReceptions(Set<Reception> receptions) {
        this.receptions = receptions;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PurshaseOrder> getPurshaseOrders() {
        return purshaseOrders;
    }

    public void setPurshaseOrders(Set<PurshaseOrder> purshaseOrders) {
        this.purshaseOrders = purshaseOrders;
    }

    public Long getFlow() {
        return flow;
    }

    public void setFlow(Long flow) {
        this.flow = flow;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
            OrderType obj = (OrderType) object;
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