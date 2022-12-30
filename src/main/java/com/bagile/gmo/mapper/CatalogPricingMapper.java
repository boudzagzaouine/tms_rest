package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CatalogPricing;
import com.bagile.gmo.entities.TmsCatalogPricing;

import java.util.*;

public class CatalogPricingMapper {

    public CatalogPricingMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsCatalogTransportId");
        map.put ("turnType", "tmsTurnType");
        map.put ("catalogPricing", "tmsCatalogPricing");
        map.put ("vehicleCategory", "tmsVehicleCategory");
        map.put ("villeSource", "tmsVilleSource");
        map.put ("villeDestination", "tmsVilleDestination");
        map.put ("interneOrExterne", "tmsCatalogTransportInternOrExterne");
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

    public static TmsCatalogPricing toEntity(CatalogPricing catalogPricing, boolean lazy) {
        if (null == catalogPricing) {
            return null;
        }

        TmsCatalogPricing tmsCatalogPricing = new TmsCatalogPricing( );
        tmsCatalogPricing.setTmsCatalogPricingId (catalogPricing.getId ());

        tmsCatalogPricing.setTmsCatalogPricingPurchaseAmountHt (catalogPricing.getPurchaseAmountHt ());
        tmsCatalogPricing.setTmsCatalogPricingPurchaseAmountTtc (catalogPricing.getPurchaseAmountTtc ());
        tmsCatalogPricing.setTmsCatalogPricingPurchaseAmountTva (catalogPricing.getSaleAmountTva ());


        tmsCatalogPricing.setTmsCatalogPricingSaleAmountHt (catalogPricing.getSaleAmountHt ());
        tmsCatalogPricing.setTmsCatalogPricingPurchaseAmountTtc (catalogPricing.getSaleAmountTtc ());
        tmsCatalogPricing.setTmsCatalogPricingSaleAmountTva (catalogPricing.getSaleAmountTva ());

        tmsCatalogPricing.setCreatedBy (catalogPricing.getCreatedBy ( ));
        tmsCatalogPricing.setUpdatedBy (catalogPricing.getUpdatedBy ( ));

        if (!lazy) {
            tmsCatalogPricing.setGmoVehicleCategory (VehicleCategoryMapper.toEntity (catalogPricing.getVehicleCategory ( ), true));
            tmsCatalogPricing.setTmsVehicleTray (VehicleTrayMapper.toEntity (catalogPricing.getVehicleTray ( ), true));

            tmsCatalogPricing.setTmsTurnType (TurnTypeMapper.toEntity (catalogPricing.getTurnType(), true));
            tmsCatalogPricing.setTmsLoadingType (LoadingTypeMapper.toEntity (catalogPricing.getLoadingType(), true));

            tmsCatalogPricing.setPrmPurchaseVat (VatMapper.toEntity (catalogPricing.getPurcahseVat ( ), true));
            tmsCatalogPricing.setPrmPricingSaleVat (VatMapper.toEntity (catalogPricing.getSaleVat ( ), true));

            tmsCatalogPricing.setPrmPaysSource (PaysMapper.toEntity (catalogPricing.getPaysSource ( ), true));
            tmsCatalogPricing.setTmsVilleSource (VilleMapper.toEntity (catalogPricing.getVilleSource ( ), true));
            tmsCatalogPricing.setPrmPaysDestination (PaysMapper.toEntity (catalogPricing.getPaysDestination ( ), true));
            tmsCatalogPricing.setTmsVilleDestination (VilleMapper.toEntity (catalogPricing.getVilleDestination ( ), true));
            tmsCatalogPricing.setOwnOwner (OwnerMapper.toEntity (catalogPricing.getOwner(), true));

        }

        return tmsCatalogPricing;

    }

