package com.bagile.tms.mapper;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.entities.TmsDriver;

import java.util.*;

public class DriverMapper {
    public DriverMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsDriverId");
        map.put("registrationNumber", "tmsRegistrationNumber");
        map.put("code", "tmsDriverCode");
        map.put("technicalVisit", "tmsDriverTechnicalVisit");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("driverCategory", "tmsDriverCategory");
        map.put("badgeType", "tmsBadgeType");
        map.put("insurance", "tmsBadgeType");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsDriver toEntity(Driver driver, boolean lazy) {
        if (null == driver) {
            return null;
        }
        TmsDriver tmsDriver = new TmsDriver();
        tmsDriver.setTmsDriverId(driver.getId());
        tmsDriver.setTmsDriverCin(driver.getCin());
        tmsDriver.setTmsDriverCode(driver.getCode() != null ? driver.getCode().toUpperCase() : null);
        tmsDriver.setTmsDriverCommission(driver.getCommission());
        tmsDriver.setTmsDriverLastMedicalVisit(driver.getLastMedicalVisit());
        tmsDriver.setTmsDriverbirthDate(driver.getBirthDate());
    


        tmsDriver.setCreatedBy(driver.getCreatedBy());
        tmsDriver.setUpdatedBy(driver.getUpdatedBy());
        tmsDriver.setCreationDate(driver.getCreationDate());
        tmsDriver.setUpdateDate(driver.getUpdateDate());


        if (!lazy) {
            tmsDriver.setTmsContact(ContactMapper.toEntity(driver.getContact(), true));
          

        }
        return tmsDriver;

    }

    public static Driver toDto(TmsDriver tmsDriver, boolean lazy) {
        if (null == tmsDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId((int) tmsDriver.getTmsDriverId());
        driver.setCin(tmsDriver.getTmsDriverCin());
        driver.setCode(tmsDriver.getTmsDriverCode() != null ? tmsDriver.getTmsDriverCode().toUpperCase() : null);
        driver.setBirthDate(tmsDriver.getTmsDriverbirthDate());
        driver.setLastMedicalVisit(tmsDriver.getTmsDriverLastMedicalVisit());
        driver.setCommission(tmsDriver.getTmsDriverCommission());


        driver.setCreatedBy(tmsDriver.getCreatedBy());
        driver.setUpdatedBy(tmsDriver.getUpdatedBy());
        driver.setCreationDate(tmsDriver.getCreationDate());
        driver.setUpdateDate(tmsDriver.getUpdateDate());

        if (!lazy) {
            driver.setContact(ContactMapper.toDto(tmsDriver.getprmContact(), lazy));
           

        }
        return driver;

    }


    public static List<Driver> toDtos(Iterable<? extends TmsDriver> tmsDrivers, boolean lazy) {
        if (null == tmsDrivers) {
            return null;
        }
        List<Driver> vehicules = new ArrayList<>();

        for (TmsDriver tmsDriver : tmsDrivers) {
            vehicules.add(toDto(tmsDriver, lazy));
        }
        return vehicules;
    }

    public static Set<TmsDriver> toEntities(Set<Driver> drivers, boolean lazy) {
        if (null == drivers) {
            return null;
        }
        Set<TmsDriver> tmsDrivers = new HashSet<>();
        for (Driver driver : drivers) {
            tmsDrivers.add(toEntity(driver, lazy));
        }
        return tmsDrivers;
    }

    public static Set<Driver> toDtos(Set<TmsDriver> tmsDrivers, boolean lazy) {
        if (null == tmsDrivers) {
            return null;
        }
        Set<Driver> drivers = new HashSet<>();
        for (TmsDriver tmsDriver : tmsDrivers) {
            drivers.add(toDto(tmsDriver, lazy));
        }
        return drivers;
    }
}
