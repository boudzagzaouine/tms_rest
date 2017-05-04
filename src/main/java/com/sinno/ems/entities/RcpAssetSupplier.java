package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "rcp_assetsupplier")
public class RcpAssetSupplier {
    private long rcpAssetId;
    @NotNull
    private String rcpAssetCode;
    @NotNull
    private BigDecimal rcpAssetAmount;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpBeginDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpExpirationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpUpdateDate;
    @NotNull
    private Boolean rcpUsed;
    @NotNull
    private RcpPurshaseOrder rcpPurshaseOrder;
    @NotNull
    private PrmCurrency prmCurrency;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "rcp_rcpassetsupplier_rcp_rcpassetsupplierid_seq", allocationSize = 1)
    @Column(name = "rcp_assetsupplierid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getRcpAssetId() {
        return rcpAssetId;
    }

    public void setRcpAssetId(long rcpAssetId) {
        this.rcpAssetId = rcpAssetId;
    }

    @Column(name = "rcp_assetsuppliercode", nullable = false)
    public String getRcpAssetCode() {
        return rcpAssetCode;
    }

    public void setRcpAssetCode(String rcpAssetCode) {
        this.rcpAssetCode = rcpAssetCode;
    }

    @Column(name = "rcp_assetsupplieramount", precision = 12, scale = 0, nullable = false)
    public BigDecimal getRcpAssetAmount() {
        return rcpAssetAmount;
    }

    public void setRcpAssetAmount(BigDecimal rcpAssetAmount) {
        this.rcpAssetAmount = rcpAssetAmount;
    }

    @Column(name = "rcp_begindate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getRcpBeginDate() {
        return rcpBeginDate;
    }

    public void setRcpBeginDate(Date rcpBeginDate) {
        this.rcpBeginDate = rcpBeginDate;
    }

    @Column(name = "rcp_expirationdate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getRcpExpirationDate() {
        return rcpExpirationDate;
    }

    public void setRcpExpirationDate(Date rcpExpirationDate) {
        this.rcpExpirationDate = rcpExpirationDate;
    }

    @Column(name = "rcp_assetsuppliercreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRcpCreationDate() {
        return rcpCreationDate;
    }

    public void setRcpCreationDate(Date rcpCreationDate) {
        this.rcpCreationDate = rcpCreationDate;
    }

    @Column(name = "rcp_assetsupplierupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRcpUpdateDate() {
        return rcpUpdateDate;
    }

    public void setRcpUpdateDate(Date rcpUpdateDate) {
        this.rcpUpdateDate = rcpUpdateDate;
    }

    @Column(name = "rcp_assetsupplierisused", nullable = false)
    public Boolean getRcpUsed() {
        return rcpUsed;
    }

    public void setRcpUsed(Boolean rcpUsed) {
        this.rcpUsed = rcpUsed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_assetsupplierpurshaseorderid", nullable = false)
    public RcpPurshaseOrder getRcpPurshaseOrder() {
        return rcpPurshaseOrder;
    }

    public void setRcpPurshaseOrder(RcpPurshaseOrder rcpSaleOrder) {
        this.rcpPurshaseOrder = rcpSaleOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_assetsuppliercurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }


}