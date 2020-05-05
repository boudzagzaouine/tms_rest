package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.InsuranceTermLigne;
import com.bagile.gmo.entities.GmoInsuranceTermLigne;

import java.util.*;

public class InsuranceTermLigneMapper {
    public InsuranceTermLigneMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoInsuranceTermInsuranceId");
        map.put("driver", "gmoInsurance");
        map.put("insuranceTermInsurances", "gmoInsuranceTerm");
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

    public static GmoInsuranceTermLigne toEntity(InsuranceTermLigne insuranceTermInsurance, boolean lazy) {
        if (null == insuranceTermInsurance) {
            return null;
        }
        GmoInsuranceTermLigne gmoinsuranceTermInsurances = new GmoInsuranceTermLigne();
        gmoinsuranceTermInsurances.setGmoInsuranceTermLigneId(insuranceTermInsurance.getId());
        gmoinsuranceTermInsurances.setGmoAmount(insuranceTermInsurance.getAmount());


        gmoinsuranceTermInsurances.setCreatedBy(insuranceTermInsurance.getCreatedBy());
        gmoinsuranceTermInsurances.setUpdatedBy(insuranceTermInsurance.getUpdatedBy());
        gmoinsuranceTermInsurances.setCreationDate(insuranceTermInsurance.getCreationDate());
        gmoinsuranceTermInsurances.setUpdateDate(insuranceTermInsurance.getUpdateDate());
        if (!lazy) {
            gmoinsuranceTermInsurances.setGmoInsurance(InsuranceMapper.toEntity(insuranceTermInsurance.getInsurance(), true));
            gmoinsuranceTermInsurances.setGmoInsuranceTerm(InsuranceTermMapper.toEntity(insuranceTermInsurance.getInsuranceTerm(),true));

        }
        return gmoinsuranceTermInsurances;

    }

    public static InsuranceTermLigne toDto(GmoInsuranceTermLigne gmoinsuranceTermInsurances, boolean lazy) {
        if (null == gmoinsuranceTermInsurances) {
            return null;
        }
        InsuranceTermLigne insuranceTermInsurance = new InsuranceTermLigne();
        insuranceTermInsurance.setId((int) gmoinsuranceTermInsurances.getGmoInsuranceTermLigneId());
        insuranceTermInsurance.setAmount( gmoinsuranceTermInsurances.getGmoAmount());


        if (!lazy) {
            insuranceTermInsurance.setInsurance(InsuranceMapper.toDto(gmoinsuranceTermInsurances.getGmoInsurance(), true));
            insuranceTermInsurance.setInsuranceTerm(InsuranceTermMapper.toDto(gmoinsuranceTermInsurances.getGmoInsuranceTerm(), true));
        }

        return insuranceTermInsurance;

    }


    public static List<InsuranceTermLigne> toDtos(Iterable<? extends GmoInsuranceTermLigne> gmoInsuranceTermLignes, boolean lazy) {
        if (null == gmoInsuranceTermLignes) {
            return null;
        }
        List<InsuranceTermLigne> insuranceTermInsurances = new ArrayList<>();

        for (GmoInsuranceTermLigne gmoinsuranceTermInsurances : gmoInsuranceTermLignes) {
            insuranceTermInsurances.add(toDto(gmoinsuranceTermInsurances, lazy));
        }
        return insuranceTermInsurances;
    }

    public static Set<GmoInsuranceTermLigne> toEntities(Iterable<? extends InsuranceTermLigne> insuranceTermInsurances, boolean lazy) {
        if (null == insuranceTermInsurances) {
            return null;
        }
        Set<GmoInsuranceTermLigne> gmoInsuranceTermLignes = new HashSet<>();
        for (InsuranceTermLigne insuranceTermInsurance : insuranceTermInsurances) {
            gmoInsuranceTermLignes.add(toEntity(insuranceTermInsurance, lazy));
        }
        return gmoInsuranceTermLignes;
    }

}
