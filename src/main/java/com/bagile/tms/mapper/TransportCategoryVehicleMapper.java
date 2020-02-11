package com.bagile.tms.mapper;

import com.bagile.tms.dto.TransportCategoryVehicle;
import com.bagile.tms.entities.TmsTransportCategoryVehicle;

import java.util.*;

public class TransportCategoryVehicleMapper {

    public TransportCategoryVehicleMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsCatalogTransportCategorieVehicleId");
        map.put ("vehicleCategory", "tmsVehicleCategory");
        map.put ("transport", "trpTransport");
        map.put ("quantity", "tmsTransportCategorieVehicleQuantity");
       


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

    public static TmsTransportCategoryVehicle toEntity(TransportCategoryVehicle transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        TmsTransportCategoryVehicle trpTransport = new TmsTransportCategoryVehicle ( );
        trpTransport.setTmsCatalogTransportCategorieVehicleId (transport.getId ());
        trpTransport.setTmsTransportCategorieVehicleQuantity (transport.getQuantity ());


        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setTmsVehicleCategory (VehicleCategoryMapper.toEntity (transport.getVehicleCategory ( ), false));
            trpTransport.setTrpTransport (TransportMapper.toEntity (transport.getTransport ( ), false));

        }

        return trpTransport;

    }

    public static TransportCategoryVehicle toDto(TmsTransportCategoryVehicle trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        TransportCategoryVehicle transport = new TransportCategoryVehicle ( );
        transport.setId ((int) trpTransport.getTmsCatalogTransportCategorieVehicleId ());
        transport.setQuantity (trpTransport.getTmsTransportCategorieVehicleQuantity ());


        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setVehicleCategory (VehicleCategoryMapper.toDto(trpTransport.getTmsVehicleCategory(), false));
            transport.setTransport (TransportMapper.toDto(trpTransport.getTrpTransport(), false));

        }
        return transport;

    }


    public static List<TransportCategoryVehicle> toDtos(Iterable<? extends TmsTransportCategoryVehicle> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        List<TransportCategoryVehicle> transports = new ArrayList<> ( );

        for (TmsTransportCategoryVehicle trpTransport : tmsTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TmsTransportCategoryVehicle> toEntities(Iterable<? extends TransportCategoryVehicle> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsTransportCategoryVehicle> tmsTransports = new HashSet<> ( );
        for (TransportCategoryVehicle transport : badges) {
            tmsTransports.add (toEntity (transport, lazy));
        }
        return tmsTransports;
    }

   /* public static Set<TransportCategoryVehicle> toDtos(Set<TmsTransportCategoryVehicle> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        Set<TransportCategoryVehicle> badges = new HashSet<> ( );
        for (TmsTransportCategoryVehicle trpTransport : tmsTransports) {
            badges.add (toDto (trpTransport, lazy));
        }
        return badges;
    }*/
}
