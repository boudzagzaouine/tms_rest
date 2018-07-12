package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class AccountLitigationMapper {
    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "InvAccountLitigationId");
        map.put("amount", "InvAccountLitigationAmount");
        map.put("account", "cmdAccount");
        map.put("creationDate", "InvAccountLitigationCreationDate");
        map.put("updateDate", "InvAccountLitigationUpdateDate");
        map.put("accountInvoice", "invAccountInvoice");
        map.put("objet", "InvAccountLitigationObject");
        map.put("comment", "InvAccountLitigationComment");
        map.put("currency", "prmCurrency");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvAccountLitigation toEntity(AccountLitigation accountLitigation, boolean lazy) {
        if (null == accountLitigation) {
            return null;
        }
        InvAccountLitigation invAccountLitigation = new InvAccountLitigation();
        invAccountLitigation.setInvAccountLitigationId(accountLitigation.getId());
        invAccountLitigation.setInvAccountLitigationAmount(accountLitigation.getAmount());
        invAccountLitigation.setInvAccountLitigationComment(accountLitigation.getComment());
        invAccountLitigation.setInvAccountLitigationObject(accountLitigation.getObjet());
        invAccountLitigation.setInvAccountLitigationCreationDate(accountLitigation.getCreationDate());
        invAccountLitigation.setInvAccountLitigationUpdateDate(accountLitigation.getUpdateDate());

        if (!lazy) {
            invAccountLitigation.setPrmCurrency(CurrencyMapper.toEntity(accountLitigation.getCurrency(), true));
            invAccountLitigation.setInvAccountInvoice(AccountInvoiceMapper.toEntity(accountLitigation.getAccountInvoice(), true));
            invAccountLitigation.setCmdAccount(AccountMapper.toEntity(accountLitigation.getAccount(), true));
        }
        return invAccountLitigation;
    }

    public static AccountLitigation toDto(InvAccountLitigation invAccountLitigation, boolean lazy) {
        if (null == invAccountLitigation) {
            return null;
        }
        AccountLitigation accountLitigation = new AccountLitigation();
        accountLitigation.setId(invAccountLitigation.getInvAccountLitigationId());
        accountLitigation.setAmount(invAccountLitigation.getInvAccountLitigationAmount());
        accountLitigation.setComment(invAccountLitigation.getInvAccountLitigationComment());
        accountLitigation.setObjet(invAccountLitigation.getInvAccountLitigationObject());
        accountLitigation.setCreationDate(invAccountLitigation.getInvAccountLitigationCreationDate());
        accountLitigation.setUpdateDate(invAccountLitigation.getInvAccountLitigationUpdateDate());

        if (!lazy) {
            accountLitigation.setCurrency(CurrencyMapper.toDto(invAccountLitigation.getPrmCurrency(),true));
            accountLitigation.setAccountInvoice(AccountInvoiceMapper.toDto(invAccountLitigation.getInvAccountInvoice(), true));
            accountLitigation.setAccount(AccountMapper.toDto(invAccountLitigation.getCmdAccount(), true));
        }
        return accountLitigation;
    }

    public static List<AccountLitigation> toDtos(List<InvAccountLitigation> invAccountLitigations, boolean lazy) {
        if (null == invAccountLitigations) {
            return null;
        }
        List<AccountLitigation> accountLitigations = new ArrayList<>();
        for (InvAccountLitigation invAccountLitigation : invAccountLitigations) {
            accountLitigations.add(toDto(invAccountLitigation, lazy));
        }
        return accountLitigations;
    }

    public static List<AccountLitigation> toDtos(Iterable<InvAccountLitigation> invAccountLitigations, boolean lazy) {
        if (null == invAccountLitigations) {
            return null;
        }
        List<AccountLitigation> accountLitigations = new ArrayList<>();
        for (InvAccountLitigation invAccountLitigation : invAccountLitigations) {
            accountLitigations.add(toDto(invAccountLitigation, lazy));
        }
        return accountLitigations;
    }

    public static Set<InvAccountLitigation> toEntities(Set<AccountLitigation> accountLitigations, boolean lazy) {
        if (null == accountLitigations) {
            return null;
        }
        Set<InvAccountLitigation> invAccountLitigations = new HashSet<>();
        for (AccountLitigation accountLitigation : accountLitigations) {
            invAccountLitigations.add(toEntity(accountLitigation, lazy));
        }
        return invAccountLitigations;
    }

    public static Set<AccountLitigation> toDtos(Set<InvAccountLitigation> invAccountLitigations, boolean lazy) {
        if (null == invAccountLitigations) {
            return null;
        }
        Set<AccountLitigation> accountLitigations = new HashSet<>();
        for (InvAccountLitigation invAccountLitigation : invAccountLitigations) {
            accountLitigations.add(toDto(invAccountLitigation, lazy));
        }
        return accountLitigations;
    }
}
