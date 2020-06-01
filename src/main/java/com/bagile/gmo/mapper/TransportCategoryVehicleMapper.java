package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportCategoryVehicle;
import com.bagile.gmo.entities.GmoTransportCategoryVehicle;

import java.util.*;

public class TransportCategoryVehicleMapper {

    public TransportCategoryVehicleMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoCatalogTransportCategorieVehicleId");
        map.put ("vehicleCategory", "gmoVehicleCategory");
        map.put ("transport", "trpTransport");
        map.put ("quantity", "gmoTransportCategorieVehicleQuantity");



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

    public static GmoTransportCategoryVehicle toEntity(TransportCategoryVehicle transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        GmoTransportCategoryVehicle trpTransport = new GmoTransportCategoryVehicle ( );
        trpTransport.setGmoCatalogTransportCategorieVehicleId (transport.getId ());
        trpTransport.setGmoTransportCategorieVehicleQuantity (transport.getQuantity ());


        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setGmoVehicleCategory (VehicleCategoryMapper.toEntity (transport.getVehicleCategory ( ), false));
            trpTransport.setTrpTransport (TransportMapper.toEntity (transport.getTransport ( ), false));

        }

        return trpTransport;

    }

    public static TransportCategoryVehicle toDto(GmoTransportCategoryVehicle trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        TransportCategoryVehicle transport = new TransportCategoryVehicle ( );
        transport.setId ((int) trpTransport.getGmoCatalogTransportCategorieVehicleId ());
        transport.setQuantity (trpTransport.getGmoTransportCategorieVehicleQuantity ());


        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setVehicleCategory (VehicleCategoryMapper.toDto(trpTransport.getGmoVehicleCategory(), false));
            transport.setTransport (TransportMapper.toDto(trpTransport.getTrpTransport(), false));

        }
        return transport;

    }


    public static List<TransportCategoryVehicle> toDtos(Iterable<? extends GmoTransportCategoryVehicle> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        List<TransportCategoryVehicle> transports = new ArrayList<> ( );

        for (GmoTransportCategoryVehicle trpTransport : gmoTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<GmoTransportCategoryVehicle> toEntities(Iterable<? extends TransportCategoryVehicle> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<GmoTransportCategoryVehicle> gmoTransports = new HashSet<> ( );
        for (TransportCategoryVehicle transport : badges) {
            gmoTransports.add (toEntity (transport, lazy));
        }
        return gmoTransports;
    }

   /* public static Set<TransportCategoryVehicle> toDtos(Set<GmoTransportCategoryVehicle> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        Set<TransportCategoryVehicle> badges = new HashSet<> ( );
        for (GmoTransportCategoryVehicle trpTransport : gmoTransports) {
            badges.add (toDto (trpTransport, lazy));
        }
        return badges;
    }*/
}
