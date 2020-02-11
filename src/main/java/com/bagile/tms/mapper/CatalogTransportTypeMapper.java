package com.bagile.tms.mapper;

import com.bagile.tms.dto.CatalogTransportType;
import com.bagile.tms.entities.TmsCatalogTransportType;

import java.util.*;

public class CatalogTransportTypeMapper {

    public CatalogTransportTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsCatalogTransportId");
        map.put ("transport", "trpTransport");
        map.put ("vehicleCategory", "tmsVehicleCategory");
        map.put ("zoneSource", "tmsZoneSource");
        map.put ("zoneDestination", "tmsZoneDestination");
        map.put ("amountHt", "tmsCatalogTransportAmountHt");
        map.put ("amountTtc", "tmsCatalogTransportAmountTtc");
        map.put ("amountTva", "tmsCatalogTransportAmountTva");
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

    public static TmsCatalogTransportType toEntity(CatalogTransportType transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        TmsCatalogTransportType trpTransport = new TmsCatalogTransportType( );
        trpTransport.setTmsCatalogTransportCategoryVehicleId (transport.getId ());

        trpTransport.setTmsCatalogTransportCategoryVehicleAmountHt (transport.getAmountHt ());
        trpTransport.setTmsCatalogTransportCategoryVehicleAmountTtc (transport.getAmountTtc ());
        trpTransport.setTmsCatalogTransportCategoryVehicleAmountTva (transport.getAmountTva ());


        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setPrmvat (VatMapper.toEntity (transport.getVat ( ), true));
            trpTransport.setTmsVehicleCategory (VehicleCategoryMapper.toEntity (transport.getVehicleCategory ( ), true));
            trpTransport.setTrpTransport (TransportMapper.toEntity (transport.getTransport ( ), true));
            trpTransport.setTmsZoneSource (ZoneMapper.toEntity (transport.getZoneSource ( ), true));
            trpTransport.setTmsZoneDestination (ZoneMapper.toEntity (transport.getZoneDestination ( ), true));

        }

        return trpTransport;

    }

    public static CatalogTransportType toDto(TmsCatalogTransportType trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        CatalogTransportType transport = new CatalogTransportType ( );
        transport.setId ((int) trpTransport.getTmsCatalogTransportCategoryVehicleId ());
        transport.setAmountHt (trpTransport.getTmsCatalogTransportCategoryVehicleAmountHt ());
        transport.setAmountTtc (trpTransport.getTmsCatalogTransportCategoryVehicleAmountTtc ());
        transport.setAmountTva (trpTransport.getTmsCatalogTransportCategoryVehicleAmountTva ());

        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setVehicleCategory (VehicleCategoryMapper.toDto(trpTransport.getTmsVehicleCategory(), true));
            transport.setTransport (TransportMapper.toDto(trpTransport.getTrpTransport(), true));
            transport.setZoneSource (ZoneMapper.toDto(trpTransport.getTmsZoneSource(), true));
            transport.setZoneDestination (ZoneMapper.toDto(trpTransport.getTmsZoneDestination(), true));
            transport.setVat (VatMapper.toDto(trpTransport.getPrmvat(), true));

        }
        return transport;

    }


    public static List<CatalogTransportType> toDtos(Iterable<? extends TmsCatalogTransportType> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        List<CatalogTransportType> transports = new ArrayList<> ( );

        for (TmsCatalogTransportType trpTransport : tmsTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TmsCatalogTransportType> toEntities(Iterable<? extends CatalogTransportType> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsCatalogTransportType> tmsTransports = new HashSet<> ( );
        for (CatalogTransportType transport : badges) {
            tmsTransports.add (toEntity (transport, lazy));
        }
        return tmsTransports;
    }

   /* public static Set<CatalogTransportType> toDtos(Set<TmsCatalogTransportCategoryVehicle> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        Set<CatalogTransportType> badges = new HashSet<> ( );
        for (TmsCatalogTransportCategoryVehicle trpTransport : tmsTransports) {
            badges.add (toDto (trpTransport, lazy));
        }
        return badges;
    }*/
}
