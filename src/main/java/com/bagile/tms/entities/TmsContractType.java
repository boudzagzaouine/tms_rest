package com.bagile.tms.entities;

import javax.persistence.*;

@Entity
@Table(name="tms_contracttype")
public class TmsContractType extends EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_contracttype_id", allocationSize = 1)
    @Column(name = "tms_contracttypeid", unique = true, nullable = false, precision = 10, scale = 0)
     private long tmsContractTypeId;
    @Column(name = "tms_contracttypecode", unique = true, nullable = false, length = 90)
    private String tmsContractTypeCode;

    @Column(name = "tms_contracttypedescription")
    private String tmsContractTypeDescription;

    public TmsContractType() {
    }

    public long getTmsContractTypeId() {
        return tmsContractTypeId;
    }

    public void setTmsContractTypeId(long tmsContractTypeId) {
        this.tmsContractTypeId = tmsContractTypeId;
    }

    public String getTmsContractTypeCode() {
        return tmsContractTypeCode;
    }

    public void setTmsContractTypeCode(String tmsContractTypeCode) {
        this.tmsContractTypeCode = tmsContractTypeCode;
    }

    public String getTmsContractTypeDescription() {
        return tmsContractTypeDescription;
    }

    public void setTmsContractTypeDescription(String tmsContractTypeDescription) {
        this.tmsContractTypeDescription = tmsContractTypeDescription;
    }
}
