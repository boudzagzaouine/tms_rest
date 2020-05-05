package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.InsuranceTermLigne;
import com.bagile.gmo.entities.TmsInsuranceTermLigne;

import java.util.*;

public class InsuranceTermLigneMapper {
    public InsuranceTermLigneMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsInsuranceTermInsuranceId");
        map.put("driver", "tmsInsurance");
        map.put("insuranceTermInsurances", "tmsInsuranceTerm");
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

    public static TmsInsuranceTermLigne toEntity(InsuranceTermLigne insuranceTermInsurance, boolean lazy) {
        if (null == insuranceTermInsurance) {
            return null;
        }
        TmsInsuranceTermLigne tmsinsuranceTermInsurances = new TmsInsuranceTermLigne();
        tmsinsuranceTermInsurances.setTmsInsuranceTermLigneId(insuranceTermInsurance.getId());
        tmsinsuranceTermInsurances.setTmsAmount(insuranceTermInsurance.getAmount());


        tmsinsuranceTermInsurances.setCreatedBy(insuranceTermInsurance.getCreatedBy());
        tmsinsuranceTermInsurances.setUpdatedBy(insuranceTermInsurance.getUpdatedBy());
        tmsinsuranceTermInsurances.setCreationDate(insuranceTermInsurance.getCreationDate());
        tmsinsuranceTermInsurances.setUpdateDate(insuranceTermInsurance.getUpdateDate());
        if (!lazy) {
            tmsinsuranceTermInsurances.setTmsInsurance(InsuranceMapper.toEntity(insuranceTermInsurance.getInsurance(), true));
            tmsinsuranceTermInsurances.setTmsInsuranceTerm(InsuranceTermMapper.toEntity(insuranceTermInsurance.getInsuranceTerm(),true));

        }
        return tmsinsuranceTermInsurances;

    }

    public static InsuranceTermLigne toDto(TmsInsuranceTermLigne tmsinsuranceTermInsurances, boolean lazy) {
        if (null == tmsinsuranceTermInsurances) {
            return null;
        }
        InsuranceTermLigne insuranceTermInsurance = new InsuranceTermLigne();
        insuranceTermInsurance.setId((int) tmsinsuranceTermInsurances.getTmsInsuranceTermLigneId());
        insuranceTermInsurance.setAmount( tmsinsuranceTermInsurances.getTmsAmount());


        if (!lazy) {
            insuranceTermInsurance.setInsurance(InsuranceMapper.toDto(tmsinsuranceTermInsurances.getTmsInsurance(), true));
            insuranceTermInsurance.setInsuranceTerm(InsuranceTermMapper.toDto(tmsinsuranceTermInsurances.getTmsInsuranceTerm(), true));
        }

        return insuranceTermInsurance;

    }


    public static List<InsuranceTermLigne> toDtos(Iterable<? extends TmsInsuranceTermLigne> tmsInsuranceTermLignes, boolean lazy) {
        if (null == tmsInsuranceTermLignes) {
            return null;
        }
        List<InsuranceTermLigne> insuranceTermInsurances = new ArrayList<>();

        for (TmsInsuranceTermLigne tmsinsuranceTermInsurances : tmsInsuranceTermLignes) {
            insuranceTermInsurances.add(toDto(tmsinsuranceTermInsurances, lazy));
        }
        return insuranceTermInsurances;
    }

    public static Set<TmsInsuranceTermLigne> toEntities(Iterable<? extends InsuranceTermLigne> insuranceTermInsurances, boolean lazy) {
        if (null == insuranceTermInsurances) {
            return null;
        }
        Set<TmsInsuranceTermLigne> tmsInsuranceTermLignes = new HashSet<>();
        for (InsuranceTermLigne insuranceTermInsurance : insuranceTermInsurances) {
            tmsInsuranceTermLignes.add(toEntity(insuranceTermInsurance, lazy));
        }
        return tmsInsuranceTermLignes;
    }

}
