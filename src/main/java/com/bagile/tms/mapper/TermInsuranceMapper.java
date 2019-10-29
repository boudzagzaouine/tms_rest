package com.bagile.tms.mapper;

import com.bagile.tms.entities.TmsTermInsurance;

import java.util.*;

public class TermInsuranceMapper {

    public TermInsuranceMapper() {
    }

    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "tmsTermInsuranceId");
        map.put("code", "tmsTermInsuranceCode");
        map.put("description", "tmsTermInsuranceDescription");


        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }


    public static TmsTermInsurance toEntity(com.bagile.tms.dto.TermInsurance termInsurance, boolean lazy) {
        if (null == termInsurance) {
            return null;
        }
        TmsTermInsurance tmsTermInsurance = new TmsTermInsurance();
        tmsTermInsurance.setTmsTermInsuranceCode(termInsurance.getCode());
        tmsTermInsurance.setTmsTermInsuranceId( termInsurance.getId());
        tmsTermInsurance.setTmsTermInsuranceDescription(termInsurance.getDescription());


        tmsTermInsurance.setCreatedBy(termInsurance.getCreatedBy());
        tmsTermInsurance.setUpdatedBy(termInsurance.getUpdatedBy());
        tmsTermInsurance.setCreationDate(termInsurance.getCreationDate());
        tmsTermInsurance.setUpdateDate(termInsurance.getUpdateDate());


        return tmsTermInsurance;
    }

    public static com.bagile.tms.dto.TermInsurance toDto(TmsTermInsurance tmsTermInsurance, boolean lazy) {
        if (null == tmsTermInsurance) {
            return null;
        }
        com.bagile.tms.dto.TermInsurance termInsurance = new com.bagile.tms.dto.TermInsurance();

        termInsurance.setId(tmsTermInsurance.getTmsTermInsuranceId());
        termInsurance.setCode(tmsTermInsurance.getTmsTermInsuranceCode());
        termInsurance.setDescription(tmsTermInsurance.getTmsTermInsuranceDescription());

        termInsurance.setCreatedBy(tmsTermInsurance.getCreatedBy());
        termInsurance.setUpdatedBy(tmsTermInsurance.getUpdatedBy());
        termInsurance.setCreationDate(tmsTermInsurance.getCreationDate());
        termInsurance.setUpdateDate(tmsTermInsurance.getUpdateDate());

        return termInsurance;
    }


    public static List<com.bagile.tms.dto.TermInsurance> toDtos(Iterable<? extends TmsTermInsurance> tmsTermInsurances, boolean lazy) {
        if (null == tmsTermInsurances) {
            return null;
        }
        List<com.bagile.tms.dto.TermInsurance> termInsurances = new ArrayList<>();
        for (TmsTermInsurance tmsTermInsurance : tmsTermInsurances) {
            termInsurances.add(toDto(tmsTermInsurance, lazy));
        }
        return termInsurances;
    }


    public static Set<TmsTermInsurance> toEntities(Set<? extends com.bagile.tms.dto.TermInsurance> termInsurances, boolean lazy) {
        if (null == termInsurances) {
            return null;
        }
        Set<TmsTermInsurance> tmsTermInsurances = new HashSet<>();
        for (com.bagile.tms.dto.TermInsurance termInsurance : termInsurances) {
            tmsTermInsurances.add(toEntity(termInsurance, lazy));
        }
        return tmsTermInsurances;
    }

    public static Set<com.bagile.tms.dto.TermInsurance> toDtos(Set<? extends TmsTermInsurance> tmsTermInsurances, boolean lazy) {
        if (null == tmsTermInsurances) {
            return null;
        }
        Set<com.bagile.tms.dto.TermInsurance> termInsurances = new HashSet<>();
        for (TmsTermInsurance tmsBadgeType : tmsTermInsurances) {
            termInsurances.add(toDto(tmsBadgeType, lazy));
        }
        return termInsurances;
    }

}
