package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ContractType;
import com.bagile.gmo.entities.GmoContractType;

import java.util.*;

public class ContractTypeMapper {
    public ContractTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoContractTypeId");
        map.put("code", "gmoContractTypeCode");
        map.put("description", "gmoContractTypeDescription");

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

    public static GmoContractType toEntity(ContractType contractType, boolean lazy) {
        if (null == contractType) {
            return null;
        }
        GmoContractType gmoContractType = new GmoContractType();
        gmoContractType.setGmoContractTypeId(contractType.getId());
        gmoContractType.setGmoContractTypeCode(contractType.getCode() != null ? contractType.getCode().toUpperCase() : null);
        gmoContractType.setGmoContractTypeDescription (contractType.getDescription ());


        gmoContractType.setCreatedBy(contractType.getCreatedBy());
        gmoContractType.setUpdatedBy(contractType.getUpdatedBy());
        gmoContractType.setCreationDate(contractType.getCreationDate());
        gmoContractType.setUpdateDate(contractType.getUpdateDate());

        if(!lazy){

            gmoContractType.setOwnOwner(OwnerMapper.toEntity(contractType.getOwner(),true));

        }
        return gmoContractType;

    }

    public static ContractType toDto(GmoContractType gmoContractType, boolean lazy) {
        if (null == gmoContractType) {
            return null;
        }
        ContractType contractType = new ContractType();
        contractType.setId((int) gmoContractType.getGmoContractTypeId());
        contractType.setCode(gmoContractType.getGmoContractTypeCode());
        contractType.setDescription (gmoContractType.getGmoContractTypeDescription ());

        contractType.setCreatedBy(gmoContractType.getCreatedBy());
        contractType.setUpdatedBy(gmoContractType.getUpdatedBy());
        contractType.setCreationDate(gmoContractType.getCreationDate());
        contractType.setUpdateDate(gmoContractType.getUpdateDate());

        if(!lazy){

            contractType.setOwner(OwnerMapper.toDto(gmoContractType.getOwnOwner(),true));
        }
        return contractType;

    }


    public static List<ContractType> toDtos(Iterable<? extends GmoContractType> gmoContractTypes, boolean lazy) {
        if (null == gmoContractTypes) {
            return null;
        }
        List<ContractType> vehicules = new ArrayList<>();

        for (GmoContractType gmoContractType : gmoContractTypes) {
            vehicules.add(toDto(gmoContractType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoContractType> toEntities(Set<ContractType> contractTypes, boolean lazy) {
        if (null == contractTypes) {
            return null;
        }
        Set<GmoContractType> gmoContractTypes = new HashSet<>();
        for (ContractType contractType : contractTypes) {
            gmoContractTypes.add(toEntity(contractType, lazy));
        }
        return gmoContractTypes;
    }

    public static Set<ContractType> toDtos(Set<GmoContractType> gmoContractTypes, boolean lazy) {
        if (null == gmoContractTypes) {
            return null;
        }
        Set<ContractType> contractTypes = new HashSet<>();
        for (GmoContractType gmoContractType : gmoContractTypes) {
            contractTypes.add(toDto(gmoContractType, lazy));
        }
        return contractTypes;
    }
}
