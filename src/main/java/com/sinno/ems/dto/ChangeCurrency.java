package com.sinno.ems.dto;

import java.math.BigDecimal;

/**
 * Created by Enissay on 31/03/2017.
 */
public class ChangeCurrency {
    private long id;
    private Currency currency;
    private BigDecimal value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
