package com.bagile.tms.mapper;

import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class SupplierInvoiceMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invSupplierInvoiceId");
        map.put("code", "invSupplierInvoiceCode");
        map.put("supplier", "rcpSupplier");
        map.put("creationDate", "invSupplierInvoiceCreationDate");
        map.put("updateDate", "invSupplierInvoiceUpdateDate");
        map.put("priceHt", "invSupplierInvoicePriceHt");
        map.put("priceTTC", "invSupplierInvoicePriceTtc");
        map.put("discount", "invSupplierInvoiceDiscount");
        map.put("deadLine", "invSupplierInvoiceDeadLine");
        map.put("state", "invSupplierInvoiceState");
        map.put("warehouse", "wrhWarehouse");
        map.put("owner", "ownOwner");
        map.put("vat", "invSupplierInvoiceVat");
        map.put("amountPayed", "invSupplierInvoiceAmountPayed");
        map.put("currency", "prmCurrency");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvSupplierInvoice toEntity(SupplierInvoice supplierInvoice, boolean lazy) {
        if (null == supplierInvoice) {
            return null;
        }
        InvSupplierInvoice invSupplierInvoice = new InvSupplierInvoice();
        invSupplierInvoice.setInvSupplierInvoiceId(supplierInvoice.getId());
        invSupplierInvoice.setInvSupplierInvoiceCode(supplierInvoice.getCode() != null ? supplierInvoice.getCode().toUpperCase() : null);
        invSupplierInvoice.setInvSupplierInvoiceCreationDate(supplierInvoice.getCreationDate());
        invSupplierInvoice.setInvSupplierInvoiceUpdateDate(supplierInvoice.getUpdateDate());
        invSupplierInvoice.setInvSupplierInvoicePriceHt(supplierInvoice.getTotalPriceHT());
        invSupplierInvoice.setInvSupplierInvoicePriceTtc(supplierInvoice.getTotalPriceTTC());
        invSupplierInvoice.setInvSupplierInvoiceDeadLine(supplierInvoice.getDeadLine());
        invSupplierInvoice.setInvSupplierInvoiceState(supplierInvoice.getState());
        invSupplierInvoice.setInvSupplierInvoiceDiscount(supplierInvoice.getDiscount());
        invSupplierInvoice.setInvSupplierInvoiceVat(supplierInvoice.getVat());
        invSupplierInvoice.setInvSupplierInvoiceAmountPayed(supplierInvoice.getAmountPayed());
        if (!lazy) {
            invSupplierInvoice.setPrmCurrency(CurrencyMapper.toEntity(supplierInvoice.getCurrency(), true));
            invSupplierInvoice.setWrhWarehouse(WarehouseMapper.toEntity(supplierInvoice.getWarehouse(), true));
            invSupplierInvoice.setOwnOwner(OwnerMapper.toEntity(supplierInvoice.getOwner(), true));
            invSupplierInvoice.setRcpPurshaseOrder(PurshaseOrderMapper.toEntity(supplierInvoice.getPurshaseOrder(), true));
            invSupplierInvoice.setRcpSupplier(SupplierMapper.toEntity(supplierInvoice.getSupplier(), true));
            invSupplierInvoice.setInvSupplierInvoiceLines(SupplierInvoiceLineMapper.toEntities(supplierInvoice.getSupplierInvoiceLines(), false));
        }
        oneToMany(invSupplierInvoice);
        return invSupplierInvoice;
    }

    public static SupplierInvoice toDto(InvSupplierInvoice invSupplierInvoice, boolean lazy) {
        if (null == invSupplierInvoice) {
            return null;
        }
        SupplierInvoice supplierInvoice = new SupplierInvoice();
        supplierInvoice.setId(invSupplierInvoice.getInvSupplierInvoiceId());
        supplierInvoice.setCode(invSupplierInvoice.getInvSupplierInvoiceCode());
        supplierInvoice.setCreationDate(invSupplierInvoice.getInvSupplierInvoiceCreationDate());
        supplierInvoice.setUpdateDate(invSupplierInvoice.getInvSupplierInvoiceUpdateDate());
        supplierInvoice.setTotalPriceHT(invSupplierInvoice.getInvSupplierInvoicePriceHt());
        supplierInvoice.setTotalPriceTTC(invSupplierInvoice.getInvSupplierInvoicePriceTtc());
        supplierInvoice.setDeadLine(invSupplierInvoice.getInvSupplierInvoiceDeadLine());
        supplierInvoice.setState(invSupplierInvoice.getInvSupplierInvoiceState());
        supplierInvoice.setDiscount(invSupplierInvoice.getInvSupplierInvoiceDiscount());
        supplierInvoice.setVat(invSupplierInvoice.getInvSupplierInvoiceVat());
        supplierInvoice.setAmountPayed(invSupplierInvoice.getInvSupplierInvoiceAmountPayed());
        if (!lazy) {
            supplierInvoice.setCurrency(CurrencyMapper.toDto(invSupplierInvoice.getPrmCurrency(), true));
            supplierInvoice.setOwner(OwnerMapper.toDto(invSupplierInvoice.getOwnOwner(), true));
            supplierInvoice.setWarehouse(WarehouseMapper.toDto(invSupplierInvoice.getWrhWarehouse(), true));
            supplierInvoice.setPurshaseOrder(PurshaseOrderMapper.toDto(invSupplierInvoice.getRcpPurshaseOrder(), true));
            supplierInvoice.setSupplier(SupplierMapper.toDto(invSupplierInvoice.getRcpSupplier(), true));
            supplierInvoice.setSupplierInvoiceLines(SupplierInvoiceLineMapper.toDtos(invSupplierInvoice.getInvSupplierInvoiceLines(), false));
        }
        return supplierInvoice;
    }

    public static void oneToMany(InvSupplierInvoice invSupplierInvoice) {
        if (null != invSupplierInvoice.getInvSupplierInvoiceLines()) {
            invSupplierInvoice.getInvSupplierInvoiceLines().stream().forEach(sl -> {
                sl.setInvSupplierInvoice(invSupplierInvoice);
                sl.setInvSupplierInvoiceLineUpdateDate(EmsDate.getDateNow());
                if (0 >= sl.getInvSupplierInvoiceLineId()) {
                    sl.setInvSupplierInvoiceLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<SupplierInvoice> toDtos(List<InvSupplierInvoice> invSupplierInvoices, boolean lazy) {
        if (null == invSupplierInvoices) {
            return null;
        }
        List<SupplierInvoice> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoice invSupplierInvoice : invSupplierInvoices) {
            supplierInvoices.add(toDto(invSupplierInvoice, lazy));
        }
        return supplierInvoices;
    }

    public static List<SupplierInvoice> toDtos(Iterable<InvSupplierInvoice> invSupplierInvoices, boolean lazy) {
        if (null == invSupplierInvoices) {
            return null;
        }
        List<SupplierInvoice> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoice invSupplierInvoice : invSupplierInvoices) {
            supplierInvoices.add(toDto(invSupplierInvoice, lazy));
        }
        return supplierInvoices;
    }

    public static Set<InvSupplierInvoice> toEntities(Set<SupplierInvoice> supplierInvoices, boolean lazy) {
        if (null == supplierInvoices) {
            return null;
        }
        Set<InvSupplierInvoice> invSupplierInvoices = new HashSet<>();
        for (SupplierInvoice supplierInvoice : supplierInvoices) {
            invSupplierInvoices.add(toEntity(supplierInvoice, lazy));
        }
        return invSupplierInvoices;
    }

    public static Set<SupplierInvoice> toDtos(Set<InvSupplierInvoice> invSupplierInvoices, boolean lazy) {
        if (null == invSupplierInvoices) {
            return null;
        }
        Set<SupplierInvoice> supplierInvoices = new HashSet<>();
        for (InvSupplierInvoice invSupplierInvoice : invSupplierInvoices) {
            supplierInvoices.add(toDto(invSupplierInvoice, lazy));
        }
        return supplierInvoices;
    }

}
