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
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPurchasePriceHT (transporPlanService.getPurchasePriceHT ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPurchasePriceTTC (transporPlanService.getPurchasePriceTTC ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPurchasePriceVat(transporPlanService.getPurchasePriceVat ());

        tmsTransporPlanService.setTmsTransporPlanServiceCatalogSalePriceHT (transporPlanService.getSalePriceHT ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogSalePriceTTC (transporPlanService.getSalePriceTTC ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogSalePriceVat (transporPlanService.getSalePriceVat ());

        tmsTransporPlanService.setTmsTransporPlanServiceCatalogPInvoice (transporPlanService.getInvoice ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogQuantity (transporPlanService.getQuantity ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogDateService (transporPlanService.getDateService ());

        tmsTransporPlanService.setTmsTransporPlanServiceCatalogTotalPurchasePriceHT (transporPlanService.getTotalPurchasePriceHT ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogTotalPurchasePriceTTC (transporPlanService.getTotalPurchasePriceTTC ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogTotalPurchasePriceVat(transporPlanService.getTotalPurchasePriceVat());


        tmsTransporPlanService.setTmsTransporPlanServiceCatalogTotalSalePriceHT (transporPlanService.getTotalSalePriceHT ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogTotalSalePriceTTC (transporPlanService.getTotalSalePriceTTC ());
        tmsTransporPlanService.setTmsTransporPlanServiceCatalogTotalSalePriceVat (transporPlanService.getTotalSalePriceVat ());



        tmsTransporPlanService.setCreatedBy(transporPlanService.getCreatedBy());
        tmsTransporPlanService.setUpdatedBy(transporPlanService.getUpdatedBy());
        tmsTransporPlanService.setCreationDate(transporPlanService.getCreationDate());
        tmsTransporPlanService.setUpdateDate(transporPlanService.getUpdateDate());

          if(!lazy){
              tmsTransporPlanService.setTrpTransport(TransportMapper.toEntity(transporPlanService.getTransport(),true));
              tmsTransporPlanService.setPdtProduct(ProductMapper.toEntity(transporPlanService.getProduct(),true));
              tmsTransporPlanService.setPrmPurchaseVat(VatMapper.toEntity(transporPlanService.getPurchaseVat(),true));
              tmsTransporPlanService.setPrmSaleVat(VatMapper.toEntity(transporPlanService.getSaleVat(),true));

              tmsTransporPlanService.setCmdAccount(AccountMapper.toEntity(transporPlanService.getAccount(),true));

              tmsTransporPlanService.setOwnOwner(OwnerMapper.toEntity(transporPlanService.getOwner(),true));

              tmsTransporPlanService.setTmsOrderTransport(OrderTransportMapper.toEntity(transporPlanService.getOrderTransport(),true));

          }

        return tmsTransporPlanService;

    }




    public static TransportPlanServiceCatalog toDto(TmsTransportPlanServiceCatalog tmsTransporPlanService, boolean lazy) {
        if (null == tmsTransporPlanService) {
            return null;
        }
        TransportPlanServiceCatalog transporPlanService = new TransportPlanServiceCatalog();
        transporPlanService.setId(tmsTransporPlanService.getTmsTransporPlanServiceCatalogId());
        transporPlanService.setPurchasePriceHT(tmsTransporPlanService.getTmsTransporPlanServiceCatalogPurchasePriceHT());
        transporPlanService.setPurchasePriceTTC (tmsTransporPlanService.getTmsTransporPlanServiceCatalogPurchasePriceTTC ());
        transporPlanService.setPurchasePriceVat (tmsTransporPlanService.getTmsTransporPlanServiceCatalogPurchasePriceVat ());

        transporPlanService.setSalePriceHT(tmsTransporPlanService.getTmsTransporPlanServiceCatalogSalePriceHT());
        transporPlanService.setSalePriceTTC (tmsTransporPlanService.getTmsTransporPlanServiceCatalogSalePriceTTC ());
        transporPlanService.setSalePriceVat (tmsTransporPlanService.getTmsTransporPlanServiceCatalogSalePriceVat ());
        transporPlanService.setSalePriceVat (tmsTransporPlanService.getTmsTransporPlanServiceCatalogSalePriceVat ());

        transporPlanService.setInvoice (tmsTransporPlanService.getTmsTransporPlanServiceCatalogPInvoice ());
        transporPlanService.setQuantity (tmsTransporPlanService.getTmsTransporPlanServiceCatalogQuantity ());
        transporPlanService.setDateService (tmsTransporPlanService.getTmsTransporPlanServiceCatalogDateService ());

        transporPlanService.setTotalPurchasePriceHT (tmsTransporPlanService.getTmsTransporPlanServiceCatalogTotalPurchasePriceHT ());
        transporPlanService.setTotalPurchasePriceTTC (tmsTransporPlanService.getTmsTransporPlanServiceCatalogTotalPurchasePriceTTC ());
        transporPlanService.setTotalPurchasePriceVat(tmsTransporPlanService.getTmsTransporPlanServiceCatalogTotalPurchasePriceVat());


        transporPlanService.setTotalSalePriceHT (tmsTransporPlanService.getTmsTransporPlanServiceCatalogTotalSalePriceHT ());
        transporPlanService.setTotalSalePriceTTC (tmsTransporPlanService.getTmsTransporPlanServiceCatalogTotalSalePriceTTC ());
        transporPlanService.setTotalSalePriceVat (tmsTransporPlanService.getTmsTransporPlanServiceCatalogTotalSalePriceVat ());

        if(!lazy){
     transporPlanService.setTransport(TransportMapper.toDto(tmsTransporPlanService.getTrpTransport(),true));
     transporPlanService.setProduct(ProductMapper.toDto(tmsTransporPlanService.getPdtProduct(),false));
     transporPlanService.setPurchaseVat(VatMapper.toDto(tmsTransporPlanService.getPrmPurchaseVat(),true));
     transporPlanService.setSaleVat(VatMapper.toDto(tmsTransporPlanService.getPrmSaleVat(),true));

     transporPlanService.setAccount(AccountMapper.toDto(tmsTransporPlanService.getCmdAccount(),true));

     transporPlanService.setOwner(OwnerMapper.toDto(tmsTransporPlanService.getOwnOwner(),true));

     transporPlanService.setOrderTransport(OrderTransportMapper.toDto(tmsTransporPlanService.getTmsOrderTransport(),true));

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
