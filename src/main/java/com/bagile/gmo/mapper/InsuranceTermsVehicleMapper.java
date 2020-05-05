package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.InsuranceTermsVehicle;
import com.bagile.gmo.entities.GmoInsuranceTermsVehicule;

public class InsuranceTermsVehicleMapper {
    public InsuranceTermsVehicleMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoInsuranceTermVehicleId");
        map.put("vehicle", "gmoVehicle");
        map.put("insuranceTerm", "gmoInsuranceTerm");
        map.put("amount", "gmoAmount");
     

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

    public static GmoInsuranceTermsVehicule toEntity(InsuranceTermsVehicle insuranceTermsVehicle, boolean lazy) {
        if (null == insuranceTermsVehicle) {
            return null;
        }
        GmoInsuranceTermsVehicule gmoInsuranceTermsVehicule = new GmoInsuranceTermsVehicule();
        gmoInsuranceTermsVehicule.setGmoInsuranceTermVehicleId(insuranceTermsVehicle.getId());
        gmoInsuranceTermsVehicule.setGmoAmount(insuranceTermsVehicle.getAmount());
      


        gmoInsuranceTermsVehicule.setCreatedBy(insuranceTermsVehicle.getCreatedBy());
        gmoInsuranceTermsVehicule.setUpdatedBy(insuranceTermsVehicle.getUpdatedBy());
        gmoInsuranceTermsVehicule.setCreationDate(insuranceTermsVehicle.getCreationDate());
        gmoInsuranceTermsVehicule.setUpdateDate(insuranceTermsVehicle.getUpdateDate());
        if (!lazy) {
            gmoInsuranceTermsVehicule.setGmoInsuranceTerm(InsuranceTermMapper.toEntity(insuranceTermsVehicle.getInsuranceTerm(), true));
            gmoInsuranceTermsVehicule.setGmoVehicle(VehicleMapper.toEntity(insuranceTermsVehicle.getVehicle(),true));

        }
        return gmoInsuranceTermsVehicule;

    }

    public static InsuranceTermsVehicle toDto(GmoInsuranceTermsVehicule gmoInsuranceTermsVehicule, boolean lazy) {
        if (null == gmoInsuranceTermsVehicule) {
            return null;
        }
        InsuranceTermsVehicle insuranceTermsVehicle = new InsuranceTermsVehicle();
        insuranceTermsVehicle.setId( gmoInsuranceTermsVehicule.getGmoInsuranceTermVehicleId());
        insuranceTermsVehicle.setAmount( gmoInsuranceTermsVehicule.getGmoAmount());
       


        if (!lazy) {
            insuranceTermsVehicle.setInsuranceTerm(InsuranceTermMapper.toDto(gmoInsuranceTermsVehicule.getGmoInsuranceTerm(), true));
            insuranceTermsVehicle.setVehicle(VehicleMapper.toDto(gmoInsuranceTermsVehicule.getGmoVehicle(),true));
        }

        return insuranceTermsVehicle;

    }


    public static List<InsuranceTermsVehicle> toDtos(Iterable<? extends GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules, boolean lazy) {
        if (null == gmoInsuranceTermsVehicules) {
            return null;
        }
        List<InsuranceTermsVehicle> insuranceTermsVehicule = new ArrayList<>();

        for (GmoInsuranceTermsVehicule gmoInsuranceTermsVehicule : gmoInsuranceTermsVehicules) {
            insuranceTermsVehicule.add(toDto(gmoInsuranceTermsVehicule, lazy));
        }
        return insuranceTermsVehicule;
    }

    public static Set<GmoInsuranceTermsVehicule> toEntities(Iterable<? extends  InsuranceTermsVehicle> badgeTypeDriverType, boolean lazy) {
        if (null == badgeTypeDriverType) {
            return null;
        }
        Set<GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules = new HashSet<>();
        for (InsuranceTermsVehicle insuranceTermsVehicle : badgeTypeDriverType) {
            gmoInsuranceTermsVehicules.add(toEntity(insuranceTermsVehicle, lazy));
        }
        return gmoInsuranceTermsVehicules;
    }

    /*public static Set<InsuranceTermsVehicle> toDtos(Set<GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules, boolean lazy) {
        if (null == gmoInsuranceTermsVehicules) {
            return null;
        }
        Set<InsuranceTermsVehicle> badgeTypeDriverType = new HashSet<>();
        for (GmoInsuranceTermsVehicule gmoInsuranceTermsVehicule : gmoInsuranceTermsVehicules) {
            badgeTypeDriverType.add(toDto(gmoInsuranceTermsVehicule, lazy));
        }
        return badgeTypeDriverType;
    }*/
}
