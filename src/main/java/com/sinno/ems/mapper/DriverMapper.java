package com.sinno.ems.mapper;

import com.sinno.ems.dto.Driver;
import com.sinno.ems.entities.TmsDriver;

import java.util.HashMap;
import java.util.*;

/**
 * Created by khalil on 22/03/2017.
 */
public class DriverMapper {
    private DriverMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsDriverId");
        map.put("passportNumber", "tmsDriverPassportNumber");
        map.put("incidents", "tmsDriverIncidents");
        map.put("badge", "tmsDriverBadge");
        map.put("driversituation", "tmsDriversituation");

        map.put("dateCreation", "tmsDriverDateCreation");
        map.put("dateUpDate", "tmsDriverDateUpDate");
        map.put("creationUser", "tmsDriverCreationUser");
        map.put("upDateUser", "tmsDriverUpDateUser");
        map.put("driverBadges", "drvDriverBadges");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsDriver toEntity(Driver driver, boolean lazy) {
        if (null == driver) {
            return null;
        }
        TmsDriver tmsDriver = new TmsDriver();
        tmsDriver.setTmsDriverId(driver.getId());
        tmsDriver.setTmsDriverPassportNumber(driver.getPassportNumber());
        tmsDriver.setTmsDriverDateCreation(driver.getDateCreation());
        tmsDriver.setTmsDriverDateUpDate(driver.getDateUpDate());
        if (!lazy) {
            tmsDriver.setPincidents(IncidentMapper.toEntities(driver.getIncidents(),true));
            tmsDriver.setPbadges(BadgeMapper.toEntities(driver.getBadges(),true));
            tmsDriver.setTmsDriverSituation(DriverSituationMapper.toEntity(driver.getDriverSituation(),true));
            tmsDriver.setTmsDriverCreationUser(UserMapper.toEntity(driver.getCreationUser(),true));
            tmsDriver.setTmsDriverUpDateUser(UserMapper.toEntity(driver.getUpDateUser(),true));
            tmsDriver.setTmsDriverBadges(DriverBadgeMapper.toEntities(driver.getDriverBadges(),true));
        }
        return tmsDriver;
    }

    public static Driver toDto(TmsDriver tmsDriver, boolean lazy) {
        if (null == tmsDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(tmsDriver.getTmsDriverId());
        driver.setDateCreation(tmsDriver.getTmsDriverDateCreation());
        driver.setDateUpDate(tmsDriver.getTmsDriverDateUpDate());

        if (!lazy) {
            driver.setIncidents(IncidentMapper.toDtos(tmsDriver.getPincidents(),true));
            driver.setBadges(BadgeMapper.toDtos(tmsDriver.getPbadges(),true));
            driver.setDriverSituation(DriverSituationMapper.toDto(tmsDriver.getTmsDriverSituation(),true));
            driver.setCreationUser(UserMapper.toDto(tmsDriver.getTmsDriverCreationUser(),true));
            driver.setUpDateUser(UserMapper.toDto(tmsDriver.getTmsDriverUpDateUser(),true));
            driver.setDriverBadges(DriverBadgeMapper.toDtos(tmsDriver.getTmsDriverBadges(),true));
        }
        return driver;
    }

    public static List<Driver> toDtos(List<TmsDriver> tmsDrivers, boolean lazy) {
        if (null == tmsDrivers) {
            return null;
        }
        List<Driver> drivers = new ArrayList<>();
        for (TmsDriver tmsDriver : tmsDrivers) {
            drivers.add(toDto(tmsDriver, lazy));

        }
        return drivers;
    }

    public static List<Driver> toDtos(Iterable<TmsDriver> tmsDrivers, boolean lazy) {
        if (null == tmsDrivers) {
            return null;
        }
        List<Driver> drivers = new ArrayList<>();
        for (TmsDriver tmsDriver : tmsDrivers) {
            drivers.add(toDto(tmsDriver, lazy));
        }
        return drivers;
    }
    public static Set<TmsDriver> toEntities(Set<Driver>drivers, boolean lazy){
        if (null == drivers) {
            return null;
        }
        Set<TmsDriver> tmsDrivers = new HashSet<>();
        for(Driver driver:drivers){
            tmsDrivers.add(toEntity(driver,lazy));
        }
        return tmsDrivers;
    }
    public static Set<Driver> toDtos(Set<TmsDriver> tmsDrivers, boolean lazy){
        if(null == tmsDrivers){
            return null;
        }
        Set<Driver> drivers = new HashSet<>();
        for(TmsDriver tmsDriver : tmsDrivers){
            drivers.add(toDto(tmsDriver,lazy));
        }
        return drivers;
    }


}

