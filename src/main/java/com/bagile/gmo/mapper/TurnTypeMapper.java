package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TurnType;
import com.bagile.gmo.entities.TmsTurnType;

import java.util.*;

public class TurnTypeMapper {
    public TurnTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTurnTypeId");
        map.put("code", "tmsTurnTypeTypeCode");
        map.put("description", "tmsTurnTypeTypeDescription");

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

    public static TmsTurnType toEntity(TurnType turnType, boolean lazy) {
        if (null == turnType) {
            return null;
        }
        TmsTurnType tmsTurnTypeType = new TmsTurnType();
        tmsTurnTypeType.setTmsTurnTypeId(turnType.getId());
        tmsTurnTypeType.setTmsTurnTypeCode(turnType.getCode() != null ? turnType.getCode().toUpperCase() : null);
        tmsTurnTypeType.setTmsTurnTypeDescription (turnType.getDescription ());

        tmsTurnTypeType.setCreatedBy(turnType.getCreatedBy());
        tmsTurnTypeType.setUpdatedBy(turnType.getUpdatedBy());
        tmsTurnTypeType.setCreationDate(turnType.getCreationDate());
        tmsTurnTypeType.setUpdateDate(turnType.getUpdateDate());

          if(!lazy){
              tmsTurnTypeType.setOwnOwner(OwnerMapper.toEntity(turnType.getOwner(),true));
          }

        return tmsTurnTypeType;

    }

    public static TurnType toDto(TmsTurnType tmsTurnTypeType, boolean lazy) {
        if (null == tmsTurnTypeType) {
            return null;
        }
        TurnType turnType = new TurnType();
        turnType.setId(tmsTurnTypeType.getTmsTurnTypeId());
        turnType.setCode(tmsTurnTypeType.getTmsTurnTypeCode());
        turnType.setDescription (tmsTurnTypeType.getTmsTurnTypeDescription ());

 if(!lazy){
      turnType.setOwner(OwnerMapper.toDto(tmsTurnTypeType.getOwnOwner(),true));
 }
        return turnType;

    }


    public static List<TurnType> toDtos(Iterable<? extends TmsTurnType> tmsTurnTypeTypes, boolean lazy) {
        if (null == tmsTurnTypeTypes) {
            return null;
        }
        List<TurnType> vehicules = new ArrayList<>();

        for (TmsTurnType tmsTurnTypeType : tmsTurnTypeTypes) {
            vehicules.add(toDto(tmsTurnTypeType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsTurnType> toEntities(Set<TurnType> turnTypes, boolean lazy) {
        if (null == turnTypes) {
            return null;
        }
        Set<TmsTurnType> tmsTurnTypeTypes = new HashSet<>();
        for (TurnType turnType : turnTypes) {
            tmsTurnTypeTypes.add(toEntity(turnType, lazy));
        }
        return tmsTurnTypeTypes;
    }

    public static Set<TurnType> toDtos(Set<TmsTurnType> tmsTurnTypeTypes, boolean lazy) {
        if (null == tmsTurnTypeTypes) {
            return null;
        }
        Set<TurnType> turnTypes = new HashSet<>();
        for (TmsTurnType tmsTurnTypeType : tmsTurnTypeTypes) {
            turnTypes.add(toDto(tmsTurnTypeType, lazy));
        }
        return turnTypes;
    }
}
