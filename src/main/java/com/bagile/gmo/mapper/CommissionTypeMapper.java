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
        map.put("minDistance", "gmoCommissionTypeMinDistance");
        map.put("maxDistance", "gmoCommissionTypeMaxDistance");
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

    public static GmoCommissionType toEntity(CommissionType commissionType, boolean lazy) {
        if (null == commissionType) {
            return null;
        }
        GmoCommissionType gmoCommissionType = new GmoCommissionType();
        gmoCommissionType.setGmoCommissionTypeId(commissionType.getId());
        gmoCommissionType.setGmoCommissionTypeCode(commissionType.getCode() != null ? commissionType.getCode().toUpperCase() : null);
        gmoCommissionType.setGmoCommissionTypeDescription (commissionType.getDescription ());
        gmoCommissionType.setGmoCommissionTypepercentage (commissionType.getPercentage ());
        gmoCommissionType.setGmoCommissionTypeMinDistance (commissionType.getMinDistance ());
        gmoCommissionType.setGmoCommissionTypeMaxDistance (commissionType.getMaxDistance ());

        gmoCommissionType.setCreatedBy(commissionType.getCreatedBy());
        gmoCommissionType.setUpdatedBy(commissionType.getUpdatedBy());
        gmoCommissionType.setCreationDate(commissionType.getCreationDate());
        gmoCommissionType.setUpdateDate(commissionType.getUpdateDate());

        if(!lazy){

            gmoCommissionType.setOwnOwner(OwnerMapper.toEntity(commissionType.getOwner(),true));
        }

        return gmoCommissionType;

    }

    public static CommissionType toDto(GmoCommissionType gmoCommissionType, boolean lazy) {
        if (null == gmoCommissionType) {
            return null;
        }
        CommissionType commissionType = new CommissionType();
        commissionType.setId((int) gmoCommissionType.getGmoCommissionTypeId());
        commissionType.setCode(gmoCommissionType.getGmoCommissionTypeCode());
        commissionType.setDescription (gmoCommissionType.getGmoCommissionTypeDescription ());
        commissionType.setPercentage (gmoCommissionType.getGmoCommissionTypepercentage ());
        commissionType.setMinDistance (gmoCommissionType.getGmoCommissionTypeMinDistance ());
        commissionType.setMaxDistance (gmoCommissionType.getGmoCommissionTypeMaxDistance ());

        if(!lazy){

            commissionType.setOwner(OwnerMapper.toDto(gmoCommissionType.getOwnOwner(),true));
        }

        return commissionType;

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
        for (CommissionType commissionTypee : commissionType) {
            gmoCommissionTypes.add(toEntity(commissionTypee, lazy));
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
