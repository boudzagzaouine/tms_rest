package com.bagile.tms.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * StkContainer generated by hbm2java
 */
@Entity
@Table(name = "stk_container", uniqueConstraints = {
        @UniqueConstraint(columnNames = "stk_containercode")})
public class StkContainer implements java.io.Serializable {

    private long stkContainerId;
    @NotNull
    private LocLocation locLocation;
    @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private WrhWarehouse wrhWarehouse;
    @Size(max = 30)
    @NotNull
    private String stkContainerCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerReceptionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerUpdateDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkContainerOutBoundDate;
    @Size(max = 255)
    private String stkContainerVariable1;
    @Size(max = 255)
    private String stkContainerVariable2;
    @Size(max = 255)
    private String stkContainerVariable3;
    @Size(max = 255)
    private String stkContainerVariable4;
    @Size(max = 255)
    private String stkContainerVariable5;
    @Size(max = 255)
    private String stkContainerVariable6;
    @Size(max = 255)
    private String stkContainerVariable7;
    @Size(max = 255)
    private String stkContainerVariable8;
    @Size(max = 255)
    private String stkContainerVariable9;
    @Size(max = 255)
    private String stkContainerVariable10;
    private Set<CmdDeliveryLine> cmdDeliveryLines=new HashSet<CmdDeliveryLine>(
            0);
    private Set<CmdSaleOrderStock> cmdSaleOrderStocks = new HashSet<CmdSaleOrderStock>(
            0);
    private Set<CmdSaleOrderStockArc> cmdSaleOrderStockArcs = new HashSet<CmdSaleOrderStockArc>(
            0);
    private Set<StkStockArc> stkStockArcs = new HashSet<StkStockArc>(0);
    private Set<StkStock> stkStocks = new HashSet<StkStock>(0);

    public StkContainer() {
    }

    public StkContainer(long stkContainerId, OwnOwner ownOwner,
                        WrhWarehouse wrhWarehouse, String stkContainerCode) {
        this.stkContainerId = stkContainerId;
        this.ownOwner = ownOwner;
        this.wrhWarehouse = wrhWarehouse;
        this.stkContainerCode = stkContainerCode;
    }

