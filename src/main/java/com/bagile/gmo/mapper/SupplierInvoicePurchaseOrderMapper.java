package com.bagile.gmo.mapper;



import com.bagile.gmo.dto.SupplierInvoicePurchaseOrder;
import com.bagile.gmo.entities.InvSupplierInvoicePurchaseOrder;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class SupplierInvoicePurchaseOrderMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invSupplierInvoicePurchaseOrderId");
        map.put("supplierInvoice", "invSupplierInvoice");
        map.put("purshaseOrder", "rcpPurshaseOrder");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvSupplierInvoicePurchaseOrder toEntity(SupplierInvoicePurchaseOrder supplierInvoicePurchaseOrder, boolean lazy) {
        if (null == supplierInvoicePurchaseOrder) {
            return null;
        }
        InvSupplierInvoicePurchaseOrder invSupplierInvoicePurchaseOrder = new InvSupplierInvoicePurchaseOrder();
        invSupplierInvoicePurchaseOrder.setInvSupplierInvoicePurchaseOrderId(supplierInvoicePurchaseOrder.getId());
        if (!lazy) {
            invSupplierInvoicePurchaseOrder.setRcpPurshaseOrder(PurshaseOrderMapper.toEntity(supplierInvoicePurchaseOrder.getPurshaseOrder(), true));
            invSupplierInvoicePurchaseOrder.setInvSupplierInvoice(SupplierInvoiceMapper.toEntity(supplierInvoicePurchaseOrder.getSupplierInvoice(), true));

        }
        return invSupplierInvoicePurchaseOrder;
    }

    public static SupplierInvoicePurchaseOrder toDto(InvSupplierInvoicePurchaseOrder invSupplierInvoicePurchaseOrder, boolean lazy) {
        if (null == invSupplierInvoicePurchaseOrder) {
            return null;
        }
        SupplierInvoicePurchaseOrder supplierInvoicePurchaseOrder = new SupplierInvoicePurchaseOrder();
        supplierInvoicePurchaseOrder.setId(invSupplierInvoicePurchaseOrder.getInvSupplierInvoicePurchaseOrderId());

        if (!lazy) {
            supplierInvoicePurchaseOrder.setSupplierInvoice(SupplierInvoiceMapper.toDto(invSupplierInvoicePurchaseOrder.getInvSupplierInvoice(), true));
            supplierInvoicePurchaseOrder.setPurshaseOrder(PurshaseOrderMapper.toDto(invSupplierInvoicePurchaseOrder.getRcpPurshaseOrder(), true));
        }
        return supplierInvoicePurchaseOrder;
    }



    public static List<SupplierInvoicePurchaseOrder> toDtos(List<InvSupplierInvoicePurchaseOrder> invSupplierInvoicePurchaseOrders, boolean lazy) {
        if (null == invSupplierInvoicePurchaseOrders) {
            return null;
        }
        List<SupplierInvoicePurchaseOrder> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoicePurchaseOrder invSupplierInvoicePurchaseOrder : invSupplierInvoicePurchaseOrders) {
            supplierInvoices.add(toDto(invSupplierInvoicePurchaseOrder, lazy));
        }
        return supplierInvoices;
    }

    public static List<SupplierInvoicePurchaseOrder> toDtos(Iterable<InvSupplierInvoicePurchaseOrder> invSupplierInvoicePurchaseOrders, boolean lazy) {
        if (null == invSupplierInvoicePurchaseOrders) {
            return null;
        }
        List<SupplierInvoicePurchaseOrder> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoicePurchaseOrder invSupplierInvoicePurchaseOrder : invSupplierInvoicePurchaseOrders) {
            supplierInvoices.add(toDto(invSupplierInvoicePurchaseOrder, lazy));
        }
        return supplierInvoices;
    }

    public static Set<InvSupplierInvoicePurchaseOrder> toEntities(Set<SupplierInvoicePurchaseOrder> supplierInvoices, boolean lazy) {
        if (null == supplierInvoices) {
            return null;
        }
        Set<InvSupplierInvoicePurchaseOrder> invSupplierInvoicePurchaseOrders = new HashSet<>();
        for (SupplierInvoicePurchaseOrder supplierInvoicePurchaseOrder : supplierInvoices) {
            invSupplierInvoicePurchaseOrders.add(toEntity(supplierInvoicePurchaseOrder, lazy));
        }
        return invSupplierInvoicePurchaseOrders;
    }

    public static Set<SupplierInvoicePurchaseOrder> toDtos(Set<InvSupplierInvoicePurchaseOrder> invSupplierInvoicePurchaseOrders, boolean lazy) {
        if (null == invSupplierInvoicePurchaseOrders) {
            return null;
        }
        Set<SupplierInvoicePurchaseOrder> supplierInvoices = new HashSet<>();
        for (InvSupplierInvoicePurchaseOrder invSupplierInvoicePurchaseOrder : invSupplierInvoicePurchaseOrders) {
            supplierInvoices.add(toDto(invSupplierInvoicePurchaseOrder, lazy));
        }
        return supplierInvoices;
    }

}
