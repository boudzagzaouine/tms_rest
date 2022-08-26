package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "inv_supplierinvoice_purchaseorder")
public class InvSupplierInvoicePurchaseOrder extends EmsEntity {
    long invSupplierInvoicePurchaseOrderId;
    private RcpPurshaseOrder rcpPurshaseOrder;
    private InvSupplierInvoice invSupplierInvoice;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "inv_payment_supplier_invoice_inv_payment_supplier_invoice_seq", allocationSize = 1)
    @Column(name = "inv_supplierinvoice_receptionid")
    public long getInvSupplierInvoicePurchaseOrderId() {
        return invSupplierInvoicePurchaseOrderId;
    }

    public void setInvSupplierInvoicePurchaseOrderId(long invSupplierInvoicePurchaseOrderId) {
        this.invSupplierInvoicePurchaseOrderId = invSupplierInvoicePurchaseOrderId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseorderid")
    public RcpPurshaseOrder getRcpPurshaseOrder() {
        return rcpPurshaseOrder;
    }

    public void setRcpPurshaseOrder(RcpPurshaseOrder rcpPurshaseOrder) {
        this.rcpPurshaseOrder = rcpPurshaseOrder;
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
