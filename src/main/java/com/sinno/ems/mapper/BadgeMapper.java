package com.sinno.ems.mapper;

import com.sinno.ems.dto.Badge;
import com.sinno.ems.entities.PrmBadge;

import java.util.*;

/**
 * Created by khalil on 21/03/2017.
 */
public class BadgeMapper {
    private BadgeMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmBadgeId");
        map.put("code", "prmBadgeCode");
        map.put("libelle", "prmBadgeLibelle");
        map.put("description", "prmBadgeDescription");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static PrmBadge toEntity(Badge badge, boolean lazy) {
        if (null == badge) {
            return null;
        }
        PrmBadge prmBadge = new PrmBadge();
        prmBadge.setPrmBadgeCode(badge.getCode());
        prmBadge.setPrmBadgeId(badge.getId());
        prmBadge.setPrmBadgeDescription(badge.getDescription());
        prmBadge.setPrmBadgeLibelle(badge.getLibelle());
        if (!lazy) {

        }
        return prmBadge;
    }

    public static Badge toDto(PrmBadge prmBadge, boolean lazy) {
        if (null == prmBadge) {
            return null;
        }
        Badge badge = new Badge();
        badge.setId(prmBadge.getPrmBadgeId());
        badge.setCode(prmBadge.getPrmBadgeCode());
        badge.setDescription(prmBadge.getPrmBadgeDescription());
        badge.setLibelle(prmBadge.getPrmBadgeLibelle());
        if (!lazy) {

        }
        return badge;
    }

    public static List<Badge> toDtos(List<PrmBadge> prmBadges, boolean lazy) {
        if (null == prmBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (PrmBadge prmBadge : prmBadges) {
            badges.add(toDto(prmBadge, lazy));

        }
        return badges;
    }
    public static List<Badge> toDtos(Iterable<PrmBadge> prmBadges, boolean lazy) {
        if (null == prmBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (PrmBadge prmBadge : prmBadges) {
            badges.add(toDto(prmBadge, lazy));
        }
        return badges;
    }
    public static Set<PrmBadge> toEntities(Set<Badge>badges, boolean lazy){
        if (null == badges) {
            return null;
        }
        Set<PrmBadge> prmDrivers = new HashSet<>();
        for(Badge badge:badges){
            prmDrivers.add(toEntity(badge,lazy));
        }
        return prmDrivers;
    }
    public static Set<Badge> toDtos(Set<PrmBadge> prmBadges,boolean lazy){
        if(null ==prmBadges){
            return null;
        }
        Set<Badge> badges = new HashSet<>();
        for(PrmBadge prmBadge:prmBadges){
            badges.add(toDto(prmBadge,lazy));
        }
        return badges;
    }

}





