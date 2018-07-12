package com.sinno.ems.mapper;

import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class AccountInvoiceMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invAccountInvoiceId");
        map.put("code", "invAccountInvoiceCode");
        map.put("account", "cmdAccount");
        map.put("creationDate", "invAccountInvoiceCreationDate");
        map.put("updateDate", "invAccountInvoiceUpdateDate");
        map.put("priceHt", "invAccountInvoicePriceHt");
        map.put("priceTTC", "invAccountInvoicePriceTTC");
        map.put("discount", "invAccountInvoiceDiscount");
        map.put("deadLine", "invAccountInvoiceDeadLine");
        map.put("state", "invAccountInvoiceState");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("warehouse", "wrhWarehouse");
        map.put("owner", "ownOwner");
        map.put("vat", "invAccountInvoiceVat");
        map.put("amountPayed", "invAccountInvoiceAmountPayed");
        map.put("currency", "prmCurrency");

        //map.put("organisation", "prmPaymentTypeOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvAccountInvoice toEntity(AccountInvoice accountInvoice, boolean lazy) {
        if (null == accountInvoice) {
            return null;
        }
        InvAccountInvoice invAccountInvoice = new InvAccountInvoice();
        invAccountInvoice.setInvAccountInvoiceId(accountInvoice.getId());
        invAccountInvoice.setInvAccountInvoiceCode(accountInvoice.getCode() != null ? accountInvoice.getCode().toUpperCase() : null);
        invAccountInvoice.setInvAccountInvoiceCreationDate(accountInvoice.getCreationDate());
        invAccountInvoice.setInvAccountInvoiceUpdateDate(accountInvoice.getUpdateDate());
        invAccountInvoice.setInvAccountInvoicePriceHt(accountInvoice.getTotalPriceHT());
        invAccountInvoice.setInvAccountInvoicePriceTTC(accountInvoice.getTotalPriceTTC());
        invAccountInvoice.setInvAccountInvoiceDeadLine(accountInvoice.getDeadLine());
        invAccountInvoice.setInvAccountInvoiceState(accountInvoice.getState());
        invAccountInvoice.setInvAccountInvoiceDiscount(accountInvoice.getDiscount());
        invAccountInvoice.setInvAccountInvoiceVat(accountInvoice.getVat());
        invAccountInvoice.setInvAccountInvoiceAmountPayed(accountInvoice.getAmountPayed());

        if (!lazy) {
            invAccountInvoice.setPrmCurrency(CurrencyMapper.toEntity(accountInvoice.getCurrency(), true));
            invAccountInvoice.setCmdAccount(AccountMapper.toEntity(accountInvoice.getAccount(), true));
            invAccountInvoice.setInvAccountInvoiceLines(AccountInvoiceLineMapper.toEntities(accountInvoice.getAccountInvoiceLines(), false));
            invAccountInvoice.setCmdSaleOrder(SaleOrderMapper.toEntity(accountInvoice.getSaleOrder(), true));
            invAccountInvoice.setOwnOwner(OwnerMapper.toEntity(accountInvoice.getOwner(), true));
            invAccountInvoice.setWrhWarehouse(WarehouseMapper.toEntity(accountInvoice.getWarehouse(), true));
        }
        oneToMany(invAccountInvoice);
        return invAccountInvoice;
    }

    public static AccountInvoice toDto(InvAccountInvoice invAccountInvoice, boolean lazy) {
        if (null == invAccountInvoice) {
            return null;
        }
        AccountInvoice accountInvoice = new AccountInvoice();
        accountInvoice.setId(invAccountInvoice.getInvAccountInvoiceId());
        accountInvoice.setCode(invAccountInvoice.getInvAccountInvoiceCode());
        accountInvoice.setCreationDate(invAccountInvoice.getInvAccountInvoiceCreationDate());
        accountInvoice.setUpdateDate(invAccountInvoice.getInvAccountInvoiceUpdateDate());
        accountInvoice.setTotalPriceHT(invAccountInvoice.getInvAccountInvoicePriceHt());
        accountInvoice.setTotalPriceTTC(invAccountInvoice.getInvAccountInvoicePriceTTC());
        accountInvoice.setDeadLine(invAccountInvoice.getInvAccountInvoiceDeadLine());
        accountInvoice.setState(invAccountInvoice.getInvAccountInvoiceState());
        accountInvoice.setDiscount(invAccountInvoice.getInvAccountInvoiceDiscount());
        accountInvoice.setVat(invAccountInvoice.getInvAccountInvoiceVat());
        accountInvoice.setAmountPayed(invAccountInvoice.getInvAccountInvoiceAmountPayed());
        if (!lazy) {
            accountInvoice.setCurrency(CurrencyMapper.toDto(invAccountInvoice.getPrmCurrency(), true));
            accountInvoice.setOwner(OwnerMapper.toDto(invAccountInvoice.getOwnOwner(), true));
            accountInvoice.setWarehouse(WarehouseMapper.toDto(invAccountInvoice.getWrhWarehouse(), true));
            accountInvoice.setAccount(AccountMapper.toDto(invAccountInvoice.getCmdAccount(), true));
            accountInvoice.setAccountInvoiceLines(AccountInvoiceLineMapper.toDtos(invAccountInvoice.getInvAccountInvoiceLines(), false));
            accountInvoice.setSaleOrder(SaleOrderMapper.toDto(invAccountInvoice.getCmdSaleOrder(), true));
        }
        return accountInvoice;
    }

    public static void oneToMany(InvAccountInvoice invAccountInvoice) {
        if (null != invAccountInvoice.getInvAccountInvoiceLines()) {
            invAccountInvoice.getInvAccountInvoiceLines().stream().forEach(sl -> {
                sl.setInvAccountInvoice(invAccountInvoice);
                sl.setInvAccountInvoiceLineUpdateDate(EmsDate.getDateNow());
                if (0 >= sl.getInvAccountInvoiceLineId()) {
                    sl.setInvAccountInvoiceLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<AccountInvoice> toDtos(List<InvAccountInvoice> invAccountInvoices, boolean lazy) {
        if (null == invAccountInvoices) {
            return null;
        }
        List<AccountInvoice> accountInvoices = new ArrayList<>();
        for (InvAccountInvoice invAccountInvoice : invAccountInvoices) {
            accountInvoices.add(toDto(invAccountInvoice, lazy));
        }
        return accountInvoices;
    }

    public static List<AccountInvoice> toDtos(Iterable<InvAccountInvoice> invAccountInvoices, boolean lazy) {
        if (null == invAccountInvoices) {
            return null;
        }
        List<AccountInvoice> accountInvoices = new ArrayList<>();
        for (InvAccountInvoice invAccountInvoice : invAccountInvoices) {
            accountInvoices.add(toDto(invAccountInvoice, lazy));
        }
        return accountInvoices;
    }

    public static Set<InvAccountInvoice> toEntities(Set<AccountInvoice> accountInvoices, boolean lazy) {
        if (null == accountInvoices) {
            return null;
        }
        Set<InvAccountInvoice> invAccountInvoices = new HashSet<>();
        for (AccountInvoice accountInvoice : accountInvoices) {
            invAccountInvoices.add(toEntity(accountInvoice, lazy));
        }
        return invAccountInvoices;
    }

    public static Set<AccountInvoice> toDtos(Set<InvAccountInvoice> invAccountInvoices, boolean lazy) {
        if (null == invAccountInvoices) {
            return null;
        }
        Set<AccountInvoice> accountInvoices = new HashSet<>();
        for (InvAccountInvoice invAccountInvoice : invAccountInvoices) {
            accountInvoices.add(toDto(invAccountInvoice, lazy));
        }
        return accountInvoices;
    }

}
