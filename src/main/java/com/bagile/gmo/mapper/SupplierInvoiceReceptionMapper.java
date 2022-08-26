package com.bagile.gmo.mapper;



import com.bagile.gmo.dto.SupplierInvoiceReception;
import com.bagile.gmo.entities.InvSupplierInvoiceReception;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class SupplierInvoiceReceptionMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invSupplierInvoiceReceptionId");
        map.put("supplierInvoice", "invSupplierInvoice");
        map.put("reception", "rcpReception");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvSupplierInvoiceReception toEntity(SupplierInvoiceReception supplierInvoiceReception, boolean lazy) {
        if (null == supplierInvoiceReception) {
            return null;
        }
        InvSupplierInvoiceReception invSupplierInvoiceReception = new InvSupplierInvoiceReception();
        invSupplierInvoiceReception.setInvSupplierInvoiceReceptionId(supplierInvoiceReception.getId());
        if (!lazy) {
            invSupplierInvoiceReception.setRcpReception(ReceptionMapper.toEntity(supplierInvoiceReception.getReception(), true));
            invSupplierInvoiceReception.setInvSupplierInvoice(SupplierInvoiceMapper.toEntity(supplierInvoiceReception.getSupplierInvoice(), true));

        }
        return invSupplierInvoiceReception;
    }

    public static SupplierInvoiceReception toDto(InvSupplierInvoiceReception invSupplierInvoiceReception, boolean lazy) {
        if (null == invSupplierInvoiceReception) {
            return null;
        }
        SupplierInvoiceReception supplierInvoiceReception = new SupplierInvoiceReception();
        supplierInvoiceReception.setId(invSupplierInvoiceReception.getInvSupplierInvoiceReceptionId());

        if (!lazy) {
            supplierInvoiceReception.setSupplierInvoice(SupplierInvoiceMapper.toDto(invSupplierInvoiceReception.getInvSupplierInvoice(), true));
            supplierInvoiceReception.setReception(ReceptionMapper.toDto(invSupplierInvoiceReception.getRcpReception(), true));
        }
        return supplierInvoiceReception;
    }



    public static List<SupplierInvoiceReception> toDtos(List<InvSupplierInvoiceReception> invSupplierInvoiceReceptions, boolean lazy) {
        if (null == invSupplierInvoiceReceptions) {
            return null;
        }
        List<SupplierInvoiceReception> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoiceReception invSupplierInvoiceReception : invSupplierInvoiceReceptions) {
            supplierInvoices.add(toDto(invSupplierInvoiceReception, lazy));
        }
        return supplierInvoices;
    }

    public static List<SupplierInvoiceReception> toDtos(Iterable<InvSupplierInvoiceReception> invSupplierInvoiceReceptions, boolean lazy) {
        if (null == invSupplierInvoiceReceptions) {
            return null;
        }
        List<SupplierInvoiceReception> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoiceReception invSupplierInvoiceReception : invSupplierInvoiceReceptions) {
            supplierInvoices.add(toDto(invSupplierInvoiceReception, lazy));
        }
        return supplierInvoices;
    }

    public static Set<InvSupplierInvoiceReception> toEntities(Set<SupplierInvoiceReception> supplierInvoices, boolean lazy) {
        if (null == supplierInvoices) {
            return null;
        }
        Set<InvSupplierInvoiceReception> invSupplierInvoiceReceptions = new HashSet<>();
        for (SupplierInvoiceReception supplierInvoiceReception : supplierInvoices) {
            invSupplierInvoiceReceptions.add(toEntity(supplierInvoiceReception, lazy));
        }
        return invSupplierInvoiceReceptions;
    }

    public static Set<SupplierInvoiceReception> toDtos(Set<InvSupplierInvoiceReception> invSupplierInvoiceReceptions, boolean lazy) {
        if (null == invSupplierInvoiceReceptions) {
            return null;
        }
        Set<SupplierInvoiceReception> supplierInvoices = new HashSet<>();
        for (InvSupplierInvoiceReception invSupplierInvoiceReception : invSupplierInvoiceReceptions) {
            supplierInvoices.add(toDto(invSupplierInvoiceReception, lazy));
        }
        return supplierInvoices;
    }

}
