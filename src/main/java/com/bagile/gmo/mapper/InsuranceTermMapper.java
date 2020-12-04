package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.InsuranceTerm;
import com.bagile.gmo.entities.GmoInsuranceTerm;

import java.util.*;

public class InsuranceTermMapper {
    public InsuranceTermMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoInsuranceTermId");
        map.put("code", "gmoInsuranceTermCode");
        map.put("description", "gmoInsuranceTermDescription");
        map.put("roofed", "gmoInsuranceTermRoofed");

        map.put("insuranceTypeTermsSet", "gmoInsuranceTypeTerms");

        map.put("insuranceTermVehicles", "gmoInsuranceTermsVehicules");


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

    public static GmoInsuranceTerm toEntity(InsuranceTerm insuranceTerm, boolean lazy) {
        if (null == insuranceTerm) {
            return null;
        }
        GmoInsuranceTerm gmoInsuranceTerm = new GmoInsuranceTerm();
        gmoInsuranceTerm.setGmoInsuranceTermId(insuranceTerm.getId());
        gmoInsuranceTerm.setGmoInsuranceTermCode(insuranceTerm.getCode() != null ? insuranceTerm.getCode().toUpperCase() : null);
        gmoInsuranceTerm.setGmoInsuranceTermDescription (insuranceTerm.getDescription ());
        gmoInsuranceTerm.setGmoInsuranceTermRoofed(insuranceTerm.isRoofed());


        gmoInsuranceTerm.setCreatedBy(insuranceTerm.getCreatedBy());
        gmoInsuranceTerm.setUpdatedBy(insuranceTerm.getUpdatedBy());
        gmoInsuranceTerm.setCreationDate(insuranceTerm.getCreationDate());
        gmoInsuranceTerm.setUpdateDate(insuranceTerm.getUpdateDate());

        if(!lazy) {
            // gmoInsurance.setGmoInsuranceTermLigne (InsuranceTermLigneMapper.toEntities(insurance.getInsuranceTermLignes(),false));
            gmoInsuranceTerm.setGmoInsuranceTermsVehicules (InsuranceTermsVehicleMapper.toEntities(insuranceTerm.getInsuranceTermVehicles (),false));
   gmoInsuranceTerm.setOwnOwner(OwnerMapper.toEntity(insuranceTerm.getOwner(),true));
            // oneToMany(gmoInsurance);
        }
        return gmoInsuranceTerm;

    }

    public static InsuranceTerm toDto(GmoInsuranceTerm gmoInsuranceTerm, boolean lazy) {
        if (null == gmoInsuranceTerm) {
            return null;
        }
        InsuranceTerm insuranceTerm = new InsuranceTerm();
        insuranceTerm.setId(gmoInsuranceTerm.getGmoInsuranceTermId());
        insuranceTerm.setCode(gmoInsuranceTerm.getGmoInsuranceTermCode());
        insuranceTerm.setDescription (gmoInsuranceTerm.getGmoInsuranceTermDescription ());
        insuranceTerm.setRoofed(gmoInsuranceTerm.isGmoInsuranceTermRoofed());

        insuranceTerm.setCreatedBy(gmoInsuranceTerm.getCreatedBy());
        insuranceTerm.setUpdatedBy(gmoInsuranceTerm.getUpdatedBy());
        insuranceTerm.setCreationDate(gmoInsuranceTerm.getCreationDate());
        insuranceTerm.setUpdateDate(gmoInsuranceTerm.getUpdateDate());

        if(!lazy) {
        insuranceTerm.setOwner(OwnerMapper.toDto(gmoInsuranceTerm.getOwnOwner(),true));
          //  insuranceTerm..setInsuranceTermLignes (InsuranceTermLigneMapper.toDtos(gmoInsurance.getGmoInsuranceTermLigne (),false));
            insuranceTerm.setInsuranceTermVehicles (InsuranceTermsVehicleMapper.toDtos(gmoInsuranceTerm.getGmoInsuranceTermsVehicules (), true));
        }
        return insuranceTerm;


    }


    public static List<InsuranceTerm> toDtos(Iterable<? extends GmoInsuranceTerm> gmoInsuranceTerms, boolean lazy) {
        if (null == gmoInsuranceTerms) {
            return null;
        }
        List<InsuranceTerm> vehicules = new ArrayList<>();

        for (GmoInsuranceTerm gmoInsuranceTerm : gmoInsuranceTerms) {
            vehicules.add(toDto(gmoInsuranceTerm, lazy));
        }
        return vehicules;
    }

    public static Set<GmoInsuranceTerm> toEntities(Iterable<? extends InsuranceTerm> insuranceTerms, boolean lazy) {
        if (null == insuranceTerms) {
            return null;
        }
        Set<GmoInsuranceTerm> gmoInsuranceTerms = new HashSet<>();
        for (InsuranceTerm insuranceTerm : insuranceTerms) {
            gmoInsuranceTerms.add(toEntity(insuranceTerm, lazy));
        }
        return gmoInsuranceTerms;
    }


}
