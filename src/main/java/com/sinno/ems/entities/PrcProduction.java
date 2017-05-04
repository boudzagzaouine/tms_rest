package com.sinno.ems.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 03/04/2017.
 */
@Entity
@Table(name = "prc_production")
public class PrcProduction {
    private long prcProductionId;
    private String prcProductionCode;
    private Date prcProductionDate;
    private Date prcProductionCreationDate;
    private Date prcProductionUpdateDate;
    private Set<PrcProductionLine> prcProductionLines = new HashSet<PrcProductionLine>();
    private OwnOwner ownOwner;
    private WrhWarehouse wrhWarehouse;
    private String prcProductionDescription;
    private PrmOrderStatus prmOrderStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prc_production", allocationSize = 1)
    @Column(name = "prc_productionid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrcProductionId() {
        return prcProductionId;
    }

    public void setPrcProductionId(long prcProductionId) {
        this.prcProductionId = prcProductionId;
    }

    @Column(name = "prc_productioncode", nullable = false, unique = true)
    public String getPrcProductionCode() {
        return prcProductionCode;
    }

    public void setPrcProductionCode(String prcProductionCode) {
        this.prcProductionCode = prcProductionCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prc_productiondate")
    public Date getPrcProductionDate() {
        return prcProductionDate;
    }

    public void setPrcProductionDate(Date prcProductionDate) {
        this.prcProductionDate = prcProductionDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prc_productioncreationdate")
    public Date getPrcProductionCreationDate() {
        return prcProductionCreationDate;
    }

    public void setPrcProductionCreationDate(Date prcProductionCreationDate) {
        this.prcProductionCreationDate = prcProductionCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prc_productionupdatedate")
    public Date getPrcProductionUpdateDate() {
        return prcProductionUpdateDate;
    }

    public void setPrcProductionUpdateDate(Date prcProductionUpdateDate) {
        this.prcProductionUpdateDate = prcProductionUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prcProduction", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PrcProductionLine> getPrcProductionLines() {
        return prcProductionLines;
    }

    public void setPrcProductionLines(Set<PrcProductionLine> prcProductionLines) {
        this.prcProductionLines = prcProductionLines;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "prc_productiondescription")
    public String getPrcProductionDescription() {
        return prcProductionDescription;
    }

    public void setPrcProductionDescription(String prcProductionDescription) {
        this.prcProductionDescription = prcProductionDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prc_productionorderstatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }
}
