package com.bagile.tms.mapper;

import com.bagile.tms.dto.ContractType;
import com.bagile.tms.entities.TmsContractType;

import java.util.*;

public class ContractTypeMapper {
    public ContractTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsContractTypeId");
        map.put("code", "tmsContractTypeCode");
        map.put("description", "tmsContractTypeDescription");

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

    public static TmsContractType toEntity(ContractType contractType, boolean lazy) {
        if (null == contractType) {
            return null;
        }
        TmsContractType tmsContractType = new TmsContractType();
        tmsContractType.setTmsContractTypeId(contractType.getId());
        tmsContractType.setTmsContractTypeCode(contractType.getCode() != null ? contractType.getCode().toUpperCase() : null);
        tmsContractType.setTmsContractTypeDescription (contractType.getDescription ());


        tmsContractType.setCreatedBy(contractType.getCreatedBy());
        tmsContractType.setUpdatedBy(contractType.getUpdatedBy());
        tmsContractType.setCreationDate(contractType.getCreationDate());
        tmsContractType.setUpdateDate(contractType.getUpdateDate());

        return tmsContractType;

    }

    public static ContractType toDto(TmsContractType tmsContractType, boolean lazy) {
        if (null == tmsContractType) {
            return null;
        }
        ContractType contractType = new ContractType();
        contractType.setId((int) tmsContractType.getTmsContractTypeId());
        contractType.setCode(tmsContractType.getTmsContractTypeCode());
        contractType.setDescription (tmsContractType.getTmsContractTypeDescription ());

        contractType.setCreatedBy(tmsContractType.getCreatedBy());
        contractType.setUpdatedBy(tmsContractType.getUpdatedBy());
        contractType.setCreationDate(tmsContractType.getCreationDate());
        contractType.setUpdateDate(tmsContractType.getUpdateDate());

        return contractType;

    }


    public static List<ContractType> toDtos(Iterable<? extends TmsContractType> tmsContractTypes, boolean lazy) {
        if (null == tmsContractTypes) {
            return null;
        }
        List<ContractType> vehicules = new ArrayList<>();

        for (TmsContractType tmsContractType : tmsContractTypes) {
            vehicules.add(toDto(tmsContractType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsContractType> toEntities(Set<ContractType> contractTypes, boolean lazy) {
        if (null == contractTypes) {
            return null;
        }
        Set<TmsContractType> tmsContractTypes = new HashSet<>();
        for (ContractType contractType : contractTypes) {
            tmsContractTypes.add(toEntity(contractType, lazy));
        }
        return tmsContractTypes;
    }

    public static Set<ContractType> toDtos(Set<TmsContractType> tmsContractTypes, boolean lazy) {
        if (null == tmsContractTypes) {
            return null;
        }
        Set<ContractType> contractTypes = new HashSet<>();
        for (TmsContractType tmsContractType : tmsContractTypes) {
            contractTypes.add(toDto(tmsContractType, lazy));
        }
        return contractTypes;
    }
}
