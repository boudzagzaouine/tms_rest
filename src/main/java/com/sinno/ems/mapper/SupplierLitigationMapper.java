package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class SupplierLitigationMapper {
    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "invSupplierLitigationId");
        map.put("amount", "invSupplierLitigationAmount");
        map.put("supplier", "rcpSupplier");
        map.put("creationDate", "invSupplierLitigationCreationDate");
        map.put("updateDate", "invSupplierLitigationUpdateDate");
        map.put("supplierInvoice", "invSupplierInvoice");
        map.put("objet", "invSupplierLitigationObject");
        map.put("comment", "invSupplierLitigationComment");
        map.put("currency", "prmCurrency");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvSupplierLitigation toEntity(SupplierLitigation supplierLitigation, boolean lazy) {
        if (null == supplierLitigation) {
            return null;
        }
        InvSupplierLitigation invSupplierLitigation = new InvSupplierLitigation();
        invSupplierLitigation.setInvSupplierLitigationId(supplierLitigation.getId());
        invSupplierLitigation.setInvSupplierLitigationAmount(supplierLitigation.getAmount());
        invSupplierLitigation.setInvSupplierLitigationComment(supplierLitigation.getComment());
        invSupplierLitigation.setInvSupplierLitigationObject(supplierLitigation.getObjet());
        invSupplierLitigation.setInvSupplierLitigationCreationDate(supplierLitigation.getCreationDate());
        invSupplierLitigation.setInvSupplierLitigationUpdateDate(supplierLitigation.getUpdateDate());

        if (!lazy) {
            invSupplierLitigation.setPrmCurrency(CurrencyMapper.toEntity(supplierLitigation.getCurrency(), true));
            invSupplierLitigation.setInvSupplierInvoice(SupplierInvoiceMapper.toEntity(supplierLitigation.getSupplierInvoice(), true));
            invSupplierLitigation.setRcpSupplier(SupplierMapper.toEntity(supplierLitigation.getSupplier(), true));
        }
        return invSupplierLitigation;
    }

    public static SupplierLitigation toDto(InvSupplierLitigation invSupplierLitigation, boolean lazy) {
        if (null == invSupplierLitigation) {
            return null;
        }
        SupplierLitigation supplierLitigation = new SupplierLitigation();
        supplierLitigation.setId(invSupplierLitigation.getInvSupplierLitigationId());
        supplierLitigation.setAmount(invSupplierLitigation.getInvSupplierLitigationAmount());
        supplierLitigation.setComment(invSupplierLitigation.getInvSupplierLitigationComment());
        supplierLitigation.setObjet(invSupplierLitigation.getInvSupplierLitigationObject());
        supplierLitigation.setCreationDate(invSupplierLitigation.getInvSupplierLitigationCreationDate());
        supplierLitigation.setUpdateDate(invSupplierLitigation.getInvSupplierLitigationUpdateDate());

        if (!lazy) {
            supplierLitigation.setCurrency(CurrencyMapper.toDto(invSupplierLitigation.getPrmCurrency(), true));
            supplierLitigation.setSupplierInvoice(SupplierInvoiceMapper.toDto(invSupplierLitigation.getInvSupplierInvoice(), true));
            supplierLitigation.setSupplier(SupplierMapper.toDto(invSupplierLitigation.getRcpSupplier(), true));
        }
        return supplierLitigation;
    }

    public static List<SupplierLitigation> toDtos(List<InvSupplierLitigation> invSupplierLitigations, boolean lazy) {
        if (null == invSupplierLitigations) {
            return null;
        }
        List<SupplierLitigation> supplierLitigations = new ArrayList<>();
        for (InvSupplierLitigation invSupplierLitigation : invSupplierLitigations) {
            supplierLitigations.add(toDto(invSupplierLitigation, lazy));
        }
        return supplierLitigations;
    }

    public static List<SupplierLitigation> toDtos(Iterable<InvSupplierLitigation> invSupplierLitigations, boolean lazy) {
        if (null == invSupplierLitigations) {
            return null;
        }
        List<SupplierLitigation> supplierLitigations = new ArrayList<>();
        for (InvSupplierLitigation invSupplierLitigation : invSupplierLitigations) {
            supplierLitigations.add(toDto(invSupplierLitigation, lazy));
        }
        return supplierLitigations;
    }

    public static Set<InvSupplierLitigation> toEntities(Set<SupplierLitigation> supplierLitigations, boolean lazy) {
        if (null == supplierLitigations) {
            return null;
        }
        Set<InvSupplierLitigation> invSupplierLitigations = new HashSet<>();
        for (SupplierLitigation supplierLitigation : supplierLitigations) {
            invSupplierLitigations.add(toEntity(supplierLitigation, lazy));
        }
        return invSupplierLitigations;
    }

    public static Set<SupplierLitigation> toDtos(Set<InvSupplierLitigation> invSupplierLitigations, boolean lazy) {
        if (null == invSupplierLitigations) {
            return null;
        }
        Set<SupplierLitigation> supplierLitigations = new HashSet<>();
        for (InvSupplierLitigation invSupplierLitigation : invSupplierLitigations) {
            supplierLitigations.add(toDto(invSupplierLitigation, lazy));
        }
        return supplierLitigations;
    }
}
