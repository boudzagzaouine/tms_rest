package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.ContainerType;
import com.bagile.gmo.entities.PrmContainerType;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class ContainerTypeMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmContainerTypeId");
        map.put("code", "prmContainerTypeCode");
        map.put("description", "prmContainerTypeDescription");
        map.put("height", "prmContainerTypeHeight");
        map.put("width", "prmContainerTypeWidth");
        map.put("length", "prmContainerTypeLength");
        map.put("creationDate", "prmContainerTypeCreationDate");
        map.put("updateDate", "prmContainerTypeUpdateDate");
        map.put("maxWeight", "prmContainerTypeMaxWeight");
        map.put("weight", "prmContainerTypeWeight");
        map.put("active", "prmContainerTypeActive");
        map.put("defaultForReception", "prmContainerDefaultForReception");
        map.put("defaultForPreparation", "prmContainerDefaultForPreparation");
        map.put("palette", "prmContainerTypePalette");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmContainerType toEntity(ContainerType containerType, boolean lazy) {
        if (null == containerType) {
            return null;
        }
        PrmContainerType prmContainerType = new PrmContainerType();
        prmContainerType.setPrmContainerTypeId(containerType.getId());
        prmContainerType.setPrmContainerTypeCode(containerType.getCode() != null ? containerType.getCode().toUpperCase() : null);
        prmContainerType.setPrmContainerTypeDescription(containerType.getDescription());
        prmContainerType.setPrmContainerTypeLength(containerType.getLength());
        prmContainerType.setPrmContainerTypeHeight(containerType.getHeight());
        prmContainerType.setPrmContainerTypeWidth(containerType.getWidth());
        prmContainerType.setPrmContainerTypeCreationDate(containerType.getCreationDate());
        prmContainerType.setPrmContainerTypeUpdateDate(containerType.getUpdateDate());
        prmContainerType.setPrmContainerTypeActive(containerType.getActive());
        prmContainerType.setUpdatedBy(containerType.getUpdatedBy());
        prmContainerType.setCreatedBy(containerType.getCreatedBy());
        prmContainerType.setPrmContainerTypeMaxWeight(containerType.getMaxWeight());
        prmContainerType.setPrmContainerTypeWeight(containerType.getWeight());
        prmContainerType.setPrmContainerTypeDefaultForPreparation(containerType.getDefaultForPreparation());
        prmContainerType.setPrmContainerTypeDefaultForReception(containerType.getDefaultForReception());
        prmContainerType.setPrmContainerTypePalette(containerType.getPalette());
        return prmContainerType;
    }

    public static ContainerType toDto(PrmContainerType prmContainerType, boolean lazy) {
        if (null == prmContainerType) {
            return null;
        }
        ContainerType containerType = new ContainerType();
        containerType.setId(prmContainerType.getPrmContainerTypeId());
        containerType.setCode(prmContainerType.getPrmContainerTypeCode());
        containerType.setDescription(prmContainerType.getPrmContainerTypeDescription());
        containerType.setCreationDate(prmContainerType.getPrmContainerTypeCreationDate());
        containerType.setUpdateDate(prmContainerType.getPrmContainerTypeUpdateDate());
        containerType.setLength(prmContainerType.getPrmContainerTypeLength());
        containerType.setHeight(prmContainerType.getPrmContainerTypeHeight());
        containerType.setWidth(prmContainerType.getPrmContainerTypeWidth());
        containerType.setActive(prmContainerType.getPrmContainerTypeActive());
        containerType.setUpdatedBy(prmContainerType.getUpdatedBy());
        containerType.setCreatedBy(prmContainerType.getCreatedBy());
        containerType.setMaxWeight(prmContainerType.getPrmContainerTypeMaxWeight());
        containerType.setWeight(prmContainerType.getPrmContainerTypeWeight());
        containerType.setDefaultForReception(prmContainerType.getPrmContainerTypeDefaultForReception());
        containerType.setDefaultForPreparation(prmContainerType.getPrmContainerTypeDefaultForPreparation());
        containerType.setPalette(prmContainerType.getPrmContainerTypePalette());
        return containerType;
    }

    public static List<ContainerType> toDtos(List<PrmContainerType> prmContainerTypes, boolean lazy) {
        if (null == prmContainerTypes) {
            return null;
        }
        List<ContainerType> containerTypes = new ArrayList<>();
        for (PrmContainerType prmContainerType : prmContainerTypes) {
            containerTypes.add(toDto(prmContainerType, lazy));
        }
        return containerTypes;
    }

    public static List<ContainerType> toDtos(Iterable<PrmContainerType> prmContainerTypes, boolean lazy) {
        if (null == prmContainerTypes) {
            return null;
        }
        List<ContainerType> containerTypes = new ArrayList<>();
        for (PrmContainerType prmContainerType : prmContainerTypes) {
            containerTypes.add(toDto(prmContainerType, lazy));
        }
        return containerTypes;
    }

    public static Set<PrmContainerType> toEntities(Set<ContainerType> containerTypes, boolean lazy) {
        if (null == containerTypes) {
            return null;
        }
        Set<PrmContainerType> prmContainerTypes = new HashSet<>();
        for (ContainerType containerType : containerTypes) {
            prmContainerTypes.add(toEntity(containerType, lazy));
        }
        return prmContainerTypes;
    }

    public static Set<ContainerType> toDtos(Set<PrmContainerType> prmContainerTypes, boolean lazy) {
        if (null == prmContainerTypes) {
            return null;
        }
        Set<ContainerType> containerTypes = new HashSet<>();
        for (PrmContainerType prmContainerType : prmContainerTypes) {
            containerTypes.add(toDto(prmContainerType, lazy));
        }
        return containerTypes;
    }
}
