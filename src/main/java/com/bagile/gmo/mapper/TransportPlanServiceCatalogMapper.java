package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportPlanServiceCatalog;
import com.bagile.gmo.entities.TmsTransportPlanServiceCatalog;

import java.util.*;

public class TransportPlanServiceCatalogMapper {
    public TransportPlanServiceCatalogMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTransporPlanServiceId");


        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsTransportPlanServiceCatalog toEntity(TransportPlanServiceCatalog transporPlanService, boolean lazy) {
        if (null == transporPlanService) {
            return null;
        }
        TmsTransportPlanServiceCatalog tmsTransporPlanService = new TmsTransportPlanServiceCatalog();
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogId(transporPlanService.getId());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPriceHT (transporPlanService.getPriceHT ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPriceTTC (transporPlanService.getPriceTTC ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPInvoice (transporPlanService.getInvoice ());

        tmsTransporPlanService.setCreatedBy(transporPlanService.getCreatedBy());
        tmsTransporPlanService.setUpdatedBy(transporPlanService.getUpdatedBy());
        tmsTransporPlanService.setCreationDate(transporPlanService.getCreationDate());
        tmsTransporPlanService.setUpdateDate(transporPlanService.getUpdateDate());

          if(!lazy){
              tmsTransporPlanService.setTrpTransport(TransportMapper.toEntity(transporPlanService.getTransport(),true));
              tmsTransporPlanService.setPdtProduct(ProductMapper.toEntity(transporPlanService.getProduct(),true));
              tmsTransporPlanService.setPrmVat(VatMapper.toEntity(transporPlanService.getVat(),true));
              tmsTransporPlanService.setAdrAddress(AddressMapper.toEntity(transporPlanService.getAddress(),true));

              tmsTransporPlanService.setOwnOwner(OwnerMapper.toEntity(transporPlanService.getOwner(),true));
          }

        return tmsTransporPlanService;

    }




    public static TransportPlanServiceCatalog toDto(TmsTransportPlanServiceCatalog tmsTransporPlanService, boolean lazy) {
        if (null == tmsTransporPlanService) {
            return null;
        }
        TransportPlanServiceCatalog transporPlanService = new TransportPlanServiceCatalog();
        transporPlanService.setId(tmsTransporPlanService.getTmsTransporPlanServiceCatalogId());
        transporPlanService.setPriceHT(tmsTransporPlanService.getTmsTransporPlanServiceCatalogPriceHT());
        transporPlanService.setPriceTTC (tmsTransporPlanService.getTmsTransporPlanServiceCatalogPriceTTC ());
        transporPlanService.setInvoice (tmsTransporPlanService.getTmsTransporPlanServiceCatalogPInvoice ());

 if(!lazy){
     transporPlanService.setTransport(TransportMapper.toDto(tmsTransporPlanService.getTrpTransport(),true));
     transporPlanService.setProduct(ProductMapper.toDto(tmsTransporPlanService.getPdtProduct(),true));
     transporPlanService.setVat(VatMapper.toDto(tmsTransporPlanService.getPrmVat(),true));
     transporPlanService.setAddress(AddressMapper.toDto(tmsTransporPlanService.getAdrAddress(),true));

     transporPlanService.setOwner(OwnerMapper.toDto(tmsTransporPlanService.getOwnOwner(),true));
 }
        return transporPlanService;

    }


    public static List<TransportPlanServiceCatalog> toDtos(Iterable<? extends TmsTransportPlanServiceCatalog> tmsTransporPlanServices, boolean lazy) {
        if (null == tmsTransporPlanServices) {
            return null;
        }
        List<TransportPlanServiceCatalog> vehicules = new ArrayList<>();

        for (TmsTransportPlanServiceCatalog tmsTransporPlanService : tmsTransporPlanServices) {
            vehicules.add(toDto(tmsTransporPlanService, lazy));
        }
        return vehicules;
    }

    public static Set<TmsTransportPlanServiceCatalog> toEntities(Iterable<? extends TransportPlanServiceCatalog> transporPlanServices, boolean lazy) {
        if (null == transporPlanServices) {
            return null;
        }
        Set<TmsTransportPlanServiceCatalog> tmsTransporPlanServices = new HashSet<>();
        for (TransportPlanServiceCatalog transporPlanService : transporPlanServices) {
            tmsTransporPlanServices.add(toEntity(transporPlanService, lazy));
        }
        return tmsTransporPlanServices;
    }


}
