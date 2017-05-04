package com.sinno.ems.mapper;

import com.sinno.ems.dto.AssetAccount;
import com.sinno.ems.entities.CmdAssetAccount;

import java.util.*;

/**
 * Created by Enissay on 16/12/2016.
 */
public class AssetAccountMapper {

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "cmdAssetId");
        map.put("code", "cmdAssetCode");
        map.put("amount", "cmdAssetAmount");
        map.put("beginDate", "cmdBeginDate");
        map.put("expirationDate", "cmdExpirationDate");
        map.put("creationDate", "cmdCreationDate");
        map.put("updateDate", "cmdUpdateDate");
        map.put("used", "cmdUsed");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("currency", "prmCurrency");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static CmdAssetAccount toEntity(AssetAccount assetAccount, boolean lazy) {
        if (null == assetAccount) {
            return null;
        }
        CmdAssetAccount cmdAssetAccount = new CmdAssetAccount();
        cmdAssetAccount.setCmdAssetId(assetAccount.getId());
        cmdAssetAccount.setCmdAssetCode(assetAccount.getCode());
        cmdAssetAccount.setCmdAssetAmount(assetAccount.getAmount());
        cmdAssetAccount.setCmdBeginDate(assetAccount.getBeginDate());
        cmdAssetAccount.setCmdExpirationDate(assetAccount.getExpirationDate());
        cmdAssetAccount.setCmdCreationDate(assetAccount.getCreationDate());
        cmdAssetAccount.setCmdUpdateDate(assetAccount.getUpdateDate());
        cmdAssetAccount.setCmdUsed(assetAccount.getUsed());
        if (!lazy) {
            cmdAssetAccount.setPrmCurrency(CurrencyMapper.toEntity(assetAccount.getCurrency(), true));
            cmdAssetAccount.setCmdSaleOrder(SaleOrderMapper.toEntity(assetAccount.getSaleOrder(), true));
        }
        return cmdAssetAccount;
    }

    public static AssetAccount toDto(CmdAssetAccount cmdAssetAccount, boolean lazy) {
        if (null == cmdAssetAccount) {
            return null;
        }
        AssetAccount assetAccount = new AssetAccount();
        assetAccount.setId(cmdAssetAccount.getCmdAssetId());
        assetAccount.setCode(cmdAssetAccount.getCmdAssetCode());
        assetAccount.setAmount(cmdAssetAccount.getCmdAssetAmount());
        assetAccount.setBeginDate(cmdAssetAccount.getCmdBeginDate());
        assetAccount.setExpirationDate(cmdAssetAccount.getCmdExpirationDate());
        assetAccount.setCreationDate(cmdAssetAccount.getCmdCreationDate());
        assetAccount.setUpdateDate(cmdAssetAccount.getCmdUpdateDate());
        assetAccount.setUsed(cmdAssetAccount.getCmdUsed());
        if (!lazy) {
            assetAccount.setCurrency(CurrencyMapper.toDto(cmdAssetAccount.getPrmCurrency(), true));
            assetAccount.setSaleOrder(SaleOrderMapper.toDto(cmdAssetAccount.getCmdSaleOrder(), true));
        }
        return assetAccount;
    }

    public static List<AssetAccount> toDtos(List<CmdAssetAccount> cmdAssetAccount, boolean lazy) {
        if (null == cmdAssetAccount) {
            return null;
        }
        List<AssetAccount> assetAccounts = new ArrayList<>();
        for (CmdAssetAccount cmdAlias : cmdAssetAccount) {
            assetAccounts.add(toDto(cmdAlias, lazy));
        }
        return assetAccounts;
    }

    public static List<AssetAccount> toDtos(Iterable<CmdAssetAccount> cmdAsset, boolean lazy) {
        if (null == cmdAsset) {
            return null;
        }
        List<AssetAccount> assetAccounts = new ArrayList<>();
        for (CmdAssetAccount cmdAlias : cmdAsset) {
            assetAccounts.add(toDto(cmdAlias, lazy));
        }
        return assetAccounts;
    }

    public static Set<CmdAssetAccount> toEntities(Set<AssetAccount> assetAccounts, boolean lazy) {
        if (null == assetAccounts) {
            return null;
        }
        Set<CmdAssetAccount> cmdAssetAccount = new HashSet<>();
        for (AssetAccount assetAccount : assetAccounts) {
            cmdAssetAccount.add(toEntity(assetAccount, lazy));
        }
        return cmdAssetAccount;
    }

    public static Set<AssetAccount> toDtos(Set<CmdAssetAccount> cmdAssetAccount, boolean lazy) {
        if (null == cmdAssetAccount) {
            return null;
        }
        Set<AssetAccount> assetAccounts = new HashSet<>();
        for (CmdAssetAccount cmdAlias : cmdAssetAccount) {
            assetAccounts.add(toDto(cmdAlias, lazy));
        }
        return assetAccounts;
    }

}
