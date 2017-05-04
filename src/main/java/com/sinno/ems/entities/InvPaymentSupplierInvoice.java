package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Enissay on 15/12/2016.
 */
@Entity
@Table(name = "inv_payment_supplier_invoice")
public class InvPaymentSupplierInvoice {
    private long invPaymentSupplierInvoiceId;
    @NotNull
    private InvSupplierInvoice invSupplierInvoice;
    @NotNull
    private InvPaymentSupplier invPaymentSupplier;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_payment_supplier_invoice_inv_payment_supplier_invoice_seq", allocationSize = 1)
    @Column(name = "inv_payment_supplier_invoiceid")
    public long getInvPaymentSupplierInvoiceId() {
        return invPaymentSupplierInvoiceId;
    }

    public void setInvPaymentSupplierInvoiceId(long invPaymentSupplierInvoiceId) {
        this.invPaymentSupplierInvoiceId = invPaymentSupplierInvoiceId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_payment_supplier_invoiceinvoiceid")
    public InvSupplierInvoice getInvSupplierInvoice() {
        return invSupplierInvoice;
    }

    public void setInvSupplierInvoice(InvSupplierInvoice invSupplierInvoice) {
        this.invSupplierInvoice = invSupplierInvoice;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_payment_supplier_invoicesupplierid")
    public InvPaymentSupplier getInvPaymentSupplier() {
        return invPaymentSupplier;
    }

    public void setInvPaymentSupplier(InvPaymentSupplier invPaymentSupplier) {
        this.invPaymentSupplier = invPaymentSupplier;
    }
}
