package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class ContainerType extends EmsDto {
    private long id;
    private String code;
    private String description;
    private Date creationDate;
    private Date updateDate;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal length;
    private BigDecimal maxWeight;
    private BigDecimal weight;
    private Boolean active;
    private Boolean defaultForReception=false;
    private Boolean defaultForPreparation=false;
    private Boolean palette;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Boolean getDefaultForReception() {
        return defaultForReception;
    }

    public void setDefaultForReception(Boolean defaultForReception) {
        this.defaultForReception = defaultForReception;
    }

    public Boolean getDefaultForPreparation() {
        return defaultForPreparation;
    }

    public void setDefaultForPreparation(Boolean defaultForPreparation) {
        this.defaultForPreparation = defaultForPreparation;
    }

    public Boolean getPalette() {
        return palette;
    }

    public void setPalette(Boolean palette) {
        this.palette = palette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerType that = (ContainerType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
