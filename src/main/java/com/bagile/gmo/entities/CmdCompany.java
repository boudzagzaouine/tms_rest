package com.bagile.gmo.entities;

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
 * CmdCompany generated by hbm2java
 */
@Entity
@Table(name = "cmd_company")
public class CmdCompany extends EmsEntity implements Serializable  {

    /**
     *
     */
    private static final long serialVersionUID = -3249779645949658793L;
    private long cmdCompanyId;

    private OwnOwner ownOwner;
    @Size(max = 30)
    @NotNull
    private String cmdCompanyCode;

    private String cmdCompanyName;
    @Size(max = 20)
    private String cmdCompanySiret;
    @Size(max = 255)
    private String cmdCompanyComment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdCompanyCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date cmdCompanyUpdateDate;
    @Size(max = 255)
    private String cmdCompanyVariable1;
    @Size(max = 255)
    private String cmdCompanyVariable2;
    @Size(max = 255)
    private String cmdCompanyVariable3;
    @Size(max = 255)
    private String cmdCompanyVariable4;
    @Size(max = 255)
    private String cmdCompanyVariable5;
    @Size(max = 255)
    private String cmdCompanyVariable6;
    @Size(max = 255)
    private String cmdCompanyVariable7;
    @Size(max = 255)
    private String cmdCompanyVariable8;
    @Size(max = 255)
    private String cmdCompanyVariable9;
    @Size(max = 255)
    private String cmdCompanyVariable10;
    private AdrAddress adrAddress;
    private String cmdCommonIdentifierOfCompany;
    private String cmdCompanyFiscalIdentifier;
    private String cmdCompanyProfessionalTax;
    private String cmdCompanyTradeRegister;
    private String cmdCompanyCnssNumber;
    private Set<CmdAccount> cmdAccounts = new HashSet<CmdAccount>(0);
    private Boolean cmdCompanySyncWms;
    private byte[] cmdCompanyImage;
    private String cmdCompanyCommercialCourt;
    private CmdActivityArea cmdActivityArea;
    private String cmdCompanyTelephone;
    private BigDecimal cmdCompanyThreshold;
    private String cmdCompanyClassificationFiscale;
    private String cmdCompanyWebSite;


    private String cmdCompanyEmail;
    private String cmdCompanyPatent;
    private BigDecimal cmdCompanyTurnover;
    private String cmdCompanyFax;

    public CmdCompany(){}





    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmd_company", allocationSize = 1)
    @Column(name = "cmd_companyid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdCompanyId() {
        return this.cmdCompanyId;
    }

