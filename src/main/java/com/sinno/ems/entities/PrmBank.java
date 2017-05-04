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
@Table(name = "prm_bank",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"prm_bankcode"})})
public class PrmBank implements Serializable {
    private Long prmBankId;
    @Size(max = 30)
    private String  prmBankCode;
    @Size(max = 50)
    private String  prmBankName;
    @Size(max = 255)
    private String prmBankDescription;
    private OrgOrganisation  prmBankOrganisation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  prmBankCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  prmBankUpdateDate;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_bank", allocationSize = 1)
    @Column(name = "prm_bankid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmBankId() {
        return prmBankId;
    }

    public void setPrmBankId(Long prmBankId) {
        this.prmBankId = prmBankId;
    }

    @Column(name = "prm_bankcode", nullable = false)
    public String getPrmBankCode() {
        return prmBankCode;
    }

    public void setPrmBankCode(String prmBankCode) {
        this.prmBankCode = prmBankCode;
    }

    @Column(name = "prm_bankname", nullable = false)
    public String getPrmBankName() {
        return prmBankName;
    }

    public void setPrmBankName(String prmBankName) {
        this.prmBankName = prmBankName;
    }

    @Column(name = "prm_bandescription")
    public String getPrmBankDescription() {
        return prmBankDescription;
    }

    public void setPrmBankDescription(String description) {
        prmBankDescription = description;
    }
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "prm_bankorganisationid")
    public OrgOrganisation getPrmBankOrganisation() {
        return prmBankOrganisation;
    }

    public void setPrmBankOrganisation(OrgOrganisation prmBankOrganisation) {
        this.prmBankOrganisation = prmBankOrganisation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_bankcreationdate")
    public Date getPrmBankCreationDate() {
        return prmBankCreationDate;
    }

    public void setPrmBankCreationDate(Date prmBankCreationDate) {
        this.prmBankCreationDate = prmBankCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_bankupdatedate")
    public Date getPrmBankUpdateDate() {
        return prmBankUpdateDate;
    }

    public void setPrmBankUpdateDate(Date prmBankUpdateDate) {
        this.prmBankUpdateDate = prmBankUpdateDate;
    }
}
