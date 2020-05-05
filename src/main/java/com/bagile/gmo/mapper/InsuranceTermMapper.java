package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.InsuranceTerm;
import com.bagile.gmo.entities.TmsInsuranceTerm;

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

        map.put("insuranceTermVehicles", "tmsInsuranceTermsVehicules");


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
        TmsInsuranceTerm gmoInsuranceTerm = new TmsInsuranceTerm();
        gmoInsuranceTerm.setGmoInsuranceTermId(insuranceTerm.getId());
        gmoInsuranceTerm.setGmoInsuranceTermCode(insuranceTerm.getCode() != null ? insuranceTerm.getCode().toUpperCase() : null);
        gmoInsuranceTerm.setGmoInsuranceTermDescription (insuranceTerm.getDescription ());
        gmoInsuranceTerm.setGmoInsuranceTermRoofed(insuranceTerm.isRoofed());


        gmoInsuranceTerm.setCreatedBy(insuranceTerm.getCreatedBy());
        gmoInsuranceTerm.setUpdatedBy(insuranceTerm.getUpdatedBy());
        gmoInsuranceTerm.setCreationDate(insuranceTerm.getCreationDate());
        gmoInsuranceTerm.setUpdateDate(insuranceTerm.getUpdateDate());

        if(!lazy) {
            // tmsInsurance.setTmsInsuranceTermLigne (InsuranceTermLigneMapper.toEntities(insurance.getInsuranceTermLignes(),false));
            gmoInsuranceTerm.setTmsInsuranceTermsVehicules (InsuranceTermsVehicleMapper.toEntities(insuranceTerm.getInsuranceTermVehicles (),false));

            // oneToMany(tmsInsurance);
        }
        return gmoInsuranceTerm;

    }

    public static InsuranceTerm toDto(TmsInsuranceTerm tmsInsuranceTerm, boolean lazy) {
        if (null == tmsInsuranceTerm) {
            return null;
        }
        InsuranceTerm insuranceTerm = new InsuranceTerm();
        insuranceTerm.setId(tmsInsuranceTerm.getGmoInsuranceTermId());
        insuranceTerm.setCode(tmsInsuranceTerm.getGmoInsuranceTermCode());
        insuranceTerm.setDescription (tmsInsuranceTerm.getGmoInsuranceTermDescription ());
        insuranceTerm.setRoofed(tmsInsuranceTerm.isGmoInsuranceTermRoofed());

        insuranceTerm.setCreatedBy(tmsInsuranceTerm.getCreatedBy());
        insuranceTerm.setUpdatedBy(tmsInsuranceTerm.getUpdatedBy());
        insuranceTerm.setCreationDate(tmsInsuranceTerm.getCreationDate());
        insuranceTerm.setUpdateDate(tmsInsuranceTerm.getUpdateDate());

        if(!lazy) {

          //  insuranceTerm..setInsuranceTermLignes (InsuranceTermLigneMapper.toDtos(tmsInsurance.getTmsInsuranceTermLigne (),false));
            insuranceTerm.setInsuranceTermVehicles (InsuranceTermsVehicleMapper.toDtos(tmsInsuranceTerm.getTmsInsuranceTermsVehicules (), true));
        }
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


}
