package com.sinno.ems.mapper;

import com.sinno.ems.dto.Driver;
import com.sinno.ems.dto.User;
import com.sinno.ems.entities.PrmDriver;

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

    public static PrmDriver toEntity(Driver driver, boolean lazy) {
        if (null == driver) {
            return null;
        }
        PrmDriver prmDriver = new PrmDriver();
        prmDriver.setPrmDriverId(driver.getId());
        prmDriver.setPrmDriverPassportNumber(driver.getPassportNumber());
        prmDriver.setPrmDriverDateCreation(driver.getDateCreation());
        prmDriver.setPrmDriverDateUpDate(driver.getDateUpDate());
        if (!lazy) {
            prmDriver.setPincidents(IncidentMapper.toEntities(driver.getIncidents(),true));
            prmDriver.setPbadges(BadgeMapper.toEntities(driver.getBadges(),true));
            prmDriver.setPrmDriverSituation(DriverSituationMapper.toEntity(driver.getDriverSituation(),true));
            prmDriver.setPrmDriverCreationUser(UserMapper.toEntity(driver.getCreationUser(),true));
            prmDriver.setPrmDriverUpDateUser(UserMapper.toEntity(driver.getUpDateUser(),true));
            prmDriver.setDrvDriverBadges(DriverBadgeMapper.toEntities(driver.getDriverBadges(),true));
        }
        return prmDriver;
    }

    public static Driver toDto(PrmDriver prmDriver, boolean lazy) {
        if (null == prmDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(prmDriver.getPrmDriverId());
        driver.setDateCreation(prmDriver.getPrmDriverDateCreation());
        driver.setDateUpDate(prmDriver.getPrmDriverDateUpDate());

        if (!lazy) {
            driver.setIncidents(IncidentMapper.toDtos(prmDriver.getPincidents(),true));
            driver.setBadges(BadgeMapper.toDtos(prmDriver.getPbadges(),true));
            driver.setDriverSituation(DriverSituationMapper.toDto(prmDriver.getPrmDriverSituation(),true));
            driver.setCreationUser(UserMapper.toDto(prmDriver.getPrmDriverCreationUser(),true));
            driver.setUpDateUser(UserMapper.toDto(prmDriver.getPrmDriverUpDateUser(),true));
            driver.setDriverBadges(DriverBadgeMapper.toDtos(prmDriver.getDrvDriverBadges(),true));
        }
        return driver;
    }

    public static List<Driver> toDtos(List<PrmDriver> prmDrivers, boolean lazy) {
        if (null == prmDrivers) {
            return null;
        }
        List<Driver> drivers = new ArrayList<>();
        for (PrmDriver prmDriver : prmDrivers) {
            drivers.add(toDto(prmDriver, lazy));

        }
        return drivers;
    }

    public static List<Driver> toDtos(Iterable<PrmDriver> prmDrivers, boolean lazy) {
        if (null == prmDrivers) {
            return null;
        }
        List<Driver> drivers = new ArrayList<>();
        for (PrmDriver prmDriver : prmDrivers) {
            drivers.add(toDto(prmDriver, lazy));
        }
        return drivers;
    }
    public static Set<PrmDriver> toEntities(Set<Driver>drivers,boolean lazy){
        if (null == drivers) {
            return null;
        }
        Set<PrmDriver> prmDrivers = new HashSet<>();
        for(Driver driver:drivers){
            prmDrivers.add(toEntity(driver,lazy));
        }
        return prmDrivers;
    }
    public static Set<Driver> toDtos(Set<PrmDriver> prmDrivers,boolean lazy){
        if(null ==prmDrivers){
            return null;
        }
        Set<Driver> drivers = new HashSet<>();
        for(PrmDriver prmDriver:prmDrivers){
            drivers.add(toDto(prmDriver,lazy));
        }
        return drivers;
    }


}

