package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Driver;
import com.bagile.gmo.entities.GmoDriver;

import java.util.*;

public class DriverMapper {
    public DriverMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoDriverId");
        map.put("code", "gmoDriverCode");
        map.put("cin", "gmoDriverCin");
        map.put("birthDate", "gmoDriverBirthDate");
        map.put("lastMedicalVisit", "gmoDriverLastMedicalVisit");
      //  map.put("commission", "gmoDriverCommission");
        map.put("contact", "prmContact");
        map.put("working", "gmoWorking");
       map.put("badgeTypeDrivers", "gmoBadgeTypeDrivers");

        map.put("name", "gmoDrivertName");
        map.put("surname", "gmoDriverSurname");
        map.put("tele1", "gmoDriverTele1");
        map.put("fax", "gmoDriverFax");
        map.put("type", "gmoDriverType");
        map.put("email", "gmoDriverEmail");
        map.put("comment", "gmoDriverComment");
        map.put("catre", "gmoCarte");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoDriver toEntity(Driver driver, boolean lazy) {
        if (null == driver) {
            return null;
        }
        GmoDriver gmoDriver = new GmoDriver();
        gmoDriver.setGmoDriverId(driver.getId());
        gmoDriver.setGmoDriverCin(driver.getCin());
        gmoDriver.setGmoDriverCode(driver.getCode() != null ? driver.getCode().toUpperCase() : null);
      // gmoDriver.setGmoDriverCommission(driver.getCommissions());
        gmoDriver.setGmoDriverLastMedicalVisit(driver.getLastMedicalVisit());
        gmoDriver.setGmoDriverBirthDate (driver.getBirthDate());
        gmoDriver.setGmoWorking(driver.isWorking());
       // gmoDriver.setGmoBadgeTypeDrivers(driver.getBadgeTypeDrivers());
        gmoDriver.setGmoDriverName(driver.getName());
        gmoDriver.setGmoDriverSurname(driver.getSurname());
        gmoDriver.setGmoDriverTele1(driver.getTele1());
        gmoDriver.setGmoDriverFax(driver.getFax());
        gmoDriver.setGmoDriverType(driver.getType());
        gmoDriver.setGmoDriverEmail(driver.getEmail());
        gmoDriver.setGmoDriverComment(driver.getComment());
 gmoDriver.setGmoCarte((driver.getCarte()));


        if (!lazy) {
            //gmoDriver.setGmoCommissions(CommissionDriverMapper.toEntities(driver.getCommissions(), false));
            gmoDriver.setGmoBadgeTypeDrivers(BadgeTypeDriverMapper.toEntities(driver.getBadgeTypeDrivers(), false));
            gmoDriver.setOwnOwner(OwnerMapper.toEntity(driver.getOwner(), false));
            gmoDriver.setGmoSubscriptionCard(SubscriptionCardMapper.toEntity(driver.getSubscriptionCard(), false));

            oneToMany(gmoDriver);


        }
        return gmoDriver;

    }

    private static void oneToMany(GmoDriver driver){
        driver.getGmoBadgeTypeDrivers().forEach(
                e->{
                    e.setCreationDate(new Date());
                    e.setGmoDriver(driver);
                }
        );
       /* driver.getGmoCommissions().forEach(
                e->{
                    e.setCreationDate(new Date());
                    e.setGmoDriver(driver);
                }
        );*/

    }

    public static Driver toDto(GmoDriver gmoDriver, boolean lazy) {
        if (null == gmoDriver) {
            return null;
        }
        Driver driver = new Driver();
        driver.setId((int) gmoDriver.getGmoDriverId());
        driver.setCin(gmoDriver.getGmoDriverCin());
        driver.setCode(gmoDriver.getGmoDriverCode() != null ? gmoDriver.getGmoDriverCode().toUpperCase() : null);
        driver.setBirthDate(gmoDriver.getGmoDriverBirthDate ());
        driver.setLastMedicalVisit(gmoDriver.getGmoDriverLastMedicalVisit());
       // driver.setCommission(gmoDriver.getGmoDriverCommission());
        driver.setWorking(gmoDriver.isGmoWorking());
        driver.setCarte((gmoDriver.getGmoCarte()));

        driver.setName(gmoDriver.getGmoDriverName());
        driver.setSurname(gmoDriver.getGmoDriverSurname());
        driver.setTele1(gmoDriver.getGmoDriverTele1());
        driver.setFax(gmoDriver.getGmoDriverFax());
        driver.setType(gmoDriver.getGmoDriverType());
        driver.setEmail(gmoDriver.getGmoDriverEmail());
        driver.setComment(gmoDriver.getGmoDriverComment());

        driver.setCreatedBy(gmoDriver.getCreatedBy());
        driver.setUpdatedBy(gmoDriver.getUpdatedBy());
        driver.setCreationDate(gmoDriver.getCreationDate());
        driver.setUpdateDate(gmoDriver.getUpdateDate());

        if (!lazy) {
         //   driver.setCommissions(CommissionDriverMapper.toDtos(gmoDriver.getGmoCommissions (), false));
            driver.setBadgeTypeDrivers(BadgeTypeDriverMapper.toDtos(gmoDriver.getGmoBadgeTypeDrivers(), false));
            driver.setOwner(OwnerMapper.toDto(gmoDriver.getOwnOwner(), false));
            driver.setSubscriptionCard(SubscriptionCardMapper.toDto(gmoDriver.getGmoSubscriptionCard(), false));
            driver.setSubscriptionCard(SubscriptionCardMapper.toDto(gmoDriver.getGmoSubscriptionCard(), false));

        }
        return driver;

    }


    public static List<Driver> toDtos(Iterable<? extends GmoDriver> gmoDrivers, boolean lazy) {
        if (null == gmoDrivers) {
            return null;
        }
        List<Driver> vehicules = new ArrayList<>();

        for (GmoDriver gmoDriver : gmoDrivers) {
            vehicules.add(toDto(gmoDriver, lazy));
        }
        return vehicules;
    }

    public static Set<GmoDriver> toEntities(Set<Driver> drivers, boolean lazy) {
        if (null == drivers) {
            return null;
        }
        Set<GmoDriver> gmoDrivers = new HashSet<>();
        for (Driver driver : drivers) {
            gmoDrivers.add(toEntity(driver, lazy));
        }
        return gmoDrivers;
    }

    public static Set<Driver> toDtos(Set<GmoDriver> gmoDrivers, boolean lazy) {
        if (null == gmoDrivers) {
            return null;
        }
        Set<Driver> drivers = new HashSet<>();
        for (GmoDriver gmoDriver : gmoDrivers) {
            drivers.add(toDto(gmoDriver, lazy));
        }
        return drivers;
    }
}
