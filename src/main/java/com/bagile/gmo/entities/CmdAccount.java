package com.bagile.gmo.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.format.annotation.DateTimeFormat;

import com.bagile.gmo.dto.EmsDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * CmdAccount generated by hbm2java
 */
@Entity
@Table(name = "cmd_account", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cmd_accountcode")})
public class CmdAccount extends EmsDto implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -8407687683333368760L;
    private Long cmdAccountId;
    private CmdCompany cmdCompany;
    @NotNull
    private OwnOwner ownOwner;

    private AdrAddress adrAddressByCmdAccountDeliveryAddressId;
    private TrpTransport trpTransport;

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
    @CreatedBy
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
    private String cmdAccountPassword;
    private Set<CmdSaleOrder> cmdSaleOrders = new HashSet<CmdSaleOrder>(0);
    private BigDecimal cmdAccountMaxCredit;
    private Boolean cmdAccountWholesale;

    private Set<TmsPlanning> tmsPlannings = new HashSet<> ();

    private Set<AdrAddress> adrAddresses = new HashSet<> ();
    private Set<PrmContact> prmContacts = new HashSet<> ();


    private Date cmdAccountDeliveryDate ;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_account", allocationSize = 1)
    @Column(name = "cmd_accountid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getCmdAccountId() {
        return this.cmdAccountId;
    }

    public void setCmdAccountId(Long cmdAccountId) {
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cmd_accountcontactid")
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


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "cmd_accountdeliveryaddressid")
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

    @Column(name = "cmd_accountdeliverydate")
    public Date getCmdAccountDeliveryDate() {
        return cmdAccountDeliveryDate;
    }

    public void setCmdAccountDeliveryDate(Date cmdAccountDeliveryDate) {
        this.cmdAccountDeliveryDate = cmdAccountDeliveryDate;
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
    public Set<CmdSaleOrder> getCmdSaleOrders() {
        return this.cmdSaleOrders;
    }

    public void setCmdSaleOrders(Set<CmdSaleOrder> cmdSaleOrders) {
        this.cmdSaleOrders = cmdSaleOrders;
    }

    @Column(name = "cmd_accountname")
    public String getCmdAccountName() {
        return cmdAccountName;
    }

    public void setCmdAccountName(String cmdAccountName) {
        this.cmdAccountName = cmdAccountName;
    }


    @Column(name = "cmd_accountpassword")
    public String getCmdAccountPassword() {
        return cmdAccountPassword;
    }

    public void setCmdAccountPassword(String cmdAccountPassword) {
        this.cmdAccountPassword = cmdAccountPassword;
    }


    @Column(name = "cmd_accountmaxcredit")
    public BigDecimal getCmdAccountMaxCredit() {
        return cmdAccountMaxCredit;
    }

    public void setCmdAccountMaxCredit(BigDecimal cmdAccountMaxCredit) {
        this.cmdAccountMaxCredit = cmdAccountMaxCredit;
    }
    @Column(name = "cmd_accountwholesale")
    public Boolean getCmdAccountWholesale() {
        return cmdAccountWholesale;
    }

    public void setCmdAccountWholesale(Boolean cmdAccountWholesale) {
        this.cmdAccountWholesale = cmdAccountWholesale;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "cmdAccount", orphanRemoval=true)
    public Set<TmsPlanning> getTmsPlannings() {
        return tmsPlannings;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "cmdAccount", orphanRemoval=true)
    public Set<AdrAddress> getAdrAddresses() {
        return adrAddresses;
    }

    public void setAdrAddresses(Set<AdrAddress> adrAddresses) {
        this.adrAddresses = adrAddresses;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "cmdAccount", orphanRemoval=true)
    public Set<PrmContact> getPrmContacts() {
        return prmContacts;
    }

    public void setPrmContacts(Set<PrmContact> prmContacts) {
        this.prmContacts = prmContacts;
    }

    public void setTmsPlannings(Set<TmsPlanning> tmsPlannings) {
        this.tmsPlannings = tmsPlannings;
    }
}
