package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CommissionType;
import com.bagile.gmo.entities.TmsCommissionType;

import java.util.*;

public class CommissionTypeMapper {
    public CommissionTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsCommissionTypeId");
        map.put("code", "tmsCommissionTypeCode");
        map.put("description", "tmsCommissionTypeDescription");
        map.put("percentage", "tmsCommissionTypePercentage");

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

    public static TmsCommissionType toEntity(CommissionType badgeType, boolean lazy) {
        if (null == badgeType) {
            return null;
        }
        TmsCommissionType tmsCommissionType = new TmsCommissionType();
        tmsCommissionType.setTmsCommissionTypeId(badgeType.getId());
        tmsCommissionType.setTmsCommissionTypeCode(badgeType.getCode() != null ? badgeType.getCode().toUpperCase() : null);
        tmsCommissionType.setTmsCommissionTypeDescription (badgeType.getDescription ());
        tmsCommissionType.setTmsCommissionTypepercentage (badgeType.getPercentage ());


        tmsCommissionType.setCreatedBy(badgeType.getCreatedBy());
        tmsCommissionType.setUpdatedBy(badgeType.getUpdatedBy());
        tmsCommissionType.setCreationDate(badgeType.getCreationDate());
        tmsCommissionType.setUpdateDate(badgeType.getUpdateDate());

        return tmsCommissionType;

    }

    public static CommissionType toDto(TmsCommissionType tmsCommissionType, boolean lazy) {
        if (null == tmsCommissionType) {
            return null;
        }
        CommissionType badgeType = new CommissionType();
        badgeType.setId((int) tmsCommissionType.getTmsCommissionTypeId());
        badgeType.setCode(tmsCommissionType.getTmsCommissionTypeCode());
        badgeType.setDescription (tmsCommissionType.getTmsCommissionTypeDescription ());
        badgeType.setPercentage (tmsCommissionType.getTmsCommissionTypepercentage ());


        return badgeType;

    }


    public static List<CommissionType> toDtos(Iterable<? extends TmsCommissionType> tmsCommissionTypes, boolean lazy) {
        if (null == tmsCommissionTypes) {
            return null;
        }
        List<CommissionType> vehicules = new ArrayList<>();

        for (TmsCommissionType tmsCommissionType : tmsCommissionTypes) {
            vehicules.add(toDto(tmsCommissionType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsCommissionType> toEntities(Set<CommissionType> commissionType, boolean lazy) {
        if (null == commissionType) {
            return null;
        }
        Set<TmsCommissionType> tmsCommissionTypes = new HashSet<>();
        for (CommissionType badgeType : commissionType) {
            tmsCommissionTypes.add(toEntity(badgeType, lazy));
        }
        return tmsCommissionTypes;
    }

    public static Set<CommissionType> toDtos(Set<TmsCommissionType> tmsCommissionTypes, boolean lazy) {
        if (null == tmsCommissionTypes) {
            return null;
        }
        Set<CommissionType> commissionType = new HashSet<>();
        for (TmsCommissionType tmsCommissionType : tmsCommissionTypes) {
            commissionType.add(toDto(tmsCommissionType, lazy));
        }
        return commissionType;
    }
}
