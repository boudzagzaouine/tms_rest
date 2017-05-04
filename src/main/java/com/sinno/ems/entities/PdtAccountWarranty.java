package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Adil on 1/24/2017.
 */
@Entity
@Table(name = "pdt_accountwarranty", uniqueConstraints = @UniqueConstraint(columnNames = "pdt_accountwarrantycode"))
public class PdtAccountWarranty implements Serializable{

    private long pdtAccountWarrantyId;

    @Size(max = 30)
    @NotNull
    private String pdtAccountWarrantyCode;
    @NotNull
    private PdtProduct pdtAccountWarrantyProduct;

    @Size(max = 255)
    @NotNull
    private  String pdtAccountWarrantyProductSerialNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtAccountWarrantyBeginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date PdtAccountWarrantyEndDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtAccountCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtAccountUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_accountwarranty", allocationSize = 1)
    @Column(name = "pdt_ccountwarrantyid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtAccountWarrantyId() {
        return pdtAccountWarrantyId;
    }

    public void setPdtAccountWarrantyId(long pdtAccountWarrantyId) {
        this.pdtAccountWarrantyId = pdtAccountWarrantyId;
    }
    @Column(name = "pdt_accountwarrantycode", nullable = false, length = 30)
    public String getPdtAccountWarrantyCode() {
        return pdtAccountWarrantyCode;
    }

    public void setPdtAccountWarrantyCode(String pdtAccountWarrantyCode) {
        this.pdtAccountWarrantyCode = pdtAccountWarrantyCode;
    }

    public PdtProduct getPdtAccountWarrantyProduct() {
        return pdtAccountWarrantyProduct;
    }

    public void setPdtAccountWarrantyProduct(PdtProduct pdtAccountWarrantyProduct) {
        this.pdtAccountWarrantyProduct = pdtAccountWarrantyProduct;
    }

    @Column(name = "pdt_accountwarrantyproductserialnumber")
    public String getPdtAccountWarrantyProductSerialNumber() {
        return pdtAccountWarrantyProductSerialNumber;
    }

    public void setPdtAccountWarrantyProductSerialNumber(String pdtAccountWarrantyProductSerialNumber) {
        this.pdtAccountWarrantyProductSerialNumber = pdtAccountWarrantyProductSerialNumber;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_accountwarrantybegindate")
    public Date getPdtAccountWarrantyBeginDate() {
        return pdtAccountWarrantyBeginDate;
    }

    public void setPdtAccountWarrantyBeginDate(Date pdtAccountWarrantyBeginDate) {
        this.pdtAccountWarrantyBeginDate = pdtAccountWarrantyBeginDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_accountwarrantyenddate")
    public Date getPdtAccountWarrantyEndDate() {
        return PdtAccountWarrantyEndDate;
    }

    public void setPdtAccountWarrantyEndDate(Date pdtAccountWarrantyEndDate) {
        PdtAccountWarrantyEndDate = pdtAccountWarrantyEndDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_accountwarrantycreationdate")
    public Date getPdtAccountCreationDate() {
        return pdtAccountCreationDate;
    }

    public void setPdtAccountCreationDate(Date pdtAccountCreationDate) {
        this.pdtAccountCreationDate = pdtAccountCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_accountwarrantyupdatedate")
    public Date getPdtAccountUpdateDate() {
        return pdtAccountUpdateDate;
    }

    public void setPdtAccountUpdateDate(Date pdtAccountUpdateDate) {
        this.pdtAccountUpdateDate = pdtAccountUpdateDate;
    }
    
}
