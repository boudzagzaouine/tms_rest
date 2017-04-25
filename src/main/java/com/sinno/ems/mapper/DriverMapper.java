package com.sinno.ems.mapper;

import com.sinno.ems.dto.Driver;
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
      // map.put("code", "prmDriverCode");
        map.put("passportNumber", "prmDriverPassportNumber");
       // map.put("passportLink", "prmDriverPassportLink");
       // map.put("lastName", "prmDriverLastName");
        //map.put("firstName", "prmDriverFirstName");
        //map.put("birthay", "prmDriverBirthay");
       // map.put("cellPhone", "prmDriverCellphone");
        map.put("incidents", "prmDriverIncidents");
      //  map.put("roads", "prmDriverRoads");
        map.put("badge", "prmDriverBadge");
     //   map.put("adresse", "prmDriverAdresse");
        map.put("driversituation", "prmDriversituation");

        map.put("driversituation", "prmDriversituation");
        map.put("driversituation", "prmDriversituation");
        map.put("driversituation", "prmDriversituation");
        map.put("driversituation", "prmDriversituation");

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
      //  prmDriver.setPrmDriverCode(driver.getCode());
        prmDriver.setPrmDriverPassportNumber(driver.getPassportNumber());
      //  prmDriver.setPrmDriverPassportLink(driver.getPassportLink());
      //  prmDriver.setPrmDriverLastName(driver.getLastName());
      //  prmDriver.setPrmDriverFirstName(driver.getFirstName());
      //  prmDriver.setPrmDriverBirthDay(driver.getBirthDay());
       // prmDriver.setPrmDriverCellPhone(driver.getCellPhone());
        if (!lazy) {
            prmDriver.setPincidents(IncidentMapper.toEntities(driver.getIncidents(),true));
        //    prmDriver.setProads(RoadMapper.toEntities(driver.getRoads(),true));
            prmDriver.setPbadges(BadgeMapper.toEntities(driver.getBadges(),true));
        }
        return prmDriver;
    }

    public static Driver toDto(PrmDriver prmDriver, boolean lazy) {
        if (null == prmDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(prmDriver.getPrmDriverId());
       // driver.setCode(prmDriver.getPrmDriverCode());
        //driver.setPassportNumber(prmDriver.getPrmDriverPassportNumber());
    //    driver.setPassportLink(prmDriver.getPrmDriverPassportLink());
      // driver.setLastName(prmDriver.getPrmDriverLastName());
      //  driver.setFirstName(prmDriver.getPrmDriverFirstName());
      //  driver.setBirthDay(prmDriver.getPrmDriverBirthDay());
       // driver.setCellPhone(prmDriver.getPrmDriverCellPhone());
        if (!lazy) {
            driver.setIncidents(IncidentMapper.toDtos(prmDriver.getPincidents(),true));
         //   driver.setRoads(RoadMapper.toDtos(prmDriver.getProads(),true));
            driver.setBadges(BadgeMapper.toDtos(prmDriver.getPbadges(),true));
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

