package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PaymentSupplierMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invPaymentSupplierId");
        map.put("paymentDate", "invPaymentSupplierDate");
        map.put("supplier", "rcpSupplier");
        map.put("creationDate", "invPaymentSupplierCreationDate");
        map.put("updateDate", "invPaymentSupplierUpdateDate");
        map.put("supplierInvoice", "invSupplierInvoice");
        map.put("amount", "invPaymentSupplierAmount");
        map.put("paymentType", "prmPaymentType");
        map.put("assetAccount", "cmdAssetAccount");
        map.put("currency", "prmCurrency");
        //map.put("organisation", "prmPaymentTypeOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvPaymentSupplier toEntity(PaymentSupplier paymentSupplier, boolean lazy) {
        if (null == paymentSupplier) {
            return null;
        }
        InvPaymentSupplier invPaymentSupplier = new InvPaymentSupplier();
        invPaymentSupplier.setInvPaymentSupplierId(paymentSupplier.getId());
        invPaymentSupplier.setInvPaymentSupplierDate(paymentSupplier.getPaymentDate());
        invPaymentSupplier.setInvPaymentSupplierAmount(paymentSupplier.getAmount());
        invPaymentSupplier.setInvPaymentSupplierCreationDate(paymentSupplier.getCreationDate());
        invPaymentSupplier.setInvPaymentSupplierUpdateDate(paymentSupplier.getUpdateDate());
        invPaymentSupplier.setInvPaymentSupplierNumber(paymentSupplier.getNumber());

        if (!lazy) {
            invPaymentSupplier.setPrmCurrency(CurrencyMapper.toEntity(paymentSupplier.getCurrency(), true));
            invPaymentSupplier.setPrmPaymentType(PaymentTypeMapper.toEntity(paymentSupplier.getPaymentType(), true));
            invPaymentSupplier.setRcpSupplier(SupplierMapper.toEntity(paymentSupplier.getSupplier(), true));
            invPaymentSupplier.setInvSupplierInvoice(SupplierInvoiceMapper.toEntity(paymentSupplier.getSupplierInvoice(), true));
            //paymentSupplier.setSupplierInvoice(SupplierInvoiceMapper.toDto(invPaymentSupplier.getRcpSupplier(),true));
            // paymentSupplier.setOrganisation(OrganisationMapper.toDto(invPaymentSupplier.getOrgOrganisation(), true));
        }
        return invPaymentSupplier;
    }

    public static PaymentSupplier toDto(InvPaymentSupplier invPaymentSupplier, boolean lazy) {
        if (null == invPaymentSupplier) {
            return null;
        }
        PaymentSupplier paymentSupplier = new PaymentSupplier();
        paymentSupplier.setId(invPaymentSupplier.getInvPaymentSupplierId());
        paymentSupplier.setPaymentDate(invPaymentSupplier.getInvPaymentSupplierDate());
        paymentSupplier.setAmount(invPaymentSupplier.getInvPaymentSupplierAmount());
        paymentSupplier.setCreationDate(invPaymentSupplier.getInvPaymentSupplierCreationDate());
        paymentSupplier.setUpdateDate(invPaymentSupplier.getInvPaymentSupplierUpdateDate());
        paymentSupplier.setNumber(invPaymentSupplier.getInvPaymentSupplierNumber());

        if (!lazy) {
            paymentSupplier.setCurrency(CurrencyMapper.toDto(invPaymentSupplier.getPrmCurrency(), true));
            paymentSupplier.setAssetSupplier(AssetSupplierMapper.toDto(invPaymentSupplier.getRcpAssetSupplier(), true));
            paymentSupplier.setPaymentType(PaymentTypeMapper.toDto(invPaymentSupplier.getPrmPaymentType(), true));
            paymentSupplier.setSupplier(SupplierMapper.toDto(invPaymentSupplier.getRcpSupplier(), true));
            paymentSupplier.setSupplierInvoice(SupplierInvoiceMapper.toDto(invPaymentSupplier.getInvSupplierInvoice(), true));
            //paymentSupplier.setSupplierInvoice(SupplierInvoiceMapper.toDto(invPaymentSupplier.getInvSupplierInvoice(),true));

            // paymentSupplier.setOrganisation(OrganisationMapper.toDto(invPaymentSupplier.getOrgOrganisation(), true));
        }
        return paymentSupplier;
    }

    public static List<PaymentSupplier> toDtos(List<InvPaymentSupplier> invPaymentSuppliers, boolean lazy) {
        if (null == invPaymentSuppliers) {
            return null;
        }
        List<PaymentSupplier> paymentSuppliers = new ArrayList<>();
        for (InvPaymentSupplier invPaymentSupplier : invPaymentSuppliers) {
            paymentSuppliers.add(toDto(invPaymentSupplier, lazy));
        }
        return paymentSuppliers;
    }

    public static List<PaymentSupplier> toDtos(Iterable<InvPaymentSupplier> invPaymentSuppliers, boolean lazy) {
        if (null == invPaymentSuppliers) {
            return null;
        }
        List<PaymentSupplier> paymentSuppliers = new ArrayList<>();
        for (InvPaymentSupplier invPaymentSupplier : invPaymentSuppliers) {
            paymentSuppliers.add(toDto(invPaymentSupplier, lazy));
        }
        return paymentSuppliers;
    }

    public static Set<InvPaymentSupplier> toEntities(Set<PaymentSupplier> paymentSuppliers, boolean lazy) {
        if (null == paymentSuppliers) {
            return null;
        }
        Set<InvPaymentSupplier> invPaymentSuppliers = new HashSet<>();
        for (PaymentSupplier paymentSupplier : paymentSuppliers) {
            invPaymentSuppliers.add(toEntity(paymentSupplier, lazy));
        }
        return invPaymentSuppliers;
    }

    public static Set<PaymentSupplier> toDtos(Set<InvPaymentSupplier> invPaymentSuppliers, boolean lazy) {
        if (null == invPaymentSuppliers) {
            return null;
        }
        Set<PaymentSupplier> paymentSuppliers = new HashSet<>();
        for (InvPaymentSupplier invPaymentSupplier : invPaymentSuppliers) {
            paymentSuppliers.add(toDto(invPaymentSupplier, lazy));
        }
        return paymentSuppliers;
    }
}
