package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.InsuranceType;
import com.bagile.gmo.entities.GmoInsuranceType;

import java.util.*;

public class InsuranceTypeMapper {
    public InsuranceTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoInsuranceTypeId");
        map.put("code", "gmoInsuranceTypeCode");
        map.put("description", "gmoInsuranceTypeDescription");
       map.put("insuranceTypeTermsSet", "gmoInsuranceTypeTerms");

        //map.put("vehicleCategories", "gmoVehicleCategories");


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

    public static GmoInsuranceType toEntity(InsuranceType insuranceType, boolean lazy) {
        if (null == insuranceType) {
            return null;
        }
        GmoInsuranceType gmoInsuranceType = new GmoInsuranceType();
        gmoInsuranceType.setGmoInsuranceTypeId(insuranceType.getId());
        gmoInsuranceType.setGmoInsuranceTypeCode(insuranceType.getCode());
        gmoInsuranceType.setGmoInsuranceTypeDescription (insuranceType.getDescription ());



        gmoInsuranceType.setCreatedBy(insuranceType.getCreatedBy());
        gmoInsuranceType.setUpdatedBy(insuranceType.getUpdatedBy());
        gmoInsuranceType.setCreationDate(insuranceType.getCreationDate());
        gmoInsuranceType.setUpdateDate(insuranceType.getUpdateDate());

        if(!lazy) {
            gmoInsuranceType.setOwnOwner(OwnerMapper.toEntity(insuranceType.getOwner(),true));
       gmoInsuranceType.setGmoInsuranceTypeTerms (InsuranceTypeTermsMapper.toEntities(insuranceType.getInsuranceTypeTermsSet(),false));
       //     oneToMany(gmoInsuranceType);
        }
        return gmoInsuranceType;
    }

    public static InsuranceType toDto(GmoInsuranceType gmoInsuranceType, boolean lazy) {
        if (null == gmoInsuranceType) {
            return null;
        }
        InsuranceType insuranceType = new InsuranceType();
        insuranceType.setId((int) gmoInsuranceType.getGmoInsuranceTypeId());
        insuranceType.setCode(gmoInsuranceType.getGmoInsuranceTypeCode());
        insuranceType.setDescription (gmoInsuranceType.getGmoInsuranceTypeDescription ());


        insuranceType.setCreatedBy(gmoInsuranceType.getCreatedBy());
        insuranceType.setUpdatedBy(gmoInsuranceType.getUpdatedBy());
        insuranceType.setCreationDate(gmoInsuranceType.getCreationDate());
        insuranceType.setUpdateDate(gmoInsuranceType.getUpdateDate());

        if(!lazy) {
 insuranceType.setOwner(OwnerMapper.toDto(gmoInsuranceType.getOwnOwner(),true));
       //   insuranceType.setInsurances (InsuranceMapper.toDtos(gmoInsuranceType.getGmoInsurances (),false));
        insuranceType.setInsuranceTypeTermsSet (InsuranceTypeTermsMapper.toDtos(gmoInsuranceType.getGmoInsuranceTypeTerms (),false));

        }
        return insuranceType;
    }

   /* private static void oneToMany(GmoInsuranceType insuranceType) {
        insuranceType.getGmoInsuranceTypeTerms().forEach(
                e -> {
                    e.setCreationDate(new Date());
                    e.setGmoInsuranceType(insuranceType);
                }
        );
    }*/

    public static List<InsuranceType> toDtos(Iterable<? extends GmoInsuranceType> gmoInsurances, boolean lazy) {
        if (null == gmoInsurances) {
            return null;
        }
        List<InsuranceType> vehicules = new ArrayList<>();

        for (GmoInsuranceType gmoInsuranceType : gmoInsurances) {
            vehicules.add(toDto(gmoInsuranceType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoInsuranceType> toEntities(Iterable<? extends InsuranceType> insurances, boolean lazy) {
        if (null == insurances) {
            return null;
        }
        Set<GmoInsuranceType> gmoInsurances = new HashSet<>();
        for (InsuranceType insuranceType : insurances) {
            gmoInsurances.add(toEntity(insuranceType, lazy));
        }
        return gmoInsurances;
    }

    public static Set<InsuranceType> toDtos(Set<GmoInsuranceType> gmoInsurances, boolean lazy) {
        if (null == gmoInsurances) {
            return null;
        }
        Set<InsuranceType> insurances = new HashSet<>();
        for (GmoInsuranceType gmoInsuranceType : gmoInsurances) {
            insurances.add(toDto(gmoInsuranceType, lazy));
        }
        return insurances;
    }
}
