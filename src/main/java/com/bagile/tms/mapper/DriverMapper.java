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
        map.put("lastMedicalVisit","tmsDriverLastMedicalVisit");
        map.put("commission", "tmsDriverCommission");
        map.put("creationDate", "tmsDriverCreationDate");
        map.put("upDateDate", "tmsDriverUpdateDate");
        map.put("contact", "tmscontactid");

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
        tmsDriver.setTmsDriverid(driver.getId());
        tmsDriver.setTmsDrivercode(driver.getCode());
        tmsDriver.setTmsDrivercin(driver.getCin());
         tmsDriver.setTmsDriverbirthDate(driver.getBirthDate());
        tmsDriver.setTmsDriverlastMedicalVisit(driver.getLastMedicalVisit());
        tmsDriver.setTmsDrivercommission(driver.getCommission());
        tmsDriver.setTmsDrivercreationDate(driver.getCreationDate());
        tmsDriver.setTmsDriverupDateDate(driver.getUpDateDate());


        if (!lazy) {

            tmsDriver.setTmsContact(com.bagile.tms.mapper.ContactMapper.toEntity(driver.getContact(),true));
           // tmsDriver.setTmsDriverCreationUser(UserMapper.toEntity(driver.getCreationUser(),true));
          //  tmsDriver.setTmsDriverBadges(BadgeMapper.toEntities(driver.getBadges(),true));
          //  tmsDriver.setTmsDriverVacation(VacationMapper.toEntity(driver.getVacation(),true));
          //  tmsDriver.setTmsDriverWorkArea(ZoneMapper.toEntity(driver.getWorkArea(),true));
            //oneToMany(tmsDriver);
        }
        return tmsDriver;
    }
    private static void oneToMany(TmsDriver tmsDriver){
       // if(null!=tmsDriver.getTmsDriverBadges())
      //  {
      //      tmsDriver.getTmsDriverBadges().forEach(tmsBadge -> tmsBadge.setTmsDriver(tmsDriver));
      //  }

    }

    public static Driver toDto(TmsDriver tmsDriver, boolean lazy) {
        if (null == tmsDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId(tmsDriver.getTmsDriverid());
        driver.setCode(tmsDriver.getTmsDrivercode());
        driver.setCin(tmsDriver.getTmsDrivercin());
        driver.setBirthDate(tmsDriver.getTmsDriverbirthDate());
        driver.setLastMedicalVisit(tmsDriver.getTmsDriverlastMedicalVisit());
        driver.setCommission(tmsDriver.getTmsDrivercommission());
        driver.setCreationDate(tmsDriver.getTmsDrivercreationDate());
        driver.setUpDateDate(tmsDriver.getTmsDriverupDateDate());

        if (!lazy) {
            driver.setContact(ContactMapper.toDto(tmsDriver.getTmsContact(),true));
           // driver.setCreationUser(UserMapper.toDto(tmsDriver.getTmsDriverCreationUser(),true));
           // driver.setBadges(BadgeMapper.toDtos(tmsDriver.getTmsDriverBadges(),true));
          // driver.setVacation(VacationMapper.toDto(tmsDriver.getTmsDriverVacation(),true));
          //  driver.setWorkArea(ZoneMapper.toDto(tmsDriver.getTmsDriverWorkArea(),true));
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

