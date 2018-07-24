package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Adil on 2/24/2017.
 */
public class InvoiceStatusMapper {
    private InvoiceStatusMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","prmInvoiceStatusId");
        map.put("code","prmInvoiceStatusCode");
        map.put("description","prmInvoiceStatusDescription");
        map.put("creationDate","prmInvoiceStatusCreationDate");
        map.put("updateDate","prmInvoiceStatusUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmInvoiceStatus toEntity(InvoiceStatus invoiceStatus, boolean lazy) {
        PrmInvoiceStatus prmInvoiceStatus = new PrmInvoiceStatus();
        prmInvoiceStatus.setPrmInvoiceStatusId(invoiceStatus.getId());
        prmInvoiceStatus.setPrmInvoiceStatusCode(invoiceStatus.getCode());
        prmInvoiceStatus.setPrmInvoiceStatusDescription(invoiceStatus.getDescription());
        prmInvoiceStatus.setPrmInvoiceStatusCreationDate(invoiceStatus.getCreationDate());
        prmInvoiceStatus.setPrmInvoiceStatusUpdateDate(invoiceStatus.getUpdateDate());


        return prmInvoiceStatus;
    }

    public static InvoiceStatus toDto(PrmInvoiceStatus prmInvoiceStatus, boolean lazy){
        InvoiceStatus invoiceStatus = new InvoiceStatus();
        invoiceStatus.setId(prmInvoiceStatus.getPrmInvoiceStatusId());
        invoiceStatus.setCode(prmInvoiceStatus.getPrmInvoiceStatusCode());
        invoiceStatus.setDescription(prmInvoiceStatus.getPrmInvoiceStatusDescription());
        invoiceStatus.setCreationDate(prmInvoiceStatus.getPrmInvoiceStatusCreationDate());
        invoiceStatus.setUpdateDate(prmInvoiceStatus.getPrmInvoiceStatusUpdateDate());

        return invoiceStatus;
    }

    public static List<InvoiceStatus> toDtos(List<PrmInvoiceStatus> prmInvoiceStatuss, boolean lazy) {
        if (null == prmInvoiceStatuss) {
            return null;
        }
        List<InvoiceStatus> invoiceStatuss = new ArrayList<>();
        for (PrmInvoiceStatus prmInvoiceStatus : prmInvoiceStatuss) {
            invoiceStatuss.add(toDto(prmInvoiceStatus, lazy));
        }
        return invoiceStatuss;
    }

    public static List<InvoiceStatus> toDtos(Iterable<PrmInvoiceStatus> prmInvoiceStatuss, boolean lazy) {
        if (null == prmInvoiceStatuss) {
            return null;
        }
        List<InvoiceStatus> invoiceStatuss = new ArrayList<>();
        for (PrmInvoiceStatus prmInvoiceStatus : prmInvoiceStatuss) {
            invoiceStatuss.add(toDto(prmInvoiceStatus, lazy));
        }
        return invoiceStatuss;
    }

    public static Set<PrmInvoiceStatus> toEntities(Set<InvoiceStatus> invoiceStatuss, boolean lazy) {
        if (null == invoiceStatuss) {
            return null;
        }
        Set<PrmInvoiceStatus> prmInvoiceStatuss = new HashSet<>();
        for (InvoiceStatus invoiceStatus : invoiceStatuss) {
            prmInvoiceStatuss.add(toEntity(invoiceStatus, lazy));
        }
        return prmInvoiceStatuss;
    }

    public static Set<InvoiceStatus> toDtos(Set<PrmInvoiceStatus> prmInvoiceStatuss, boolean lazy) {
        if (null == prmInvoiceStatuss) {
            return null;
        }
        Set<InvoiceStatus> invoiceStatuss = new HashSet<>();
        for (PrmInvoiceStatus prmInvoiceStatus : prmInvoiceStatuss) {
            invoiceStatuss.add(toDto(prmInvoiceStatus, lazy));
        }
        return invoiceStatuss;
    }
}
