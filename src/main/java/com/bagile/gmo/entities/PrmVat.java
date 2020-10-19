package com.bagile.gmo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 22/12/2016.
 */
@Entity
@Table(name = "prm_vat",uniqueConstraints = @UniqueConstraint(columnNames = "prm_vatvalue"))
public class PrmVat extends EmsEntity{
    private long prmVatId;
    @NotNull
    private BigDecimal prmVatValue;
   private Set<PdtProduct> pdtProduct=new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "prm_vat_prm_vatid_seq", allocationSize = 1)
    @Column(name = "prm_vatid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getPrmVatId() {
        return prmVatId;
    }

    public void setPrmVatId(long prmVatId) {
        this.prmVatId = prmVatId;
    }

    @Column(name = "prm_vatvalue", nullable = false)

    public BigDecimal getPrmVatValue() {
        return prmVatValue;
    }

    public void setPrmVatValue(BigDecimal prmVatValue) {
        this.prmVatValue = prmVatValue;
    }

    @OneToMany(mappedBy="prmVat")
    public Set<PdtProduct> getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(Set<PdtProduct> pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
}
