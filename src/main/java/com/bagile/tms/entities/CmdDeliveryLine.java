package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 21/04/2016.
 */

@Entity
@Table(name = "cmd_deliveryline")

public class CmdDeliveryLine {
    private long cmdDeliveryLineId;
    @Max(999999999)
    private Long cmdDeliveryLinelineNumber;
    private CmdSaleOrderLine cmdSaleOrderLine;
    @NotNull
    private PdtProduct pdtProduct;
    @Size(max = 255)
    private String cmdDeliveryLineProductDescription;
    @NotNull
    @Max(999999999)
    private BigDecimal cmdDeliveryLineOrderQuantity;
    private PdtUom pdtUom;
    @Max(999999999)
    private BigDecimal cmdDeliveryLineQuantityServed;
    @NotNull
    private WrhWarehouse wrhWarehouse;

    private StkContainer cmdDeliveryLineContainer;

    private PrmOrderStatus prmOrderStatus;

    private String cmdDeliveryLineComment;
    @NotNull
    private OwnOwner ownOwner;
    private CmdDelivery cmdDelivery;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDeliveryLineUpdateDate;

    private String cmdDeliveryLineContainerCode;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_deliveryline", allocationSize = 1)
    @Column(name = "cmd_deliverylineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdDeliveryLineId() {
        return cmdDeliveryLineId;
    }

    public void setCmdDeliveryLineId(long cmdDeliveryLineId) {
        this.cmdDeliveryLineId = cmdDeliveryLineId;
    }

    public Long getCmdDeliveryLinelineNumber() {
        return cmdDeliveryLinelineNumber;
    }

    public void setCmdDeliveryLinelineNumber(Long cmdDeliveryLinelineNumber) {
        this.cmdDeliveryLinelineNumber = cmdDeliveryLinelineNumber;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinesaleorderlineid", nullable = false)
    public CmdSaleOrderLine getCmdSaleOrderLine() {
        return cmdSaleOrderLine;
    }

    public void setCmdSaleOrderLine(CmdSaleOrderLine cmdSaleOrderLine) {
        this.cmdSaleOrderLine = cmdSaleOrderLine;
    }

    @Column(name = "cmd_deliverylinedescription")
    public String getCmdDeliveryLineProductDescription() {
        return cmdDeliveryLineProductDescription;
    }

    public void setCmdDeliveryLineProductDescription(String cmdDeliveryLineProductDescription) {
        this.cmdDeliveryLineProductDescription = cmdDeliveryLineProductDescription;
    }
    @Column(name = "cmd_deliverylinequantity", nullable = false, precision = 12, scale = 5)
    public BigDecimal getCmdDeliveryLineOrderQuantity() {
        return cmdDeliveryLineOrderQuantity;
    }

    public void setCmdDeliveryLineOrderQuantity(BigDecimal cmdDeliveryLineOrderQuantity) {
        this.cmdDeliveryLineOrderQuantity = cmdDeliveryLineOrderQuantity;
    }


    @Column(name = "cmd_deliveryquantityserved", precision = 12, scale = 5)
    public BigDecimal getCmdDeliveryLineQuantityServed() {
        return cmdDeliveryLineQuantityServed;
    }

    public void setCmdDeliveryLineQuantityServed(BigDecimal cmdDeliveryLineQuantityServed) {
        this.cmdDeliveryLineQuantityServed = cmdDeliveryLineQuantityServed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinecontainerid")
    public StkContainer getCmdDeliveryLineContainer() {
        return cmdDeliveryLineContainer;
    }

    public void setCmdDeliveryLineContainer(StkContainer cmdDeliveryLineContainer) {
        this.cmdDeliveryLineContainer = cmdDeliveryLineContainer;
    }


    @Column(name = "cmd_deliverylinecomment", length = 255)
    public String getCmdDeliveryLineComment() {
        return cmdDeliveryLineComment;
    }

    public void setCmdDeliveryLineComment(String cmdDeliveryLineComment) {
        this.cmdDeliveryLineComment = cmdDeliveryLineComment;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinewarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylinestatusid", nullable = false)
    public PrmOrderStatus getPrmOrderStatus() {
        return prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deliverylineownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_deliverylinecreationdate")
    public Date getCmdDeliveryLineCreationDate() {
        return cmdDeliveryLineCreationDate;
    }

    public void setCmdDeliveryLineCreationDate(Date cmdDeliveryLineCreationDate) {
        this.cmdDeliveryLineCreationDate = cmdDeliveryLineCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_deliverylineupdatedate")
    public Date getCmdDeliveryLineUpdateDate() {
        return cmdDeliveryLineUpdateDate;
    }

    public void setCmdDeliveryLineUpdateDate(Date cmdDeliveryLineUpdateDate) {
        this.cmdDeliveryLineUpdateDate = cmdDeliveryLineUpdateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_deliverylinedeliveryid",nullable = false)
    public CmdDelivery getCmdDelivery() {
        return cmdDelivery;
    }

    public void setCmdDelivery(CmdDelivery cmdDelivery) {
        this.cmdDelivery = cmdDelivery;
    }
    @Column(name = "cmd_deliverylinecontainercode" )

    public String getCmdDeliveryLineContainerCode() {
        return cmdDeliveryLineContainerCode;
    }

    public void setCmdDeliveryLineContainerCode(String cmdDeliveryLineContainerCode) {
        this.cmdDeliveryLineContainerCode = cmdDeliveryLineContainerCode;
    }

}
