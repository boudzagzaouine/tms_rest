package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.PaymentType;
import com.bagile.gmo.entities.PrmPaymentType;


import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PaymentTypeMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmPaymentTypeId");
        map.put("code", "prmPaymentTypeCode");
        map.put("description", "prmPaymentTypeDescription");
        map.put("creationDate", "prmPaymentTypeCreationDate");
        map.put("updateDate", "prmPaymentTypeUpdateDate");
        map.put("accounted", "prmPaymentTypeAccounted");
        map.put("active", "prmPaymentTypeActive");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmPaymentType toEntity(PaymentType paymentType, boolean lazy) {
        if (null == paymentType) {
            return null;
        }
        PrmPaymentType prmPaymentType = new PrmPaymentType();
        prmPaymentType.setPrmPaymentTypeId(paymentType.getId());
        prmPaymentType.setPrmPaymentTypeCode(paymentType.getCode() != null ? paymentType.getCode().toUpperCase() : null);
        prmPaymentType.setPrmPaymentTypeDescription(paymentType.getDescription());
        prmPaymentType.setPrmPaymentTypeCreationDate(paymentType.getCreationDate());
        prmPaymentType.setPrmPaymentTypeUpdateDate(paymentType.getUpdateDate());
        prmPaymentType.setPrmPaymentTypeAccounted(paymentType.getAccounted());
        prmPaymentType.setPrmPaymentTypeActive(paymentType.getActive());
        prmPaymentType.setUpdatedBy(paymentType.getUpdatedBy());
        prmPaymentType.setCreatedBy(paymentType.getCreatedBy());
        if (!lazy) {
            // prmPaymentType.setOrgOrganisation(OrganisationMapper.toEntity(paymentType.getOrganisation(), true));
        }
        return prmPaymentType;
    }

    public static PaymentType toDto(PrmPaymentType prmPaymentType, boolean lazy) {
        if (null == prmPaymentType) {
            return null;
        }
        PaymentType paymentType = new PaymentType();
        paymentType.setId(prmPaymentType.getPrmPaymentTypeId());
        paymentType.setCode(prmPaymentType.getPrmPaymentTypeCode());
        paymentType.setDescription(prmPaymentType.getPrmPaymentTypeDescription());
        paymentType.setCreationDate(prmPaymentType.getPrmPaymentTypeCreationDate());
        paymentType.setUpdateDate(prmPaymentType.getPrmPaymentTypeUpdateDate());
        paymentType.setAccounted(prmPaymentType.getPrmPaymentTypeAccounted());
        paymentType.setActive(prmPaymentType.getPrmPaymentTypeActive());
        paymentType.setUpdatedBy(prmPaymentType.getUpdatedBy());
        paymentType.setCreatedBy(prmPaymentType.getCreatedBy());
        if (!lazy) {
            // paymentType.setOrganisation(OrganisationMapper.toDto(prmPaymentType.getOrgOrganisation(), true));
        }
        return paymentType;
    }

    public static List<PaymentType> toDtos(List<PrmPaymentType> prmPaymentTypes, boolean lazy) {
        if (null == prmPaymentTypes) {
            return null;
        }
        List<PaymentType> paymentTypes = new ArrayList<>();
        for (PrmPaymentType prmPaymentType : prmPaymentTypes) {
            paymentTypes.add(toDto(prmPaymentType, lazy));
        }
        return paymentTypes;
    }

    public static List<PaymentType> toDtos(Iterable<PrmPaymentType> prmPaymentTypes, boolean lazy) {
        if (null == prmPaymentTypes) {
            return null;
        }
        List<PaymentType> paymentTypes = new ArrayList<>();
        for (PrmPaymentType prmPaymentType : prmPaymentTypes) {
            paymentTypes.add(toDto(prmPaymentType, lazy));
        }
        return paymentTypes;
    }

    public static Set<PrmPaymentType> toEntities(Set<PaymentType> paymentTypes, boolean lazy) {
        if (null == paymentTypes) {
            return null;
        }
        Set<PrmPaymentType> prmPaymentTypes = new HashSet<>();
        for (PaymentType paymentType : paymentTypes) {
            prmPaymentTypes.add(toEntity(paymentType, lazy));
        }
        return prmPaymentTypes;
    }

    public static Set<PaymentType> toDtos(Set<PrmPaymentType> prmPaymentTypes, boolean lazy) {
        if (null == prmPaymentTypes) {
            return null;
        }
        Set<PaymentType> paymentTypes = new HashSet<>();
        for (PrmPaymentType prmPaymentType : prmPaymentTypes) {
            paymentTypes.add(toDto(prmPaymentType, lazy));
        }
        return paymentTypes;
    }
}
