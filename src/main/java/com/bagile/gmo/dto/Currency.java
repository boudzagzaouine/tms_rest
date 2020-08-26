package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 22/12/2016.
 */
public class Currency  extends EmsDto {
    private Long id;
    private String code;
    private String symbol;
    private String description;
    private Date creationDate;
    private Date updateDate;
    private Boolean byDefault;
    private BigDecimal exchangeRate;
    private BigDecimal exchangeRatePurchase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getByDefault() {
        return byDefault;
    }

    public void setByDefault(Boolean byDefault) {
        this.byDefault = byDefault;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRatePurchase() {
        return exchangeRatePurchase;
    }

    public void setExchangeRatePurchase(BigDecimal exchangeRatePurchase) {
        this.exchangeRatePurchase = exchangeRatePurchase;
    }
}
