package com.bagile.gmo.dto;

public class SupplierInvoicePurchaseOrder {
    private long id;
   private SupplierInvoice supplierInvoice;
   private PurshaseOrder purshaseOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public PurshaseOrder getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(PurshaseOrder purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }
}
