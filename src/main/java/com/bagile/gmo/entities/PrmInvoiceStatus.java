package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * PrmInvoiceStatus generated by hbm2java
 */
@Entity
@Table(name = "prm_Invoicestatus", uniqueConstraints = @UniqueConstraint(columnNames = "prm_Invoicestatuscode"))
public class PrmInvoiceStatus extends EmsEntity implements java.io.Serializable {

    private long prmInvoiceStatusId;
    @Size(max = 30)
    private String prmInvoiceStatusCode;
    @Size(max = 255)
    private String prmInvoiceStatusDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmInvoiceStatusCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmInvoiceStatusUpdateDate;

    public PrmInvoiceStatus() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_Invoicestatus", allocationSize = 1)
    @Column(name = "prm_Invoicestatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmInvoiceStatusId() {
        return this.prmInvoiceStatusId;
    }

    public void setPrmInvoiceStatusId(long prmInvoiceStatusId) {
        this.prmInvoiceStatusId = prmInvoiceStatusId;
    }

    @Column(name = "prm_Invoicestatuscode", unique = true, nullable = false, length = 30)
    public String getPrmInvoiceStatusCode() {
        return this.prmInvoiceStatusCode;
    }

    public void setPrmInvoiceStatusCode(String prmInvoiceStatusCode) {
        this.prmInvoiceStatusCode = prmInvoiceStatusCode;
    }

    @Column(name = "prm_Invoicestatusdescription")
    public String getPrmInvoiceStatusDescription() {
        return this.prmInvoiceStatusDescription;
    }

    public void setPrmInvoiceStatusDescription(String prmInvoiceStatusDescription) {
        this.prmInvoiceStatusDescription = prmInvoiceStatusDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_Invoicestatuscreationdate")
    public Date getPrmInvoiceStatusCreationDate() {
        return this.prmInvoiceStatusCreationDate;
    }

    public void setPrmInvoiceStatusCreationDate(Date prmInvoiceStatusCreationDate) {
        this.prmInvoiceStatusCreationDate = prmInvoiceStatusCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_Invoicestatusupdatedate")
    public Date getPrmInvoiceStatusUpdateDate() {
        return this.prmInvoiceStatusUpdateDate;
    }

    public void setPrmInvoiceStatusUpdateDate(Date prmInvoiceStatusUpdateDate) {
        this.prmInvoiceStatusUpdateDate = prmInvoiceStatusUpdateDate;
    }

}
