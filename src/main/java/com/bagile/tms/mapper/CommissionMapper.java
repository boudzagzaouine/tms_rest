package com.bagile.tms.mapper;

import com.bagile.tms.dto.Commission;
import com.bagile.tms.entities.TmsCommission;

import java.util.*;

public class CommissionMapper {
    public CommissionMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsCommissionId");
        map.put("driver", "tmsDriver");
        map.put("commissionType", "tmsCommissionType");
        map.put("amount", "tmsAmount");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsCommission toEntity(Commission commission, boolean lazy) {
        if (null == commission) {
            return null;
        }
        TmsCommission tmsCommission = new TmsCommission();
        tmsCommission.setTmsCommissionId(commission.getId());
        tmsCommission.setTmsAmount (commission.getAmount ());

        tmsCommission.setCreatedBy(commission.getCreatedBy());
        tmsCommission.setUpdatedBy(commission.getUpdatedBy());
        tmsCommission.setCreationDate(commission.getCreationDate());
        tmsCommission.setUpdateDate(commission.getUpdateDate());
        if (!lazy) {
            tmsCommission.setTmsDriver(DriverMapper.toEntity(commission.getDriver(), true));
            tmsCommission.setTmsCommissionType(CommissionTypeMapper.toEntity(commission.getCommissionType(),true));

        }
        return tmsCommission;

    }

    public static Commission toDto(TmsCommission tmsCommission, boolean lazy) {
        if (null == tmsCommission) {
            return null;
        }
        Commission commission = new Commission();
        commission.setId((int) tmsCommission.getTmsCommissionId());
        commission.setAmount(tmsCommission.getTmsAmount());

        if (!lazy) {
            commission.setDriver(DriverMapper.toDto(tmsCommission.getTmsDriver(), true));
            commission.setCommissionType(CommissionTypeMapper.toDto(tmsCommission.getTmsCommissionType(), true));

        }

        return commission;

    }


    public static List<Commission> toDtos(Iterable<? extends TmsCommission> tmsCommissions, boolean lazy) {
        if (null == tmsCommissions) {
            return null;
        }
        List<Commission> commissions = new ArrayList<>();

        for (TmsCommission tmsCommission : tmsCommissions) {
            commissions.add(toDto(tmsCommission, lazy));
        }
        return commissions;
    }

    public static Set<TmsCommission> toEntities(Set<Commission> commissionType, boolean lazy) {
        if (null == commissionType) {
            return null;
        }
        Set<TmsCommission> tmsCommissions = new HashSet<>();
        for (Commission commission : commissionType) {
            tmsCommissions.add(toEntity(commission, lazy));
        }
        return tmsCommissions;
    }

    public static Set<Commission> toDtos(Set<TmsCommission> tmsCommissions, boolean lazy) {
        if (null == tmsCommissions) {
            return null;
        }
        Set<Commission> commissionType = new HashSet<>();
        for (TmsCommission tmsCommission : tmsCommissions) {
            commissionType.add(toDto(tmsCommission, lazy));
        }
        return commissionType;
    }
}
