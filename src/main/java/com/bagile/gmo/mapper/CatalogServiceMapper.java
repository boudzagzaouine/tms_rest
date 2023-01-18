package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.CatalogService;
import com.bagile.gmo.entities.TmsCatalogService;

import java.util.*;

public class CatalogServiceMapper {

    public CatalogServiceMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsCatalogTransportId");
        map.put ("product", "pdtProduct");

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

    public static TmsCatalogService toEntity(CatalogService catalogService, boolean lazy) {
        if (null == catalogService) {
            return null;
        }

        TmsCatalogService tmsCatalogService = new TmsCatalogService( );
        tmsCatalogService.setTmsCatalogServiceId (catalogService.getId ());

        tmsCatalogService.setTmsCatalogServicePurchaseAmountHt (catalogService.getPurchaseAmountHt ());
        tmsCatalogService.setTmsCatalogServicePurchaseAmountTtc (catalogService.getPurchaseAmountTtc ());
        tmsCatalogService.setTmsCatalogServicePurchaseAmountTva (catalogService.getPurchaseAmountTva ());


        tmsCatalogService.setTmsCatalogServiceSaleAmountHt (catalogService.getSaleAmountHt ());
        tmsCatalogService.setTmsCatalogServiceSaleAmountTtc (catalogService.getSaleAmountTtc ());
        tmsCatalogService.setTmsCatalogServiceSaleAmountTva (catalogService.getSaleAmountTva ());

        tmsCatalogService.setCreatedBy (catalogService.getCreatedBy ( ));
        tmsCatalogService.setUpdatedBy (catalogService.getUpdatedBy ( ));

        if (!lazy) {
            tmsCatalogService.setPdtProduct (ProductMapper.toEntity (catalogService.getProduct( ), true));

            tmsCatalogService.setPrmPurchaseVat (VatMapper.toEntity (catalogService.getPurchaseVat( ), true));
            tmsCatalogService.setPrmSaleVat (VatMapper.toEntity (catalogService.getSaleVat ( ), true));

            tmsCatalogService.setOwnOwner (OwnerMapper.toEntity (catalogService.getOwner(), true));

        }

        return tmsCatalogService;

    }

    public static CatalogService toDto(TmsCatalogService tmsCatalogService, boolean lazy) {
        if (null == tmsCatalogService) {
            return null;
        }
        CatalogService catalogService = new CatalogService ( );
        catalogService.setId (tmsCatalogService.getTmsCatalogServiceId ());

        catalogService.setPurchaseAmountHt (tmsCatalogService.getTmsCatalogServicePurchaseAmountHt ());
        catalogService.setPurchaseAmountTtc (tmsCatalogService.getTmsCatalogServicePurchaseAmountTtc ());
        catalogService.setPurchaseAmountTva(tmsCatalogService.getTmsCatalogServicePurchaseAmountTva ());

        catalogService.setSaleAmountHt (tmsCatalogService.getTmsCatalogServiceSaleAmountHt ());
        catalogService.setSaleAmountTtc (tmsCatalogService.getTmsCatalogServiceSaleAmountTtc ());
        catalogService.setSaleAmountTva (tmsCatalogService.getTmsCatalogServiceSaleAmountTva ());



        catalogService.setCreatedBy (tmsCatalogService.getCreatedBy ());
        catalogService.setUpdatedBy (tmsCatalogService.getUpdatedBy ());
        catalogService.setCreationDate (tmsCatalogService.getCreationDate ());
        catalogService.setUpdateDate (tmsCatalogService.getUpdateDate ());

        if (!lazy) {
            catalogService.setProduct(ProductMapper.toDto(tmsCatalogService.getPdtProduct(), true));

            catalogService.setPurchaseVat(VatMapper.toDto(tmsCatalogService.getPrmPurchaseVat(), true));
            catalogService.setSaleVat (VatMapper.toDto(tmsCatalogService.getPrmSaleVat(), true));
            catalogService.setOwner (OwnerMapper.toDto(tmsCatalogService.getOwnOwner(), true));

        }
        return catalogService;

    }


    public static List<CatalogService> toDtos(Iterable<? extends TmsCatalogService> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        List<CatalogService> catalogServices = new ArrayList<> ( );

        for (TmsCatalogService tmsCatalogService : tmsTransports) {
            catalogServices.add (toDto (tmsCatalogService, lazy));
        }
        return catalogServices;
    }

    public static Set<TmsCatalogService> toEntities(Iterable<? extends CatalogService> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsCatalogService> tmsTransports = new HashSet<> ( );
        for (CatalogService catalogService : badges) {
            tmsTransports.add (toEntity (catalogService, lazy));
        }
        return tmsTransports;
    }

   /* public static Set<CatalogService> toDtos(Set<TmsCatalogTransportCategoryVehicle> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        Set<CatalogService> badges = new HashSet<> ( );
        for (TmsCatalogTransportCategoryVehicle tmsCatalogService : tmsTransports) {
            badges.add (toDto (tmsCatalogService, lazy));
        }
        return badges;
    }*/
}
