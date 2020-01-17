package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tms_insurancetype")
public class TmsInsuranceType extends EmsEntity {

    private long tmsInsuranceTypeId;
    private String tmsInsuranceTypeCode;
    private String tmsInsuranceTypeDescription;
    private Set<TmsInsurance> tmsInsurances= new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_insurancetype_id", allocationSize = 1)
    @Column(name = "tms_insurancetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsInsuranceTypeId() {
        return tmsInsuranceTypeId;
    }

    public void setTmsInsuranceTypeId(long tmsInsuranceTypeId) {
        this.tmsInsuranceTypeId = tmsInsuranceTypeId;
    }
    @Column(name = "tms_insurancetypecode")
    public String getTmsInsuranceTypeCode() {
        return tmsInsuranceTypeCode;
    }

    public void setTmsInsuranceTypeCode(String tmsInsuranceTypeCode) {
        this.tmsInsuranceTypeCode = tmsInsuranceTypeCode;
    }
    @Column(name = "tms_insurancetypedescription")
    public String getTmsInsuranceTypeDescription() {
        return tmsInsuranceTypeDescription;
    }

    public void setTmsInsuranceTypeDescription(String tmsInsuranceTypeDescription) {
        this.tmsInsuranceTypeDescription = tmsInsuranceTypeDescription;
    }

    @OneToMany(mappedBy = "tmsInsuranceType",cascade = CascadeType.ALL)
    public Set<TmsInsurance> getTmsInsurances() {
        return tmsInsurances;
    }

    public void setTmsInsurances(Set<TmsInsurance> tmsInsurances) {
        this.tmsInsurances = tmsInsurances;
    }
}
