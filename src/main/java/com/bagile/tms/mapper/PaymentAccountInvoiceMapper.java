package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Enissay on 15/12/2016.
 */
public class PaymentAccountInvoiceMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invPaymentAccountInvoiceInvoiceId");
        map.put("paymentAccount", "invPaymentAccountInvoice");
        map.put("accountInvoice", "invAccountInvoice");
    }
    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }
    public static InvPaymentAccountInvoice toEntity(PaymentAccountInvoice paymentAccountInvoice, boolean lazy) {
        if (null == paymentAccountInvoice) {
            return null;
        }
        InvPaymentAccountInvoice invPaymentAccountInvoice=new InvPaymentAccountInvoice();
        invPaymentAccountInvoice.setInvPaymentAccountInvoiceId(paymentAccountInvoice.getId());


        if (!lazy) {
            invPaymentAccountInvoice.setInvPaymentAccount(PaymentAccountMapper.toEntity(paymentAccountInvoice.getPaymentAccount(), true));
            invPaymentAccountInvoice.setInvAccountInvoice(AccountInvoiceMapper.toEntity(paymentAccountInvoice.getAccountInvoice(),true));
        }
        return invPaymentAccountInvoice;
    }

    public static PaymentAccountInvoice toDto(InvPaymentAccountInvoice invPaymentAccountInvoice, boolean lazy) {
        if (null == invPaymentAccountInvoice) {
            return null;
        }
        PaymentAccountInvoice paymentAccountInvoice = new PaymentAccountInvoice();
        paymentAccountInvoice.setId(invPaymentAccountInvoice.getInvPaymentAccountInvoiceId());
        if (!lazy) {
            paymentAccountInvoice.setPaymentAccount(PaymentAccountMapper.toDto(invPaymentAccountInvoice.getInvPaymentAccount(),true));
            paymentAccountInvoice.setAccountInvoice(AccountInvoiceMapper.toDto(invPaymentAccountInvoice.getInvAccountInvoice(),true));

        }
        return paymentAccountInvoice;
    }

    public static List<PaymentAccountInvoice> toDtos(List<InvPaymentAccountInvoice> invPaymentAccountInvoices, boolean lazy) {
        if (null == invPaymentAccountInvoices) {
            return null;
        }
        List<PaymentAccountInvoice> paymentAccounts = new ArrayList<>();
        for (InvPaymentAccountInvoice invPaymentAccountInvoice : invPaymentAccountInvoices) {
            paymentAccounts.add(toDto(invPaymentAccountInvoice, lazy));
        }
        return paymentAccounts;
    }

    public static List<PaymentAccountInvoice> toDtos(Iterable<InvPaymentAccountInvoice> invPaymentAccountInvoices, boolean lazy) {
        if (null == invPaymentAccountInvoices) {
            return null;
        }
        List<PaymentAccountInvoice> paymentAccounts = new ArrayList<>();
        for (InvPaymentAccountInvoice invPaymentAccountInvoice : invPaymentAccountInvoices) {
            paymentAccounts.add(toDto(invPaymentAccountInvoice, lazy));
        }
        return paymentAccounts;
    }

    public static Set<InvPaymentAccountInvoice> toEntities(Set<PaymentAccountInvoice> paymentAccounts, boolean lazy) {
        if (null == paymentAccounts) {
            return null;
        }
        Set<InvPaymentAccountInvoice> invPaymentAccountInvoices = new HashSet<>();
        for (PaymentAccountInvoice paymentAccount : paymentAccounts) {
            invPaymentAccountInvoices.add(toEntity(paymentAccount, lazy));
        }
        return invPaymentAccountInvoices;
    }

    public static Set<PaymentAccountInvoice> toDtos(Set<InvPaymentAccountInvoice> invPaymentAccountInvoices, boolean lazy) {
        if (null == invPaymentAccountInvoices) {
            return null;
        }
        Set<PaymentAccountInvoice> paymentAccounts = new HashSet<>();
        for (InvPaymentAccountInvoice invPaymentAccountInvoice : invPaymentAccountInvoices) {
            paymentAccounts.add(toDto(invPaymentAccountInvoice, lazy));
        }
        return paymentAccounts;
    }
}
