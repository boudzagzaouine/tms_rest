package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 15/12/2016.
 */
public class PaymentSupplierInvoiceMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invPaymentSupplierInvoiceInvoiceId");
        map.put("paymentSupplier", "invPaymentSupplierInvoice");
        map.put("accountInvoice", "invSupplierInvoice");
    }
    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }
    public static InvPaymentSupplierInvoice toEntity(PaymentSupplierInvoice paymentSupplier, boolean lazy) {
        if (null == paymentSupplier) {
            return null;
        }
        InvPaymentSupplierInvoice invPaymentSupplierInvoice=new InvPaymentSupplierInvoice();
        invPaymentSupplierInvoice.setInvPaymentSupplierInvoiceId(paymentSupplier.getId());


        if (!lazy) {
            invPaymentSupplierInvoice.setInvPaymentSupplier(PaymentSupplierMapper.toEntity(paymentSupplier.getPaymentSupplier(), true));
            invPaymentSupplierInvoice.setInvSupplierInvoice(SupplierInvoiceMapper.toEntity(paymentSupplier.getSupplierInvoice(),true));
        }
        return invPaymentSupplierInvoice;
    }

    public static PaymentSupplierInvoice toDto(InvPaymentSupplierInvoice invPaymentSupplierInvoice, boolean lazy) {
        if (null == invPaymentSupplierInvoice) {
            return null;
        }
        PaymentSupplierInvoice paymentSupplierInvoice = new PaymentSupplierInvoice();
        paymentSupplierInvoice.setId(invPaymentSupplierInvoice.getInvPaymentSupplierInvoiceId());
        if (!lazy) {
            paymentSupplierInvoice.setPaymentSupplier(PaymentSupplierMapper.toDto(invPaymentSupplierInvoice.getInvPaymentSupplier(),true));
            paymentSupplierInvoice.setSupplierInvoice(SupplierInvoiceMapper.toDto(invPaymentSupplierInvoice.getInvSupplierInvoice(),true));

        }
        return paymentSupplierInvoice;
    }

    public static List<PaymentSupplierInvoice> toDtos(List<InvPaymentSupplierInvoice> invPaymentSupplierInvoices, boolean lazy) {
        if (null == invPaymentSupplierInvoices) {
            return null;
        }
        List<PaymentSupplierInvoice> paymentSuppliers = new ArrayList<>();
        for (InvPaymentSupplierInvoice invPaymentSupplierInvoice : invPaymentSupplierInvoices) {
            paymentSuppliers.add(toDto(invPaymentSupplierInvoice, lazy));
        }
        return paymentSuppliers;
    }

    public static List<PaymentSupplierInvoice> toDtos(Iterable<InvPaymentSupplierInvoice> invPaymentSupplierInvoices, boolean lazy) {
        if (null == invPaymentSupplierInvoices) {
            return null;
        }
        List<PaymentSupplierInvoice> paymentSuppliers = new ArrayList<>();
        for (InvPaymentSupplierInvoice invPaymentSupplierInvoice : invPaymentSupplierInvoices) {
            paymentSuppliers.add(toDto(invPaymentSupplierInvoice, lazy));
        }
        return paymentSuppliers;
    }

    public static Set<InvPaymentSupplierInvoice> toEntities(Set<PaymentSupplierInvoice> paymentSuppliers, boolean lazy) {
        if (null == paymentSuppliers) {
            return null;
        }
        Set<InvPaymentSupplierInvoice> invPaymentSupplierInvoices = new HashSet<>();
        for (PaymentSupplierInvoice paymentSupplier : paymentSuppliers) {
            invPaymentSupplierInvoices.add(toEntity(paymentSupplier, lazy));
        }
        return invPaymentSupplierInvoices;
    }

    public static Set<PaymentSupplierInvoice> toDtos(Set<InvPaymentSupplierInvoice> invPaymentSupplierInvoices, boolean lazy) {
        if (null == invPaymentSupplierInvoices) {
            return null;
        }
        Set<PaymentSupplierInvoice> paymentSuppliers = new HashSet<>();
        for (InvPaymentSupplierInvoice invPaymentSupplierInvoice : invPaymentSupplierInvoices) {
            paymentSuppliers.add(toDto(invPaymentSupplierInvoice, lazy));
        }
        return paymentSuppliers;
    }
}
