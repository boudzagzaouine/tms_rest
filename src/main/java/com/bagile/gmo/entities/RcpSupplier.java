package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rcp_supplier")
// @SQLDelete(sql = "update schema_crm.rcp_supplier set rcp_supplierisactive = false")
// @Where(clause = "rcp_supplierisactive = true")
public class RcpSupplier extends EmsEntity implements java.io.Serializable {

    private Long rcpSupplierId;
   // @NotNull
    private OwnOwner ownOwner;
    private PrmContact prmContact;
    private AdrAddress adrAddress;
    @Size(max = 30)
    @NotNull
    private String rcpSupplierCode;
    @Size(max = 255)
    private String rcpSupplierDescription;
    @Size(max = 255)
    private String rcpSupplierComment;
    @Size(max = 255)
    private String rcpSupplierTerms;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpSupplierCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpSupplierUpdateDate;
   // @NotNull
    private Boolean rcpSupplierIsActive;

    private Boolean rcpSupplierGmao;

    private Set<TmsPlanning> tmsPlannings = new HashSet<>();

    private GmoSupplierType gmoSupplierType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_rcp_supplier_id", allocationSize = 1)
    @Column(name = "rcp_supplierid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getRcpSupplierId() {
        return this.rcpSupplierId;
    }

    public void setRcpSupplierId(Long rcpSupplierId) {
        this.rcpSupplierId = rcpSupplierId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_supplierownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    @JoinColumn(name = "rcp_suppliercontactid")
    public PrmContact getPrmContact() {
        return this.prmContact;
    }

    public void setPrmContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "rcp_supplieraddressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }

    @Column(name = "rcp_supplierisactive")
    public Boolean getRcpSupplierIsActive() {
        return rcpSupplierIsActive;
    }

    public void setRcpSupplierIsActive(Boolean rcpSupplierIsActive) {
        this.rcpSupplierIsActive = rcpSupplierIsActive;
    }

    @Column(name = "rcp_suppliercode", nullable = false, length = 30)
    public String getRcpSupplierCode() {
        return this.rcpSupplierCode;
    }

    public void setRcpSupplierCode(String rcpSupplierCode) {
        this.rcpSupplierCode = rcpSupplierCode;
    }

    @Column(name = "rcp_supplierdescription")
    public String getRcpSupplierDescription() {
        return this.rcpSupplierDescription;
    }

    public void setRcpSupplierDescription(String rcpSupplierDescription) {
        this.rcpSupplierDescription = rcpSupplierDescription;
    }
    @Column(name = "rcp_suppliergmao")
    public Boolean getRcpSupplierGmao() {
        return rcpSupplierGmao;
    }

    public void setRcpSupplierGmao(Boolean rcpGmo) {
        this.rcpSupplierGmao = rcpGmo;
    }

    @Column(name = "rcp_suppliercomment")
    public String getRcpSupplierComment() {
        return this.rcpSupplierComment;
    }

    public void setRcpSupplierComment(String rcpSupplierComment) {
        this.rcpSupplierComment = rcpSupplierComment;
    }

    @Column(name = "rcp_supplierterms")
    public String getRcpSupplierTerms() {
        return this.rcpSupplierTerms;
    }

    public void setRcpSupplierTerms(String rcpSupplierTerms) {
        this.rcpSupplierTerms = rcpSupplierTerms;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_suppliercreationdate")
    public Date getRcpSupplierCreationDate() {
        return this.rcpSupplierCreationDate;
    }

    public void setRcpSupplierCreationDate(Date rcpSupplierCreationDate) {
        this.rcpSupplierCreationDate = rcpSupplierCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_supplierupdatedate")
    public Date getRcpSupplierUpdateDate() {
        return this.rcpSupplierUpdateDate;
    }

    public void setRcpSupplierUpdateDate(Date rcpSupplierUpdateDate) {
        this.rcpSupplierUpdateDate = rcpSupplierUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "rcpSupplier", orphanRemoval=true)
    public Set<TmsPlanning> getTmsPlannings() {
        return tmsPlannings;
    }

    public void setTmsPlannings(Set<TmsPlanning> tmsPlannings) {
        this.tmsPlannings = tmsPlannings;
    }

    @ManyToOne()
    @JoinColumn(name = "rcp_supplierTypeid")
    public GmoSupplierType getGmoSupplierType() {
        return gmoSupplierType;
    }

    public void setGmoSupplierType(GmoSupplierType gmoSupplierType) {
        this.gmoSupplierType = gmoSupplierType;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            RcpSupplier obj = (RcpSupplier) object;
            if (this.getRcpSupplierId() == obj.getRcpSupplierId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rcpSupplierId);
    }
}
