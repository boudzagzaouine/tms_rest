package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "inv_supplierinvoice_reception")
public class InvSupplierInvoiceReception extends EmsEntity{
    long invSupplierInvoiceReceptionId;
    private RcpReception rcpReception;
    private InvSupplierInvoice invSupplierInvoice;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_payment_supplier_invoice_inv_payment_supplier_invoice_seq", allocationSize = 1)
    @Column(name = "inv_supplierinvoice_receptionid")
    public long getInvSupplierInvoiceReceptionId() {
        return invSupplierInvoiceReceptionId;
    }

    public void setInvSupplierInvoiceReceptionId(long invSupplierInvoiceReceptionId) {
        this.invSupplierInvoiceReceptionId = invSupplierInvoiceReceptionId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receptionid")
    public RcpReception getRcpReception() {
        return rcpReception;
    }

    public void setRcpReception(RcpReception rcpReception) {
        this.rcpReception = rcpReception;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceid")
    public InvSupplierInvoice getInvSupplierInvoice() {
        return invSupplierInvoice;
    }

    public void setInvSupplierInvoice(InvSupplierInvoice invSupplierInvoice) {
        this.invSupplierInvoice = invSupplierInvoice;
    }
}
