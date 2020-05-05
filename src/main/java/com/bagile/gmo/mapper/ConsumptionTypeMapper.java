package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ConsumptionType;
import com.bagile.gmo.entities.TmsConsumptionType;

import java.util.*;

public class ConsumptionTypeMapper {
    public ConsumptionTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsConsumptionId");
        map.put ("code", "tmsConsumptionCode");
        map.put ("description", "tmsConsumptionDescription");

        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static TmsConsumptionType toEntity(ConsumptionType consumptionType, boolean lazy) {
        if (null == consumptionType) {
            return null;
        }

        TmsConsumptionType tmsConsumptionType = new TmsConsumptionType ( );
        tmsConsumptionType.setTmsConsumptionTypeId (consumptionType.getId ( ));
        tmsConsumptionType.setTmsConsumptionTypeCode (consumptionType.getCode ( ) != null ? consumptionType.getCode ( ).toUpperCase ( ) : null);
        tmsConsumptionType.setTmsConsumptionTypeDescription (consumptionType.getDescription ( ));

        tmsConsumptionType.setCreatedBy (consumptionType.getCreatedBy ( ));
        tmsConsumptionType.setUpdatedBy (consumptionType.getUpdatedBy ( ));



        return tmsConsumptionType;

    }

    public static ConsumptionType toDto(TmsConsumptionType tmsConsumptionType, boolean lazy) {
        if (null == tmsConsumptionType) {
            return null;
        }
        ConsumptionType consumptionType = new ConsumptionType ( );
        consumptionType.setId ((int) tmsConsumptionType.getTmsConsumptionTypeId ());
        consumptionType.setCode (tmsConsumptionType.getTmsConsumptionTypeCode ());
        consumptionType.setDescription (tmsConsumptionType.getTmsConsumptionTypeDescription ());

        consumptionType.setCreatedBy (tmsConsumptionType.getCreatedBy ());
        consumptionType.setUpdatedBy (tmsConsumptionType.getUpdatedBy ());
        consumptionType.setCreationDate (tmsConsumptionType.getCreationDate ());
        consumptionType.setUpdateDate (tmsConsumptionType.getUpdateDate ());


        return consumptionType;

    }


    public static List<ConsumptionType> toDtos(Iterable<? extends TmsConsumptionType> tmsConsumptionTypes, boolean lazy) {
        if (null == tmsConsumptionTypes) {
            return null;
        }
        List<ConsumptionType> vehicules = new ArrayList<> ( );

        for (TmsConsumptionType tmsConsumptionType : tmsConsumptionTypes) {
            vehicules.add (toDto (tmsConsumptionType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsConsumptionType> toEntities(Set<ConsumptionType> consumptionTypes, boolean lazy) {
        if (null == consumptionTypes) {
            return null;
        }
        Set<TmsConsumptionType> tmsConsumptionTypes = new HashSet<> ( );
        for (ConsumptionType consumptionType : consumptionTypes) {
            tmsConsumptionTypes.add (toEntity (consumptionType, lazy));
        }
        return tmsConsumptionTypes;
    }

    public static Set<ConsumptionType> toDtos(Set<TmsConsumptionType> tmsConsumptionTypes, boolean lazy) {
        if (null == tmsConsumptionTypes) {
            return null;
        }
        Set<ConsumptionType> consumptionTypes = new HashSet<> ( );
        for (TmsConsumptionType tmsConsumptionType : tmsConsumptionTypes) {
            consumptionTypes.add (toDto (tmsConsumptionType, lazy));
        }
        return consumptionTypes;
    }
}
