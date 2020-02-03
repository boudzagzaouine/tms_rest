package com.bagile.tms.mapper;

import com.bagile.tms.dto.InsuranceTerm;
import com.bagile.tms.dto.InsuranceTypeTerms;
import com.bagile.tms.dto.VehicleCategory;
import com.bagile.tms.entities.TmsInsuranceTerm;
import com.bagile.tms.entities.TmsInsuranceTypeTerms;
import com.bagile.tms.entities.TmsVehicleCategory;

import java.util.*;

public class InsuranceTypeTermMapper {
    public InsuranceTypeTermMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsInsuranceTypeTermId");
        map.put("insuranceTerm", "tmsInsuranceTerm");
        map.put("insuranceType", "tmsInsuranceType");
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

    public static TmsInsuranceTypeTerms toEntity(InsuranceTypeTerms insuranceTypeTerms, boolean lazy) {
        if (null == insuranceTypeTerms) {
            return null;
        }
        TmsInsuranceTypeTerms tmsinsuranceTermInsurances = new TmsInsuranceTypeTerms();
        tmsinsuranceTermInsurances.setTmsInsuranceTypeTermId(insuranceTypeTerms.getId());
        tmsinsuranceTermInsurances.setTmsAmount(insuranceTypeTerms.getAmount());


        tmsinsuranceTermInsurances.setCreatedBy(insuranceTypeTerms.getCreatedBy());
        tmsinsuranceTermInsurances.setUpdatedBy(insuranceTypeTerms.getUpdatedBy());
        tmsinsuranceTermInsurances.setCreationDate(insuranceTypeTerms.getCreationDate());
        tmsinsuranceTermInsurances.setUpdateDate(insuranceTypeTerms.getUpdateDate());
        if (!lazy) {
            tmsinsuranceTermInsurances.setTmsInsuranceTerm(InsuranceTermMapper.toEntity(insuranceTypeTerms.getInsuranceTerm(), false));
            tmsinsuranceTermInsurances.setTmsInsuranceType(InsuranceTypeMapper.toEntity(insuranceTypeTerms.getInsuranceType(),true));

        }
        return tmsinsuranceTermInsurances;

    }

    public static InsuranceTypeTerms toDto(TmsInsuranceTypeTerms tmsinsuranceTermInsurances, boolean lazy) {
        if (null == tmsinsuranceTermInsurances) {
            return null;
        }
        InsuranceTypeTerms insuranceTypeTerms = new InsuranceTypeTerms();
        insuranceTypeTerms.setId( tmsinsuranceTermInsurances.getTmsInsuranceTypeTermId());
        insuranceTypeTerms.setAmount( tmsinsuranceTermInsurances.getTmsAmount());


        if (!lazy) {
            insuranceTypeTerms.setInsuranceTerm(InsuranceTermMapper.toDto(tmsinsuranceTermInsurances.getTmsInsuranceTerm(), false));
            insuranceTypeTerms.setInsuranceType(InsuranceTypeMapper.toDto(tmsinsuranceTermInsurances.getTmsInsuranceType(), true));
        }

        return insuranceTypeTerms;

    }


    public static List<InsuranceTypeTerms> toDtos(Iterable<? extends TmsInsuranceTypeTerms> tmsInsuranceTypeTerms, boolean lazy) {
        if (null == tmsInsuranceTypeTerms) {
            return null;
        }
        List<InsuranceTypeTerms> insuranceTermInsurances = new ArrayList<>();

        for (TmsInsuranceTypeTerms tmsinsuranceTermInsurances : tmsInsuranceTypeTerms) {
            insuranceTermInsurances.add(toDto(tmsinsuranceTermInsurances, lazy));
        }
        return insuranceTermInsurances;
    }

    public static Set<TmsInsuranceTypeTerms> toEntities(Iterable<? extends InsuranceTypeTerms> insuranceTermInsurances, boolean lazy) {
        if (null == insuranceTermInsurances) {
            return null;
        }
        Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms = new HashSet<>();
        for (InsuranceTypeTerms insuranceTypeTerms : insuranceTermInsurances) {
            tmsInsuranceTypeTerms.add(toEntity(insuranceTypeTerms, lazy));
        }
        return tmsInsuranceTypeTerms;
    }



}
