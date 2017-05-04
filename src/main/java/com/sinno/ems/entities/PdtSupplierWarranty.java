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
@Table(name = "pdt_supplierwarranty", uniqueConstraints = @UniqueConstraint(columnNames = "pdt_supplierwarrantycode"))
public class PdtSupplierWarranty implements Serializable{

    private long pdtSupplierWarrantyId;

    @Size(max = 30)
    @NotNull
    private String pdtSupplierWarrantyCode;
    @NotNull
    private PdtProduct pdtSupplierWarrantyProduct;
    
    @Size(max = 255)
    @NotNull
    private  String pdtSupplierWarrantyProductSerialNumber;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtSupplierWarrantyBeginDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date PdtSupplierWarrantyEndDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtSupplierCreationDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtSupplierUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_supplierwarranty", allocationSize = 1)
    @Column(name = "pdt_ccountwarrantyid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtSupplierWarrantyId() {
        return pdtSupplierWarrantyId;
    }
    
    public void setPdtSupplierWarrantyId(long pdtSupplierWarrantyId) {
        this.pdtSupplierWarrantyId = pdtSupplierWarrantyId;
    }
    @Column(name = "pdt_supplierwarrantycode", nullable = false, length = 30)
    public String getPdtSupplierWarrantyCode() {
        return pdtSupplierWarrantyCode;
    }

    public void setPdtSupplierWarrantyCode(String pdtSupplierWarrantyCode) {
        this.pdtSupplierWarrantyCode = pdtSupplierWarrantyCode;
    }

    public PdtProduct getPdtSupplierWarrantyProduct() {
        return pdtSupplierWarrantyProduct;
    }

    public void setPdtSupplierWarrantyProduct(PdtProduct pdtSupplierWarrantyProduct) {
        this.pdtSupplierWarrantyProduct = pdtSupplierWarrantyProduct;
    }

    @Column(name = "pdt_supplierwarrantyproductserialnumber")
    public String getPdtSupplierWarrantyProductSerialNumber() {
        return pdtSupplierWarrantyProductSerialNumber;
    }

    public void setPdtSupplierWarrantyProductSerialNumber(String pdtSupplierWarrantyProductSerialNumber) {
        this.pdtSupplierWarrantyProductSerialNumber = pdtSupplierWarrantyProductSerialNumber;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_supplierwarrantybegindate")
    public Date getPdtSupplierWarrantyBeginDate() {
        return pdtSupplierWarrantyBeginDate;
    }

    public void setPdtSupplierWarrantyBeginDate(Date pdtSupplierWarrantyBeginDate) {
        this.pdtSupplierWarrantyBeginDate = pdtSupplierWarrantyBeginDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_supplierwarrantyenddate")
    public Date getPdtSupplierWarrantyEndDate() {
        return PdtSupplierWarrantyEndDate;
    }

    public void setPdtSupplierWarrantyEndDate(Date pdtSupplierWarrantyEndDate) {
        PdtSupplierWarrantyEndDate = pdtSupplierWarrantyEndDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_supplierwarrantycreationdate")
    public Date getPdtSupplierCreationDate() {
        return pdtSupplierCreationDate;
    }

    public void setPdtSupplierCreationDate(Date pdtSupplierCreationDate) {
        this.pdtSupplierCreationDate = pdtSupplierCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_supplierwarrantyupdatedate")
    public Date getPdtSupplierUpdateDate() {
        return pdtSupplierUpdateDate;
    }

    public void setPdtSupplierUpdateDate(Date pdtSupplierUpdateDate) {
        this.pdtSupplierUpdateDate = pdtSupplierUpdateDate;
    }
}
