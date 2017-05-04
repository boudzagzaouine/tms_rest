package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Enissay on 15/12/2016.
 */
@Entity
@Table(name = "inv_payment_account_invoice")
public class InvPaymentAccountInvoice {
    private long invPaymentAccountInvoiceId;
    @NotNull
    private InvAccountInvoice invAccountInvoice;
    @NotNull
    private InvPaymentAccount invPaymentAccount;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_payment_account_invoice_inv_payment_account_invoice_seq", allocationSize = 1)
    @Column(name = "inv_payment_account_invoiceid")
    public long getInvPaymentAccountInvoiceId() {
        return invPaymentAccountInvoiceId;
    }

    public void setInvPaymentAccountInvoiceId(long invPaymentAccountInvoiceId) {
        this.invPaymentAccountInvoiceId = invPaymentAccountInvoiceId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_payment_account_invoiceinvoiceid")
    public InvAccountInvoice getInvAccountInvoice() {
        return invAccountInvoice;
    }

    public void setInvAccountInvoice(InvAccountInvoice invAccountInvoice) {
        this.invAccountInvoice = invAccountInvoice;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_payment_account_invoiceacountid")
    public InvPaymentAccount getInvPaymentAccount() {
        return invPaymentAccount;
    }

    public void setInvPaymentAccount(InvPaymentAccount invPaymentAccount) {
        this.invPaymentAccount = invPaymentAccount;
    }
}
