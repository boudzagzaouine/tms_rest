/**
 *
 */
package com.bagile.tms.mapper;

import java.util.*;

/**
 * @author aelguezzar
 */
public class InvoiceRulesMapper {
    private InvoiceRulesMapper() {
    }

    private static Map<String, String> map;


    public static Map<String, String> getMap() {
        return map;
    }

    static {
        map = new HashMap<>();
        map.put("id", "invInvoiceRulesId");
        map.put("code", "invInvoiceRulesCode");
        map.put("price", "invInvoiceRulesPrice");
        map.put("owner", "ownOwner");
        map.put("productActive", "invInvoiceProductActive");
        map.put("movementType", "invMovementType");
        map.put("relevantReception", "invInvoiceRulesRelevantReception");
        map.put("relevantDelivery", "invInvoiceRulesRelevantDelivery");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static InvoiceRules toDto(InvInvoiceRules invInvoiceRules,
                                     boolean lazy) {
        if (null == invInvoiceRules) {
            return null;
        }
        InvoiceRules invoiceRules = new InvoiceRules();
        invoiceRules.setCode(invInvoiceRules.getInvInvoiceRulesCode());

        invoiceRules.setId(invInvoiceRules.getInvInvoiceRulesId());
        invoiceRules.setPrice(invInvoiceRules.getInvInvoiceRulesPrice());
        invoiceRules.setProductActive(invInvoiceRules.isInvInvoiceProductActive());
        invoiceRules.setRelevantDelivery(invInvoiceRules.getInvInvoiceRelevantDelivery());
        invoiceRules.setRelevantReception(invInvoiceRules.getInvInvoiceRelevantReception());
        if (!lazy) {
            invoiceRules.setOwner(OwnerMapper.toDto(invInvoiceRules.getOwnOwner(), true));
            invoiceRules.setMovementType(MovementTypeMapper.toDto(invInvoiceRules.getInvMovementType(), true));
        }
        return invoiceRules;
    }

    public static InvInvoiceRules toEntity(InvoiceRules invoiceRules,
                                           boolean lazy) {
        if (null == invoiceRules) {
            return null;
        }
        InvInvoiceRules invInvoiceRules = new InvInvoiceRules();
        invInvoiceRules.setInvInvoiceRulesCode(invoiceRules.getCode());
        invInvoiceRules.setInvInvoiceRulesId(invoiceRules.getId());
        invInvoiceRules.setInvInvoiceRulesPrice(invoiceRules.getPrice());
        invInvoiceRules.setInvInvoiceProductActive(invoiceRules.isProductActive());
        invInvoiceRules.setInvInvoiceRelevantDelivery(invoiceRules.getRelevantDelivery());
        invInvoiceRules.setInvInvoiceRelevantReception(invoiceRules.getRelevantReception());
        if (!lazy) {
            invInvoiceRules.setOwnOwner(OwnerMapper.toEntity(invoiceRules.getOwner(), true));
            invInvoiceRules.setInvMovementType(MovementTypeMapper.toEntity(invoiceRules.getMovementType(), true));
        }

        return invInvoiceRules;
    }

    public static List<InvoiceRules> toDtos(
            List<InvInvoiceRules> listInvInvoiceRules, boolean lazy) {
        if (null == listInvInvoiceRules) {
            return null;
        }
        List<InvoiceRules> listInvoiceRules = new ArrayList<>();
        for (InvInvoiceRules invInvoiceRules : listInvInvoiceRules) {
            listInvoiceRules.add(toDto(invInvoiceRules, lazy));
        }
        return listInvoiceRules;
    }

    public static List<InvoiceRules> toDtos(
            Iterable<InvInvoiceRules> listInvInvoiceRules, boolean lazy) {
        if (null == listInvInvoiceRules) {
            return null;
        }
        List<InvoiceRules> listInvoiceRules = new ArrayList<>();
        for (InvInvoiceRules invInvoiceRules : listInvInvoiceRules) {
            listInvoiceRules.add(toDto(invInvoiceRules, lazy));
        }
        return listInvoiceRules;
    }

    public static Set<InvInvoiceRules> toEntities(
            Set<InvoiceRules> setInvoiceRules, boolean lazy) {
        if (null == setInvoiceRules) {
            return null;
        }
        Set<InvInvoiceRules> setInvInvoiceRules = new HashSet<>();
        for (InvoiceRules invoiceRules : setInvoiceRules) {
            setInvInvoiceRules.add(toEntity(invoiceRules, lazy));
        }
        return setInvInvoiceRules;
    }

    public static Set<InvoiceRules> toDtos(
            Set<InvInvoiceRules> setInvInvoiceRules, boolean lazy) {
        if (null == setInvInvoiceRules) {
            return null;
        }
        Set<InvoiceRules> listInvoiceRules = new HashSet<>();
        for (InvInvoiceRules invInvoiceRules : setInvInvoiceRules) {
            listInvoiceRules.add(toDto(invInvoiceRules, lazy));
        }
        return listInvoiceRules;
    }

}
