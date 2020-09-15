package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.InsuranceTypeTerms;
import com.bagile.gmo.entities.GmoInsuranceTypeTerms;

import java.util.*;

public class InsuranceTypeTermsMapper {
    public InsuranceTypeTermsMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoInsuranceTypeTermId");
        map.put("insuranceTerm", "gmoInsuranceTerm");
        map.put("insuranceType", "gmoInsuranceType");
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

    public static GmoInsuranceTypeTerms toEntity(InsuranceTypeTerms insuranceTypeTerms, boolean lazy) {
        if (null == insuranceTypeTerms) {
            return null;
        }
        GmoInsuranceTypeTerms gmoinsuranceTermInsurances = new GmoInsuranceTypeTerms();
        gmoinsuranceTermInsurances.setGmoInsuranceTypeTermId(insuranceTypeTerms.getId());
        gmoinsuranceTermInsurances.setGmoAmount(insuranceTypeTerms.getAmount());


        gmoinsuranceTermInsurances.setCreatedBy(insuranceTypeTerms.getCreatedBy());
        gmoinsuranceTermInsurances.setUpdatedBy(insuranceTypeTerms.getUpdatedBy());
        gmoinsuranceTermInsurances.setCreationDate(insuranceTypeTerms.getCreationDate());
        gmoinsuranceTermInsurances.setUpdateDate(insuranceTypeTerms.getUpdateDate());
        if (!lazy) {
            gmoinsuranceTermInsurances.setGmoInsuranceTerm(InsuranceTermMapper.toEntity(insuranceTypeTerms.getInsuranceTerm(), true));
            gmoinsuranceTermInsurances.setGmoInsuranceType(InsuranceTypeMapper.toEntity(insuranceTypeTerms.getInsuranceType(),true));

        }
        return gmoinsuranceTermInsurances;

    }

    public static InsuranceTypeTerms toDto(GmoInsuranceTypeTerms gmoinsuranceTermInsurances, boolean lazy) {
        if (null == gmoinsuranceTermInsurances) {
            return null;
        }
        InsuranceTypeTerms insuranceTypeTerms = new InsuranceTypeTerms();
        insuranceTypeTerms.setId( gmoinsuranceTermInsurances.getGmoInsuranceTypeTermId());
        insuranceTypeTerms.setAmount( gmoinsuranceTermInsurances.getGmoAmount());


        if (!lazy) {
            insuranceTypeTerms.setInsuranceTerm(InsuranceTermMapper.toDto(gmoinsuranceTermInsurances.getGmoInsuranceTerm(), true));
            insuranceTypeTerms.setInsuranceType(InsuranceTypeMapper.toDto(gmoinsuranceTermInsurances.getGmoInsuranceType(), true));
        }

        return insuranceTypeTerms;

    }


    public static List<InsuranceTypeTerms> toDtos(Iterable<? extends GmoInsuranceTypeTerms> gmoInsuranceTypeTerms, boolean lazy) {
        if (null == gmoInsuranceTypeTerms) {
            return null;
        }
        List<InsuranceTypeTerms> insuranceTermInsurances = new ArrayList<>();

        for (GmoInsuranceTypeTerms gmoinsuranceTermInsurances : gmoInsuranceTypeTerms) {
            insuranceTermInsurances.add(toDto(gmoinsuranceTermInsurances, lazy));
        }
        return insuranceTermInsurances;
    }

    public static Set<GmoInsuranceTypeTerms> toEntities(Iterable<? extends InsuranceTypeTerms> insuranceTermInsurances, boolean lazy) {
        if (null == insuranceTermInsurances) {
            return null;
        }
        Set<GmoInsuranceTypeTerms> gmoInsuranceTypeTerms = new HashSet<>();
        for (InsuranceTypeTerms insuranceTypeTerms : insuranceTermInsurances) {
            gmoInsuranceTypeTerms.add(toEntity(insuranceTypeTerms, lazy));
        }
        return gmoInsuranceTypeTerms;
    }



}
