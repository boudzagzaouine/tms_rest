package com.bagile.tms.mapper;

import com.bagile.tms.dto.CommissionDriver;
import com.bagile.tms.entities.TmsCommissionDriver;

import java.util.*;

public class CommissionDriverMapper {
    public CommissionDriverMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsCommissionId");
        map.put("driver", "tmsDriver");
        map.put("commissionType", "tmsCommissionType");
        map.put("datee", "tmsDatee");


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

    public static TmsCommissionDriver toEntity(CommissionDriver commission, boolean lazy) {
        if (null == commission) {
            return null;
        }
        TmsCommissionDriver tmsCommission = new TmsCommissionDriver();
        tmsCommission.setTmsCommissionId(commission.getId());
        tmsCommission.setTmsDatee(commission.getDatee());

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

    public static CommissionDriver toDto(TmsCommissionDriver tmsCommission, boolean lazy) {
        if (null == tmsCommission) {
            return null;
        }
        CommissionDriver commission = new CommissionDriver();
        commission.setId((int) tmsCommission.getTmsCommissionId());

        commission.setDatee(tmsCommission.getTmsDatee());

        if (!lazy) {
            commission.setDriver(DriverMapper.toDto(tmsCommission.getTmsDriver(), true));

            commission.setCommissionType(CommissionTypeMapper.toDto(tmsCommission.getTmsCommissionType(), true));

        }

        return commission;

    }


    public static List<CommissionDriver> toDtos(Iterable<? extends TmsCommissionDriver> tmsCommissions, boolean lazy) {
        if (null == tmsCommissions) {
            return null;
        }
        List<CommissionDriver> commissions = new ArrayList<>();

        for (TmsCommissionDriver tmsCommission : tmsCommissions) {
            commissions.add(toDto(tmsCommission, lazy));
        }
        return commissions;
    }

    public static Set<TmsCommissionDriver> toEntities(Iterable<? extends CommissionDriver> commissionType, boolean lazy) {
        if (null == commissionType) {
            return null;
        }
        Set<TmsCommissionDriver> tmsCommissions = new HashSet<>();
        for (CommissionDriver commission : commissionType) {
            tmsCommissions.add(toEntity(commission, lazy));
        }
        return tmsCommissions;
    }

   /* public static List<CommissionDriver> toDtos(Iterable<? extends TmsCommissionDriver> tmsCommissions, boolean lazy) {
        if (null == tmsCommissions) {
            return null;
        }
        List<CommissionDriver> commissionType = new ArrayList<>();
        for (TmsCommissionDriver tmsCommission : tmsCommissions) {
            commissionType.add(toDto(tmsCommission, lazy));
        }
        return commissionType;
    }*/
}
