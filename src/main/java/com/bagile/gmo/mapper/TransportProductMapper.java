package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportProduct;
import com.bagile.gmo.entities.RcpSupplier;
import com.bagile.gmo.entities.TmsTransportProduct;
import com.bagile.gmo.entities.TrpTransport;

import java.util.*;

public class TransportProductMapper {
    public TransportProductMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTransportProductId");


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

    public static TmsTransportProduct toEntity(TransportProduct transportProduct, boolean lazy) {
        if (null == transportProduct) {
            return null;
        }
        TmsTransportProduct tmsTransportProduct = new TmsTransportProduct();
        tmsTransportProduct.setTmsTransportProductId(transportProduct.getId());
        tmsTransportProduct.setTmsTransportProductPriceHT (transportProduct.getPriceHT ());
        tmsTransportProduct.setTmsTransportProductPriceTTC (transportProduct.getPriceTTC ());

        tmsTransportProduct.setCreatedBy(transportProduct.getCreatedBy());
        tmsTransportProduct.setUpdatedBy(transportProduct.getUpdatedBy());
        tmsTransportProduct.setCreationDate(transportProduct.getCreationDate());
        tmsTransportProduct.setUpdateDate(transportProduct.getUpdateDate());

          if(!lazy){
              tmsTransportProduct.setTrpTransport(TransportMapper.toEntity(transportProduct.getTransport(),true));
              tmsTransportProduct.setPdtProduct(ProductMapper.toEntity(transportProduct.getProduct(),true));
              tmsTransportProduct.setPrmVat(VatMapper.toEntity(transportProduct.getVat(),true));

              tmsTransportProduct.setOwnOwner(OwnerMapper.toEntity(transportProduct.getOwner(),true));
          }

        return tmsTransportProduct;

    }




    public static TransportProduct toDto(TmsTransportProduct tmsTransportProduct, boolean lazy) {
        if (null == tmsTransportProduct) {
            return null;
        }
        TransportProduct transportProduct = new TransportProduct();
        transportProduct.setId(tmsTransportProduct.getTmsTransportProductId());
        transportProduct.setPriceHT(tmsTransportProduct.getTmsTransportProductPriceHT());
        transportProduct.setPriceTTC (tmsTransportProduct.getTmsTransportProductPriceTTC ());

 if(!lazy){
     transportProduct.setTransport(TransportMapper.toDto(tmsTransportProduct.getTrpTransport(),true));
     transportProduct.setProduct(ProductMapper.toDto(tmsTransportProduct.getPdtProduct(),true));
     transportProduct.setVat(VatMapper.toDto(tmsTransportProduct.getPrmVat(),true));

     transportProduct.setOwner(OwnerMapper.toDto(tmsTransportProduct.getOwnOwner(),true));
 }
        return transportProduct;

    }


    public static List<TransportProduct> toDtos(Iterable<? extends TmsTransportProduct> tmsTransportProducts, boolean lazy) {
        if (null == tmsTransportProducts) {
            return null;
        }
        List<TransportProduct> vehicules = new ArrayList<>();

        for (TmsTransportProduct tmsTransportProduct : tmsTransportProducts) {
            vehicules.add(toDto(tmsTransportProduct, lazy));
        }
        return vehicules;
    }

    public static Set<TmsTransportProduct> toEntities(Iterable<? extends TransportProduct> transportProducts, boolean lazy) {
        if (null == transportProducts) {
            return null;
        }
        Set<TmsTransportProduct> tmsTransportProducts = new HashSet<>();
        for (TransportProduct transportProduct : transportProducts) {
            tmsTransportProducts.add(toEntity(transportProduct, lazy));
        }
        return tmsTransportProducts;
    }


}
