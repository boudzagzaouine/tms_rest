package com.bagile.tms.mapper;

import com.bagile.tms.dto.Insurance;
import com.bagile.tms.dto.TermInsurance;
import com.bagile.tms.entities.TmsInsurance;

import java.util.*;

public class InsuranceMapper {

    public InsuranceMapper() {
    }


    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "tmsInsuranceId");
        map.put("code", "tmsInsuranceCode");
        map.put("startDate", "tmsInsuranceStartDate");
        map.put("endDate", "tmsInsuranceEndDate");
        map.put("amount", "tmsInsuranceAmount");
        map.put("contractType", "tmsContractType");
        map.put("contractType", "tmsTermInsurance");

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

    public static TmsInsurance toEntity(Insurance insurance, boolean lazy) {
        if (null == insurance) {
            return null;
        }
        TmsInsurance tmsinsurance = new TmsInsurance();
        tmsinsurance.setTmsInsuranceCode(insurance.getCode());
        tmsinsurance.setTmsInsuranceId((int) insurance.getId());
        tmsinsurance.setTmsInsuranceStartDate(insurance.getStartDate());
        tmsinsurance.setTmsInsuranceEndDate(insurance.getEndDate());
        tmsinsurance.setTmsInsuranceAmount(insurance.getAmount());


        tmsinsurance.setCreatedBy(insurance.getCreatedBy());
        tmsinsurance.setUpdatedBy(insurance.getUpdatedBy());
        tmsinsurance.setCreationDate(insurance.getCreationDate());
        tmsinsurance.setUpdateDate(insurance.getUpdateDate());
        if (!lazy) {
            tmsinsurance.setTmsContractType(ContractTypeMapper.toEntity(insurance.getContractType(), true));
            tmsinsurance.setTmsTermInsurance(TermInsuranceMapper.toEntity(insurance.getTermInsurance(),true));
        }

        return tmsinsurance;
    }


    public static Insurance toDto(TmsInsurance tmsInsurance, boolean lazy) {
        if (null == tmsInsurance) {
            return null;
        }
        Insurance insurance = new Insurance();
        insurance.setId((int) tmsInsurance.getTmsInsuranceId());
        insurance.setCode(tmsInsurance.getTmsInsuranceCode());
        insurance.setStartDate(tmsInsurance.getTmsInsuranceStartDate());
        insurance.setEndDate(tmsInsurance.getTmsInsuranceEndDate());
        insurance.setAmount(tmsInsurance.getTmsInsuranceAmount());


        insurance.setCreatedBy(tmsInsurance.getCreatedBy());
        insurance.setUpdatedBy(tmsInsurance.getUpdatedBy());
        insurance.setCreationDate(tmsInsurance.getCreationDate());
        insurance.setUpdateDate(tmsInsurance.getUpdateDate());

        if (!lazy) {
            insurance.setContractType(ContractTypeMapper.toDto(tmsInsurance.getTmsContractType(), true));
            insurance.setTermInsurance(TermInsuranceMapper.toDto(tmsInsurance.getTmsTermInsurance(), true));
        }
        return insurance;
    }



    public static List<Insurance> toDtos(Iterable<? extends TmsInsurance> tmsInsurances, boolean lazy) {
        if (null == tmsInsurances) {
            return null;
        }
        List<Insurance> insurances = new ArrayList<>();
        for (TmsInsurance tmsInsurance : tmsInsurances) {
            insurances.add(toDto(tmsInsurance, lazy));
        }
        return insurances;
    }


    public static Set<TmsInsurance> toEntities(Set<? extends Insurance> insurances, boolean lazy) {
        if (null == insurances) {
            return null;
        }
        Set<TmsInsurance> tmsInsurances = new HashSet<>();
        for (Insurance insurance : insurances) {
            tmsInsurances.add(toEntity(insurance, lazy));
        }
        return tmsInsurances;
    }


    public static Set<Insurance> toDtos(Set<? extends TmsInsurance> tmsInsurances, boolean lazy) {
        if (null == tmsInsurances) {
            return null;
        }
        Set<Insurance> insurances = new HashSet<>();
        for (TmsInsurance tmsInsurance : tmsInsurances) {
            insurances.add(toDto(tmsInsurance, lazy));
        }
        return insurances;
    }

}
