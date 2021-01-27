package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CommissionDriver;
import com.bagile.gmo.entities.GmoCommissionDriver;

import java.util.*;

public class CommissionDriverMapper {
    public CommissionDriverMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoCommissionId");
        map.put("driver", "gmoDriver");
        map.put("commissionType", "gmoCommissionType");
        map.put("datee", "gmoDatee");


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

    public static GmoCommissionDriver toEntity(CommissionDriver commission, boolean lazy) {
        if (null == commission) {
            return null;
        }
        GmoCommissionDriver gmoCommission = new GmoCommissionDriver();
        gmoCommission.setGmoCommissionId(commission.getId());
        gmoCommission.setGmoDatee(commission.getDatee());

        gmoCommission.setCreatedBy(commission.getCreatedBy());
        gmoCommission.setUpdatedBy(commission.getUpdatedBy());
        gmoCommission.setCreationDate(commission.getCreationDate());
        gmoCommission.setUpdateDate(commission.getUpdateDate());
        if (!lazy) {
            gmoCommission.setGmoDriver(DriverMapper.toEntity(commission.getDriver(), false));
            gmoCommission.setGmoCommissionType(CommissionTypeMapper.toEntity(commission.getCommissionType(),false));

        }
        return gmoCommission;

    }

    public static CommissionDriver toDto(GmoCommissionDriver gmoCommission, boolean lazy) {
        if (null == gmoCommission) {
            return null;
        }
        CommissionDriver commission = new CommissionDriver();
        commission.setId(gmoCommission.getGmoCommissionId());

        commission.setDatee(gmoCommission.getGmoDatee());

        if (!lazy) {
            commission.setDriver(DriverMapper.toDto(gmoCommission.getGmoDriver(), true));

            commission.setCommissionType(CommissionTypeMapper.toDto(gmoCommission.getGmoCommissionType(), true));

        }

        return commission;

    }


    public static List<CommissionDriver> toDtos(Iterable<? extends GmoCommissionDriver> gmoCommissions, boolean lazy) {
        if (null == gmoCommissions) {
            return null;
        }
        List<CommissionDriver> commissions = new ArrayList<>();

        for (GmoCommissionDriver gmoCommission : gmoCommissions) {
            commissions.add(toDto(gmoCommission, lazy));
        }
        return commissions;
    }

    public static Set<GmoCommissionDriver> toEntities(Iterable<? extends CommissionDriver> commissionType, boolean lazy) {
        if (null == commissionType) {
            return null;
        }
        Set<GmoCommissionDriver> gmoCommissions = new HashSet<>();
        for (CommissionDriver commission : commissionType) {
            gmoCommissions.add(toEntity(commission, lazy));
        }
        return gmoCommissions;
    }

   /* public static List<CommissionDriver> toDtos(Iterable<? extends GmoCommissionDriver> gmoCommissions, boolean lazy) {
        if (null == gmoCommissions) {
            return null;
        }
        List<CommissionDriver> commissionType = new ArrayList<>();
        for (GmoCommissionDriver gmoCommission : gmoCommissions) {
            commissionType.add(toDto(gmoCommission, lazy));
        }
        return commissionType;
    }*/
}