    public void setCmdCompanyId(long cmdCompanyId) {
        this.cmdCompanyId = cmdCompanyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_companyownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Column(name = "cmd_companycode", nullable = false, length = 30)
    public String getCmdCompanyCode() {
        return this.cmdCompanyCode;
    }

    public void setCmdCompanyCode(String cmdCompanyCode) {
        this.cmdCompanyCode = cmdCompanyCode;
    }

    @Column(name = "cmd_companysiret", length = 20)
    public String getCmdCompanySiret() {
        return this.cmdCompanySiret;
    }

    public void setCmdCompanySiret(String cmdCompanySiret) {
        this.cmdCompanySiret = cmdCompanySiret;
    }

    @Column(name = "cmd_companycomment")
    public String getCmdCompanyComment() {
        return this.cmdCompanyComment;
    }

    public void setCmdCompanyComment(String cmdCompanyComment) {
        this.cmdCompanyComment = cmdCompanyComment;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_companycreationdate")
    public Date getCmdCompanyCreationDate() {
        return this.cmdCompanyCreationDate;
    }

    public void setCmdCompanyCreationDate(Date cmdCompanyCreationDate) {
        this.cmdCompanyCreationDate = cmdCompanyCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_companyupdatedate")
    public Date getCmdCompanyUpdateDate() {
        return this.cmdCompanyUpdateDate;
    }

    public void setCmdCompanyUpdateDate(Date cmdCompanyUpdateDate) {
        this.cmdCompanyUpdateDate = cmdCompanyUpdateDate;
    }

    @Column(name = "cmd_companyvariable1")
    public String getCmdCompanyVariable1() {
        return this.cmdCompanyVariable1;
    }

    public void setCmdCompanyVariable1(String cmdCompanyVariable1) {
        this.cmdCompanyVariable1 = cmdCompanyVariable1;
    }

    @Column(name = "cmd_companyvariable2")
    public String getCmdCompanyVariable2() {
        return this.cmdCompanyVariable2;
    }

    public void setCmdCompanyVariable2(String cmdCompanyVariable2) {
        this.cmdCompanyVariable2 = cmdCompanyVariable2;
    }

    @Column(name = "cmd_companyvariable3")
    public String getCmdCompanyVariable3() {
        return this.cmdCompanyVariable3;
    }

    public void setCmdCompanyVariable3(String cmdCompanyVariable3) {
        this.cmdCompanyVariable3 = cmdCompanyVariable3;
    }

    @Column(name = "cmd_companyvariable4")
    public String getCmdCompanyVariable4() {
        return this.cmdCompanyVariable4;
    }

    public void setCmdCompanyVariable4(String cmdCompanyVariable4) {
        this.cmdCompanyVariable4 = cmdCompanyVariable4;
    }

    @Column(name = "cmd_companyvariable5")
    public String getCmdCompanyVariable5() {
        return this.cmdCompanyVariable5;
    }

    public void setCmdCompanyVariable5(String cmdCompanyVariable5) {
        this.cmdCompanyVariable5 = cmdCompanyVariable5;
    }

    @Column(name = "cmd_companyvariable6")
    public String getCmdCompanyVariable6() {
        return this.cmdCompanyVariable6;
    }

    public void setCmdCompanyVariable6(String cmdCompanyVariable6) {
        this.cmdCompanyVariable6 = cmdCompanyVariable6;
    }

    @Column(name = "cmd_companyvariable7")
    public String getCmdCompanyVariable7() {
        return this.cmdCompanyVariable7;
    }

    public void setCmdCompanyVariable7(String cmdCompanyVariable7) {
        this.cmdCompanyVariable7 = cmdCompanyVariable7;
    }

    @Column(name = "cmd_companyvariable8")
    public String getCmdCompanyVariable8() {
        return this.cmdCompanyVariable8;
    }

    public void setCmdCompanyVariable8(String cmdCompanyVariable8) {
        this.cmdCompanyVariable8 = cmdCompanyVariable8;
    }

    @Column(name = "cmd_companyvariable9")
    public String getCmdCompanyVariable9() {
        return this.cmdCompanyVariable9;
    }

    public void setCmdCompanyVariable9(String cmdCompanyVariable9) {
        this.cmdCompanyVariable9 = cmdCompanyVariable9;
    }

    @Column(name = "cmd_companyvariable10")
    public String getCmdCompanyVariable10() {
        return this.cmdCompanyVariable10;
    }

    public void setCmdCompanyVariable10(String cmdCompanyVariable10) {
        this.cmdCompanyVariable10 = cmdCompanyVariable10;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cmdCompany")
    public Set<CmdAccount> getCmdAccounts() {
        return this.cmdAccounts;
    }

    public void setCmdAccounts(Set<CmdAccount> cmdAccounts) {
        this.cmdAccounts = cmdAccounts;
    }

    @OneToOne(cascade = {CascadeType.ALL} , mappedBy = "cmdCompany")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
        if(this.adrAddress != null)
        this.adrAddress.setCmdCompany(this);
    }

    @Column(name = "cmd_companyname", length = 50, nullable = false)
    public String getCmdCompanyName() {
        return cmdCompanyName;
    }

    public void setCmdCompanyName(String cmdCompanyName) {
        this.cmdCompanyName = cmdCompanyName;
    }

    @Column(name = "cmd_companycommonidentifierofcompany")
    public String getCmdCommonIdentifierOfCompany() {
        return cmdCommonIdentifierOfCompany;
    }

    public void setCmdCommonIdentifierOfCompany(String cmdCommonIdentifierOfCompany) {
        this.cmdCommonIdentifierOfCompany = cmdCommonIdentifierOfCompany;
    }
    @Column(name = "cmd_companyfiscalidentifier")
    public String getCmdCompanyFiscalIdentifier() {
        return cmdCompanyFiscalIdentifier;
    }

    public void setCmdCompanyFiscalIdentifier(String cmdCompanyFiscalIdentifier) {
        this.cmdCompanyFiscalIdentifier = cmdCompanyFiscalIdentifier;
    }
    @Column(name = "cmd_companyprofessionaltax")
    public String getCmdCompanyProfessionalTax() {
        return cmdCompanyProfessionalTax;
    }

    public void setCmdCompanyProfessionalTax(String cmdCompanyProfessionalTax) {
        this.cmdCompanyProfessionalTax = cmdCompanyProfessionalTax;
    }
    @Column(name = "cmd_companytraderegister")
    public String getCmdCompanyTradeRegister() {
        return cmdCompanyTradeRegister;
    }

    public void setCmdCompanyTradeRegister(String cmdCompanyTradeRegister) {
        this.cmdCompanyTradeRegister = cmdCompanyTradeRegister;
    }
    @Column(name = "cmd_companycnssnumber")
    public String getCmdCompanyCnssNumber() {
        return cmdCompanyCnssNumber;
    }

    public void setCmdCompanyCnssNumber(String cmdCompanyCnssNumber) {
        this.cmdCompanyCnssNumber = cmdCompanyCnssNumber;
    }

    @Column(name = "cmd_companysyncwms")
    public Boolean getCmdCompanySyncWms() {
        return cmdCompanySyncWms;
    }

    public void setCmdCompanySyncWms(Boolean cmdCompanySyncWms) {
        this.cmdCompanySyncWms = cmdCompanySyncWms;
    }

    @Column(name = "cmd_companyimage")
    public byte[] getCmdCompanyImage() {
        return cmdCompanyImage;
    }

    public void setCmdCompanyImage(byte[] cmdCompanyImage) {
        this.cmdCompanyImage = cmdCompanyImage;
    }

//    @Column(name = "cmd_companycommercialcourt",nullable = false)
//    public String getCmdCompanyCommercialCourt() {
//        return cmdCompanyCommercialCourt;
//    }
//
//    public void setCmdCompanyCommercialCourt(String cmdCompanyCommercialCourt) {
//        this.cmdCompanyCommercialCourt = cmdCompanyCommercialCourt;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmd_companyactivityareaid")
    public CmdActivityArea getCmdActivityArea() {
        return cmdActivityArea;
    }

    public void setCmdActivityArea(CmdActivityArea cmdActivityArea) {
        this.cmdActivityArea = cmdActivityArea;
    }

    @Column(name = "cmd_companytelephone")
    public String getCmdCompanyTelephone() {
        return cmdCompanyTelephone;
    }

    public void setCmdCompanyTelephone(String cmdCompanyTelephone) {
        this.cmdCompanyTelephone = cmdCompanyTelephone;
    }

    @Column(name = "cmd_companythreshold")
    public BigDecimal getCmdCompanyThreshold() {
        return cmdCompanyThreshold;
    }

    public void setCmdCompanyThreshold(BigDecimal cmdCompanyThreshold) {
        this.cmdCompanyThreshold = cmdCompanyThreshold;
    }

    @Column(name = "cmd_companyclassificationfiscale")
    public String getCmdCompanyClassificationFiscale() {
        return cmdCompanyClassificationFiscale;
    }

    public void setCmdCompanyClassificationFiscale(String cmdCompanyClassificationFiscale) {
        this.cmdCompanyClassificationFiscale = cmdCompanyClassificationFiscale;
    }

    @Column(name = "cmd_companywebsite")
    public String getCmdCompanyWebSite() {
        return cmdCompanyWebSite;
    }

    public void setCmdCompanyWebSite(String cmdCompanyWebSite) {
        this.cmdCompanyWebSite = cmdCompanyWebSite;
    }



    @Column(name = "cmd_companyemail")
    public String getCmdCompanyEmail() {
        return cmdCompanyEmail;
    }

    public void setCmdCompanyEmail(String cmdCompanyEmail) {
        this.cmdCompanyEmail = cmdCompanyEmail;
    }

    @Column(name = "cmd_companypatent")
    public String getCmdCompanyPatent() {
        return cmdCompanyPatent;
    }

    public void setCmdCompanyPatent(String cmdCompanyPatent) {
        this.cmdCompanyPatent = cmdCompanyPatent;
    }

    @Column(name = "cmd_companyturnover")
    public BigDecimal getCmdCompanyTurnover() {
        return cmdCompanyTurnover;
    }

    public void setCmdCompanyTurnover(BigDecimal cmdCompanyTurnover) {
        this.cmdCompanyTurnover = cmdCompanyTurnover;
    }
    @Column(name = "cmd_companyfax")
    public String getCmdCompanyFax() {
        return cmdCompanyFax;
    }

    public void setCmdCompanyFax(String cmdCompanyFax) {
        this.cmdCompanyFax = cmdCompanyFax;
    }
}
