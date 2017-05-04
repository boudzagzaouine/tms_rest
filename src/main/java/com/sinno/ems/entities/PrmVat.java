package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 22/12/2016.
 */
@Entity
@Table(name = "prm_vat",uniqueConstraints = @UniqueConstraint(columnNames = "prm_vatvalue"))
public class PrmVat {
    private long prmVatId;
    @NotNull
    private BigDecimal prmVatValue;
    private Date prmVatCreationDate;
    private Date prmVatUpdateDate;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_vatcreationdate")
    public Date getPrmVatCreationDate() {
        return prmVatCreationDate;
    }

    public void setPrmVatCreationDate(Date prmVatCreationDate) {
        this.prmVatCreationDate = prmVatCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_vatupdatedate")
    public Date getPrmVatUpdateDate() {
        return prmVatUpdateDate;
    }

    public void setPrmVatUpdateDate(Date prmVatUpdateDate) {
        this.prmVatUpdateDate = prmVatUpdateDate;
    }
}
