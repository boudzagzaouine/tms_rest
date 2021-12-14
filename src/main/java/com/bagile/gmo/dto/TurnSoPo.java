package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TurnSoPo extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8747248049547537558L;

    private long id;
    private String code;

    private Turn turn;
    private SaleOrder saleOrder;
    private PurshaseOrder purshaseOrder;
    private List<TurnLine> turnLines = new ArrayList<>();

    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal totalPriceTurn ;
    private  BigDecimal totalQuantity;

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

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public PurshaseOrder getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(PurshaseOrder purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }

    public List<TurnLine> getTurnLines() {
        return turnLines;
    }

    public void setTurnLines(List<TurnLine> turnLines) {
        this.turnLines = turnLines;
    }

    public BigDecimal getTotalPriceTurn() {
        return totalPriceTurn;
    }

    public void setTotalPriceTurn(BigDecimal totalPriceTurn) {
        this.totalPriceTurn = totalPriceTurn;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurnSoPo turnSoPo = (TurnSoPo) o;
        return id == turnSoPo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}