    public static CatalogPricing toDto(TmsCatalogPricing tmsCatalogPricing, boolean lazy) {
        if (null == tmsCatalogPricing) {
            return null;
        }
        CatalogPricing catalogPricing = new CatalogPricing ( );
        catalogPricing.setId (tmsCatalogPricing.getTmsCatalogPricingId ());
        catalogPricing.setPurchaseAmountHt (tmsCatalogPricing.getTmsCatalogPricingPurchaseAmountHt ());
        catalogPricing.setPurchaseAmountTtc (tmsCatalogPricing.getTmsCatalogPricingPurchaseAmountTtc ());
        catalogPricing.setPurchaseamountTva (tmsCatalogPricing.getTmsCatalogPricingPurchaseAmountTva ());

        catalogPricing.setSaleAmountHt (tmsCatalogPricing.getTmsCatalogPricingSaleAmountHt ());
        catalogPricing.setSaleAmountTtc (tmsCatalogPricing.getTmsCatalogPricingSaleAmountTtc ());
        catalogPricing.setSaleAmountTva (tmsCatalogPricing.getTmsCatalogPricingSaleAmountTva ());



        catalogPricing.setCreatedBy (tmsCatalogPricing.getCreatedBy ());
        catalogPricing.setUpdatedBy (tmsCatalogPricing.getUpdatedBy ());
        catalogPricing.setCreationDate (tmsCatalogPricing.getCreationDate ());
        catalogPricing.setUpdateDate (tmsCatalogPricing.getUpdateDate ());

        if (!lazy) {
            catalogPricing.setVehicleCategory (VehicleCategoryMapper.toDto(tmsCatalogPricing.getGmoVehicleCategory(), true));
            catalogPricing.setVehicleTray (VehicleTrayMapper.toDto(tmsCatalogPricing.getTmsVehicleTray(), true));
            catalogPricing.setTurnType (TurnTypeMapper.toDto(tmsCatalogPricing.getTmsTurnType(), true));
            catalogPricing.setLoadingType (LoadingTypeMapper.toDto(tmsCatalogPricing.getTmsLoadingType(), true));

            catalogPricing.setPaysSource (PaysMapper.toDto(tmsCatalogPricing.getPrmPaysSource(), true));
            catalogPricing.setVilleSource (VilleMapper.toDto(tmsCatalogPricing.getTmsVilleSource(), true));
            catalogPricing.setPaysDestination (PaysMapper.toDto(tmsCatalogPricing.getPrmPaysDestination(), true));
            catalogPricing.setVilleDestination (VilleMapper.toDto(tmsCatalogPricing.getTmsVilleDestination(), true));
            catalogPricing.setPurcahseVat (VatMapper.toDto(tmsCatalogPricing.getPrmPurchaseVat(), true));
            catalogPricing.setSaleVat (VatMapper.toDto(tmsCatalogPricing.getPrmPricingSaleVat(), true));
            catalogPricing.setOwner (OwnerMapper.toDto(tmsCatalogPricing.getOwnOwner(), true));

        }
        return catalogPricing;

    }


    public static List<CatalogPricing> toDtos(Iterable<? extends TmsCatalogPricing> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        List<CatalogPricing> catalogPricings = new ArrayList<> ( );

        for (TmsCatalogPricing tmsCatalogPricing : tmsTransports) {
            catalogPricings.add (toDto (tmsCatalogPricing, lazy));
        }
        return catalogPricings;
    }

    public static Set<TmsCatalogPricing> toEntities(Iterable<? extends CatalogPricing> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsCatalogPricing> tmsTransports = new HashSet<> ( );
        for (CatalogPricing catalogPricing : badges) {
            tmsTransports.add (toEntity (catalogPricing, lazy));
        }
        return tmsTransports;
    }

   /* public static Set<CatalogPricing> toDtos(Set<TmsCatalogTransportCategoryVehicle> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        Set<CatalogPricing> badges = new HashSet<> ( );
        for (TmsCatalogTransportCategoryVehicle tmsCatalogPricing : tmsTransports) {
            badges.add (toDto (tmsCatalogPricing, lazy));
        }
        return badges;
    }*/
}
