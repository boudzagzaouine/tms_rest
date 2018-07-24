package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Enissay on 05/12/2016.
 */
public class AccountInvoiceLineMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "InvAccountInvoiceId");
        map.put("number", "InvAccountInvoiceLineNumber");
        map.put("creationDate", "InvAccountInvoiceLineCreationDate");
        map.put("updateDate", "InvAccountInvoiceLineUpdateDate");
        map.put("pricetHt", "InvAccountInvoiceLinePriceHt");
        map.put("priceTTC", "InvAccountInvoiceLinePriceTTC");
        map.put("quantity", "InvAccountInvoiceLineQuantity");
        map.put("discount", "InvAccountInvoiceLineDiscount");
        map.put("quantity", "InvAccountInvoiceState");
        map.put("invoiceAccount", "InvAccountInvoiceState");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("tarifPrice", "InvAccountInvoiceLineTarifPrice");
        map.put("vat", "prmVat");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvAccountInvoiceLine toEntity(AccountInvoiceLine accountInvoiceLine, boolean lazy) {
        if (null == accountInvoiceLine) {
            return null;
        }
        InvAccountInvoiceLine invAccountInvoiceLine = new InvAccountInvoiceLine();
        invAccountInvoiceLine.setInvAccountInvoiceLineId(accountInvoiceLine.getId());
        invAccountInvoiceLine.setInvAccountInvoiceLineNumber(accountInvoiceLine.getNumber());
        invAccountInvoiceLine.setInvAccountInvoiceLineCreationDate(accountInvoiceLine.getCreationDate());
        invAccountInvoiceLine.setInvAccountInvoiceLineUpdateDate(accountInvoiceLine.getUpdateDate());
        invAccountInvoiceLine.setInvAccountInvoiceLinePriceHt(accountInvoiceLine.getTotalPriceHT());
        invAccountInvoiceLine.setInvAccountInvoiceLinePriceTTC(accountInvoiceLine.getTotalPriceTTC());
        invAccountInvoiceLine.setInvAccountInvoiceLineDiscount(accountInvoiceLine.getDiscount());
        invAccountInvoiceLine.setInvAccountInvoiceLineTarifPrice(accountInvoiceLine.getTarifPrice());
        invAccountInvoiceLine.setInvAccountInvoiceLineQuantity(accountInvoiceLine.getQuantity());

        if (!lazy) {
            invAccountInvoiceLine.setPrmVat(VatMapper.toEntity(accountInvoiceLine.getVat(), true));
            invAccountInvoiceLine.setPdtProduct(ProductMapper.toEntity(accountInvoiceLine.getProduct(), true));
            invAccountInvoiceLine.setPdtUom(UomMapper.toEntity(accountInvoiceLine.getUom(), true));
            invAccountInvoiceLine.setInvAccountInvoice(AccountInvoiceMapper.toEntity(accountInvoiceLine.getAccountInvoice(), true));
        }
        return invAccountInvoiceLine;
    }

    public static AccountInvoiceLine toDto(InvAccountInvoiceLine invAccountInvoiceLine, boolean lazy) {
        if (null == invAccountInvoiceLine) {
            return null;
        }
        AccountInvoiceLine accountInvoiceLine = new AccountInvoiceLine();
        accountInvoiceLine.setId(invAccountInvoiceLine.getInvAccountInvoiceLineId());
        accountInvoiceLine.setNumber(invAccountInvoiceLine.getInvAccountInvoiceLineNumber());
        accountInvoiceLine.setCreationDate(invAccountInvoiceLine.getInvAccountInvoiceLineCreationDate());
        accountInvoiceLine.setUpdateDate(invAccountInvoiceLine.getInvAccountInvoiceLineUpdateDate());
        accountInvoiceLine.setTotalPriceHT(invAccountInvoiceLine.getInvAccountInvoiceLinePriceHt());
        accountInvoiceLine.setTotalPriceTTC(invAccountInvoiceLine.getInvAccountInvoiceLinePriceTTC());
        accountInvoiceLine.setDiscount(invAccountInvoiceLine.getInvAccountInvoiceLineDiscount());
        accountInvoiceLine.setTarifPrice(invAccountInvoiceLine.getInvAccountInvoiceLineTarifPrice());
        accountInvoiceLine.setQuantity(invAccountInvoiceLine.getInvAccountInvoiceLineQuantity());

        if (!lazy) {
            accountInvoiceLine.setVat(VatMapper.toDto(invAccountInvoiceLine.getPrmVat(), true));
            accountInvoiceLine.setProduct(ProductMapper.toDto(invAccountInvoiceLine.getPdtProduct(), true));
            accountInvoiceLine.setUom(UomMapper.toDto(invAccountInvoiceLine.getPdtUom(), true));
            accountInvoiceLine.setAccountInvoice(AccountInvoiceMapper.toDto(invAccountInvoiceLine.getInvAccountInvoice(), true));
        }
        return accountInvoiceLine;
    }

    public static List<AccountInvoiceLine> toDtos(List<InvAccountInvoiceLine> invAccountInvoiceLines, boolean lazy) {
        if (null == invAccountInvoiceLines) {
            return null;
        }
        List<AccountInvoiceLine> accountInvoiceLines = new ArrayList<>();
        for (InvAccountInvoiceLine invAccountInvoiceLine : invAccountInvoiceLines) {
            accountInvoiceLines.add(toDto(invAccountInvoiceLine, lazy));
        }
        return accountInvoiceLines;
    }

    public static List<AccountInvoiceLine> toDtos(Iterable<InvAccountInvoiceLine> invAccountInvoices, boolean lazy) {
        if (null == invAccountInvoices) {
            return null;
        }
        List<AccountInvoiceLine> accountInvoices = new ArrayList<>();
        for (InvAccountInvoiceLine invAccountInvoiceLine : invAccountInvoices) {
            accountInvoices.add(toDto(invAccountInvoiceLine, lazy));
        }
        return accountInvoices;
    }

    public static Set<InvAccountInvoiceLine> toEntities(Set<AccountInvoiceLine> accountInvoiceLines, boolean lazy) {
        if (null == accountInvoiceLines) {
            return null;
        }
        Set<InvAccountInvoiceLine> invAccountInvoices = new HashSet<>();
        for (AccountInvoiceLine accountInvoice : accountInvoiceLines) {
            invAccountInvoices.add(toEntity(accountInvoice, lazy));
        }
        return invAccountInvoices;
    }

    public static Set<AccountInvoiceLine> toDtos(Set<InvAccountInvoiceLine> invAccountInvoiceLines, boolean lazy) {
        if (null == invAccountInvoiceLines) {
            return null;
        }
        Set<AccountInvoiceLine> accountInvoices = new HashSet<>();
        for (InvAccountInvoiceLine invAccountInvoiceLine : invAccountInvoiceLines) {
            accountInvoices.add(toDto(invAccountInvoiceLine, lazy));
        }
        return accountInvoices;
    }


}
