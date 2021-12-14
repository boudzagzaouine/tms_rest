package com.bagile.gmo.entities;


import com.bagile.gmo.dto.EmsDto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_turnsopo")
public class TmsTurnSoPo extends EmsDto implements Serializable  {


    private Long tmsTurnSoPoeId;
    private String tmsTurnSoPoCode;
    private BigDecimal tmsTurnSoPoTotalPriceHT;
    private BigDecimal tmsTurnSoPoTotalPriceTTC;
    private TmsTurn tmsTurn ;
    private CmdSaleOrder cmdSaleOrder;
    private RcpPurshaseOrder rcpPurshaseOrder;
    private Set<TmsTurnLine> tmsTurnLines = new HashSet<>();

    private BigDecimal tmsTurnSoPoTotalPriceTurn ;
    private  BigDecimal tmsTurnSoPoTotalQuantity;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turnsopo", allocationSize = 1)
    @Column(name = "tms_turnsopoid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTurnSoPoeId() {
        return tmsTurnSoPoeId;
    }

    public void setTmsTurnSoPoeId(Long tmsTurnSoPoeId) {
        this.tmsTurnSoPoeId = tmsTurnSoPoeId;
    }

    @Column(name = "tms_turnsopocode")
    public String getTmsTurnSoPoCode() {
        return tmsTurnSoPoCode;
    }

    public void setTmsTurnSoPoCode(String tmsTurnSoPoCode) {
        this.tmsTurnSoPoCode = tmsTurnSoPoCode;
    }

    @Column(name = "tms_turnsopototalpriceht")
    public BigDecimal getTmsTurnSoPoTotalPriceHT() {
        return tmsTurnSoPoTotalPriceHT;
    }

    public void setTmsTurnSoPoTotalPriceHT(BigDecimal tmsTurnSoPoTotalPriceHT) {
        this.tmsTurnSoPoTotalPriceHT = tmsTurnSoPoTotalPriceHT;
    }


    @Column(name = "tms_turnsopototalpricettc")
    public BigDecimal getTmsTurnSoPoTotalPriceTTC() {
        return tmsTurnSoPoTotalPriceTTC;
    }

    public void setTmsTurnSoPoTotalPriceTTC(BigDecimal tmsTurnSoPoTotalPriceTTC) {
        this.tmsTurnSoPoTotalPriceTTC = tmsTurnSoPoTotalPriceTTC;
    }

    @Column(name = "tms_turnsopototalpriceturn")
    public BigDecimal getTmsTurnSoPoTotalPriceTurn() {
        return tmsTurnSoPoTotalPriceTurn;
    }

    public void setTmsTurnSoPoTotalPriceTurn(BigDecimal tmsTurnSoPoTotalPriceTurn) {
        this.tmsTurnSoPoTotalPriceTurn = tmsTurnSoPoTotalPriceTurn;
    }

    @Column(name = "tms_turnsopototalquanity")
    public BigDecimal getTmsTurnSoPoTotalQuantity() {
        return tmsTurnSoPoTotalQuantity;
    }

    public void setTmsTurnSoPoTotalQuantity(BigDecimal tmsTurnSoPoTotalQuantity) {
        this.tmsTurnSoPoTotalQuantity = tmsTurnSoPoTotalQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turnsopoturnid")
    public TmsTurn getTmsTurn() {
        return tmsTurn;
    }

    public void setTmsTurn(TmsTurn tmsTurn) {
        this.tmsTurn = tmsTurn;
    }

  
   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_turnlinesaleorderid")
    public CmdSaleOrder getCmdSaleOrder() {
        return this.cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_turnlinepurchaseorderid")
    public RcpPurshaseOrder getRcpPurshaseOrder() {
        return rcpPurshaseOrder;
    }

    public void setRcpPurshaseOrder(RcpPurshaseOrder rcpPurshaseOrder) {
        this.rcpPurshaseOrder = rcpPurshaseOrder;
    }

    @OneToMany(mappedBy = "tmsTurnSoPo",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<TmsTurnLine> getTmsTurnLines() {
        return tmsTurnLines;
    }

    public void setTmsTurnLines(Set<TmsTurnLine> tmsTurnLines) {
        this.tmsTurnLines = tmsTurnLines;
    }
}

