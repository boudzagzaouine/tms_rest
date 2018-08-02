package com.bagile.tms.mapper;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.entities.TmsDriver;

import java.util.*;


public class DriverMapper {
    private DriverMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsDriverId");
        map.put("code", "tmsDriverCode");
        map.put("cin", "tmsDriverCin");
        map.put("badges", "tmsDriverBadge");
        map.put("lastMedicalVisit","tmsDriverLastMedicalVisit");
        map.put("workArea","tmsDriverWorkArea");
        map.put("vacation", "tmsDriverVacation");
        map.put("commission", "tmsDriverCommission");
        map.put("contact", "tmsDriverContact");
        map.put("creationDate", "tmsDriverCreationDate");
        map.put("creationUser", "tmsDriverCreationUser");
        map.put("upDateDate", "tmsDriverUpdateDate");

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
        tmsDriver.setTmsDriverCin(driver.getCin());
        tmsDriver.setTmsDriverCin(driver.getCode());
        if (!lazy) {
            tmsDriver.setTmsDrivercontact(com.bagile.tms.mapper.ContactMapper.toEntity(driver.getContact(),true));
            tmsDriver.setTmsDriverCreationUser(UserMapper.toEntity(driver.getCreationUser(),true));
            tmsDriver.setTmsDriverUpDateDate(UserMapper.toEntity(driver.getUpDateDate(),true));
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
        driver.setCreationDate(tmsDriver.getTmsDriverCreationDate());
        driver.setUpDateDate(tmsDriver.getTmsDriverUpDateDate());

        if (!lazy) {
            driver.setContact(com.bagile.tms.mapper.ContactMapper.toDto(tmsDriver.getTmsDrivercontact(),true));
            driver.setUpDateDate(UserMapper.toDto(tmsDriver.getTmsDriverUpDateDate(),true));
            driver.setDriverBadges(DriverBadgeMapper.toDtos(tmsDriver.getTmsDriverBadges(),true);
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

