package com.bagile.tms.mapper;

import com.bagile.tms.dto.InsuranceType;
import com.bagile.tms.entities.TmsInsurance;
import com.bagile.tms.entities.TmsInsuranceType;

import java.util.*;

public class InsuranceTypeMapper {
    public InsuranceTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsInsuranceTypeId");
        map.put("code", "tmsInsuranceTypeCode");
        map.put("description", "tmsInsuranceTypeDescription");
       map.put("insuranceTypeTermsSet", "tmsInsuranceTypeTerms");

        //map.put("vehicleCategories", "tmsVehicleCategories");


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

    public static TmsInsuranceType toEntity(InsuranceType insuranceType, boolean lazy) {
        if (null == insuranceType) {
            return null;
        }
        TmsInsuranceType tmsInsuranceType = new TmsInsuranceType();
        tmsInsuranceType.setTmsInsuranceTypeId(insuranceType.getId());
        tmsInsuranceType.setTmsInsuranceTypeCode(insuranceType.getCode());
        tmsInsuranceType.setTmsInsuranceTypeDescription (insuranceType.getDescription ());



        tmsInsuranceType.setCreatedBy(insuranceType.getCreatedBy());
        tmsInsuranceType.setUpdatedBy(insuranceType.getUpdatedBy());
        tmsInsuranceType.setCreationDate(insuranceType.getCreationDate());
        tmsInsuranceType.setUpdateDate(insuranceType.getUpdateDate());

        if(!lazy) {
       tmsInsuranceType.setTmsInsuranceTypeTerms (InsuranceTypeTermMapper.toEntities(insuranceType.getInsuranceTypeTermsSet(),false));
       //     oneToMany(tmsInsuranceType);
        }
        return tmsInsuranceType;
    }

    public static InsuranceType toDto(TmsInsuranceType tmsInsuranceType, boolean lazy) {
        if (null == tmsInsuranceType) {
            return null;
        }
        InsuranceType insuranceType = new InsuranceType();
        insuranceType.setId((int) tmsInsuranceType.getTmsInsuranceTypeId());
        insuranceType.setCode(tmsInsuranceType.getTmsInsuranceTypeCode());
        insuranceType.setDescription (tmsInsuranceType.getTmsInsuranceTypeDescription ());


        insuranceType.setCreatedBy(tmsInsuranceType.getCreatedBy());
        insuranceType.setUpdatedBy(tmsInsuranceType.getUpdatedBy());
        insuranceType.setCreationDate(tmsInsuranceType.getCreationDate());
        insuranceType.setUpdateDate(tmsInsuranceType.getUpdateDate());

        if(!lazy) {

       //   insuranceType.setInsurances (InsuranceMapper.toDtos(tmsInsuranceType.getTmsInsurances (),false));
        insuranceType.setInsuranceTypeTermsSet (InsuranceTypeTermMapper.toDtos(tmsInsuranceType.getTmsInsuranceTypeTerms (),false));

        }
        return insuranceType;
    }

   /* private static void oneToMany(TmsInsuranceType insuranceType) {
        insuranceType.getTmsInsuranceTypeTerms().forEach(
                e -> {
                    e.setCreationDate(new Date());
                    e.setTmsInsuranceType(insuranceType);
                }
        );
    }*/

    public static List<InsuranceType> toDtos(Iterable<? extends TmsInsuranceType> tmsInsurances, boolean lazy) {
        if (null == tmsInsurances) {
            return null;
        }
        List<InsuranceType> vehicules = new ArrayList<>();

        for (TmsInsuranceType tmsInsuranceType : tmsInsurances) {
            vehicules.add(toDto(tmsInsuranceType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsInsuranceType> toEntities(Iterable<? extends InsuranceType> insurances, boolean lazy) {
        if (null == insurances) {
            return null;
        }
        Set<TmsInsuranceType> tmsInsurances = new HashSet<>();
        for (InsuranceType insuranceType : insurances) {
            tmsInsurances.add(toEntity(insuranceType, lazy));
        }
        return tmsInsurances;
    }

    public static Set<InsuranceType> toDtos(Set<TmsInsuranceType> tmsInsurances, boolean lazy) {
        if (null == tmsInsurances) {
            return null;
        }
        Set<InsuranceType> insurances = new HashSet<>();
        for (TmsInsuranceType tmsInsuranceType : tmsInsurances) {
            insurances.add(toDto(tmsInsuranceType, lazy));
        }
        return insurances;
    }
}
