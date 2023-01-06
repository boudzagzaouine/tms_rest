package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.entities.TmsCatalogTransportPricing;

import java.util.*;

public class CatalogTransportPricingMapper {

    public CatalogTransportPricingMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsCatalogTransportId");
        map.put("code", "tmsAccountPricingCode");
        map.put("transport", "trpTransport");
        map.put("loadingType", "tmsLoadingType");
        map.put("turnType", "tmsTurnType");
        map.put("vehicleCategory", "gmoVehicleCategory");
        map.put("vehicleTray", "tmsVehicleTray");
        map.put("villeSource", "tmsVilleSource");
        map.put("villeDestination", "tmsVilleDestination");



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

    public static TmsCatalogTransportPricing toEntity(CatalogTransportPricing transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        TmsCatalogTransportPricing trpTransport = new TmsCatalogTransportPricing( );
        trpTransport.setTmsCatalogTransportId(transport.getId ());

        trpTransport.setTmsCatalogTransportPricingPurchaseAmountHt (transport.getPurchaseAmountHt ());
        trpTransport.setTmsCatalogTransportPricingPurchaseAmountTtc (transport.getPurchaseAmountTtc ());
        trpTransport.setTmsCatalogTransportPricingPurchaseAmountTva (transport.getPurchaseAmountTva ());


        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setTrpTransport (TransportMapper.toEntity (transport.getTransport ( ), false));
            trpTransport.setGmoVehicleCategory (VehicleCategoryMapper.toEntity (transport.getVehicleCategory ( ), true));
            trpTransport.setTmsVehicleTray (VehicleTrayMapper.toEntity (transport.getVehicleTray ( ), true));
            trpTransport.setTmsTurnType (TurnTypeMapper.toEntity (transport.getTurnType ( ), true));
            trpTransport.setPrmPaysSource (PaysMapper.toEntity (transport.getPaysSource ( ), true));
            trpTransport.setTmsVilleSource (VilleMapper.toEntity (transport.getVilleSource ( ), true));
            trpTransport.setPrmPaysDestination (PaysMapper.toEntity (transport.getPaysDestination ( ), true));
            trpTransport.setTmsVilleDestination (VilleMapper.toEntity (transport.getVilleDestination ( ), true));
            trpTransport.setTmsLoadingType (LoadingTypeMapper.toEntity (transport.getLoadingType ( ), true));
            trpTransport.setPrmPurchaseVat (VatMapper.toEntity (transport.getPurchaseVat ( ), true));
            trpTransport.setOwnOwner (OwnerMapper.toEntity (transport.getOwner(), true));

        }

        return trpTransport;

    }

    public static CatalogTransportPricing toDto(TmsCatalogTransportPricing trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        CatalogTransportPricing transport = new CatalogTransportPricing( );
        transport.setId (trpTransport.getTmsCatalogTransportId());
        transport.setPurchaseAmountHt (trpTransport.getTmsCatalogTransportPricingPurchaseAmountHt ());
        transport.setPurchaseAmountTtc (trpTransport.getTmsCatalogTransportPricingPurchaseAmountTtc ());
        transport.setPurchaseAmountTva (trpTransport.getTmsCatalogTransportPricingPurchaseAmountTva ());

        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setVehicleCategory (VehicleCategoryMapper.toDto(trpTransport.getGmoVehicleCategory(), true));
            transport.setTransport (TransportMapper.toDto(trpTransport.getTrpTransport(), false));
            transport.setVehicleTray (VehicleTrayMapper.toDto(trpTransport.getTmsVehicleTray(), true));
            transport.setTurnType (TurnTypeMapper.toDto(trpTransport.getTmsTurnType(), true));
            transport.setPaysSource (PaysMapper.toDto(trpTransport.getPrmPaysSource(), true));
            transport.setVilleSource (VilleMapper.toDto(trpTransport.getTmsVilleSource(), true));
            transport.setPaysDestination (PaysMapper.toDto(trpTransport.getPrmPaysDestination(), true));
            transport.setVilleDestination (VilleMapper.toDto(trpTransport.getTmsVilleDestination(), true));
            transport.setLoadingType (LoadingTypeMapper.toDto(trpTransport.getTmsLoadingType(), true));
            transport.setPurchaseVat (VatMapper.toDto(trpTransport.getPrmPurchaseVat(), true));
            transport.setOwner (OwnerMapper.toDto(trpTransport.getOwnOwner(), true));

        }
        return transport;

    }


    public static List<CatalogTransportPricing> toDtos(Iterable<? extends TmsCatalogTransportPricing> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        List<CatalogTransportPricing> transports = new ArrayList<> ( );

        for (TmsCatalogTransportPricing trpTransport : gmoTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TmsCatalogTransportPricing> toEntities(Iterable<? extends CatalogTransportPricing> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsCatalogTransportPricing> gmoTransports = new HashSet<> ( );
        for (CatalogTransportPricing transport : badges) {
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
