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
        map.put("birthDate", "tmsDrivetBirthDate");
        map.put("badges", "tmsDriverBadges");
        map.put("lastMedicalVisit","tmsDriverLastMedicalVisit");
        map.put("workArea","tmsDriverWorkArea");
        map.put("vacation", "tmsDriverVacation");
        map.put("commission", "tmsDriverCommission");
        map.put("working","tmsDriverWorking");
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
        tmsDriver.setTmsDriverCode(driver.getCode());
        tmsDriver.setTmsDriverCommission(driver.getCommission());
        tmsDriver.setTmsDriverWorking(driver.isWorking());
        tmsDriver.setTmsDriverBirthDate(driver.getBirthDate());
        tmsDriver.setTmsDriverlastMedicalVisit(driver.getLastMedicalVisit());
        tmsDriver.setTmsDriverCreationDate(driver.getCreationDate());
        tmsDriver.setTmsDriverUpDateDate(driver.getUpDateDate());

        if (!lazy) {
            tmsDriver.setTmsDrivercontact(com.bagile.tms.mapper.ContactMapper.toEntity(driver.getContact(),true));
            tmsDriver.setTmsDriverCreationUser(UserMapper.toEntity(driver.getCreationUser(),true));
            tmsDriver.setTmsDriverBadges(BadgeMapper.toEntities(driver.getBadges(),true));
            tmsDriver.setTmsDriverWorkArea(ZoneMapper.toEntity(driver.getWorkArea(),true));
        }
        return tmsDriver;
    }

    public static Driver toDto(TmsDriver tmsDriver, boolean lazy) {
        if (null == tmsDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(tmsDriver.getTmsDriverId());
        driver.setCode(tmsDriver.getTmsDriverCode());
        driver.setCin(tmsDriver.getTmsDriverCin());
        driver.setCommission(tmsDriver.getTmsDriverCommission());
        driver.setWorking(tmsDriver.isTmsDriverWorking());
        driver.setBirthDate(tmsDriver.getTmsDriverBirthDate());
        driver.setLastMedicalVisit(tmsDriver.getTmsDriverlastMedicalVisit());
        driver.setCreationDate(tmsDriver.getTmsDriverCreationDate());
        driver.setUpDateDate(tmsDriver.getTmsDriverUpDateDate());

        if (!lazy) {
            driver.setContact(ContactMapper.toDto(tmsDriver.getTmsDrivercontact(),true));
            driver.setCreationUser(UserMapper.toDto(tmsDriver.getTmsDriverCreationUser(),true));
            driver.setBadges(BadgeMapper.toDtos(tmsDriver.getTmsDriverBadges(),true));
            driver.setWorkArea(ZoneMapper.toDto(tmsDriver.getTmsDriverWorkArea(),true));
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

