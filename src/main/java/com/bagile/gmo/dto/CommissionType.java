package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommissionType extends EmsDto implements Serializable {
    /**
     *
     */

    private long id;
    private String code;
    private String description;
    private long  minDistance;
    private long  maxDistance;
    private BigDecimal percentage ;
    private List<CommissionDriver> commissions = new ArrayList<>();
    private Owner owner;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(long minDistance) {
        this.minDistance = minDistance;
    }

    public long getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(long maxDistance) {
        this.maxDistance = maxDistance;
    }

    public List<CommissionDriver> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDriver> commissions) {
        this.commissions = commissions;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
