package com.sinno.ems.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * CmdAccount generated by hbm2java
 */
@Entity
@Table(name = "cmd_account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cmd_accountcode")})
public class CmdAccount implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8407687683333368760L;
    private long cmdAccountId;
    private CmdCompany cmdCompany;
    @NotNull
    private OwnOwner ownOwner;

    @NotNull
    private AdrAddress adrAddressByCmdAccountDeliveryAddressId;
    private TrpTransport trpTransport;
    @NotNull
    private PrmContact prmContact;
    @NotNull
    @Size(max = 30)
    private String cmdAccountCode;
    @Size(max = 255)
    private String cmdAccountComment;
    @Size(max = 1000)
    private String cmdAccountTerms;
    @NotNull
    private Boolean cmdAccountIsActive;

    //TODO
    @Size(max = 255)
    private String cmdAccountDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdAccountCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdAccountUpdateDate;

    @Size(max = 255)
    private String cmdAccountVariable1;
    @Size(max = 255)
    private String cmdAccountVariable2;
    @Size(max = 255)
    private String cmdAccountVariable3;
    @Size(max = 255)
    private String cmdAccountVariable4;
    @Size(max = 255)
    private String cmdAccountVariable5;
    @Size(max = 255)
    private String cmdAccountVariable6;
    @Size(max = 255)
    private String cmdAccountVariable7;
    @Size(max = 255)
    private String cmdAccountVariable8;
    @Size(max = 255)
    private String cmdAccountVariable9;
    @Size(max = 255)
    private String cmdAccountVariable10;
    private String cmdAccountName;
    private InvInvoiceTerm invInvoiceTerm;
    private String cmdAccountPassword;

    private Set<StkStockReserved> stkStockReserveds = new HashSet<StkStockReserved>(
            0);
    private Set<CmdSaleOrder> cmdSaleOrders = new HashSet<CmdSaleOrder>(0);
    private Set<CmdSaleOrderArc> cmdSaleOrderArcs = new HashSet<CmdSaleOrderArc>(
            0);


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_account", allocationSize = 1)
    @Column(name = "cmd_accountid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdAccountId() {
        return this.cmdAccountId;
    }

    public void setCmdAccountId(long cmdAccountId) {
        this.cmdAccountId = cmdAccountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_accountcompanyid")
    public CmdCompany getCmdCompany() {
        return this.cmdCompany;
    }

    public void setCmdCompany(CmdCompany cmdCompany) {
        this.cmdCompany = cmdCompany;
    }

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "cmd_accountcontactid", nullable = false)
    public PrmContact getPrmContact() {
        return prmContact;
    }

    public void setPrmContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_accountownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_accountdeliveryaddressid", nullable = false)
    public AdrAddress getAdrAddressByCmdAccountDeliveryAddressId() {
        return this.adrAddressByCmdAccountDeliveryAddressId;
    }

    public void setAdrAddressByCmdAccountDeliveryAddressId(
            AdrAddress adrAddressByCmdAccountDeliveryAddressId) {
        this.adrAddressByCmdAccountDeliveryAddressId = adrAddressByCmdAccountDeliveryAddressId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_accounttransportid")
    public TrpTransport getTrpTransport() {
        return this.trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @Column(name = "cmd_accountdescription")
    public String getCmdAccountDescription() {
        return cmdAccountDescription;
    }

    public void setCmdAccountDescription(String cmdAccountDescription) {
        this.cmdAccountDescription = cmdAccountDescription;
    }

    @Column(name = "cmd_accountcode", unique = true, nullable = false, length = 30)
    public String getCmdAccountCode() {
        return this.cmdAccountCode;
    }

    public void setCmdAccountCode(String cmdAccountCode) {
        this.cmdAccountCode = cmdAccountCode;
    }


    @Column(name = "cmd_accountcomment")
    public String getCmdAccountComment() {
        return this.cmdAccountComment;
    }

    public void setCmdAccountComment(String cmdAccountComment) {
        this.cmdAccountComment = cmdAccountComment;
    }

    @Column(name = "cmd_accountterms", length = 1000)
    public String getCmdAccountTerms() {
        return this.cmdAccountTerms;
    }

    public void setCmdAccountTerms(String cmdAccountTerms) {
        this.cmdAccountTerms = cmdAccountTerms;
    }

    @Column(name = "cmd_accountisactive", nullable = false)
    public Boolean getCmdAccountIsActive() {
        return this.cmdAccountIsActive;
    }

    public void setCmdAccountIsActive(Boolean cmdAccountIsActive) {
        this.cmdAccountIsActive = cmdAccountIsActive;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_accountcreationdate")
    public Date getCmdAccountCreationDate() {
        return this.cmdAccountCreationDate;
    }

    public void setCmdAccountCreationDate(Date cmdAccountCreationDate) {
        this.cmdAccountCreationDate = cmdAccountCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_accountupdatedate")
    public Date getCmdAccountUpdateDate() {
        return this.cmdAccountUpdateDate;
    }

    public void setCmdAccountUpdateDate(Date cmdAccountUpdateDate) {
        this.cmdAccountUpdateDate = cmdAccountUpdateDate;
    }

    @Column(name = "cmd_accountvariable1")
    public String getCmdAccountVariable1() {
        return this.cmdAccountVariable1;
    }

    public void setCmdAccountVariable1(String cmdAccountVariable1) {
        this.cmdAccountVariable1 = cmdAccountVariable1;
    }

    @Column(name = "cmd_accountvariable2")
    public String getCmdAccountVariable2() {
        return this.cmdAccountVariable2;
    }

    public void setCmdAccountVariable2(String cmdAccountVariable2) {
        this.cmdAccountVariable2 = cmdAccountVariable2;
    }

    @Column(name = "cmd_accountvariable3")
    public String getCmdAccountVariable3() {
        return this.cmdAccountVariable3;
    }

    public void setCmdAccountVariable3(String cmdAccountVariable3) {
        this.cmdAccountVariable3 = cmdAccountVariable3;
    }

    @Column(name = "cmd_accountvariable4")
    public String getCmdAccountVariable4() {
        return this.cmdAccountVariable4;
    }

    public void setCmdAccountVariable4(String cmdAccountVariable4) {
        this.cmdAccountVariable4 = cmdAccountVariable4;
    }

    @Column(name = "cmd_accountvariable5")
    public String getCmdAccountVariable5() {
        return this.cmdAccountVariable5;
    }

    public void setCmdAccountVariable5(String cmdAccountVariable5) {
        this.cmdAccountVariable5 = cmdAccountVariable5;
    }

    @Column(name = "cmd_accountvariable6")
    public String getCmdAccountVariable6() {
        return this.cmdAccountVariable6;
    }

    public void setCmdAccountVariable6(String cmdAccountVariable6) {
        this.cmdAccountVariable6 = cmdAccountVariable6;
    }

    @Column(name = "cmd_accountvariable7")
    public String getCmdAccountVariable7() {
        return this.cmdAccountVariable7;
    }

    public void setCmdAccountVariable7(String cmdAccountVariable7) {
        this.cmdAccountVariable7 = cmdAccountVariable7;
    }

    @Column(name = "cmd_accountvariable8")
    public String getCmdAccountVariable8() {
        return this.cmdAccountVariable8;
    }

    public void setCmdAccountVariable8(String cmdAccountVariable8) {
        this.cmdAccountVariable8 = cmdAccountVariable8;
    }

    @Column(name = "cmd_accountvariable9")
    public String getCmdAccountVariable9() {
        return this.cmdAccountVariable9;
    }

    public void setCmdAccountVariable9(String cmdAccountVariable9) {
        this.cmdAccountVariable9 = cmdAccountVariable9;
    }

    @Column(name = "cmd_accountvariable10")
    public String getCmdAccountVariable10() {
        return this.cmdAccountVariable10;
    }

    public void setCmdAccountVariable10(String cmdAccountVariable10) {
        this.cmdAccountVariable10 = cmdAccountVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmdAccount")
    public Set<StkStockReserved> getStkStockReserveds() {
        return this.stkStockReserveds;
    }

    public void setStkStockReserveds(Set<StkStockReserved> stkStockReserveds) {
        this.stkStockReserveds = stkStockReserveds;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmdAccount")
    public Set<CmdSaleOrder> getCmdSaleOrders() {
        return this.cmdSaleOrders;
    }

    public void setCmdSaleOrders(Set<CmdSaleOrder> cmdSaleOrders) {
        this.cmdSaleOrders = cmdSaleOrders;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmdAccount")
    public Set<CmdSaleOrderArc> getCmdSaleOrderArcs() {
        return this.cmdSaleOrderArcs;
    }

    public void setCmdSaleOrderArcs(Set<CmdSaleOrderArc> cmdSaleOrderArcs) {
        this.cmdSaleOrderArcs = cmdSaleOrderArcs;
    }

    @Column(name = "cmd_accountname")
    public String getCmdAccountName() {
        return cmdAccountName;
    }

    public void setCmdAccountName(String cmdAccountName) {
        this.cmdAccountName = cmdAccountName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_accountinvoicetermid")
    public InvInvoiceTerm getInvInvoiceTerm() {
        return invInvoiceTerm;
    }

    public void setInvInvoiceTerm(InvInvoiceTerm invInvoiceTerm) {
        this.invInvoiceTerm = invInvoiceTerm;
    }

    @Column(name = "cmd_accountpassword")
    public String getCmdAccountPassword() {
        return cmdAccountPassword;
    }

    public void setCmdAccountPassword(String cmdAccountPassword) {
        this.cmdAccountPassword = cmdAccountPassword;
    }
}
