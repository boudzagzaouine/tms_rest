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
        map.put("birthDate", "tmsDriverbirthDate");
        map.put("lastMedicalVisit","tmsDriverLastMedicalVisit");
        map.put("commission", "tmsDriverCommission");
        map.put("contact", "prmContact");
        map.put("working", "tmsWorking");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");

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
        tmsDriver.setTmsDriverCode(driver.getCode());
        tmsDriver.setTmsDriverCin(driver.getCin());
         tmsDriver.setTmsDriverbirthDate(driver.getBirthDate());
        tmsDriver.setTmsDriverLastMedicalVisit(driver.getLastMedicalVisit());
        tmsDriver.setTmsDriverCommission(driver.getCommission());
        tmsDriver.setTmsWorking(driver.isWorking());

        tmsDriver.setCreatedBy(driver.getCreatedBy());
        tmsDriver.setUpdatedBy(driver.getUpdatedBy());
        tmsDriver.setCreationDate(driver.getCreationDate());
        tmsDriver.setUpdateDate(driver.getUpdateDate());

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
        driver.setId(tmsDriver.getTmsDriverId());
        driver.setCode(tmsDriver.getTmsDriverCode());
        driver.setCin(tmsDriver.getTmsDriverCin());
        driver.setBirthDate(tmsDriver.getTmsDriverbirthDate());
        driver.setLastMedicalVisit(tmsDriver.getTmsDriverLastMedicalVisit());
        driver.setCommission(tmsDriver.getTmsDriverCommission());
        driver.setWorking(tmsDriver.isTmsWorking());

        driver.setCreatedBy(tmsDriver.getCreatedBy());
        driver.setUpdatedBy(tmsDriver.getUpdatedBy());
        driver.setCreationDate(tmsDriver.getCreationDate());
        driver.setUpdateDate(tmsDriver.getUpdateDate());

        if (!lazy) {
            driver.setContact(ContactMapper.toDto(tmsDriver.getprmContact(),true));
           // driver.setCreationUser(UserMapper.toDto(tmsDriver.getTmsDriverCreationUser(),true));
           // driver.setBadges(BadgeMapper.toDtos(tmsDriver.getTmsDriverBadges(),true));
          // driver.setVacation(VacationMapper.toDto(tmsDriver.getTmsDriverVacation(),true));
          //  driver.setWorkArea(ZoneMapper.toDto(tmsDriver.getTmsDriverWorkArea(),true));
        }
        return driver;
    }



    public static List<Driver> toDtos(Iterable<? extends TmsDriver> tmsDrivers, boolean lazy) {
        if (null == tmsDrivers) {
            return null;
        }
        List<Driver> drivers = new ArrayList<>();
        for (TmsDriver tmsDriver : tmsDrivers) {
            drivers.add(toDto(tmsDriver, lazy));
        }
        return drivers;
    }
    public static Set<TmsDriver> toEntities(Set<? extends Driver>drivers, boolean lazy){
        if (null == drivers) {
            return null;
        }
        Set<TmsDriver> tmsDrivers = new HashSet<>();
        for(Driver driver:drivers){
            tmsDrivers.add(toEntity(driver,lazy));
        }
        return tmsDrivers;
    }
    public static Set<Driver> toDtos(Set<? extends TmsDriver> tmsDrivers, boolean lazy){
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

