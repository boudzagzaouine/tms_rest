package com.sinno.ems.mapper;

import com.sinno.ems.dto.Address;
import com.sinno.ems.dto.Driver;
import com.sinno.ems.entities.TmsDriver;

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
        map.put("driversituation", "tmsDriverSituation");
        map.put("dateCreation", "tmsDriverDateCreation");
        map.put("dateUpDate", "tmsDriverDateUpDate");
        map.put("contact","prmContact");
        map.put("address","prmAddress");
        map.put("creationUser", "tmsDriverCreationUser");
        map.put("upDateUser", "tmsDriverUpDateUser");


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
            tmsDriver.setAdrAddress(AddressMapper.toEntity(driver.getAddress(),true));
            tmsDriver.setPrmContact(ContactMapper.toEntity(driver.getContact(),true));
            tmsDriver.setPincidents(IncidentMapper.toEntities(driver.getIncidents(),true));
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
            driver.setContact(ContactMapper.toDto(tmsDriver.getPrmContact(),true));
            driver.setAddress(AddressMapper.toDto(tmsDriver.getAdrAddress(),true));
            driver.setIncidents(IncidentMapper.toDtos(tmsDriver.getPincidents(),true));
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

