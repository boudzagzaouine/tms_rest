package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PaymentAccountMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invPaymentAccountId");
        map.put("paymentDate", "invPaymentAccountDate");
        map.put("account", "cmdAccount");
        map.put("creationDate", "invPaymentAccountCreationDate");
        map.put("updateDate", "invPaymentAccountUpdateDate");
        map.put("accountInvoice", "invAccountInvoice");
        map.put("amount", "invPaymentAccountAmount");
        map.put("paymentType", "prmPaymentType");
        map.put("assetAccount", "cmdAssetAccount");
        map.put("currency", "prmCurrency");

        //map.put("organisation", "prmPaymentTypeOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvPaymentAccount toEntity(PaymentAccount paymentAccount, boolean lazy) {
        if (null == paymentAccount) {
            return null;
        }
        InvPaymentAccount invPaymentAccount = new InvPaymentAccount();
        invPaymentAccount.setInvPaymentAccountId(paymentAccount.getId());
        invPaymentAccount.setInvPaymentAccountDate(paymentAccount.getPaymentDate());
        invPaymentAccount.setInvPaymentAccountAmount(paymentAccount.getAmount());
        invPaymentAccount.setInvPaymentAccountCreationDate(paymentAccount.getCreationDate());
        invPaymentAccount.setInvPaymentAccountUpdateDate(paymentAccount.getUpdateDate());
        invPaymentAccount.setInvPaymentAccountNumber(paymentAccount.getNumber());

        if (!lazy) {
            invPaymentAccount.setPrmCurrency(CurrencyMapper.toEntity(paymentAccount.getCurrency(), true));
            invPaymentAccount.setCmdAssetAccount(AssetAccountMapper.toEntity(paymentAccount.getAssetAccount(), true));
            invPaymentAccount.setPrmPaymentType(PaymentTypeMapper.toEntity(paymentAccount.getPaymentType(), true));
            invPaymentAccount.setCmdAccount(AccountMapper.toEntity(paymentAccount.getAccount(), true));
            invPaymentAccount.setInvAccountInvoice(AccountInvoiceMapper.toEntity(paymentAccount.getAccountInvoice(), true));
        }
        return invPaymentAccount;
    }

    public static PaymentAccount toDto(InvPaymentAccount invPaymentAccount, boolean lazy) {
        if (null == invPaymentAccount) {
            return null;
        }
        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setId(invPaymentAccount.getInvPaymentAccountId());
        paymentAccount.setPaymentDate(invPaymentAccount.getInvPaymentAccountDate());
        paymentAccount.setAmount(invPaymentAccount.getInvPaymentAccountAmount());
        paymentAccount.setCreationDate(invPaymentAccount.getInvPaymentAccountCreationDate());
        paymentAccount.setUpdateDate(invPaymentAccount.getInvPaymentAccountUpdateDate());
        paymentAccount.setNumber(invPaymentAccount.getInvPaymentAccountNumber());

        if (!lazy) {
            paymentAccount.setCurrency(CurrencyMapper.toDto(invPaymentAccount.getPrmCurrency(), true));
            paymentAccount.setAssetAccount(AssetAccountMapper.toDto(invPaymentAccount.getCmdAssetAccount(), true));
            paymentAccount.setPaymentType(PaymentTypeMapper.toDto(invPaymentAccount.getPrmPaymentType(), true));
            paymentAccount.setAccount(AccountMapper.toDto(invPaymentAccount.getCmdAccount(), true));
            paymentAccount.setAccountInvoice(AccountInvoiceMapper.toDto(invPaymentAccount.getInvAccountInvoice(), true));

        }
        return paymentAccount;
    }

    public static List<PaymentAccount> toDtos(List<InvPaymentAccount> invPaymentAccounts, boolean lazy) {
        if (null == invPaymentAccounts) {
            return null;
        }
        List<PaymentAccount> paymentAccounts = new ArrayList<>();
        for (InvPaymentAccount invPaymentAccount : invPaymentAccounts) {
            paymentAccounts.add(toDto(invPaymentAccount, lazy));
        }
        return paymentAccounts;
    }

    public static List<PaymentAccount> toDtos(Iterable<InvPaymentAccount> invPaymentAccounts, boolean lazy) {
        if (null == invPaymentAccounts) {
            return null;
        }
        List<PaymentAccount> paymentAccounts = new ArrayList<>();
        for (InvPaymentAccount invPaymentAccount : invPaymentAccounts) {
            paymentAccounts.add(toDto(invPaymentAccount, lazy));
        }
        return paymentAccounts;
    }

    public static Set<InvPaymentAccount> toEntities(Set<PaymentAccount> paymentAccounts, boolean lazy) {
        if (null == paymentAccounts) {
            return null;
        }
        Set<InvPaymentAccount> invPaymentAccounts = new HashSet<>();
        for (PaymentAccount paymentAccount : paymentAccounts) {
            invPaymentAccounts.add(toEntity(paymentAccount, lazy));
        }
        return invPaymentAccounts;
    }

    public static Set<PaymentAccount> toDtos(Set<InvPaymentAccount> invPaymentAccounts, boolean lazy) {
        if (null == invPaymentAccounts) {
            return null;
        }
        Set<PaymentAccount> paymentAccounts = new HashSet<>();
        for (InvPaymentAccount invPaymentAccount : invPaymentAccounts) {
            paymentAccounts.add(toDto(invPaymentAccount, lazy));
        }
        return paymentAccounts;
    }
}
