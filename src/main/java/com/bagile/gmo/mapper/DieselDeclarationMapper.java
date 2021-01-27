package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.DieselDeclaration;
import com.bagile.gmo.entities.GmoDieselDeclaration;

import java.util.*;

public class DieselDeclarationMapper {
    public DieselDeclarationMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoDieselDeclarationId");
        map.put ("code", "gmoDieselDeclarationCode");
        map.put ("vehicle", "gmoVehicle");
        map.put ("amount", "gmoDieselDeclarationAmount");
        map.put ("mileage", "gmoDieselDeclarationMileage");
        map.put ("dieselDeclarationDate", "gmoDieselDeclarationDate");
  

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

    public static GmoDieselDeclaration toEntity(DieselDeclaration dieselDeclaration, boolean lazy) {
        if (null == dieselDeclaration) {
            return null;
        }

        GmoDieselDeclaration gmoDieselDeclaration = new GmoDieselDeclaration ( );
        gmoDieselDeclaration.setGmoDieselDeclarationId (dieselDeclaration.getId ( ));
        gmoDieselDeclaration.setGmoDieselDeclarationCode (dieselDeclaration.getCode ( ) != null ? dieselDeclaration.getCode ( ).toUpperCase ( ) : null);
        gmoDieselDeclaration.setGmoDieselDeclarationAmount(dieselDeclaration.getAmount ( ));
        gmoDieselDeclaration.setGmoDieselDeclarationDate(dieselDeclaration.getDieselDeclarationDate ( ));
        gmoDieselDeclaration.setGmoDieselDeclarationMileage(dieselDeclaration.getMileage ( ));
        gmoDieselDeclaration.setGmoTypeDeclaration(dieselDeclaration.getTypeDeclaration ( ));
        gmoDieselDeclaration.setGmoBon(dieselDeclaration.getBon ( ));

        gmoDieselDeclaration.setCreatedBy (dieselDeclaration.getCreatedBy ( ));
        gmoDieselDeclaration.setUpdatedBy (dieselDeclaration.getUpdatedBy ( ));

        if (!lazy) {
            gmoDieselDeclaration.setGmoVehicle (VehicleMapper.toEntity (dieselDeclaration.getVehicle ( ), true));
            gmoDieselDeclaration.setOwnOwner (OwnerMapper.toEntity (dieselDeclaration.getOwner ( ), true));
            gmoDieselDeclaration.setGmoDriver (DriverMapper.toEntity (dieselDeclaration.getDriver ( ), true));
            gmoDieselDeclaration.setGmoSubscriptionCard (SubscriptionCardMapper.toEntity (dieselDeclaration.getSubscriptionCard ( ), true));
            gmoDieselDeclaration.setRcpPurshaseOrder (PurshaseOrderMapper.toEntity (dieselDeclaration.getPurshaseOrder ( ), false));

        }

        return gmoDieselDeclaration;

    }

    public static DieselDeclaration toDto(GmoDieselDeclaration gmoDieselDeclaration, boolean lazy) {
        if (null == gmoDieselDeclaration) {
            return null;
        }
        DieselDeclaration dieselDeclaration = new DieselDeclaration ( );
        dieselDeclaration.setId (gmoDieselDeclaration.getGmoDieselDeclarationId ());
        dieselDeclaration.setCode (gmoDieselDeclaration.getGmoDieselDeclarationCode ());
        dieselDeclaration.setAmount (gmoDieselDeclaration.getGmoDieselDeclarationAmount());
        dieselDeclaration.setDieselDeclarationDate (gmoDieselDeclaration.getGmoDieselDeclarationDate());
        dieselDeclaration.setMileage (gmoDieselDeclaration.getGmoDieselDeclarationMileage());
        dieselDeclaration.setTypeDeclaration (gmoDieselDeclaration.getGmoTypeDeclaration());
        dieselDeclaration.setBon (gmoDieselDeclaration.getGmoBon());

        dieselDeclaration.setCreatedBy (gmoDieselDeclaration.getCreatedBy ());
        dieselDeclaration.setUpdatedBy (gmoDieselDeclaration.getUpdatedBy ());
        dieselDeclaration.setCreationDate (gmoDieselDeclaration.getCreationDate ());
        dieselDeclaration.setUpdateDate (gmoDieselDeclaration.getUpdateDate ());

        if (!lazy) {
            dieselDeclaration.setVehicle (VehicleMapper.toDto (gmoDieselDeclaration.getGmoVehicle(), true));
            dieselDeclaration.setOwner (OwnerMapper.toDto (gmoDieselDeclaration.getOwnOwner(), true));
            dieselDeclaration.setDriver(DriverMapper.toDto (gmoDieselDeclaration.getGmoDriver(), true));
            dieselDeclaration.setSubscriptionCard (SubscriptionCardMapper.toDto (gmoDieselDeclaration.getGmoSubscriptionCard(), true));
            dieselDeclaration.setPurshaseOrder (PurshaseOrderMapper.toDto (gmoDieselDeclaration.getRcpPurshaseOrder(), false));


        }
        return dieselDeclaration;

    }


    public static List<DieselDeclaration> toDtos(Iterable<? extends GmoDieselDeclaration> gmoDieselDeclarations, boolean lazy) {
        if (null == gmoDieselDeclarations) {
            return null;
        }
        List<DieselDeclaration> vehicules = new ArrayList<> ( );

        for (GmoDieselDeclaration gmoDieselDeclaration : gmoDieselDeclarations) {
            vehicules.add (toDto (gmoDieselDeclaration, lazy));
        }
        return vehicules;
    }

    public static Set<GmoDieselDeclaration> toEntities(Set<DieselDeclaration> dieselDeclarations, boolean lazy) {
        if (null == dieselDeclarations) {
            return null;
        }
        Set<GmoDieselDeclaration> gmoDieselDeclarations = new HashSet<> ( );
        for (DieselDeclaration dieselDeclaration : dieselDeclarations) {
            gmoDieselDeclarations.add (toEntity (dieselDeclaration, lazy));
        }
        return gmoDieselDeclarations;
    }

    public static Set<DieselDeclaration> toDtos(Set<GmoDieselDeclaration> gmoDieselDeclarations, boolean lazy) {
        if (null == gmoDieselDeclarations) {
            return null;
        }
        Set<DieselDeclaration> dieselDeclarations = new HashSet<> ( );
        for (GmoDieselDeclaration gmoDieselDeclaration : gmoDieselDeclarations) {
            dieselDeclarations.add (toDto (gmoDieselDeclaration, lazy));
        }
        return dieselDeclarations;
    }
}
