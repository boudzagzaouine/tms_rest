package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ASMAE on 28/04/2016.
 */

@Entity
@Table(name = "prm_barcode_suffixe")
public class PrmBarCode {
    private long prmBarCodeId;
    @Size(max = 50)
    private String prmBarCodeName;
    @Size(max = 10)
    private String prmBarCodeSuffixe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmBarCodeCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmBarCodeUpdateDate;

    public PrmBarCode() {
    }

    public PrmBarCode(long prmBarCodeId, String prmBarCodeName,
                      String prmBarCodeSuffixe, Date prmBarCodeCreationDate,
                      Date prmBarCodeUpdateDate) {
        this.prmBarCodeId = prmBarCodeId;
        this.prmBarCodeName = prmBarCodeName;
        this.prmBarCodeSuffixe = prmBarCodeSuffixe;
        this.prmBarCodeCreationDate = prmBarCodeCreationDate;
        this.prmBarCodeUpdateDate = prmBarCodeUpdateDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_barcode", allocationSize = 1)
    @Column(name = "prm_barcode_suffixeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmBarCodeId() {
        return prmBarCodeId;
    }

    public void setPrmBarCodeId(long prmBarCodeId) {
        this.prmBarCodeId = prmBarCodeId;
    }

    @Column(name = "prm_barcode_suffixename")
    public String getPrmBarCodeName() {
        return prmBarCodeName;
    }

    public void setPrmBarCodeName(String prmBarCodeName) {
        this.prmBarCodeName = prmBarCodeName;
    }

    @Column(name = "prm_barcode_suffixesuffixe")
    public String getPrmBarCodeSuffixe() {
        return prmBarCodeSuffixe;
    }

    public void setPrmBarCodeSuffixe(String prmBarCodeSuffixe) {
        this.prmBarCodeSuffixe = prmBarCodeSuffixe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_barcode_suffixecreationdate")
    public Date getPrmBarCodeCreationDate() {
        return prmBarCodeCreationDate;
    }

    public void setPrmBarCodeCreationDate(Date prmBarCodeCreationDate) {
        this.prmBarCodeCreationDate = prmBarCodeCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_barcode_suffixeupdatedate")
    public Date getPrmBarCodeUpdateDate() {
        return prmBarCodeUpdateDate;
    }

    public void setPrmBarCodeUpdateDate(Date prmBarCodeUpdateDate) {
        this.prmBarCodeUpdateDate = prmBarCodeUpdateDate;
    }
}
