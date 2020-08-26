package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Adil on 3/1/2017.
 */
public class Box extends EmsDto {
    private long id;
    private String code;
    private String description;
    private BigDecimal initAmount = BigDecimal.ZERO;
    private BigDecimal currentAmount = BigDecimal.ZERO;
    private Date creationDate;
    private Date updateDate;
    private Agency agency;
    private Date initDate;
    private User initUser;
    private BigDecimal closureAmount = BigDecimal.ZERO;
    private Date closureDate;
    private Long totalSales = 0L;
    private BigDecimal chequeAmount = BigDecimal.ZERO;
    private BigDecimal especeAmount = BigDecimal.ZERO;
    private BigDecimal creditCardAmount = BigDecimal.ZERO;
    private BigDecimal effetAmount = BigDecimal.ZERO;


    private Long totalCharges = 0L;
    private BigDecimal chargesAmount = BigDecimal.ZERO;
    private User closureUser;
    private Boolean defaultBox;
    private Boolean initialized;

    private BigDecimal unpaidSalesAmount = BigDecimal.ZERO;
    private BigDecimal paidPurchasesAmount = BigDecimal.ZERO;
    private BigDecimal unpaidPurchasesAmount = BigDecimal.ZERO;
    private BigDecimal supplierPurchaseTurnOver = BigDecimal.ZERO;
    private BigDecimal chargePurchaseTurnOver = BigDecimal.ZERO;
    private BigDecimal paidSalesAmount = BigDecimal.ZERO;
    private BigDecimal salesTurnOver = BigDecimal.ZERO;
    private BigDecimal fixedChargeAmount = BigDecimal.ZERO;

    private BigDecimal bankTransfertAmount = BigDecimal.ZERO;

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

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }


    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public User getInitUser() {
        return initUser;
    }

    public void setInitUser(User initUser) {
        this.initUser = initUser;
    }


    public BigDecimal getClosureAmount() {
        return closureAmount;
    }

    public void setClosureAmount(BigDecimal closureAmount) {
        this.closureAmount = closureAmount;
    }

    public Date getClosureDate() {
        return closureDate;
    }

    public void setClosureDate(Date closureDate) {
        this.closureDate = closureDate;
    }


    public BigDecimal getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(BigDecimal chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public BigDecimal getEspeceAmount() {
        return especeAmount;
    }

    public void setEspeceAmount(BigDecimal especeAmount) {
        this.especeAmount = especeAmount;
    }

    public BigDecimal getCreditCardAmount() {
        return creditCardAmount;
    }

    public void setCreditCardAmount(BigDecimal creditCardAmount) {
        this.creditCardAmount = creditCardAmount;
    }

    public BigDecimal getEffetAmount() {
        return effetAmount;
    }

    public void setEffetAmount(BigDecimal effetAmount) {
        this.effetAmount = effetAmount;
    }

    public Long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Long totalSales) {
        this.totalSales = totalSales;
    }

    public Long getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(Long totalCharges) {
        this.totalCharges = totalCharges;
    }

    public BigDecimal getChargesAmount() {
        return chargesAmount;
    }

    public void setChargesAmount(BigDecimal chargesAmount) {
        this.chargesAmount = chargesAmount;
    }

    public User getClosureUser() {
        return closureUser;
    }

    public void setClosureUser(User closureUser) {
        this.closureUser = closureUser;
    }

    public Boolean isDefaultBox() {
        return defaultBox;
    }

    public void setDefaultBox(Boolean defaultBox) {
        this.defaultBox = defaultBox;
    }

    public Boolean getInitialized() {
        return initialized;
    }

    public void setInitialized(Boolean initialized) {
        this.initialized = initialized;
    }

    public BigDecimal getSalesTurnOver() {
        return salesTurnOver;
    }

    public void setSalesTurnOver(BigDecimal salesTurnOver) {
        this.salesTurnOver = salesTurnOver;

    }

    public BigDecimal getPaidSalesAmount() {
        return paidSalesAmount;
    }

    public void setPaidSalesAmount(BigDecimal paidSalesAmount) {
        this.paidSalesAmount = paidSalesAmount;
    }

    public BigDecimal getUnpaidSalesAmount() {
        return unpaidSalesAmount;
    }

    public void setUnpaidSalesAmount(BigDecimal unpaidSalesAmount) {
        this.unpaidSalesAmount = unpaidSalesAmount;
    }

    public BigDecimal getPaidPurchasesAmount() {
        return paidPurchasesAmount;
    }

    public void setPaidPurchasesAmount(BigDecimal paidPurchasesAmount) {
        this.paidPurchasesAmount = paidPurchasesAmount;
    }

    public BigDecimal getSupplierPurchaseTurnOver() {
        return supplierPurchaseTurnOver;
    }

    public void setSupplierPurchaseTurnOver(BigDecimal supplierPurchaseTurnOver) {
        this.supplierPurchaseTurnOver = supplierPurchaseTurnOver;
    }

    public BigDecimal getChargePurchaseTurnOver() {
        return chargePurchaseTurnOver;
    }

    public void setChargePurchaseTurnOver(BigDecimal chargePurchaseTurnOver) {
        this.chargePurchaseTurnOver = chargePurchaseTurnOver;
    }

    public Boolean getDefaultBox() {
        return defaultBox;
    }

    public BigDecimal getUnpaidPurchasesAmount() {
        return unpaidPurchasesAmount;
    }

    public void setUnpaidPurchasesAmount(BigDecimal unpaidPurchasesAmount) {
        this.unpaidPurchasesAmount = unpaidPurchasesAmount;
    }

    public BigDecimal getBankTransfertAmount() {
        return bankTransfertAmount;
    }

    public void setBankTransfertAmount(BigDecimal bankTransfertAmount) {
        this.bankTransfertAmount = bankTransfertAmount;
    }

    public BigDecimal getFixedChargeAmount() {
        return fixedChargeAmount;
    }

    public void setFixedChargeAmount(BigDecimal fixedChargeAmount) {
        this.fixedChargeAmount = fixedChargeAmount;
    }
}
