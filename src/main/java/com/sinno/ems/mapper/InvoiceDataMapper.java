package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 31/10/2016.
 */
public class InvoiceDataMapper {
    private InvoiceDataMapper() {
    }

    private static Map<String, String> map;


    public static Map<String, String> getMap() {
        return map;
    }

    static {
        map = new HashMap<>();
        map.put("id", "invInvoiceDataId");
        map.put("owner", "ownOwner");
        map.put("movementType", "invMovementType");
        map.put("price", "invInvoiceDataPrice");
        map.put("totalPrice", "invInvoiceDataTotalPrice");
        map.put("quantity", "invInvoiceDataQuantity");
        map.put("invoiceDate", "invInvoiceDataInvoiceDate");
        map.put("creationDate","invInvoiceDataCreationDate");
        map.put("updateDate","invInvoiceDataUpdateDate");
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static InvoiceData toDto(InvInvoiceData invInvoiceData, boolean lazy) {
        if (null == invInvoiceData) {
            return null;
        }
        InvoiceData invoiceData=new InvoiceData();
        invoiceData.setId(invInvoiceData.getInvInvoiceDataId());
        invoiceData.setPrice(invInvoiceData.getInvInvoiceDataPrice());
        invoiceData.setTotalPrice(invInvoiceData.getInvInvoiceDataTotalPrice());
        invoiceData.setQuantity(invInvoiceData.getInvInvoiceDataQuantity());
        invoiceData.setInvoiceDate(invInvoiceData.getInvInvoiceDataInvoiceDate());
        invoiceData.setUpdateDate(invInvoiceData.getInvInvoiceDataUpdateDate());
        invoiceData.setCreationDate(invInvoiceData.getInvInvoiceDataCreationDate());

        if (!lazy) {
           invoiceData.setOwner(OwnerMapper.toDto(invInvoiceData.getOwnOwner(),true));
            invoiceData.setMovementType(MovementTypeMapper.toDto(invInvoiceData.getInvMovementType(),true));
        }
        return invoiceData;
    }

    public static InvInvoiceData toEntity(InvoiceData invoiceData, boolean lazy) {
        if (null == invoiceData) {
            return null;
        }
        InvInvoiceData invInvoiceData=new InvInvoiceData();
        invInvoiceData.setInvInvoiceDataId(invoiceData.getId());
        invInvoiceData.setInvInvoiceDataPrice(invoiceData.getPrice());
        invInvoiceData.setInvInvoiceDataTotalPrice(invoiceData.getTotalPrice());
        invInvoiceData.setInvInvoiceDataQuantity(invoiceData.getQuantity());
        invInvoiceData.setInvInvoiceDataInvoiceDate(invoiceData.getInvoiceDate());
        invInvoiceData.setInvInvoiceDataUpdateDate(invoiceData.getCreationDate());
        invInvoiceData.setInvInvoiceDataCreationDate(invInvoiceData.getInvInvoiceDataInvoiceDate());

        if (!lazy) {
            invInvoiceData.setOwnOwner(OwnerMapper.toEntity(invoiceData.getOwner(),false));
            invInvoiceData.setInvMovementType(MovementTypeMapper.toEntity(invoiceData.getMovementType(),false));
        }
        return invInvoiceData;
    }



    public static List<InvoiceData> toDtos(List<InvInvoiceData> invInvoiceDatas, boolean lazy) {
        if (null == invInvoiceDatas) {
            return null;
        }
        List<InvoiceData> invoiceDatas = new ArrayList<>();
        for (InvInvoiceData invInvoiceData : invInvoiceDatas) {
            invoiceDatas.add(toDto(invInvoiceData, lazy));
        }
        return invoiceDatas;
    }

    public static List<InvoiceData> toDtos(Iterable<InvInvoiceData> invInvoiceDatas, boolean lazy) {
        if (null == invInvoiceDatas) {
            return null;
        }
        List<InvoiceData> invoiceDatas = new ArrayList<>();
        for (InvInvoiceData invInvoiceData : invInvoiceDatas) {
            invoiceDatas.add(toDto(invInvoiceData, lazy));
        }
        return invoiceDatas;
    }

    public static Set<InvInvoiceData> toEntities(Set<InvoiceData> invoiceDatas, boolean lazy) {
        if (null == invoiceDatas) {
            return null;
        }
        Set<InvInvoiceData> invInvoiceDatas = new HashSet<>();
        for (InvoiceData invoiceData : invoiceDatas) {
            invInvoiceDatas.add(toEntity(invoiceData, lazy));
        }
        return invInvoiceDatas;
    }

    public static Set<InvoiceData> toDtos(Set<InvInvoiceData> invInvoiceDatas, boolean lazy) {
        if (null == invInvoiceDatas) {
            return null;
        }
        Set<InvoiceData> invoiceDatas = new HashSet<>();
        for (InvInvoiceData invInvoiceData : invInvoiceDatas) {
            invoiceDatas.add(toDto(invInvoiceData, lazy));
        }
        return invoiceDatas;
    }
}
