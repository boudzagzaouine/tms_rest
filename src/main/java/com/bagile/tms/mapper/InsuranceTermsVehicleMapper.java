package com.bagile.tms.mapper;

import com.bagile.tms.dto.InsuranceTermsVehicle;
import com.bagile.tms.entities.TmsInsuranceTermsVehicule;

import java.util.*;

public class InsuranceTermsVehicleMapper {
    public InsuranceTermsVehicleMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsInsuranceTermVehicleId");
        map.put("vehicle", "tmsVehicle");
        map.put("insuranceTerm", "tmsInsuranceTerm");
        map.put("amount", "tmsAmount");
     

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

    public static TmsInsuranceTermsVehicule toEntity(InsuranceTermsVehicle insuranceTermsVehicle, boolean lazy) {
        if (null == insuranceTermsVehicle) {
            return null;
        }
        TmsInsuranceTermsVehicule tmsInsuranceTermsVehicule = new TmsInsuranceTermsVehicule();
        tmsInsuranceTermsVehicule.setTmsInsuranceTermVehicleId(insuranceTermsVehicle.getId());
        tmsInsuranceTermsVehicule.setTmsAmount(insuranceTermsVehicle.getAmount());
      


        tmsInsuranceTermsVehicule.setCreatedBy(insuranceTermsVehicle.getCreatedBy());
        tmsInsuranceTermsVehicule.setUpdatedBy(insuranceTermsVehicle.getUpdatedBy());
        tmsInsuranceTermsVehicule.setCreationDate(insuranceTermsVehicle.getCreationDate());
        tmsInsuranceTermsVehicule.setUpdateDate(insuranceTermsVehicle.getUpdateDate());
        if (!lazy) {
            tmsInsuranceTermsVehicule.setTmsInsuranceTerm(InsuranceTermMapper.toEntity(insuranceTermsVehicle.getInsuranceTerm(), true));
            tmsInsuranceTermsVehicule.setTmsVehicle(VehicleMapper.toEntity(insuranceTermsVehicle.getVehicle(),true));

        }
        return tmsInsuranceTermsVehicule;

    }

    public static InsuranceTermsVehicle toDto(TmsInsuranceTermsVehicule tmsInsuranceTermsVehicule, boolean lazy) {
        if (null == tmsInsuranceTermsVehicule) {
            return null;
        }
        InsuranceTermsVehicle insuranceTermsVehicle = new InsuranceTermsVehicle();
        insuranceTermsVehicle.setId( tmsInsuranceTermsVehicule.getTmsInsuranceTermVehicleId());
        insuranceTermsVehicle.setAmount( tmsInsuranceTermsVehicule.getTmsAmount());
       


        if (!lazy) {
            insuranceTermsVehicle.setInsuranceTerm(InsuranceTermMapper.toDto(tmsInsuranceTermsVehicule.getTmsInsuranceTerm(), true));
            insuranceTermsVehicle.setVehicle(VehicleMapper.toDto(tmsInsuranceTermsVehicule.getTmsVehicle(),true));
        }

        return insuranceTermsVehicle;

    }


    public static List<InsuranceTermsVehicle> toDtos(Iterable<? extends TmsInsuranceTermsVehicule> tmsInsuranceTermsVehicules, boolean lazy) {
        if (null == tmsInsuranceTermsVehicules) {
            return null;
        }
        List<InsuranceTermsVehicle> insuranceTermsVehicule = new ArrayList<>();

        for (TmsInsuranceTermsVehicule tmsInsuranceTermsVehicule : tmsInsuranceTermsVehicules) {
            insuranceTermsVehicule.add(toDto(tmsInsuranceTermsVehicule, lazy));
        }
        return insuranceTermsVehicule;
    }

    public static Set<TmsInsuranceTermsVehicule> toEntities(Iterable<? extends  InsuranceTermsVehicle> badgeTypeDriverType, boolean lazy) {
        if (null == badgeTypeDriverType) {
            return null;
        }
        Set<TmsInsuranceTermsVehicule> tmsInsuranceTermsVehicules = new HashSet<>();
        for (InsuranceTermsVehicle insuranceTermsVehicle : badgeTypeDriverType) {
            tmsInsuranceTermsVehicules.add(toEntity(insuranceTermsVehicle, lazy));
        }
        return tmsInsuranceTermsVehicules;
    }

    /*public static Set<InsuranceTermsVehicle> toDtos(Set<TmsInsuranceTermsVehicule> tmsInsuranceTermsVehicules, boolean lazy) {
        if (null == tmsInsuranceTermsVehicules) {
            return null;
        }
        Set<InsuranceTermsVehicle> badgeTypeDriverType = new HashSet<>();
        for (TmsInsuranceTermsVehicule tmsInsuranceTermsVehicule : tmsInsuranceTermsVehicules) {
            badgeTypeDriverType.add(toDto(tmsInsuranceTermsVehicule, lazy));
        }
        return badgeTypeDriverType;
    }*/
}
