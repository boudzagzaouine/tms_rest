package com.sinno.ems.mapper;

import com.sinno.ems.dto.AssetSupplier;
import com.sinno.ems.entities.RcpAssetSupplier;

import java.util.*;

/**
 * Created by Enissay on 16/12/2016.
 */
public class AssetSupplierMapper {

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "rcpAssetId");
        map.put("code", "rcpAssetCode");
        map.put("amount", "rcpAssetAmount");
        map.put("beginDate", "rcpBeginDate");
        map.put("expirationDate", "rcpExpirationDate");
        map.put("creationDate", "rcpCreationDate");
        map.put("updateDate", "rcpUpdateDate");
        map.put("used", "rcpUsed");
        map.put("purshaseOrder", "rcpPurshaseOrder");
        map.put("currency","prmCurrency");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static RcpAssetSupplier toEntity(AssetSupplier assetSupplier, boolean lazy) {
        if (null == assetSupplier) {
            return null;
        }
        RcpAssetSupplier rcpAssetSupplier = new RcpAssetSupplier();
        rcpAssetSupplier.setRcpAssetId(assetSupplier.getId());
        rcpAssetSupplier.setRcpAssetCode(assetSupplier.getCode());
        rcpAssetSupplier.setRcpAssetAmount(assetSupplier.getAmount());
        rcpAssetSupplier.setRcpBeginDate(assetSupplier.getBeginDate());
        rcpAssetSupplier.setRcpExpirationDate(assetSupplier.getExpirationDate());
        rcpAssetSupplier.setRcpCreationDate(assetSupplier.getCreationDate());
        rcpAssetSupplier.setRcpUpdateDate(assetSupplier.getUpdateDate());
        rcpAssetSupplier.setRcpUsed(assetSupplier.getUsed());
        if (!lazy) {
            rcpAssetSupplier.setPrmCurrency(CurrencyMapper.toEntity(assetSupplier.getCurrency(), true));
            rcpAssetSupplier.setRcpPurshaseOrder(PurshaseOrderMapper.toEntity(assetSupplier.getPurshaseOrder(), true));
        }
        return rcpAssetSupplier;
    }

    public static AssetSupplier toDto(RcpAssetSupplier rcpAssetSupplier, boolean lazy) {
        if (null == rcpAssetSupplier) {
            return null;
        }
        AssetSupplier assetSupplier = new AssetSupplier();
        assetSupplier.setId(rcpAssetSupplier.getRcpAssetId());
        assetSupplier.setCode(rcpAssetSupplier.getRcpAssetCode());
        assetSupplier.setAmount(rcpAssetSupplier.getRcpAssetAmount());
        assetSupplier.setBeginDate(rcpAssetSupplier.getRcpBeginDate());
        assetSupplier.setExpirationDate(rcpAssetSupplier.getRcpExpirationDate());
        assetSupplier.setCreationDate(rcpAssetSupplier.getRcpCreationDate());
        assetSupplier.setUpdateDate(rcpAssetSupplier.getRcpUpdateDate());
        assetSupplier.setUsed(rcpAssetSupplier.getRcpUsed());
        if (!lazy) {
            assetSupplier.setCurrency(CurrencyMapper.toDto(rcpAssetSupplier.getPrmCurrency(), true));
            assetSupplier.setPurshaseOrder(PurshaseOrderMapper.toDto(rcpAssetSupplier.getRcpPurshaseOrder(), true));
        }
        return assetSupplier;
    }

    public static List<AssetSupplier> toDtos(List<RcpAssetSupplier> rcpAssetSupplier, boolean lazy) {
        if (null == rcpAssetSupplier) {
            return null;
        }
        List<AssetSupplier> assetSuppliers = new ArrayList<>();
        for (RcpAssetSupplier rcpAlias : rcpAssetSupplier) {
            assetSuppliers.add(toDto(rcpAlias, lazy));
        }
        return assetSuppliers;
    }

    public static List<AssetSupplier> toDtos(Iterable<RcpAssetSupplier> rcpAsset, boolean lazy) {
        if (null == rcpAsset) {
            return null;
        }
        List<AssetSupplier> assetSuppliers = new ArrayList<>();
        for (RcpAssetSupplier rcpAlias : rcpAsset) {
            assetSuppliers.add(toDto(rcpAlias, lazy));
        }
        return assetSuppliers;
    }

    public static Set<RcpAssetSupplier> toEntities(Set<AssetSupplier> assetSuppliers, boolean lazy) {
        if (null == assetSuppliers) {
            return null;
        }
        Set<RcpAssetSupplier> rcpAssetSupplier = new HashSet<>();
        for (AssetSupplier assetSupplier : assetSuppliers) {
            rcpAssetSupplier.add(toEntity(assetSupplier, lazy));
        }
        return rcpAssetSupplier;
    }

    public static Set<AssetSupplier> toDtos(Set<RcpAssetSupplier> rcpAssetSupplier, boolean lazy) {
        if (null == rcpAssetSupplier) {
            return null;
        }
        Set<AssetSupplier> assetSuppliers = new HashSet<>();
        for (RcpAssetSupplier rcpAlias : rcpAssetSupplier) {
            assetSuppliers.add(toDto(rcpAlias, lazy));
        }
        return assetSuppliers;
    }

}
