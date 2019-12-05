package com.bagile.tms.dto;

import java.math.BigDecimal;

public class MaintenaceLine extends EmsDto {

    private long id;
    private Product product;
    private String description;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private MaintenancePlan maintenancePlan;
}
