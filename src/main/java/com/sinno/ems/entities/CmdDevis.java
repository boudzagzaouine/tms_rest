package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 06/12/2016.
 */
@Entity
@Table(name = "cmd_devis", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cmd_deviscode")})
public class CmdDevis implements Serializable {

    private long cmdDevisId;
    private CmdAccount cmdAccount;
    @NotNull
    private OwnOwner ownOwner;
    private AdrAddress adrAddressByCmdDevisDeliveryAddressId;
    private PrmOrderStatus prmOrderStatus;
    private PrmOrderType prmOrderType;
    @Size(max = 30)
    @NotNull
    private String cmdDevisCode;
    @Size(max = 255)
    private String cmdDevisRemarks;
    @Size(max = 30)
    private String cmdDevisCustomerCode;
    @Size(max = 255)
    private String cmdDevisDescription;
    private Short cmdDevisContainers;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDevisExpectedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDevisCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdDevisUpdateDate;

    private Long cmdDevisNumberLine;
    private Long cmdDevisNumberLineCmd;
    private BigDecimal cmdDevisDiscount;
    private UsrUser usrUser;
    private BigDecimal cmdDevisVersion;
    private BigDecimal cmdDevisTotalPriceHT;
    private BigDecimal cmdDevisTotalPriceTTC;
    private PrmCurrency prmCurrency;
    private BigDecimal cmdDevisVat;


    private Set<CmdDevisLine> cmdDevisLines = new HashSet<CmdDevisLine>(
            0);


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_devis", allocationSize = 1)
    @Column(name = "cmd_devisid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdDevisId() {
        return this.cmdDevisId;
    }

    public void setCmdDevisId(long cmdDevisId) {
        this.cmdDevisId = cmdDevisId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devisaccountid")
    public CmdAccount getCmdAccount() {
        return this.cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devisownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devisdeliveryaddressid")
    public AdrAddress getAdrAddressByCmdDevisDeliveryAddressId() {
        return this.adrAddressByCmdDevisDeliveryAddressId;
    }

    public void setAdrAddressByCmdDevisDeliveryAddressId(
            AdrAddress adrAddressByCmdDevisDeliveryAddressId) {
        this.adrAddressByCmdDevisDeliveryAddressId = adrAddressByCmdDevisDeliveryAddressId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devisstatusid")
    public PrmOrderStatus getPrmOrderStatus() {
        return this.prmOrderStatus;
    }

    public void setPrmOrderStatus(PrmOrderStatus prmOrderStatus) {
        this.prmOrderStatus = prmOrderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_devistypeid", nullable = false)
    public PrmOrderType getPrmOrderType() {
        return this.prmOrderType;
    }

    public void setPrmOrderType(PrmOrderType prmOrderType) {
        this.prmOrderType = prmOrderType;
    }



    @Column(name = "cmd_deviscode", unique = true, nullable = false, length = 30)
    public String getCmdDevisCode() {
        return this.cmdDevisCode;
    }

    public void setCmdDevisCode(String cmdDevisCode) {
        this.cmdDevisCode = cmdDevisCode;
    }

    @Column(name = "cmd_devisnumberline")
    public Long getCmdDevisNumberLine() {
        return cmdDevisNumberLine;
    }

    public void setCmdDevisNumberLine(Long cmdDevisNumberLine) {
        this.cmdDevisNumberLine = cmdDevisNumberLine;
    }

    @Column(name = "cmd_devisnumberlinecmd")
    public Long getCmdDevisNumberLineCmd() {
        return cmdDevisNumberLineCmd;
    }

    public void setCmdDevisNumberLineCmd(Long cmdDevisNumberLineCmd) {
        this.cmdDevisNumberLineCmd = cmdDevisNumberLineCmd;
    }

    @Column(name = "cmd_devisRemarks")
    public String getCmdDevisRemarks() {
        return this.cmdDevisRemarks;
    }

    public void setCmdDevisRemarks(String cmdDevisRemarks) {
        this.cmdDevisRemarks = cmdDevisRemarks;
    }

    @Column(name = "cmd_deviscustomercode", length = 30)
    public String getCmdDevisCustomerCode() {
        return this.cmdDevisCustomerCode;
    }

    public void setCmdDevisCustomerCode(String cmdDevisCustomerCode) {
        this.cmdDevisCustomerCode = cmdDevisCustomerCode;
    }

    @Column(name = "cmd_devisdescription")
    public String getCmdDevisDescription() {
        return this.cmdDevisDescription;
    }

    public void setCmdDevisDescription(String cmdDevisDescription) {
        this.cmdDevisDescription = cmdDevisDescription;
    }



    @Column(name = "cmd_deviscontainers", precision = 4, scale = 0)
    public Short getCmdDevisContainers() {
        return this.cmdDevisContainers;
    }

    public void setCmdDevisContainers(Short cmdDevisContainers) {
        this.cmdDevisContainers = cmdDevisContainers;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cmd_devisexpecteddate", length = 13)
    public Date getCmdDevisExpectedDate() {
        return this.cmdDevisExpectedDate;
    }

    public void setCmdDevisExpectedDate(Date cmdDevisExpectedDate) {
        this.cmdDevisExpectedDate = cmdDevisExpectedDate;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_deviscreationdate")
    public Date getCmdDevisCreationDate() {
        return this.cmdDevisCreationDate;
    }

    public void setCmdDevisCreationDate(Date cmdDevisCreationDate) {
        this.cmdDevisCreationDate = cmdDevisCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_devisupdatedate")
    public Date getCmdDevisUpdateDate() {
        return this.cmdDevisUpdateDate;
    }

    public void setCmdDevisUpdateDate(Date cmdDevisUpdateDate) {
        this.cmdDevisUpdateDate = cmdDevisUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cmdDevis", orphanRemoval = true)
    public Set<CmdDevisLine> getCmdDevisLines() {
        return this.cmdDevisLines;
    }

    public void setCmdDevisLines(Set<CmdDevisLine> cmdDevisLines) {
        this.cmdDevisLines = cmdDevisLines;
    }


    @Column(name = "cmd_devisdiscount", scale = 5, precision = 10)

    public BigDecimal getCmdDevisDiscount() {
        return cmdDevisDiscount;
    }

    public void setCmdDevisDiscount(BigDecimal cmdDevisDiscount) {
        this.cmdDevisDiscount = cmdDevisDiscount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_deviscommercialid")
    public UsrUser getUsrUser() {
        return usrUser;
    }

    public void setUsrUser(UsrUser usrUser) {
        this.usrUser = usrUser;
    }

    @Column(name = "cmd_devisversion")
    public BigDecimal getCmdDevisVersion() {
        return cmdDevisVersion;
    }

    public void setCmdDevisVersion(BigDecimal cmdDevisVersion) {
        this.cmdDevisVersion = cmdDevisVersion;
    }
    @Column(name="cmd_devispriceht")
    public BigDecimal getCmdDevisTotalPriceHT() {
        return cmdDevisTotalPriceHT;
    }

    public void setCmdDevisTotalPriceHT(BigDecimal cmdDevisTotalPriceHT) {
        this.cmdDevisTotalPriceHT = cmdDevisTotalPriceHT;
    }
    @Column(name="cmd_devispricettc")

    public BigDecimal getCmdDevisTotalPriceTTC() {
        return cmdDevisTotalPriceTTC;
    }

    public void setCmdDevisTotalPriceTTC(BigDecimal cmdDevisTotalPriceTTC) {
        this.cmdDevisTotalPriceTTC = cmdDevisTotalPriceTTC;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cmd_deviscurrencyid")
    public PrmCurrency getPrmCurrency() {
        return prmCurrency;
    }

    public void setPrmCurrency(PrmCurrency prmCurrency) {
        this.prmCurrency = prmCurrency;
    }

    @Column(name = "cmd_devisVat")
    public BigDecimal getCmdDevisVat() {
        return cmdDevisVat;
    }

    public void setCmdDevisVat(BigDecimal cmdDevisVat) {
        this.cmdDevisVat = cmdDevisVat;
    }
}
