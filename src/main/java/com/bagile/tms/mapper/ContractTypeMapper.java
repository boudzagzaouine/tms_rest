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
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsContractType toEntity(ContractType contractType, boolean lazy) {
        if (null == contractType) {
            return null;
        }
        TmsContractType tmsContractType = new com.bagile.tms.entities.TmsContractType();
        tmsContractType.setTmsContractTypeId((int)contractType.getId());
        tmsContractType.setTmsContractTypeCode( contractType.getCode());
        tmsContractType.setTmsContractTypeDescription(contractType.getDescription());


        tmsContractType.setCreatedBy(contractType.getCreatedBy());
        tmsContractType.setUpdatedBy(contractType.getUpdatedBy());
        tmsContractType.setCreationDate(contractType.getCreationDate());
        tmsContractType.setUpdateDate(contractType.getUpdateDate());


        return tmsContractType;
    }


    public static ContractType toDto(com.bagile.tms.entities.TmsContractType tmsContractType, boolean lazy) {
        if (null == tmsContractType) {
            return null;
        }
        ContractType contractType = new ContractType();

        contractType.setId((int) tmsContractType.getTmsContractTypeId());
        contractType.setCode(tmsContractType.getTmsContractTypeCode());
        contractType.setDescription(tmsContractType.getTmsContractTypeDescription());


        contractType.setCreatedBy(tmsContractType.getCreatedBy());
        contractType.setUpdatedBy(tmsContractType.getUpdatedBy());
        contractType.setCreationDate(tmsContractType.getCreationDate());
        contractType.setUpdateDate(tmsContractType.getUpdateDate());

        return contractType;
    }



    public static List<ContractType> toDtos(Iterable<? extends com.bagile.tms.entities.TmsContractType> tmsContractTypes, boolean lazy) {
        if (null == tmsContractTypes) {
            return null;
        }
        List<ContractType> contractTypes = new ArrayList<>();
        for (com.bagile.tms.entities.TmsContractType tmsContractType : tmsContractTypes) {
            contractTypes.add(toDto(tmsContractType, lazy));
        }
        return contractTypes;
    }

    public static Set<com.bagile.tms.entities.TmsContractType> toEntities(Set<? extends ContractType> contractTypes, boolean lazy) {
        if (null == contractTypes) {
            return null;
        }
        Set<com.bagile.tms.entities.TmsContractType> tmsContractTypes = new HashSet<>();
        for (ContractType contractType : contractTypes) {
            tmsContractTypes.add(toEntity(contractType, lazy));
        }
        return tmsContractTypes;
    }

    public static Set<ContractType> toDtos(Set<? extends com.bagile.tms.entities.TmsContractType> tmsContractTypes, boolean lazy) {
        if (null == tmsContractTypes) {
            return null;
        }
        Set<ContractType> contractTypes = new HashSet<>();
        for (com.bagile.tms.entities.TmsContractType tmsContractType : tmsContractTypes) {
            contractTypes.add(toDto(tmsContractType, lazy));
        }
        return contractTypes;
    }

}
