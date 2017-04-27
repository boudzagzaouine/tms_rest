package com.sinno.ems.mapper;

import com.sinno.ems.dto.Badge;
import com.sinno.ems.entities.TmsBadge;

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

    public static TmsBadge toEntity(Badge badge, boolean lazy) {
        if (null == badge) {
            return null;
        }
        TmsBadge tmsBadge = new TmsBadge();
        tmsBadge.setPrmBadgeCode(badge.getCode());
        tmsBadge.setPrmBadgeId(badge.getId());
        tmsBadge.setPrmBadgeDescription(badge.getDescription());
        tmsBadge.setPrmBadgeLibelle(badge.getLibelle());
        if (!lazy) {

        }
        return tmsBadge;
    }

    public static Badge toDto(TmsBadge tmsBadge, boolean lazy) {
        if (null == tmsBadge) {
            return null;
        }
        Badge badge = new Badge();
        badge.setId(tmsBadge.getPrmBadgeId());
        badge.setCode(tmsBadge.getPrmBadgeCode());
        badge.setDescription(tmsBadge.getPrmBadgeDescription());
        badge.setLibelle(tmsBadge.getPrmBadgeLibelle());
        if (!lazy) {

        }
        return badge;
    }

    public static List<Badge> toDtos(List<TmsBadge> tmsBadges, boolean lazy) {
        if (null == tmsBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (TmsBadge tmsBadge : tmsBadges) {
            badges.add(toDto(tmsBadge, lazy));

        }
        return badges;
    }
    public static List<Badge> toDtos(Iterable<TmsBadge> prmBadges, boolean lazy) {
        if (null == prmBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (TmsBadge tmsBadge : prmBadges) {
            badges.add(toDto(tmsBadge, lazy));
        }
        return badges;
    }
    public static Set<TmsBadge> toEntities(Set<Badge>badges, boolean lazy){
        if (null == badges) {
            return null;
        }
        Set<TmsBadge> prmDrivers = new HashSet<>();
        for(Badge badge:badges){
            prmDrivers.add(toEntity(badge,lazy));
        }
        return prmDrivers;
    }
    public static Set<Badge> toDtos(Set<TmsBadge> tmsBadges, boolean lazy){
        if(null == tmsBadges){
            return null;
        }
        Set<Badge> badges = new HashSet<>();
        for(TmsBadge tmsBadge : tmsBadges){
            badges.add(toDto(tmsBadge,lazy));
        }
        return badges;
    }

}





