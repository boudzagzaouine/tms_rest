package com.bagile.tms.mapper;

import com.bagile.tms.dto.InsuranceTerm;
import com.bagile.tms.dto.InsuranceTypeTerms;
import com.bagile.tms.entities.TmsInsuranceTerm;

import java.util.*;

public class InsuranceTermMapper {
    public InsuranceTermMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsInsuranceTermId");
        map.put("code", "tmsInsuranceTermCode");
        map.put("description", "tmsInsuranceTermDescription");
        map.put("isValue", "tmsInsuranceTermIsValue");

        map.put("insuranceTypeTermsSet", "tmsInsuranceTypeTerms");


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

    public static TmsInsuranceTerm toEntity(InsuranceTerm insuranceTerm, boolean lazy) {
        if (null == insuranceTerm) {
            return null;
        }
        TmsInsuranceTerm tmsInsuranceTerm = new TmsInsuranceTerm();
        tmsInsuranceTerm.setTmsInsuranceTermId(insuranceTerm.getId());
        tmsInsuranceTerm.setTmsInsuranceTermCode(insuranceTerm.getCode() != null ? insuranceTerm.getCode().toUpperCase() : null);
        tmsInsuranceTerm.setTmsInsuranceTermDescription (insuranceTerm.getDescription ());
        tmsInsuranceTerm.setTmsInsuranceTermRoofed(insuranceTerm.isRoofed());


        tmsInsuranceTerm.setCreatedBy(insuranceTerm.getCreatedBy());
        tmsInsuranceTerm.setUpdatedBy(insuranceTerm.getUpdatedBy());
        tmsInsuranceTerm.setCreationDate(insuranceTerm.getCreationDate());
        tmsInsuranceTerm.setUpdateDate(insuranceTerm.getUpdateDate());


        return tmsInsuranceTerm;

    }

    public static InsuranceTerm toDto(TmsInsuranceTerm tmsInsuranceTerm, boolean lazy) {
        if (null == tmsInsuranceTerm) {
            return null;
        }
        InsuranceTerm insuranceTerm = new InsuranceTerm();
        insuranceTerm.setId(tmsInsuranceTerm.getTmsInsuranceTermId());
        insuranceTerm.setCode(tmsInsuranceTerm.getTmsInsuranceTermCode());
        insuranceTerm.setDescription (tmsInsuranceTerm.getTmsInsuranceTermDescription ());
        insuranceTerm.setRoofed(tmsInsuranceTerm.isTmsInsuranceTermRoofed());

        insuranceTerm.setCreatedBy(tmsInsuranceTerm.getCreatedBy());
        insuranceTerm.setUpdatedBy(tmsInsuranceTerm.getUpdatedBy());
        insuranceTerm.setCreationDate(tmsInsuranceTerm.getCreationDate());
        insuranceTerm.setUpdateDate(tmsInsuranceTerm.getUpdateDate());


        return insuranceTerm;

    }


    public static List<InsuranceTerm> toDtos(Iterable<? extends TmsInsuranceTerm> tmsInsuranceTerms, boolean lazy) {
        if (null == tmsInsuranceTerms) {
            return null;
        }
        List<InsuranceTerm> vehicules = new ArrayList<>();

        for (TmsInsuranceTerm tmsInsuranceTerm : tmsInsuranceTerms) {
            vehicules.add(toDto(tmsInsuranceTerm, lazy));
        }
        return vehicules;
    }

    public static Set<TmsInsuranceTerm> toEntities(Iterable<? extends InsuranceTerm> insuranceTerms, boolean lazy) {
        if (null == insuranceTerms) {
            return null;
        }
        Set<TmsInsuranceTerm> tmsInsuranceTerms = new HashSet<>();
        for (InsuranceTerm insuranceTerm : insuranceTerms) {
            tmsInsuranceTerms.add(toEntity(insuranceTerm, lazy));
        }
        return tmsInsuranceTerms;
    }

    public static Set<InsuranceTerm> toDtos(Set<TmsInsuranceTerm> tmsInsuranceTerms, boolean lazy) {
        if (null == tmsInsuranceTerms) {
            return null;
        }
        Set<InsuranceTerm> insuranceTerms = new HashSet<>();
        for (TmsInsuranceTerm tmsInsuranceTerm : tmsInsuranceTerms) {
            insuranceTerms.add(toDto(tmsInsuranceTerm, lazy));
        }
        return insuranceTerms;
    }
}
