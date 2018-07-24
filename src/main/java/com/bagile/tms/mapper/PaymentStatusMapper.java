package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Adil on 2/23/2017.
 */

public class PaymentStatusMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmPaymentStatusId");
        map.put("code", "prmPaymentStatusCode");
        map.put("description", "prmPaymentStatusDescription");
        map.put("creationDate", "prmPaymentStatusCreationDate");
        map.put("updateDate", "prmPaymentStatusUpdateDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmPaymentStatus toEntity(PaymentStatus paymentStatus, boolean lazy){
        PrmPaymentStatus prmPaymentStatus = new PrmPaymentStatus();
        prmPaymentStatus.setPrmPaymentStatusID(paymentStatus.getId());
        prmPaymentStatus.setPrmPaymentStatusCode(paymentStatus.getCode());
        prmPaymentStatus.setPrmPaymentStatusDescription(prmPaymentStatus.getPrmPaymentStatusDescription());
        prmPaymentStatus.setPrmPaymentStatusCreationDate(prmPaymentStatus.getPrmPaymentStatusCreationDate());
        prmPaymentStatus.setPrmPaymentStatusUpdateDate(prmPaymentStatus.getPrmPaymentStatusUpdateDate());
        return prmPaymentStatus;
    }

    public static PaymentStatus toDto(PrmPaymentStatus prmPaymentStatus, boolean lazy) {
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setId(prmPaymentStatus.getPrmPaymentStatusID());
        paymentStatus.setCode(prmPaymentStatus.getPrmPaymentStatusCode());
        paymentStatus.setDescription(prmPaymentStatus.getPrmPaymentStatusDescription());
        paymentStatus.setCreationDate(prmPaymentStatus.getPrmPaymentStatusCreationDate());
        paymentStatus.setUpdateDate(prmPaymentStatus.getPrmPaymentStatusUpdateDate());
        return paymentStatus;
    }

    public static List<PrmPaymentStatus> toEntities(Set<PaymentStatus> paymentStatuses, boolean lazy){
        if (null == paymentStatuses) return null;

        List<PrmPaymentStatus> prmPaymentStatuses = new ArrayList<>();
        for (PaymentStatus paymentStatus : paymentStatuses){
           prmPaymentStatuses.add(toEntity(paymentStatus, lazy));
        }
        return prmPaymentStatuses;
    }

    public static List<PaymentStatus> toDtos(List<PrmPaymentStatus> prmPaymentStatuses, boolean lazy){
        if(null == prmPaymentStatuses) return null;

        List<PaymentStatus> paymentStatuses = new ArrayList<>();
        for (PrmPaymentStatus prmPaymentStatus:prmPaymentStatuses) {
            paymentStatuses.add(toDto(prmPaymentStatus, lazy));
        }
        return paymentStatuses;
    }

    public static List<PaymentStatus> toDtos(Iterable<PrmPaymentStatus> prmPaymentStatuses, boolean lazy){
        if(null == prmPaymentStatuses) return null;

        List<PaymentStatus> paymentStatuses = new ArrayList<>();
        for (PrmPaymentStatus prmPaymentStatus:prmPaymentStatuses) {
            paymentStatuses.add(toDto(prmPaymentStatus, lazy));
        }
        return paymentStatuses;
    }


    public static List<PaymentStatus> toDtos(Set<PrmPaymentStatus> prmPaymentStatuses, boolean lazy){
        if(null == prmPaymentStatuses) return null;

        List<PaymentStatus> paymentStatuses = new ArrayList<>();
        for (PrmPaymentStatus prmPaymentStatus:prmPaymentStatuses) {
            paymentStatuses.add(toDto(prmPaymentStatus, lazy));
        }
        return paymentStatuses;
    }






}
