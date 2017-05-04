package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * Created by pc on 22/04/2016.
 */
@Entity
@Table(name="prm_ean")
public class PrmEan {

    @Max(999999999)
    private long prmEanId;
    @Size(max = 50)
    private String prmEanType;

    private OrgOrganisation orgOrganisation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_ean", allocationSize = 1)
    @Column(name = "prm_eanid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmEanId() {
        return prmEanId;
    }

    public void setPrmEanId(long prmEanId) {
        this.prmEanId = prmEanId;
    }

    @Column(name = "prm_eantype")
    public String getPrmEanType() {
        return prmEanType;
    }

    public void setPrmEanType(String prmEanType) {
        this.prmEanType = prmEanType;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "prmEan", cascade = CascadeType.ALL)
    public OrgOrganisation getOrgOrganisation() {
        return orgOrganisation;
    }

    public void setOrgOrganisation(OrgOrganisation orgOrganisation) {
        this.orgOrganisation = orgOrganisation;
    }
}
