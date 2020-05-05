package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ConsumptionType;
import com.bagile.gmo.entities.GmoConsumptionType;

import java.util.*;

public class ConsumptionTypeMapper {
    public ConsumptionTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoConsumptionId");
        map.put ("code", "gmoConsumptionCode");
        map.put ("description", "gmoConsumptionDescription");

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

    public static GmoConsumptionType toEntity(ConsumptionType consumptionType, boolean lazy) {
        if (null == consumptionType) {
            return null;
        }

        GmoConsumptionType gmoConsumptionType = new GmoConsumptionType ( );
        gmoConsumptionType.setGmoConsumptionTypeId (consumptionType.getId ( ));
        gmoConsumptionType.setGmoConsumptionTypeCode (consumptionType.getCode ( ) != null ? consumptionType.getCode ( ).toUpperCase ( ) : null);
        gmoConsumptionType.setGmoConsumptionTypeDescription (consumptionType.getDescription ( ));

        gmoConsumptionType.setCreatedBy (consumptionType.getCreatedBy ( ));
        gmoConsumptionType.setUpdatedBy (consumptionType.getUpdatedBy ( ));



        return gmoConsumptionType;

    }

    public static ConsumptionType toDto(GmoConsumptionType gmoConsumptionType, boolean lazy) {
        if (null == gmoConsumptionType) {
            return null;
        }
        ConsumptionType consumptionType = new ConsumptionType ( );
        consumptionType.setId ((int) gmoConsumptionType.getGmoConsumptionTypeId ());
        consumptionType.setCode (gmoConsumptionType.getGmoConsumptionTypeCode ());
        consumptionType.setDescription (gmoConsumptionType.getGmoConsumptionTypeDescription ());

        consumptionType.setCreatedBy (gmoConsumptionType.getCreatedBy ());
        consumptionType.setUpdatedBy (gmoConsumptionType.getUpdatedBy ());
        consumptionType.setCreationDate (gmoConsumptionType.getCreationDate ());
        consumptionType.setUpdateDate (gmoConsumptionType.getUpdateDate ());


        return consumptionType;

    }


    public static List<ConsumptionType> toDtos(Iterable<? extends GmoConsumptionType> gmoConsumptionTypes, boolean lazy) {
        if (null == gmoConsumptionTypes) {
            return null;
        }
        List<ConsumptionType> vehicules = new ArrayList<> ( );

        for (GmoConsumptionType gmoConsumptionType : gmoConsumptionTypes) {
            vehicules.add (toDto (gmoConsumptionType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoConsumptionType> toEntities(Set<ConsumptionType> consumptionTypes, boolean lazy) {
        if (null == consumptionTypes) {
            return null;
        }
        Set<GmoConsumptionType> gmoConsumptionTypes = new HashSet<> ( );
        for (ConsumptionType consumptionType : consumptionTypes) {
            gmoConsumptionTypes.add (toEntity (consumptionType, lazy));
        }
        return gmoConsumptionTypes;
    }

    public static Set<ConsumptionType> toDtos(Set<GmoConsumptionType> gmoConsumptionTypes, boolean lazy) {
        if (null == gmoConsumptionTypes) {
            return null;
        }
        Set<ConsumptionType> consumptionTypes = new HashSet<> ( );
        for (GmoConsumptionType gmoConsumptionType : gmoConsumptionTypes) {
            consumptionTypes.add (toDto (gmoConsumptionType, lazy));
        }
        return consumptionTypes;
    }
}
