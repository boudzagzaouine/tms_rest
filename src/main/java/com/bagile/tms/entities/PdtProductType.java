package com.bagile.tms.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PdtProductType generated by hbm2java
 */
@Entity
@Table(name = "pdt_producttype", uniqueConstraints = {
        @UniqueConstraint(columnNames = "pdt_producttypecode")})
public class PdtProductType extends EmsEntity {

    private long pdtProductTypeId;
    private OwnOwner ownOwner;
    private PdtProductType pdtProductTypeParent;
    @Size(max = 30)
    @NotNull
    private String pdtProductTypeCode;
    @Size(max = 255)
    private String pdtProductTypeDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date pdtProductTypeCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date pdtProductTypeUpdateDate;
    private Set<PdtProductType> pdtProductTypes = new HashSet<PdtProductType>(0);
    private Set<PdtProduct> pdtProductsForPdtProductTypeId = new HashSet<PdtProduct>(
            0);
    private Set<PdtProduct> pdtProductsForPdtProductSubTypeId = new HashSet<PdtProduct>(
            0);

    public PdtProductType() {
    }

    public PdtProductType(long pdtProductTypeId, String pdtProductTypeCode) {
        this.pdtProductTypeId = pdtProductTypeId;
        this.pdtProductTypeCode = pdtProductTypeCode;
    }

    public PdtProductType(long pdtProductTypeId, OwnOwner ownOwner,
                          PdtProductType pdtProductType, String pdtProductTypeCode,
                          String pdtProductTypeDescription, Date pdtProductTypeCreationDate,
                          Date pdtProductTypeUpdateDate, Set<PdtProductType> pdtProductTypes,
                          Set<PdtProduct> pdtProductsForPdtProductTypeId,
                          Set<PdtProduct> pdtProductsForPdtProductSubTypeId) {
        this.pdtProductTypeId = pdtProductTypeId;
        this.ownOwner = ownOwner;
        this.pdtProductTypeParent = pdtProductType;
        this.pdtProductTypeCode = pdtProductTypeCode;
        this.pdtProductTypeDescription = pdtProductTypeDescription;
        this.pdtProductTypeCreationDate = pdtProductTypeCreationDate;
        this.pdtProductTypeUpdateDate = pdtProductTypeUpdateDate;
        this.pdtProductTypes = pdtProductTypes;
        this.pdtProductsForPdtProductTypeId = pdtProductsForPdtProductTypeId;
        this.pdtProductsForPdtProductSubTypeId = pdtProductsForPdtProductSubTypeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_producttype", allocationSize = 1)
    @Column(name = "pdt_producttypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtProductTypeId() {
        return this.pdtProductTypeId;
    }

    public void setPdtProductTypeId(long pdtProductTypeId) {
        this.pdtProductTypeId = pdtProductTypeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_producttypeownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_producttypeparentid")
    public PdtProductType getPdtProductTypeParent() {
        return this.pdtProductTypeParent;
    }

    public void setPdtProductTypeParent(PdtProductType pdtProductType) {
        this.pdtProductTypeParent = pdtProductType;
    }

    @Column(name = "pdt_producttypecode", unique = true, nullable = false, length = 30)
    public String getPdtProductTypeCode() {
        return this.pdtProductTypeCode;
    }

    public void setPdtProductTypeCode(String pdtProductTypeCode) {
        this.pdtProductTypeCode = pdtProductTypeCode;
    }

    @Column(name = "pdt_producttypedescription")
    public String getPdtProductTypeDescription() {
        return this.pdtProductTypeDescription;
    }

    public void setPdtProductTypeDescription(String pdtProductTypeDescription) {
        this.pdtProductTypeDescription = pdtProductTypeDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_producttypecreationdate")
    public Date getPdtProductTypeCreationDate() {
        return this.pdtProductTypeCreationDate;
    }

    public void setPdtProductTypeCreationDate(Date pdtProductTypeCreationDate) {
        this.pdtProductTypeCreationDate = pdtProductTypeCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_producttypeupdatedate")
    public Date getPdtProductTypeUpdateDate() {
        return this.pdtProductTypeUpdateDate;
    }

    public void setPdtProductTypeUpdateDate(Date pdtProductTypeUpdateDate) {
        this.pdtProductTypeUpdateDate = pdtProductTypeUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProductTypeParent")
    public Set<PdtProductType> getPdtProductTypes() {
        return this.pdtProductTypes;
    }

    public void setPdtProductTypes(Set<PdtProductType> pdtProductTypes) {
        this.pdtProductTypes = pdtProductTypes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProductTypeByPdtProductTypeId")
    public Set<PdtProduct> getPdtProductsForPdtProductTypeId() {
        return this.pdtProductsForPdtProductTypeId;
    }

    public void setPdtProductsForPdtProductTypeId(
            Set<PdtProduct> pdtProductsForPdtProductTypeId) {
        this.pdtProductsForPdtProductTypeId = pdtProductsForPdtProductTypeId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProductTypeByPdtProductSubTypeId")
    public Set<PdtProduct> getPdtProductsForPdtProductSubTypeId() {
        return this.pdtProductsForPdtProductSubTypeId;
    }

    public void setPdtProductsForPdtProductSubTypeId(
            Set<PdtProduct> pdtProductsForPdtProductSubTypeId) {
        this.pdtProductsForPdtProductSubTypeId = pdtProductsForPdtProductSubTypeId;
    }

}
