package com.bagile.gmo.dto;

public class SupplierInvoiceReception {
    private long id;
   private SupplierInvoice supplierInvoice;
   private Reception reception;

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

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }
}
