package com.sinno.ems.mapper;

import com.sinno.ems.dto.DriverBadge;
import com.sinno.ems.entities.DrvDriverBadge;
import com.sinno.ems.util.Search;

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

        map.put("id", "drvDriverBadgeId");
        map.put("badge", "drvDriverBadgeBadge");
        map.put("driver", "drvDriverBadgeDriver");



    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static DrvDriverBadge toEntity(DriverBadge driverBadge,boolean lazy){
        if (null == driverBadge) {
            return null;
        }

        DrvDriverBadge drvDriverBadge = new DrvDriverBadge();
        drvDriverBadge.setDrvDriverBadgeId(driverBadge.getId());
        if (!lazy){
            drvDriverBadge.setDrvDriverBadgeBadge(BadgeMapper.toEntity(driverBadge.getBadge(),true));
            drvDriverBadge.setDrvDriverBadgeDriver(DriverMapper.toEntity(driverBadge.getDriver(),true));
        }
        return drvDriverBadge;
    }

    public static DriverBadge toDto(DrvDriverBadge drvDriverBadge,boolean lazy){
        if (null == drvDriverBadge) {
            return null;
        }
        DriverBadge driverBadge= new DriverBadge();
        driverBadge.setId(drvDriverBadge.getDrvDriverBadgeId());
        if (!lazy){
            driverBadge.setBadge(BadgeMapper.toDto(drvDriverBadge.getDrvDriverBadgeBadge(),true));
            driverBadge.setDriver(DriverMapper.toDto(drvDriverBadge.getDrvDriverBadgeDriver(),true));
        }
        return driverBadge;
    }
    public static List<DriverBadge>toDtos(List<DrvDriverBadge>drvDriverBadges , boolean lazy){
        if (null == drvDriverBadges) {
            return null;
        }
        List<DriverBadge>driverBadges=new ArrayList<>();
        for (DrvDriverBadge drvDriverBadge:drvDriverBadges) {
            driverBadges.add(toDto(drvDriverBadge,lazy));
        }
        return driverBadges;
    }
    public static List<DriverBadge>toDtos(Iterable<DrvDriverBadge>drvDriverBadges,boolean lazy){
        if (null == drvDriverBadges) {
            return null;
        }
        List<DriverBadge>driverBadges=new ArrayList<>();
        for (DrvDriverBadge drvDriverBadge : drvDriverBadges){
            driverBadges.add(toDto(drvDriverBadge,lazy));
        }
        return driverBadges;
    }
    public static Set<DrvDriverBadge>toEntities(Set<DriverBadge>driverBadges,boolean lazy){
        if (null == driverBadges) {
            return null;
        }
        Set<DrvDriverBadge>drvDriverBadges = new HashSet<>();
        for (DriverBadge driverBadge : driverBadges){
            drvDriverBadges.add(toEntity(driverBadge,lazy));
        }
        return drvDriverBadges;
    }
    public static Set<DriverBadge>toDtos(Set<DrvDriverBadge>drvDriverBadges,boolean lazy){
        if (null == drvDriverBadges) {
            return null;
        }
        Set<DriverBadge>driverBadges = new HashSet<>();
        for (DrvDriverBadge drvDriverBadge : drvDriverBadges){
            driverBadges.add(toDto(drvDriverBadge,lazy));
        }
        return driverBadges;
    }

    }

