package com.bagile.tms.mapper;

import com.bagile.tms.dto.DriverBadge;

import java.util.*;

/**
 * Created by bouzi on 4/25/2017.
 */
public class DriverBadgeMapper {
    public DriverBadgeMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsDriverBadgeId");
        map.put("badge", "tmsDriverBadgeBadge");
        map.put("driver", "tmsDriverBadgeDriver");



    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsDriverBadge toEntity(DriverBadge driverBadge, boolean lazy){
        if (null == driverBadge) {
            return null;
        }

        TmsDriverBadge tmsDriverBadge = new TmsDriverBadge();
        tmsDriverBadge.setTmsDriverBadgeId(driverBadge.getId());
        if (!lazy){
            tmsDriverBadge.setTmsDriverBadgeBadge(BadgeMapper.toEntity(driverBadge.getBadge(),true));
            tmsDriverBadge.setTmsDriverBadgeDriver(DriverMapper.toEntity(driverBadge.getDriver(),true));
        }
        return tmsDriverBadge;
    }

    public static DriverBadge toDto(TmsDriverBadge tmsDriverBadge, boolean lazy){
        if (null == tmsDriverBadge) {
            return null;
        }
        DriverBadge driverBadge= new DriverBadge();
        driverBadge.setId(tmsDriverBadge.getTmsDriverBadgeId());
        if (!lazy){
            driverBadge.setBadge(BadgeMapper.toDto(tmsDriverBadge.getTmsDriverBadgeBadge(),true));
            driverBadge.setDriver(DriverMapper.toDto(tmsDriverBadge.getTmsDriverBadgeDriver(),true));
        }
        return driverBadge;
    }
    public static List<DriverBadge>toDtos(List<TmsDriverBadge> tmsDriverBadges, boolean lazy){
        if (null == tmsDriverBadges) {
            return null;
        }
        List<DriverBadge>driverBadges=new ArrayList<>();
        for (TmsDriverBadge tmsDriverBadge : tmsDriverBadges) {
            driverBadges.add(toDto(tmsDriverBadge,lazy));
        }
        return driverBadges;
    }
    public static List<DriverBadge>toDtos(Iterable<TmsDriverBadge>tmsDriverBadges, boolean lazy){
        if (null == tmsDriverBadges) {
            return null;
        }
        List<DriverBadge>driverBadges=new ArrayList<>();
        for (TmsDriverBadge tmsDriverBadge : tmsDriverBadges){
            driverBadges.add(toDto(tmsDriverBadge,lazy));
        }
        return driverBadges;
    }
    public static Set<TmsDriverBadge>toEntities(Set<DriverBadge>driverBadges, boolean lazy){
        if (null == driverBadges) {
            return null;
        }
        Set<TmsDriverBadge> tmsDriverBadges = new HashSet<>();
        for (DriverBadge driverBadge : driverBadges){
            tmsDriverBadges.add(toEntity(driverBadge,lazy));
        }
        return tmsDriverBadges;
    }
    public static Set<DriverBadge>toDtos(Set<TmsDriverBadge> tmsDriverBadges, boolean lazy){
        if (null == tmsDriverBadges) {
            return null;
        }
        Set<DriverBadge>driverBadges = new HashSet<>();
        for (TmsDriverBadge tmsDriverBadge : tmsDriverBadges){
            driverBadges.add(toDto(tmsDriverBadge,lazy));
        }
        return driverBadges;
    }

    }

