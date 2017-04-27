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
        map.put("id", "prmDriverId");
        map.put("passportNumber", "prmDriverPassportNumber");
        map.put("incidents", "prmDriverIncidents");
        map.put("badge", "prmDriverBadge");
        map.put("driversituation", "prmDriversituation");

        map.put("dateCreation", "prmDriverDateCreation");
        map.put("dateUpDate", "prmDriverDateUpDate");
        map.put("creationUser", "prmDriverCreationUser");
        map.put("upDateUser", "prmDriverUpDateUser");
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
        tmsDriver.setPrmDriverId(driver.getId());
        tmsDriver.setPrmDriverPassportNumber(driver.getPassportNumber());
        tmsDriver.setPrmDriverDateCreation(driver.getDateCreation());
        tmsDriver.setPrmDriverDateUpDate(driver.getDateUpDate());
        if (!lazy) {
            tmsDriver.setPincidents(IncidentMapper.toEntities(driver.getIncidents(),true));
            tmsDriver.setPbadges(BadgeMapper.toEntities(driver.getBadges(),true));
            tmsDriver.setTmsDriverSituation(DriverSituationMapper.toEntity(driver.getDriverSituation(),true));
            tmsDriver.setPrmDriverCreationUser(UserMapper.toEntity(driver.getCreationUser(),true));
            tmsDriver.setPrmDriverUpDateUser(UserMapper.toEntity(driver.getUpDateUser(),true));
            tmsDriver.setDrvDriverBadges(DriverBadgeMapper.toEntities(driver.getDriverBadges(),true));
        }
        return tmsDriver;
    }

    public static Driver toDto(TmsDriver tmsDriver, boolean lazy) {
        if (null == tmsDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(tmsDriver.getPrmDriverId());
        driver.setDateCreation(tmsDriver.getPrmDriverDateCreation());
        driver.setDateUpDate(tmsDriver.getPrmDriverDateUpDate());

        if (!lazy) {
            driver.setIncidents(IncidentMapper.toDtos(tmsDriver.getPincidents(),true));
            driver.setBadges(BadgeMapper.toDtos(tmsDriver.getPbadges(),true));
            driver.setDriverSituation(DriverSituationMapper.toDto(tmsDriver.getTmsDriverSituation(),true));
            driver.setCreationUser(UserMapper.toDto(tmsDriver.getPrmDriverCreationUser(),true));
            driver.setUpDateUser(UserMapper.toDto(tmsDriver.getPrmDriverUpDateUser(),true));
            driver.setDriverBadges(DriverBadgeMapper.toDtos(tmsDriver.getDrvDriverBadges(),true));
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

    public static List<Driver> toDtos(Iterable<TmsDriver> prmDrivers, boolean lazy) {
        if (null == prmDrivers) {
            return null;
        }
        List<Driver> drivers = new ArrayList<>();
        for (TmsDriver tmsDriver : prmDrivers) {
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