    public StkContainer(long stkContainerId, LocLocation locLocation,
                        OwnOwner ownOwner, WrhWarehouse wrhWarehouse,
                        String stkContainerCode, Date stkContainerReceptionDate,
                        Date stkContainerCreationDate, Date stkContainerUpdateDate,
                        String stkContainerVariable1, String stkContainerVariable2,
                        String stkContainerVariable3, String stkContainerVariable4,
                        String stkContainerVariable5, String stkContainerVariable6,
                        String stkContainerVariable7, String stkContainerVariable8,
                        String stkContainerVariable9, String stkContainerVariable10,
                        Set<CmdSaleOrderStock> cmdSaleOrderStocks,
                        Set<CmdSaleOrderStockArc> cmdSaleOrderStockArcs,
                        Set<StkStockArc> stkStockArcs, Set<StkStock> stkStocks) {
        this.stkContainerId = stkContainerId;
        this.locLocation = locLocation;
        this.ownOwner = ownOwner;
        this.wrhWarehouse = wrhWarehouse;
        this.stkContainerCode = stkContainerCode;
        this.stkContainerReceptionDate = stkContainerReceptionDate;
        this.stkContainerCreationDate = stkContainerCreationDate;
        this.stkContainerUpdateDate = stkContainerUpdateDate;
        this.stkContainerVariable1 = stkContainerVariable1;
        this.stkContainerVariable2 = stkContainerVariable2;
        this.stkContainerVariable3 = stkContainerVariable3;
        this.stkContainerVariable4 = stkContainerVariable4;
        this.stkContainerVariable5 = stkContainerVariable5;
        this.stkContainerVariable6 = stkContainerVariable6;
        this.stkContainerVariable7 = stkContainerVariable7;
        this.stkContainerVariable8 = stkContainerVariable8;
        this.stkContainerVariable9 = stkContainerVariable9;
        this.stkContainerVariable10 = stkContainerVariable10;
        this.cmdSaleOrderStocks = cmdSaleOrderStocks;
        this.cmdSaleOrderStockArcs = cmdSaleOrderStockArcs;
        this.stkStockArcs = stkStockArcs;
        this.stkStocks = stkStocks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_stk_container", allocationSize = 1)
    @Column(name = "stk_containerid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getStkContainerId() {
        return this.stkContainerId;
    }

    public void setStkContainerId(long stkContainerId) {
        this.stkContainerId = stkContainerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_containerlocationid")
    public LocLocation getLocLocation() {
        return this.locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_containerownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_containerwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "stk_containercode", unique = true, nullable = false, length = 30)
    public String getStkContainerCode() {
        return this.stkContainerCode;
    }

    public void setStkContainerCode(String stkContainerCode) {
        this.stkContainerCode = stkContainerCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_containerreceptiondate")
    public Date getStkContainerReceptionDate() {
        return this.stkContainerReceptionDate;
    }

    public void setStkContainerReceptionDate(Date stkContainerReceptionDate) {
        this.stkContainerReceptionDate = stkContainerReceptionDate;
    }

    @Column(name = "stk_containercreationdate", precision = 10, scale = 0)
    public Date getStkContainerCreationDate() {
        return this.stkContainerCreationDate;
    }

    public void setStkContainerCreationDate(Date stkContainerCreationDate) {
        this.stkContainerCreationDate = stkContainerCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_containerupdatedate")
    public Date getStkContainerUpdateDate() {
        return this.stkContainerUpdateDate;
    }

    public void setStkContainerUpdateDate(Date stkContainerUpdateDate) {
        this.stkContainerUpdateDate = stkContainerUpdateDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_containeroutbounddate")
    public Date getStkContainerOutBoundDate() {
		return stkContainerOutBoundDate;
	}

	public void setStkContainerOutBoundDate(Date stkContainerOutBoundDate) {
		this.stkContainerOutBoundDate = stkContainerOutBoundDate;
	}

	@Column(name = "stk_containervariable1")
    public String getStkContainerVariable1() {
        return this.stkContainerVariable1;
    }

    public void setStkContainerVariable1(String stkContainerVariable1) {
        this.stkContainerVariable1 = stkContainerVariable1;
    }

    @Column(name = "stk_containervariable2")
    public String getStkContainerVariable2() {
        return this.stkContainerVariable2;
    }

    public void setStkContainerVariable2(String stkContainerVariable2) {
        this.stkContainerVariable2 = stkContainerVariable2;
    }

    @Column(name = "stk_containervariable3")
    public String getStkContainerVariable3() {
        return this.stkContainerVariable3;
    }

    public void setStkContainerVariable3(String stkContainerVariable3) {
        this.stkContainerVariable3 = stkContainerVariable3;
    }

    @Column(name = "stk_containervariable4")
    public String getStkContainerVariable4() {
        return this.stkContainerVariable4;
    }

    public void setStkContainerVariable4(String stkContainerVariable4) {
        this.stkContainerVariable4 = stkContainerVariable4;
    }

    @Column(name = "stk_containervariable5")
    public String getStkContainerVariable5() {
        return this.stkContainerVariable5;
    }

    public void setStkContainerVariable5(String stkContainerVariable5) {
        this.stkContainerVariable5 = stkContainerVariable5;
    }

    @Column(name = "stk_containervariable6")
    public String getStkContainerVariable6() {
        return this.stkContainerVariable6;
    }

    public void setStkContainerVariable6(String stkContainerVariable6) {
        this.stkContainerVariable6 = stkContainerVariable6;
    }

    @Column(name = "stk_containervariable7")
    public String getStkContainerVariable7() {
        return this.stkContainerVariable7;
    }

    public void setStkContainerVariable7(String stkContainerVariable7) {
        this.stkContainerVariable7 = stkContainerVariable7;
    }

    @Column(name = "stk_containervariable8")
    public String getStkContainerVariable8() {
        return this.stkContainerVariable8;
    }

    public void setStkContainerVariable8(String stkContainerVariable8) {
        this.stkContainerVariable8 = stkContainerVariable8;
    }

    @Column(name = "stk_containervariable9")
    public String getStkContainerVariable9() {
        return this.stkContainerVariable9;
    }

    public void setStkContainerVariable9(String stkContainerVariable9) {
        this.stkContainerVariable9 = stkContainerVariable9;
    }

    @Column(name = "stk_containervariable10")
    public String getStkContainerVariable10() {
        return this.stkContainerVariable10;
    }

    public void setStkContainerVariable10(String stkContainerVariable10) {
        this.stkContainerVariable10 = stkContainerVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stkContainer")
    public Set<CmdSaleOrderStock> getCmdSaleOrderStocks() {
        return this.cmdSaleOrderStocks;
    }

    public void setCmdSaleOrderStocks(Set<CmdSaleOrderStock> cmdSaleOrderStocks) {
        this.cmdSaleOrderStocks = cmdSaleOrderStocks;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stkContainer")
    public Set<CmdSaleOrderStockArc> getCmdSaleOrderStockArcs() {
        return this.cmdSaleOrderStockArcs;
    }

    public void setCmdSaleOrderStockArcs(
            Set<CmdSaleOrderStockArc> cmdSaleOrderStockArcs) {
        this.cmdSaleOrderStockArcs = cmdSaleOrderStockArcs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stkContainer")
    public Set<StkStockArc> getStkStockArcs() {
        return this.stkStockArcs;
    }

    public void setStkStockArcs(Set<StkStockArc> stkStockArcs) {
        this.stkStockArcs = stkStockArcs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stkContainer")
    public Set<StkStock> getStkStocks() {
        return this.stkStocks;
    }

    public void setStkStocks(Set<StkStock> stkStocks) {
        this.stkStocks = stkStocks;
    }



    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cmdDeliveryLineContainer")

    public Set<CmdDeliveryLine> getCmdDeliveryLines() {
        return cmdDeliveryLines;
    }

    public void setCmdDeliveryLines(Set<CmdDeliveryLine> cmdDeliveryLines) {
        this.cmdDeliveryLines = cmdDeliveryLines;
    }
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            StkContainer obj = (StkContainer) object;
            if (this.getStkContainerId() == obj.getStkContainerId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.getStkContainerId();
        hash = 7 * hash + (int) this.getStkContainerId();
        return hash;
    }

}
