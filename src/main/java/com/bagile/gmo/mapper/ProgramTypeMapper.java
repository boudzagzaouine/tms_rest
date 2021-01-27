package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ProgramType;
import com.bagile.gmo.entities.GmoProgramType;

import java.util.*;

public class ProgramTypeMapper {
    public ProgramTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoProgramTypeId");
        map.put ("code", "gmoProgramTypeCode");
        map.put ("description", "gmoProgramTypeDescription");
        map.put ("maintenanceType", "gmoMaintenanceType");
        map.put ("operationType", "gmoOperationType");

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

    public static GmoProgramType toEntity(ProgramType programType, boolean lazy) {
        if (null == programType) {
            return null;
        }

        GmoProgramType gmoProgramType = new GmoProgramType ( );
        gmoProgramType.setGmoProgramTypeId (programType.getId ( ));
        gmoProgramType.setGmoProgramTypeCode (programType.getCode ( ) != null ? programType.getCode ( ).toUpperCase ( ) : null);
        gmoProgramType.setGmoProgramTypeDescription (programType.getDescription ( ));
        
        gmoProgramType.setCreatedBy (programType.getCreatedBy ());
        gmoProgramType.setUpdatedBy (programType.getUpdatedBy ());

        if (!lazy) {
            gmoProgramType.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity(programType.getMaintenanceType(), true));

        }

        return gmoProgramType;

    }

    public static ProgramType toDto(GmoProgramType gmoProgramType, boolean lazy) {
        if (null == gmoProgramType) {
            return null;
        }
        ProgramType programType = new ProgramType ( );
        programType.setId (gmoProgramType.getGmoProgramTypeId ());
        programType.setCode (gmoProgramType.getGmoProgramTypeCode ());
        programType.setDescription (gmoProgramType.getGmoProgramTypeDescription ());

        programType.setCreatedBy (gmoProgramType.getCreatedBy ());
        programType.setUpdatedBy (gmoProgramType.getUpdatedBy ());
        programType.setCreationDate (gmoProgramType.getCreationDate ());
        programType.setUpdateDate (gmoProgramType.getUpdateDate ());

        if (!lazy) {
            programType.setMaintenanceType (MaintenanceTypeMapper.toDto(gmoProgramType.getGmoMaintenanceType(), true));
        }
        return programType;

    }


    public static List<ProgramType> toDtos(Iterable<? extends GmoProgramType> gmoProgramTypes, boolean lazy) {
        if (null == gmoProgramTypes) {
            return null;
        }
        List<ProgramType> programTypes = new ArrayList<> ( );

        for (GmoProgramType gmoProgramType : gmoProgramTypes) {
            programTypes.add (toDto (gmoProgramType, lazy));
        }
        return programTypes;
    }

    public static Set<GmoProgramType> toEntities(Set<ProgramType> programTypes, boolean lazy) {
        if (null == programTypes) {
            return null;
        }
        Set<GmoProgramType> gmoProgramTypes = new HashSet<> ( );
        for (ProgramType programType : programTypes) {
            gmoProgramTypes.add (toEntity (programType, lazy));
        }
        return gmoProgramTypes;
    }

    public static Set<ProgramType> toDtos(Set<GmoProgramType> gmoProgramTypes, boolean lazy) {
        if (null == gmoProgramTypes) {
            return null;
        }
        Set<ProgramType> programTypes = new HashSet<> ( );
        for (GmoProgramType gmoProgramType : gmoProgramTypes) {
            programTypes.add (toDto (gmoProgramType, lazy));
        }
        return programTypes;
    }
}
