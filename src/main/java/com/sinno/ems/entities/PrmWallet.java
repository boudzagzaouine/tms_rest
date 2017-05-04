package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Adil on 2/27/2017.
 */
@Entity
@Table(name = "prm_wallet",uniqueConstraints = @UniqueConstraint(columnNames = "prm_walletcode"))
public class PrmWallet implements Serializable {
    private Long prmWalletId;
    @Size(max = 30)
    private String  prmWalletCode;
    private BigDecimal  prmWalletBalance;
    private OwnOwner ownOwner;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  prmWalletCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  prmWalletUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_wallet", allocationSize = 1)
    @Column(name = "prm_walletid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmWalletId() {
        return prmWalletId;
    }

    public void setPrmWalletId(Long prmWalletId) {
        this.prmWalletId = prmWalletId;
    }
    @Column(name = "prm_walletcode", nullable = false)
    public String getPrmWalletCode() {
        return prmWalletCode;
    }

    public void setPrmWalletCode(String prmWalletCode) {
        this.prmWalletCode = prmWalletCode;
    }
    @Column(name = "prm_walletbalance")
    public BigDecimal getPrmWalletBalance() {
        return prmWalletBalance;
    }

    public void setPrmWalletBalance(BigDecimal prmWalletBalance) {
        this.prmWalletBalance = prmWalletBalance;
    }

    @OneToOne(mappedBy = "prmWallet")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_walletcreationdate")
    public Date getPrmWalletCreationDate() {
        return prmWalletCreationDate;
    }

    public void setPrmWalletCreationDate(Date prmWalletCreationDate) {
        this.prmWalletCreationDate = prmWalletCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_walletupdatedate")
    public Date getPrmWalletUpdateDate() {
        return prmWalletUpdateDate;
    }

    public void setPrmWalletUpdateDate(Date prmWalletUpdateDate) {
        this.prmWalletUpdateDate = prmWalletUpdateDate;
    }
}
