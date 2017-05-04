package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Enissay on 02/12/2016.
 */
@Entity
@Table(name = "inv_invoiceterm", uniqueConstraints = @UniqueConstraint(columnNames = "inv_invoicetermcode"))
public class InvInvoiceTerm {
    private long invInvoiceTermId;
    @NotNull
    private String invInvoiceTermCode;
    private String invInvoiceTermDescription;
    private Date invInvoiceTermCreationDate;
    private Date InvInvoiceTermUpdateDate;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "schema_ems.inv_invoiceterm_inv_invoicetermid_seq", allocationSize = 1)
    @Column(name = "inv_invoicetermid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getInvInvoiceTermId() {
        return invInvoiceTermId;
    }

    public void setInvInvoiceTermId(long invInvoiceTermId) {
        this.invInvoiceTermId = invInvoiceTermId;
    }
    @Column(name = "inv_invoicetermcode")
    public String getInvInvoiceTermCode() {
        return invInvoiceTermCode;
    }

    public void setInvInvoiceTermCode(String invInvoiceTermCode) {
        this.invInvoiceTermCode = invInvoiceTermCode;
    }
    @Column(name = "inv_invoicetermdescription")

    public String getInvInvoiceTermDescription() {
        return invInvoiceTermDescription;
    }

    public void setInvInvoiceTermDescription(String invInvoiceTermDescription) {
        this.invInvoiceTermDescription = invInvoiceTermDescription;
    }
    @Column(name = "inv_invoicetermcreationdate")
    @Temporal(TemporalType.TIMESTAMP)

    public Date getInvInvoiceTermCreationDate() {
        return invInvoiceTermCreationDate;
    }

    public void setInvInvoiceTermCreationDate(Date invInvoiceTermCreationDate) {
        this.invInvoiceTermCreationDate = invInvoiceTermCreationDate;
    }
    @Column(name = "inv_invoicetermupdatedate")
    @Temporal(TemporalType.TIMESTAMP)

    public Date getInvInvoiceTermUpdateDate() {
        return InvInvoiceTermUpdateDate;
    }

    public void setInvInvoiceTermUpdateDate(Date invInvoiceTermUpdateDate) {
        InvInvoiceTermUpdateDate = invInvoiceTermUpdateDate;
    }
}
