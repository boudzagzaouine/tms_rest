package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CommissionType;
import com.bagile.gmo.entities.GmoCommissionType;

import java.util.*;

public class CommissionTypeMapper {
    public CommissionTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoCommissionTypeId");
        map.put("code", "gmoCommissionTypeCode");
        map.put("description", "gmoCommissionTypeDescription");
        map.put("percentage", "gmoCommissionTypePercentage");

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

    public static GmoCommissionType toEntity(CommissionType badgeType, boolean lazy) {
        if (null == badgeType) {
            return null;
        }
        GmoCommissionType gmoCommissionType = new GmoCommissionType();
        gmoCommissionType.setGmoCommissionTypeId(badgeType.getId());
        gmoCommissionType.setGmoCommissionTypeCode(badgeType.getCode() != null ? badgeType.getCode().toUpperCase() : null);
        gmoCommissionType.setGmoCommissionTypeDescription (badgeType.getDescription ());
        gmoCommissionType.setGmoCommissionTypepercentage (badgeType.getPercentage ());


        gmoCommissionType.setCreatedBy(badgeType.getCreatedBy());
        gmoCommissionType.setUpdatedBy(badgeType.getUpdatedBy());
        gmoCommissionType.setCreationDate(badgeType.getCreationDate());
        gmoCommissionType.setUpdateDate(badgeType.getUpdateDate());

        return gmoCommissionType;

    }

    public static CommissionType toDto(GmoCommissionType gmoCommissionType, boolean lazy) {
        if (null == gmoCommissionType) {
            return null;
        }
        CommissionType badgeType = new CommissionType();
        badgeType.setId((int) gmoCommissionType.getGmoCommissionTypeId());
        badgeType.setCode(gmoCommissionType.getGmoCommissionTypeCode());
        badgeType.setDescription (gmoCommissionType.getGmoCommissionTypeDescription ());
        badgeType.setPercentage (gmoCommissionType.getGmoCommissionTypepercentage ());


        return badgeType;

    }


    public static List<CommissionType> toDtos(Iterable<? extends GmoCommissionType> gmoCommissionTypes, boolean lazy) {
        if (null == gmoCommissionTypes) {
            return null;
        }
        List<CommissionType> vehicules = new ArrayList<>();

        for (GmoCommissionType gmoCommissionType : gmoCommissionTypes) {
            vehicules.add(toDto(gmoCommissionType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoCommissionType> toEntities(Set<CommissionType> commissionType, boolean lazy) {
        if (null == commissionType) {
            return null;
        }
        Set<GmoCommissionType> gmoCommissionTypes = new HashSet<>();
        for (CommissionType badgeType : commissionType) {
            gmoCommissionTypes.add(toEntity(badgeType, lazy));
        }
        return gmoCommissionTypes;
    }

    public static Set<CommissionType> toDtos(Set<GmoCommissionType> gmoCommissionTypes, boolean lazy) {
        if (null == gmoCommissionTypes) {
            return null;
        }
        Set<CommissionType> commissionType = new HashSet<>();
        for (GmoCommissionType gmoCommissionType : gmoCommissionTypes) {
            commissionType.add(toDto(gmoCommissionType, lazy));
        }
        return commissionType;
    }
}
