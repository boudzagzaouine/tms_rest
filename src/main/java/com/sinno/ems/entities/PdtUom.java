package com.sinno.ems.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PdtUom generated by hbm2java
 */
@Entity
@Table(name = "pdt_uom", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pdt_uomcode", "pdt_uomownerid"} )})
public class PdtUom implements java.io.Serializable {

    private long pdtUomId;
    private OwnOwner ownOwner;
    @Size(max = 30)
    private String pdtUomCode;
    @Size(max = 100)
    private String pdtUomDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date pdtUomCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date pdtUomUpdateDate;


    public PdtUom() {
    }

    public PdtUom(long pdtUomId, OwnOwner ownOwner, String pdtUomCode) {
        this.pdtUomId = pdtUomId;
        this.ownOwner = ownOwner;
        this.pdtUomCode = pdtUomCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_uom", allocationSize = 1)
    @Column(name = "pdt_uomid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtUomId() {
        return this.pdtUomId;
    }

    public void setPdtUomId(long pdtUomId) {
        this.pdtUomId = pdtUomId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_uomownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Column(name = "pdt_uomcode", nullable = false, length = 30)
    public String getPdtUomCode() {
        return this.pdtUomCode;
    }

    public void setPdtUomCode(String pdtUomCode) {
        this.pdtUomCode = pdtUomCode;
    }

    @Column(name = "pdt_uomdescription", length = 100)
    public String getPdtUomDescription() {
        return this.pdtUomDescription;
    }

    public void setPdtUomDescription(String pdtUomDescription) {
        this.pdtUomDescription = pdtUomDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_uomcreationdate")
    public Date getPdtUomCreationDate() {
        return this.pdtUomCreationDate;
    }

    public void setPdtUomCreationDate(Date pdtUomCreationDate) {
        this.pdtUomCreationDate = pdtUomCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_uomupdatedate")
    public Date getPdtUomUpdateDate() {
        return this.pdtUomUpdateDate;
    }

    public void setPdtUomUpdateDate(Date pdtUomUpdateDate) {
        this.pdtUomUpdateDate = pdtUomUpdateDate;
    }


    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            PdtUom obj = (PdtUom) object;
            if (this.getPdtUomId() == obj.getPdtUomId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.getPdtUomId();
        hash = 7 * hash + (int) this.getPdtUomId();
        return hash;
    }
}
