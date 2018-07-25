package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 03/12/2016.
 */
@Entity
@Table(name = "cmd_preparation", uniqueConstraints = @UniqueConstraint(columnNames = "cmd_preparationcode"))
public class CmdPreparation {
    private long cmdPreparationId;
    @NotNull
    private String cmdPreparationCode;
    @NotNull
    private CmdSaleOrder cmdSaleOrder;
    @NotNull
    private CmdAccount cmdAccount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdPreparationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdPreparationCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdPreparationUpdateDate;
    @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private WrhWarehouse wrhWarehouse;
    private Set<CmdPreparationLine> cmdPreparationLines =new HashSet<CmdPreparationLine>();
    private PrmOrderStatus prmOrderStatus;
    private PrmOrderType prmOrderType;
    @NotNull
    private Boolean cmdPreparationActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_preparationwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_emsgc.cmd_preparation_cmd_preparationid_seq", allocationSize = 1)
    @Column(name = "cmd_preparationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdPreparationId() {
        return cmdPreparationId;
    }

    public void setCmdPreparationId(long cmdPreparationId) {
        this.cmdPreparationId = cmdPreparationId;
    }
    @Column(name="cmd_preparationcode")
    public String getCmdPreparationCode() {
        return cmdPreparationCode;
    }

    public void setCmdPreparationCode(String cmdPreparationCode) {
        this.cmdPreparationCode = cmdPreparationCode;
    }

    @ManyToOne
    @JoinColumn(name="cmd_preparationsorderid")
    public CmdSaleOrder getCmdSaleOrder() {
        return cmdSaleOrder;
    }

    public void setCmdSaleOrder(CmdSaleOrder cmdSaleOrder) {
        this.cmdSaleOrder = cmdSaleOrder;
    }
    @ManyToOne
    @JoinColumn(name="cmd_preparationaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="cmd_preparationdate")

    public Date getCmdPreparationDate() {
        return cmdPreparationDate;
    }

    public void setCmdPreparationDate(Date cmdPreparationDate) {
        this.cmdPreparationDate = cmdPreparationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="cmd_preparationcreationdate")
    public Date getCmdPreparationCreationDate() {
        return cmdPreparationCreationDate;
    }

    public void setCmdPreparationCreationDate(Date cmdPreparationCreationDate) {
        this.cmdPreparationCreationDate = cmdPreparationCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="cmd_preparationupdatedate")

    public Date getCmdPreparationUpdateDate() {
        return cmdPreparationUpdateDate;
    }

    public void setCmdPreparationUpdateDate(Date cmdPreparationUpdateDate) {
        this.cmdPreparationUpdateDate = cmdPreparationUpdateDate;
    }
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cmdPreparation", orphanRemoval = true)
    public Set<CmdPreparationLine> getCmdPreparationLines() {
        return cmdPreparationLines;
    }

    public void setCmdPreparationLines(Set<CmdPreparationLine> cmdPreparationLines) {
        this.cmdPreparationLines = cmdPreparationLines;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_preparationorderstatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_preparationordertypeid")
    public PrmOrderType getPrmOrderType() {
        return prmOrderType;
    }

    public void setPrmOrderType(PrmOrderType prmOrderType) {
        this.prmOrderType = prmOrderType;
    }
    @Column(name="cmd_preparationactive",nullable = false)
    public Boolean getCmdPreparationActive() {
        return cmdPreparationActive;
    }

    public void setCmdPreparationActive(Boolean cmdPreparationActive) {
        this.cmdPreparationActive = cmdPreparationActive;
    }
}
