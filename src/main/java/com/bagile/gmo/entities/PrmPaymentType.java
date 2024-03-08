package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Enissay on 02/12/2016.
 */
@Entity
@Table(name = "prm_paymenttype")
public class PrmPaymentType extends EmsEntity{
    private long prmPaymentTypeId;
    private String prmPaymentTypeCode;
    private String prmPaymentTypeDescription;
    private Date prmPaymentTypeCreationDate;
    private Date prmPaymentTypeUpdateDate;
    private Boolean prmPaymentTypeAccounted;
    private Boolean prmPaymentTypeActive;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "prm_paymenttypeid_seq", allocationSize = 1)
    @Column(name = "prm_paymenttypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmPaymentTypeId() {
        return prmPaymentTypeId;
    }

    public void setPrmPaymentTypeId(long prmPaymentTypeId) {
        this.prmPaymentTypeId = prmPaymentTypeId;
    }

    @Column(name = "prm_paymenttypecode")
    public String getPrmPaymentTypeCode() {
        return prmPaymentTypeCode;
    }

    public void setPrmPaymentTypeCode(String prmPaymentTypeCode) {
        this.prmPaymentTypeCode = prmPaymentTypeCode;
    }

    @Column(name = "prm_paymenttypedescription")

    public String getPrmPaymentTypeDescription() {
        return prmPaymentTypeDescription;
    }

    public void setPrmPaymentTypeDescription(String prmPaymentTypeDescription) {
        this.prmPaymentTypeDescription = prmPaymentTypeDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_paymenttypecreationdate")
    public Date getPrmPaymentTypeCreationDate() {
        return prmPaymentTypeCreationDate;
    }

    public void setPrmPaymentTypeCreationDate(Date prmPaymentTypeCreationDate) {
        this.prmPaymentTypeCreationDate = prmPaymentTypeCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_paymenttypeupdatedate")
    public Date getPrmPaymentTypeUpdateDate() {
        return prmPaymentTypeUpdateDate;
    }

    public void setPrmPaymentTypeUpdateDate(Date prmPaymentTypeUpdateDate) {
        this.prmPaymentTypeUpdateDate = prmPaymentTypeUpdateDate;
    }
    @Column(name = "prm_paymenttypeaccounted")
    public Boolean getPrmPaymentTypeAccounted() {
        return prmPaymentTypeAccounted;
    }

    public void setPrmPaymentTypeAccounted(Boolean prmPaymentTypeAccounted) {
        this.prmPaymentTypeAccounted = prmPaymentTypeAccounted;
    }

    @Column(name = "prm_paymenttypeactive")
    public Boolean getPrmPaymentTypeActive() {
        return prmPaymentTypeActive;
    }

    public void setPrmPaymentTypeActive(Boolean prmPaymentTypeActive) {
        this.prmPaymentTypeActive = prmPaymentTypeActive;
    }
}
