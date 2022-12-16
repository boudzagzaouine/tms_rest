package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportPlanProductService;
import com.bagile.gmo.entities.TmsTransportPlanProductService;

import java.util.*;

public class TransportPlanProductServiceMapper {
    public TransportPlanProductServiceMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTransportPlanServiceId");


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

    public static TmsTransportPlanProductService toEntity(TransportPlanProductService transportPlanService, boolean lazy) {
        if (null == transportPlanService) {
            return null;
        }
        TmsTransportPlanProductService tmsTransportPlanService = new TmsTransportPlanProductService();
        tmsTransportPlanService.setTmsTransportPlanProductServiceId(transportPlanService.getId());
        tmsTransportPlanService.setTmsTransportPlanProductServicePriceHT (transportPlanService.getPriceHT ());
        tmsTransportPlanService.setTmsTransportPlanProductServicePriceTTC (transportPlanService.getPriceTTC ());

        tmsTransportPlanService.setCreatedBy(transportPlanService.getCreatedBy());
        tmsTransportPlanService.setUpdatedBy(transportPlanService.getUpdatedBy());
        tmsTransportPlanService.setCreationDate(transportPlanService.getCreationDate());
        tmsTransportPlanService.setUpdateDate(transportPlanService.getUpdateDate());

          if(!lazy){
              tmsTransportPlanService.setTrpTransport(TransportMapper.toEntity(transportPlanService.getTransport(),true));
              tmsTransportPlanService.setPdtProduct(ProductMapper.toEntity(transportPlanService.getProduct(),true));
              tmsTransportPlanService.setPrmVat(VatMapper.toEntity(transportPlanService.getVat(),true));
              tmsTransportPlanService.setTmsTransportPlan(TransportPlanMapper.toEntity(transportPlanService.getTransportPlan(),true));

              tmsTransportPlanService.setOwnOwner(OwnerMapper.toEntity(transportPlanService.getOwner(),true));
          }

        return tmsTransportPlanService;

    }




    public static TransportPlanProductService toDto(TmsTransportPlanProductService tmsTransportPlanService, boolean lazy) {
        if (null == tmsTransportPlanService) {
            return null;
        }
        TransportPlanProductService transportPlanService = new TransportPlanProductService();
        transportPlanService.setId(tmsTransportPlanService.getTmsTransportPlanProductServiceId());
        transportPlanService.setPriceHT(tmsTransportPlanService.getTmsTransportPlanProductServicePriceHT());
        transportPlanService.setPriceTTC (tmsTransportPlanService.getTmsTransportPlanProductServicePriceTTC ());

 if(!lazy){
     transportPlanService.setTransport(TransportMapper.toDto(tmsTransportPlanService.getTrpTransport(),true));
     transportPlanService.setProduct(ProductMapper.toDto(tmsTransportPlanService.getPdtProduct(),true));
     transportPlanService.setVat(VatMapper.toDto(tmsTransportPlanService.getPrmVat(),true));
     transportPlanService.setTransportPlan(TransportPlanMapper.toDto(tmsTransportPlanService.getTmsTransportPlan(),true));

     transportPlanService.setOwner(OwnerMapper.toDto(tmsTransportPlanService.getOwnOwner(),true));
 }
        return transportPlanService;

    }


    public static List<TransportPlanProductService> toDtos(Iterable<? extends TmsTransportPlanProductService> tmsTransportPlanServices, boolean lazy) {
        if (null == tmsTransportPlanServices) {
            return null;
        }
        List<TransportPlanProductService> vehicules = new ArrayList<>();

        for (TmsTransportPlanProductService tmsTransportPlanService : tmsTransportPlanServices) {
            vehicules.add(toDto(tmsTransportPlanService, lazy));
        }
        return vehicules;
    }

    public static Set<TmsTransportPlanProductService> toEntities(Iterable<? extends TransportPlanProductService> transportPlanServices, boolean lazy) {
        if (null == transportPlanServices) {
            return null;
        }
        Set<TmsTransportPlanProductService> tmsTransportPlanServices = new HashSet<>();
        for (TransportPlanProductService transportPlanService : transportPlanServices) {
            tmsTransportPlanServices.add(toEntity(transportPlanService, lazy));
        }
        return tmsTransportPlanServices;
    }


}
