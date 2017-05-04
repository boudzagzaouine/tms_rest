package com.sinno.ems.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Enissay on 13/03/2017.
 */
@Entity
@Table(name="pdt_productform")
public class PdtProductForm {
    private long pdtProductFormId;
    private String pdtProductFormCode;
    private Date pdtProductFormCreationDate;
    private Date pdtProductFormUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_productform", allocationSize = 1)
    @Column(name = "pdt_productformid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtProductFormId() {
        return pdtProductFormId;
    }

    public void setPdtProductFormId(long pdtProductFormId) {
        this.pdtProductFormId = pdtProductFormId;
    }
    @Column(name="pdt_productformcode",nullable = false,unique = true)
    public String getPdtProductFormCode() {
        return pdtProductFormCode;
    }

    public void setPdtProductFormCode(String pdtProductFormCode) {
        this.pdtProductFormCode = pdtProductFormCode;
    }
    @Column(name = "pdt_productformcreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPdtProductFormCreationDate() {
        return pdtProductFormCreationDate;
    }

    public void setPdtProductFormCreationDate(Date pdtProductFormCreationDate) {
        this.pdtProductFormCreationDate = pdtProductFormCreationDate;
    }
    @Column(name = "pdt_productformupdatedate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPdtProductFormUpdateDate() {
        return pdtProductFormUpdateDate;
    }

    public void setPdtProductFormUpdateDate(Date pdtProductFormUpdateDate) {
        this.pdtProductFormUpdateDate = pdtProductFormUpdateDate;
    }
}
