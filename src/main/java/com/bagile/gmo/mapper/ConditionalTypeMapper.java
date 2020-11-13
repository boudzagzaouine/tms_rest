package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ConditionalType;
import com.bagile.gmo.entities.GmoConditionalType;

import java.util.*;

public class ConditionalTypeMapper {
    public ConditionalTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoConditionalTypeId");
        map.put("code", "gmoConditionalTypeCode");
        map.put("description", "gmoConditionalTypeDescription");

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

    public static GmoConditionalType toEntity(ConditionalType conditionalType, boolean lazy) {
        if (null == conditionalType) {
            return null;
        }
        GmoConditionalType gmoConditionalType = new GmoConditionalType();
        gmoConditionalType.setGmoConditionalTypeId(conditionalType.getId());
        gmoConditionalType.setGmoConditionalTypeCode(conditionalType.getCode() != null ? conditionalType.getCode().toUpperCase() : null);
        gmoConditionalType.setGmoConditionalTypeDescription (conditionalType.getDescription ());


        gmoConditionalType.setCreatedBy(conditionalType.getCreatedBy());
        gmoConditionalType.setUpdatedBy(conditionalType.getUpdatedBy());
        gmoConditionalType.setCreationDate(conditionalType.getCreationDate());
        gmoConditionalType.setUpdateDate(conditionalType.getUpdateDate());

        return gmoConditionalType;

    }

    public static ConditionalType toDto(GmoConditionalType gmoConditionalType, boolean lazy) {
        if (null == gmoConditionalType) {
            return null;
        }
        ConditionalType conditionalType = new ConditionalType();
        conditionalType.setId((int) gmoConditionalType.getGmoConditionalTypeId());
        conditionalType.setCode(gmoConditionalType.getGmoConditionalTypeCode());
        conditionalType.setDescription (gmoConditionalType.getGmoConditionalTypeDescription ());


        return conditionalType;

    }


    public static List<ConditionalType> toDtos(Iterable<? extends GmoConditionalType> gmoConditionalTypes, boolean lazy) {
        if (null == gmoConditionalTypes) {
            return null;
        }
        List<ConditionalType> vehicules = new ArrayList<>();

        for (GmoConditionalType gmoConditionalType : gmoConditionalTypes) {
            vehicules.add(toDto(gmoConditionalType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoConditionalType> toEntities(Set<ConditionalType> conditionalTypes, boolean lazy) {
        if (null == conditionalTypes) {
            return null;
        }
        Set<GmoConditionalType> gmoConditionalTypes = new HashSet<>();
        for (ConditionalType conditionalType : conditionalTypes) {
            gmoConditionalTypes.add(toEntity(conditionalType, lazy));
        }
        return gmoConditionalTypes;
    }

    public static Set<ConditionalType> toDtos(Set<GmoConditionalType> gmoConditionalTypes, boolean lazy) {
        if (null == gmoConditionalTypes) {
            return null;
        }
        Set<ConditionalType> conditionalTypes = new HashSet<>();
        for (GmoConditionalType gmoConditionalType : gmoConditionalTypes) {
            conditionalTypes.add(toDto(gmoConditionalType, lazy));
        }
        return conditionalTypes;
    }
}
