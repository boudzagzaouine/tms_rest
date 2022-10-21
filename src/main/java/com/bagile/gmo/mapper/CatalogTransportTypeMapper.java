package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CatalogTransportType;
import com.bagile.gmo.entities.GmoCatalogTransportType;

import java.util.*;

public class CatalogTransportTypeMapper {

    public CatalogTransportTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoCatalogTransportId");
        map.put ("transport", "trpTransport");
        map.put ("vehicleCategory", "gmoVehicleCategory");
        map.put ("villeSource", "gmoVilleSource");
        map.put ("villeDestination", "gmoVilleDestination");
        map.put ("amountHt", "gmoCatalogTransportAmountHt");
        map.put ("amountTtc", "gmoCatalogTransportAmountTtc");
        map.put ("amountTva", "gmoCatalogTransportAmountTva");
        map.put ("vat", "prmvat");



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

    public static GmoCatalogTransportType toEntity(CatalogTransportType transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        GmoCatalogTransportType trpTransport = new GmoCatalogTransportType( );
        trpTransport.setGmoCatalogTransportCategoryVehicleId (transport.getId ());

        trpTransport.setGmoCatalogTransportCategoryVehicleAmountHt (transport.getAmountHt ());
        trpTransport.setGmoCatalogTransportCategoryVehicleAmountTtc (transport.getAmountTtc ());
        trpTransport.setGmoCatalogTransportCategoryVehicleAmountTva (transport.getAmountTva ());


        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setPrmvat (VatMapper.toEntity (transport.getVat ( ), true));
            trpTransport.setGmoVehicleCategory (VehicleCategoryMapper.toEntity (transport.getVehicleCategory ( ), true));
            trpTransport.setTrpTransport (TransportMapper.toEntity (transport.getTransport ( ), true));
            trpTransport.setGmoVilleSource (VilleMapper.toEntity (transport.getVilleSource ( ), true));
            trpTransport.setGmoVilleDestination (VilleMapper.toEntity (transport.getVilleDestination ( ), true));
            trpTransport.setOwnOwner (OwnerMapper.toEntity (transport.getOwner(), true));

        }

        return trpTransport;

    }

    public static CatalogTransportType toDto(GmoCatalogTransportType trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        CatalogTransportType transport = new CatalogTransportType ( );
        transport.setId (trpTransport.getGmoCatalogTransportCategoryVehicleId ());
        transport.setAmountHt (trpTransport.getGmoCatalogTransportCategoryVehicleAmountHt ());
        transport.setAmountTtc (trpTransport.getGmoCatalogTransportCategoryVehicleAmountTtc ());
        transport.setAmountTva (trpTransport.getGmoCatalogTransportCategoryVehicleAmountTva ());

        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setVehicleCategory (VehicleCategoryMapper.toDto(trpTransport.getGmoVehicleCategory(), true));
            transport.setTransport (TransportMapper.toDto(trpTransport.getTrpTransport(), true));
            transport.setVilleSource (VilleMapper.toDto(trpTransport.getGmoVilleSource(), true));
            transport.setVilleDestination (VilleMapper.toDto(trpTransport.getGmoVilleDestination(), true));
            transport.setVat (VatMapper.toDto(trpTransport.getPrmvat(), true));
            transport.setOwner (OwnerMapper.toDto(trpTransport.getOwnOwner(), true));

        }
        return transport;

    }


    public static List<CatalogTransportType> toDtos(Iterable<? extends GmoCatalogTransportType> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        List<CatalogTransportType> transports = new ArrayList<> ( );

        for (GmoCatalogTransportType trpTransport : gmoTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<GmoCatalogTransportType> toEntities(Iterable<? extends CatalogTransportType> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<GmoCatalogTransportType> gmoTransports = new HashSet<> ( );
        for (CatalogTransportType transport : badges) {
            gmoTransports.add (toEntity (transport, lazy));
        }
        return gmoTransports;
    }

   /* public static Set<CatalogTransportType> toDtos(Set<GmoCatalogTransportCategoryVehicle> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        Set<CatalogTransportType> badges = new HashSet<> ( );
        for (GmoCatalogTransportCategoryVehicle trpTransport : gmoTransports) {
            badges.add (toDto (trpTransport, lazy));
        }
        return badges;
    }*/
}
