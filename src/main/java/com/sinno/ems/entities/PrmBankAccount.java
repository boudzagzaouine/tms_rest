package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Adil on 2/24/2017.
 */
@Entity
@Table(name = "prm_bankaccount", uniqueConstraints = {@UniqueConstraint(columnNames = {"prm_bankaccountcode"})})
public class PrmBankAccount implements Serializable{
    private Long prmBankAccountId;
    @Size(max = 30)
    private String prmBankAccountCode;
    private PrmBank prmBankAccountBank;
    @Size(max = 30)
    private String prmBankAccountNumber;
    @Size(max = 255)
    private String prmBankAccountDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmBankAccountCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmBankAccountUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_bankaccount", allocationSize = 1)
    @Column(name = "prm_bankaccountid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmBankAccountId() {
        return prmBankAccountId;
    }

    public void setPrmBankAccountId(Long prmBankAccountId) {
        this.prmBankAccountId = prmBankAccountId;
    }

    @Column(name = "prm_bankaccountcode", nullable = false)
    public String getPrmBankAccountCode() {
        return prmBankAccountCode;
    }

    public void setPrmBankAccountCode(String prmBankAccountCode) {
        this.prmBankAccountCode = prmBankAccountCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_bankaccountbankid")
    public PrmBank getPrmBankAccountBank() {
        return prmBankAccountBank;
    }

    public void setPrmBankAccountBank(PrmBank prmBankAccountBank) {
        this.prmBankAccountBank = prmBankAccountBank;
    }

    @Column(name = "prm_bankaccountnumber", nullable = false)
    public String getPrmBankAccountNumber() {
        return prmBankAccountNumber;
    }

    public void setPrmBankAccountNumber(String prmBankAccountNumber) {
        this.prmBankAccountNumber = prmBankAccountNumber;
    }

    @Column(name = "prm_bankaccountdescription")
    public String getPrmBankAccountDescription() {
        return prmBankAccountDescription;
    }

    public void setPrmBankAccountDescription(String prmBankAccountDescription) {
        this.prmBankAccountDescription = prmBankAccountDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_bankaccountcreationdate")
    public Date getPrmBankAccountCreationDate() {
        return prmBankAccountCreationDate;
    }

    public void setPrmBankAccountCreationDate(Date prmBankAccountCreationDate) {
        this.prmBankAccountCreationDate = prmBankAccountCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_bankaccountupdatedate")
    public Date getPrmBankAccountUpdateDate() {
        return prmBankAccountUpdateDate;
    }

    public void setPrmBankAccountUpdateDate(Date prmBankAccountUpdateDate) {
        this.prmBankAccountUpdateDate = prmBankAccountUpdateDate;
    }
}
