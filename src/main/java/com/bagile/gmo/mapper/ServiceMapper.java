package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Service;
import com.bagile.gmo.entities.GmoService;

import java.util.*;

public class ServiceMapper {

    public ServiceMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoOperationTypeId");
        map.put ("code", "gmoOperationTypeCode");
        map.put ("description", "gmoOperationTypeDescription");

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

    public static GmoService toEntity(Service operationType, boolean lazy) {
        if (null == operationType) {
            return null;
        }

        GmoService gmoOperationType = new GmoService( );
        gmoOperationType.setGmoOperationTypeId (operationType.getId ( ));
        gmoOperationType.setGmoOperationTypeCode (operationType.getCode ( ) != null ? operationType.getCode ( ).toUpperCase ( ) : null);
        gmoOperationType.setGmoOperationTypeDescription (operationType.getDescription ( ));
        
        gmoOperationType.setCreatedBy (operationType.getCreatedBy ( ));
        gmoOperationType.setUpdatedBy (operationType.getUpdatedBy ( ));


        return gmoOperationType;

    }

    public static Service toDto(GmoService gmoOperationType, boolean lazy) {
        if (null == gmoOperationType) {
            return null;
        }
        Service operationType = new Service( );
        operationType.setId ((int) gmoOperationType.getGmoOperationTypeId ());
        operationType.setCode (gmoOperationType.getGmoOperationTypeCode ());
        operationType.setDescription (gmoOperationType.getGmoOperationTypeDescription ());

        operationType.setCreatedBy (gmoOperationType.getCreatedBy ());
        operationType.setUpdatedBy (gmoOperationType.getUpdatedBy ());
        operationType.setCreationDate (gmoOperationType.getCreationDate ());
        operationType.setUpdateDate (gmoOperationType.getUpdateDate ());

        return operationType;

    }


    public static List<Service> toDtos(Iterable<? extends GmoService> gmoOperationTypes, boolean lazy) {
        if (null == gmoOperationTypes) {
            return null;
        }
        List<Service> operationTypes = new ArrayList<> ( );

        for (GmoService gmoOperationType : gmoOperationTypes) {
            operationTypes.add (toDto (gmoOperationType, lazy));
        }
        return operationTypes;
    }

    public static Set<GmoService> toEntities(List<Service> operationTypes, boolean lazy) {
        if (null == operationTypes) {
            return null;
        }
        Set<GmoService> gmoOperationTypes = new HashSet<> ();
        for (Service operationType : operationTypes) {
            gmoOperationTypes.add (toEntity (operationType, lazy));
        }
        return gmoOperationTypes;
    }

    public static Set<Service> toDtos(Set<GmoService> gmoOperationTypes, boolean lazy) {
        if (null == gmoOperationTypes) {
            return null;
        }
        Set<Service> operationTypes = new HashSet<> ( );
        for (GmoService gmoOperationType : gmoOperationTypes) {
            operationTypes.add (toDto (gmoOperationType, lazy));
        }
        return operationTypes;
    }
}
