package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Product;
import com.bagile.gmo.dto.SupplierProduct;
import com.bagile.gmo.entities.TmsSupplierProduct;

import java.util.*;

public class SupplierProductMapper {
    public SupplierProductMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsSupplierProductId");


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

    public static TmsSupplierProduct toEntity(SupplierProduct supplierProduct, boolean lazy) {
        if (null == supplierProduct) {
            return null;
        }
        TmsSupplierProduct tmsSupplierProduct = new TmsSupplierProduct();
        tmsSupplierProduct.setTmsSupplierProductId(supplierProduct.getId());
        tmsSupplierProduct.setTmsSupplierProductPriceHT (supplierProduct.getPriceHT ());
        tmsSupplierProduct.setTmsSupplierProductPriceTTC (supplierProduct.getPriceTTC ());

        tmsSupplierProduct.setCreatedBy(supplierProduct.getCreatedBy());
        tmsSupplierProduct.setUpdatedBy(supplierProduct.getUpdatedBy());
        tmsSupplierProduct.setCreationDate(supplierProduct.getCreationDate());
        tmsSupplierProduct.setUpdateDate(supplierProduct.getUpdateDate());

          if(!lazy){
              tmsSupplierProduct.setRcpSupplier(SupplierMapper.toEntity(supplierProduct.getSupplier(),true));
              tmsSupplierProduct.setPdtProduct(ProductMapper.toEntity(supplierProduct.getProduct(),true));
              tmsSupplierProduct.setPrmVat(VatMapper.toEntity(supplierProduct.getVat(),true));
              tmsSupplierProduct.setPdtUom(UomMapper.toEntity(supplierProduct.getUom(),true));

              tmsSupplierProduct.setOwnOwner(OwnerMapper.toEntity(supplierProduct.getOwner(),true));
          }

        return tmsSupplierProduct;

    }

    public static SupplierProduct toDto(TmsSupplierProduct tmsSupplierProduct, boolean lazy) {
        if (null == tmsSupplierProduct) {
            return null;
        }
        SupplierProduct supplierProduct = new SupplierProduct();
        supplierProduct.setId(tmsSupplierProduct.getTmsSupplierProductId());
        supplierProduct.setPriceHT(tmsSupplierProduct.getTmsSupplierProductPriceHT());
        supplierProduct.setPriceTTC (tmsSupplierProduct.getTmsSupplierProductPriceTTC ());

 if(!lazy){
     supplierProduct.setSupplier(SupplierMapper.toDto(tmsSupplierProduct.getRcpSupplier(),true));
     supplierProduct.setProduct(ProductMapper.toDto(tmsSupplierProduct.getPdtProduct(),true));
     supplierProduct.setUom(UomMapper.toDto(tmsSupplierProduct.getPdtUom(),true));
     supplierProduct.setVat(VatMapper.toDto(tmsSupplierProduct.getPrmVat(),true));

     supplierProduct.setOwner(OwnerMapper.toDto(tmsSupplierProduct.getOwnOwner(),true));
 }
        return supplierProduct;

    }


    public static List<SupplierProduct> toDtos(Iterable<? extends TmsSupplierProduct> tmsSupplierProducts, boolean lazy) {
        if (null == tmsSupplierProducts) {
            return null;
        }
        List<SupplierProduct> vehicules = new ArrayList<>();

        for (TmsSupplierProduct tmsSupplierProduct : tmsSupplierProducts) {
            vehicules.add(toDto(tmsSupplierProduct, lazy));
        }
        return vehicules;
    }

    public static Set<TmsSupplierProduct> toEntities(Iterable<? extends SupplierProduct> supplierProducts, boolean lazy) {
        if (null == supplierProducts) {
            return null;
        }
        Set<TmsSupplierProduct> tmsSupplierProducts = new HashSet<>();
        for (SupplierProduct supplierProduct : supplierProducts) {
            tmsSupplierProducts.add(toEntity(supplierProduct, lazy));
        }
        return tmsSupplierProducts;
    }


}
