package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.PeriodicityType;
import com.bagile.gmo.entities.GmoPeriodicityType;

import java.util.*;

public class PeriodicityTypeMapper {
    
    public PeriodicityTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoPeriodicityTypeId");
        map.put ("code", "gmoPeriodicityTypeCode");
        map.put ("description", "gmoPeriodicityTypeDescription");
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

    public static GmoPeriodicityType toEntity(PeriodicityType periodicityType, boolean lazy) {
        if (null == periodicityType) {
            return null;
        }

        GmoPeriodicityType gmoPeriodicityType = new GmoPeriodicityType ( );
        gmoPeriodicityType.setGmoPeriodicityTypeId (periodicityType.getId ( ));
        gmoPeriodicityType.setGmoPeriodicityTypeCode (periodicityType.getCode ( ) != null ? periodicityType.getCode ( ).toUpperCase ( ) : null);
        gmoPeriodicityType.setGmoPeriodicityTypeDescription (periodicityType.getDescription ( ));
        
        gmoPeriodicityType.setCreatedBy (periodicityType.getCreatedBy ( ));
        gmoPeriodicityType.setUpdatedBy (periodicityType.getUpdatedBy ( ));

       

        return gmoPeriodicityType;

    }

    public static PeriodicityType toDto(GmoPeriodicityType gmoPeriodicityType, boolean lazy) {
        if (null == gmoPeriodicityType) {
            return null;
        }
        PeriodicityType periodicityType = new PeriodicityType ( );
        periodicityType.setId ((int) gmoPeriodicityType.getGmoPeriodicityTypeId ());
        periodicityType.setCode (gmoPeriodicityType.getGmoPeriodicityTypeCode ());
        periodicityType.setDescription (gmoPeriodicityType.getGmoPeriodicityTypeDescription ());

        periodicityType.setCreatedBy (gmoPeriodicityType.getCreatedBy ());
        periodicityType.setUpdatedBy (gmoPeriodicityType.getUpdatedBy ());
        periodicityType.setCreationDate (gmoPeriodicityType.getCreationDate ());
        periodicityType.setUpdateDate (gmoPeriodicityType.getUpdateDate ());

      
        return periodicityType;

    }


    public static List<PeriodicityType> toDtos(Iterable<? extends GmoPeriodicityType> gmoPeriodicityTypes, boolean lazy) {
        if (null == gmoPeriodicityTypes) {
            return null;
        }
        List<PeriodicityType> periodicityTypes = new ArrayList<> ( );

        for (GmoPeriodicityType gmoPeriodicityType : gmoPeriodicityTypes) {
            periodicityTypes.add (toDto (gmoPeriodicityType, lazy));
        }
        return periodicityTypes;
    }

    public static Set<GmoPeriodicityType> toEntities(Set<PeriodicityType> periodicityTypes, boolean lazy) {
        if (null == periodicityTypes) {
            return null;
        }
        Set<GmoPeriodicityType> gmoPeriodicityTypes = new HashSet<> ( );
        for (PeriodicityType periodicityType : periodicityTypes) {
            gmoPeriodicityTypes.add (toEntity (periodicityType, lazy));
        }
        return gmoPeriodicityTypes;
    }

    public static Set<PeriodicityType> toDtos(Set<GmoPeriodicityType> gmoPeriodicityTypes, boolean lazy) {
        if (null == gmoPeriodicityTypes) {
            return null;
        }
        Set<PeriodicityType> periodicityTypes = new HashSet<> ( );
        for (GmoPeriodicityType gmoPeriodicityType : gmoPeriodicityTypes) {
            periodicityTypes.add (toDto (gmoPeriodicityType, lazy));
        }
        return periodicityTypes;
    }
}
