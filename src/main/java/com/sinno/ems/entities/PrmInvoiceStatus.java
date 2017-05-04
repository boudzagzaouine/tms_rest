package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Adil on 2/27/2017.
 */
@Entity
@Table(name = "prm_invoicestatus",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"prm_invoicestatuscode"})})
public class PrmInvoiceStatus implements Serializable {

    private Long prmInvoiceStatusId;
    @Size(max = 30)
    private String prmInvoiceStatusCode;
    @Size(max = 255)
    private String prmInvoiceStatusDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmInvoiceStatusCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmInvoiceStatusUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_invoicestatus", allocationSize = 1)
    @Column(name = "prm_invoicestatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmInvoiceStatusId() {
        return prmInvoiceStatusId;
    }

    public void setPrmInvoiceStatusId(Long prmInvoiceStatusId) {
        this.prmInvoiceStatusId = prmInvoiceStatusId;
    }

    @Column(name = "prm_invoicestatuscode")
    public String getPrmInvoiceStatusCode() {
        return prmInvoiceStatusCode;
    }

    public void setPrmInvoiceStatusCode(String prmInvoiceStatusCode) {
        this.prmInvoiceStatusCode = prmInvoiceStatusCode;
    }

    @Column(name = "prm-invoicestatusdescription")
    public String getPrmInvoiceStatusDescription() {
        return prmInvoiceStatusDescription;
    }

    public void setPrmInvoiceStatusDescription(String prmInvoiceStatusDescription) {
        this.prmInvoiceStatusDescription = prmInvoiceStatusDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_invoicestatuscreationdate")
    public Date getPrmInvoiceStatusCreationDate() {
        return prmInvoiceStatusCreationDate;
    }

    public void setPrmInvoiceStatusCreationDate(Date prmInvoiceStatusCreationDate) {
        this.prmInvoiceStatusCreationDate = prmInvoiceStatusCreationDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_invoicestatusupdatedate")
    public Date getPrmInvoiceStatusUpdateDate() {
        return prmInvoiceStatusUpdateDate;
    }

    public void setPrmInvoiceStatusUpdateDate(Date prmInvoiceStatusUpdateDate) {
        this.prmInvoiceStatusUpdateDate = prmInvoiceStatusUpdateDate;
    }
}
