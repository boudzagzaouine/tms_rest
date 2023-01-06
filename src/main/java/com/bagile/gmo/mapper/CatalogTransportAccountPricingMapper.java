package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.entities.TmsCatalogTransportAccountPricing;

import java.util.*;

public class CatalogTransportAccountPricingMapper {

    public CatalogTransportAccountPricingMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsCatalogTransportAccountPricingId");
        map.put("company", "cmdCompany");

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

    public static TmsCatalogTransportAccountPricing toEntity(CatalogTransportAccountPricing transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        TmsCatalogTransportAccountPricing trpTransport = new TmsCatalogTransportAccountPricing( );
        trpTransport.setTmsCatalogTransportAccountPricingId(transport.getId ());

        trpTransport.setTmsCatalogTransportAccountPricingPurchaseAmountHt (transport.getPurchaseAmountHt ());
        trpTransport.setTmsCatalogTransportAccountPricingPurchaseAmountTtc (transport.getPurchaseAmountTtc ());
        trpTransport.setTmsCatalogTransportAccountPricingPurchaseAmountTva (transport.getPurchaseAmountTva ());


        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setCmdCompany (CompanyMapper.toEntity (transport.getCompany ( ), false));

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

    public static CatalogTransportAccountPricing toDto(TmsCatalogTransportAccountPricing trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        CatalogTransportAccountPricing transport = new CatalogTransportAccountPricing( );
        transport.setId (trpTransport.getTmsCatalogTransportAccountPricingId());
        transport.setPurchaseAmountHt (trpTransport.getTmsCatalogTransportAccountPricingPurchaseAmountHt ());
        transport.setPurchaseAmountTtc (trpTransport.getTmsCatalogTransportAccountPricingPurchaseAmountTtc ());
        transport.setPurchaseAmountTva (trpTransport.getTmsCatalogTransportAccountPricingPurchaseAmountTva ());

        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setCompany (CompanyMapper.toDto(trpTransport.getCmdCompany(), true));

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


    public static List<CatalogTransportAccountPricing> toDtos(Iterable<? extends TmsCatalogTransportAccountPricing> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        List<CatalogTransportAccountPricing> transports = new ArrayList<> ( );

        for (TmsCatalogTransportAccountPricing trpTransport : gmoTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TmsCatalogTransportAccountPricing> toEntities(Iterable<? extends CatalogTransportAccountPricing> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsCatalogTransportAccountPricing> gmoTransports = new HashSet<> ( );
        for (CatalogTransportAccountPricing transport : badges) {
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
