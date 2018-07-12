package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 15/12/2016.
 */
public class WarrantyPeriodMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmWarrantyPeriodId");
        map.put("code", "prmWarrantyPeriodCode");
        map.put("description", "prmWarrantyPeriodDescription");
        map.put("creationDate", "prmWarrantyPeriodCreationDate");
        map.put("updateDate", "prmWarrantyPeriodUpdateDate");
        //map.put("organisation", "prmWarrantyPeriodOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmWarrantyPeriod toEntity(WarrantyPeriod warrantyPeriod, boolean lazy) {
        if (null == warrantyPeriod) {
            return null;
        }
        PrmWarrantyPeriod prmWarrantyPeriod = new PrmWarrantyPeriod();
        prmWarrantyPeriod.setPrmWarrantyPeriodId(warrantyPeriod.getId());
        prmWarrantyPeriod.setPrmWarrantyPeriodCode(warrantyPeriod.getCode() != null ? warrantyPeriod.getCode().toUpperCase() : null);
        prmWarrantyPeriod.setPrmWarrantyPeriodDescription(warrantyPeriod.getDescription());
        prmWarrantyPeriod.setPrmWarrantyPeriodCreationDate(warrantyPeriod.getCreationDate());
        prmWarrantyPeriod.setPrmWarrantyPeriodUpdateDate(warrantyPeriod.getUpdateDate());

        if (!lazy) {
            // prmWarrantyPeriod.setOrgOrganisation(OrganisationMapper.toEntity(warrantyPeriod.getOrganisation(), true));
        }
        return prmWarrantyPeriod;
    }

    public static WarrantyPeriod toDto(PrmWarrantyPeriod prmWarrantyPeriod, boolean lazy) {
        if (null == prmWarrantyPeriod) {
            return null;
        }
        WarrantyPeriod warrantyPeriod = new WarrantyPeriod();
        warrantyPeriod.setId(prmWarrantyPeriod.getPrmWarrantyPeriodId());
        warrantyPeriod.setCode(prmWarrantyPeriod.getPrmWarrantyPeriodCode());
        warrantyPeriod.setDescription(prmWarrantyPeriod.getPrmWarrantyPeriodDescription());
        warrantyPeriod.setCreationDate(prmWarrantyPeriod.getPrmWarrantyPeriodCreationDate());
        warrantyPeriod.setUpdateDate(prmWarrantyPeriod.getPrmWarrantyPeriodUpdateDate());

        if (!lazy) {
            // warrantyPeriod.setOrganisation(OrganisationMapper.toDto(prmWarrantyPeriod.getOrgOrganisation(), true));
        }
        return warrantyPeriod;
    }

    public static List<WarrantyPeriod> toDtos(List<PrmWarrantyPeriod> prmWarrantyPeriods, boolean lazy) {
        if (null == prmWarrantyPeriods) {
            return null;
        }
        List<WarrantyPeriod> warrantyPeriods = new ArrayList<>();
        for (PrmWarrantyPeriod prmWarrantyPeriod : prmWarrantyPeriods) {
            warrantyPeriods.add(toDto(prmWarrantyPeriod, lazy));
        }
        return warrantyPeriods;
    }

    public static List<WarrantyPeriod> toDtos(Iterable<PrmWarrantyPeriod> prmWarrantyPeriods, boolean lazy) {
        if (null == prmWarrantyPeriods) {
            return null;
        }
        List<WarrantyPeriod> warrantyPeriods = new ArrayList<>();
        for (PrmWarrantyPeriod prmWarrantyPeriod : prmWarrantyPeriods) {
            warrantyPeriods.add(toDto(prmWarrantyPeriod, lazy));
        }
        return warrantyPeriods;
    }

    public static Set<PrmWarrantyPeriod> toEntities(Set<WarrantyPeriod> warrantyPeriods, boolean lazy) {
        if (null == warrantyPeriods) {
            return null;
        }
        Set<PrmWarrantyPeriod> prmWarrantyPeriods = new HashSet<>();
        for (WarrantyPeriod warrantyPeriod : warrantyPeriods) {
            prmWarrantyPeriods.add(toEntity(warrantyPeriod, lazy));
        }
        return prmWarrantyPeriods;
    }

    public static Set<WarrantyPeriod> toDtos(Set<PrmWarrantyPeriod> prmWarrantyPeriods, boolean lazy) {
        if (null == prmWarrantyPeriods) {
            return null;
        }
        Set<WarrantyPeriod> warrantyPeriods = new HashSet<>();
        for (PrmWarrantyPeriod prmWarrantyPeriod : prmWarrantyPeriods) {
            warrantyPeriods.add(toDto(prmWarrantyPeriod, lazy));
        }
        return warrantyPeriods;
    }
}
