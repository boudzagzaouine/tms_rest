package com.bagile.tms.mapper;

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
        map.put("id", "tmsBadgeId");
        map.put("code", "tmsBadgeCode");
        map.put("libelle", "tmsBadgeLibelle");
        map.put("description", "tmsBadgeDescription");
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
        tmsBadge.setTmsBadgeCode(badge.getCode());
        tmsBadge.setTmsBadgeId(badge.getId());
        tmsBadge.setTmsBadgeDescription(badge.getDescription());
        tmsBadge.setTmsBadgeLibelle(badge.getLibelle());
        if (!lazy) {
            tmsBadge.setTmsDriverBadges(DriverBadgeMapper.toEntities(badge.getDriverBadges(),true));
            tmsBadge.setTmsBadgeVehicule(VehicleMapper.toEntities(badge.getVehicules(),true));
        }
        return tmsBadge;
    }

    public static Badge toDto(TmsBadge tmsBadge, boolean lazy) {
        if (null == tmsBadge) {
            return null;
        }
        Badge badge = new Badge();
        badge.setId(tmsBadge.getTmsBadgeId());
        badge.setCode(tmsBadge.getTmsBadgeCode());
        badge.setDescription(tmsBadge.getTmsBadgeDescription());
        badge.setLibelle(tmsBadge.getTmsBadgeLibelle());
        if (!lazy) {
            badge.setDriverBadges(DriverBadgeMapper.toDtos(tmsBadge.getTmsDriverBadges(),true));
            badge.setVehicules(VehicleMapper.toDtos(tmsBadge.getTmsBadgeVehicule(),true));

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
    public static List<Badge> toDtos(Iterable<TmsBadge> tmsBadges, boolean lazy) {
        if (null == tmsBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (TmsBadge tmsBadge : tmsBadges) {
            badges.add(toDto(tmsBadge, lazy));
        }
        return badges;
    }
    public static Set<TmsBadge> toEntities(Set<Badge>badges, boolean lazy){
        if (null == badges) {
            return null;
        }
        Set<TmsBadge> tmsDrivers = new HashSet<>();
        for(Badge badge:badges){
            tmsDrivers.add(toEntity(badge,lazy));
        }
        return tmsDrivers;
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





