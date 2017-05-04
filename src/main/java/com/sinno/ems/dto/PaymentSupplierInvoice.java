package com.sinno.ems.dto;

/**
 * Created by Enissay on 15/12/2016.
 */
public class PaymentSupplierInvoice {
    private long id;
    private PaymentSupplier paymentSupplier;
    private SupplierInvoice supplierInvoice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentSupplier getPaymentSupplier() {
        return paymentSupplier;
    }

    public void setPaymentSupplier(PaymentSupplier paymentSupplier) {
        this.paymentSupplier = paymentSupplier;
    }

    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }
}
