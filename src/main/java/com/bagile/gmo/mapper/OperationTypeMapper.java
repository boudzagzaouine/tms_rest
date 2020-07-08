package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OperationType;
import com.bagile.gmo.entities.GmoOperationType;

import java.util.*;

public class OperationTypeMapper {

    public OperationTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoOperationTypeId");
        map.put ("code", "gmoOperationTypeCode");
        map.put ("description", "gmoOperationTypeDescription");
        map.put ("programType", "gmoProgramType");

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

    public static GmoOperationType toEntity(OperationType operationType, boolean lazy) {
        if (null == operationType) {
            return null;
        }

        GmoOperationType gmoOperationType = new GmoOperationType ( );
        gmoOperationType.setGmoOperationTypeId (operationType.getId ( ));
        gmoOperationType.setGmoOperationTypeCode (operationType.getCode ( ) != null ? operationType.getCode ( ).toUpperCase ( ) : null);
        gmoOperationType.setGmoOperationTypeDescription (operationType.getDescription ( ));
        
        gmoOperationType.setCreatedBy (operationType.getCreatedBy ( ));
        gmoOperationType.setUpdatedBy (operationType.getUpdatedBy ( ));

        if (!lazy) {
            gmoOperationType.setGmoProgramType(ProgramTypeMapper.toEntity(operationType.getProgramType(), true));

        }

        return gmoOperationType;

    }

    public static OperationType toDto(GmoOperationType gmoOperationType, boolean lazy) {
        if (null == gmoOperationType) {
            return null;
        }
        OperationType operationType = new OperationType ( );
        operationType.setId ((int) gmoOperationType.getGmoOperationTypeId ());
        operationType.setCode (gmoOperationType.getGmoOperationTypeCode ());
        operationType.setDescription (gmoOperationType.getGmoOperationTypeDescription ());

        operationType.setCreatedBy (gmoOperationType.getCreatedBy ());
        operationType.setUpdatedBy (gmoOperationType.getUpdatedBy ());
        operationType.setCreationDate (gmoOperationType.getCreationDate ());
        operationType.setUpdateDate (gmoOperationType.getUpdateDate ());
        if (!lazy) {
            operationType.setProgramType(ProgramTypeMapper.toDto(gmoOperationType.getGmoProgramType(), true));

        }
      
        return operationType;

    }


    public static List<OperationType> toDtos(Iterable<? extends GmoOperationType> gmoOperationTypes, boolean lazy) {
        if (null == gmoOperationTypes) {
            return null;
        }
        List<OperationType> operationTypes = new ArrayList<> ( );

        for (GmoOperationType gmoOperationType : gmoOperationTypes) {
            operationTypes.add (toDto (gmoOperationType, lazy));
        }
        return operationTypes;
    }

    public static Set<GmoOperationType> toEntities(List<OperationType> operationTypes, boolean lazy) {
        if (null == operationTypes) {
            return null;
        }
        Set<GmoOperationType> gmoOperationTypes = new HashSet<> ();
        for (OperationType operationType : operationTypes) {
            gmoOperationTypes.add (toEntity (operationType, lazy));
        }
        return gmoOperationTypes;
    }

    public static Set<OperationType> toDtos(Set<GmoOperationType> gmoOperationTypes, boolean lazy) {
        if (null == gmoOperationTypes) {
            return null;
        }
        Set<OperationType> operationTypes = new HashSet<> ( );
        for (GmoOperationType gmoOperationType : gmoOperationTypes) {
            operationTypes.add (toDto (gmoOperationType, lazy));
        }
        return operationTypes;
    }
}
